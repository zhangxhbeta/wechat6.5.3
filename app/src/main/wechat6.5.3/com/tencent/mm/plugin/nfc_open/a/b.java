package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    public com.tencent.mm.v.b cif;
    private e cii;

    public b(int i) {
        a aVar = new a();
        aVar.czn = new lt();
        aVar.czo = new lu();
        aVar.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
        aVar.czm = 1561;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((lt) this.cif.czk.czs).version = i;
    }

    public final int getType() {
        return 1561;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }
}
