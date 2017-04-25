package com.tencent.mm.plugin.bbom;

import com.tencent.mm.e.a.ii;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.f.a.c.a;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.o;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class g implements a {
    public final void c(bm bmVar) {
        final String a = m.a(bmVar.mbU);
        if (!(be.kS(a) || ((d) com.tencent.mm.kernel.g.f(d.class)).wH().LZ(a))) {
            ab.a.crZ.I(a, SQLiteDatabase.KeyEmpty);
        }
        if (com.tencent.mm.model.m.dE(a)) {
            final o LD = ak.yW().wO().LD(a);
            ak.yW();
            com.tencent.mm.i.a LX = c.wH().LX(a);
            if (LX == null || ((int) LX.chr) <= 0) {
                ab.a.crZ.a(a, null, new ab.c.a(this) {
                    final /* synthetic */ g enY;

                    public final void p(String str, boolean z) {
                        if (LD != null && LD.bvd()) {
                            b iiVar = new ii();
                            iiVar.biD.biB = a;
                            iiVar.biD.biE = LD.bvc();
                            com.tencent.mm.sdk.c.a.nhr.z(iiVar);
                        }
                    }
                });
            } else if (LD.bvd()) {
                b iiVar = new ii();
                iiVar.biD.biB = a;
                iiVar.biD.biE = LD.bvc();
                com.tencent.mm.sdk.c.a.nhr.z(iiVar);
            }
        }
    }
}
