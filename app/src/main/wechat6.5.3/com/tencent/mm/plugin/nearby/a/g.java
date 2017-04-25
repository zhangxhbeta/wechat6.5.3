package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ar.l;
import com.tencent.mm.e.a.hl;
import com.tencent.mm.e.a.ho;
import com.tencent.mm.e.a.ij;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.ow;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g implements ag {
    private c eOy = new c<ow>(this) {
        final /* synthetic */ g hEN;

        {
            this.hEN = r2;
            this.nhz = ow.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ow owVar = (ow) bVar;
            if (owVar.bqh.bqi.equals(ij.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.hEN.hEJ.bmG();
                } else {
                    this.hEN.hEJ.avH();
                }
            } else if (owVar.bqh.bqi.equals(ik.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.hEN.hEK.bmG();
                } else {
                    this.hEN.hEK.avH();
                }
            } else if (owVar.bqh.bqi.equals(hl.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.hEN.hEL.bmH();
                } else {
                    this.hEN.hEL.unregister();
                }
            }
            return false;
        }
    };
    private c hEI = new c<ho>(this) {
        final /* synthetic */ g hEN;

        {
            this.hEN = r2;
            this.nhz = ho.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ho hoVar = (ho) bVar;
            switch (hoVar.bhk.bdf) {
                case 1:
                    b.aI(hoVar.bhk.bhm, hoVar.bhk.bhn);
                    break;
                case 2:
                    b.cJ(hoVar.bhk.bhn);
                    break;
                case 3:
                    hoVar.bhl.aYN = b.aDv();
                    break;
                case 4:
                    b.aDw();
                    break;
                case 5:
                    b.aDx();
                    break;
                case 6:
                    b.xf(hoVar.bhk.bhm);
                    break;
                case 7:
                    ho.b bVar2 = hoVar.bhl;
                    ak.yW();
                    Long l = (Long) com.tencent.mm.model.c.vf().get(8210, null);
                    boolean z = l == null ? true : System.currentTimeMillis() > l.longValue();
                    bVar2.aYN = z;
                    break;
                default:
                    v.e("MicroMsg.SubCoreNearby", "LbsroomLogicEvent unkown opcode!");
                    break;
            }
            return false;
        }
    };
    com.tencent.mm.pluginsdk.d.c<ij> hEJ = new com.tencent.mm.pluginsdk.d.c<ij>(this) {
        final /* synthetic */ g hEN;

        {
            this.hEN = r1;
        }

        public final /* synthetic */ b a(int i, k kVar, b bVar) {
            ij ijVar = (ij) bVar;
            d dVar = (d) kVar;
            ijVar.biG.biM = dVar.aDy();
            ijVar.biG.biO = dVar.aDz();
            ijVar.biG.biN = dVar.aDA();
            ijVar.biG.bdf = ijVar.biF.bdf;
            return ijVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            ij ijVar = (ij) bVar;
            if (ijVar.biF.bin) {
                com.tencent.mm.pluginsdk.d.c.x(ijVar);
            } else {
                y(ijVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            ij ijVar = (ij) bVar;
            return new d(ijVar.biF.bdf, ijVar.biF.biH, ijVar.biF.bhs, ijVar.biF.biI, ijVar.biF.biJ, ijVar.biF.biK, ijVar.biF.biL);
        }

        public final int acY() {
            return JsApiScanCode.CTRL_INDEX;
        }
    };
    com.tencent.mm.pluginsdk.d.c<ik> hEK = new com.tencent.mm.pluginsdk.d.c<ik>(this) {
        final /* synthetic */ g hEN;

        {
            this.hEN = r1;
        }

        public final /* synthetic */ b a(int i, k kVar, b bVar) {
            ik ikVar = (ik) bVar;
            f fVar = (f) kVar;
            ikVar.biQ.bhN = ((aga) fVar.cif.czl.czs).eOX;
            ik.b bVar2 = ikVar.biQ;
            LinkedList linkedList = ((aga) fVar.cif.czl.czs).mbB;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    afy com_tencent_mm_protocal_c_afy = (afy) it.next();
                    ak.yW().xv().dJ(com_tencent_mm_protocal_c_afy.gln, com_tencent_mm_protocal_c_afy.mvR);
                }
            }
            bVar2.biC = linkedList;
            return ikVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            ik ikVar = (ik) bVar;
            if (ikVar.biP.bin) {
                com.tencent.mm.pluginsdk.d.c.x(ikVar);
            } else {
                y(ikVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            return new f(((ik) bVar).biP.bhm);
        }

        public final int acY() {
            return 377;
        }
    };
    d hEL = new d(this) {
        final /* synthetic */ g hEN;

        {
            this.hEN = r1;
        }

        public final b um(String str) {
            hl hlVar = new hl();
            hlVar.bhf.aXv = str;
            return hlVar;
        }

        public final com.tencent.mm.sdk.h.g asj() {
            return l.KE();
        }
    };
    private a hEM = new a(this) {
        final /* synthetic */ g hEN;

        {
            this.hEN = r1;
        }

        public final void a(aa aaVar, u uVar) {
            if (aaVar != null && uVar != null && uVar.tK()) {
                l.KE().kJ(uVar.field_username);
            }
        }
    };

    public final void th() {
        ak.yW();
        com.tencent.mm.model.c.wH().b(this.hEM);
        com.tencent.mm.sdk.c.a.nhr.f(this.hEI);
        com.tencent.mm.sdk.c.a.nhr.f(this.eOy);
        com.tencent.mm.sdk.c.a.nhr.f(this.hEJ);
        com.tencent.mm.sdk.c.a.nhr.f(this.hEK);
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
        if ((i & 512) != 0) {
            aDB();
        }
    }

    public static void aDB() {
        l.KE().Kz();
        ak.vy().a(new d(2, 0.0f, 0.0f, 0, 0, "", ""), 0);
    }

    public final void aG(boolean z) {
        ak.yW();
        com.tencent.mm.model.c.wH().a(this.hEM);
        com.tencent.mm.sdk.c.a.nhr.e(this.eOy);
        com.tencent.mm.sdk.c.a.nhr.e(this.hEI);
        com.tencent.mm.sdk.c.a.nhr.e(this.hEJ);
        com.tencent.mm.sdk.c.a.nhr.e(this.hEK);
    }

    public final void aH(boolean z) {
    }
}
