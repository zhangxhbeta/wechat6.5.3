package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e.b;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.protocal.c.aea;
import com.tencent.mm.protocal.c.aeb;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class o extends k implements j, b {
    public final com.tencent.mm.v.b cif;
    private e cxf;
    private final int ldX;
    public adp ldZ;

    public o(adp com_tencent_mm_protocal_c_adp, String str, String str2, String str3, String str4, String str5, String str6, String str7, com.tencent.mm.ba.b bVar, int i, LinkedList<aeo> linkedList, int i2) {
        v.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i)});
        this.ldZ = com_tencent_mm_protocal_c_adp;
        this.ldX = i2;
        a aVar = new a();
        aVar.czn = new aea();
        aVar.czo = new aeb();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
        aVar.czm = 1096;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aea com_tencent_mm_protocal_c_aea = (aea) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aea.url = str;
        com_tencent_mm_protocal_c_aea.bmJ = str2;
        com_tencent_mm_protocal_c_aea.mEp = str3;
        com_tencent_mm_protocal_c_aea.fZV = str4;
        com_tencent_mm_protocal_c_aea.mEs = str5;
        com_tencent_mm_protocal_c_aea.bCj = str6;
        com_tencent_mm_protocal_c_aea.mEt = str7;
        com_tencent_mm_protocal_c_aea.mEv = i;
        com_tencent_mm_protocal_c_aea.mEu = bVar;
        com_tencent_mm_protocal_c_aea.mEA = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1096;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int bie() {
        return this.ldX;
    }
}
