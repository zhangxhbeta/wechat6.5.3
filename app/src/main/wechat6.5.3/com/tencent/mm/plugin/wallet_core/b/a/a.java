package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.protocal.c.alv;
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
    public int kLI = 0;

    public a() {
        boolean booleanValue;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        alu com_tencent_mm_protocal_c_alu = new alu();
        ak.yW();
        Object obj = c.vf().get(com.tencent.mm.storage.t.a.nrO, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        com_tencent_mm_protocal_c_alu.mMB = booleanValue ? 1 : 0;
        aVar.czn = com_tencent_mm_protocal_c_alu;
        aVar.czo = new alv();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        aVar.czm = 1564;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        alv com_tencent_mm_protocal_c_alv = (alv) ((b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            v.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_alv.fvC), com_tencent_mm_protocal_c_alv.fvD});
            str = com_tencent_mm_protocal_c_alv.fvD;
            i2 = com_tencent_mm_protocal_c_alv.fvC;
            this.jumpUrl = com_tencent_mm_protocal_c_alv.gkT;
            this.kLI = com_tencent_mm_protocal_c_alv.mMC;
        } else {
            v.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
            this.jumpUrl = null;
        }
        if (be.kS(str)) {
            str = aa.getContext().getString(2131236155);
        }
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 1564;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
