package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ak.n;
import com.tencent.mm.e.a.z;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

final class b extends c<z> {
    b() {
        this.nhz = z.class.getName().hashCode();
    }

    private static boolean a(z zVar) {
        if (!(zVar instanceof z)) {
            v.f("MicroMsg.QQMail.EventListener", "not bind qq event");
        } else if (zVar.aXk.aXm == 0) {
            try {
                ak.yW();
                com.tencent.mm.model.c.vf().set(17, Integer.valueOf(2));
                int xQ = k.xQ() | 1;
                ak.yW();
                com.tencent.mm.model.c.vf().set(34, Integer.valueOf(xQ));
                ak.yW();
                com.tencent.mm.model.c.wG().b(new n("", "", "", "", "", "", "", "", xQ, "", ""));
                x.aHI();
                v.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
            } catch (Throwable e) {
                v.a("MicroMsg.QQMail.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
