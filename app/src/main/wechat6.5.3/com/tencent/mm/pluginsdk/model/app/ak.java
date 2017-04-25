package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ak extends k implements j {
    private b cif;
    private e cii;
    private int dbA;
    private String gjS;

    public ak(int i, String str) {
        a aVar = new a();
        aVar.czn = new rn();
        aVar.czo = new ro();
        aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        aVar.czm = 427;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        rn rnVar = (rn) this.cif.czk.czs;
        rnVar.mio = d.lWb;
        rnVar.mip = d.lWa;
        rnVar.miq = d.lWd;
        rnVar.mir = d.lWe;
        rnVar.mis = u.bsY();
        rnVar.itQ = i;
        rnVar.mit = str;
        this.dbA = i;
        this.gjS = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MircoMsg.NetsceneGameKVReport", "errType = " + i2 + ", errCode = " + i3 + ", logId = " + this.dbA + ", logExt = " + this.gjS);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 427;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
