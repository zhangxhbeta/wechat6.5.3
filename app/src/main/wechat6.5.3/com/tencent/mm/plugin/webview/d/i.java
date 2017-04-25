package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tn;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Map;

public final class i extends k implements j {
    public b cif;
    private e cii;

    public i(String str, String str2, Map<String, Object> map) {
        a aVar = new a();
        aVar.czn = new tn();
        aVar.czo = new to();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
        aVar.czm = 1393;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        tn tnVar = (tn) this.cif.czk.czs;
        tnVar.mop = str;
        tnVar.mwJ = str2;
        tnVar.mwI = (String) map.get("groupId");
        tnVar.kNT = (String) map.get("timestamp");
        tnVar.eKz = (String) map.get("nonceStr");
        tnVar.bCj = (String) map.get("signature");
        tnVar.mwK = map.get("params").toString();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1393;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
        return a(eVar, this.cif, this);
    }
}
