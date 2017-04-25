package com.tencent.mm.ag;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bak;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private final b cif;
    private com.tencent.mm.v.e cii;

    public e() {
        a aVar = new a();
        aVar.czn = new bak();
        aVar.czo = new bal();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
        aVar.czm = 550;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((bak) this.cif.czk.czs).meB = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 550;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            c.vf().set(286722, "");
            ak.yW();
            c.vf().set(286721, "");
            ak.yW();
            c.vf().set(286723, "");
        }
        this.cii.a(i2, i3, str, this);
    }
}
