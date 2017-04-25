package com.tencent.mm.plugin.label.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.mj;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private final com.tencent.mm.v.b cif;
    private e cii;
    public String gPS = null;

    public b(String str) {
        a aVar = new a();
        aVar.czn = new mj();
        aVar.czo = new mk();
        aVar.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
        aVar.czm = 636;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.gPS = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 636;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        mj mjVar = (mj) this.cif.czk.czs;
        mjVar.moP = this.gPS;
        if (this.gPS == null || be.kS(this.gPS)) {
            v.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
            eVar2.a(3, -1, "[doScene]empty label is list.", this);
            return 0;
        }
        mjVar.moP = this.gPS;
        mjVar.moP = this.gPS;
        return a(eVar, this.cif, this);
    }
}
