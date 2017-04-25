package com.google.android.gms.analytics.a;

import com.google.android.gms.c.af;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class b {
    public Map<String, String> afx;

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.afx.entrySet()) {
            if (((String) entry.getKey()).startsWith("&")) {
                hashMap.put(((String) entry.getKey()).substring(1), entry.getValue());
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return af.c(hashMap);
    }
}
