package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agz;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    String appId;
    final b cif;
    private e cxf;
    String ldU;

    public f(String str, String str2) {
        this.appId = str;
        this.ldU = str2;
        a aVar = new a();
        aVar.czn = new agz();
        aVar.czo = new aha();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
        aVar.czm = 1035;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        agz com_tencent_mm_protocal_c_agz = (agz) this.cif.czk.czs;
        com_tencent_mm_protocal_c_agz.bmJ = str;
        com_tencent_mm_protocal_c_agz.mGQ = str2;
        v.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", new Object[]{str, str2});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1035;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
