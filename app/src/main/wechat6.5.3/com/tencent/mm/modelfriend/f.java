package com.tencent.mm.modelfriend;

import com.tencent.mm.e.a.er;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class f extends c<er> {
    public f() {
        this.nhz = er.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        er erVar = (er) bVar;
        if (erVar instanceof er) {
            erVar.bdq.bdt = true;
            if (!be.kS(m.iI(erVar.bdp.bdr))) {
                erVar.bdq.bdt = false;
            } else if (be.kS(m.iI(erVar.bdp.bds))) {
                v.i("MicroMsg.FMessageMobileFilterListenerImpl", "mobile fmessage not found by phonemd5 or fullphonemd5");
            } else {
                erVar.bdq.bdt = false;
            }
        }
        return false;
    }
}
