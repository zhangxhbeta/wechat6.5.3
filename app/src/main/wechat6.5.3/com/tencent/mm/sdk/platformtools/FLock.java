package com.tencent.mm.sdk.platformtools;

import android.support.v7.a.a.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;

public class FLock {
    private File dAr;
    private volatile int nic;

    private static native int nativeFree(int i);

    private static native int nativeInit(String str);

    private static native int nativeLockRead(int i);

    private static native int nativeLockWrite(int i);

    private static native int nativeUnlock(int i);

    public FLock(String str) {
        this(new File(str), true);
    }

    private FLock(File file, boolean z) {
        this.dAr = null;
        this.nic = -1;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } else if (!file.isFile()) {
            throw new IllegalArgumentException("target is not a file.");
        }
        this.dAr = file;
    }

    protected void finalize() {
        super.finalize();
        free();
    }

    private synchronized int aAt() {
        if (!this.dAr.exists()) {
            try {
                this.dAr.createNewFile();
            } catch (IOException e) {
            }
            this.nic = -1;
        }
        if (this.nic == -1) {
            this.nic = nativeInit(this.dAr.getAbsolutePath());
        }
        return this.nic;
    }

    private synchronized void free() {
        if (this.nic != -1) {
            nativeFree(this.nic);
            this.nic = -1;
        }
    }

    public final synchronized void bsO() {
        int aAt;
        int i = 0;
        while (i < 5) {
            try {
                aAt = aAt();
                switch (nativeLockRead(aAt)) {
                    case 4:
                        throw new InterruptedException("lock is interrupted.");
                    case 9:
                        throw new IllegalArgumentException(aAt + " is not a valid fd.");
                    case 11:
                        throw new IllegalStateException("non-block mode indicates it would block, shouldn't be here.");
                    case k.MM /*22*/:
                        throw new IllegalStateException("bad operation.");
                    case 46:
                        throw new IllegalStateException("kernel lock spaces ran out.");
                    default:
                        break;
                }
                if (i >= 5) {
                    throw new IllegalStateException("lockRead failed after 5" + " tries.");
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FLock", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                aAt = i + 1;
                try {
                    Thread.sleep(0);
                    i = aAt;
                } catch (InterruptedException e2) {
                    i = aAt;
                }
            } catch (Throwable e3) {
                v.a("MicroMsg.FLock", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                this.dAr.delete();
                aAt();
            }
        }
        if (i >= 5) {
            throw new IllegalStateException("lockRead failed after 5" + " tries.");
        }
    }

    public final synchronized void bsP() {
        int i = 0;
        while (i < 5) {
            try {
                switch (nativeLockWrite(aAt())) {
                    case 4:
                        throw new InterruptedException("lock is interrupted.");
                    case 9:
                        throw new IllegalArgumentException(this.nic + " is not a valid fd.");
                    case 11:
                        throw new IllegalStateException("non-block mode indicates it would block, shouldn't be here.");
                    case k.MM /*22*/:
                        throw new IllegalStateException("bad operation.");
                    case 46:
                        throw new IllegalStateException("kernel lock spaces ran out.");
                    default:
                        break;
                }
                if (i >= 5) {
                    throw new IllegalStateException("lockWrite failed after 5" + " tries.");
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FLock", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                r0 = i + 1;
                int i2;
                try {
                    Thread.sleep(0);
                    i = i2;
                } catch (InterruptedException e2) {
                    i = i2;
                }
            } catch (Throwable e3) {
                v.a("MicroMsg.FLock", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                this.dAr.delete();
                aAt();
            }
        }
        if (i >= 5) {
            throw new IllegalStateException("lockWrite failed after 5" + " tries.");
        }
    }

    public final synchronized void unlock() {
        if (this.nic != -1) {
            try {
                int nativeUnlock = nativeUnlock(this.nic);
                switch (nativeUnlock) {
                    case 0:
                        free();
                        break;
                    case 9:
                        throw new IllegalArgumentException(this.nic + " is not a valid fd.");
                    case k.MM /*22*/:
                        throw new IllegalStateException("bad operation.");
                    default:
                        throw new IllegalStateException("other err: " + nativeUnlock);
                }
            } catch (Throwable th) {
                free();
            }
        }
    }
}
