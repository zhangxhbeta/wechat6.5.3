package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.a.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public final class h {
    private static String JW(String str) {
        if (!be.kS(str) && str.length() > 4) {
            return str.substring(0, 2) + "/" + str.substring(2, 4) + "/";
        }
        return null;
    }

    public static boolean JX(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                file = new File(str + ".nomedia");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Throwable e) {
                        v.a("MicroMsg.FilePathGenerator", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static String a(String str, String str2, String str3, String str4, int i, boolean z) {
        if (be.kS(str) || !str.endsWith("/")) {
            return null;
        }
        String str5 = SQLiteDatabase.KeyEmpty;
        if (i == 1) {
            str5 = JW(str3);
        } else if (i == 2) {
            str5 = be.kS(str3) ? null : JW(g.m(str3.getBytes()));
        }
        if (be.kS(str5)) {
            return null;
        }
        str5 = str + str5;
        if (!z || JX(str5)) {
            return str5 + be.ma(str2) + str3 + be.ma(str4);
        }
        return null;
    }

    public static String b(String str, String str2, String str3, String str4, int i) {
        return a(str, str2, str3, str4, i, true);
    }

    public static String a(String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        String str6 = str + str3 + str4 + str5;
        String a = a(str2, str3, str4, str5, 1, z);
        if (be.kS(str6) || be.kS(a)) {
            return null;
        }
        File file = new File(a);
        File file2 = new File(str6);
        if (file.exists() || !file2.exists()) {
            return a;
        }
        j.n(str6, a, false);
        return a;
    }

    public static String e(String str, String str2, String str3, String str4, String str5) {
        return a(str, str2, str3, str4, str5, 1, true);
    }
}
