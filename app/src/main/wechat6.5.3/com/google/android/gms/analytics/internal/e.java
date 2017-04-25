package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.b;

@Deprecated
public final class e {
    private static volatile b afT = new ad();

    public static void c(String str, Object obj) {
        Object obj2 = null;
        f hu = f.hu();
        if (hu != null) {
            hu.g(str, obj);
        } else {
            if (afT != null && afT.getLogLevel() <= 3) {
                obj2 = 1;
            }
            if (obj2 != null) {
                if (obj != null) {
                    new StringBuilder().append(str).append(":").append(obj);
                }
                aj.aie.get();
            }
        }
        b bVar = afT;
    }

    public static b ht() {
        return afT;
    }
}
