package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.oi;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class j extends c<oi> {
    public j() {
        this.nhz = oi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oi oiVar = (oi) bVar;
        if (oiVar instanceof oi) {
            oiVar.bpo.aYN = a.a(oiVar.bpn.bpq, oiVar.bpn.url, oiVar.bpn.bpp);
            return true;
        }
        v.f("MicroMsg.SnsfillEventInfoListener", "mismatched event");
        return false;
    }
}
