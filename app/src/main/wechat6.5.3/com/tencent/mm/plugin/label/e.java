package com.tencent.mm.plugin.label;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public class e implements ag {
    private static HashMap<Integer, c> bXq;
    private z gPP;
    private d gPQ = new d();

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return z.cic;
            }
        });
        bXq.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return y.cic;
            }
        });
    }

    private static e avJ() {
        e eVar = (e) ak.yP().fY("plugin.label");
        if (eVar == null) {
            synchronized (e.class) {
                if (eVar == null) {
                    eVar = new e();
                    ak.yP().a("plugin.label", eVar);
                }
            }
        }
        return eVar;
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        a.lxT = new b();
        com.tencent.mm.sdk.c.a.nhr.e(this.gPQ);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        a.lxT = null;
        com.tencent.mm.sdk.c.a.nhr.f(this.gPQ);
    }

    public static z avK() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (avJ().gPP == null) {
            e avJ = avJ();
            ak.yW();
            avJ.gPP = new z(com.tencent.mm.model.c.wE());
        }
        return avJ().gPP;
    }
}
