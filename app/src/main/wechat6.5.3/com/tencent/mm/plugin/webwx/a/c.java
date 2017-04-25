package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    final b cQA;
    private e cii;

    public c(String str) {
        a aVar = new a();
        pj pjVar = new pj();
        pk pkVar = new pk();
        aVar.czn = pjVar;
        aVar.czo = pkVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
        aVar.czm = 971;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        pjVar.mre = str;
        v.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", new Object[]{str});
    }

    public final int getType() {
        return 971;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }
}
