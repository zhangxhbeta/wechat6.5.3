package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.e.a.kb;
import com.tencent.mm.plugin.scanner.b.n.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class j extends c<kb> {
    public j() {
        this.nhz = kb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kb kbVar = (kb) bVar;
        switch (kbVar.bkO.opType) {
            case 0:
                a aN = i.aN(kbVar.bkO.bkQ, 0);
                if (aN != null) {
                    kbVar.bkP.bkR = i.a(kbVar.bkO.context, aN);
                    kbVar.bkP.bdZ = com.tencent.mm.plugin.scanner.b.aKP().cr(aN.field_thumburl, "@S");
                    kbVar.bkP.aYN = true;
                    break;
                }
                v.w("MicroMsg.ProductOperationListener", "error, xml[%s] can not parse", new Object[]{kbVar.bkO.bkQ});
                kbVar.bkP.aYN = false;
                break;
        }
        return false;
    }
}
