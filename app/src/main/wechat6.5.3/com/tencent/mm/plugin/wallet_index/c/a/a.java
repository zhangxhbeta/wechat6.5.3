package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class a extends k {
    private b cif;
    private e cii;
    public String jumpUrl;
    public String kXn;
    public String kXw;
    public String kXx;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new als();
        aVar.czo = new alt();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggenprepay";
        aVar.czm = 1563;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        als com_tencent_mm_protocal_c_als = (als) this.cif.czk.czs;
        com_tencent_mm_protocal_c_als.glj = str;
        com_tencent_mm_protocal_c_als.mmU = str4;
        com_tencent_mm_protocal_c_als.mmT = str2;
        com_tencent_mm_protocal_c_als.mmV = str5;
        com_tencent_mm_protocal_c_als.mmW = str6;
        com_tencent_mm_protocal_c_als.mgs = str3;
        com_tencent_mm_protocal_c_als.mmu = str7;
        com_tencent_mm_protocal_c_als.mvq = str8;
        com_tencent_mm_protocal_c_als.lZo = i;
        v.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str2, str5, str6, str3, str7, str8}));
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        alt com_tencent_mm_protocal_c_alt = (alt) ((b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            v.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_alt.fvC), com_tencent_mm_protocal_c_alt.fvD});
            str = com_tencent_mm_protocal_c_alt.fvD;
            i2 = com_tencent_mm_protocal_c_alt.fvC;
            this.jumpUrl = com_tencent_mm_protocal_c_alt.gkT;
            this.kXw = com_tencent_mm_protocal_c_alt.mvt;
            this.kXn = com_tencent_mm_protocal_c_alt.mvu;
            this.kXx = com_tencent_mm_protocal_c_alt.mMA;
        } else {
            v.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
            this.jumpUrl = null;
        }
        if (be.kS(str)) {
            str = aa.getContext().getString(2131236155);
        }
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 1563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
