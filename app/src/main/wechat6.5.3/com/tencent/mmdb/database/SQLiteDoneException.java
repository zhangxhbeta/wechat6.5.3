package com.tencent.mmdb.database;

public class SQLiteDoneException extends SQLiteException {
    public SQLiteDoneException(String str) {
        super(str);
    }
}
