package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.mm.e.a.ex;
import com.tencent.mm.e.a.om;
import com.tencent.mm.e.b.dn;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.plugin.favorite.b.b;
import com.tencent.mm.plugin.favorite.b.d;
import com.tencent.mm.plugin.favorite.b.g;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.k;
import com.tencent.mm.plugin.favorite.b.n;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.b.z;
import com.tencent.mm.plugin.favorite.c.c;
import com.tencent.mm.plugin.favorite.c.f;
import com.tencent.mm.plugin.favorite.ui.c.e;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;

public final class h implements ag {
    private j fJW;
    private b fJX;
    private com.tencent.mm.plugin.favorite.c.h fJY;
    private c fJZ;
    private com.tencent.mm.plugin.favorite.c.b fKa;
    private n fKb;
    private g fKc;
    private d fKd;
    private f fKe;
    private com.tencent.mm.plugin.favorite.c.d fKf;
    private r fKg;
    private a fKh = new a();
    private b fKi = new b();
    private f fKj = new f();
    private e fKk = new e();
    private g fKl = new g();
    private d fKm = new d();
    private dn fKn = null;
    private k fKo;
    private boolean fKp = false;
    private byte[] fKq = new byte[0];
    private com.tencent.mm.sdk.c.c fKr = new com.tencent.mm.sdk.c.c<ex>(this) {
        final /* synthetic */ h fKt;

        {
            this.fKt = r2;
            this.nhz = ex.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ex exVar = (ex) bVar;
            if (exVar != null && (exVar instanceof ex)) {
                if (exVar.bdL.bdM != null && (exVar.bdL.bdM instanceof com.tencent.mm.pluginsdk.ui.applet.c.c) && exVar.bdL.bdN != null && (exVar.bdL.bdN instanceof Context)) {
                    e.a((com.tencent.mm.pluginsdk.ui.applet.c.c) exVar.bdL.bdM, (Context) exVar.bdL.bdN, h.alu().bB(exVar.bdL.aZa));
                }
                exVar.bdL.aZa = 0;
                exVar.bdL.bdM = null;
                exVar.bdL.bdN = null;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c fKs = new com.tencent.mm.sdk.c.c<om>(this) {
        final /* synthetic */ h fKt;

        {
            this.fKt = r2;
            this.nhz = om.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.i("MicroMsg.StartFavServiceListener", "runService");
            h.all().run();
            h.alo().run();
            h.alk().run();
            h.alm().run();
            h.als().run();
            return false;
        }
    };

    private static h alj() {
        h hVar = (h) ak.yP().fY("plugin.favorite");
        if (hVar == null) {
            hVar = new h();
            ak.yP().a("plugin.favorite", hVar);
        }
        if (hVar.fKp) {
            v.w("MicroMsg.SubCoreFav", "getCore need reset DB now, befor synchronized %b", new Object[]{Boolean.valueOf(hVar.fKp)});
            synchronized (hVar.fKq) {
                if (hVar.fKp) {
                    hVar.fKn = dn.pR();
                    hVar.fKp = false;
                }
                v.i("MicroMsg.SubCoreFav", "getCore need reset DB now, after synchronized %b", new Object[]{Boolean.valueOf(hVar.fKp)});
            }
        }
        return hVar;
    }

    public static com.tencent.mm.plugin.favorite.c.h alk() {
        if (ak.uz()) {
            if (alj().fJY == null) {
                alj().fJY = new com.tencent.mm.plugin.favorite.c.h();
            }
            return alj().fJY;
        }
        throw new com.tencent.mm.model.b();
    }

    public static com.tencent.mm.plugin.favorite.c.b all() {
        if (ak.uz()) {
            if (alj().fKa == null) {
                alj().fKa = new com.tencent.mm.plugin.favorite.c.b();
            }
            return alj().fKa;
        }
        throw new com.tencent.mm.model.b();
    }

    public static f alm() {
        if (ak.uz()) {
            if (alj().fKe == null) {
                alj().fKe = new f();
            }
            return alj().fKe;
        }
        throw new com.tencent.mm.model.b();
    }

    public static r aln() {
        if (ak.uz()) {
            if (alj().fKg == null) {
                alj().fKg = new r();
            }
            return alj().fKg;
        }
        throw new com.tencent.mm.model.b();
    }

    public static c alo() {
        if (ak.uz()) {
            if (alj().fJZ == null) {
                alj().fJZ = new c();
            }
            return alj().fJZ;
        }
        throw new com.tencent.mm.model.b();
    }

    public static b alp() {
        if (ak.uz()) {
            if (alj().fJX == null) {
                alj().fJX = new b(alj().fKn);
            }
            return alj().fJX;
        }
        throw new com.tencent.mm.model.b();
    }

    public static g alq() {
        if (ak.uz()) {
            if (alj().fKc == null) {
                alj().fKc = new g(alj().fKn);
            }
            return alj().fKc;
        }
        throw new com.tencent.mm.model.b();
    }

    public static d alr() {
        if (ak.uz()) {
            if (alj().fKd == null) {
                alj().fKd = new d(alj().fKn);
            }
            return alj().fKd;
        }
        throw new com.tencent.mm.model.b();
    }

    public static com.tencent.mm.plugin.favorite.c.d als() {
        if (ak.uz()) {
            if (alj().fKf == null) {
                alj().fKf = new com.tencent.mm.plugin.favorite.c.d();
            }
            return alj().fKf;
        }
        throw new com.tencent.mm.model.b();
    }

    public static n alt() {
        if (ak.uz()) {
            if (alj().fKb == null) {
                alj().fKb = new n(alj().fKn);
            }
            return alj().fKb;
        }
        throw new com.tencent.mm.model.b();
    }

    public static j alu() {
        if (ak.uz()) {
            if (alj().fJW == null) {
                alj().fJW = new j(alj().fKn);
            }
            return alj().fJW;
        }
        throw new com.tencent.mm.model.b();
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreFav", "onAccountPostReset updated:%b", new Object[]{Boolean.valueOf(z)});
        this.fKp = true;
        a.nhr.e(this.fKh);
        a.nhr.e(this.fKi);
        a.nhr.e(this.fKk);
        a.nhr.e(this.fKj);
        a.nhr.e(this.fKs);
        a.nhr.e(this.fKl);
        a.nhr.e(this.fKm);
        a.nhr.d(this.fKr);
        File file = new File(com.tencent.mm.plugin.favorite.b.v.alP());
        if (!(file.exists() && file.isDirectory())) {
            v.d("MicroMsg.SubCoreFav", "fav root dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(com.tencent.mm.plugin.favorite.b.v.alQ());
        if (!(file.exists() && file.isDirectory())) {
            v.d("MicroMsg.SubCoreFav", "fav web dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(com.tencent.mm.plugin.favorite.b.v.alS());
        if (!(file.exists() && file.isDirectory())) {
            v.d("MicroMsg.SubCoreFav", "fav attach dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(com.tencent.mm.plugin.favorite.b.v.alR());
        if (!(file.exists() && file.isDirectory())) {
            v.d("MicroMsg.SubCoreFav", "fav voice dir not exists, try to make it");
            file.mkdirs();
        }
        this.fKo = new k();
        alp().a(this.fKo);
        alu().c(this.fKo);
        com.tencent.mm.plugin.favorite.a.a aVar = new com.tencent.mm.plugin.favorite.a.a();
        p.a(aVar);
        aVar.create();
        com.tencent.mm.plugin.favorite.a.b bVar = new com.tencent.mm.plugin.favorite.a.b();
        p.a(6, bVar);
        bVar.create();
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.favorite.ui.b.d());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.favorite.ui.b.b());
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        this.fKp = false;
        a.nhr.f(this.fKh);
        a.nhr.f(this.fKi);
        a.nhr.f(this.fKk);
        a.nhr.f(this.fKs);
        a.nhr.f(this.fKj);
        a.nhr.f(this.fKl);
        a.nhr.f(this.fKm);
        a.nhr.f(this.fKr);
        p.gc(256);
        p.gb(6);
        com.tencent.mm.ui.f.e.xZ(128);
        com.tencent.mm.ui.f.e.xZ(4176);
        alp().b(this.fKo);
        alu().d(this.fKo);
        this.fKo = null;
        c alo = alo();
        alo.pu();
        alo.aVA.QI();
        alo.aVw = 0;
        ak.b(alo.cEZ);
        com.tencent.mm.plugin.favorite.c.b all = all();
        all.pu();
        all.aVA.QI();
        ak.vy().b(404, all);
        ak.b(all.cEZ);
        com.tencent.mm.plugin.favorite.c.h alk = alk();
        alk.pu();
        alk.aVA.QI();
        alk.aVw = 0;
        ak.vy().b(401, alk);
        f alm = alm();
        alm.pu();
        alm.aVA.QI();
        alm.aVw = 0;
        ak.vy().b(426, alm);
        com.tencent.mm.plugin.favorite.c.d als = als();
        ak.vy().b(426, als);
        ak.vy().b(401, als);
        als.fMx.clear();
        z.amf();
        if (this.fKn != null) {
            this.fKn.wB();
        }
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }
}
