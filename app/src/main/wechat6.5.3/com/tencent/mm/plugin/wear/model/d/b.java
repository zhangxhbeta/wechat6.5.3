package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.model.aw;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private com.tencent.mm.v.b cQA;
    private e cii;

    public b(String str) {
        a aVar = new a();
        aVar.czm = 976;
        aVar.uri = "/cgi-bin/micromsg-bin/sendyo";
        aVar.czn = new bij();
        aVar.czo = new bik();
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        bij com_tencent_mm_protocal_c_bij = (bij) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_bij.gom = str;
        com_tencent_mm_protocal_c_bij.mIR = com_tencent_mm_protocal_c_bij.hNS;
        com_tencent_mm_protocal_c_bij.hNS = (int) aw.fN(str);
        com_tencent_mm_protocal_c_bij.efm = 63;
        com_tencent_mm_protocal_c_bij.ncV = 1;
        com_tencent_mm_protocal_c_bij.eet = 1;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 976;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }
}
