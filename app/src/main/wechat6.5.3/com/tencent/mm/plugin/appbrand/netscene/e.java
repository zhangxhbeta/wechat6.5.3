package com.tencent.mm.plugin.appbrand.netscene;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.protocal.c.aeh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class e extends k implements j {
    public final b cif;
    private com.tencent.mm.v.e cxf;
    private a<e> dMd;

    public interface a<T extends k> {
        void c(int i, int i2, String str, T t);
    }

    public e(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, a<e> aVar) {
        this(str, linkedList, i, str2, i2, i3);
        this.dMd = aVar;
    }

    private e(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3) {
        v.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d]", new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3)});
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aeg();
        aVar.czo = new aeh();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        aVar.czm = 1117;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aeg com_tencent_mm_protocal_c_aeg = (aeg) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aeg.glj = str;
        com_tencent_mm_protocal_c_aeg.mEH = linkedList;
        com_tencent_mm_protocal_c_aeg.mEK = i;
        com_tencent_mm_protocal_c_aeg.mEL = str2;
        com_tencent_mm_protocal_c_aeg.mEJ = i2;
        com_tencent_mm_protocal_c_aeg.mEI = i3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
        if (this.dMd != null) {
            this.dMd.c(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1117;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
