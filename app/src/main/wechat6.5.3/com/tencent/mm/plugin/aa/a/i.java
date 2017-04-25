package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.aa.a.a.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class i implements e {
    long bao = -1;
    b czg;

    public final void init() {
        ak.vy().a(1530, this);
    }

    public final void Ny() {
        ak.vy().b(1530, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            com.tencent.mm.protocal.c.e eVar = ((d) kVar).dsM;
            v.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[]{Integer.valueOf(eVar.hKq)});
            v.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[]{eVar.lYy});
            if (eVar.hKq == 0) {
                g.a(this.czg, new Object[]{Boolean.valueOf(true)});
                if (!be.kS(eVar.lYy) && this.bao > 0 && ((d) kVar).scene == a.drW) {
                    h.e(this.bao, eVar.lYy);
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 21, 1, false);
                return;
            } else if (eVar.hKq <= 0 || be.kS(eVar.hKr)) {
                this.czg.bo(Boolean.valueOf(false));
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 23, 1, false);
                return;
            } else {
                this.czg.bo(eVar.hKr);
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 11, 1, false);
                return;
            }
        }
        this.czg.bo(Boolean.valueOf(false));
        com.tencent.mm.plugin.report.service.g.iuh.a(407, 22, 1, false);
    }
}
