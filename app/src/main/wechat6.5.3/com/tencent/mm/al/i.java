package com.tencent.mm.al;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.m;

public final class i implements e {
    public i() {
        ak.vy().a(159, (e) this);
        ak.vy().a(160, (e) this);
        ak.vy().a(new k(5), 0);
    }

    private void release() {
        ak.vy().b(159, (e) this);
        ak.vy().b(160, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof m) && ((m) kVar).BI() == 5) {
            int type = kVar.getType();
            if (type == 159) {
                if (i == 0 && i2 == 0) {
                    HM();
                    m[] fU = t.HS().fU(5);
                    if (fU == null || fU.length == 0) {
                        v.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    m mVar = fU[0];
                    v.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.cUv);
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    ak.vy().a(new j(mVar.id, 5), 0);
                    return;
                }
                release();
                return;
            } else if (type == 160) {
                if (i == 0 && i2 == 0) {
                    HM();
                }
                release();
                return;
            } else {
                return;
            }
        }
        v.d("MicroMsg.LangPackageUpdater", "another scene");
    }

    private static void HM() {
        ak.yW();
        c.vf().set(81939, Long.valueOf(be.Ni()));
    }
}
