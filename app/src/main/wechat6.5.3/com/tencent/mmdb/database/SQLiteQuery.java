package com.tencent.mmdb.database;

import com.tencent.mmdb.CursorWindow;
import com.tencent.mmdb.support.CancellationSignal;
import com.tencent.mmdb.support.Log;

public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "MMDB.SQLiteQuery";
    private final CancellationSignal mCancellationSignal;

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, null, cancellationSignal);
        this.mCancellationSignal = cancellationSignal;
    }

    final int fillWindow(CursorWindow cursorWindow, int i, int i2, boolean z) {
        acquireReference();
        try {
            cursorWindow.acquireReference();
            try {
                int executeForCursorWindow = getSession().executeForCursorWindow(getSql(), getBindArgs(), cursorWindow, i, i2, z, getConnectionFlags(), this.mCancellationSignal);
                cursorWindow.releaseReference();
                return executeForCursorWindow;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (SQLiteException e2) {
                Log.e(TAG, "exception: " + e2.getMessage() + "; query: " + getSql());
                throw e2;
            } catch (Throwable th) {
                cursorWindow.releaseReference();
            }
        } finally {
            releaseReference();
        }
    }

    public final String toString() {
        return "SQLiteQuery: " + getSql();
    }
}
