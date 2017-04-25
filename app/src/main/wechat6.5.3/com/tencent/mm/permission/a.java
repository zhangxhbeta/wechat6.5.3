package com.tencent.mm.permission;

import com.tencent.mm.al.j;
import com.tencent.mm.al.k;
import com.tencent.mm.al.t;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.m;

public final class a implements e {
    private static a dot;
    private boolean dou = false;
    private int dov = 3;

    public static a MQ() {
        if (dot == null) {
            dot = new a();
        }
        return dot;
    }

    public final void MR() {
        if (ak.uz()) {
            if (!this.dou) {
                ak.yW();
                if (c.isSDCardAvailable()) {
                    ak.yW();
                    if (be.Ni() - ((Long) c.vf().get(327944, Long.valueOf(0))).longValue() >= 86400000) {
                        release();
                        this.dou = true;
                        ak.vy().a(new k(23), 0);
                        ak.vy().a(159, (e) this);
                        ak.vy().a(160, (e) this);
                        return;
                    }
                    return;
                }
            }
            v.e("MicroMsg.PermissionConfigUpdater", "not to update, isUpdating: %s", Boolean.valueOf(this.dou));
        }
    }

    private void release() {
        this.dou = false;
        ak.vy().b(159, (e) this);
        ak.vy().b(160, (e) this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if ((kVar instanceof m) && ((m) kVar).BI() == 23) {
            int type = kVar.getType();
            if (159 == type) {
                if (i == 0 && i2 == 0) {
                    HM();
                    com.tencent.mm.al.m[] fU = t.HS().fU(23);
                    if (fU == null || fU.length == 0) {
                        v.i("MicroMsg.PermissionConfigUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    com.tencent.mm.al.m mVar = fU[0];
                    v.i("MicroMsg.PermissionConfigUpdater", "permission, pkgId: %d, version: %d, status: %d, type: %d", Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), Integer.valueOf(mVar.cUv));
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    ak.vy().a(new j(mVar.id, 23), 0);
                    return;
                }
                type = this.dov - 1;
                this.dov = type;
                if (type <= 0) {
                    if (ak.uz()) {
                        ak.yW();
                        c.vf().set(327944, Long.valueOf((be.Ni() - 86400000) + 3600000));
                    }
                    this.dov = 3;
                }
                release();
                return;
            } else if (160 == type) {
                if (i == 0 && i2 == 0) {
                    HM();
                }
                release();
                return;
            } else {
                return;
            }
        }
        v.d("MicroMsg.PermissionConfigUpdater", "another scene");
    }

    private static void HM() {
        if (ak.uz()) {
            ak.yW();
            c.vf().set(327944, Long.valueOf(be.Ni()));
        }
    }
}
