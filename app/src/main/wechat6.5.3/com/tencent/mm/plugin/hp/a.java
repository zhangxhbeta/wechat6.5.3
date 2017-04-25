package com.tencent.mm.plugin.hp;

import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.e.a.as;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class a implements i {
    private com.tencent.mm.plugin.hp.a.a gDT = new com.tencent.mm.plugin.hp.a.a();
    private c<as> gDU = new c<as>(this) {
        final /* synthetic */ a gDW;

        {
            this.gDW = r2;
            this.nhz = as.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            as asVar = (as) bVar;
            if (29 == asVar.aYs.aYo && asVar.aYs.aYt == 0) {
                v.d("Tinker.HotPatchApplication", "hp_res received new hotpatch cache request");
                com.tencent.mm.plugin.hp.a.b.du(false);
            }
            return false;
        }
    };
    private c<ar> gDV = new c<ar>(this) {
        final /* synthetic */ a gDW;

        {
            this.gDW = r2;
            this.nhz = ar.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ar arVar = (ar) bVar;
            if (29 == arVar.aYn.aYo && arVar.aYn.aYr) {
                v.d("Tinker.HotPatchApplication", "hp_res received new/updated download resource, path=%s", new Object[]{arVar.aYn.filePath});
                com.tencent.mm.plugin.hp.a.b.dv(false);
                com.tencent.mm.plugin.hp.a.a.uD(arVar.aYn.filePath);
            }
            return false;
        }
    };

    public a() {
        com.tencent.mm.plugin.hp.tinker.c.atG();
        com.tencent.mm.plugin.hp.tinker.c.atF();
        com.tencent.mm.plugin.hp.tinker.c.a(MMApplicationLike.getTinkerApplicationLike());
        com.tencent.mm.sdk.c.a.nhr.e(this.gDT);
        com.tencent.mm.sdk.c.a.nhr.e(this.gDV);
        com.tencent.mm.sdk.c.a.nhr.e(this.gDU);
    }

    public final void a(h hVar) {
    }

    public final void a(g gVar) {
    }
}
