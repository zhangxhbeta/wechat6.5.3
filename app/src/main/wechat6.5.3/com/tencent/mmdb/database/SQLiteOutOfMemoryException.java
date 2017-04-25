package com.tencent.mmdb.database;

public class SQLiteOutOfMemoryException extends SQLiteException {
    public SQLiteOutOfMemoryException(String str) {
        super(str);
    }
}
