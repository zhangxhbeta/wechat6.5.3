package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.vending.g.b;

public final class a extends com.tencent.mm.vending.app.a {
    int dsY = 0;

    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.v.a.a<v>> {
        final /* synthetic */ b dsZ;
        final /* synthetic */ a dta;

        AnonymousClass1(a aVar, b bVar) {
            this.dta = aVar;
            this.dsZ = bVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.v.a.a aVar = (com.tencent.mm.v.a.a) obj;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                v vVar = (v) aVar.bra;
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(vVar.hKq), vVar.hKr});
                if (vVar.hKq == 0) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish get success, return record size: %s", new Object[]{Integer.valueOf(vVar.lZg.size())});
                    a aVar2 = this.dta;
                    aVar2.dsY = vVar.lZg.size() + aVar2.dsY;
                    this.dsZ.r(new Object[]{vVar.lZg, vVar.lZh});
                    g.iuh.a(407, 30, 1, false);
                } else if (vVar.hKq <= 0 || !be.kS(vVar.hKr)) {
                    this.dsZ.bo(Boolean.valueOf(false));
                    g.iuh.a(407, 32, 1, false);
                } else {
                    this.dsZ.bo(vVar.hKr);
                    g.iuh.a(407, 32, 1, false);
                }
            } else {
                this.dsZ.bo(Boolean.valueOf(false));
                g.iuh.a(407, 31, 1, false);
            }
            return phb;
        }
    }

    protected final void onCreate() {
        super.onCreate();
    }
}
