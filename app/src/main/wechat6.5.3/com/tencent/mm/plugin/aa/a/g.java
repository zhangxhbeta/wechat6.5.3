package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public final class g implements b<f> {
    protected f dsp;
    public final a dsq;

    public class a implements e<c<String, String>, com.tencent.mm.vending.j.e<String, Long, Integer, String>> {
        final /* synthetic */ g dsr;

        public a(g gVar) {
            this.dsr = gVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            f fVar = this.dsr.dsp;
            String str = (String) eVar.get(0);
            long longValue = ((Long) eVar.get(1)).longValue();
            int intValue = ((Integer) eVar.get(2)).intValue();
            String str2 = (String) eVar.get(3);
            if (fVar.dso) {
                v.e("MicroMsg.AAPayLogic", "aaPay, isPaying!");
            } else {
                ak.vy().a(new h(str, longValue, intValue, str2), 0);
                fVar.dsa = com.tencent.mm.vending.g.g.bKP();
                fVar.dso = true;
            }
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.dsp;
    }

    public g() {
        this(new f());
    }

    private g(f fVar) {
        this.dsq = new a(this);
        this.dsp = fVar;
    }

    public final f Nx() {
        return this.dsp;
    }
}
