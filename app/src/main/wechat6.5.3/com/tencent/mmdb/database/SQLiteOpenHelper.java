package com.tencent.mmdb.database;

import android.content.Context;
import com.tencent.mmdb.DatabaseErrorHandler;
import com.tencent.mmdb.database.SQLiteDatabase.Arithmetic;
import com.tencent.mmdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.mmdb.database.SQLiteDatabase.LockedDevice;
import com.tencent.mmdb.support.Log;

public abstract class SQLiteOpenHelper {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
    private Arithmetic mArithmeticl;
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final CursorFactory mFactory;
    private boolean mIsInitWaited;
    private boolean mIsInitializing;
    private int mMode;
    private final String mName;
    private boolean mNeedMode;
    private final int mNewVersion;
    private byte[] mPassword;
    private LockedDevice mlockedDevice;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null);
    }

    public SQLiteOpenHelper(Context context, String str, LockedDevice lockedDevice, byte[] bArr, Arithmetic arithmetic, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        this.mContext = context;
        this.mName = str;
        this.mFactory = cursorFactory;
        this.mNewVersion = i;
        this.mErrorHandler = databaseErrorHandler;
        this.mPassword = bArr;
        this.mArithmeticl = arithmetic;
        this.mIsInitWaited = z;
        this.mlockedDevice = lockedDevice;
        this.mNeedMode = false;
    }

    public SQLiteOpenHelper(Context context, String str, byte[] bArr, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, bArr, Arithmetic.DEFAULT, cursorFactory, i, databaseErrorHandler);
    }

    public SQLiteOpenHelper(Context context, String str, byte[] bArr, Arithmetic arithmetic, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, LockedDevice.DEFAULT, bArr, arithmetic, cursorFactory, i, databaseErrorHandler);
    }

    public SQLiteOpenHelper(Context context, String str, LockedDevice lockedDevice, byte[] bArr, Arithmetic arithmetic, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, lockedDevice, bArr, arithmetic, cursorFactory, i, databaseErrorHandler, false);
    }

    public void OverInitWaitedDefault() {
        try {
            this.mDatabase.OverInitWaitedDefault();
            if (this.mNeedMode) {
                com.tencent.mmdb.support.Context.OverInitWaitedDefault(this.mContext, this.mName, this.mMode);
            }
            SQLiteDatabase databaseLockedLast = getDatabaseLockedLast(this.mDatabase);
            if (databaseLockedLast != null && databaseLockedLast != this.mDatabase) {
                databaseLockedLast.close();
            }
        } finally {
            this.mIsInitializing = false;
        }
    }

    public SQLiteOpenHelper(Context context, String str, LockedDevice lockedDevice, Arithmetic arithmetic, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, lockedDevice, null, arithmetic, cursorFactory, i, databaseErrorHandler, true);
    }

    public SQLiteOpenHelper(Context context, String str, Arithmetic arithmetic, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, LockedDevice.DEFAULT, arithmetic, cursorFactory, i, databaseErrorHandler);
    }

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, LockedDevice.DEFAULT, null, Arithmetic.UNKNOWN, cursorFactory, i, databaseErrorHandler, false);
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != z) {
                if (!(this.mDatabase == null || !this.mDatabase.isOpen() || this.mDatabase.isReadOnly())) {
                    if (z) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                }
                this.mEnableWriteAheadLogging = z;
            }
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(true);
        }
        return databaseLocked;
    }

    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(false);
        }
        return databaseLocked;
    }

    private SQLiteDatabase getDatabaseLocked(boolean z) {
        if (this.mDatabase != null) {
            if (!this.mDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!(z && this.mDatabase.isReadOnly())) {
                return this.mDatabase;
            }
        }
        if (this.mIsInitializing) {
            throw new IllegalStateException("getDatabase called recursively");
        }
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
        try {
            this.mIsInitializing = true;
            if (sQLiteDatabase2 != null) {
                if (z && sQLiteDatabase2.isReadOnly()) {
                    sQLiteDatabase2.reopenReadWrite();
                    sQLiteDatabase = sQLiteDatabase2;
                } else {
                    sQLiteDatabase = sQLiteDatabase2;
                }
            } else if (this.mName == null) {
                sQLiteDatabase = SQLiteDatabase.create(null, this.mlockedDevice, this.mPassword, this.mArithmeticl, this.mIsInitWaited);
            } else {
                this.mNeedMode = true;
                this.mMode = this.mEnableWriteAheadLogging ? 8 : 0;
                sQLiteDatabase = com.tencent.mmdb.support.Context.openOrCreateDatabase(this.mContext, this.mName, this.mlockedDevice, this.mPassword, this.mArithmeticl, this.mMode, this.mFactory, this.mErrorHandler, this.mIsInitWaited);
            }
        } catch (SQLiteException e) {
            if (z) {
                throw e;
            } else {
                Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", new Object[]{e});
                sQLiteDatabase = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mlockedDevice, this.mPassword, this.mArithmeticl, this.mFactory, 1, this.mErrorHandler, this.mIsInitWaited);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase2;
        }
        try {
            if (this.mIsInitWaited) {
                this.mDatabase = sQLiteDatabase;
                this.mIsInitializing = false;
                if (sQLiteDatabase == null || sQLiteDatabase == this.mDatabase) {
                    return sQLiteDatabase;
                }
                sQLiteDatabase.close();
                return sQLiteDatabase;
            }
            sQLiteDatabase3 = getDatabaseLockedLast(sQLiteDatabase);
            this.mIsInitializing = false;
            if (!(sQLiteDatabase == null || sQLiteDatabase == this.mDatabase)) {
                sQLiteDatabase.close();
            }
            return sQLiteDatabase3;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            sQLiteDatabase3 = sQLiteDatabase;
            th2 = th4;
            this.mIsInitializing = false;
            if (!(sQLiteDatabase3 == null || sQLiteDatabase3 == this.mDatabase)) {
                sQLiteDatabase3.close();
            }
            throw th2;
        }
    }

    private SQLiteDatabase getDatabaseLockedLast(SQLiteDatabase sQLiteDatabase) {
        onConfigure(sQLiteDatabase);
        int version = sQLiteDatabase.getVersion();
        if (version != this.mNewVersion) {
            if (sQLiteDatabase.isReadOnly()) {
                throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
            }
            sQLiteDatabase.beginTransaction();
            if (version == 0) {
                try {
                    onCreate(sQLiteDatabase);
                } catch (Throwable th) {
                    sQLiteDatabase.endTransaction();
                }
            } else if (version > this.mNewVersion) {
                onDowngrade(sQLiteDatabase, version, this.mNewVersion);
            } else {
                onUpgrade(sQLiteDatabase, version, this.mNewVersion);
            }
            sQLiteDatabase.setVersion(this.mNewVersion);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        }
        onOpen(sQLiteDatabase);
        if (sQLiteDatabase.isReadOnly()) {
            Log.w(TAG, "Opened " + this.mName + " in read-only mode");
        }
        this.mDatabase = sQLiteDatabase;
        return sQLiteDatabase;
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        } else if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }
}
