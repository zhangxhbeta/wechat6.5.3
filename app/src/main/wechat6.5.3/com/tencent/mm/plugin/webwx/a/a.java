package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public int bdf;
    private final b cQA;
    private e cii;

    public a(int i) {
        this.bdf = i;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        pd pdVar = new pd();
        pe peVar = new pe();
        aVar.czn = pdVar;
        aVar.czo = peVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
        aVar.czm = 792;
        aVar.czp = 0;
        aVar.czq = 0;
        pdVar.gly = i;
        pdVar.mrd = 1;
        this.cQA = aVar.Bv();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 792;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }
}
