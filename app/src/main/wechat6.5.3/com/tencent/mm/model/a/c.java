package com.tencent.mm.model.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;

public final class c implements d {
    public final b b(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar == null || bmVar.mbW == null) {
            v.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
        } else {
            String a = m.a(bmVar.mbW);
            ak.yW();
            com.tencent.mm.model.c.vf().set(328193, a);
            b Aj = f.Aj();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Aj.gb(a);
                ak.yW();
                a = (String) com.tencent.mm.model.c.vf().get(328197, null);
                if (be.kS(a) || !(Aj.cvS == null || a.equals(Aj.cvS.cvO))) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(328197, Aj.cvS.cvO);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(328195, Boolean.valueOf(false));
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(328194, Boolean.valueOf(false));
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(328196, Boolean.valueOf(false));
                    v.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
                }
            } catch (Exception e) {
                v.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
            }
            v.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (f.Aj().Ah()) {
                e.gd(f.Aj().cvS.cvO);
            }
        }
        return null;
    }

    public final void d(at atVar) {
    }
}
