package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.vending.g.g;
import java.util.Map;

public class e implements com.tencent.mm.vending.c.b<d> {
    protected d dti;
    public final b dtj;
    public final c dtk;
    public final a dtl;

    public class a implements com.tencent.mm.vending.h.e<d, Void> {
        final /* synthetic */ e dtm;

        public a(e eVar) {
            this.dtm = eVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            g.a(g.bKO().c(this.dtm.dti.dth.dsm));
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.c<Integer, Map<String, Object>>> {
        final /* synthetic */ e dtm;

        public b(e eVar) {
            this.dtm = eVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            com.tencent.mm.vending.app.a aVar = this.dtm.dti;
            int intValue = ((Integer) cVar.get(0)).intValue();
            Map map = (Map) cVar.get(1);
            if (aVar.pgh.getIntExtra("enter_scene", 1) == 1) {
                map.put(k.dsB, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.drF));
            }
            g.a(g.s(Integer.valueOf(intValue), map).c(aVar.dtg.dsH));
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public class c implements com.tencent.mm.vending.h.e<com.tencent.mm.vending.j.d<Boolean, String, Long>, Map<String, Object>> {
        final /* synthetic */ e dtm;

        public c(e eVar) {
            this.dtm = eVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            Map map = (Map) obj;
            com.tencent.mm.vending.app.a aVar = this.dtm.dti;
            if (aVar.pgh.getIntExtra("enter_scene", 1) == 1) {
                map.put(k.dsB, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.drF));
            }
            g.a(g.br(map).c(aVar.dtg.dsI));
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.dti;
    }

    public e() {
        this(new d());
    }

    private e(d dVar) {
        this.dtj = new b(this);
        this.dtk = new c(this);
        this.dtl = new a(this);
        this.dti = dVar;
    }

    public final d NC() {
        return this.dti;
    }
}
