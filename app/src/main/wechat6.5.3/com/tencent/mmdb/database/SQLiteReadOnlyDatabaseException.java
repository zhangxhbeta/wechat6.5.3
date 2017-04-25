package com.tencent.mmdb.database;

public class SQLiteReadOnlyDatabaseException extends SQLiteException {
    public SQLiteReadOnlyDatabaseException(String str) {
        super(str);
    }
}
