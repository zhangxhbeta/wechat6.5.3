package com.tencent.mm.plugin.order.model;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class f extends k {
    private b cif;
    private e cii;

    public f(String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new ot();
        aVar.czo = new ou();
        aVar.uri = "/cgi-bin/micromsg-bin/evaluateorder";
        aVar.czm = 583;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ot otVar = (ot) this.cif.czk.czs;
        otVar.mqY = str;
        otVar.glj = str2;
        otVar.itI = i;
        otVar.mkb = com.tencent.mm.plugin.wallet_core.model.f.bfP();
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
