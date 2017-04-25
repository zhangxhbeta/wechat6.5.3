package com.tencent.mmdb.repair;

import com.tencent.mmdb.SQLException;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteException;

public class RepairKit {
    public static final int FLAG_ALL_TABLES = 2;
    public static final int FLAG_NO_CREATE_TABLES = 1;
    private static final int INTEGRITY_DATA = 2;
    private static final int INTEGRITY_HEADER = 1;
    private static final int INTEGRITY_KDF_SALT = 4;
    private int mIntegrityFlags;
    private long mNativePtr;

    public static class MasterInfo {
        long mMasterPtr;

        private MasterInfo(long j) {
            this.mMasterPtr = j;
        }

        public static MasterInfo make(String[] strArr) {
            long access$000 = RepairKit.nativeMakeMaster(strArr);
            if (access$000 != 0) {
                return new MasterInfo(access$000);
            }
            throw new SQLiteException("Cannot create MasterInfo.");
        }

        public static MasterInfo load(String str, byte[] bArr, String[] strArr, byte[] bArr2) {
            if (bArr2 == null || bArr2.length >= 16) {
                long access$100 = RepairKit.nativeLoadMaster(str, bArr, strArr, bArr2);
                if (access$100 != 0) {
                    return new MasterInfo(access$100);
                }
                throw new SQLiteException("Cannot create MasterInfo.");
            }
            throw new IllegalArgumentException("Salt must be at least 16 bytes long.");
        }

        public static boolean save(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
            long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle(true, false);
            boolean access$200 = RepairKit.nativeSaveMaster(acquireNativeConnectionHandle, str, bArr);
            sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle);
            return access$200;
        }

        public void release() {
            if (this.mMasterPtr != 0) {
                RepairKit.nativeFreeMaster(this.mMasterPtr);
                this.mMasterPtr = 0;
            }
        }

        protected void finalize() {
            release();
            super.finalize();
        }
    }

    private static native void nativeFini(long j);

    private static native void nativeFreeMaster(long j);

    private static native long nativeInit(String str, byte[] bArr, byte[] bArr2);

    private static native int nativeIntegrityFlags(long j);

    private static native String nativeLastError();

    private static native long nativeLoadMaster(String str, byte[] bArr, String[] strArr, byte[] bArr2);

    private static native long nativeMakeMaster(String[] strArr);

    private static native boolean nativeOutput(long j, long j2, long j3, int i);

    private static native boolean nativeSaveMaster(long j, String str, byte[] bArr);

    public RepairKit(String str, byte[] bArr, byte[] bArr2) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if (bArr2 == null || bArr2.length >= 16) {
            this.mNativePtr = nativeInit(str, bArr, bArr2);
            if (this.mNativePtr == 0) {
                throw new SQLException("Failed initialize RepairKit.");
            }
            this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        } else {
            throw new IllegalArgumentException("Salt must be at least 16 bytes long.");
        }
    }

    public void release() {
        if (this.mNativePtr != 0) {
            nativeFini(this.mNativePtr);
            this.mNativePtr = 0;
        }
    }

    public boolean output(SQLiteDatabase sQLiteDatabase, MasterInfo masterInfo, int i) {
        long j = 0;
        if (this.mNativePtr == 0) {
            throw new IllegalArgumentException();
        }
        if (masterInfo != null) {
            j = masterInfo.mMasterPtr;
        }
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle(false, false);
        boolean nativeOutput = nativeOutput(this.mNativePtr, acquireNativeConnectionHandle, j, i);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle);
        this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        return nativeOutput;
    }

    public boolean isSaltCorrupted() {
        return (this.mIntegrityFlags & 4) == 0;
    }

    public boolean isHeaderCorrupted() {
        return (this.mIntegrityFlags & 1) == 0;
    }

    public boolean isDataCorrupted() {
        return (this.mIntegrityFlags & 2) == 0;
    }

    public static String lastError() {
        return nativeLastError();
    }

    protected void finalize() {
        release();
        super.finalize();
    }
}
