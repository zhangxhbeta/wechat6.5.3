package com.tencent.mmdb.database;

import android.annotation.SuppressLint;
import com.tencent.mm.m.a.b;
import com.tencent.mm.m.a.c;
import com.tencent.mm.m.a.c.a;
import com.tencent.mmdb.CursorWindow;
import com.tencent.mmdb.DatabaseUtils;
import com.tencent.mmdb.database.SQLiteDebug.DbStats;
import com.tencent.mmdb.support.CancellationSignal;
import com.tencent.mmdb.support.CancellationSignal.OnCancelListener;
import com.tencent.mmdb.support.Log;
import com.tencent.mmdb.support.LruCache;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public final class SQLiteConnection implements OnCancelListener {
    private static final boolean DEBUG = false;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String TAG = "MMDB.SQLiteConnection";
    private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
    c currentFillingDbCursor;
    b currentFillingWindow;
    private int mArithmetic;
    private int mCancellationSignalAttachCount;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private long mConnectionPtr;
    private boolean mIsInitWaited;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private int mLockedDevice;
    private boolean mOnlyAllowReadOnlyOperations;
    private byte[] mPassword;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations = new OperationLog();
    a rb;
    public int windowAllocatedSize;

    @SuppressLint({"SimpleDateFormat"})
    private static final class Operation {
        private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        public ArrayList<Object> mBindArgs;
        public int mCookie;
        public long mEndTime;
        public Exception mException;
        public boolean mFinished;
        public String mKind;
        public String mSql;
        public long mStartTime;
        public int type;

        private Operation() {
        }

        public final void describe(StringBuilder stringBuilder, boolean z) {
            stringBuilder.append(this.mKind);
            if (this.mFinished) {
                stringBuilder.append(" took ").append(this.mEndTime - this.mStartTime).append("ms");
            } else {
                stringBuilder.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
            }
            stringBuilder.append(" - ").append(getStatus());
            if (this.mSql != null) {
                stringBuilder.append(", sql=\"").append(SQLiteConnection.trimSqlForDisplay(this.mSql)).append("\"");
            }
            if (!(!z || this.mBindArgs == null || this.mBindArgs.size() == 0)) {
                stringBuilder.append(", bindArgs=[");
                int size = this.mBindArgs.size();
                for (int i = 0; i < size; i++) {
                    Object obj = this.mBindArgs.get(i);
                    if (i != 0) {
                        stringBuilder.append(", ");
                    }
                    if (obj == null) {
                        stringBuilder.append("null");
                    } else if (obj instanceof byte[]) {
                        stringBuilder.append("<byte[]>");
                    } else if (obj instanceof String) {
                        stringBuilder.append("\"").append((String) obj).append("\"");
                    } else {
                        stringBuilder.append(obj);
                    }
                }
                stringBuilder.append("]");
            }
            if (this.mException != null && this.mException.getMessage() != null) {
                stringBuilder.append(", exception=\"").append(this.mException.getMessage()).append("\"");
            }
        }

        public final void bindStamentType(int i) {
            this.type = i;
        }

        private String getStatus() {
            if (this.mFinished) {
                return this.mException != null ? "failed" : "succeeded";
            } else {
                return "running";
            }
        }

        private String getFormattedStartTime() {
            return sDateFormat.format(new Date(this.mStartTime));
        }
    }

    private final class OperationLog {
        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation[] mOperations;

        private OperationLog() {
            this.mOperations = new Operation[20];
        }

        public final Operation beginOperation(String str, String str2, Object[] objArr) {
            Operation operation;
            int i = 0;
            synchronized (this.mOperations) {
                int i2 = (this.mIndex + 1) % 20;
                operation = this.mOperations[i2];
                if (operation == null) {
                    operation = new Operation();
                    this.mOperations[i2] = operation;
                } else {
                    operation.mFinished = false;
                    operation.mException = null;
                    if (operation.mBindArgs != null) {
                        operation.mBindArgs.clear();
                    }
                }
                operation.mStartTime = System.currentTimeMillis();
                operation.mKind = str;
                operation.mSql = str2;
                if (objArr != null) {
                    if (operation.mBindArgs == null) {
                        operation.mBindArgs = new ArrayList();
                    } else {
                        operation.mBindArgs.clear();
                    }
                    while (i < objArr.length) {
                        Object obj = objArr[i];
                        if (obj == null || !(obj instanceof byte[])) {
                            operation.mBindArgs.add(obj);
                        } else {
                            operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                        }
                        i++;
                    }
                }
                operation.mCookie = newOperationCookieLocked(i2);
                this.mIndex = i2;
            }
            return operation;
        }

        public final void failOperation(int i, Exception exception) {
            synchronized (this.mOperations) {
                Operation operationLocked = getOperationLocked(i);
                if (operationLocked != null) {
                    operationLocked.mException = exception;
                }
            }
        }

        public final void endOperation(String str, long j, int i) {
            synchronized (this.mOperations) {
                if (endOperationDeferLogLocked(str, j, i)) {
                    logOperationLocked(i, null);
                }
            }
        }

        public final boolean endOperationDeferLog(String str, long j, int i) {
            boolean endOperationDeferLogLocked;
            synchronized (this.mOperations) {
                endOperationDeferLogLocked = endOperationDeferLogLocked(str, j, i);
            }
            return endOperationDeferLogLocked;
        }

        public final void logOperation(int i, String str) {
            synchronized (this.mOperations) {
                logOperationLocked(i, str);
            }
        }

        private boolean endOperationDeferLogLocked(String str, long j, int i) {
            Operation operationLocked = getOperationLocked(i);
            if (operationLocked == null) {
                return false;
            }
            operationLocked.mEndTime = System.currentTimeMillis();
            operationLocked.mFinished = true;
            if (operationLocked.mException != null && operationLocked.mException.getMessage() != null) {
                return true;
            }
            long j2 = operationLocked.mEndTime - operationLocked.mStartTime;
            SQLiteConnection.this.mPool.traceExecute(operationLocked.mSql, operationLocked.type, j2);
            return SQLiteDebug.shouldLogSlowQuery(j2);
        }

        private void logOperationLocked(int i, String str) {
            Operation operationLocked = getOperationLocked(i);
            StringBuilder stringBuilder = new StringBuilder();
            operationLocked.describe(stringBuilder, false);
            if (str != null) {
                stringBuilder.append(", ").append(str);
            }
            Log.i(SQLiteConnection.TAG, stringBuilder.toString());
        }

        private int newOperationCookieLocked(int i) {
            int i2 = this.mGeneration;
            this.mGeneration = i2 + 1;
            return (i2 << 8) | i;
        }

        private Operation getOperationLocked(int i) {
            Operation operation = this.mOperations[i & 255];
            return operation.mCookie == i ? operation : null;
        }

        public final String describeCurrentOperation() {
            String str;
            synchronized (this.mOperations) {
                Operation operation = this.mOperations[this.mIndex];
                if (operation == null || operation.mFinished) {
                    str = null;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    operation.describe(stringBuilder, false);
                    str = stringBuilder.toString();
                }
            }
            return str;
        }

        public final void dump(boolean z) {
            synchronized (this.mOperations) {
                Log.i(SQLiteConnection.TAG, "  Most recently executed operations:");
                int i = this.mIndex;
                Operation operation = this.mOperations[i];
                if (operation != null) {
                    Operation operation2 = operation;
                    int i2 = 0;
                    while (true) {
                        int i3;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("    ").append(i2).append(": [");
                        stringBuilder.append(operation2.getFormattedStartTime());
                        stringBuilder.append("] ");
                        operation2.describe(stringBuilder, z);
                        Log.i(SQLiteConnection.TAG, stringBuilder.toString());
                        if (i > 0) {
                            i3 = i - 1;
                        } else {
                            i3 = 19;
                        }
                        i2++;
                        Operation operation3 = this.mOperations[i3];
                        if (operation3 == null || i2 >= 20) {
                            break;
                        }
                        Operation operation4 = operation3;
                        i = i3;
                        operation2 = operation4;
                    }
                } else {
                    Log.i(SQLiteConnection.TAG, "    <none>");
                }
            }
        }
    }

    private static final class PreparedStatement {
        public boolean mInCache;
        public boolean mInUse;
        public int mNumParameters;
        public PreparedStatement mPoolNext;
        public boolean mReadOnly;
        public String mSql;
        public long mStatementPtr;
        public int mType;

        private PreparedStatement() {
        }
    }

    private final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        public PreparedStatementCache(int i) {
            super(i);
        }

        protected final void entryRemoved(boolean z, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            preparedStatement.mInCache = false;
            if (!preparedStatement.mInUse) {
                SQLiteConnection.this.finalizePreparedStatement(preparedStatement);
            }
        }

        public final void dump() {
            Log.i(SQLiteConnection.TAG, "  Prepared statement cache:");
            Map snapshot = snapshot();
            if (snapshot.isEmpty()) {
                Log.i(SQLiteConnection.TAG, "    <none>");
                return;
            }
            int i = 0;
            for (Entry entry : snapshot.entrySet()) {
                PreparedStatement preparedStatement = (PreparedStatement) entry.getValue();
                if (preparedStatement.mInCache) {
                    Log.i(SQLiteConnection.TAG, "    " + i + ": statementPtr=0x" + Long.toHexString(preparedStatement.mStatementPtr) + ", numParameters=" + preparedStatement.mNumParameters + ", type=" + preparedStatement.mType + ", readOnly=" + preparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay((String) entry.getKey()) + "\"");
                }
                i++;
            }
        }
    }

    private static native void nativeBindBlob(long j, long j2, int i, byte[] bArr);

    private static native void nativeBindDouble(long j, long j2, int i, double d);

    private static native void nativeBindLong(long j, long j2, int i, long j3);

    private static native void nativeBindNull(long j, long j2, int i);

    private static native void nativeBindString(long j, long j2, int i, String str);

    private static native void nativeCancel(long j);

    private static native void nativeClose(long j);

    private static native void nativeExecute(long j, long j2);

    private static native int nativeExecuteForChangedRowCount(long j, long j2);

    private native long nativeExecuteForCursorDataWindow(long j, long j2, int i, int i2);

    private static native long nativeExecuteForCursorWindow(long j, long j2, long j3, int i, int i2, boolean z);

    private static native long nativeExecuteForLastInsertedRowId(long j, long j2);

    private static native long nativeExecuteForLong(long j, long j2);

    private static native String nativeExecuteForString(long j, long j2);

    private static native String nativeExplainQueryPlan(long j, String str);

    private static native void nativeFinalizeStatement(long j, long j2);

    private static native int nativeGetColumnCount(long j, long j2);

    private static native String nativeGetColumnName(long j, long j2, int i);

    private static native int nativeGetDbLookaside(long j);

    private static native int nativeGetParameterCount(long j, long j2);

    private static native boolean nativeIsReadOnly(long j, long j2);

    private static native long nativeOpen(String str, int i, String str2, boolean z, boolean z2);

    private static native long nativePrepareStatement(long j, String str);

    private static native void nativeRegisterCustomFunction(long j, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(long j, String str);

    private static native void nativeResetCancel(long j, boolean z);

    private static native void nativeResetStatementAndClearBindings(long j, long j2);

    private static native void nativeSetKey(long j, int i, byte[] bArr, int i2);

    final long getCurrentConnectionPtr() {
        return this.mConnectionPtr;
    }

    private SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i, boolean z, int i2, byte[] bArr, int i3, boolean z2) {
        this.mIsInitWaited = z2;
        this.mPassword = bArr;
        this.mArithmetic = i3;
        this.mLockedDevice = i2;
        this.mPool = sQLiteConnectionPool;
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.mConnectionId = i;
        this.mIsPrimaryConnection = z;
        this.mIsReadOnlyConnection = (sQLiteDatabaseConfiguration.openFlags & 1) != 0;
        this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
    }

    protected final void finalize() {
        try {
            if (!(this.mPool == null || this.mConnectionPtr == 0)) {
                this.mPool.onConnectionLeaked();
            }
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    static SQLiteConnection open(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i, boolean z, int i2, byte[] bArr, int i3, boolean z2) {
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, sQLiteDatabaseConfiguration, i, z, i2, bArr, i3, z2);
        try {
            sQLiteConnection.open();
            return sQLiteConnection;
        } catch (SQLiteException e) {
            sQLiteConnection.dispose(false);
            throw e;
        }
    }

    final void close() {
        dispose(false);
    }

    private void open() {
        this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.label, false, false);
        setPageSize();
        nativeSetKey(this.mConnectionPtr, this.mLockedDevice, this.mPassword, this.mArithmetic);
        if (!this.mIsInitWaited) {
            initDb();
        }
    }

    final void OverInitWaitedDefault() {
        if (this.mIsInitWaited) {
            boolean z = this.mOnlyAllowReadOnlyOperations;
            if (z) {
                this.mOnlyAllowReadOnlyOperations = false;
            }
            initDb();
            if (z) {
                this.mOnlyAllowReadOnlyOperations = z;
            }
        }
    }

    private void initDb() {
        setForeignKeyModeFromConfiguration();
        setWalModeFromConfiguration();
        setJournalSizeLimit();
        setAutoCheckpointInterval();
        setLocaleFromConfiguration();
        int size = this.mConfiguration.customFunctions.size();
        for (int i = 0; i < size; i++) {
            nativeRegisterCustomFunction(this.mConnectionPtr, (SQLiteCustomFunction) this.mConfiguration.customFunctions.get(i));
        }
    }

    private void dispose(boolean z) {
        if (this.mConnectionPtr != 0) {
            int i = this.mRecentOperations.beginOperation("close", null, null).mCookie;
            try {
                this.mPreparedStatementCache.evictAll();
                nativeClose(this.mConnectionPtr);
                this.mConnectionPtr = 0;
            } finally {
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
            }
        }
    }

    private void setPageSize() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long defaultPageSize = (long) SQLiteGlobal.getDefaultPageSize();
            if (executeForLong("PRAGMA page_size", null, null) != defaultPageSize) {
                execute("PRAGMA page_size=" + defaultPageSize, null, null);
            }
        }
    }

    private void setAutoCheckpointInterval() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long wALAutoCheckpoint = (long) SQLiteGlobal.getWALAutoCheckpoint();
            if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != wALAutoCheckpoint) {
                executeForLong("PRAGMA wal_autocheckpoint=" + wALAutoCheckpoint, null, null);
            }
        }
    }

    private void setJournalSizeLimit() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long journalSizeLimit = (long) SQLiteGlobal.getJournalSizeLimit();
            if (executeForLong("PRAGMA journal_size_limit", null, null) != journalSizeLimit) {
                executeForLong("PRAGMA journal_size_limit=" + journalSizeLimit, null, null);
            }
        }
    }

    private void setForeignKeyModeFromConfiguration() {
        if (!this.mIsReadOnlyConnection) {
            long j = this.mConfiguration.foreignKeyConstraintsEnabled ? 1 : 0;
            if (executeForLong("PRAGMA foreign_keys", null, null) != j) {
                execute("PRAGMA foreign_keys=" + j, null, null);
            }
        }
    }

    private void setWalModeFromConfiguration() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            if ((this.mConfiguration.openFlags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                setJournalMode("WAL");
                setSyncMode(SQLiteGlobal.getWALSyncMode());
                return;
            }
            setJournalMode(SQLiteGlobal.getDefaultJournalMode());
            setSyncMode(SQLiteGlobal.getDefaultSyncMode());
        }
    }

    private void setSyncMode(String str) {
        if (!canonicalizeSyncMode(executeForString("PRAGMA synchronous", null, null)).equalsIgnoreCase(canonicalizeSyncMode(str))) {
            execute("PRAGMA synchronous=" + str, null, null);
        }
    }

    private static String canonicalizeSyncMode(String str) {
        if (str.equals("0")) {
            return "OFF";
        }
        if (str.equals("1")) {
            return "NORMAL";
        }
        if (str.equals("2")) {
            return "FULL";
        }
        return str;
    }

    private void setJournalMode(String str) {
        String executeForString = executeForString("PRAGMA journal_mode", null, null);
        if (!executeForString.equalsIgnoreCase(str)) {
            try {
                if (executeForString("PRAGMA journal_mode=" + str, null, null).equalsIgnoreCase(str)) {
                    return;
                }
            } catch (SQLiteDatabaseLockedException e) {
            }
            Log.w(TAG, "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + executeForString + "' to '" + str + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        }
    }

    private void setLocaleFromConfiguration() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        sQLiteDatabaseConfiguration.openFlags |= 16;
        if ((this.mConfiguration.openFlags & 16) == 0) {
            String locale = this.mConfiguration.locale.toString();
            nativeRegisterLocalizedCollators(this.mConnectionPtr, locale);
            if (!this.mIsReadOnlyConnection) {
                try {
                    execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
                    String executeForString = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);
                    if (executeForString == null || !executeForString.equals(locale)) {
                        execute("BEGIN", null, null);
                        execute("DELETE FROM android_metadata", null, null);
                        execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{locale}, null);
                        execute("REINDEX LOCALIZED", null, null);
                        execute("COMMIT", null, null);
                    }
                } catch (Throwable e) {
                    throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + locale + "'.", e);
                } catch (Throwable th) {
                    execute("ROLLBACK", null, null);
                }
            }
        }
    }

    final void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        boolean z;
        boolean z2 = true;
        this.mOnlyAllowReadOnlyOperations = false;
        int size = sQLiteDatabaseConfiguration.customFunctions.size();
        for (int i = 0; i < size; i++) {
            SQLiteCustomFunction sQLiteCustomFunction = (SQLiteCustomFunction) sQLiteDatabaseConfiguration.customFunctions.get(i);
            if (!this.mConfiguration.customFunctions.contains(sQLiteCustomFunction)) {
                nativeRegisterCustomFunction(this.mConnectionPtr, sQLiteCustomFunction);
            }
        }
        boolean z3 = sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled;
        if (((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (sQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale)) {
            z2 = false;
        }
        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
        this.mPreparedStatementCache.resize(sQLiteDatabaseConfiguration.maxSqlCacheSize);
        if (z3) {
            setForeignKeyModeFromConfiguration();
        }
        if (z) {
            setWalModeFromConfiguration();
        }
        if (z2) {
            setLocaleFromConfiguration();
        }
    }

    final void setOnlyAllowReadOnlyOperations(boolean z) {
        this.mOnlyAllowReadOnlyOperations = z;
    }

    final boolean isPreparedStatementInCache(String str) {
        return this.mPreparedStatementCache.get(str) != null;
    }

    final void setKey(byte[] bArr, int i, int i2) {
        this.mPassword = bArr;
        this.mArithmetic = i2;
        this.mLockedDevice = i;
        nativeSetKey(this.mConnectionPtr, this.mLockedDevice, this.mPassword, this.mArithmetic);
    }

    public final int getConnectionId() {
        return this.mConnectionId;
    }

    public final boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    public final void prepare(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("prepare", str, null);
        int i = beginOperation.mCookie;
        PreparedStatement acquirePreparedStatement;
        try {
            acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.bindStamentType(acquirePreparedStatement.mType);
            if (sQLiteStatementInfo != null) {
                sQLiteStatementInfo.numParameters = acquirePreparedStatement.mNumParameters;
                sQLiteStatementInfo.readOnly = acquirePreparedStatement.mReadOnly;
                int nativeGetColumnCount = nativeGetColumnCount(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                if (nativeGetColumnCount == 0) {
                    sQLiteStatementInfo.columnNames = EMPTY_STRING_ARRAY;
                } else {
                    sQLiteStatementInfo.columnNames = new String[nativeGetColumnCount];
                    for (int i2 = 0; i2 < nativeGetColumnCount; i2++) {
                        sQLiteStatementInfo.columnNames[i2] = nativeGetColumnName(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr, i2);
                    }
                }
            }
            releasePreparedStatement(acquirePreparedStatement);
            this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy();
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th) {
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
            }
        } catch (Throwable th2) {
            releasePreparedStatement(acquirePreparedStatement);
        }
    }

    public final void execute(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("execute", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.bindStamentType(acquirePreparedStatement.mType);
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                nativeExecute(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy();
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
            }
        }
    }

    public final long executeForLong(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForLong", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.bindStamentType(acquirePreparedStatement.mType);
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                long nativeExecuteForLong = nativeExecuteForLong(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
                return nativeExecuteForLong;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy();
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
            }
        }
    }

    public final String executeForString(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForString", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.bindStamentType(acquirePreparedStatement.mType);
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                String nativeExecuteForString = nativeExecuteForString(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
                return nativeExecuteForString;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy();
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
            }
        }
    }

    public final int executeForChangedRowCount(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        int nativeExecuteForChangedRowCount;
        Throwable th;
        Exception e;
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForChangedRowCount", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.bindStamentType(acquirePreparedStatement.mType);
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                nativeExecuteForChangedRowCount = nativeExecuteForChangedRowCount(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                try {
                    detachCancellationSignal(cancellationSignal);
                } catch (Throwable th2) {
                    th = th2;
                    releasePreparedStatement(acquirePreparedStatement);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                nativeExecuteForChangedRowCount = 0;
                releasePreparedStatement(acquirePreparedStatement);
                throw th;
            }
            try {
                releasePreparedStatement(acquirePreparedStatement);
                if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i)) {
                    this.mRecentOperations.logOperation(i, "changedRows=" + nativeExecuteForChangedRowCount);
                    if (explainQueryPlan(str) != null) {
                        Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                    }
                }
                return nativeExecuteForChangedRowCount;
            } catch (RuntimeException e2) {
                e = e2;
                try {
                    if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                        this.mPool.logConnectionPoolBusy();
                    }
                    this.mRecentOperations.failOperation(i, e);
                    throw e;
                } catch (Throwable th4) {
                    th = th4;
                    if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i)) {
                        this.mRecentOperations.logOperation(i, "changedRows=" + nativeExecuteForChangedRowCount);
                        if (explainQueryPlan(str) != null) {
                            Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                        }
                    }
                    throw th;
                }
            }
        } catch (RuntimeException e3) {
            e = e3;
            nativeExecuteForChangedRowCount = 0;
            this.mPool.logConnectionPoolBusy();
            this.mRecentOperations.failOperation(i, e);
            throw e;
        } catch (Throwable th5) {
            th = th5;
            nativeExecuteForChangedRowCount = 0;
            if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i)) {
                this.mRecentOperations.logOperation(i, "changedRows=" + nativeExecuteForChangedRowCount);
                if (explainQueryPlan(str) != null) {
                    Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                }
            }
            throw th;
        }
    }

    public final long executeForLastInsertedRowId(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.bindStamentType(acquirePreparedStatement.mType);
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                long nativeExecuteForLastInsertedRowId = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
                return nativeExecuteForLastInsertedRowId;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy();
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(this.mConfiguration.path, getCurrentConnectionPtr(), i);
            }
        }
    }

    public final int executeForCursorWindow(String str, Object[] objArr, int i, int i2, int i3, b bVar, c cVar) {
        int i4;
        int i5;
        Throwable th;
        Exception e;
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (bVar != null) {
            bVar.acquireReference();
        }
        int i6 = -1;
        try {
            Operation beginOperation = this.mRecentOperations.beginOperation("executeForCursorWindow", str, objArr);
            int i7 = beginOperation.mCookie;
            try {
                PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                beginOperation.bindStamentType(acquirePreparedStatement.mType);
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                int size;
                try {
                    this.currentFillingWindow = bVar;
                    this.currentFillingDbCursor = cVar;
                    long nativeExecuteForCursorDataWindow = nativeExecuteForCursorDataWindow(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr, i2, i3);
                    i4 = (int) (nativeExecuteForCursorDataWindow >> 32);
                    i5 = (int) nativeExecuteForCursorDataWindow;
                    if (bVar != null) {
                        try {
                            size = bVar.chv.size();
                            try {
                                bVar.mStartPos = i4;
                                i6 = size;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    releasePreparedStatement(acquirePreparedStatement);
                                    this.currentFillingWindow = null;
                                    this.currentFillingDbCursor = null;
                                    throw th;
                                } catch (RuntimeException e2) {
                                    e = e2;
                                    i6 = size;
                                    try {
                                        this.mPool.logConnectionPoolBusy();
                                        this.mRecentOperations.failOperation(i7, e);
                                        throw e;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i7)) {
                                            this.mRecentOperations.logOperation(i7, "window='" + bVar + "', startPos=" + i2 + ", actualPos=" + i4 + ", filledRows=" + i6 + ", countedRows=" + i5);
                                            if (explainQueryPlan(str) != null) {
                                                Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    i6 = size;
                                    if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i7)) {
                                        this.mRecentOperations.logOperation(i7, "window='" + bVar + "', startPos=" + i2 + ", actualPos=" + i4 + ", filledRows=" + i6 + ", countedRows=" + i5);
                                        if (explainQueryPlan(str) != null) {
                                            Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            size = -1;
                            releasePreparedStatement(acquirePreparedStatement);
                            this.currentFillingWindow = null;
                            this.currentFillingDbCursor = null;
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    size = -1;
                    i5 = -1;
                    i4 = -1;
                    releasePreparedStatement(acquirePreparedStatement);
                    this.currentFillingWindow = null;
                    this.currentFillingDbCursor = null;
                    throw th;
                }
                try {
                    releasePreparedStatement(acquirePreparedStatement);
                    this.currentFillingWindow = null;
                    this.currentFillingDbCursor = null;
                    if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i7)) {
                        this.mRecentOperations.logOperation(i7, "window='" + bVar + "', startPos=" + i2 + ", actualPos=" + i4 + ", filledRows=" + i6 + ", countedRows=" + i5);
                        if (explainQueryPlan(str) != null) {
                            Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                        }
                    }
                    if (bVar != null) {
                        bVar.releaseReference();
                    }
                    return i5;
                } catch (RuntimeException e3) {
                    e = e3;
                    this.mPool.logConnectionPoolBusy();
                    this.mRecentOperations.failOperation(i7, e);
                    throw e;
                }
            } catch (RuntimeException e4) {
                e = e4;
                i5 = -1;
                i4 = -1;
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy();
                }
                this.mRecentOperations.failOperation(i7, e);
                throw e;
            } catch (Throwable th7) {
                th = th7;
                i5 = -1;
                i4 = -1;
                if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i7)) {
                    this.mRecentOperations.logOperation(i7, "window='" + bVar + "', startPos=" + i2 + ", actualPos=" + i4 + ", filledRows=" + i6 + ", countedRows=" + i5);
                    if (explainQueryPlan(str) != null) {
                        Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            if (bVar != null) {
                bVar.releaseReference();
            }
        }
    }

    public final int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i, int i2, boolean z, CancellationSignal cancellationSignal) {
        int i3;
        int numRows;
        Throwable th;
        Exception e;
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        } else {
            cursorWindow.acquireReference();
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            try {
                Operation beginOperation = this.mRecentOperations.beginOperation("executeForCursorWindow", str, objArr);
                int i7 = beginOperation.mCookie;
                try {
                    PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                    beginOperation.bindStamentType(acquirePreparedStatement.mType);
                    try {
                        int i8;
                        throwIfStatementForbidden(acquirePreparedStatement);
                        bindArguments(acquirePreparedStatement, objArr);
                        applyBlockGuardPolicy(acquirePreparedStatement);
                        attachCancellationSignal(cancellationSignal);
                        try {
                            long nativeExecuteForCursorWindow = nativeExecuteForCursorWindow(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr, cursorWindow.mWindowPtr, i, i2, z);
                            i8 = (int) (nativeExecuteForCursorWindow >> 32);
                            i3 = (int) nativeExecuteForCursorWindow;
                            try {
                                numRows = cursorWindow.getNumRows();
                                try {
                                    cursorWindow.setStartPosition(i8);
                                } catch (Throwable th2) {
                                    th = th2;
                                    detachCancellationSignal(cancellationSignal);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                numRows = -1;
                                detachCancellationSignal(cancellationSignal);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            numRows = -1;
                            i3 = -1;
                            i8 = -1;
                            detachCancellationSignal(cancellationSignal);
                            throw th;
                        }
                        try {
                            detachCancellationSignal(cancellationSignal);
                            try {
                                releasePreparedStatement(acquirePreparedStatement);
                                if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i7)) {
                                    this.mRecentOperations.logOperation(i7, "window='" + cursorWindow + "', startPos=" + i + ", actualPos=" + i8 + ", filledRows=" + numRows + ", countedRows=" + i3);
                                    if (explainQueryPlan(str) != null) {
                                        Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                                    }
                                }
                                cursorWindow.releaseReference();
                                return i3;
                            } catch (RuntimeException e2) {
                                e = e2;
                                i6 = numRows;
                                i5 = i3;
                                i4 = i8;
                                try {
                                    if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                                        this.mPool.logConnectionPoolBusy();
                                    }
                                    this.mRecentOperations.failOperation(i7, e);
                                    throw e;
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i7)) {
                                        this.mRecentOperations.logOperation(i7, "window='" + cursorWindow + "', startPos=" + i + ", actualPos=" + i4 + ", filledRows=" + i6 + ", countedRows=" + i5);
                                        if (explainQueryPlan(str) != null) {
                                            Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                i6 = numRows;
                                i5 = i3;
                                i4 = i8;
                                if (this.mRecentOperations.endOperationDeferLog(this.mConfiguration.path, this.mConnectionPtr, i7)) {
                                    this.mRecentOperations.logOperation(i7, "window='" + cursorWindow + "', startPos=" + i + ", actualPos=" + i4 + ", filledRows=" + i6 + ", countedRows=" + i5);
                                    if (explainQueryPlan(str) != null) {
                                        Log.i(TAG, "Explain Query Plan: %s\n%s", str, explainQueryPlan(str));
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            i6 = numRows;
                            i5 = i3;
                            i4 = i8;
                            releasePreparedStatement(acquirePreparedStatement);
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        releasePreparedStatement(acquirePreparedStatement);
                        throw th;
                    }
                } catch (RuntimeException e3) {
                    e = e3;
                    this.mPool.logConnectionPoolBusy();
                    this.mRecentOperations.failOperation(i7, e);
                    throw e;
                }
            } catch (Throwable th9) {
                cursorWindow.releaseReference();
            }
        }
    }

    public final String explainQueryPlan(String str) {
        return nativeExplainQueryPlan(this.mConnectionPtr, str);
    }

    private PreparedStatement acquirePreparedStatement(String str) {
        long nativePrepareStatement;
        PreparedStatement preparedStatement = (PreparedStatement) this.mPreparedStatementCache.get(str);
        boolean z;
        int nativeGetParameterCount;
        int sqlStatementType;
        if (preparedStatement == null) {
            z = false;
            nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
            nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
            sqlStatementType = DatabaseUtils.getSqlStatementType(str);
            preparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
            this.mPreparedStatementCache.put(str, preparedStatement);
            preparedStatement.mInCache = true;
            preparedStatement.mInUse = true;
        } else if (preparedStatement.mInUse) {
            z = true;
            nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
            try {
                nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
                sqlStatementType = DatabaseUtils.getSqlStatementType(str);
                preparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
                if (!z && isCacheable(sqlStatementType)) {
                    this.mPreparedStatementCache.put(str, preparedStatement);
                    preparedStatement.mInCache = true;
                }
                preparedStatement.mInUse = true;
            } catch (RuntimeException e) {
                if (preparedStatement == null || !preparedStatement.mInCache) {
                    nativeFinalizeStatement(this.mConnectionPtr, nativePrepareStatement);
                }
                throw e;
            }
        }
        return preparedStatement;
    }

    private void releasePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mInUse = false;
        if (preparedStatement.mInCache) {
            try {
                nativeResetStatementAndClearBindings(this.mConnectionPtr, preparedStatement.mStatementPtr);
                return;
            } catch (SQLiteException e) {
                this.mPreparedStatementCache.remove(preparedStatement.mSql);
                return;
            }
        }
        finalizePreparedStatement(preparedStatement);
    }

    private void finalizePreparedStatement(PreparedStatement preparedStatement) {
        nativeFinalizeStatement(this.mConnectionPtr, preparedStatement.mStatementPtr);
        recyclePreparedStatement(preparedStatement);
    }

    private void attachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            this.mCancellationSignalAttachCount++;
            if (this.mCancellationSignalAttachCount == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                cancellationSignal.setOnCancelListener(this);
            }
        }
    }

    private void detachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            this.mCancellationSignalAttachCount--;
            if (this.mCancellationSignalAttachCount == 0) {
                cancellationSignal.setOnCancelListener(null);
                nativeResetCancel(this.mConnectionPtr, false);
            }
        }
    }

    public final void onCancel() {
        nativeCancel(this.mConnectionPtr);
    }

    private void bindArguments(PreparedStatement preparedStatement, Object[] objArr) {
        int length;
        if (objArr != null) {
            length = objArr.length;
        } else {
            length = 0;
        }
        if (length != preparedStatement.mNumParameters) {
            throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.mNumParameters + " bind arguments but " + length + " were provided.");
        } else if (length != 0) {
            long j = preparedStatement.mStatementPtr;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                switch (DatabaseUtils.getTypeOfObject(obj)) {
                    case 0:
                        nativeBindNull(this.mConnectionPtr, j, i + 1);
                        break;
                    case 1:
                        nativeBindLong(this.mConnectionPtr, j, i + 1, ((Number) obj).longValue());
                        break;
                    case 2:
                        nativeBindDouble(this.mConnectionPtr, j, i + 1, ((Number) obj).doubleValue());
                        break;
                    case 4:
                        nativeBindBlob(this.mConnectionPtr, j, i + 1, (byte[]) obj);
                        break;
                    default:
                        if (!(obj instanceof Boolean)) {
                            nativeBindString(this.mConnectionPtr, j, i + 1, obj.toString());
                            break;
                        }
                        long j2;
                        long j3 = this.mConnectionPtr;
                        int i2 = i + 1;
                        if (((Boolean) obj).booleanValue()) {
                            j2 = 1;
                        } else {
                            j2 = 0;
                        }
                        nativeBindLong(j3, j, i2, j2);
                        break;
                }
            }
        }
    }

    private void throwIfStatementForbidden(PreparedStatement preparedStatement) {
        if (this.mOnlyAllowReadOnlyOperations && !preparedStatement.mReadOnly) {
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        }
    }

    private static boolean isCacheable(int i) {
        if (i == 2 || i == 1) {
            return true;
        }
        return false;
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedStatement) {
        this.mConfiguration.isInMemoryDb();
    }

    public final void dump(boolean z) {
        dumpUnsafe(z);
    }

    final void dumpUnsafe(boolean z) {
        Log.i(TAG, "Connection #" + this.mConnectionId + ":");
        if (z) {
            Log.i(TAG, "  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
        }
        Log.i(TAG, "  isPrimaryConnection: " + this.mIsPrimaryConnection);
        Log.i(TAG, "  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        this.mRecentOperations.dump(z);
        if (z) {
            this.mPreparedStatementCache.dump();
        }
    }

    final String describeCurrentOperationUnsafe() {
        return this.mRecentOperations.describeCurrentOperation();
    }

    final void collectDbStats(ArrayList<DbStats> arrayList) {
        int nativeGetDbLookaside = nativeGetDbLookaside(this.mConnectionPtr);
        long j = 0;
        long j2 = 0;
        try {
            j = executeForLong("PRAGMA page_count;", null, null);
            j2 = executeForLong("PRAGMA page_size;", null, null);
        } catch (SQLiteException e) {
        }
        arrayList.add(getMainDbStatsUnsafe(nativeGetDbLookaside, j, j2));
        CursorWindow cursorWindow = new CursorWindow("collectDbStats");
        try {
            executeForCursorWindow("PRAGMA database_list;", null, cursorWindow, 0, 0, false, null);
            for (int i = 1; i < cursorWindow.getNumRows(); i++) {
                long j3;
                String string = cursorWindow.getString(i, 1);
                String string2 = cursorWindow.getString(i, 2);
                long j4 = 0;
                long j5 = 0;
                try {
                    j4 = executeForLong("PRAGMA " + string + ".page_count;", null, null);
                    j5 = executeForLong("PRAGMA " + string + ".page_size;", null, null);
                    j3 = j4;
                } catch (SQLiteException e2) {
                    j3 = j4;
                } finally {
                    cursorWindow.close();
                }
                String str = "  (attached) " + string;
                if (string2.length() != 0) {
                    str = str + ": " + string2;
                }
                arrayList.add(new DbStats(str, j3, j5, 0, 0, 0, 0));
            }
        } catch (SQLiteException e3) {
        } finally {
            cursorWindow.close();
        }
    }

    final void collectDbStatsUnsafe(ArrayList<DbStats> arrayList) {
        arrayList.add(getMainDbStatsUnsafe(0, 0, 0));
    }

    private DbStats getMainDbStatsUnsafe(int i, long j, long j2) {
        String str = this.mConfiguration.path;
        if (!this.mIsPrimaryConnection) {
            str = str + " (" + this.mConnectionId + ")";
        }
        return new DbStats(str, j, j2, i, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    }

    public final String toString() {
        return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
    }

    private PreparedStatement obtainPreparedStatement(String str, long j, int i, int i2, boolean z) {
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement();
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = j;
        preparedStatement.mNumParameters = i;
        preparedStatement.mType = i2;
        preparedStatement.mReadOnly = z;
        return preparedStatement;
    }

    private void recyclePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mSql = null;
        preparedStatement.mPoolNext = this.mPreparedStatementPool;
        this.mPreparedStatementPool = preparedStatement;
    }

    private static String trimSqlForDisplay(String str) {
        return TRIM_SQL_PATTERN.matcher(str).replaceAll(" ");
    }

    public final void fillRowString(int i, String str) {
        if (this.currentFillingWindow != null) {
            b bVar = this.currentFillingWindow;
            if (bVar.chz != null) {
                bVar.chz.n(i, str);
            }
        } else if (this.rb != null) {
            this.rb.al(str);
        }
    }

    public final void fillRowInt(int i, long j) {
        if (this.currentFillingWindow != null) {
            b bVar = this.currentFillingWindow;
            if (bVar.chz != null) {
                bVar.chz.j(i, j);
            }
        } else if (this.rb != null) {
            this.rb.al(Long.valueOf(j));
        }
    }

    public final void fillRowLong(int i, long j) {
        if (this.currentFillingWindow != null) {
            b bVar = this.currentFillingWindow;
            if (bVar.chz != null) {
                bVar.chz.k(i, j);
            }
        } else if (this.rb != null) {
            this.rb.al(Long.valueOf(j));
        }
    }

    public final void fillRowDouble(int i, double d) {
        if (this.currentFillingWindow == null && this.rb != null) {
            this.rb.al(Double.valueOf(d));
        }
    }

    public final void fillRowBlob(int i, byte[] bArr) {
        if (this.currentFillingWindow != null) {
            b bVar = this.currentFillingWindow;
            if (bVar.chz != null) {
                bVar.chz.e(i, bArr);
            }
        } else if (this.rb != null) {
            this.rb.al(bArr);
        }
    }

    public final void fillRowFloat(int i, float f) {
        if (this.currentFillingWindow == null && this.rb != null) {
            this.rb.al(Float.valueOf(f));
        }
    }

    public final void fillRowNull(int i) {
        if (this.currentFillingWindow == null && this.rb != null) {
            this.rb.al(null);
        }
    }

    public final void fillRowStart(int i) {
        if (this.currentFillingWindow != null) {
            b bVar = this.currentFillingWindow;
            if (!bVar.em(i)) {
                bVar.chz = bVar.tZ();
            }
        } else if (this.currentFillingDbCursor != null) {
            Object[] objArr;
            c cVar = this.currentFillingDbCursor;
            int i2 = i / cVar.chB;
            if (cVar.chA.indexOfKey(i2) < 0) {
                objArr = new Object[(cVar.chB * cVar.columnCount)];
                cVar.chA.put(i2, objArr);
            } else {
                objArr = (Object[]) cVar.chA.get(i2);
            }
            int i3 = cVar.columnCount * (i % cVar.chB);
            int i4 = i3 + cVar.columnCount;
            i2 = i + 1;
            if (i2 <= cVar.chC) {
                i2 = cVar.chC;
            }
            cVar.chC = i2;
            this.rb = new a(cVar, i3, i4, objArr);
        }
    }

    public final void fillRowEnd(int i, int i2) {
        if (this.currentFillingWindow != null) {
            b bVar = this.currentFillingWindow;
            if (i2 != 0) {
                Log.e("MMDB.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", Integer.valueOf(i2), Integer.valueOf(i));
                bVar.chv.remove(i);
            } else if (bVar.chz != null) {
                Object key = bVar.chz.getKey();
                bVar.chx.put(key, bVar.chz);
                bVar.chv.put(i, key);
            }
        }
    }

    public final void allDataEnd(int i, int i2) {
        if (this.currentFillingWindow != null) {
            b bVar = this.currentFillingWindow;
            bVar.chz = null;
            bVar.chw = bVar.chv.size();
            Log.i("MMDB.CursorDataWindow", "newcursor fillEnd posistionMaps.size is   %d ,data size is :%d", Integer.valueOf(bVar.chw), Integer.valueOf(bVar.chx.size()));
            this.windowAllocatedSize += i2;
            return;
        }
        this.currentFillingDbCursor = null;
        this.rb = null;
        this.currentFillingWindow = null;
    }
}
