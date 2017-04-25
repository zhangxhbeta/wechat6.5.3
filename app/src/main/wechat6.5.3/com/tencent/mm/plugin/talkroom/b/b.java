package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ox;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private final com.tencent.mm.v.b cif;
    private e cii;
    private int hGO;

    public b(int i, long j, String str, int i2) {
        this.hGO = i2;
        a aVar = new a();
        aVar.czn = new ox();
        aVar.czo = new oy();
        aVar.uri = "/cgi-bin/micromsg-bin/exittalkroom";
        aVar.czm = 333;
        aVar.czp = 148;
        aVar.czq = 1000000148;
        this.cif = aVar.Bv();
        ox oxVar = (ox) this.cif.czk.czs;
        oxVar.mqR = str;
        oxVar.mqS = i;
        oxVar.mqT = j;
        oxVar.maG = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", new Object[]{Integer.valueOf(this.hGO)});
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 333;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }
}
