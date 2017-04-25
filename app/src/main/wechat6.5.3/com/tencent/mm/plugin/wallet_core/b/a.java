package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.kk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class a extends k {
    private b cif;
    private e cii;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new kj();
        aVar.czo = new kk();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.czm = 580;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        kj kjVar = (kj) this.cif.czk.czs;
        kjVar.glj = str;
        kjVar.mgs = str2;
        kjVar.mmT = str3;
        kjVar.mmU = str4;
        kjVar.mmW = str5;
        kjVar.mmV = str6;
        kjVar.mmu = str7;
        kjVar.mmX = i;
        kjVar.mkb = f.bfP();
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, 1);
    }

    public final int getType() {
        return 580;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            kk kkVar = (kk) ((b) pVar).czl.czs;
            v.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + kkVar.fvC + " resp.ErrMsg is " + kkVar.fvD);
            str = kkVar.fvD;
        }
        this.cii.a(i, i2, str, this);
    }

    public final String axY() {
        return ((kk) this.cif.czl.czs).token;
    }
}
