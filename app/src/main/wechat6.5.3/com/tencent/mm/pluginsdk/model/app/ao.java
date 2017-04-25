package com.tencent.mm.pluginsdk.model.app;

import android.net.Uri;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ao {
    public static ao lBK = null;
    public static long lBL = -1;
    public int aJW = -1;
    public String lBI = SQLiteDatabase.KeyEmpty;
    public String[] lBJ = null;
    public String[] projection = null;
    public String selection = SQLiteDatabase.KeyEmpty;
    public String[] selectionArgs = null;
    public Uri uri = null;

    public ao(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        this.uri = uri;
        this.projection = strArr;
        this.selection = str;
        this.selectionArgs = strArr2;
        this.lBI = str2;
        this.aJW = i;
        this.lBJ = strArr3;
    }
}
