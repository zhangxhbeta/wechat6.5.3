package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f {
    public static boolean jW(String str) {
        if (str.lastIndexOf(";?enc=") > 0) {
            return true;
        }
        return false;
    }

    public static String j(String str, long j) {
        if (j == 0) {
            return String.format(str + ";?enc=%d", new Object[]{Long.valueOf(314159265)});
        }
        return String.format(str + ";?enc=%d", new Object[]{Long.valueOf(j)});
    }

    public static String jX(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static long jY(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return be.KM(str.substring(lastIndexOf + 6));
        }
        return 0;
    }

    public static String jZ(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return str.substring(lastIndexOf + 6).trim();
        }
        return SQLiteDatabase.KeyEmpty;
    }
}
