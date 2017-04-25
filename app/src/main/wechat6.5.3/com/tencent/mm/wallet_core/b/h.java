package com.tencent.mm.wallet_core.b;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.amc;
import com.tencent.mm.protocal.c.amd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class h extends k {
    private b cif;
    private e cii;

    public h(String str) {
        this(str, null, -1, -1, -1);
    }

    public h(String str, String str2, int i, int i2, int i3) {
        a aVar = new a();
        aVar.czn = new amc();
        aVar.czo = new amd();
        aVar.uri = "/cgi-bin/mmpay-bin/paysubscribe";
        aVar.czm = 421;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        amc com_tencent_mm_protocal_c_amc = (amc) this.cif.czk.czs;
        com_tencent_mm_protocal_c_amc.mMV = str;
        com_tencent_mm_protocal_c_amc.mkb = f.bfP();
        if (!be.kS(str2)) {
            com_tencent_mm_protocal_c_amc.mMX = new com.tencent.mm.ba.b(str2.getBytes());
        }
        if (i >= 0) {
            com_tencent_mm_protocal_c_amc.mMY = i;
        }
        if (i2 >= 0) {
            com_tencent_mm_protocal_c_amc.lZo = i2;
        }
        if (i3 >= 0) {
            com_tencent_mm_protocal_c_amc.mMZ = i3;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetScenePaySubscribe", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 421;
    }
}
