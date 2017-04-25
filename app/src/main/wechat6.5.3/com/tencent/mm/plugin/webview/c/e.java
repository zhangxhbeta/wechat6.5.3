package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.protocal.c.aqo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private b cQA;
    private com.tencent.mm.v.e cii;

    public e(aqn com_tencent_mm_protocal_c_aqn) {
        a aVar = new a();
        aVar.czm = 1134;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchreport";
        aVar.czn = com_tencent_mm_protocal_c_aqn;
        aVar.czo = new aqo();
        this.cQA = aVar.Bv();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1134;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }
}
