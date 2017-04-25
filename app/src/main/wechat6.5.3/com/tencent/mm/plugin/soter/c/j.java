package com.tencent.mm.plugin.soter.c;

import android.content.Context;
import com.tencent.mm.e.a.oo;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class j extends c<oo> {
    public j() {
        this.nhz = oo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oo ooVar = (oo) bVar;
        com.tencent.mm.pluginsdk.l.c cVar = ooVar.bpQ.bpS;
        Context context = ooVar.bpQ.context;
        if (cVar == null || be.kS(cVar.getProcessName()) || context == null || com.tencent.mm.plugin.soter.b.aYz() == null || !com.tencent.mm.plugin.soter.b.aYz().containsKey(cVar.getProcessName())) {
            v.e("MicroMsg.SoterStartProcessEventListener", "hy: process err param invalid");
            k.a(1, "parameter error!", "", ooVar);
        } else {
            a aVar = (a) com.tencent.mm.plugin.soter.b.aYz().get(cVar.getProcessName());
            if (aVar != null) {
                aVar.a(context, cVar, ooVar);
            } else {
                v.e("MicroMsg.SoterStartProcessEventListener", "hy: process: %s is not registered", new Object[]{cVar.getProcessName()});
                k.a(2, "process not registered!", "", ooVar);
            }
        }
        return false;
    }
}
