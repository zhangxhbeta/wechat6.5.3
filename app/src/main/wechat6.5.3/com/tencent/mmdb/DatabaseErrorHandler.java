package com.tencent.mmdb;

import com.tencent.mmdb.database.SQLiteDatabase;

public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase sQLiteDatabase);
}
