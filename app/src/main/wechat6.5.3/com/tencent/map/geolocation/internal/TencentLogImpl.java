package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import ct.b.a;
import java.io.File;
import java.io.IOException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class TencentLogImpl implements TencentLog {
    private static boolean DEBUG = false;
    private static final String TAG = "TencentLogImpl";
    private final File mBackupDir;
    private Handler mHandler;
    private final Runnable mKiller;
    private boolean mPrepared;
    private HandlerThread mWorker;

    final class LogHandler extends Handler {
        private static final String TXWATCHDOG = "txwatchdog";
        private File mDest;

        private LogHandler(Looper looper) {
            super(looper);
            this.mDest = makeSureDest();
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.mDest == null || !"txwatchdog".equals(this.mDest.getName())) {
                this.mDest = makeSureDest();
            }
            try {
                a.a(message.obj.toString().getBytes("GBK"), this.mDest);
                File access$500 = TencentLogImpl.this.mBackupDir;
                File file = this.mDest;
                if (access$500 != null && file != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (file.length() > 409600) {
                        file.renameTo(new File(access$500, new StringBuilder(TencentLog.PREFIX).append(currentTimeMillis).toString()));
                    }
                    File[] listFiles = access$500.listFiles();
                    if (listFiles != null && listFiles.length > 10) {
                        for (File file2 : listFiles) {
                            if (!"txwatchdog".equals(file2.getName()) && !file2.isDirectory() && file2.getName().startsWith(TencentLog.PREFIX) && currentTimeMillis - file2.lastModified() > -1702967296) {
                                file2.delete();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                this.mDest = null;
            }
        }

        private File makeSureDest() {
            File access$500 = TencentLogImpl.this.mBackupDir;
            if (!access$500.exists()) {
                access$500.mkdirs();
            }
            return new File(access$500, "txwatchdog");
        }
    }

    public TencentLogImpl(Context context, @Nullable File file) {
        this.mBackupDir = file;
        boolean z = file != null && (file.exists() || file.mkdirs());
        this.mPrepared = z;
        if (this.mPrepared) {
            this.mWorker = new HandlerThread("log_worker", 10);
            this.mWorker.start();
            this.mHandler = new LogHandler(this.mWorker.getLooper());
        }
        this.mKiller = new Runnable() {
            public void run() {
                if (TencentLogImpl.this._isPrepared()) {
                    TencentLogImpl.this.mPrepared = false;
                    TencentLogImpl.this.mHandler.removeCallbacksAndMessages(null);
                    TencentLogImpl.this.mWorker.quit();
                }
            }
        };
        if (DEBUG) {
            new StringBuilder("log dir=").append(this.mBackupDir);
            if (!this.mPrepared) {
                new StringBuilder("init failed: mPrepared=").append(this.mPrepared);
            }
        }
    }

    public final void shutdown(long j) {
        if (_isPrepared()) {
            this.mHandler.removeCallbacks(this.mKiller);
            this.mHandler.postDelayed(this.mKiller, j);
        }
    }

    public final boolean tryRestart() {
        if (!_isPrepared()) {
            return false;
        }
        this.mHandler.removeCallbacks(this.mKiller);
        return true;
    }

    private boolean _isPrepared() {
        return this.mPrepared && this.mHandler != null;
    }

    final boolean isPrepared() {
        return this.mPrepared;
    }

    public static void setDebugEnabled(boolean z) {
        DEBUG = z;
    }

    public static boolean isDebugEnabled() {
        return DEBUG;
    }

    public final void println(String str, int i, @NonNull String str2) {
        if (_isPrepared()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
            stringBuilder.append(":").append(str);
            stringBuilder.append(":").append(str2).append("\n");
            this.mHandler.obtainMessage(1, stringBuilder.toString()).sendToTarget();
        }
        if (DEBUG && i != 4) {
        }
    }

    public final String getDirString() {
        if (this.mBackupDir != null) {
            return this.mBackupDir.getName();
        }
        return null;
    }
}
