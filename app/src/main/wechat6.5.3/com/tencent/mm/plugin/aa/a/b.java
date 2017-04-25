package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.vending.g.g;

public final class b implements e {
    com.tencent.mm.vending.g.b dsa;

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            t tVar = ((i) kVar).dsW;
            v.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", new Object[]{Integer.valueOf(tVar.hKq)});
            if (tVar.hKq == 0) {
                g.a(this.dsa, new Object[]{tVar});
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 6, 1, false);
                return;
            }
            if (tVar.hKq <= 0 || be.kS(tVar.hKr)) {
                this.dsa.bo(Boolean.valueOf(false));
            } else {
                this.dsa.bo(tVar.hKr);
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(407, 8, 1, false);
            return;
        }
        if (this.dsa != null) {
            this.dsa.bo(Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.report.service.g.iuh.a(407, 7, 1, false);
    }
}
