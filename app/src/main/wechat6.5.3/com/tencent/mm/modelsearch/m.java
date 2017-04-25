package com.tencent.mm.modelsearch;

import android.database.Cursor;
import com.tencent.mmdb.database.SQLiteStatement;

public interface m {
    boolean aP(int i, int i2);

    void beginTransaction();

    void commit();

    SQLiteStatement compileStatement(String str);

    long e(long j, long j2);

    void execSQL(String str);

    void execSQL(String str, Object[] objArr);

    void f(long j, long j2);

    boolean inTransaction();

    boolean jH(String str);

    Cursor rawQuery(String str, String[] strArr);
}
