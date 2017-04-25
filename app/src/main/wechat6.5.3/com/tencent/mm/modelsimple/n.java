package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class n extends k implements j {
    public String bCk;
    public String bCl;
    public String cJg;
    private b cif;
    private e cii;

    public n(double d, double d2) {
        a aVar = new a();
        aVar.czn = new vg();
        aVar.czo = new vh();
        aVar.uri = "/cgi-bin/micromsg-bin/getcurlocation";
        this.cif = aVar.Bv();
        vg vgVar = (vg) this.cif.czk.czs;
        vgVar.mhZ = d;
        vgVar.mhY = d2;
        v.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + d + ", longitude:" + d2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 665;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            vh vhVar = (vh) this.cif.czl.czs;
            this.bCl = vhVar.cHe;
            this.cJg = vhVar.cHl;
            this.bCk = vhVar.cHd;
        }
        this.cii.a(i2, i3, str, this);
    }
}
