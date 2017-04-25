package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.qq;
import com.tencent.mm.protocal.c.qr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    public String bhT;
    public b cif;
    private e cii;
    public String fkg;

    public c(String str, String str2, String str3, String str4, String str5) {
        this.bhT = str2;
        this.fkg = str3;
        a aVar = new a();
        aVar.czn = new qq();
        aVar.czo = new qr();
        aVar.uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
        aVar.czm = 1555;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        qq qqVar = (qq) this.cif.czk.czs;
        qqVar.muw = str;
        qqVar.mgw = str2;
        qqVar.hOy = str3;
        qqVar.mux = str4;
        qqVar.muy = str5;
        qqVar.mpB = com.tencent.mm.plugin.wallet_core.model.mall.c.bgL().Dg(str);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + i3 + ", errMsg " + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
