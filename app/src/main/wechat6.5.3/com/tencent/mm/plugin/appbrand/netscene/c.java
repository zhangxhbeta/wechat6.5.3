package com.tencent.mm.plugin.appbrand.netscene;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aec;
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class c extends k implements j {
    public final b cif;
    private e cxf;
    private a<c> dMb;

    public interface a<T extends k> {
        void c(int i, int i2, String str, T t);
    }

    public c(String str, LinkedList<String> linkedList, int i, int i2, a<c> aVar) {
        this(str, linkedList, i, i2);
        this.dMb = aVar;
    }

    private c(String str, LinkedList<String> linkedList, int i, int i2) {
        v.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aec();
        aVar.czo = new aed();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        aVar.czm = 1158;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aec com_tencent_mm_protocal_c_aec = (aec) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aec.glj = str;
        com_tencent_mm_protocal_c_aec.mEH = linkedList;
        com_tencent_mm_protocal_c_aec.mEJ = i;
        com_tencent_mm_protocal_c_aec.mEI = i2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
        if (this.dMb != null) {
            this.dMb.c(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1158;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
