package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.a.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import java.util.List;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a dtb;
    public final a dtc;

    public class a implements e<c<List, String>, Boolean> {
        final /* synthetic */ b dtd;

        public a(b bVar) {
            this.dtd = bVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            Boolean bool = (Boolean) obj;
            a aVar = this.dtd.dtb;
            int i = 20;
            if (bool.booleanValue() && aVar.dsY > 0) {
                i = aVar.dsY;
                aVar.dsY = 0;
            }
            v.i("MicroMsg.AAQueryListInteractor", "getNextAAQueryPage, currentPageOffset: %s, force: %s", new Object[]{Integer.valueOf(aVar.dsY), Boolean.valueOf(r2)});
            com.tencent.mm.vending.g.b bKJ = g.bKJ();
            bKJ.bKI();
            new com.tencent.mm.plugin.aa.a.a.b(i, aVar.dsY).Bt().a(new AnonymousClass1(aVar, bKJ));
            return null;
        }

        public final String Ns() {
            return "Vending.ANY";
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.dtb;
    }

    public b() {
        this(new a());
    }

    private b(a aVar) {
        this.dtc = new a(this);
        this.dtb = aVar;
    }
}
