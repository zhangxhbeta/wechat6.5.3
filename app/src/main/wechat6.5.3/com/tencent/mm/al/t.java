package com.tencent.mm.al;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class t implements ag {
    private static HashMap<Integer, c> bXq;
    private p cUA = new p();
    private q cUB = new q();
    private r cUC = new r();
    private l cUD = null;
    private ah cUE = new ah(ak.vA().htb.getLooper(), new a(this) {
        final /* synthetic */ t cUF;

        {
            this.cUF = r1;
        }

        public final boolean oU() {
            v.d("MicroMsg.SubCorePacakge", "dkregcode Update RegonCode here TRULY!");
            s.HQ().update();
            return false;
        }

        public final String toString() {
            return super.toString() + "|regCodeUpdater";
        }
    }, false);
    private n cUx;
    private b cUy;
    private o cUz = new o();

    private static t HR() {
        t tVar = (t) ak.yP().fY(t.class.getName());
        if (tVar != null) {
            return tVar;
        }
        Object tVar2 = new t();
        ak.yP().a(t.class.getName(), tVar2);
        return tVar2;
    }

    public static n HS() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (HR().cUx == null) {
            t HR = HR();
            ak.yW();
            HR.cUx = new n(com.tencent.mm.model.c.wE());
        }
        return HR().cUx;
    }

    public static b HT() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (HR().cUy == null) {
            t HR = HR();
            ak.yW();
            HR.cUy = new b(com.tencent.mm.model.c.wE());
        }
        return HR().cUy;
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.cUz);
        com.tencent.mm.sdk.c.a.nhr.f(this.cUA);
        com.tencent.mm.sdk.c.a.nhr.f(this.cUB);
        com.tencent.mm.sdk.c.a.nhr.f(this.cUC);
        com.tencent.mm.sdk.c.a.nhr.f(this.cUD.cUr);
        com.tencent.mm.sdk.c.a.nhr.f(this.cUD.cUs);
    }

    public final void aG(boolean z) {
        if (z) {
            v.d("MicroMsg.SubCorePacakge", "dkregcode Update RegonCode here !");
            this.cUE.ea(10000);
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.cUz);
        com.tencent.mm.sdk.c.a.nhr.e(this.cUA);
        com.tencent.mm.sdk.c.a.nhr.e(this.cUB);
        com.tencent.mm.sdk.c.a.nhr.e(this.cUC);
        if (this.cUD != null) {
            this.cUD.cUq.clear();
        } else {
            this.cUD = new l();
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.cUD.cUr);
        com.tencent.mm.sdk.c.a.nhr.e(this.cUD.cUs);
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return n.cic;
            }
        });
        bXq.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return b.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }
}
