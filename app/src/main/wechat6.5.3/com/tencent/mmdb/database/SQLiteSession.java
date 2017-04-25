package com.tencent.mmdb.database;

import com.tencent.mm.m.a.b;
import com.tencent.mm.m.a.c;
import com.tencent.mmdb.CursorWindow;
import com.tencent.mmdb.DatabaseUtils;
import com.tencent.mmdb.support.CancellationSignal;

public final class SQLiteSession {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteSession.class.desiredAssertionStatus());
    public static final int TRANSACTION_MODE_DEFERRED = 0;
    public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
    public static final int TRANSACTION_MODE_IMMEDIATE = 1;
    private SQLiteConnection mConnection;
    private int mConnectionFlags;
    private final SQLiteConnectionPool mConnectionPool;
    private int mConnectionUseCount;
    private Transaction mTransactionPool;
    private Transaction mTransactionStack;

    private static final class Transaction {
        public boolean mChildFailed;
        public SQLiteTransactionListener mListener;
        public boolean mMarkedSuccessful;
        public int mMode;
        public Transaction mParent;

        private Transaction() {
        }
    }

    public SQLiteSession(SQLiteConnectionPool sQLiteConnectionPool) {
        if (sQLiteConnectionPool == null) {
            throw new IllegalArgumentException("connectionPool must not be null");
        }
        this.mConnectionPool = sQLiteConnectionPool;
    }

    public final boolean hasTransaction() {
        return this.mTransactionStack != null;
    }

    public final boolean hasNestedTransaction() {
        return (this.mTransactionStack == null || this.mTransactionStack.mParent == null) ? false : true;
    }

    public final boolean hasConnection() {
        return this.mConnection != null;
    }

    public final void beginTransaction(int i, SQLiteTransactionListener sQLiteTransactionListener, int i2, CancellationSignal cancellationSignal) {
        throwIfTransactionMarkedSuccessful();
        beginTransactionUnchecked(i, sQLiteTransactionListener, i2, cancellationSignal);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void beginTransactionUnchecked(int r5, com.tencent.mmdb.database.SQLiteTransactionListener r6, int r7, com.tencent.mmdb.support.CancellationSignal r8) {
        /*
        r4 = this;
        r1 = 0;
        if (r8 == 0) goto L_0x0006;
    L_0x0003:
        r8.throwIfCanceled();
    L_0x0006:
        r0 = r4.mTransactionStack;
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r4.acquireConnection(r1, r7, r8);
    L_0x000d:
        r0 = r4.mTransactionStack;	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x001d;
    L_0x0011:
        switch(r5) {
            case 1: goto L_0x0034;
            case 2: goto L_0x0047;
            default: goto L_0x0014;
        };	 Catch:{ all -> 0x003e }
    L_0x0014:
        r0 = r4.mConnection;	 Catch:{ all -> 0x003e }
        r1 = "BEGIN;";
        r2 = 0;
        r0.execute(r1, r2, r8);	 Catch:{ all -> 0x003e }
    L_0x001d:
        if (r6 == 0) goto L_0x0022;
    L_0x001f:
        r6.onBegin();	 Catch:{ RuntimeException -> 0x0051 }
    L_0x0022:
        r0 = r4.obtainTransaction(r5, r6);	 Catch:{ all -> 0x003e }
        r1 = r4.mTransactionStack;	 Catch:{ all -> 0x003e }
        r0.mParent = r1;	 Catch:{ all -> 0x003e }
        r4.mTransactionStack = r0;	 Catch:{ all -> 0x003e }
        r0 = r4.mTransactionStack;
        if (r0 != 0) goto L_0x0033;
    L_0x0030:
        r4.releaseConnection();
    L_0x0033:
        return;
    L_0x0034:
        r0 = r4.mConnection;	 Catch:{ all -> 0x003e }
        r1 = "BEGIN IMMEDIATE;";
        r2 = 0;
        r0.execute(r1, r2, r8);	 Catch:{ all -> 0x003e }
        goto L_0x001d;
    L_0x003e:
        r0 = move-exception;
        r1 = r4.mTransactionStack;
        if (r1 != 0) goto L_0x0046;
    L_0x0043:
        r4.releaseConnection();
    L_0x0046:
        throw r0;
    L_0x0047:
        r0 = r4.mConnection;	 Catch:{ all -> 0x003e }
        r1 = "BEGIN EXCLUSIVE;";
        r2 = 0;
        r0.execute(r1, r2, r8);	 Catch:{ all -> 0x003e }
        goto L_0x001d;
    L_0x0051:
        r0 = move-exception;
        r1 = r4.mTransactionStack;	 Catch:{ all -> 0x003e }
        if (r1 != 0) goto L_0x005f;
    L_0x0056:
        r1 = r4.mConnection;	 Catch:{ all -> 0x003e }
        r2 = "ROLLBACK;";
        r3 = 0;
        r1.execute(r2, r3, r8);	 Catch:{ all -> 0x003e }
    L_0x005f:
        throw r0;	 Catch:{ all -> 0x003e }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmdb.database.SQLiteSession.beginTransactionUnchecked(int, com.tencent.mmdb.database.SQLiteTransactionListener, int, com.tencent.mmdb.support.CancellationSignal):void");
    }

    public final void setTransactionSuccessful() {
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        this.mTransactionStack.mMarkedSuccessful = true;
    }

    public final void endTransaction(CancellationSignal cancellationSignal) {
        throwIfNoTransaction();
        if ($assertionsDisabled || this.mConnection != null) {
            endTransactionUnchecked(cancellationSignal, false);
            return;
        }
        throw new AssertionError();
    }

    private void endTransactionUnchecked(CancellationSignal cancellationSignal, boolean z) {
        RuntimeException runtimeException;
        boolean z2 = false;
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Transaction transaction = this.mTransactionStack;
        boolean z3 = (transaction.mMarkedSuccessful || z) && !transaction.mChildFailed;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.mListener;
        if (sQLiteTransactionListener == null) {
            z2 = z3;
            runtimeException = null;
        } else if (z3) {
            try {
                sQLiteTransactionListener.onCommit();
                z2 = z3;
                runtimeException = null;
            } catch (RuntimeException e) {
                runtimeException = e;
            }
        } else {
            sQLiteTransactionListener.onRollback();
            z2 = z3;
            runtimeException = null;
        }
        this.mTransactionStack = transaction.mParent;
        recycleTransaction(transaction);
        if (this.mTransactionStack == null) {
            if (z2) {
                try {
                    this.mConnection.execute("COMMIT;", null, cancellationSignal);
                } catch (Throwable th) {
                    releaseConnection();
                }
            } else {
                this.mConnection.execute("ROLLBACK;", null, cancellationSignal);
            }
            releaseConnection();
        } else if (!z2) {
            this.mTransactionStack.mChildFailed = true;
        }
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final boolean yieldTransaction(long j, boolean z, CancellationSignal cancellationSignal) {
        if (z) {
            throwIfNoTransaction();
            throwIfTransactionMarkedSuccessful();
            throwIfNestedTransaction();
        } else if (this.mTransactionStack == null || this.mTransactionStack.mMarkedSuccessful || this.mTransactionStack.mParent != null) {
            return false;
        }
        if (!$assertionsDisabled && this.mConnection == null) {
            throw new AssertionError();
        } else if (this.mTransactionStack.mChildFailed) {
            return false;
        } else {
            return yieldTransactionUnchecked(j, cancellationSignal);
        }
    }

    private boolean yieldTransactionUnchecked(long j, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags)) {
            return false;
        }
        int i = this.mTransactionStack.mMode;
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionStack.mListener;
        int i2 = this.mConnectionFlags;
        endTransactionUnchecked(cancellationSignal, true);
        if (j > 0) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e) {
            }
        }
        beginTransactionUnchecked(i, sQLiteTransactionListener, i2, cancellationSignal);
        return true;
    }

    public final void prepare(String str, int i, CancellationSignal cancellationSignal, SQLiteStatementInfo sQLiteStatementInfo) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        acquireConnection(str, i, cancellationSignal);
        try {
            this.mConnection.prepare(str, sQLiteStatementInfo);
        } finally {
            releaseConnection();
        }
    }

    public final void setKey(byte[] bArr, int i, int i2, int i3) {
        acquireConnection("PRAGMA key = ?", i3, null);
        try {
            this.mConnection.setKey(bArr, i, i2);
        } finally {
            releaseConnection();
        }
    }

    public final void execute(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (!executeSpecial(str, objArr, i, cancellationSignal)) {
            acquireConnection(str, i, cancellationSignal);
            try {
                this.mConnection.execute(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
            }
        }
    }

    public final long executeForLong(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i, cancellationSignal);
            try {
                long executeForLong = this.mConnection.executeForLong(str, objArr, cancellationSignal);
                return executeForLong;
            } finally {
                releaseConnection();
            }
        }
    }

    public final String executeForString(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            return null;
        } else {
            acquireConnection(str, i, cancellationSignal);
            try {
                String executeForString = this.mConnection.executeForString(str, objArr, cancellationSignal);
                return executeForString;
            } finally {
                releaseConnection();
            }
        }
    }

    public final int executeForChangedRowCount(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i, cancellationSignal);
            try {
                int executeForChangedRowCount = this.mConnection.executeForChangedRowCount(str, objArr, cancellationSignal);
                return executeForChangedRowCount;
            } finally {
                releaseConnection();
            }
        }
    }

    public final long executeForLastInsertedRowId(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i, cancellationSignal);
            try {
                long executeForLastInsertedRowId = this.mConnection.executeForLastInsertedRowId(str, objArr, cancellationSignal);
                return executeForLastInsertedRowId;
            } finally {
                releaseConnection();
            }
        }
    }

    public final int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i, int i2, boolean z, int i3, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        } else if (executeSpecial(str, objArr, i3, cancellationSignal)) {
            cursorWindow.clear();
            return 0;
        } else {
            acquireConnection(str, i3, cancellationSignal);
            try {
                int executeForCursorWindow = this.mConnection.executeForCursorWindow(str, objArr, cursorWindow, i, i2, z, cancellationSignal);
                return executeForCursorWindow;
            } finally {
                releaseConnection();
            }
        }
    }

    public final int executeForCursorWindow(String str, Object[] objArr, int i, int i2, int i3, b bVar, c cVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, null)) {
            if (bVar != null) {
                bVar.ua();
            }
            return 0;
        } else {
            acquireConnection(str, i, null);
            try {
                int executeForCursorWindow = this.mConnection.executeForCursorWindow(str, objArr, i, i2, i3, bVar, cVar);
                return executeForCursorWindow;
            } finally {
                releaseConnection();
            }
        }
    }

    private boolean executeSpecial(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        switch (DatabaseUtils.getSqlStatementType(str)) {
            case 4:
                beginTransaction(2, null, i, cancellationSignal);
                return true;
            case 5:
                setTransactionSuccessful();
                endTransaction(cancellationSignal);
                return true;
            case 6:
                endTransaction(cancellationSignal);
                return true;
            default:
                return false;
        }
    }

    private void acquireConnection(String str, int i, CancellationSignal cancellationSignal) {
        if (this.mConnection == null) {
            this.mConnection = this.mConnectionPool.acquireConnection(str, i, cancellationSignal);
            this.mConnectionFlags = i;
        }
        this.mConnectionUseCount++;
    }

    final SQLiteConnection acquireConnectionForNativeHandle(int i) {
        if (this.mConnection == null) {
            this.mConnection = this.mConnectionPool.acquireConnection(null, i, null);
            this.mConnectionFlags = i;
        }
        this.mConnectionUseCount++;
        return this.mConnection;
    }

    final void releaseConnection() {
        int i = this.mConnectionUseCount - 1;
        this.mConnectionUseCount = i;
        if (i == 0) {
            try {
                this.mConnectionPool.releaseConnection(this.mConnection);
            } finally {
                this.mConnection = null;
            }
        }
    }

    private void throwIfNoTransaction() {
        if (this.mTransactionStack == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
    }

    private void throwIfTransactionMarkedSuccessful() {
        if (this.mTransactionStack != null && this.mTransactionStack.mMarkedSuccessful) {
            throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        }
    }

    private void throwIfNestedTransaction() {
        if (hasNestedTransaction()) {
            throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
        }
    }

    private Transaction obtainTransaction(int i, SQLiteTransactionListener sQLiteTransactionListener) {
        Transaction transaction = this.mTransactionPool;
        if (transaction != null) {
            this.mTransactionPool = transaction.mParent;
            transaction.mParent = null;
            transaction.mMarkedSuccessful = false;
            transaction.mChildFailed = false;
        } else {
            transaction = new Transaction();
        }
        transaction.mMode = i;
        transaction.mListener = sQLiteTransactionListener;
        return transaction;
    }

    private void recycleTransaction(Transaction transaction) {
        transaction.mParent = this.mTransactionPool;
        transaction.mListener = null;
        this.mTransactionPool = transaction;
    }
}
