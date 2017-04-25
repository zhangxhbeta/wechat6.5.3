package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.mt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private String aRh;
    private b cif;
    private e cii;

    public a(String str) {
        this.aRh = str;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new ms();
        aVar.czo = new mt();
        aVar.uri = "/cgi-bin/micromsg-bin/delsafedevice";
        aVar.czm = 362;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((ms) this.cif.czk.czs).moU = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            mt mtVar = (mt) this.cif.czl.czs;
            ak.yW();
            c.vf().set(64, Integer.valueOf(mtVar.may));
            v.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + mtVar.may);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 362;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (be.kS(this.aRh)) {
            v.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
            return -1;
        }
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
