package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.protocal.c.aym;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class k extends com.tencent.mm.v.k implements j {
    private b cif;
    private e cii;
    public String hQB;

    public k(avd com_tencent_mm_protocal_c_avd) {
        a aVar = new a();
        aVar.czn = new aym();
        aVar.czo = new ayn();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
        aVar.czm = 557;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((aym) this.cif.czk.czs).mVT = com_tencent_mm_protocal_c_avd;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ayn com_tencent_mm_protocal_c_ayn = (ayn) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + com_tencent_mm_protocal_c_ayn.mVU);
            this.hQB = com_tencent_mm_protocal_c_ayn.mVU;
        }
        v.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + i3 + ", errMsg " + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 557;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
