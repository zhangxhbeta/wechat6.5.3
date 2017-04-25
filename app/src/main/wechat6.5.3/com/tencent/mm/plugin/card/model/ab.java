package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.and;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ab extends k implements j {
    public String bmE;
    private final b cif;
    private e cii;
    public String content;
    public String dCB;
    public String eDE;
    public String eDF;
    public boolean eDG;
    public int status;

    public ab(int i, String str) {
        a aVar = new a();
        aVar.czn = new and();
        aVar.czo = new ane();
        aVar.uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
        aVar.czm = 1171;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        and com_tencent_mm_protocal_c_and = (and) this.cif.czk.czs;
        com_tencent_mm_protocal_c_and.lZR = i;
        com_tencent_mm_protocal_c_and.lZS = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ane com_tencent_mm_protocal_c_ane = (ane) this.cif.czl.czs;
            this.bmE = com_tencent_mm_protocal_c_ane.lZU;
            this.eDE = com_tencent_mm_protocal_c_ane.lZV;
            this.status = com_tencent_mm_protocal_c_ane.status;
            this.content = com_tencent_mm_protocal_c_ane.content;
            this.eDF = com_tencent_mm_protocal_c_ane.eDb;
            this.dCB = com_tencent_mm_protocal_c_ane.mNr;
            this.eDG = com_tencent_mm_protocal_c_ane.eDG;
            v.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[]{this.bmE, this.eDE, Integer.valueOf(this.status), this.content, this.eDF, this.dCB, Boolean.valueOf(this.eDG)});
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1171;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
