package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.aa.a.a.g;
import com.tencent.mm.vending.c.b;

public final class e implements b<d> {
    protected d dsl;
    public final a dsm;

    public class a implements com.tencent.mm.vending.h.e<Void, Void> {
        final /* synthetic */ e dsn;

        public a(e eVar) {
            this.dsn = eVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            d dVar = this.dsn.dsl;
            ak.vy().a(new g(), 0);
            dVar.dsa = com.tencent.mm.vending.g.g.bKP();
            return phb;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.dsl;
    }

    public e() {
        this(new d());
    }

    private e(d dVar) {
        this.dsm = new a(this);
        this.dsl = dVar;
    }

    public final d Nw() {
        return this.dsl;
    }
}
