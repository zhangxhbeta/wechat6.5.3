package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.Map;

public final class q {
    public static Map<String, String> Kb(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (String str2 : str.split("\n")) {
            if (str2 != null && str2.length() > 0) {
                String[] split = str2.trim().split("=", 2);
                if (split != null && split.length >= 2) {
                    String str3 = split[0];
                    Object obj = split[1];
                    if (str3 != null && str3.length() > 0 && str3.matches("^[a-zA-Z0-9_.]*")) {
                        hashMap.put(str3, obj);
                    }
                }
            }
        }
        return hashMap;
    }
}
