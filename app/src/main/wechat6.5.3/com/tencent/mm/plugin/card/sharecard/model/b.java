package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.protocal.c.uk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private final com.tencent.mm.v.b cif;
    private e cii;
    public String eDn;
    public String eEw = "";

    public b(double d, double d2, String str) {
        a aVar = new a();
        aVar.czn = new uj();
        aVar.czo = new uk();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
        aVar.czm = 1164;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        uj ujVar = (uj) this.cif.czk.czs;
        ujVar.latitude = d;
        ujVar.longitude = d2;
        ujVar.eEw = str;
        ak.yW();
        ujVar.mxc = (String) c.vf().get(t.a.npF, "");
        v.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ujVar.mxc);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(1164), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            uk ukVar = (uk) this.cif.czl.czs;
            v.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + ukVar.eDn);
            this.eDn = ukVar.eDn;
            this.eEw = ukVar.eEw;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1164;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
