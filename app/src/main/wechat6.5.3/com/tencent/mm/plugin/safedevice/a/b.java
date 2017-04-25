package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    public String aRh;
    public String aZN;
    private com.tencent.mm.v.b cif;
    private e cii;
    public String deviceName;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new bbd();
        aVar.czo = new bbe();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesafedevice";
        aVar.czm = 361;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.aRh = str;
        this.deviceName = str2;
        this.aZN = str3;
        bbd com_tencent_mm_protocal_c_bbd = (bbd) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bbd.moU = str;
        com_tencent_mm_protocal_c_bbd.gkB = str2;
        com_tencent_mm_protocal_c_bbd.meq = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 361;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (be.kS(this.aRh) || be.kS(this.deviceName) || be.kS(this.aZN)) {
            v.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
            return -1;
        }
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
