package com.tencent.mmdb.database;

import android.os.SystemClock;
import com.tencent.mmdb.database.SQLiteDatabase.Arithmetic;
import com.tencent.mmdb.database.SQLiteDatabase.LockedDevice;
import com.tencent.mmdb.database.SQLiteDebug.DbStats;
import com.tencent.mmdb.support.CancellationSignal;
import com.tencent.mmdb.support.CancellationSignal.OnCancelListener;
import com.tencent.mmdb.support.Log;
import com.tencent.mmdb.support.OperationCanceledException;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public final class SQLiteConnectionPool implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteConnectionPool.class.desiredAssertionStatus());
    public static final int CONNECTION_FLAG_INTERACTIVE = 4;
    public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
    public static final int CONNECTION_FLAG_READ_ONLY = 1;
    private static final long CONNECTION_POOL_BUSY_MILLIS = 30000;
    private static final String TAG = "MMDB.SQLiteConnectionPool";
    private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> mAcquiredConnections = new WeakHashMap();
    private int mArithmetic;
    private final ArrayList<SQLiteConnection> mAvailableNonPrimaryConnections = new ArrayList();
    private SQLiteConnection mAvailablePrimaryConnection;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final AtomicBoolean mConnectionLeaked = new AtomicBoolean();
    private ConnectionWaiter mConnectionWaiterPool;
    private ConnectionWaiter mConnectionWaiterQueue;
    private final WeakReference<SQLiteDatabase> mDB;
    private boolean mIsInitWaited;
    private boolean mIsOpen;
    private final Object mLock = new Object();
    private int mMaxConnectionPoolSize;
    private int mNextConnectionId;
    private byte[] mPassword;
    private volatile SQLiteTrace mTraceCallback;
    private int mlockedDevice;

    enum AcquiredConnectionStatus {
        NORMAL,
        RECONFIGURE,
        DISCARD
    }

    private static final class ConnectionWaiter {
        public SQLiteConnection mAssignedConnection;
        public int mConnectionFlags;
        public RuntimeException mException;
        public ConnectionWaiter mNext;
        public int mNonce;
        public int mPriority;
        public String mSql;
        public long mStartTime;
        public Thread mThread;
        public boolean mWantPrimaryConnection;

        private ConnectionWaiter() {
        }
    }

    private SQLiteConnectionPool(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i) {
        this.mDB = new WeakReference(sQLiteDatabase);
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked(i);
    }

    protected final void finalize() {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    public static SQLiteConnectionPool open(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, LockedDevice lockedDevice, byte[] bArr, Arithmetic arithmetic, boolean z) {
        return open(sQLiteDatabase, sQLiteDatabaseConfiguration, lockedDevice, bArr, arithmetic, z, 1);
    }

    public static SQLiteConnectionPool open(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, LockedDevice lockedDevice, byte[] bArr, Arithmetic arithmetic, boolean z, int i) {
        if (sQLiteDatabaseConfiguration == null) {
            throw new IllegalArgumentException("configuration must not be null.");
        }
        SQLiteConnectionPool sQLiteConnectionPool = new SQLiteConnectionPool(sQLiteDatabase, sQLiteDatabaseConfiguration, i);
        sQLiteConnectionPool.mIsInitWaited = z;
        sQLiteConnectionPool.mlockedDevice = lockedDevice.getValue();
        sQLiteConnectionPool.mPassword = bArr;
        sQLiteConnectionPool.mArithmetic = arithmetic.getValue();
        sQLiteConnectionPool.open();
        return sQLiteConnectionPool;
    }

    public final void OverInitWaitedDefault() {
        this.mAvailablePrimaryConnection.OverInitWaitedDefault();
    }

    private void open() {
        this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
        this.mIsOpen = true;
    }

    public final void close() {
        dispose(false);
    }

    private void dispose(boolean z) {
        if (!z) {
            synchronized (this.mLock) {
                throwIfClosedLocked();
                this.mIsOpen = false;
                closeAvailableConnectionsAndLogExceptionsLocked();
                int size = this.mAcquiredConnections.size();
                if (size != 0) {
                    Log.i(TAG, "The connection pool for " + this.mConfiguration.label + " has been closed but there are still " + size + " connections in use.  They will be closed as they are released back to the pool.");
                }
                wakeConnectionWaitersLocked();
            }
        }
    }

    public final void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        Object obj = 1;
        if (sQLiteDatabaseConfiguration == null) {
            throw new IllegalArgumentException("configuration must not be null.");
        }
        synchronized (this.mLock) {
            throwIfClosedLocked();
            Object obj2 = ((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0 ? 1 : null;
            if (obj2 != null) {
                if (this.mAcquiredConnections.isEmpty()) {
                    closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
                } else {
                    throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                }
            }
            if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) {
                obj = null;
            }
            if (obj == null || this.mAcquiredConnections.isEmpty()) {
                if (this.mConfiguration.openFlags != sQLiteDatabaseConfiguration.openFlags) {
                    if (obj2 != null) {
                        closeAvailableConnectionsAndLogExceptionsLocked();
                    }
                    SQLiteConnection openConnectionLocked = openConnectionLocked(sQLiteDatabaseConfiguration, true);
                    closeAvailableConnectionsAndLogExceptionsLocked();
                    discardAcquiredConnectionsLocked();
                    this.mAvailablePrimaryConnection = openConnectionLocked;
                    this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
                    setMaxConnectionPoolSizeLocked(1);
                } else {
                    this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
                    setMaxConnectionPoolSizeLocked(1);
                    closeExcessConnectionsAndLogExceptionsLocked();
                    reconfigureAllConnectionsLocked();
                }
                wakeConnectionWaitersLocked();
            } else {
                throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
            }
        }
    }

    public final SQLiteConnection acquireConnection(String str, int i, CancellationSignal cancellationSignal) {
        return waitForConnection(str, i, cancellationSignal);
    }

    public final void releaseConnection(SQLiteConnection sQLiteConnection) {
        synchronized (this.mLock) {
            AcquiredConnectionStatus acquiredConnectionStatus = (AcquiredConnectionStatus) this.mAcquiredConnections.remove(sQLiteConnection);
            if (acquiredConnectionStatus == null) {
                throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
            }
            if (!this.mIsOpen) {
                closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            } else if (sQLiteConnection.isPrimaryConnection()) {
                if (recycleConnectionLocked(sQLiteConnection, acquiredConnectionStatus)) {
                    if ($assertionsDisabled || this.mAvailablePrimaryConnection == null) {
                        this.mAvailablePrimaryConnection = sQLiteConnection;
                    } else {
                        throw new AssertionError();
                    }
                }
                wakeConnectionWaitersLocked();
            } else if (this.mAvailableNonPrimaryConnections.size() >= this.mMaxConnectionPoolSize - 1) {
                closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            } else {
                if (recycleConnectionLocked(sQLiteConnection, acquiredConnectionStatus)) {
                    this.mAvailableNonPrimaryConnections.add(sQLiteConnection);
                }
                wakeConnectionWaitersLocked();
            }
        }
    }

    private boolean recycleConnectionLocked(SQLiteConnection sQLiteConnection, AcquiredConnectionStatus acquiredConnectionStatus) {
        if (acquiredConnectionStatus == AcquiredConnectionStatus.RECONFIGURE) {
            try {
                sQLiteConnection.reconfigure(this.mConfiguration);
            } catch (RuntimeException e) {
                Log.e(TAG, "Failed to reconfigure released connection, closing it: " + sQLiteConnection, e);
                acquiredConnectionStatus = AcquiredConnectionStatus.DISCARD;
            }
        }
        if (acquiredConnectionStatus != AcquiredConnectionStatus.DISCARD) {
            return true;
        }
        closeConnectionAndLogExceptionsLocked(sQLiteConnection);
        return false;
    }

    public final boolean shouldYieldConnection(SQLiteConnection sQLiteConnection, int i) {
        boolean isSessionBlockingImportantConnectionWaitersLocked;
        synchronized (this.mLock) {
            if (!this.mAcquiredConnections.containsKey(sQLiteConnection)) {
                throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
            } else if (this.mIsOpen) {
                isSessionBlockingImportantConnectionWaitersLocked = isSessionBlockingImportantConnectionWaitersLocked(sQLiteConnection.isPrimaryConnection(), i);
            } else {
                isSessionBlockingImportantConnectionWaitersLocked = false;
            }
        }
        return isSessionBlockingImportantConnectionWaitersLocked;
    }

    public final void collectDbStats(ArrayList<DbStats> arrayList) {
        synchronized (this.mLock) {
            if (this.mAvailablePrimaryConnection != null) {
                this.mAvailablePrimaryConnection.collectDbStats(arrayList);
            }
            Iterator it = this.mAvailableNonPrimaryConnections.iterator();
            while (it.hasNext()) {
                ((SQLiteConnection) it.next()).collectDbStats(arrayList);
            }
            for (SQLiteConnection collectDbStatsUnsafe : this.mAcquiredConnections.keySet()) {
                collectDbStatsUnsafe.collectDbStatsUnsafe(arrayList);
            }
        }
    }

    private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, boolean z) {
        int i = this.mNextConnectionId;
        this.mNextConnectionId = i + 1;
        return SQLiteConnection.open(this, sQLiteDatabaseConfiguration, i, z, this.mlockedDevice, this.mPassword, this.mArithmetic, this.mIsInitWaited);
    }

    final void onConnectionLeaked() {
        Log.w(TAG, "A SQLiteConnection object for database '" + this.mConfiguration.label + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        this.mConnectionLeaked.set(true);
    }

    private void closeAvailableConnectionsAndLogExceptionsLocked() {
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
        if (this.mAvailablePrimaryConnection != null) {
            closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
            this.mAvailablePrimaryConnection = null;
        }
    }

    private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked() {
        int size = this.mAvailableNonPrimaryConnections.size();
        for (int i = 0; i < size; i++) {
            closeConnectionAndLogExceptionsLocked((SQLiteConnection) this.mAvailableNonPrimaryConnections.get(i));
        }
        this.mAvailableNonPrimaryConnections.clear();
    }

    private void closeExcessConnectionsAndLogExceptionsLocked() {
        int size = this.mAvailableNonPrimaryConnections.size();
        while (true) {
            int i = size - 1;
            if (size > this.mMaxConnectionPoolSize - 1) {
                closeConnectionAndLogExceptionsLocked((SQLiteConnection) this.mAvailableNonPrimaryConnections.remove(i));
                size = i;
            } else {
                return;
            }
        }
    }

    private void closeConnectionAndLogExceptionsLocked(SQLiteConnection sQLiteConnection) {
        try {
            sQLiteConnection.close();
        } catch (RuntimeException e) {
            Log.e(TAG, "Failed to close connection, its fate is now in the hands of the merciful GC: " + sQLiteConnection, e);
        }
    }

    private void discardAcquiredConnectionsLocked() {
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.DISCARD);
    }

    private void reconfigureAllConnectionsLocked() {
        if (this.mAvailablePrimaryConnection != null) {
            try {
                this.mAvailablePrimaryConnection.reconfigure(this.mConfiguration);
            } catch (RuntimeException e) {
                Log.e(TAG, "Failed to reconfigure available primary connection, closing it: " + this.mAvailablePrimaryConnection, e);
                closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
                this.mAvailablePrimaryConnection = null;
            }
        }
        int size = this.mAvailableNonPrimaryConnections.size();
        int i = 0;
        while (i < size) {
            int i2;
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mAvailableNonPrimaryConnections.get(i);
            try {
                sQLiteConnection.reconfigure(this.mConfiguration);
                i2 = i;
                i = size;
            } catch (RuntimeException e2) {
                Log.e(TAG, "Failed to reconfigure available non-primary connection, closing it: " + sQLiteConnection, e2);
                closeConnectionAndLogExceptionsLocked(sQLiteConnection);
                i2 = i - 1;
                this.mAvailableNonPrimaryConnections.remove(i);
                i = size - 1;
            }
            size = i;
            i = i2 + 1;
        }
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.RECONFIGURE);
    }

    private void markAcquiredConnectionsLocked(AcquiredConnectionStatus acquiredConnectionStatus) {
        if (!this.mAcquiredConnections.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.mAcquiredConnections.size());
            for (Entry entry : this.mAcquiredConnections.entrySet()) {
                AcquiredConnectionStatus acquiredConnectionStatus2 = (AcquiredConnectionStatus) entry.getValue();
                if (!(acquiredConnectionStatus == acquiredConnectionStatus2 || acquiredConnectionStatus2 == AcquiredConnectionStatus.DISCARD)) {
                    arrayList.add(entry.getKey());
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mAcquiredConnections.put(arrayList.get(i), acquiredConnectionStatus);
            }
        }
    }

    private SQLiteConnection waitForConnection(String str, int i, CancellationSignal cancellationSignal) {
        SQLiteConnection sQLiteConnection;
        boolean z = (i & 2) != 0;
        synchronized (this.mLock) {
            throwIfClosedLocked();
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            sQLiteConnection = null;
            if (!z) {
                sQLiteConnection = tryAcquireNonPrimaryConnectionLocked(str, i);
            }
            if (sQLiteConnection == null) {
                sQLiteConnection = tryAcquirePrimaryConnectionLocked(i);
            }
            if (sQLiteConnection != null) {
            } else {
                int priority = getPriority(i);
                final ConnectionWaiter obtainConnectionWaiterLocked = obtainConnectionWaiterLocked(Thread.currentThread(), SystemClock.uptimeMillis(), priority, z, str, i);
                ConnectionWaiter connectionWaiter = null;
                for (ConnectionWaiter connectionWaiter2 = this.mConnectionWaiterQueue; connectionWaiter2 != null; connectionWaiter2 = connectionWaiter2.mNext) {
                    if (priority > connectionWaiter2.mPriority) {
                        obtainConnectionWaiterLocked.mNext = connectionWaiter2;
                        break;
                    }
                    connectionWaiter = connectionWaiter2;
                }
                if (connectionWaiter != null) {
                    connectionWaiter.mNext = obtainConnectionWaiterLocked;
                } else {
                    this.mConnectionWaiterQueue = obtainConnectionWaiterLocked;
                }
                final int i2 = obtainConnectionWaiterLocked.mNonce;
                if (cancellationSignal != null) {
                    cancellationSignal.setOnCancelListener(new OnCancelListener() {
                        public void onCancel() {
                            synchronized (SQLiteConnectionPool.this.mLock) {
                                if (obtainConnectionWaiterLocked.mNonce == i2) {
                                    SQLiteConnectionPool.this.cancelConnectionWaiterLocked(obtainConnectionWaiterLocked);
                                }
                            }
                        }
                    });
                }
                try {
                    RuntimeException runtimeException;
                    long j = obtainConnectionWaiterLocked.mStartTime + CONNECTION_POOL_BUSY_MILLIS;
                    long j2 = CONNECTION_POOL_BUSY_MILLIS;
                    long j3 = j;
                    while (true) {
                        if (this.mConnectionLeaked.compareAndSet(true, false)) {
                            synchronized (this.mLock) {
                                wakeConnectionWaitersLocked();
                            }
                        }
                        LockSupport.parkNanos(j2 * 1000000);
                        Thread.interrupted();
                        synchronized (this.mLock) {
                            throwIfClosedLocked();
                            sQLiteConnection = obtainConnectionWaiterLocked.mAssignedConnection;
                            runtimeException = obtainConnectionWaiterLocked.mException;
                            if (sQLiteConnection == null && runtimeException == null) {
                                j2 = SystemClock.uptimeMillis();
                                if (j2 < j3) {
                                    j = j3;
                                    j3 = j2 - j3;
                                    j2 = j;
                                } else {
                                    logConnectionPoolBusyLocked(j2 - obtainConnectionWaiterLocked.mStartTime, i);
                                    j3 = CONNECTION_POOL_BUSY_MILLIS;
                                    j2 += CONNECTION_POOL_BUSY_MILLIS;
                                }
                            } else {
                                recycleConnectionWaiterLocked(obtainConnectionWaiterLocked);
                            }
                        }
                        j = j2;
                        j2 = j3;
                        j3 = j;
                    }
                    recycleConnectionWaiterLocked(obtainConnectionWaiterLocked);
                    if (sQLiteConnection != null) {
                        if (cancellationSignal != null) {
                            cancellationSignal.setOnCancelListener(null);
                        }
                    } else {
                        throw runtimeException;
                    }
                } catch (Throwable th) {
                    if (cancellationSignal != null) {
                        cancellationSignal.setOnCancelListener(null);
                    }
                }
            }
        }
        return sQLiteConnection;
    }

    private void cancelConnectionWaiterLocked(ConnectionWaiter connectionWaiter) {
        if (connectionWaiter.mAssignedConnection == null && connectionWaiter.mException == null) {
            ConnectionWaiter connectionWaiter2 = null;
            ConnectionWaiter connectionWaiter3 = this.mConnectionWaiterQueue;
            while (connectionWaiter3 != connectionWaiter) {
                if ($assertionsDisabled || connectionWaiter3 != null) {
                    connectionWaiter2 = connectionWaiter3;
                    connectionWaiter3 = connectionWaiter3.mNext;
                } else {
                    throw new AssertionError();
                }
            }
            if (connectionWaiter2 != null) {
                connectionWaiter2.mNext = connectionWaiter.mNext;
            } else {
                this.mConnectionWaiterQueue = connectionWaiter.mNext;
            }
            connectionWaiter.mException = new OperationCanceledException();
            LockSupport.unpark(connectionWaiter.mThread);
            wakeConnectionWaitersLocked();
        }
    }

    public final void logConnectionPoolBusy() {
        synchronized (this.mLock) {
            logConnectionPoolBusyLocked(0, 0);
        }
    }

    private void logConnectionPoolBusyLocked(long j, int i) {
        int i2;
        int i3;
        StringBuilder stringBuilder = new StringBuilder();
        if (j != 0) {
            Thread currentThread = Thread.currentThread();
            stringBuilder.append("The connection pool for database '").append(this.mConfiguration.label);
            stringBuilder.append("' has been unable to grant a connection to thread ");
            stringBuilder.append(currentThread.getId()).append(" (").append(currentThread.getName()).append(") ");
            stringBuilder.append("with flags 0x").append(Integer.toHexString(i));
            stringBuilder.append(" for ").append(((float) j) * 0.001f).append(" seconds.\n");
        }
        ArrayList arrayList = new ArrayList();
        if (this.mAcquiredConnections.isEmpty()) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = 0;
            i3 = 0;
            for (SQLiteConnection describeCurrentOperationUnsafe : this.mAcquiredConnections.keySet()) {
                String describeCurrentOperationUnsafe2 = describeCurrentOperationUnsafe.describeCurrentOperationUnsafe();
                if (describeCurrentOperationUnsafe2 != null) {
                    arrayList.add(describeCurrentOperationUnsafe2);
                    i3++;
                } else {
                    i2++;
                }
            }
        }
        int size = this.mAvailableNonPrimaryConnections.size();
        if (this.mAvailablePrimaryConnection != null) {
            size++;
        }
        stringBuilder.append("Connections: ").append(i3).append(" active, ");
        stringBuilder.append(i2).append(" idle, ");
        stringBuilder.append(size).append(" available.\n");
        if (!arrayList.isEmpty()) {
            stringBuilder.append("\nRequests in progress:\n");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuilder.append("  ").append((String) it.next()).append("\n");
            }
        }
        Log.w(TAG, stringBuilder.toString());
    }

    private void wakeConnectionWaitersLocked() {
        int i;
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
        Object obj = null;
        Object obj2 = null;
        ConnectionWaiter connectionWaiter2 = null;
        while (connectionWaiter != null) {
            Object obj3;
            if (this.mIsOpen) {
                try {
                    SQLiteConnection sQLiteConnection;
                    if (connectionWaiter.mWantPrimaryConnection || obj != null) {
                        sQLiteConnection = null;
                    } else {
                        sQLiteConnection = tryAcquireNonPrimaryConnectionLocked(connectionWaiter.mSql, connectionWaiter.mConnectionFlags);
                        if (sQLiteConnection == null) {
                            obj = 1;
                        }
                    }
                    if (sQLiteConnection == null && obj2 == null) {
                        sQLiteConnection = tryAcquirePrimaryConnectionLocked(connectionWaiter.mConnectionFlags);
                        if (sQLiteConnection == null) {
                            obj2 = 1;
                        }
                    }
                    if (sQLiteConnection != null) {
                        connectionWaiter.mAssignedConnection = sQLiteConnection;
                        obj3 = obj2;
                        obj2 = obj;
                        i = 1;
                    } else if (obj == null || obj2 == null) {
                        obj3 = obj2;
                        obj2 = obj;
                        obj = null;
                    } else {
                        return;
                    }
                } catch (RuntimeException e) {
                    connectionWaiter.mException = e;
                    obj3 = obj2;
                    obj2 = obj;
                    i = 1;
                }
            } else {
                obj3 = obj2;
                obj2 = obj;
                obj = 1;
            }
            ConnectionWaiter connectionWaiter3 = connectionWaiter.mNext;
            if (obj != null) {
                if (connectionWaiter2 != null) {
                    connectionWaiter2.mNext = connectionWaiter3;
                } else {
                    this.mConnectionWaiterQueue = connectionWaiter3;
                }
                connectionWaiter.mNext = null;
                LockSupport.unpark(connectionWaiter.mThread);
            } else {
                connectionWaiter2 = connectionWaiter;
            }
            obj = obj2;
            connectionWaiter = connectionWaiter3;
            obj2 = obj3;
        }
    }

    private SQLiteConnection tryAcquirePrimaryConnectionLocked(int i) {
        SQLiteConnection sQLiteConnection = this.mAvailablePrimaryConnection;
        if (sQLiteConnection != null) {
            this.mAvailablePrimaryConnection = null;
            finishAcquireConnectionLocked(sQLiteConnection, i);
            return sQLiteConnection;
        }
        for (SQLiteConnection sQLiteConnection2 : this.mAcquiredConnections.keySet()) {
            if (sQLiteConnection2.isPrimaryConnection()) {
                return null;
            }
        }
        sQLiteConnection2 = openConnectionLocked(this.mConfiguration, true);
        finishAcquireConnectionLocked(sQLiteConnection2, i);
        return sQLiteConnection2;
    }

    private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String str, int i) {
        SQLiteConnection sQLiteConnection;
        int size = this.mAvailableNonPrimaryConnections.size();
        if (size > 1 && str != null) {
            for (int i2 = 0; i2 < size; i2++) {
                sQLiteConnection = (SQLiteConnection) this.mAvailableNonPrimaryConnections.get(i2);
                if (sQLiteConnection.isPreparedStatementInCache(str)) {
                    this.mAvailableNonPrimaryConnections.remove(i2);
                    finishAcquireConnectionLocked(sQLiteConnection, i);
                    return sQLiteConnection;
                }
            }
        }
        if (size > 0) {
            sQLiteConnection = (SQLiteConnection) this.mAvailableNonPrimaryConnections.remove(size - 1);
            finishAcquireConnectionLocked(sQLiteConnection, i);
            return sQLiteConnection;
        }
        int size2 = this.mAcquiredConnections.size();
        if (this.mAvailablePrimaryConnection != null) {
            size2++;
        }
        if (size2 >= this.mMaxConnectionPoolSize) {
            return null;
        }
        sQLiteConnection = openConnectionLocked(this.mConfiguration, false);
        finishAcquireConnectionLocked(sQLiteConnection, i);
        return sQLiteConnection;
    }

    private void finishAcquireConnectionLocked(SQLiteConnection sQLiteConnection, int i) {
        try {
            sQLiteConnection.setOnlyAllowReadOnlyOperations((i & 1) != 0);
            this.mAcquiredConnections.put(sQLiteConnection, AcquiredConnectionStatus.NORMAL);
        } catch (RuntimeException e) {
            Log.e(TAG, "Failed to prepare acquired connection for session, closing it: " + sQLiteConnection + ", connectionFlags=" + i);
            closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            throw e;
        }
    }

    private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean z, int i) {
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
        if (connectionWaiter != null) {
            int priority = getPriority(i);
            while (priority <= connectionWaiter.mPriority) {
                if (!z && connectionWaiter.mWantPrimaryConnection) {
                    connectionWaiter = connectionWaiter.mNext;
                    if (connectionWaiter == null) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static int getPriority(int i) {
        return (i & 4) != 0 ? 1 : 0;
    }

    private void setMaxConnectionPoolSizeLocked(int i) {
        if ((this.mConfiguration.openFlags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            this.mMaxConnectionPoolSize = i;
            Log.i(TAG, "main connectionPoolOpen in WAL,pool size is %d ", Integer.valueOf(i));
            return;
        }
        this.mMaxConnectionPoolSize = i;
        Log.i(TAG, "main connectionPoolOpen ,pool size is %d ", Integer.valueOf(i));
    }

    private void throwIfClosedLocked() {
        if (!this.mIsOpen) {
            throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
        }
    }

    private ConnectionWaiter obtainConnectionWaiterLocked(Thread thread, long j, int i, boolean z, String str, int i2) {
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterPool;
        if (connectionWaiter != null) {
            this.mConnectionWaiterPool = connectionWaiter.mNext;
            connectionWaiter.mNext = null;
        } else {
            connectionWaiter = new ConnectionWaiter();
        }
        connectionWaiter.mThread = thread;
        connectionWaiter.mStartTime = j;
        connectionWaiter.mPriority = i;
        connectionWaiter.mWantPrimaryConnection = z;
        connectionWaiter.mSql = str;
        connectionWaiter.mConnectionFlags = i2;
        return connectionWaiter;
    }

    private void recycleConnectionWaiterLocked(ConnectionWaiter connectionWaiter) {
        connectionWaiter.mNext = this.mConnectionWaiterPool;
        connectionWaiter.mThread = null;
        connectionWaiter.mSql = null;
        connectionWaiter.mAssignedConnection = null;
        connectionWaiter.mException = null;
        connectionWaiter.mNonce++;
        this.mConnectionWaiterPool = connectionWaiter;
    }

    final SQLiteTrace getTraceCallback() {
        return this.mTraceCallback;
    }

    final void setTraceCallback(SQLiteTrace sQLiteTrace) {
        this.mTraceCallback = sQLiteTrace;
    }

    final void traceExecute(String str, int i, long j) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.mDB.get();
        if (this.mTraceCallback != null && sQLiteDatabase != null) {
            this.mTraceCallback.onSQLExecuted(sQLiteDatabase, str, i, j);
        }
    }

    public final void dump(boolean z) {
        synchronized (this.mLock) {
            Log.i(TAG, "Connection pool for " + this.mConfiguration.path + ":");
            Log.i(TAG, "  Open: " + this.mIsOpen);
            Log.i(TAG, "  Max connections: " + this.mMaxConnectionPoolSize);
            Log.i(TAG, "  Available primary connection:");
            if (this.mAvailablePrimaryConnection != null) {
                this.mAvailablePrimaryConnection.dump(z);
            } else {
                Log.i(TAG, "<none>");
            }
            Log.i(TAG, "  Available non-primary connections:");
            if (this.mAvailableNonPrimaryConnections.isEmpty()) {
                Log.i(TAG, "<none>");
            } else {
                int size = this.mAvailableNonPrimaryConnections.size();
                for (int i = 0; i < size; i++) {
                    ((SQLiteConnection) this.mAvailableNonPrimaryConnections.get(i)).dump(z);
                }
            }
            Log.i(TAG, "  Acquired connections:");
            if (this.mAcquiredConnections.isEmpty()) {
                Log.i(TAG, "<none>");
            } else {
                for (Entry entry : this.mAcquiredConnections.entrySet()) {
                    ((SQLiteConnection) entry.getKey()).dumpUnsafe(z);
                    Log.i(TAG, "  Status: " + entry.getValue());
                }
            }
            Log.i(TAG, "  Connection waiters:");
            if (this.mConnectionWaiterQueue != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
                int i2 = 0;
                while (connectionWaiter != null) {
                    Log.i(TAG, i2 + ": waited for " + (((float) (uptimeMillis - connectionWaiter.mStartTime)) * 0.001f) + " ms - thread=" + connectionWaiter.mThread + ", priority=" + connectionWaiter.mPriority + ", sql='" + connectionWaiter.mSql + "'");
                    connectionWaiter = connectionWaiter.mNext;
                    i2++;
                }
            } else {
                Log.i(TAG, "<none>");
            }
        }
    }

    public final String toString() {
        return "SQLiteConnectionPool: " + this.mConfiguration.path;
    }
}
