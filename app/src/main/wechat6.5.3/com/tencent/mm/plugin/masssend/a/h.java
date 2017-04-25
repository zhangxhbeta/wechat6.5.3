package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d.a;
import java.util.HashMap;

public final class h implements ag {
    private static HashMap<Integer, c> bXq;
    private b hik = new b(this) {
        final /* synthetic */ h hjE;

        {
            this.hjE = r1;
        }

        public final void a(a aVar) {
            String a = m.a(aVar.czu.mbW);
            v.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:" + a);
            h.azg().wl(a);
            h.azg().azb();
            h.azg();
            c.ch(be.Ni());
        }
    };
    private b hjA;
    private c hjB;
    private i hjC = new i();
    private g hjD = new g();

    private static h aze() {
        h hVar = (h) ak.yP().fY("plugin.masssend");
        if (hVar != null) {
            return hVar;
        }
        hVar = new h();
        ak.yP().a("plugin.favorite", hVar);
        return hVar;
    }

    public static b azf() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aze().hjA == null) {
            h aze = aze();
            ak.yW();
            aze.hjA = new b(com.tencent.mm.model.c.wE());
        }
        return aze().hjA;
    }

    public static c azg() {
        if (aze().hjB == null) {
            aze().hjB = new c();
        }
        return aze().hjB;
    }

    public final void th() {
        ak.yU().b("masssendapp", this.hik, false);
        com.tencent.mm.sdk.c.a.nhr.f(this.hjC);
        com.tencent.mm.sdk.c.a.nhr.f(this.hjD);
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return b.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        ak.yU().a("masssendapp", this.hik, false);
        com.tencent.mm.sdk.c.a.nhr.e(this.hjC);
        com.tencent.mm.sdk.c.a.nhr.e(this.hjD);
    }

    public final void aH(boolean z) {
    }
}
