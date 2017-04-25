package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.e.a.pb;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class l extends c<pb> {
    public l() {
        this.nhz = pb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pb pbVar = (pb) bVar;
        switch (pbVar.bqo.opType) {
            case 0:
                a zy = com.tencent.mm.plugin.shake.e.c.zy(pbVar.bqo.bqq);
                if (zy != null) {
                    pbVar.bqp.bkR = com.tencent.mm.plugin.shake.e.c.a(pbVar.bqo.context, zy);
                    pbVar.bqp.bdZ = k.cr(zy.field_thumburl, "@B");
                    pbVar.bqp.aYN = true;
                    break;
                }
                v.w("MicroMsg.TVOperationListener", "error, xml[%s] can not parse", new Object[]{pbVar.bqo.bqq});
                pbVar.bqp.aYN = false;
                break;
        }
        return false;
    }
}
