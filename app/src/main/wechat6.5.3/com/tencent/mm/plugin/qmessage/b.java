package com.tencent.mm.plugin.qmessage;

import com.tencent.mm.e.a.ke;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;

public final class b extends c<ke> {
    public b() {
        this.nhz = ke.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
        ke keVar = (ke) bVar;
        switch (keVar.bla.opType) {
            case 0:
                String str = keVar.bla.blc;
                String str2 = keVar.bla.bld;
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX(str);
                if (LX == null || ((int) LX.chr) == 0) {
                    LX = new u(str);
                    LX.tt();
                    LX.bS(str2);
                    LX.cY(4);
                    ak.yW();
                    com.tencent.mm.model.c.wH().N(LX);
                    com.tencent.mm.u.b.gB(LX.field_username);
                }
                d xU = g.aHl().xU(str);
                if (xU == null || be.ma(xU.getUsername()).length() <= 0) {
                    xU = new d();
                    xU.bkU = -1;
                    xU.hZH = 1;
                    xU.username = str;
                    xU.hZI = 0;
                    xU.hZJ = 0;
                    if (!g.aHl().a(xU)) {
                        v.e("MicroMsg.QMsgExtension", "processModQContact: insert qcontact failed");
                    }
                }
                keVar.blb.aYN = true;
                break;
            case 1:
                d xU2 = g.aHl().xU(keVar.bla.ble);
                if (xU2 != null && be.ma(xU2.getUsername()).length() > 0) {
                    if (xU2.hZI != ((long) keVar.bla.blf) || xU2.hZJ != ((long) keVar.bla.blg)) {
                        xU2.hZH = 1;
                        xU2.username = keVar.bla.ble;
                        xU2.hZI = (long) keVar.bla.blf;
                        xU2.hZJ = (long) keVar.bla.blg;
                        xU2.bkU = 56;
                        if (!g.aHl().a(xU2.getUsername(), xU2)) {
                            v.e("MicroMsg.QMsgOperationListener", "processModQContact: update qcontact failed");
                        }
                        keVar.blb.aYN = true;
                        break;
                    }
                    keVar.blb.aYN = true;
                    break;
                }
                xU2 = new d();
                xU2.bkU = -1;
                xU2.hZH = 1;
                xU2.username = keVar.bla.ble;
                xU2.hZI = (long) keVar.bla.blf;
                xU2.hZJ = (long) keVar.bla.blg;
                if (!g.aHl().a(xU2)) {
                    v.e("MicroMsg.QMsgOperationListener", "processModQContact: insert qcontact failed");
                }
                keVar.blb.aYN = true;
                break;
                break;
            case 2:
                g.aHm();
                break;
        }
        return false;
    }
}
