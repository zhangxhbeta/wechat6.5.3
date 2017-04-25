package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.e.a.qx;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.b.k.f;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.i.a;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ae implements e {
    c bYn = new c<qx>(this) {
        final /* synthetic */ ae fvl;

        {
            this.fvl = r2;
            this.nhz = qx.class.getName().hashCode();
        }

        private boolean a(final qx qxVar) {
            boolean z = true;
            if (qxVar instanceof qx) {
                switch (qxVar.bsC.aYt) {
                    case 1:
                        v.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[]{qxVar.bsC.aRh});
                        i.fuj.a(aa.getContext(), new a(this) {
                            final /* synthetic */ AnonymousClass1 fvn;

                            public final void cN(boolean z) {
                                if (z) {
                                    ae.U(qxVar.bsC.aRh, true);
                                    return;
                                }
                                v.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[]{qxVar.bsC.aRh, qxVar.bsC.aZN});
                                ae.U(qxVar.bsC.aRh, false);
                            }
                        });
                        break;
                    case 3:
                        b sq = ac.ajq().sq(qxVar.bsC.aRh);
                        qx.a aVar = qxVar.bsC;
                        if (sq == null) {
                            z = false;
                        }
                        aVar.bbq = z;
                        break;
                    case 4:
                        v.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[]{qxVar.bsC.aRh});
                        ak.vy().a(538, this.fvl);
                        ak.vy().a(new w(0, qxVar.bsC.aZN, qxVar.bsC.aRh, f.aiz(), be.Ni(), qxVar.bsC.data, 1), 0);
                        break;
                    case 7:
                        ak.vy().a(541, this.fvl);
                        ak.vy().a(new r("AndroidWear", qxVar.bsC.aZN, qxVar.bsC.aRh, 1, new byte[0]), 0);
                        break;
                    case 11:
                        if (!be.aZ(aa.getContext(), aa.getPackageName() + ":exdevice")) {
                            d.bE(aa.getContext());
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };

    static /* synthetic */ void U(String str, boolean z) {
        v.i("MicroMsg.WearHardDeviceLogic", "publish register response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        qx qxVar = new qx();
        qxVar.bsC.aYt = 2;
        qxVar.bsC.bbq = z;
        qxVar.bsC.aRh = str;
        com.tencent.mm.sdk.c.a.nhr.z(qxVar);
    }

    public ae() {
        com.tencent.mm.sdk.c.a.nhr.e(this.bYn);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof r) {
            ak.vy().b(541, this);
            r rVar = (r) kVar;
            if (i == 0 && i2 == 0) {
                S(rVar.fuA, true);
            } else {
                S(rVar.fuA, false);
            }
        } else if (kVar instanceof w) {
            ak.vy().b(538, this);
            w wVar = (w) kVar;
            if (i == 0 && i2 == 0) {
                T(wVar.fuC, true);
            } else {
                T(wVar.fuC, false);
            }
        }
    }

    private static void S(String str, boolean z) {
        v.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        qx qxVar = new qx();
        qxVar.bsC.aYt = 8;
        qxVar.bsC.bbq = z;
        qxVar.bsC.aRh = str;
        com.tencent.mm.sdk.c.a.nhr.z(qxVar);
    }

    private static void T(String str, boolean z) {
        v.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        qx qxVar = new qx();
        qxVar.bsC.aYt = 5;
        qxVar.bsC.bbq = z;
        qxVar.bsC.aRh = str;
        com.tencent.mm.sdk.c.a.nhr.z(qxVar);
    }
}
