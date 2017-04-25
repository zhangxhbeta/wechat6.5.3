package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.al.k;
import com.tencent.mm.al.m;
import com.tencent.mm.al.t;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.e;
import java.io.File;

public final class d implements e {
    private static d gED = null;
    private boolean cwY = false;
    c gEE = new c<bt>(this) {
        final /* synthetic */ d gEF;

        {
            this.gEF = r2;
            this.nhz = bt.class.getName().hashCode();
        }

        private boolean a(bt btVar) {
            if (btVar instanceof bt) {
                v.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
                ak.yW();
                int intValue = ((Integer) com.tencent.mm.model.c.vf().get(a.nqr, Integer.valueOf(0))).intValue();
                int i = j.sU().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
                v.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i)});
                if (intValue != i) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(a.nqr, Integer.valueOf(i));
                    t.HS().fT(26);
                    c atY = c.atY();
                    v.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", new Object[]{com.tencent.mm.compatible.util.e.cng + "ipcallCountryCodeConfig.cfg"});
                    try {
                        File file = new File(com.tencent.mm.compatible.util.e.cng + "ipcallCountryCodeConfig.cfg");
                        if (file.exists()) {
                            file.delete();
                        }
                        atY.isInit = false;
                        atY.gEC.clear();
                    } catch (Exception e) {
                        v.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", new Object[]{e.getMessage()});
                    }
                    this.gEF.dy(true);
                }
            }
            return false;
        }
    };
    private int retryCount = 0;

    private d() {
    }

    public static d auc() {
        if (gED == null) {
            gED = new d();
        }
        return gED;
    }

    public final void dy(boolean z) {
        if (!ak.uz()) {
            v.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
        } else if (this.cwY) {
            v.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
        } else {
            v.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                ak.yW();
                long longValue = ((Long) com.tencent.mm.model.c.vf().get(a.nqs, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue != 0 && Math.abs(currentTimeMillis - longValue) < 86400000) {
                    v.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
                    return;
                }
            }
            v.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
            this.cwY = true;
            ak.vy().a(159, this);
            ak.vy().a(160, this);
            aud();
        }
    }

    private static void aud() {
        boolean z;
        m[] fU = t.HS().fU(26);
        if (fU == null || fU.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        ak.vy().a(new k(z), 0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.cwY)});
        if (this.cwY) {
            boolean z;
            if (i == 0 || i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            v.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[]{Boolean.valueOf(z)});
            if (kVar.getType() == 159) {
                if (z) {
                    v.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
                    m[] fU = t.HS().fU(26);
                    if (fU == null || fU.length == 0) {
                        v.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
                        aue();
                        return;
                    }
                    v.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[]{Integer.valueOf(fU.length)});
                    m mVar = fU[0];
                    v.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[]{Integer.valueOf(mVar.cUv), Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), mVar.HN()});
                    if (mVar.status == 3) {
                        v.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
                    } else if (mVar.status != 5) {
                        v.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
                        c.atY().dx(true);
                        aue();
                    } else {
                        ak.vy().a(new com.tencent.mm.al.j(mVar.id, 26), 0);
                    }
                } else if (this.retryCount < 3) {
                    this.retryCount++;
                    aud();
                    v.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[]{Integer.valueOf(this.retryCount)});
                } else {
                    v.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
                }
            } else if (kVar.getType() == 160 && z) {
                v.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
                c.atY().dx(true);
                aue();
            }
        }
    }

    private void aue() {
        this.cwY = false;
        this.retryCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        com.tencent.mm.model.c.vf().a(a.nqs, Long.valueOf(currentTimeMillis));
    }
}
