package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gcm.modelgcm.d.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    private p cAt;
    private e cii = null;
    private String gAJ = null;
    private int uin = 0;

    public static class a implements p {
        private final com.tencent.mm.plugin.gcm.modelgcm.d.a gAM = new com.tencent.mm.plugin.gcm.modelgcm.d.a();
        private final b gAN = new b();
        int uin;

        public final /* bridge */ /* synthetic */ d ze() {
            return this.gAN;
        }

        public final int getType() {
            return 624;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/androidgcmunreg";
        }

        public final c Bx() {
            this.gAM.lWP = com.tencent.mm.compatible.d.p.rK();
            this.gAM.lWO = com.tencent.mm.protocal.d.cmW;
            this.gAM.lWN = com.tencent.mm.protocal.d.lWh;
            this.gAM.cW(this.uin);
            return this.gAM;
        }

        public final boolean By() {
            return false;
        }

        public final int Bu() {
            return 0;
        }
    }

    public f(String str, int i) {
        this.gAJ = str;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        this.cAt = new a();
        ((a) this.cAt).uin = this.uin;
        ((com.tencent.mm.plugin.gcm.modelgcm.d.a) this.cAt.Bx()).gAH.lZl = this.gAJ;
        return a(eVar, this.cAt, this);
    }

    public final int getType() {
        return 624;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
