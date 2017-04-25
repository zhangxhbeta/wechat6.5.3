package com.tencent.mmdb.database;

public class SQLiteTableLockedException extends SQLiteException {
    public SQLiteTableLockedException(String str) {
        super(str);
    }
}
