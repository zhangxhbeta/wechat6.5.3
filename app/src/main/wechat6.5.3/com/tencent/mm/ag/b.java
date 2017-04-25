package com.tencent.mm.ag;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gc;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private final com.tencent.mm.v.b cif;
    private e cii;

    public b(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.czn = new gc();
        aVar.czo = new gd();
        aVar.uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
        aVar.czm = 549;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        gc gcVar = (gc) this.cif.czk.czs;
        gcVar.meB = 1;
        gcVar.mgo = i;
        gcVar.mgp = str;
        gcVar.mgq = str2;
        gcVar.mgr = str3;
        gcVar.mgs = str4;
        gcVar.mgt = str5;
        gcVar.mgu = str6;
        gcVar.mgv = str7;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 549;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        gc gcVar = (gc) this.cif.czk.czs;
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            c.vf().set(286722, gcVar.mgq);
            ak.yW();
            c.vf().set(286721, gcVar.mgp);
            ak.yW();
            c.vf().set(286723, gcVar.mgr);
        }
        this.cii.a(i2, i3, str, this);
    }
}
