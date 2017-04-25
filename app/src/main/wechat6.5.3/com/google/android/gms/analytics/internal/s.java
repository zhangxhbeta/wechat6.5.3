package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class s {
    final Map<String, String> afL;
    final long agV = 0;
    final String agW;
    final String agX;
    final boolean agY;
    long agZ;

    public s(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        w.U(str);
        w.U(str2);
        this.agW = str;
        this.agX = str2;
        this.agY = z;
        this.agZ = j2;
        if (map != null) {
            this.afL = new HashMap(map);
        } else {
            this.afL = Collections.emptyMap();
        }
    }
}
