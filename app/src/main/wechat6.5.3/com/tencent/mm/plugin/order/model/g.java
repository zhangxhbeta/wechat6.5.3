package com.tencent.mm.plugin.order.model;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class g extends k {
    private b cif;
    private e cii;

    public g(String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new alp();
        aVar.czo = new alq();
        aVar.uri = "/cgi-bin/micromsg-bin/paydeluserroll";
        aVar.czm = 389;
        aVar.czp = 187;
        aVar.czq = 1000000187;
        this.cif = aVar.Bv();
        alp com_tencent_mm_protocal_c_alp = (alp) this.cif.czk.czs;
        com_tencent_mm_protocal_c_alp.mMw = 1;
        if (!be.kS(str)) {
            com_tencent_mm_protocal_c_alp.hNP = str;
        }
        if (!be.kS(str2)) {
            com_tencent_mm_protocal_c_alp.hOj = str2;
        }
        com_tencent_mm_protocal_c_alp.mkb = f.bfP();
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.cii.a(i, i2, str, this);
    }

    public final int aFO() {
        return ((alp) this.cif.czk.czs).mMw;
    }

    public final String aFP() {
        return ((alp) this.cif.czk.czs).hNP;
    }

    public final int getType() {
        return 389;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
