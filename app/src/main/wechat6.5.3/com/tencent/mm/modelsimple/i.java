package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.mw;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends k implements j {
    private final b cif;
    private e cii;

    public i(String str) {
        v.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", str);
        a aVar = new a();
        aVar.czn = new mw();
        aVar.czo = new mx();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
        this.cif = aVar.Bv();
        mw mwVar = (mw) this.cif.czk.czs;
        mwVar.mhz = str;
        mwVar.moV = com.tencent.mm.ba.b.aT(new byte[0]);
    }

    public final int getType() {
        return 1067;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.cii.a(i2, i3, str, this);
    }
}
