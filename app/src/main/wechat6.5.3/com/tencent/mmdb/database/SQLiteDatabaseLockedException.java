package com.tencent.mmdb.database;

public class SQLiteDatabaseLockedException extends SQLiteException {
    public SQLiteDatabaseLockedException(String str) {
        super(str);
    }
}
