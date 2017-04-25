package com.tencent.mm.wallet_core.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ani;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class i extends k {
    public final b cif;
    private e cii;
    public String fdU;
    public String kXk;
    public String kXl;

    public i(String str, String str2, String str3, int i, int i2, String str4) {
        a aVar = new a();
        aVar.czn = new ani();
        aVar.czo = new anj();
        aVar.uri = "/cgi-bin/micromsg-bin/preparepurchase";
        aVar.czm = 422;
        aVar.czp = 214;
        aVar.czq = 1000000214;
        this.cif = aVar.Bv();
        ani com_tencent_mm_protocal_c_ani = (ani) this.cif.czk.czs;
        this.fdU = str;
        com_tencent_mm_protocal_c_ani.mdM = str;
        this.kXl = str2;
        com_tencent_mm_protocal_c_ani.mNw = str2;
        this.kXk = str3;
        com_tencent_mm_protocal_c_ani.mNx = str3;
        com_tencent_mm_protocal_c_ani.hNX = i2;
        com_tencent_mm_protocal_c_ani.mNy = i;
        com_tencent_mm_protocal_c_ani.gor = str4;
        v.d("MicroMsg.NetScenePreparePurchase", "productId:" + str + ",price:" + str2 + ",currencyType:" + str3 + ",payType:" + i2);
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.cii.a(i, i2, str, this);
        } else {
            this.cii.a(i, i2, str, this);
        }
    }

    public final String bLc() {
        anj com_tencent_mm_protocal_c_anj = (anj) this.cif.czl.czs;
        if (com_tencent_mm_protocal_c_anj != null) {
            v.d("MicroMsg.NetScenePreparePurchase", "get bill no is " + com_tencent_mm_protocal_c_anj.mNz);
            return com_tencent_mm_protocal_c_anj.mNz;
        }
        v.e("MicroMsg.NetScenePreparePurchase", "get bill no field.");
        return "";
    }

    public final int getType() {
        return 422;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
