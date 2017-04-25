package com.tencent.mmdb.database;

import com.tencent.mmdb.SQLException;

public class SQLiteException extends SQLException {
    public SQLiteException(String str) {
        super(str);
    }

    public SQLiteException(String str, Throwable th) {
        super(str, th);
    }
}
