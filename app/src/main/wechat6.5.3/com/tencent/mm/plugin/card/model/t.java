package com.tencent.mm.plugin.card.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tx;
import com.tencent.mm.protocal.c.ty;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class t extends k implements j {
    private final b cif;
    private e cii;
    private String eDy = "";

    public t() {
        a aVar = new a();
        aVar.czn = new tx();
        aVar.czo = new ty();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
        aVar.czm = 692;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 692;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.eDy = ((ty) this.cif.czl.czs).eDn;
            ak.yW();
            c.vf().set(282885, this.eDy);
        }
        this.cii.a(i2, i3, str, this);
    }
}
