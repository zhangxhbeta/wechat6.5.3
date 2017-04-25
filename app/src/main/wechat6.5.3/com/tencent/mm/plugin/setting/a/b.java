package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif;
    private e cii;

    public b(String str) {
        a aVar = new a();
        aVar.czn = new rs();
        aVar.czo = new rt();
        aVar.uri = "/cgi-bin/micromsg-bin/generalset";
        aVar.czm = 177;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        rs rsVar = (rs) this.cif.czk.czs;
        rsVar.mpW = 1;
        rsVar.mvw = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneGeneralSet", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 177;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }
}
