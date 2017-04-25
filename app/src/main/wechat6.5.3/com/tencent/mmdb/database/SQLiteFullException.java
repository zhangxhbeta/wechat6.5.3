package com.tencent.mmdb.database;

public class SQLiteFullException extends SQLiteException {
    public SQLiteFullException(String str) {
        super(str);
    }
}
