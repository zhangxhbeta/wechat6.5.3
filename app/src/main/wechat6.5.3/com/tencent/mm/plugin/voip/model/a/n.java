package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.voip.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public abstract class n<REQ, RESP> extends k implements j {
    protected b cif;
    e cii;
    private e fZt;
    protected com.tencent.mm.plugin.voip.model.e ksv = f.bbN();

    public abstract e bcT();

    public final void a(int i, final int i2, final int i3, final String str, p pVar, byte[] bArr) {
        cB(i2, i3);
        if (this.fZt != null) {
            this.fZt.a(i2, i3, str, this);
        }
        if (this.cii != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ n kvB;

                public final void run() {
                    if (this.kvB.cii != null) {
                        this.kvB.cii.a(i2, i3, str, this.kvB);
                    }
                }
            });
        }
    }

    public int bcU() {
        return 0;
    }

    public void cB(int i, int i2) {
    }

    public final void bcW() {
        v.d("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        ak.vy().a(this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int bcU = bcU();
        if (bcU != 0) {
            return bcU;
        }
        this.fZt = eVar2;
        this.cii = bcT();
        return a(eVar, this.cif, this);
    }

    public final <RESP> RESP bcX() {
        return this.cif.czl.czs;
    }

    public final <REQ> REQ bcY() {
        return this.cif.czk.czs;
    }
}
