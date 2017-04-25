package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.el;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ak.a;
import com.tencent.mm.pluginsdk.j.q.e;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends c<el> {
    public b() {
        this.nhz = el.class.getName().hashCode();
    }

    private boolean a(final el elVar) {
        if (elVar instanceof el) {
            a aSu = ad.aSu();
            aSu.a(elVar.bcP.type, elVar.bcP.username, new e.a(this) {
                final /* synthetic */ b jaz;

                public final void b(boolean z, String str, boolean z2) {
                }

                public final void a(boolean z, boolean z2, String str, boolean z3) {
                    if (elVar.bcP != null) {
                        elVar.bcP.bcT.a(null);
                    }
                }
            });
            aSu.b(1, elVar.bcP.username, elVar.bcP.bcR, elVar.bcP.bcS);
            return true;
        }
        v.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
        return false;
    }
}
