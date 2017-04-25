package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.ab.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;

public final class j extends k implements com.tencent.mm.network.j {
    private WakerLock bXE = new WakerLock(aa.getContext());
    private final p cAt;
    private e cii;

    public static class a extends i {
        private final com.tencent.mm.protocal.ab.a cRD = new com.tencent.mm.protocal.ab.a();
        private final b cRE = new b();

        protected final c zd() {
            return this.cRD;
        }

        public final d ze() {
            return this.cRE;
        }

        public final int getType() {
            return 39;
        }

        public final String getUri() {
            return null;
        }

        public final int Bu() {
            return 1;
        }
    }

    public j() {
        this.bXE.lock(3000, "NetSceneSynCheck");
        this.cAt = new a();
        g.vx();
        if (g.vw() != null) {
            g.vx();
            if (g.vw().vf() != null) {
                g.vx();
                com.tencent.mm.protocal.ab.a aVar = (com.tencent.mm.protocal.ab.a) this.cAt.Bx();
                aVar.cRq = be.KG((String) g.vw().vf().get(8195, null));
                com.tencent.mm.protocal.ab.a aVar2 = (com.tencent.mm.protocal.ab.a) this.cAt.Bx();
                g.vx();
                aVar2.uin = g.vu().uin;
                ((com.tencent.mm.protocal.ab.a) this.cAt.Bx()).netType = com.tencent.mm.protocal.a.getNetType(aa.getContext());
                ((com.tencent.mm.protocal.ab.a) this.cAt.Bx()).lWW = com.tencent.mm.protocal.a.brq();
                v.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
                return;
            }
        }
        v.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        int a = a(eVar, this.cAt, this);
        if (a == -1 && this.bXE.isLocking()) {
            this.bXE.unLock();
        }
        return a;
    }

    public final boolean Bz() {
        return true;
    }

    public final int getType() {
        return 39;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        b bVar = (b) pVar.ze();
        v.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + bVar.lXy);
        if (g.uz() && !com.tencent.mm.kernel.a.uG()) {
            byte[] bArr2 = ((com.tencent.mm.protocal.ab.a) pVar.Bx()).cjG;
            if (be.bl(bArr2)) {
                v.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
            }
            bVar.cjG = bArr2;
            ((com.tencent.mm.plugin.zero.a.d) g.f(com.tencent.mm.plugin.zero.a.d.class)).Ho().a(bVar.lXy, 2, bVar.brF());
        }
        this.cii.a(i2, i3, str, this);
        this.bXE.unLock();
    }
}
