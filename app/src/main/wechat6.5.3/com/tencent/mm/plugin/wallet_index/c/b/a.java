package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.amk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class a extends k {
    private b cif;
    private e cii;
    public String kXm;
    public String kXn;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new amj();
        aVar.czo = new amk();
        aVar.uri = "/cgi-bin/mmpay-bin/payugenprepay";
        aVar.czm = 1521;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        amj com_tencent_mm_protocal_c_amj = (amj) this.cif.czk.czs;
        com_tencent_mm_protocal_c_amj.glj = str;
        com_tencent_mm_protocal_c_amj.mmU = str4;
        com_tencent_mm_protocal_c_amj.mmT = str3;
        com_tencent_mm_protocal_c_amj.mmV = str5;
        com_tencent_mm_protocal_c_amj.mmW = str2;
        com_tencent_mm_protocal_c_amj.mgs = str6;
        com_tencent_mm_protocal_c_amj.mmu = str7;
        com_tencent_mm_protocal_c_amj.mvq = str8;
        com_tencent_mm_protocal_c_amj.lZo = i;
        v.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str3, str5, str2, str6, str7, str8}));
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        amk com_tencent_mm_protocal_c_amk = (amk) ((b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.NetScenePayUGenPrepay", "rr " + com_tencent_mm_protocal_c_amk.mvt);
            this.kXm = com_tencent_mm_protocal_c_amk.mvt;
            this.kXn = com_tencent_mm_protocal_c_amk.mvu;
        }
        this.cii.a(i, i2, com_tencent_mm_protocal_c_amk.fvD, this);
    }

    public final int getType() {
        return 1521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
