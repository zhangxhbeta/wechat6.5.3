package com.tencent.mmdb.database;

public class SQLiteConstraintException extends SQLiteException {
    public SQLiteConstraintException(String str) {
        super(str);
    }
}
