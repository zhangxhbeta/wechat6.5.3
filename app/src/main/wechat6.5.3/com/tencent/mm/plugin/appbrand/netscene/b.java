package com.tencent.mm.plugin.appbrand.netscene;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aee;
import com.tencent.mm.protocal.c.aef;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class b extends k implements j {
    public final com.tencent.mm.v.b cif;
    private e cxf;
    private a<b> dMa;

    public interface a<T extends k> {
        void c(int i, int i2, String str, T t);
    }

    public b(String str, LinkedList<String> linkedList, int i, a<b> aVar) {
        this(str, linkedList, i);
        this.dMa = aVar;
    }

    private b(String str, LinkedList<String> linkedList, int i) {
        v.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d]", new Object[]{str, Integer.valueOf(i)});
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aee();
        aVar.czo = new aef();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.czm = 1157;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aee com_tencent_mm_protocal_c_aee = (aee) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aee.glj = str;
        com_tencent_mm_protocal_c_aee.mEH = linkedList;
        com_tencent_mm_protocal_c_aee.mEJ = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
        if (this.dMa != null) {
            this.dMa.c(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1157;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
