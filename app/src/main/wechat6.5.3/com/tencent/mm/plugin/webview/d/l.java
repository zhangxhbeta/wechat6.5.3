package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e.b;
import com.tencent.mm.protocal.c.adq;
import com.tencent.mm.protocal.c.adr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j, b {
    private final com.tencent.mm.v.b cif;
    private e cxf;
    public a ldV;
    public String ldW;
    private final int ldX;
    public String url;

    public l(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i, String str8, int i2) {
        v.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[]{str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8});
        this.ldV = aVar;
        this.ldW = str3;
        this.url = str;
        this.ldX = i2;
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new adq();
        aVar2.czo = new adr();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
        aVar2.czm = 1095;
        aVar2.czp = 0;
        aVar2.czq = 0;
        this.cif = aVar2.Bv();
        adq com_tencent_mm_protocal_c_adq = (adq) this.cif.czk.czs;
        com_tencent_mm_protocal_c_adq.url = str;
        com_tencent_mm_protocal_c_adq.gkz = str2;
        com_tencent_mm_protocal_c_adq.mEp = str3;
        com_tencent_mm_protocal_c_adq.fZV = str4;
        com_tencent_mm_protocal_c_adq.mEs = str5;
        com_tencent_mm_protocal_c_adq.bCj = str6;
        com_tencent_mm_protocal_c_adq.mEt = str7;
        com_tencent_mm_protocal_c_adq.mEu = com.tencent.mm.ba.b.aT(bArr);
        com_tencent_mm_protocal_c_adq.mEv = i;
        com_tencent_mm_protocal_c_adq.mEw = str8;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1095;
    }

    public final adq bic() {
        if (this.cif == null) {
            return null;
        }
        return (adq) this.cif.czk.czs;
    }

    public final adr bid() {
        if (this.cif == null) {
            return null;
        }
        return (adr) this.cif.czl.czs;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int bie() {
        return this.ldX;
    }
}
