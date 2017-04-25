package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.pluginsdk.l.a.c;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class a extends k {
    private b cif;
    private e cii;
    public String kXm;
    public String kXn;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new rp();
        aVar.czo = new rq();
        aVar.uri = "/cgi-bin/mmpay-bin/genprepay";
        aVar.czm = 398;
        aVar.czp = 189;
        aVar.czq = 1000000189;
        this.cif = aVar.Bv();
        c bol = com.tencent.mm.pluginsdk.l.e.bol();
        String str9 = bol.bgr;
        String str10 = bol.bgs;
        rp rpVar = (rp) this.cif.czk.czs;
        rpVar.glj = str;
        rpVar.mmU = str4;
        rpVar.mmT = str3;
        rpVar.mmV = str5;
        rpVar.mmW = str2;
        rpVar.mgs = str6;
        rpVar.mmu = str7;
        rpVar.mvq = str8;
        rpVar.lZo = i;
        rpVar.mvs = str9;
        rpVar.mvr = str10;
        rpVar.mkb = f.bfP();
        v.d("MicroMsg.NetSceneGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str3, str5, str2, str6, str7, str8}));
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        rq rqVar = (rq) ((b) pVar).czl.czs;
        v.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(rqVar.fvC), rqVar.fvD});
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.NetSceneGenPrepay", "rr " + rqVar.mvt);
            this.kXm = rqVar.mvt;
            this.kXn = rqVar.mvu;
        }
        String str2 = rqVar.fvD;
        this.cii.a(i, rqVar.fvC, str2, this);
    }

    public final int getType() {
        return 398;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
