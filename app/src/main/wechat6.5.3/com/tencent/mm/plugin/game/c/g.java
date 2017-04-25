package com.tencent.mm.plugin.game.c;

import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends f {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ LinkedList ghO;

        AnonymousClass1(LinkedList linkedList) {
            this.ghO = linkedList;
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            Iterator it = this.ghO.iterator();
            while (it.hasNext()) {
                Iterator it2 = f.l(((g) it.next()).optJSONArray("items")).iterator();
                while (it2.hasNext()) {
                    c cVar = (c) it2.next();
                    if (!be.kS(cVar.field_appId)) {
                        linkedList.add(cVar.field_appId);
                    }
                }
            }
            it = c.asJ().iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!linkedList.contains(fVar.field_appId)) {
                    am.bnB().b(fVar, new String[0]);
                    v.i("MicroMsg.GameDataSearchGameList", "delete appid : " + fVar.field_appId);
                }
            }
        }
    }

    protected g(String str) {
        super(str);
    }

    public final void arj() {
        LinkedList l = f.l(optJSONArray("items"));
        Iterator it = l.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            cVar.bF(cVar.ghn);
        }
        d.N(l);
    }
}
