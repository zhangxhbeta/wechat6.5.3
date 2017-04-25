package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    public String cID;
    private b cif;
    private e cii;
    public boolean dxk;
    public String username;

    public c(String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new apk();
        aVar.czo = new apl();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
        aVar.czm = 417;
        aVar.czp = 202;
        aVar.czq = 1000000202;
        this.cif = aVar.Bv();
        apk com_tencent_mm_protocal_c_apk = (apk) this.cif.czk.czs;
        com_tencent_mm_protocal_c_apk.eWB = 0;
        com_tencent_mm_protocal_c_apk.mPf = str;
        com_tencent_mm_protocal_c_apk.bmJ = str2;
        com_tencent_mm_protocal_c_apk.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        boolean z = true;
        v.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            apl com_tencent_mm_protocal_c_apl = (apl) ((b) pVar).czl.czs;
            this.username = com_tencent_mm_protocal_c_apl.fDn;
            this.cID = com_tencent_mm_protocal_c_apl.mPi;
            if (com_tencent_mm_protocal_c_apl.mPh != 1) {
                z = false;
            }
            this.dxk = z;
            if (com_tencent_mm_protocal_c_apl.mOR.mOV != null) {
                v.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_apl.mOR.mOV.size());
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().q(com_tencent_mm_protocal_c_apl.mOR.mOV);
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().Os();
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 417;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
