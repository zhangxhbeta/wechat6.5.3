package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private final b cif;
    private e cii;
    public String eDn;
    public int eDo;
    public String eDp;

    public d(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new yw();
        aVar.czo = new yx();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
        aVar.czm = 910;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        yw ywVar = (yw) this.cif.czk.czs;
        ywVar.bol = str;
        ywVar.scene = 20;
        ywVar.eBK = str2;
        ywVar.code = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(910), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            yx yxVar = (yx) this.cif.czl.czs;
            v.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + yxVar.eDn);
            this.eDn = yxVar.eDn;
            this.eDp = yxVar.eDp;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 910;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
