package com.tencent.mmdb.repair;

import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteException;

public class RecoverTask {
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "MMDB.DBBackup";
    private SQLiteDatabase mDB;
    private int mFailedCount;
    private long mNativePtr;
    private int mSuccessCount;
    private Thread mThread;

    private static native void nativeCancel(long j);

    private static native int nativeFailureCount(long j);

    private static native void nativeFinish(long j);

    private static native long nativeInit(String str, byte[] bArr);

    private static native String nativeLastError(long j);

    private static native int nativeRun(long j, long j2, boolean z);

    private static native int nativeSuccessCount(long j);

    public RecoverTask(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
        this.mDB = sQLiteDatabase;
        this.mNativePtr = nativeInit(str, bArr);
        if (this.mNativePtr == 0) {
            throw new SQLiteException("Failed initialize recover context.");
        }
        this.mThread = null;
    }

    public void run(final boolean z) {
        if (this.mNativePtr == 0) {
            throw new IllegalStateException("RecoverTask not initialized.");
        }
        this.mThread = new Thread("DB Recover Thread") {
            public void run() {
                long acquireNativeConnectionHandle = RecoverTask.this.mDB.acquireNativeConnectionHandle(false, false);
                try {
                    RecoverTask.this.onStart();
                    int access$200 = RecoverTask.nativeRun(RecoverTask.this.mNativePtr, acquireNativeConnectionHandle, z);
                    RecoverTask.this.mSuccessCount = RecoverTask.nativeSuccessCount(RecoverTask.this.mNativePtr);
                    RecoverTask.this.mFailedCount = RecoverTask.nativeFailureCount(RecoverTask.this.mNativePtr);
                    RecoverTask.this.mDB.releaseNativeConnection(acquireNativeConnectionHandle);
                    RecoverTask.nativeFinish(RecoverTask.this.mNativePtr);
                    RecoverTask.this.mNativePtr = 0;
                    RecoverTask.this.onFinish(access$200);
                    RecoverTask.this.mThread = null;
                } catch (Throwable th) {
                    RecoverTask.this.mSuccessCount = RecoverTask.nativeSuccessCount(RecoverTask.this.mNativePtr);
                    RecoverTask.this.mFailedCount = RecoverTask.nativeFailureCount(RecoverTask.this.mNativePtr);
                    RecoverTask.this.mDB.releaseNativeConnection(acquireNativeConnectionHandle);
                    RecoverTask.nativeFinish(RecoverTask.this.mNativePtr);
                    RecoverTask.this.mNativePtr = 0;
                    RecoverTask.this.onFinish(-1);
                    RecoverTask.this.mThread = null;
                }
            }
        };
        this.mThread.start();
    }

    public int successCount() {
        return this.mSuccessCount;
    }

    public int failureCount() {
        return this.mFailedCount;
    }

    public void onStart() {
    }

    public void onFinish(int i) {
    }

    public void cancel() {
        if (this.mNativePtr != 0 && this.mThread != null) {
            nativeCancel(this.mNativePtr);
        }
    }

    public String lastError() {
        return this.mNativePtr != 0 ? nativeLastError(this.mNativePtr) : null;
    }

    public void release() {
        if (this.mNativePtr != 0) {
            nativeFinish(this.mNativePtr);
            this.mNativePtr = 0;
        }
    }

    protected void finalize() {
        release();
    }
}
