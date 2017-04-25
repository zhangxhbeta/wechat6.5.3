package com.tencent.mm.ab;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.subapp.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class d implements ag {
    private static HashMap<Integer, c> bXq;
    private b cKr;
    private c cKs;

    private static d Gf() {
        a aVar = (a) ak.yP().fY("plugin.subapp");
        d dVar = (d) aVar.Cq(d.class.getName());
        if (dVar != null) {
            return dVar;
        }
        Object dVar2 = new d();
        aVar.b(d.class.getName(), dVar2);
        return dVar2;
    }

    public static b Gg() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Gf().cKr == null) {
            d Gf = Gf();
            ak.yW();
            Gf.cKr = new b(com.tencent.mm.model.c.wE());
        }
        return Gf().cKr;
    }

    public final void th() {
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new c() {
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

    public final void aG(boolean z) {
        if (this.cKs == null) {
            this.cKs = new c();
        }
        ab.a.crZ = this.cKs;
        v.d("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", this.cKs);
    }

    public final void aH(boolean z) {
    }
}
