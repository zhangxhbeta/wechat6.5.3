package com.tencent.mm.plugin.appbrand.netscene;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.protocal.c.aej;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class d extends k implements j {
    public final b cif;
    private e cxf;
    private a<d> dMc;

    public interface a<T extends k> {
        void c(int i, int i2, String str, T t);
    }

    public d(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, a<d> aVar) {
        this(str, linkedList, i, str2, str3, i2);
        this.dMc = aVar;
    }

    private d(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2) {
        v.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d]", new Object[]{str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2)});
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aei();
        aVar.czo = new aej();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar.czm = 1029;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aei com_tencent_mm_protocal_c_aei = (aei) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aei.glj = str;
        com_tencent_mm_protocal_c_aei.mEH = linkedList;
        com_tencent_mm_protocal_c_aei.mEK = i;
        com_tencent_mm_protocal_c_aei.glb = str2;
        com_tencent_mm_protocal_c_aei.mEL = str3;
        com_tencent_mm_protocal_c_aei.mEJ = i2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
        if (this.dMc != null) {
            this.dMc.c(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1029;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
