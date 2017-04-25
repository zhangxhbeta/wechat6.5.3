package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.aa.a.c;
import com.tencent.mm.plugin.aa.a.g;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.protocal.c.q;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public class f extends a {
    c dtn = new c();
    g dto = new g();
    j dtp = new j();

    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.v.a.a<q>> {
        final /* synthetic */ b dsZ;
        final /* synthetic */ f dtq;

        AnonymousClass1(f fVar, b bVar) {
            this.dtq = fVar;
            this.dsZ = bVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.v.a.a aVar = (com.tencent.mm.v.a.a) obj;
            v.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (aVar.errType == 0 && aVar.errCode == 0) {
                q qVar = (q) aVar.bra;
                v.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(qVar.hKq), qVar.hKr});
                if (qVar.hKq == 0) {
                    v.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay success");
                    com.tencent.mm.plugin.aa.a.drq.ow();
                    this.dsZ.r(new Object[]{Boolean.valueOf(true)});
                    com.tencent.mm.plugin.report.service.g.iuh.a(407, 24, 1, false);
                } else {
                    if (qVar.hKq <= 0 || be.kS(qVar.hKr)) {
                        this.dsZ.bo(Boolean.valueOf(false));
                    } else {
                        this.dsZ.bo(qVar.hKr);
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.a(407, 26, 1, false);
                }
            } else {
                this.dsZ.bo(Boolean.valueOf(false));
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 25, 1, false);
            }
            return phb;
        }
    }

    protected final void onCreate() {
        super.onCreate();
        com.tencent.mm.plugin.aa.a.b Nq = this.dtn.Nq();
        v.i("MicroMsg.AAGetPaylistDetailLogic", "init");
        ak.vy().a(1695, Nq);
        ak.vy().a(1629, this.dto.Nx());
        this.dtp.Nz().init();
    }

    protected final void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.aa.a.b Nq = this.dtn.Nq();
        v.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
        ak.vy().b(1695, Nq);
        ak.vy().b(1629, this.dto.Nx());
        this.dtp.Nz().Ny();
    }
}
