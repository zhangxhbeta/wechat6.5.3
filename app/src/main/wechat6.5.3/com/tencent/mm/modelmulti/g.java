package com.tencent.mm.modelmulti;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    private p cAt;
    public long cQV = -1;
    private byte[] cRq;
    private e cii;
    private int uin = 0;

    public static class b implements p {
        private final com.tencent.mm.protocal.y.a cRr = new com.tencent.mm.protocal.y.a();
        private final com.tencent.mm.protocal.y.b cRs = new com.tencent.mm.protocal.y.b();
        int uin;

        public final /* bridge */ /* synthetic */ d ze() {
            return this.cRs;
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }

        public final c Bx() {
            this.cRr.lWP = com.tencent.mm.compatible.d.p.rK();
            this.cRr.lWO = com.tencent.mm.protocal.d.cmW;
            this.cRr.lWN = com.tencent.mm.protocal.d.lWh;
            this.cRr.cW(this.uin);
            return this.cRr;
        }

        public final boolean By() {
            return false;
        }

        public final int Bu() {
            return 0;
        }
    }

    public static class a extends i {
        private final com.tencent.mm.protocal.y.a cRr = new com.tencent.mm.protocal.y.a();
        private final com.tencent.mm.protocal.y.b cRs = new com.tencent.mm.protocal.y.b();

        protected final /* bridge */ /* synthetic */ c zd() {
            return this.cRr;
        }

        public final /* bridge */ /* synthetic */ d ze() {
            return this.cRs;
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }
    }

    public g(long j, byte[] bArr) {
        this.cQV = j;
        this.cRq = bArr;
    }

    public g(long j, byte[] bArr, int i) {
        this.cQV = j;
        this.cRq = bArr;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (be.bl(this.cRq)) {
            v.e("MicroMsg.NetSceneNotifyData", "dkpush %s", "get keyBuf failed");
            return -1;
        }
        if (this.uin == 0) {
            this.cAt = new a();
        } else {
            this.cAt = new b();
            ((b) this.cAt).uin = this.uin;
        }
        v.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", Long.valueOf(this.cQV), be.bj(this.cRq));
        ((com.tencent.mm.protocal.y.a) this.cAt.Bx()).cSJ = this.cQV;
        ((com.tencent.mm.protocal.y.a) this.cAt.Bx()).bdP = this.cRq;
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final int getType() {
        return 268369922;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.cii.a(i2, i3, str, this);
    }
}
