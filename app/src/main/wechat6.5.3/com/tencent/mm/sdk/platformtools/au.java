package com.tencent.mm.sdk.platformtools;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class au {
    public static String U(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~SEMI_XML~");
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 != null) {
                int length = str.length();
                int length2 = str2.length();
                stringBuilder.append((char) (length >> 16)).append((char) length).append(str);
                stringBuilder.append((char) (length2 >> 16)).append((char) length2).append(str2);
            }
        }
        return stringBuilder.toString();
    }

    public static Map<String, String> Ks(String str) {
        if (str == null || !str.startsWith("~SEMI_XML~")) {
            return null;
        }
        String substring = str.substring(10);
        Map<String, String> hashMap = new HashMap();
        int length = substring.length() - 4;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            try {
                int i3 = i2 + 1;
                i = ((substring.charAt(i) << 16) + substring.charAt(i2)) + i3;
                String substring2 = substring.substring(i3, i);
                i3 = i + 1;
                int i4 = i3 + 1;
                i = ((substring.charAt(i) << 16) + substring.charAt(i3)) + i4;
                hashMap.put(substring2, substring.substring(i4, i));
            } catch (Throwable e) {
                v.a("MicroMsg.SemiXml", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return hashMap;
            }
        }
        return hashMap;
    }
}
