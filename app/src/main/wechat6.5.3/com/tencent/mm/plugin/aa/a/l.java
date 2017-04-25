package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public final class l implements com.tencent.mm.vending.c.b<k> {
    protected k dsG;
    public final a dsH;
    public final b dsI;

    public class a implements e<Boolean, c<Integer, Map<String, Object>>> {
        final /* synthetic */ l dsJ;

        public a(l lVar) {
            this.dsJ = lVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            c cVar = (c) obj;
            this.dsJ.dsG.c(((Integer) cVar.get(0)).intValue(), (Map) cVar.get(1));
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<d<Boolean, String, Long>, Map<String, Object>> {
        final /* synthetic */ l dsJ;

        public b(l lVar) {
            this.dsJ = lVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            this.dsJ.dsG.m((Map) obj);
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.dsG;
    }

    public l() {
        this(new k());
    }

    private l(k kVar) {
        this.dsH = new a(this);
        this.dsI = new b(this);
        this.dsG = kVar;
    }

    public final k NA() {
        return this.dsG;
    }
}
