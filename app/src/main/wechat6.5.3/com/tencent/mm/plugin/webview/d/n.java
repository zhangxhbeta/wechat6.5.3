package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e.b;
import com.tencent.mm.protocal.c.ady;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class n extends k implements j, b {
    private final com.tencent.mm.v.b cif;
    private e cxf;
    public a ldV;
    private final int ldX;

    public n(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i) {
        v.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6, str7});
        this.ldV = aVar;
        this.ldX = i;
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new ady();
        aVar2.czo = new adz();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
        aVar2.czm = 1094;
        aVar2.czp = 0;
        aVar2.czq = 0;
        this.cif = aVar2.Bv();
        ady com_tencent_mm_protocal_c_ady = (ady) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ady.url = str;
        com_tencent_mm_protocal_c_ady.bmJ = str2;
        com_tencent_mm_protocal_c_ady.mEp = str3;
        com_tencent_mm_protocal_c_ady.fZV = str4;
        com_tencent_mm_protocal_c_ady.mEs = str5;
        com_tencent_mm_protocal_c_ady.bCj = str6;
        com_tencent_mm_protocal_c_ady.mEt = str7;
        com_tencent_mm_protocal_c_ady.mEu = com.tencent.mm.ba.b.aT(bArr);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1094;
    }

    public final adz big() {
        if (this.cif == null) {
            return null;
        }
        return (adz) this.cif.czl.czs;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int bie() {
        return this.ldX;
    }
}
