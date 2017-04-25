package com.tencent.mm.plugin.sns.d;

import com.tencent.mm.e.a.nr;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;

public final class a implements b {
    public c jeg = new c<nr>(this) {
        final /* synthetic */ a jeh;

        {
            this.jeh = r2;
            this.nhz = nr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            nr nrVar = (nr) bVar;
            if (nrVar instanceof nr) {
                if (nrVar.boK.aYt == 1) {
                    v.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "start do download id %s", new Object[]{nrVar.boK.boL.gID});
                    e eVar = new e(nrVar.boK.boL);
                    eVar.jdO = 1;
                    eVar.jdN = nrVar.boK.boL.gID;
                    if (nrVar.boK.boL.efm == 6) {
                        ad.aSz().a(nrVar.boK.boL, 5, eVar, ak.nvz);
                    } else {
                        ad.aSz().a(nrVar.boK.boL, 1, eVar, ak.nvz);
                    }
                } else if (nrVar.boK.aYt == 3) {
                    String cA = al.cA(ad.xh(), nrVar.boK.mediaId);
                    String zK = i.zK(nrVar.boK.mediaId);
                    nrVar.boK.path = cA + zK;
                }
            }
            return false;
        }
    };

    public a() {
        com.tencent.mm.sdk.c.a.nhr.e(this.jeg);
        ad.aSz().a((b) this);
    }

    public final void Aa(String str) {
        v.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[]{str});
        nr nrVar = new nr();
        nrVar.boK.aYt = 2;
        nrVar.boK.mediaId = str;
        String cA = al.cA(ad.xh(), str);
        nrVar.boK.path = cA + i.zK(str);
        com.tencent.mm.sdk.c.a.nhr.z(nrVar);
    }

    public final void ai(String str, boolean z) {
    }

    public final void aRc() {
    }

    public final void aj(String str, boolean z) {
    }
}
