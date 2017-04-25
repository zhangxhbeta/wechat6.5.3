package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ak.n;
import com.tencent.mm.e.a.z;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

final class a extends c<z> {
    a() {
        this.nhz = z.class.getName().hashCode();
    }

    private static boolean a(z zVar) {
        if (!(zVar instanceof z)) {
            v.f("MicroMsg.QMsg.EventListener", "not bind qq event");
        } else if (zVar.aXk.aXm == 0) {
            try {
                int xQ = k.xQ() | 32;
                ak.yW();
                com.tencent.mm.model.c.vf().set(34, Integer.valueOf(xQ));
                ak.yW();
                com.tencent.mm.model.c.wG().b(new n("", "", "", "", "", "", "", "", xQ, "", ""));
                g.aHn();
                v.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
            } catch (Throwable e) {
                v.a("MicroMsg.QMsg.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
