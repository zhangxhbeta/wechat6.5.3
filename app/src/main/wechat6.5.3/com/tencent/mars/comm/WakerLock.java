package com.tencent.mars.comm;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.jni.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class WakerLock {
    private static final String TAG = "MicroMsg.WakerLock";
    private static long lastChecktime = 0;
    private static Boolean shouldLock = null;
    private IAutoUnlockCallback autoUnlockCallback;
    private Context context;
    private String mCreatePosStackLine;
    private ac mHandler;
    private Runnable mReleaser;
    private WakeLock wakeLock;

    public interface IAutoUnlockCallback {
        void autoUnlockCallback();
    }

    private String getCallerStack() {
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (!stackTraceElement.getClassName().contains(WakerLock.class.getName())) {
                return stackTraceElement.toString();
            }
        }
        return "<native>";
    }

    public String getCreatePosStackLine() {
        return this.mCreatePosStackLine;
    }

    public WakerLock(Context context, IAutoUnlockCallback iAutoUnlockCallback) {
        this(context);
        this.autoUnlockCallback = iAutoUnlockCallback;
    }

    public WakerLock(Context context) {
        this.mCreatePosStackLine = null;
        this.wakeLock = null;
        this.mHandler = null;
        this.autoUnlockCallback = null;
        this.mReleaser = new Runnable() {
            public void run() {
                if (WakerLock.this.wakeLock.isHeld()) {
                    v.w(WakerLock.TAG, "unlock by fucking handler! [%d,%d] @[%s]", Integer.valueOf(WakerLock.this.hashCode()), Integer.valueOf(WakerLock.this.wakeLock.hashCode()), WakerLock.this.mCreatePosStackLine);
                    WakerLock.this.unLock();
                    if (WakerLock.this.autoUnlockCallback != null) {
                        WakerLock.this.autoUnlockCallback.autoUnlockCallback();
                    }
                }
            }
        };
        this.mCreatePosStackLine = getCallerStack();
        this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "WakerLock:" + hashCode());
        this.wakeLock.setReferenceCounted(false);
        this.mHandler = new ac(context.getMainLooper());
        this.context = context;
        v.i(TAG, "init [%d,%d] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine);
    }

    protected void finalize() {
        v.i(TAG, "finalize unlock [%d,%d] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine);
        unLock();
        super.finalize();
    }

    public void lock(long j) {
        lock(j, getCallerStack());
    }

    public void lock() {
        lock(getCallerStack());
    }

    public void lock(String str) {
        lock(-1, str);
    }

    private static final boolean checkShouldLock() {
        if (be.ay(lastChecktime) > 10000 || shouldLock == null) {
            boolean z = (l.dG(aa.getContext()) || l.dH(aa.getContext())) ? false : true;
            shouldLock = Boolean.valueOf(z);
            v.i(TAG, "checkShouldLock screen:%b chatging:%b res:%b checkTime:%d ", Boolean.valueOf(r3), Boolean.valueOf(r4), shouldLock, Long.valueOf(be.ay(lastChecktime)));
            lastChecktime = be.Ni();
        }
        return shouldLock.booleanValue();
    }

    public void lock(long j, String str) {
        try {
            if (checkShouldLock()) {
                if (this.wakeLock.isHeld()) {
                    unLock();
                }
                a.a(this, str);
                v.i(TAG, "lock [%d,%d] traceMsg:[%s] @[%s] limit time:%d", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), str, getCreatePosStackLine(), Long.valueOf(j));
                this.wakeLock.acquire();
                if (j == -1) {
                    this.mHandler.removeCallbacks(this.mReleaser);
                } else {
                    this.mHandler.postDelayed(this.mReleaser, j);
                }
            }
        } catch (Throwable e) {
            v.a(TAG, e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        }
    }

    public void unLock() {
        if (this.wakeLock.isHeld()) {
            this.mHandler.removeCallbacks(this.mReleaser);
            a.c(this);
            v.i(TAG, "unlock [%d,%d] caller:[%s] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), getCallerStack(), getCreatePosStackLine());
            try {
                this.wakeLock.release();
            } catch (Throwable e) {
                v.a(TAG, e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            }
        }
    }

    public boolean isLocking() {
        try {
            v.i(TAG, "check is held [%d,%d] :%b caller:[%s] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), Boolean.valueOf(this.wakeLock.isHeld()), getCallerStack(), getCreatePosStackLine());
            return this.wakeLock.isHeld();
        } catch (Throwable e) {
            v.a(TAG, e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            return false;
        }
    }

    public int innerWakeLockHashCode() {
        return this.wakeLock.hashCode();
    }
}
