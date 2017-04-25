package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.protocal.c.ayr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class g extends k {
    private b cif;
    private e cii;
    public String dzg;
    public PayInfo imN;

    public g(MallRechargeProduct mallRechargeProduct, String str) {
        this(mallRechargeProduct.appId, mallRechargeProduct.imm, mallRechargeProduct.aZD, str);
    }

    public g(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.czn = new ayq();
        aVar.czo = new ayr();
        aVar.uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
        aVar.czm = 498;
        aVar.czp = 230;
        aVar.czq = 1000000230;
        this.cif = aVar.Bv();
        ayq com_tencent_mm_protocal_c_ayq = (ayq) this.cif.czk.czs;
        this.dzg = str;
        com_tencent_mm_protocal_c_ayq.mux = str;
        com_tencent_mm_protocal_c_ayq.muw = str2;
        com_tencent_mm_protocal_c_ayq.mzc = str3;
        com_tencent_mm_protocal_c_ayq.muy = str4;
        com_tencent_mm_protocal_c_ayq.mpB = c.bgL().Dg(str2);
    }

    public final void c(int i, int i2, String str, p pVar) {
        this.imN = new PayInfo();
        ayr com_tencent_mm_protocal_c_ayr = (ayr) ((b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + com_tencent_mm_protocal_c_ayr.mdO);
            this.imN.appId = this.dzg;
            this.imN.kXn = com_tencent_mm_protocal_c_ayr.mvu;
            this.imN.fTG = com_tencent_mm_protocal_c_ayr.mdO;
        }
        if (i2 == 0) {
            i2 = com_tencent_mm_protocal_c_ayr.muz;
        }
        if (be.kS(str)) {
            str = com_tencent_mm_protocal_c_ayr.muA;
        }
        this.imN.lVC = String.valueOf(i2);
        this.imN.biS = str != null ? str : "";
        v.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i2 + ", errMsg " + str);
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 498;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
