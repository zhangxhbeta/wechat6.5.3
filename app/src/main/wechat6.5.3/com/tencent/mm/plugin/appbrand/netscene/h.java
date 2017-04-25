package com.tencent.mm.plugin.appbrand.netscene;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Locale;

public final class h extends k implements j {
    private b cxe;
    private e cxf;
    private bju owh;

    public h() {
        a aVar = new a();
        aVar.czn = new bjt();
        aVar.czo = new bju();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
        aVar.czm = 1170;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cxe = aVar.Bv();
    }

    public final int getType() {
        return 1170;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cxe, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.owh = (bju) this.cxe.czl.czs;
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
        ak.yW();
        r vf = c.vf();
        vf.a(t.a.pRF, Locale.getDefault().getLanguage());
        vf.a(t.a.pRG, this.owh.pRB.gIE);
        vf.a(t.a.pRH, this.owh.pRB.pRA);
        vf.a(t.a.pRI, Long.valueOf(System.currentTimeMillis()));
    }
}
