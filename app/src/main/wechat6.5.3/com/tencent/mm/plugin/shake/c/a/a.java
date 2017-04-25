package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ip;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private final b cif;
    private e cii;

    public a(String str, String str2) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new ip();
        aVar.czo = new iq();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
        aVar.czm = 1252;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ip ipVar = (ip) this.cif.czk.czs;
        ipVar.eBK = str;
        ipVar.bom = str2;
    }

    public final int getType() {
        return 1252;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = 1252" + " errType = " + i2 + " errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }
}
