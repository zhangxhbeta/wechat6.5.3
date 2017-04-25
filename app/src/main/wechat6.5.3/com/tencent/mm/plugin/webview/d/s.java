package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agy;
import com.tencent.mm.protocal.c.ahd;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class s extends k implements j {
    String appId;
    String bde;
    final b cif;
    private e cxf;

    public s(String str, String str2, agy com_tencent_mm_protocal_c_agy) {
        this.appId = str;
        this.bde = str2;
        a aVar = new a();
        aVar.czn = new ahd();
        aVar.czo = new ahe();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
        aVar.czm = 1034;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ahd com_tencent_mm_protocal_c_ahd = (ahd) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ahd.bmJ = str;
        com_tencent_mm_protocal_c_ahd.mGR = com_tencent_mm_protocal_c_agy;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1034;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
