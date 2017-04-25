package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.k.a.b.c;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.m;
import com.tencent.mm.pluginsdk.k.a.c.n.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class d extends a<c> {
    public d(c cVar) {
        super(cVar);
    }

    public final String Pa() {
        return "CheckResUpdate";
    }

    public final boolean dw(long j) {
        if (((c) this.lEi).fileSize <= 0 || ((c) this.lEi).fileSize == com.tencent.mm.pluginsdk.k.a.d.a.Hj(OZ()) + j) {
            return super.dw(j);
        }
        return false;
    }

    public final boolean Pg() {
        if (super.Pg()) {
            j.q(((c) this.lEi).lCW, 12);
            return true;
        }
        j.q(((c) this.lEi).lCW, 27);
        return false;
    }

    protected final m a(k kVar) {
        l lVar = (c) this.lEi;
        String OZ = lVar.OZ();
        String str = lVar.aZy;
        if (lVar.ldv && be.ma(g.aX(lVar.OZ())).equals(str)) {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
            return new m(lVar, com.tencent.mm.pluginsdk.k.a.d.a.Hj(OZ));
        } else if (!be.bl(((c) this.lEi).lDt) && com.tencent.mm.pluginsdk.k.a.d.a.t(((c) this.lEi).OZ(), ((c) this.lEi).lDt) && be.ma(g.aX(((c) this.lEi).OZ())).equals(((c) this.lEi).aZy)) {
            return new m((l) this.lEi, com.tencent.mm.pluginsdk.k.a.d.a.Hj(((c) this.lEi).OZ()));
        } else {
            m a = super.a(kVar);
            v.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = " + a, lVar.lCO);
            if (a.status == 2) {
                if (be.kS(((c) this.lEi).aZy) || !((c) this.lEi).aZy.equals(g.aX(OZ()))) {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", lVar.lCO);
                    return new m("CheckResUpdate", bnQ(), getURL(), OZ(), a.bsM, a.bsL, new c());
                }
                v.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", lVar.lCO);
            }
            return a;
        }
    }
}
