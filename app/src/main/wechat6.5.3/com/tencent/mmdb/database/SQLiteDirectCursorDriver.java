package com.tencent.mmdb.database;

import com.tencent.mmdb.Cursor;
import com.tencent.mmdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.mmdb.support.CancellationSignal;

public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteQuery mQuery;
    private final String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
        this.mCancellationSignal = cancellationSignal;
    }

    public final Cursor query(CursorFactory cursorFactory, String[] strArr) {
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, this.mCancellationSignal);
        try {
            Cursor sQLiteCursor;
            sQLiteQuery.bindAllArgsAsStrings(strArr);
            if (cursorFactory == null) {
                sQLiteCursor = new SQLiteCursor(this, this.mEditTable, sQLiteQuery);
            } else {
                sQLiteCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            }
            this.mQuery = sQLiteQuery;
            return sQLiteCursor;
        } catch (RuntimeException e) {
            sQLiteQuery.close();
            throw e;
        }
    }

    public final void cursorClosed() {
    }

    public final void setBindArguments(String[] strArr) {
        this.mQuery.bindAllArgsAsStrings(strArr);
    }

    public final void cursorDeactivated() {
    }

    public final void cursorRequeried(Cursor cursor) {
    }

    public final String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
