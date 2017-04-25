package com.tencent.mm.plugin.appbrand.l.b;

import com.tencent.mm.plugin.appbrand.l.b.a.b;
import com.tencent.mm.plugin.appbrand.l.e.a;

public final class c extends b {
    public final b a(a aVar) {
        if (b.d(aVar) == 13) {
            return b.MATCHED;
        }
        return b.NOT_MATCHED;
    }

    public final com.tencent.mm.plugin.appbrand.l.e.b a(com.tencent.mm.plugin.appbrand.l.e.b bVar) {
        super.a(bVar);
        bVar.put("Sec-WebSocket-Version", "13");
        return bVar;
    }

    public final a Sx() {
        return new c();
    }
}
