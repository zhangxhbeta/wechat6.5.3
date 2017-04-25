package com.tencent.mm.plugin.search.a;

import android.database.DatabaseUtils;
import java.util.Arrays;

public final class h {
    private static String[] cVU = new String[]{"wxid_", "wx_", "gh_"};

    public static String Y(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        for (String startsWith : cVU) {
            if (str.startsWith(startsWith)) {
                return null;
            }
        }
        if (str.indexOf(64) >= 0) {
            return null;
        }
        return str;
    }

    static String i(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('(');
        for (int append : iArr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    static String s(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append('(');
        for (String sqlEscapeString : strArr) {
            stringBuilder.append(DatabaseUtils.sqlEscapeString(sqlEscapeString) + ',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    public static boolean f(int[] iArr, int i) {
        return Arrays.binarySearch(iArr, i) >= 0;
    }
}
