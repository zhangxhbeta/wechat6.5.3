package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.HashMap;
import java.util.Map;

public final class g extends af<g> {
    public final Map<String, Object> afL = new HashMap();

    public static String af(String str) {
        w.U(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        w.i(str, "Name can not be empty or \"&\"");
        return str;
    }

    public final /* synthetic */ void a(af afVar) {
        g gVar = (g) afVar;
        w.Z(gVar);
        gVar.afL.putAll(this.afL);
    }

    public final String toString() {
        return af.m(this.afL, 0);
    }
}
