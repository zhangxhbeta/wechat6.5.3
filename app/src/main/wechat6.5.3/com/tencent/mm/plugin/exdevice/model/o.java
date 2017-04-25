package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tt;
import com.tencent.mm.protocal.c.tu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class o extends k implements j {
    b cif = null;
    private e cii = null;

    public o() {
        a aVar = new a();
        aVar.czn = new tt();
        aVar.czo = new tu();
        aVar.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
        aVar.czm = 539;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((tt) this.cif.czk.czs).efl = 1;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneGetBoundHardDevices", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 539;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
