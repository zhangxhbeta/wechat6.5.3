package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apo;
import com.tencent.mm.protocal.c.app;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private b cif;
    private com.tencent.mm.v.e cii;

    public e(int i) {
        a aVar = new a();
        aVar.czn = new apo();
        aVar.czo = new app();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
        aVar.czm = 419;
        aVar.czp = 204;
        aVar.czq = 1000000204;
        this.cif = aVar.Bv();
        ((apo) this.cif.czk.czs).id = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            app com_tencent_mm_protocal_c_app = (app) ((b) pVar).czl.czs;
            if (com_tencent_mm_protocal_c_app.mOR.mOV != null) {
                v.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_app.mOR.mOV.size());
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().q(com_tencent_mm_protocal_c_app.mOR.mOV);
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().Os();
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 419;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
