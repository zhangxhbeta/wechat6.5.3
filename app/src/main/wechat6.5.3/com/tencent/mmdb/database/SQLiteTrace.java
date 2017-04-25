package com.tencent.mmdb.database;

public interface SQLiteTrace {
    void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase);

    void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j);
}
