package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wear.model.e.e;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.g;
import com.tencent.mm.plugin.wear.model.e.h;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g.b;
import com.tencent.mm.pluginsdk.j.am;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d;
import java.util.HashMap;

public final class a implements ag {
    q laP;
    public r laQ;
    public d laR;
    private e laS;
    public g laT;
    public b laU;
    private WearMessageLogic laV;
    private i laW;
    public j laX;
    public com.tencent.mm.plugin.wear.model.g.a laY;
    private d laZ;

    public a() {
        v.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[]{getClass().getClassLoader()});
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public static a bhH() {
        a aVar = (a) ak.yP().fY("plugin.wear");
        if (aVar != null) {
            return aVar;
        }
        aVar = new a();
        ak.yP().a("plugin.wear", aVar);
        return aVar;
    }

    public final void ed(int i) {
        v.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[]{Integer.valueOf(i)});
    }

    public final void aG(boolean z) {
        am.lym = new c();
        v.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[]{Boolean.valueOf(z)});
        this.laP = new q();
        this.laQ = new r();
        this.laX = new j();
        this.laS = new e();
        this.laT = new g();
        this.laU = new b();
        this.laR = new d();
        this.laV = new WearMessageLogic();
        this.laW = new i();
        this.laY = new com.tencent.mm.plugin.wear.model.g.a();
        this.laZ = new b();
        d.c.a(Integer.valueOf(63), this.laZ);
        this.laP.a(this.laR.lbi);
        this.laP.a(this.laR.lbj);
        this.laP.a(this.laR.lbk);
        this.laP.a(new h());
        this.laP.a(new g());
        this.laP.a(new com.tencent.mm.plugin.wear.model.e.d());
        this.laP.a(new com.tencent.mm.plugin.wear.model.e.c());
        this.laP.a(new e());
        this.laP.a(new f());
        this.laP.a(new k());
        this.laP.a(new m());
        this.laP.a(new o());
        this.laP.a(new n());
        this.laP.a(new l());
        this.laX.a(new com.tencent.mm.plugin.wear.model.f.c(this) {
            final /* synthetic */ a lba;

            {
                this.lba = r1;
            }

            protected final void send() {
                r.a(20001, null, false);
                r.a(20008, null, false);
            }

            public final String getName() {
                return "PhoneStartTask";
            }
        });
    }

    public final void aH(boolean z) {
        v.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[]{Boolean.valueOf(z)});
    }

    public final void th() {
        d.c.aw(Integer.valueOf(63));
        this.laZ = null;
        v.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
        this.laP.lco.clear();
        this.laP = null;
        this.laQ = null;
        e eVar = this.laS;
        eVar.dwn.QI();
        com.tencent.mm.sdk.c.a.nhr.f(eVar.jUY);
        com.tencent.mm.sdk.c.a.nhr.f(eVar.lbo);
        com.tencent.mm.sdk.c.a.nhr.f(eVar.lbp);
        com.tencent.mm.sdk.c.a.nhr.f(eVar.lbq);
        com.tencent.mm.sdk.c.a.nhr.f(eVar.lbr);
        com.tencent.mm.sdk.c.a.nhr.f(eVar.lbs);
        com.tencent.mm.sdk.c.a.nhr.f(eVar.lbt);
        com.tencent.mm.sdk.c.a.nhr.f(eVar.bZd);
        com.tencent.mm.sdk.c.a.nhr.f(eVar.hcA);
        ak.yW();
        com.tencent.mm.model.c.wJ().a(eVar.fGy);
        this.laS = null;
        this.laT = null;
        b bVar = this.laU;
        com.tencent.mm.sdk.c.a.nhr.f(bVar.lbc);
        ak.yW();
        com.tencent.mm.model.c.wH().b(bVar.lbd);
        bVar.lbe.QI();
        this.laU = null;
        d dVar = this.laR;
        dVar.lbh.finish();
        dVar.lbl.reset();
        this.laR = null;
        aa.getContext().unregisterReceiver(this.laV);
        this.laV = null;
        a aVar = this.laX.lbO;
        aVar.eUv = true;
        aVar.lbQ.lbN.add(new com.tencent.mm.plugin.wear.model.f.d(aVar) {
            final /* synthetic */ a lbR;

            {
                this.lbR = r1;
            }

            public final String getName() {
                return "StopWorkerTask";
            }

            protected final void execute() {
            }
        });
        this.laX = null;
        i iVar = this.laW;
        iVar.cba = null;
        iVar.bhQ();
        aa.getContext().unregisterReceiver(iVar.lbK);
        this.laW = null;
    }
}
