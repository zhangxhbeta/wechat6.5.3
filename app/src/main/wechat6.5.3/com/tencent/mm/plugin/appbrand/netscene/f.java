package com.tencent.mm.plugin.appbrand.netscene;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aek;
import com.tencent.mm.protocal.c.ael;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    public final b cif;
    private e cxf;
    private a<f> dMe;

    public interface a<T extends k> {
        void c(int i, int i2, String str, T t);
    }

    public f(String str, String str2, String str3, int i, int i2, a<f> aVar) {
        this(str, str2, str3, i, i2);
        this.dMe = aVar;
    }

    private f(String str, String str2, String str3, int i, int i2) {
        v.i("MicroMsg.webview.NetSceneJSOperateWxData", "NetSceneJSLogin doScene appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d]", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aek();
        aVar.czo = new ael();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
        aVar.czm = 1133;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aek com_tencent_mm_protocal_c_aek = (aek) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aek.glj = str;
        com_tencent_mm_protocal_c_aek.eew = new com.tencent.mm.ba.b(str2.getBytes() == null ? new byte[0] : str2.getBytes());
        com_tencent_mm_protocal_c_aek.mEP = str3;
        com_tencent_mm_protocal_c_aek.mEJ = i;
        com_tencent_mm_protocal_c_aek.mEI = i2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneJSOperateWxData", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
        if (this.dMe != null) {
            this.dMe.c(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1133;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
