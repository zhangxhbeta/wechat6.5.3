package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.protocal.c.aqm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class q extends k implements j {
    private final b cif;
    private e cii;

    public q(float f, float f2, String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new aql();
        aVar.czo = new aqm();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
        aVar.czm = 1253;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aql com_tencent_mm_protocal_c_aql = (aql) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aql.latitude = (double) f;
        com_tencent_mm_protocal_c_aql.longitude = (double) f2;
        com_tencent_mm_protocal_c_aql.bol = str;
        com_tencent_mm_protocal_c_aql.eBK = str2;
        com_tencent_mm_protocal_c_aql.mPL = i;
    }

    public final int getType() {
        return 1253;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }
}
