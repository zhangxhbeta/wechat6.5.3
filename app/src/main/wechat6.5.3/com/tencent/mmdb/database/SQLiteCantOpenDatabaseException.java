package com.tencent.mmdb.database;

public class SQLiteCantOpenDatabaseException extends SQLiteException {
    public SQLiteCantOpenDatabaseException(String str) {
        super(str);
    }
}
