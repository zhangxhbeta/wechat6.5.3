package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class w extends k implements j {
    private b cif;
    private e cii;
    int lAE;
    v lAF;

    public w(int i, v vVar) {
        this.lAE = i;
        a aVar = new a();
        aVar.czn = new cg();
        aVar.czo = new ch();
        aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
        this.cif = aVar.Bv();
        cg cgVar = (cg) this.cif.czk.czs;
        byte[] arW = vVar.arW();
        if (arW != null) {
            cgVar.mcz = new are().ba(arW);
        }
        cgVar.efm = i;
        this.lAF = vVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.lAF.ap(m.a(((ch) this.cif.czl.czs).mcA));
            this.lAF.a(i, i2, i3, str, this.cif, bArr);
            this.cii.a(i2, i3, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 452;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
