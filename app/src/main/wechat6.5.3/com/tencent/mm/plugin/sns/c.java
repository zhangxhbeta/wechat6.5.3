package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.gp;
import com.tencent.mm.e.a.lx;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.o;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awb;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class c extends com.tencent.mm.sdk.c.c<gp> implements e {
    private int jaA;
    private awa jaB;
    private k jaC;
    private ah jaD;

    public c() {
        this.nhz = gp.class.getName().hashCode();
    }

    private boolean a(gp gpVar) {
        if (gpVar instanceof gp) {
            this.jaA = gpVar.bge.bcm;
            this.jaC = ad.aSE().qG(this.jaA);
            this.jaB = com.tencent.mm.plugin.sns.e.ah.m(this.jaC);
            if (this.jaB == null || ((this.jaB.mTr != 3 || this.jaB.mTw == null || this.jaB.mTw.size() <= 0) && (this.jaB.mTr != 5 || this.jaB.mIw == null || this.jaB.mIw.size() <= 0))) {
                o oVar = new o(this.jaC.field_snsId);
                ((awb) oVar.cif.czk.czs).mTA = 1;
                ak.vy().a(210, this);
                ak.vy().a(oVar, 0);
                this.jaD = new ah(new a(this) {
                    final /* synthetic */ c jaE;

                    {
                        this.jaE = r1;
                    }

                    public final boolean oU() {
                        lx lxVar = new lx();
                        lxVar.bnc.bgg = null;
                        com.tencent.mm.sdk.c.a.nhr.z(lxVar);
                        return false;
                    }
                }, false);
                this.jaD.ea(10000);
                return true;
            }
            gpVar.bgf.bgg = this.jaB;
            return true;
        }
        v.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.jaD.QI();
        if (i == 0 && i2 == 0) {
            k dd = ad.aSE().dd(this.jaC.field_snsId);
            lx lxVar = new lx();
            lxVar.bnc.bgg = com.tencent.mm.plugin.sns.e.ah.m(dd);
            com.tencent.mm.sdk.c.a.nhr.z(lxVar);
            return;
        }
        lx lxVar2 = new lx();
        lxVar2.bnc.bgg = null;
        com.tencent.mm.sdk.c.a.nhr.z(lxVar2);
    }
}
