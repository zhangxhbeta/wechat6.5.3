package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class a extends k {
    private b cif;
    private e cii;

    public final int getType() {
        return 1554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetScenePayUCheckJsApi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        amg com_tencent_mm_protocal_c_amg = (amg) ((b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.NetScenePayUCheckJsApi", "rr " + com_tencent_mm_protocal_c_amg.fvC);
        }
        this.cii.a(i, i2, com_tencent_mm_protocal_c_amg.fvD, this);
    }
}
