package com.tencent.mm.model.c;

import android.annotation.SuppressLint;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.b;
import com.tencent.mm.storage.d;
import com.tencent.mm.v.d.a;
import java.util.HashMap;

public class c implements ag {
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, com.tencent.mm.bg.g.c> bXq;
    private d cwf;
    private b cwg;
    private bo.b cwh = new bo.b(this) {
        final /* synthetic */ c cwj;

        {
            this.cwj = r1;
        }

        public final void a(a aVar) {
            String a = m.a(aVar.czu.mbW);
            v.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s" + a);
            a.a gi = a.gi(a);
            c.Au().bQ(gi.cwd);
            c.Av().bQ(gi.cwe);
        }
    };
    private com.tencent.mm.sdk.c.c cwi = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.d>(this) {
        final /* synthetic */ c cwj;

        {
            this.cwj = r2;
            this.nhz = com.tencent.mm.e.a.d.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (((com.tencent.mm.e.a.d) bVar).aWo.aWp) {
                b.Ao();
            }
            return true;
        }
    };

    private static c At() {
        c cVar = (c) ak.yP().fY(c.class.getName());
        if (cVar == null) {
            synchronized (c.class) {
                if (cVar == null) {
                    cVar = new c();
                    ak.yP().a(c.class.getName(), cVar);
                }
            }
        }
        return cVar;
    }

    public static d Au() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (At().cwf == null) {
            c At = At();
            ak.yW();
            At.cwf = new d(com.tencent.mm.model.c.wE());
        }
        return At().cwf;
    }

    public static b Av() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (At().cwg == null) {
            c At = At();
            ak.yW();
            At.cwg = new b(com.tencent.mm.model.c.wE());
        }
        return At().cwg;
    }

    public final void aG(boolean z) {
        ak.yU().a("newabtest", this.cwh, true);
        ak.yU().a("newabtestinfo", this.cwh, true);
        com.tencent.mm.sdk.c.a.nhr.e(this.cwi);
    }

    public final void th() {
        ak.yU().b("newabtest", this.cwh, true);
        ak.yU().b("newabtestinfo", this.cwh, true);
        com.tencent.mm.sdk.c.a.nhr.f(this.cwi);
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        bXq.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return b.cic;
            }
        });
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }
}
