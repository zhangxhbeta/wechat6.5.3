package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class c extends k {
    private b cif;
    private e cii;
    public amb kZp = null;

    public c(String str) {
        a aVar = new a();
        aVar.czn = new aml();
        aVar.czo = new amm();
        aVar.uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
        aVar.czm = 1520;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aml com_tencent_mm_protocal_c_aml = (aml) this.cif.czk.czs;
        if (!be.kS(str)) {
            com_tencent_mm_protocal_c_aml.hNP = str;
        }
    }

    public final int getType() {
        return 1520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.cii.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            amm com_tencent_mm_protocal_c_amm = (amm) ((b) pVar).czl.czs;
            this.kZp = com_tencent_mm_protocal_c_amm.mNd;
            if (com_tencent_mm_protocal_c_amm.mNd != null) {
                v.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + com_tencent_mm_protocal_c_amm.mNd.hNP);
            } else {
                v.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
            }
        }
    }
}
