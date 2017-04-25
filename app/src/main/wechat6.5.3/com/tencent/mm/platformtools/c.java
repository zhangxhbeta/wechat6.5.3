package com.tencent.mm.platformtools;

import com.tencent.mmdb.database.SQLiteDatabase;

public final class c {
    public static String lT(String str) {
        if (str == null || SQLiteDatabase.KeyEmpty.equals(str.trim())) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char f : toCharArray) {
            String f2 = SpellMap.f(f);
            if (f2 != null) {
                stringBuffer.append(f2);
            }
        }
        return stringBuffer.toString();
    }

    public static String lU(String str) {
        if (str == null || SQLiteDatabase.KeyEmpty.equals(str.trim())) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = toCharArray.length;
        for (int i = 0; i < length; i++) {
            if (!Character.isSpace(toCharArray[i])) {
                String f = SpellMap.f(toCharArray[i]);
                if (f != null && f.length() > 0) {
                    stringBuffer.append(f.charAt(0));
                }
            }
        }
        return stringBuffer.toString().toUpperCase();
    }
}
