package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.di;
import com.tencent.mm.protocal.c.dj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j {
    public b cif;
    private e cii;
    public String url;

    public l(String str) {
        a aVar = new a();
        aVar.czm = 1080;
        aVar.uri = "/cgi-bin/mmbiz-bin/urlcheck/asyncurlcheck";
        aVar.czn = new di();
        aVar.czo = new dj();
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((di) this.cif.czk.czs).url = str;
        this.url = str;
        v.d("MicroMsg.NetSceneAsyncUrlCheck", "req url=" + str);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAsyncUrlCheck", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1080;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
