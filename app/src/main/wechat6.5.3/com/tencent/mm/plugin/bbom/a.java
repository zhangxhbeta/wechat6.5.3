package com.tencent.mm.plugin.bbom;

import com.tencent.mm.e.a.cj;
import com.tencent.mm.e.a.gc;
import com.tencent.mm.e.a.jf;
import com.tencent.mm.e.a.oy;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.b;

public final class a implements com.tencent.mm.plugin.b.a.a {
    public final void a(f fVar, baq com_tencent_mm_protocal_c_baq, boolean z) {
        if ((com_tencent_mm_protocal_c_baq.mXe & 2) != 0) {
            ai aiVar = com_tencent_mm_protocal_c_baq.mXg;
            if (!z) {
                ak.yW();
                c.ed(aiVar.mau);
            }
            com.tencent.mm.model.ai.cse.fG(b.r(k.xF(), false));
            if (aiVar.mar != 0) {
                ak.yW();
                c.wN().bV(aiVar.mar + "@qqim", 3);
            }
            b.d((long) aiVar.mar, 3);
        } else {
            v.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
        }
        n.gp(1);
    }

    public final void a(z.b bVar, String str, int i, String str2, String str3, int i2) {
        com.tencent.mm.model.ai.cse.fG(b.r(k.xF(), false));
        b.d((long) i, 3);
        ak.yW();
        c.wN().bV(bVar.lXv.mKQ, 2);
        if (i != 0) {
            ak.yW();
            c.wN().bV(i + "@qqim", 3);
        }
    }

    public final void a(ih ihVar, ih ihVar2, ih ihVar3) {
        ad.o(new com.tencent.mm.model.an.AnonymousClass1(ihVar, ihVar2, ihVar3));
    }

    public final void a(d dVar, e eVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ a enP;

            {
                this.enP = r1;
            }

            public final void run() {
                ax.fR("ver" + com.tencent.mm.protocal.d.lWh);
                am.bnF().bK(am.bnB().bnq());
                com.tencent.mm.sdk.c.a aVar = com.tencent.mm.sdk.c.a.nhr;
                if (aVar == null) {
                    v.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
                    return;
                }
                com.tencent.mm.sdk.c.b gcVar = new gc();
                gcVar.bfE.bfF = true;
                aVar.z(gcVar);
                gcVar = new oy();
                gcVar.bqj.bqk = true;
                aVar.z(gcVar);
                aVar.z(new cj());
                aVar.z(new jf());
                o.Ho().fP(3);
                v.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
            }

            public final String toString() {
                return super.toString() + "|onGYNetEnd2";
            }
        });
    }

    public final void a(f fVar, g gVar) {
        com.tencent.mm.sdk.c.b gcVar = new gc();
        gcVar.bfE.bfF = false;
        com.tencent.mm.sdk.c.a.nhr.z(gcVar);
        gcVar = new oy();
        gcVar.bqj.bqk = true;
        com.tencent.mm.sdk.c.a.nhr.z(gcVar);
    }
}
