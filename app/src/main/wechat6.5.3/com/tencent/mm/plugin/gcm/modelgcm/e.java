package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gcm.modelgcm.c.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private p cAt;
    private com.tencent.mm.v.e cii = null;
    private String gAJ = null;
    private int uin = 0;

    public static class a implements p {
        private final com.tencent.mm.plugin.gcm.modelgcm.c.a gAK = new com.tencent.mm.plugin.gcm.modelgcm.c.a();
        private final b gAL = new b();
        int uin;

        public final /* bridge */ /* synthetic */ d ze() {
            return this.gAL;
        }

        public final int getType() {
            return 623;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/androidgcmreg";
        }

        public final c Bx() {
            this.gAK.lWP = com.tencent.mm.compatible.d.p.rK();
            this.gAK.lWO = com.tencent.mm.protocal.d.cmW;
            this.gAK.lWN = com.tencent.mm.protocal.d.lWh;
            this.gAK.cW(this.uin);
            return this.gAK;
        }

        public final boolean By() {
            return false;
        }

        public final int Bu() {
            return 0;
        }
    }

    public e(String str, int i) {
        this.gAJ = str;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        this.cAt = new a();
        ((a) this.cAt).uin = this.uin;
        ((com.tencent.mm.plugin.gcm.modelgcm.c.a) this.cAt.Bx()).gAF.lZl = this.gAJ;
        return a(eVar, this.cAt, this);
    }

    public final int getType() {
        return 623;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
