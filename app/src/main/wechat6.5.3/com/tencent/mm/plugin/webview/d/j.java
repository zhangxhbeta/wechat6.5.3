package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yn;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class j extends k implements com.tencent.mm.network.j {
    public final b cif;
    private e cxf;

    public j(String str, String str2, int i, int i2) {
        v.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.czn = new yn();
        aVar.czo = new yo();
        aVar.uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
        aVar.czm = 673;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        yn ynVar = (yn) this.cif.czk.czs;
        ynVar.URL = str;
        ynVar.mAs = str2;
        ynVar.Width = i;
        ynVar.Height = i2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        this.cxf.a(i2, i3, str, this);
        if (i2 != 0 || i3 != 0) {
            v.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final int getType() {
        return 673;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
