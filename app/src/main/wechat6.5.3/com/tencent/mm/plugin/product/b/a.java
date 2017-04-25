package com.tencent.mm.plugin.product.b;

import com.tencent.mm.e.a.kb;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends c<kb> {
    public a() {
        this.nhz = kb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = null;
        kb kbVar = (kb) bVar;
        switch (kbVar.bkO.opType) {
            case 1:
                com.tencent.mm.plugin.product.a.a.aFW();
                c aFX = com.tencent.mm.plugin.product.a.a.aFX();
                if (aFX != null) {
                    m b = m.b(null, kbVar.bkO.bkQ);
                    aFX.a(b, null);
                    kbVar.bkP.bkR = aFX.aGp();
                    kb.b bVar2 = kbVar.bkP;
                    if (!be.kS(b.aGs())) {
                        str = com.tencent.mm.plugin.product.ui.c.xK(b.aGs());
                    }
                    bVar2.bdZ = str;
                    kbVar.bkP.aYN = true;
                    break;
                }
                v.w("MicroMsg.MallProductListener", "error, xml[%s] can not parse", new Object[]{kbVar.bkO.bkQ});
                kbVar.bkP.aYN = false;
                break;
        }
        return false;
    }
}
