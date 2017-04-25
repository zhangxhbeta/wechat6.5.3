package com.tencent.wework.api;

import android.content.Context;
import com.tencent.mmdb.database.SQLiteDatabase;

public class WWAPIFactory {
    public static IWWAPI gC(Context context) {
        new StringBuilder("createWXAPI, appId = ").append(SQLiteDatabase.KeyEmpty).append(", checkSignature = false");
        return new WWAPIImpl(context);
    }
}
