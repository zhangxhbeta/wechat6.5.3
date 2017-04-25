package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.protocal.c.zb;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    private final b cif;
    private e cii;
    public String eDn;

    public c(String str) {
        a aVar = new a();
        aVar.czn = new za();
        aVar.czo = new zb();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecard";
        aVar.czm = 904;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((za) this.cif.czk.czs).bol = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(904), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            zb zbVar = (zb) this.cif.czl.czs;
            v.v("MicroMsg.NetSceneGetShareCard", "json:" + zbVar.eDn);
            this.eDn = zbVar.eDn;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 904;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
