package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.protocal.c.mv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private String bol = "";
    private final b cif;
    private e cii;
    public int eDo;

    public a(String str) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new mu();
        aVar.czo = new mv();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
        aVar.czm = 1163;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((mu) this.cif.czk.czs).bol = str;
        this.bol = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(1163), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            mv mvVar = (mv) this.cif.czl.czs;
            v.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + mvVar.eDo);
            this.eDo = mvVar.eDo;
            if (this.eDo == 0) {
                af.aas().qb(this.bol);
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1163;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
