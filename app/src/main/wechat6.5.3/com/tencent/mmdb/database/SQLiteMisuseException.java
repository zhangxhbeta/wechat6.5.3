package com.tencent.mmdb.database;

public class SQLiteMisuseException extends SQLiteException {
    public SQLiteMisuseException(String str) {
        super(str);
    }
}
