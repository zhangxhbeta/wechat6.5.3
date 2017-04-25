package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ub;
import com.tencent.mm.protocal.c.uc;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class v extends k implements j {
    private final b cif;
    private e cii;
    public CardGiftInfo eDq;

    public v(int i, String str) {
        a aVar = new a();
        aVar.czn = new ub();
        aVar.czo = new uc();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
        aVar.czm = 1165;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ub ubVar = (ub) this.cif.czk.czs;
        ubVar.lZR = i;
        ubVar.lZS = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            uc ucVar = (uc) this.cif.czl.czs;
            this.eDq = new CardGiftInfo();
            this.eDq.bcB = ucVar.lZT;
            this.eDq.bmE = ucVar.lZU;
            this.eDq.eCa = ucVar.lZV;
            this.eDq.eCb = ucVar.content;
            this.eDq.eCc = ucVar.lZW;
            this.eDq.eCd = ucVar.lZX;
            this.eDq.eCe = ucVar.lZY;
            this.eDq.eCf = ucVar.lZZ;
            this.eDq.eCh = ucVar.mab;
            this.eDq.eCg = ucVar.maa;
            this.eDq.eCi = ucVar.mad;
            this.eDq.eCj = ucVar.mae;
            this.eDq.eCk = ucVar.maf;
            this.eDq.eCl = ucVar.mag;
            this.eDq.eCm = ucVar.mah;
            this.eDq.coN = ucVar.coN;
            this.eDq.eCn = ucVar.mai;
            this.eDq.eCo = ucVar.maj;
            this.eDq.eCp = ucVar.mak;
            this.eDq.eCq = ucVar.mal;
            this.eDq.eCr = ucVar.mam;
            this.eDq.eCs = ucVar.man;
            this.eDq.eCt = ucVar.mao;
            this.eDq.eCu = ucVar.maq;
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[]{this.eDq.toString()});
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1165;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
