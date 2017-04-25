package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.aqg;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class i extends k {
    private b cif;
    private e cii;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.czn = new aqg();
        aVar.czo = new aqh();
        aVar.uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
        aVar.czm = 600;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aqg com_tencent_mm_protocal_c_aqg = (aqg) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aqg.mPF = str;
        com_tencent_mm_protocal_c_aqg.mPE = be.getInt(str2, 0);
        com_tencent_mm_protocal_c_aqg.mkb = f.bfP();
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 600;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
