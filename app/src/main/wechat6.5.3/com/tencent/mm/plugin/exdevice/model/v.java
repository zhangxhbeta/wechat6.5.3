package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.ash;
import com.tencent.mm.protocal.c.asi;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class v extends k implements j {
    public b cif = null;
    private e cii = null;

    public v(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new ash();
        aVar.czo = new asi();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
        aVar.czm = 1270;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ash com_tencent_mm_protocal_c_ash = (ash) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ash.mgm = new abt();
        com_tencent_mm_protocal_c_ash.mgm.meq = str;
        com_tencent_mm_protocal_c_ash.mgm.eez = str2;
        com_tencent_mm_protocal_c_ash.mQY = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1270;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
