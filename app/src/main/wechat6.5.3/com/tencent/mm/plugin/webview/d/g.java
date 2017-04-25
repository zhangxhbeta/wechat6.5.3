package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.sl;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    private e cii;
    public final b fut;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.czn = new sl();
        aVar.czo = new sm();
        aVar.uri = "/cgi-bin/mmbiz-bin/getappticket";
        aVar.czm = 1097;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        sl slVar = (sl) this.fut.czk.czs;
        slVar.bmJ = str;
        slVar.bCj = str2;
    }

    public final int getType() {
        return 1097;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetAppTicket", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }
}
