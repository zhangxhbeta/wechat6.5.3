package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.gs;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends c<gs> {
    private k jaC;
    private String jaF;
    private azr jaG;

    public e() {
        this.nhz = gs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gs gsVar = (gs) bVar;
        if (gsVar instanceof gs) {
            this.jaF = gsVar.bgj.bap;
            this.jaC = ad.aSE().Bq(this.jaF);
            this.jaG = this.jaC.aUp();
            if (this.jaG != null) {
                gsVar.bgk.bgl = this.jaG;
                return true;
            }
        }
        v.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }
}
