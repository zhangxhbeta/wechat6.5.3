package com.tencent.mm.plugin.sns.k;

import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a kco;
    public final a kcp;
    public final b kcq;

    public class a implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
        final /* synthetic */ b kcr;

        public a(b bVar) {
            this.kcr = bVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            a aVar = this.kcr.kco;
            String str = (String) eVar.get(0);
            ((Boolean) eVar.get(1)).booleanValue();
            aVar.e(str, ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
            return phb;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }

        public final c<Void> b(String str, boolean z, boolean z2, int i) {
            return g.a(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).c(this);
        }
    }

    public class b implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
        final /* synthetic */ b kcr;

        public b(b bVar) {
            this.kcr = bVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            a aVar = this.kcr.kco;
            String str = (String) eVar.get(0);
            ((Boolean) eVar.get(1)).booleanValue();
            aVar.f(str, ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
            return phb;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }

        public final c<Void> b(String str, boolean z, boolean z2, int i) {
            return g.a(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).c(this);
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.kco;
    }

    public b() {
        this(new a());
    }

    private b(a aVar) {
        this.kcp = new a(this);
        this.kcq = new b(this);
        this.kco = aVar;
    }

    public final a aYx() {
        return this.kco;
    }
}
