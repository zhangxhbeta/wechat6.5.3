package com.tencent.mm.al;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.m;

public final class s implements e {
    private static s cUw;
    private int cTV = 3;
    private boolean cwY = false;

    public static s HQ() {
        if (cUw == null) {
            cUw = new s();
        }
        return cUw;
    }

    public final void update() {
        if (!this.cwY) {
            ak.yW();
            if (c.isSDCardAvailable()) {
                release();
                this.cwY = true;
                ak.vy().a(159, (e) this);
                ak.vy().a(160, (e) this);
                ak.vy().a(new k(8), 0);
            }
        }
    }

    private void release() {
        this.cwY = false;
        ak.vy().b(159, (e) this);
        ak.vy().b(160, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof m) && ((m) kVar).BI() == 8) {
            int type = kVar.getType();
            if (type == 159) {
                if (i == 0 && i2 == 0) {
                    HM();
                    m[] fU = t.HS().fU(8);
                    if (fU == null || fU.length == 0) {
                        v.i("MicroMsg.RegionCodeUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    m mVar = fU[0];
                    v.i("MicroMsg.RegionCodeUpdater", "dkregcode Pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.cUv);
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    ak.vy().a(new j(mVar.id, 8), 0);
                    return;
                }
                type = this.cTV - 1;
                this.cTV = type;
                if (type <= 0) {
                    ak.yW();
                    c.vf().set(81937, Long.valueOf(((be.Ni() - 604800000) + 3600000) / 1000));
                    this.cTV = 3;
                }
                release();
                return;
            } else if (type == 160) {
                if (i == 0 && i2 == 0) {
                    HM();
                    RegionCodeDecoder.bxc().bvb();
                }
                release();
                return;
            } else {
                return;
            }
        }
        v.d("MicroMsg.RegionCodeUpdater", "another scene");
    }

    private static void HM() {
        ak.yW();
        c.vf().set(81937, Long.valueOf(be.Nh()));
    }
}
