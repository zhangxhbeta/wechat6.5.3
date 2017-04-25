package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.e.a.nd;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public enum a {
    ;
    
    public static final c<nd> dBB = null;

    static {
        dBB = new c<nd>() {
            {
                this.nhz = nd.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                boolean z;
                nd.b bVar2 = ((nd) bVar).dRM;
                if (ak.uz()) {
                    if (j.sU().getInt("WeAppForbiddenSwitch", 0) == 1) {
                        v.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
                    } else {
                        int i = -1;
                        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100163");
                        if (Ls.isValid()) {
                            i = be.getInt((String) Ls.buX().get("OpenWeAppEntranceType"), 0);
                        }
                        if (i <= 0 || i > 2) {
                            z = false;
                            bVar2.dRN = z;
                            return true;
                        }
                        if (i == 1) {
                            z = true;
                        } else if (com.tencent.mm.plugin.appbrand.a.a.dzS != null) {
                            c cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
                            c.Pq();
                            if (com.tencent.mm.plugin.appbrand.a.a.dzS.Pp()) {
                                z = true;
                            }
                        }
                        bVar2.dRN = z;
                        return true;
                    }
                }
                z = false;
                bVar2.dRN = z;
                return true;
            }
        };
    }
}
