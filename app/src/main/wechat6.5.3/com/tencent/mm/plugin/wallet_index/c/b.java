package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.sdk.g.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class b extends k {
    public com.tencent.mm.v.b cif;
    private e cii;

    public b(a aVar, String str, String str2, String str3, String str4) {
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new all();
        aVar2.czo = new alm();
        aVar2.uri = "/cgi-bin/mmpay-bin/payauthapp";
        aVar2.czm = 397;
        aVar2.czp = 188;
        aVar2.czq = 1000000188;
        this.cif = aVar2.Bv();
        all com_tencent_mm_protocal_c_all = (all) this.cif.czk.czs;
        com_tencent_mm_protocal_c_all.glj = aVar.appId;
        com_tencent_mm_protocal_c_all.mMo = aVar.bkj;
        com_tencent_mm_protocal_c_all.mvt = aVar.kXw;
        com_tencent_mm_protocal_c_all.mmT = aVar.bkl;
        com_tencent_mm_protocal_c_all.mMp = aVar.bkm;
        com_tencent_mm_protocal_c_all.mmU = aVar.nhN;
        com_tencent_mm_protocal_c_all.mmV = aVar.fZW;
        com_tencent_mm_protocal_c_all.mmW = aVar.bkk;
        com_tencent_mm_protocal_c_all.mMq = str;
        com_tencent_mm_protocal_c_all.gkE = str2;
        com_tencent_mm_protocal_c_all.hNZ = str3;
        com_tencent_mm_protocal_c_all.mkb = f.bfP();
        com_tencent_mm_protocal_c_all.mMs = str4;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetScenePayAuthApp", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 397;
    }
}
