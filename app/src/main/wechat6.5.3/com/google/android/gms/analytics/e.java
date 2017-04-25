package com.google.android.gms.analytics;

public final class e {
    static String e(String str, int i) {
        if (i > 0) {
            return str + i;
        }
        com.google.android.gms.analytics.internal.e.c("index out of range for prefix", str);
        return "";
    }
}
