package com.tencent.mmdb.database;

public class SQLiteBlobTooBigException extends SQLiteException {
    public SQLiteBlobTooBigException(String str) {
        super(str);
    }
}
