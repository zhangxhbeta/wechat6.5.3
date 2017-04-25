package com.tencent.mm.plugin.address.model;

import com.tencent.mm.a.o;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apg;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif;
    private e cii;
    public int status;

    public b(String str, String str2, o oVar) {
        boolean z = true;
        a aVar = new a();
        aVar.czn = new apg();
        aVar.czo = new aph();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
        aVar.czm = 582;
        aVar.czp = 0;
        aVar.czq = 0;
        String str3 = "MicroMsg.NetSceneRcptInfoImportYiXun";
        StringBuilder append = new StringBuilder("a2key is ").append(!be.kS(str)).append(", newa2key is ");
        if (be.kS(str2)) {
            z = false;
        }
        v.d(str3, append.append(z).toString());
        this.cif = aVar.Bv();
        apg com_tencent_mm_protocal_c_apg = (apg) this.cif.czk.czs;
        com_tencent_mm_protocal_c_apg.med = new are().ba(be.KG(str));
        com_tencent_mm_protocal_c_apg.mOT = new are().ba(be.KG(str2));
        com_tencent_mm_protocal_c_apg.mOS = oVar.intValue();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            aph com_tencent_mm_protocal_c_aph = (aph) ((com.tencent.mm.v.b) pVar).czl.czs;
            this.status = com_tencent_mm_protocal_c_aph.mOU;
            v.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
            if (com_tencent_mm_protocal_c_aph.mOR.mOV != null && this.status == 0) {
                v.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_aph.mOR.mOV.size());
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().q(com_tencent_mm_protocal_c_aph.mOR.mOV);
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().Os();
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 582;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
