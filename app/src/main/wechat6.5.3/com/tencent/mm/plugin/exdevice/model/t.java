package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class t extends k implements j {
    private b cif = null;
    private e cii = null;

    public t(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new aro();
        aVar.czo = new arp();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
        aVar.czm = 1706;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aro com_tencent_mm_protocal_c_aro = (aro) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aro.mac = str;
        if (str2 == null) {
            str2 = "";
        }
        com_tencent_mm_protocal_c_aro.userName = str2;
        if (str3 == null) {
            str3 = "";
        }
        com_tencent_mm_protocal_c_aro.category = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1706;
    }

    public final arp ajm() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (arp) this.cif.czl.czs;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
