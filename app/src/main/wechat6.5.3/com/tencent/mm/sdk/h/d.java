package com.tencent.mm.sdk.h;

import android.content.ContentValues;
import android.database.Cursor;

public interface d {
    Cursor aH(String str, boolean z);

    boolean buA();

    boolean dF(String str, String str2);

    int delete(String str, String str2, String[] strArr);

    long insert(String str, String str2, ContentValues contentValues);

    Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5);

    Cursor rawQuery(String str, String[] strArr);

    long replace(String str, String str2, ContentValues contentValues);

    int update(String str, ContentValues contentValues, String str2, String[] strArr);
}
