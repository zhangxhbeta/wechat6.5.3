package com.tencent.mm.kernel.a;

import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;

public final class b {
    private f<e> cjN = new f();
    private boolean cld = false;
    private HashMap<Class<? extends e>, e> cle = new HashMap();
    public c clf;

    protected final synchronized d<Void> a(com.tencent.mm.vending.h.d dVar) {
        c bp;
        final long currentTimeMillis = System.currentTimeMillis();
        a("boot start to execute task on scheduler [%s]...", dVar.getType());
        this.cld = true;
        final ArrayList vq = this.cjN.vq();
        a("boot task execution chain ... %s", vq);
        ArrayList vp = this.cjN.vp();
        if (vp.size() > 0) {
            throw new RuntimeException("Found cycle dependencies! Between " + vp);
        }
        a("boot check tasks cycle dependency ok...", new Object[0]);
        bp = g.bKO().bp(true);
        final ProcessProfile uZ = com.tencent.mm.kernel.g.vt().uZ();
        bp.b(dVar).c(new a<Void, Void>(this) {
            final /* synthetic */ b clh;

            public final /* synthetic */ Object aq(Object obj) {
                Iterator it = vq.iterator();
                while (it.hasNext()) {
                    b.a((e) it.next(), uZ);
                }
                b.a("boot task execution all done in [%s].", b.H(currentTimeMillis));
                return null;
            }
        });
        return bp.bKK();
    }

    public static void a(e eVar, ProcessProfile processProfile) {
        a("boot task executing [%s]...", eVar);
        eVar.execute(processProfile);
    }

    public final synchronized void a(e eVar, e eVar2) {
        Assert.assertNotNull(eVar);
        if (!this.cle.containsKey(eVar.getClass())) {
            this.cle.put(eVar.getClass(), eVar);
        }
        this.cjN.n(eVar, eVar2);
    }

    public static final void a(String str, Object... objArr) {
        if (objArr.length == 0) {
            v.i("MMKernel.Boot", str);
        } else {
            v.i("MMKernel.Boot", str, objArr);
        }
    }

    public static String H(long j) {
        return (System.currentTimeMillis() - j) + "ms";
    }
}
