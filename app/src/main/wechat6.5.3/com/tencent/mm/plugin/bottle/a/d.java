package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private final b cif;
    private e cii;

    public d() {
        a aVar = new a();
        aVar.czn = new tr();
        aVar.czo = new ts();
        aVar.uri = "/cgi-bin/micromsg-bin/getbottlecount";
        aVar.czm = v.CTRL_INDEX;
        aVar.czp = 49;
        aVar.czq = 1000000049;
        aVar.czr = false;
        this.cif = aVar.Bv();
        tr trVar = (tr) this.cif.czk.czs;
        trVar.gln = com.tencent.mm.model.k.xF();
        trVar.mwL = (int) be.Nh();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return v.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ts tsVar = (ts) this.cif.czl.czs;
        if (i2 == 0 && i3 == 0) {
            c.iv(tsVar.mwN);
            c.iu(tsVar.mwM);
        } else if (tsVar.mcj == -2002 || tsVar.mcj == -56) {
            c.iv(0);
            c.iu(0);
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetBottleCount", "onGYNetEnd type:" + i2 + " code:" + i3 + " ret:" + tsVar.mcj + " pickCnt:" + tsVar.mwN + " throwCnt:" + tsVar.mwM);
        this.cii.a(0, tsVar.mcj, str, this);
    }
}
