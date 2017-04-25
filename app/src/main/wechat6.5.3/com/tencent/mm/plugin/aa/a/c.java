package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public final class c implements b<b> {
    protected b dsb;
    public final a dsc;

    public class a implements e<t, d<String, Integer, String>> {
        final /* synthetic */ c dsd;

        public a(c cVar) {
            this.dsd = cVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            d dVar = (d) obj;
            b bVar = this.dsd.dsb;
            ak.vy().a(new i((String) dVar.get(0), ((Integer) dVar.get(1)).intValue(), (String) dVar.get(2)), 0);
            bVar.dsa = g.bKP();
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.dsb;
    }

    public c() {
        this(new b());
    }

    private c(b bVar) {
        this.dsc = new a(this);
        this.dsb = bVar;
    }

    public final b Nq() {
        return this.dsb;
    }
}
