package com.tencent.mmdb.repair;

import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteException;
import java.util.Arrays;

public class BackupTask {
    public static final int FLAG_FIX_CORRUPTION = 4;
    public static final int FLAG_INCREMENTAL = 16;
    public static final int FLAG_NO_CIPHER = 1;
    public static final int FLAG_NO_COMPRESS = 2;
    public static final int FLAG_NO_CREATE_TABLE = 8;
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "MMDB.DBBackup";
    private SQLiteDatabase mDB;
    private long mNativePtr;
    private int mStatementCount;
    private String[] mTableDesc;
    private Thread mThread;

    private static native void nativeCancel(long j);

    private static native void nativeFinish(long j);

    private static native long nativeInit(String str, byte[] bArr, int i);

    private static native String nativeLastError(long j);

    private static native int nativeRun(long j, long j2, String[] strArr);

    private static native int nativeStatementCount(long j);

    public BackupTask(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, int i, String[] strArr) {
        this.mDB = sQLiteDatabase;
        this.mTableDesc = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.mNativePtr = nativeInit(str, bArr, i);
        if (this.mNativePtr == 0) {
            throw new SQLiteException("Failed initialize backup context.");
        }
        this.mThread = null;
    }

    public void run() {
        if (this.mNativePtr == 0) {
            throw new IllegalStateException("BackupTask not initialized.");
        }
        this.mThread = new Thread("DB Backup Thread") {
            public void run() {
                long acquireNativeConnectionHandle = BackupTask.this.mDB.acquireNativeConnectionHandle(false, false);
                try {
                    BackupTask.this.onStart();
                    int access$300 = BackupTask.nativeRun(BackupTask.this.mNativePtr, acquireNativeConnectionHandle, BackupTask.this.mTableDesc);
                    BackupTask.this.mStatementCount = BackupTask.nativeStatementCount(BackupTask.this.mNativePtr);
                    BackupTask.this.mDB.releaseNativeConnection(acquireNativeConnectionHandle);
                    BackupTask.nativeFinish(BackupTask.this.mNativePtr);
                    BackupTask.this.mNativePtr = 0;
                    BackupTask.this.onFinish(access$300);
                    BackupTask.this.mThread = null;
                } catch (Throwable th) {
                    BackupTask.this.mStatementCount = BackupTask.nativeStatementCount(BackupTask.this.mNativePtr);
                    BackupTask.this.mDB.releaseNativeConnection(acquireNativeConnectionHandle);
                    BackupTask.nativeFinish(BackupTask.this.mNativePtr);
                    BackupTask.this.mNativePtr = 0;
                    BackupTask.this.onFinish(-1);
                    BackupTask.this.mThread = null;
                }
            }
        };
        this.mThread.start();
    }

    public int statementCount() {
        return this.mStatementCount;
    }

    public void onStart() {
    }

    public void onFinish(int i) {
    }

    public void cancel() {
        if (this.mNativePtr == 0) {
            throw new IllegalStateException("BackupTask not initialized.");
        } else if (this.mThread != null) {
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
