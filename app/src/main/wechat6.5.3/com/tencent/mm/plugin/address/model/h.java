package com.tencent.mm.plugin.address.model;

import com.tencent.mm.e.a.kk;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends c<kk> implements e {
    private kk dxm;
    private BizInfo dxn;

    public h() {
        this.nhz = kk.class.getName().hashCode();
    }

    private boolean a(kk kkVar) {
        if (kkVar instanceof kk) {
            this.dxm = kkVar;
            ak.vy().a(417, this);
            ak.vy().a(new c(this.dxm.bly.url, this.dxm.bly.appId, 1), 0);
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(kVar instanceof c)) {
            return;
        }
        if (i2 == 0) {
            x(i2, true);
        } else {
            x(i2, false);
        }
    }

    private void x(int i, boolean z) {
        v.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        this.dxm.blz.errCode = i;
        if (i != 0) {
            this.dxm.blz.blA = false;
        } else if (z) {
            r0 = this.dxn;
            if (r0 != null) {
                r0.field_brandFlag |= 8;
                com.tencent.mm.modelbiz.e.g(r0);
            }
            this.dxm.blz.blA = true;
            a.Op();
            com.tencent.mm.plugin.address.c.a aVar = a.Oq().dxq;
            if (aVar.dxB.size() > 0) {
                b bVar = (b) aVar.dxB.getFirst();
                this.dxm.blz.blB = bVar.dxK;
                this.dxm.blz.userName = bVar.dxI;
                this.dxm.blz.blC = bVar.dxJ;
                this.dxm.blz.blD = bVar.dxG;
                this.dxm.blz.blE = bVar.dxD;
                this.dxm.blz.blF = bVar.dxE;
                this.dxm.blz.blG = bVar.dxF;
                this.dxm.blz.blH = bVar.dxH;
            }
        } else {
            r0 = this.dxn;
            if (r0 != null) {
                r0.field_brandFlag &= -9;
                com.tencent.mm.modelbiz.e.g(r0);
            }
            this.dxm.blz.blA = false;
        }
        if (this.dxm.bpT != null) {
            this.dxm.bpT.run();
        }
        ak.vy().b(417, this);
    }
}
