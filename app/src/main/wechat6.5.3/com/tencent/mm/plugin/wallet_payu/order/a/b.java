package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class b extends k {
    private com.tencent.mm.v.b cif;
    private e cii;

    public b(String str) {
        a aVar = new a();
        aVar.czn = new amh();
        aVar.czo = new ami();
        aVar.uri = "/cgi-bin/mmpay-bin/payudeluserroll";
        aVar.czm = 1544;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        amh com_tencent_mm_protocal_c_amh = (amh) this.cif.czk.czs;
        if (!be.kS(str)) {
            com_tencent_mm_protocal_c_amh.hNP = str;
        }
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 1544;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
