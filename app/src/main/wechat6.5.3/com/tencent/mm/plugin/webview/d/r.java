package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azw;
import com.tencent.mm.protocal.c.azx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class r extends k implements j {
    public final b cif;
    private e cxf;

    public r(String str, String str2) {
        a aVar = new a();
        aVar.czn = new azw();
        aVar.czo = new azx();
        aVar.uri = "/cgi-bin/mmbiz-bin/transid";
        aVar.czm = 1142;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        azw com_tencent_mm_protocal_c_azw = (azw) this.cif.czk.czs;
        com_tencent_mm_protocal_c_azw.bmJ = str;
        com_tencent_mm_protocal_c_azw.mWE = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1142;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
