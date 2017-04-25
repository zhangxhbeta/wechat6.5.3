package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class f implements e {
    b dsa;
    boolean dso = false;

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.dso = false;
        if (i == 0 && i2 == 0) {
            o oVar = ((h) kVar).dsU;
            v.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(oVar.hKq), oVar.hKr});
            if (oVar.hKq == 0) {
                g.a(this.dsa, new Object[]{oVar});
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 9, 1, false);
                return;
            }
            if (this.dsa != null) {
                if (oVar.lYN.bkU == 1 && !be.kS(oVar.lYN.kMP) && !be.kS(oVar.lYN.hcm) && !be.kS(oVar.lYN.hcn) && !be.kS(oVar.lYN.bhe)) {
                    this.dsa.bo(oVar.lYN);
                } else if (oVar.hKq <= 0 || be.kS(oVar.hKr)) {
                    this.dsa.bo(Boolean.valueOf(false));
                } else {
                    this.dsa.bo(oVar.hKr);
                }
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(407, 11, 1, false);
            return;
        }
        if (this.dsa != null) {
            this.dsa.bo(Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.report.service.g.iuh.a(407, 10, 1, false);
    }
}
