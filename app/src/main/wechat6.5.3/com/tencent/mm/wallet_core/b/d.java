package com.tencent.mm.wallet_core.b;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.in;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class d extends k {
    private b cif;
    private e cii;

    public d(String str, String str2) {
        a aVar = new a();
        aVar.czn = new in();
        aVar.czo = new io();
        aVar.uri = "/cgi-bin/mmpay-bin/cancelqrpay";
        aVar.czm = 410;
        aVar.czp = 198;
        aVar.czq = 1000000198;
        this.cif = aVar.Bv();
        in inVar = (in) this.cif.czk.czs;
        inVar.mka = str;
        inVar.mdO = str2;
        inVar.mkb = f.bfP();
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneCancelQRPay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 410;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
