package com.tencent.mm.m.a;

import com.tencent.mmdb.Cursor;
import com.tencent.mmdb.database.SQLiteCursorDriver;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.mmdb.support.CancellationSignal;

public final class f implements SQLiteCursorDriver {
    private i chI;
    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private final String mSql;

    public f(SQLiteDatabase sQLiteDatabase, String str, String str2, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
        this.mCancellationSignal = cancellationSignal;
    }

    public final Cursor query(CursorFactory cursorFactory, String[] strArr) {
        i iVar = new i(this.mDatabase, this.mSql, this.mCancellationSignal);
        try {
            iVar.bindAllArgsAsStrings(strArr);
            Cursor gVar = new g(this, this.mEditTable, iVar);
            this.chI = iVar;
            return gVar;
        } catch (RuntimeException e) {
            iVar.close();
            throw e;
        }
    }

    public final void cursorClosed() {
    }

    public final void setBindArguments(String[] strArr) {
        this.chI.bindAllArgsAsStrings(strArr);
    }

    public final void cursorDeactivated() {
    }

    public final void cursorRequeried(Cursor cursor) {
    }

    public final String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
