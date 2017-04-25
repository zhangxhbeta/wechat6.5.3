package com.tencent.mmdb.database;

import com.tencent.mmdb.Cursor;
import com.tencent.mmdb.database.SQLiteDatabase.CursorFactory;

public interface SQLiteCursorDriver {
    void cursorClosed();

    void cursorDeactivated();

    void cursorRequeried(Cursor cursor);

    Cursor query(CursorFactory cursorFactory, String[] strArr);

    void setBindArguments(String[] strArr);
}
