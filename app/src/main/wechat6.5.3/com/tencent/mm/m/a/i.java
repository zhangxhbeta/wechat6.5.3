package com.tencent.mm.m.a;

import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDatabaseCorruptException;
import com.tencent.mmdb.database.SQLiteException;
import com.tencent.mmdb.database.SQLiteProgram;
import com.tencent.mmdb.support.CancellationSignal;
import com.tencent.mmdb.support.Log;

public final class i extends SQLiteProgram {
    private final CancellationSignal mCancellationSignal;

    final int a(b bVar, int i, int i2, c cVar) {
        acquireReference();
        if (bVar != null) {
            try {
                bVar.acquireReference();
            } catch (Throwable th) {
                releaseReference();
            }
        }
        try {
            int executeForCursorWindow = getSession().executeForCursorWindow(getSql(), getBindArgs(), getConnectionFlags(), i, i2, bVar, cVar);
            if (bVar != null) {
                bVar.releaseReference();
            }
            releaseReference();
            return executeForCursorWindow;
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (SQLiteException e2) {
            Log.e("MMDB.SQLiteQuery", "exception: " + e2.getMessage() + "; query: " + getSql());
            throw e2;
        } catch (Throwable th2) {
            if (bVar != null) {
                bVar.releaseReference();
            }
        }
    }

    i(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, null, cancellationSignal);
        this.mCancellationSignal = cancellationSignal;
    }

    public final String toString() {
        return "SQLiteNewQuery: " + getSql();
    }
}
