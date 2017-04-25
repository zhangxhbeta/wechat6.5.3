package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.baa;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class n extends k implements j {
    public String aRh = null;
    b cif = null;
    private e cii = null;
    public int fuz = 0;

    public n(acj com_tencent_mm_protocal_c_acj, String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new baa();
        aVar.czo = new bab();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
        aVar.czm = 1717;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        baa com_tencent_mm_protocal_c_baa = (baa) this.cif.czk.czs;
        com_tencent_mm_protocal_c_baa.meq = str;
        com_tencent_mm_protocal_c_baa.mnR = str2;
        com_tencent_mm_protocal_c_baa.mWG = com_tencent_mm_protocal_c_acj;
        com_tencent_mm_protocal_c_baa.mWH = i;
        this.aRh = str2;
        this.fuz = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
