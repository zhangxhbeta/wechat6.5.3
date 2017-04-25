package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e.b;
import com.tencent.mm.protocal.c.adw;
import com.tencent.mm.protocal.c.adx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class m extends k implements j, b {
    public final com.tencent.mm.v.b cif;
    private e cxf;
    public a ldV;
    private final int ldX;
    public String ldY;

    public m(a aVar, String str, String str2, LinkedList<String> linkedList, String str3, String str4, String str5, String str6, int i) {
        v.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6});
        this.ldV = aVar;
        this.ldY = str;
        this.ldX = i;
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new adw();
        aVar2.czo = new adx();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
        aVar2.czm = 1093;
        aVar2.czp = 0;
        aVar2.czq = 0;
        this.cif = aVar2.Bv();
        adw com_tencent_mm_protocal_c_adw = (adw) this.cif.czk.czs;
        com_tencent_mm_protocal_c_adw.url = str;
        com_tencent_mm_protocal_c_adw.bmJ = str2;
        com_tencent_mm_protocal_c_adw.mEE = linkedList;
        com_tencent_mm_protocal_c_adw.fZV = str3;
        com_tencent_mm_protocal_c_adw.mEs = str4;
        com_tencent_mm_protocal_c_adw.bCj = str5;
        com_tencent_mm_protocal_c_adw.mEt = str6;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1093;
    }

    public final adx bif() {
        if (this.cif == null) {
            return null;
        }
        return (adx) this.cif.czl.czs;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int bie() {
        return this.ldX;
    }
}
