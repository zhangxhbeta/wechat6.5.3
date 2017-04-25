package com.tencent.mm.al;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c implements e {
    private static c cTW;
    private int cTV = 3;
    private boolean cwY = false;

    public static c HL() {
        if (cTW == null) {
            cTW = new c();
        }
        return cTW;
    }

    public final void update() {
        v.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.cwY);
        StringBuilder stringBuilder = new StringBuilder("isSDCardAvailable : ");
        ak.yW();
        v.i("MicroMsg.ConfigListUpdater", stringBuilder.append(com.tencent.mm.model.c.isSDCardAvailable()).toString());
        if (!this.cwY) {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                release();
                this.cwY = true;
                ak.vy().a(159, (e) this);
                ak.vy().a(new k(7), 0);
            }
        }
    }

    private void release() {
        this.cwY = false;
        ak.vy().b(159, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 159) {
            v.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(81938, Long.valueOf(be.Nh()));
            } else {
                int i3 = this.cTV - 1;
                this.cTV = i3;
                if (i3 < 0) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(81938, Long.valueOf(((be.Ni() - 86400000) + 3600000) / 1000));
                    this.cTV = 3;
                }
            }
            release();
        }
    }
}
