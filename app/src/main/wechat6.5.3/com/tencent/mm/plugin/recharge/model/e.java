package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e extends k implements j {
    private b cif;
    private com.tencent.mm.v.e cii;
    public String imA;
    public String imB;
    public String imC;
    public String imD;
    public String imm;
    public ArrayList<MallRechargeProduct> imz = null;

    public e(String str) {
        a aVar = new a();
        aVar.czn = new xt();
        aVar.czo = new xu();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
        aVar.czm = 496;
        aVar.czp = 228;
        aVar.czq = 1000000228;
        this.cif = aVar.Bv();
        xt xtVar = (xt) this.cif.czk.czs;
        this.imm = str;
        xtVar.muw = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            xu xuVar = (xu) ((b) pVar).czl.czs;
            String str2 = xuVar.mze;
            v.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList " + str2);
            if (!be.kS(str2)) {
                try {
                    this.imz = b.a(this.imm, new JSONObject(str2).getJSONArray("pay_product_list"));
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneGetPayFunctionProductList", e, "", new Object[0]);
                }
            }
            if (!be.kS(xuVar.mzW)) {
                try {
                    JSONObject jSONObject = new JSONObject(xuVar.mzW);
                    this.imA = jSONObject.optString("balance_link");
                    this.imC = jSONObject.optString("recharge_link");
                    this.imB = jSONObject.optString("balance_wording");
                    this.imD = jSONObject.optString("recharge_wording");
                } catch (Throwable e2) {
                    v.a("MicroMsg.NetSceneGetPayFunctionProductList", e2, "", new Object[0]);
                }
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 496;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
