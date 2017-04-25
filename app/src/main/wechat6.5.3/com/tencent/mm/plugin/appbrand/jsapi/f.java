package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.be;
import java.util.Map;

final class f {
    static Map<String, d> dEZ;
    static Map<String, d> dFa;

    static void a(d dVar) {
        if (!be.kS(dVar.getName())) {
            dEZ.put(dVar.getName(), dVar);
        }
    }

    static void b(d dVar) {
        if (!be.kS(dVar.getName())) {
            dFa.put(dVar.getName(), dVar);
        }
    }
}
