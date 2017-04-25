package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.amf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class a extends k {
    public b cif;
    private e cii;

    public a(int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new ame();
        aVar.czo = new amf();
        aVar.uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
        aVar.czm = 1519;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ame com_tencent_mm_protocal_c_ame = (ame) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ame.gmo = 10;
        com_tencent_mm_protocal_c_ame.mfb = i;
        v.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10" + ",offset:" + i);
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.cii.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((amf) ((b) pVar).czl.czs).mNa);
        }
    }

    public final int bhE() {
        return ((amf) this.cif.czl.czs).mNa;
    }

    public final int getType() {
        return 1519;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
