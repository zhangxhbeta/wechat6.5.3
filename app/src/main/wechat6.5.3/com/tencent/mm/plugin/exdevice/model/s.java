package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class s extends k implements j {
    private e cxf = null;
    private String fto = null;
    private b fuB = null;

    public s(String str, String str2, String str3, int i) {
        a aVar = new a();
        aVar.czn = new aca();
        aVar.czo = new acb();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
        aVar.czm = 1090;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fuB = aVar.Bv();
        aca com_tencent_mm_protocal_c_aca = (aca) this.fuB.czk.czs;
        com_tencent_mm_protocal_c_aca.mfC = com.tencent.mm.ba.b.Ir(str2);
        com_tencent_mm_protocal_c_aca.mfA = com.tencent.mm.ba.b.Ir(str3);
        com_tencent_mm_protocal_c_aca.gly = i;
        this.fto = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        ac.ajq().sq(this.fto);
        if (i2 == 0 && i3 == 0) {
            eo eoVar = ((acb) this.fuB.czl.czs).mQl;
            int i4 = eoVar.mcj;
            if (eoVar.mfD.mQz) {
                String str2 = eoVar.mfD.mQy;
            }
            v.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + i4 + ",msg=" + str);
        }
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1090;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.fuB, this);
    }
}
