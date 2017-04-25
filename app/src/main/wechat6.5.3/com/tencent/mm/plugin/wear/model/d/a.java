package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public String aRh;
    public String aZN;
    private b cQA;
    private e cii;

    public a(String str, String str2) {
        this.aRh = str;
        this.aZN = str2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czm = 1091;
        aVar.uri = "/cgi-bin/mmbiz-bin/device/register";
        aVar.czn = new aby();
        aVar.czo = new abz();
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        aby com_tencent_mm_protocal_c_aby = (aby) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_aby.mfA = new com.tencent.mm.ba.b(str.getBytes());
        com_tencent_mm_protocal_c_aby.mfC = new com.tencent.mm.ba.b(str2.getBytes());
        com_tencent_mm_protocal_c_aby.mDg = new com.tencent.mm.ba.b("5".getBytes());
    }

    public final int getType() {
        return 1091;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.cii.a(i2, i3, str, this);
    }
}
