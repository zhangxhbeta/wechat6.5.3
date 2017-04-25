package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class m extends k implements j {
    private final b cif;
    private e cii;
    public CardGiftInfo eDq;

    public m(int i, String str) {
        a aVar = new a();
        aVar.czn = new ag();
        aVar.czo = new ah();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
        aVar.czm = 1136;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ag agVar = (ag) this.cif.czk.czs;
        agVar.lZR = i;
        agVar.lZS = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ah ahVar = (ah) this.cif.czl.czs;
            this.eDq = new CardGiftInfo();
            this.eDq.bcB = ahVar.lZT;
            this.eDq.bmE = ahVar.lZU;
            this.eDq.eCa = ahVar.lZV;
            this.eDq.eCb = ahVar.content;
            this.eDq.eCc = ahVar.lZW;
            this.eDq.eCd = ahVar.lZX;
            this.eDq.eCe = ahVar.lZY;
            this.eDq.eCf = ahVar.lZZ;
            this.eDq.eCh = ahVar.mab;
            this.eDq.eCg = ahVar.maa;
            this.eDq.eCi = ahVar.mad;
            this.eDq.eCj = ahVar.mae;
            this.eDq.eCk = ahVar.maf;
            this.eDq.eCl = ahVar.mag;
            this.eDq.eCm = ahVar.mah;
            this.eDq.coN = ahVar.coN;
            this.eDq.eCn = ahVar.mai;
            this.eDq.eCo = ahVar.maj;
            this.eDq.eCp = ahVar.mak;
            this.eDq.eCq = ahVar.mal;
            this.eDq.eCr = ahVar.mam;
            this.eDq.eCs = ahVar.man;
            this.eDq.eCt = ahVar.mao;
            this.eDq.eCu = ahVar.maq;
            v.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[]{this.eDq.toString()});
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1136;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
