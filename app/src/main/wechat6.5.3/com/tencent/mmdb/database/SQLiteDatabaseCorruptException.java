package com.tencent.mmdb.database;

public class SQLiteDatabaseCorruptException extends SQLiteException {
    public SQLiteDatabaseCorruptException(String str) {
        super(str);
    }
}
