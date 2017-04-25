package com.tencent.mm.an;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.nb;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private final b cif;
    private e cii;

    public a(String str) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new nb();
        aVar.czo = new nc();
        aVar.uri = "/cgi-bin/micromsg-bin/deletecardimg";
        this.cif = aVar.Bv();
        ((nb) this.cif.czk.czs).mpa = str;
    }

    public final int getType() {
        return 576;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.cii.a(i2, i3, str, this);
    }
}
