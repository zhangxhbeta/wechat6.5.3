package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.c.ww;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;
import org.json.JSONObject;

public final class d extends k implements j {
    public b cif;
    private e cii;
    public String dwA;
    public String imm;
    public String imn = null;
    public int imt;
    public MallRechargeProduct imw = null;
    public List<MallRechargeProduct> imx = null;
    public String imy;

    public d(int i, String str, String str2, String str3, String str4, String str5) {
        this.imm = str;
        this.imt = i;
        this.dwA = str5;
        this.imy = str2;
        a aVar = new a();
        aVar.czn = new ww();
        aVar.czo = new wx();
        aVar.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
        aVar.czm = 497;
        aVar.czp = 229;
        aVar.czq = 1000000229;
        this.cif = aVar.Bv();
        ww wwVar = (ww) this.cif.czk.czs;
        wwVar.muw = str;
        wwVar.mux = str3;
        wwVar.mzc = str2;
        wwVar.muy = str4;
        wwVar.mpB = c.bgL().Dg(str);
        v.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[]{str, str3, str2, str4}));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + i3 + ", errMsg " + str);
        wx wxVar = (wx) ((b) pVar).czl.czs;
        v.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + wxVar.muB);
        String str2 = wxVar.muB;
        this.imn = "";
        if (!be.kS(str2)) {
            String[] split = str2.split("&");
            if (split != null && split.length > 0) {
                Object obj = 1;
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3.length == 2) {
                        if (obj == null) {
                            this.imn += " ";
                        } else {
                            obj = null;
                        }
                        this.imn += split3[1];
                    }
                }
            }
        }
        if (!be.kS(wxVar.mze)) {
            try {
                this.imx = b.a(this.imm, new JSONObject(wxVar.mze).optJSONArray("product_info"));
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneGetLatestPayProductInfo", e, "", new Object[0]);
            }
        }
        if (i2 == 0 && i3 == 0) {
            str2 = wxVar.mzd;
            v.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product " + str2);
            if (!be.kS(str2)) {
                try {
                    this.imw = b.a(this.imm, new JSONObject(str2));
                    this.imw.imn = this.imn;
                } catch (Throwable e2) {
                    v.a("MicroMsg.NetSceneGetLatestPayProductInfo", e2, "", new Object[0]);
                }
            }
        }
        v.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[]{Integer.valueOf(wxVar.muz), wxVar.muA, Integer.valueOf(wxVar.muC), wxVar.muD}));
        if (i3 == 0) {
            if (wxVar.muC != 0) {
                i3 = wxVar.muC;
            } else {
                i3 = wxVar.muz;
            }
        }
        if (be.kS(str)) {
            if (be.kS(wxVar.muD)) {
                str = wxVar.muA;
            } else {
                str = wxVar.muD;
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 497;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
