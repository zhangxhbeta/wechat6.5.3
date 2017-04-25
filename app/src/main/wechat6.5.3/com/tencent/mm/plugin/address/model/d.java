package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.protocal.c.apn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private b cif;
    private e cii;
    public int dxl = 0;

    public d(int i) {
        a aVar = new a();
        aVar.czn = new apm();
        aVar.czo = new apn();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
        aVar.czm = 416;
        aVar.czp = 201;
        aVar.czq = 1000000201;
        this.cif = aVar.Bv();
        this.dxl = i;
        v.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id " + i);
        ((apm) this.cif.czk.czs).id = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            apn com_tencent_mm_protocal_c_apn = (apn) ((b) pVar).czl.czs;
            if (com_tencent_mm_protocal_c_apn.mOR.mOV != null) {
                v.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_apn.mOR.mOV.size());
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().q(com_tencent_mm_protocal_c_apn.mOR.mOV);
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().Os();
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 416;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
