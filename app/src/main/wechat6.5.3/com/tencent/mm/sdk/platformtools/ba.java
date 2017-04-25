package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;

public final class ba {
    private static final HashMap<String, String> nlt = new HashMap();

    public static String getProperty(String str) {
        return (String) nlt.get(str);
    }

    public static void setProperty(String str, String str2) {
        nlt.put(str, str2);
    }
}
