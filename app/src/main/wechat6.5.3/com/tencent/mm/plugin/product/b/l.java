package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.ayp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class l extends k implements j {
    private b cif;
    private e cii;
    public String hQB;

    public l(avd com_tencent_mm_protocal_c_avd, String str) {
        a aVar = new a();
        aVar.czn = new ayo();
        aVar.czo = new ayp();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallorder";
        aVar.czm = 556;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ayo com_tencent_mm_protocal_c_ayo = (ayo) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ayo.mVT = com_tencent_mm_protocal_c_avd;
        com_tencent_mm_protocal_c_ayo.mVV = str;
    }

    public final int getType() {
        return 556;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        ayp com_tencent_mm_protocal_c_ayp = (ayp) ((b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + com_tencent_mm_protocal_c_ayp.mVU);
            this.hQB = com_tencent_mm_protocal_c_ayp.mVU;
        }
        v.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + i2 + ", errMsg " + str);
        this.cii.a(i, i2, str, this);
    }
}
