package com.tencent.pb.b.a;

import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.common.c.h;

public final class a {
    private static String TAG = "AccountEngine";
    private static int psY = 0;
    private static String psZ = SQLiteDatabase.KeyEmpty;

    public static String bMo() {
        return psZ;
    }

    public static void Qf(String str) {
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        psZ = str;
    }

    public static void yG(int i) {
        psY = i;
    }

    public static boolean bMp() {
        return !h.ty(psZ);
    }
}
