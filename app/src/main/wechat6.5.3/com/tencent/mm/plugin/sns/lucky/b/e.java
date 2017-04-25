package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.lucky.b.f.b;
import com.tencent.mm.protocal.c.akg;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private final p cAt;
    private com.tencent.mm.v.e cii;
    public long jei;

    public static class a extends i {
        private final com.tencent.mm.plugin.sns.lucky.b.f.a jej = new com.tencent.mm.plugin.sns.lucky.b.f.a();
        final b jek = new b();

        protected final c zd() {
            return this.jej;
        }

        public final d ze() {
            return this.jek;
        }

        public final int getType() {
            return 428;
        }

        public final String getUri() {
            return null;
        }

        public final int Bu() {
            return 1;
        }

        public final boolean By() {
            return true;
        }
    }

    public e(com.tencent.mm.ba.b bVar, long j, int i) {
        v.i("MicroMsg.NetSceneSnsLuckyMoneyFlowControl", "NetSceneSnsLuckyMoneyFlowControl " + (bVar != null) + " " + j + " level:" + i);
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new akg();
        aVar.czo = new akh();
        aVar.czm = 428;
        aVar.czp = 319;
        aVar.czq = 1000000319;
        aVar.uri = "/cgi-bin/micromsg-bin/newyearsnsamountcheck2016";
        this.cAt = new a();
        com.tencent.mm.plugin.sns.lucky.b.f.a aVar2 = (com.tencent.mm.plugin.sns.lucky.b.f.a) this.cAt.Bx();
        ak.yW();
        aVar2.fvo = com.tencent.mm.model.c.ww();
        ((com.tencent.mm.plugin.sns.lucky.b.f.a) this.cAt.Bx()).jen = bVar;
        ((com.tencent.mm.plugin.sns.lucky.b.f.a) this.cAt.Bx()).jel = (int) j;
        ((com.tencent.mm.plugin.sns.lucky.b.f.a) this.cAt.Bx()).jem = i;
        this.jei = j;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSnsLuckyMoneyFlowControl", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 428;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        v.i("MicroMsg.NetSceneSnsLuckyMoneyFlowControl", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }
}
