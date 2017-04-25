package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.e.a.gk;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class c extends com.tencent.mm.sdk.c.c<gk> {
    public c() {
        this.nhz = gk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gk gkVar = (gk) bVar;
        if (gkVar instanceof gk) {
            v.i("MicroMsg.GetSoterSupportEventListener", "hy: request is support soter");
            if (k.aYJ() && k.cB(aa.getContext())) {
                gkVar.bfV.bfW = 1;
            } else {
                gkVar.bfV.bfW = 0;
            }
        }
        return true;
    }
}
