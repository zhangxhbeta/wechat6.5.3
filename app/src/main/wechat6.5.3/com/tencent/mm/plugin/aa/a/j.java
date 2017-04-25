package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.aa.a.a.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public final class j implements com.tencent.mm.vending.c.b<i> {
    protected i dss;
    public final b dst;
    public final a dsu;

    public class a implements e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>> {
        final /* synthetic */ j dsv;

        public a(j jVar) {
            this.dsv = jVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            i iVar = this.dsv.dss;
            String str = (String) eVar.get(0);
            int intValue = ((Integer) eVar.get(1)).intValue();
            String str2 = (String) eVar.get(2);
            long longValue = ((Long) eVar.get(3)).longValue();
            iVar.czg = g.bKJ();
            iVar.bao = longValue;
            if (be.kS(str)) {
                iVar.czg.bo(Boolean.valueOf(false));
            } else {
                ak.vy().a(new d(str, intValue, str2), 0);
                v.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", new Object[]{str, Integer.valueOf(intValue)});
                iVar.czg = g.bKP();
            }
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<Boolean, com.tencent.mm.vending.j.d<String, Integer, String>> {
        final /* synthetic */ j dsv;

        public b(j jVar) {
            this.dsv = jVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            i iVar = this.dsv.dss;
            String str = (String) dVar.get(0);
            int intValue = ((Integer) dVar.get(1)).intValue();
            String str2 = (String) dVar.get(2);
            iVar.czg = g.bKJ();
            if (be.kS(str)) {
                iVar.czg.bo(Boolean.valueOf(false));
            } else {
                ak.vy().a(new d(str, intValue, str2), 0);
                v.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", new Object[]{str, Integer.valueOf(intValue)});
                iVar.czg = g.bKP();
            }
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.dss;
    }

    public j() {
        this(new i());
    }

    private j(i iVar) {
        this.dst = new b(this);
        this.dsu = new a(this);
        this.dss = iVar;
    }

    public final i Nz() {
        return this.dss;
    }
}
