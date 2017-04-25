package com.tencent.mm.plugin.wear.model.g;

import com.tencent.mm.e.a.qz;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;

public final class b implements d {
    public final com.tencent.mm.v.d.b b(a aVar) {
        bm bmVar = aVar.czu;
        ak.yW();
        if (!be.kS((String) c.vf().get(2, ""))) {
            String a = m.a(bmVar.mbU);
            String a2 = m.a(bmVar.mbV);
            if (be.kS(a) || be.kS(a2)) {
                v.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
            } else {
                String a3 = m.a(bmVar.mbW);
                v.i("MicroMsg.YoExtension", "from  " + a + "content " + a3);
                a aVar2 = com.tencent.mm.plugin.wear.model.a.bhH().laY;
                synchronized (aVar2.lcs) {
                    qz DO = a.DO(a);
                    if (aVar2.lcs.containsKey(a) || DO.bsF.bsG == 1) {
                        v.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[]{a});
                        qz qzVar = new qz();
                        qzVar.bsE.aYt = 2;
                        qzVar.bsE.username = a;
                        com.tencent.mm.sdk.c.a.nhr.z(qzVar);
                    } else {
                        v.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[]{a});
                        aVar2.lcs.put(a, new a(aVar2, a, a3));
                    }
                }
                com.tencent.mm.plugin.wear.model.a.bhH().laY.bhW();
            }
        }
        return null;
    }

    public final void d(at atVar) {
    }
}
