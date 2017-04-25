package com.tencent.mm.plugin.wear.a;

import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    public static final boolean DP(String str) {
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            return false;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 3 || !"wear".equals(split[2])) {
            return false;
        }
        return true;
    }
}
