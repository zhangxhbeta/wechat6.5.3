package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.ax;
import com.tencent.mm.e.a.dx;
import com.tencent.mm.e.a.fc;
import com.tencent.mm.e.a.gv;
import com.tencent.mm.e.a.hp;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.e;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class l implements ag {
    private com.tencent.mm.plugin.location.model.a.a gSA;
    private int gSB = 0;
    private e gSC = new b();
    private e gSD = new n();
    private o gSE = null;
    private p gSF = null;
    private i gSG = null;
    private m gSH = null;
    private d gSI = new d();
    private k gSJ = null;
    private j gSK = null;
    private com.tencent.mm.v.e gSL = new com.tencent.mm.v.e(this) {
        final /* synthetic */ l gSR;

        {
            this.gSR = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                x xVar = (x) kVar;
                arm Jw = xVar.Jw();
                if (Jw.efm == 0) {
                    long j = xVar.bao;
                    String ki = x.ki(Jw.mii);
                    ak.yW();
                    at ek = com.tencent.mm.model.c.wJ().ek(j);
                    if (ek.bwl()) {
                        ek.cJ(ki);
                        ak.yW();
                        com.tencent.mm.model.c.wJ().a(j, ek);
                    }
                }
            }
        }
    };
    private com.tencent.mm.sdk.c.c gSM = new com.tencent.mm.sdk.c.c<dx>(this) {
        final /* synthetic */ l gSR;

        {
            this.gSR = r2;
            this.nhz = dx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            dx dxVar = (dx) bVar;
            v.i("MicroMsg.SubCoreLocation", "exit track trackMgr:%s event:%s", new Object[]{com.tencent.mm.pluginsdk.j.a.lxP.awp(), dxVar.bbQ.username});
            l.awi().stop();
            if (!be.kS(com.tencent.mm.pluginsdk.j.a.lxQ.awz())) {
                l.awi().mp(1);
                pd pdVar = new pd();
                pdVar.bqt.bqw = true;
                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
            }
            if (!be.kS(dxVar.bbQ.username)) {
                com.tencent.mm.plugin.location.a.a vI = l.awj().vI(dxVar.bbQ.username);
                if (vI != null) {
                    vI.biC.remove(com.tencent.mm.model.k.xF());
                    l.awj().a(dxVar.bbQ.username, vI.biC, vI.latitude, vI.longitude, vI.gRG, null, null);
                    if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
                        com.tencent.mm.pluginsdk.j.a.lxG.a(dxVar.bbQ.username, null, null, null, 1);
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gSN = new com.tencent.mm.sdk.c.c<lw>(this) {
        final /* synthetic */ l gSR;

        {
            this.gSR = r2;
            this.nhz = lw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            lw lwVar = (lw) bVar;
            v.d("MicroMsg.SubCoreLocation", "trackEvent state " + lwVar.bnb.aWr);
            if (lwVar.bnb.aWr) {
                if (l.awi().awn() && l.awi().gTd) {
                    l.awi().awo();
                }
            } else if (l.awi().awn()) {
                o awi = l.awi();
                v.d("MicorMsg.TrackRefreshManager", "pause refresh");
                awi.gTd = true;
                if (awi.cCR != null) {
                    awi.cCR.c(awi.bYl);
                }
                if (awi.gSU != null) {
                    awi.gSU.b(awi.gTj);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gSO = new com.tencent.mm.sdk.c.c<gv>(this) {
        final /* synthetic */ l gSR;

        {
            this.gSR = r2;
            this.nhz = gv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            gv gvVar = (gv) bVar;
            j awh = l.awh();
            at atVar = gvVar.bgt.aXd;
            ImageView imageView = gvVar.bgt.bgv;
            ProgressBar progressBar = gvVar.bgt.bgx;
            ImageView imageView2 = gvVar.bgt.bgw;
            int i = gvVar.bgt.bgy;
            int i2 = gvVar.bgt.w;
            int i3 = gvVar.bgt.h;
            String str = atVar.field_content;
            if (!be.kS(str)) {
                awh.w = i2;
                awh.h = i3;
                if (awh.w <= 0 || awh.h <= 0) {
                    awh.w = 300;
                    awh.h = 300;
                }
                boolean z = atVar.field_isSend == 0;
                if (m.dE(atVar.field_talker) && z) {
                    int fK = aw.fK(str);
                    if (fK != -1) {
                        str = str.substring(fK + 1).trim();
                    }
                }
                ak.yW();
                com.tencent.mm.storage.at.b MV = com.tencent.mm.model.c.wJ().MV(str);
                if (atVar.bNu == 5 || awh.gSq.contains(Long.valueOf(atVar.field_msgId))) {
                    v.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", new Object[]{Long.valueOf(atVar.field_msgId), Integer.valueOf(atVar.bNu)});
                    imageView2.setVisibility(0);
                    progressBar.setVisibility(8);
                } else {
                    com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(atVar.field_msgId, (float) MV.gRK, (float) MV.gRL, (int) (((double) MV.bhu) * 1.1d), 0);
                    progressBar.setVisibility(0);
                    imageView2.setVisibility(8);
                    k awg = l.awg();
                    awg.w = i2;
                    awg.h = i3;
                    if (awg.w <= 0 || awg.h <= 0) {
                        awg.w = 300;
                        awg.h = 300;
                    }
                    String b = k.b(bVar2);
                    if (com.tencent.mm.a.e.aR(b)) {
                        if (!ak.uz()) {
                            b = "";
                        }
                    } else if (awg.gSs == null || !awg.gSs.toString().equals(bVar2.toString())) {
                        Iterator it = awg.gSr.iterator();
                        while (it.hasNext()) {
                            if (bVar2.toString().equals(((com.tencent.mm.pluginsdk.location.b) it.next()).toString())) {
                                v.i("MicroMsg.StaticMapServer", "has add queue");
                                awg.FX();
                                b = "";
                                break;
                            }
                        }
                        awg.gSr.add(bVar2);
                        v.i("MicroMsg.StaticMapServer", "task size %d w%d h %d", new Object[]{Integer.valueOf(awg.gSr.size()), Integer.valueOf(awg.w), Integer.valueOf(awg.h)});
                        awg.FX();
                        b = "";
                    } else {
                        v.i("MicroMsg.StaticMapServer", "has add queue");
                        awg.FX();
                        b = "";
                    }
                    if (be.kS(b) || !com.tencent.mm.a.e.aR(b)) {
                        awh.gSl.put(Long.valueOf(bVar2.lyQ), MV);
                        awh.gSp.put(Long.valueOf(atVar.field_msgId), Integer.valueOf(i));
                        awh.gSo.put(MV, atVar);
                        awh.gSk.put(Long.valueOf(atVar.field_msgId), new WeakReference(imageView));
                        awh.gSm.put(Long.valueOf(atVar.field_msgId), new WeakReference(progressBar));
                        awh.gSn.put(Long.valueOf(atVar.field_msgId), new WeakReference(imageView2));
                        awh.start();
                    } else {
                        v.d("MicroMsg.StaticMapMsgLogic", "readloc from local %d", new Object[]{Integer.valueOf(i)});
                        if (ak.uz()) {
                            Bitmap a = n.GH().a(atVar.field_msgId, b, i, awh.w, awh.h, z);
                            if (!(a == null || a.isRecycled())) {
                                imageView.setImageBitmap(a);
                                progressBar.setVisibility(8);
                                imageView2.setVisibility(0);
                            }
                        }
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gSP = new com.tencent.mm.sdk.c.c<ax>(this) {
        final /* synthetic */ l gSR;

        {
            this.gSR = r2;
            this.nhz = ax.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            com.tencent.mm.pluginsdk.location.a awh = l.awh();
            v.i("MicroMsg.StaticMapMsgLogic", "clean task");
            awh.gSk.clear();
            awh.gSo.clear();
            awh.gSp.clear();
            awh.gSm.clear();
            awh.gSn.clear();
            awh.gSq.clear();
            awh.gSl.clear();
            l.awg().a(awh);
            l.awg().a(awh);
            return false;
        }
    };
    private com.tencent.mm.model.bo.b gSQ = new com.tencent.mm.model.bo.b(this) {
        final /* synthetic */ l gSR;

        {
            this.gSR = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            new n().b(aVar);
        }
    };
    private c gSx = new c();
    private a gSy = new a();
    private b gSz = new b();

    private static final class a extends com.tencent.mm.sdk.c.c<fc> {
        private a() {
            this.nhz = fc.class.getName().hashCode();
        }

        /* synthetic */ a(byte b) {
            this();
            this.nhz = fc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            fc fcVar = (fc) bVar;
            if (!(fcVar instanceof fc)) {
                return false;
            }
            l.F(fcVar.bem.aXd);
            return true;
        }
    }

    private static final class b extends com.tencent.mm.sdk.c.c<hp> {
        private b() {
            this.nhz = hp.class.getName().hashCode();
        }

        /* synthetic */ b(byte b) {
            this();
            this.nhz = hp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            hp hpVar = (hp) bVar;
            if (!(hpVar instanceof hp)) {
                return false;
            }
            v.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + hpVar.bho.bhq);
            switch (hpVar.bho.bhq) {
                case 0:
                    hpVar.bhp.path = e.a(hpVar.bho.bhr, hpVar.bho.filename, hpVar.bho.view);
                    break;
                case 1:
                    com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(-1, hpVar.bho.bhs, hpVar.bho.bht, hpVar.bho.bhu, 1);
                    hpVar.bhp.path = k.b(bVar2);
                    break;
                case 2:
                    ak.vy().a(new g(hpVar.bho.bhs, hpVar.bho.bht, hpVar.bho.bhu, hpVar.bho.width, hpVar.bho.height, hpVar.bho.filename, u.bsY()), 0);
                    break;
                case 3:
                    g gVar = (g) hpVar.bho.aZJ;
                    hpVar.bhp.path = gVar.gRY;
                    break;
            }
            return true;
        }
    }

    private static final class c extends com.tencent.mm.sdk.c.c<hq> {
        private volatile boolean Ox;

        private c() {
            this.Ox = false;
            this.nhz = hq.class.getName().hashCode();
        }

        /* synthetic */ c(byte b) {
            this();
            this.nhz = hq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            hq hqVar = (hq) bVar;
            if (!(hqVar instanceof hq)) {
                return false;
            }
            v.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + hqVar.bhv.bhq);
            switch (hqVar.bhv.bhq) {
                case 0:
                    l.awf().gRQ = new HashSet();
                    this.Ox = true;
                    return true;
                case 1:
                    if (this.Ox) {
                        String[] E = l.awf().E(hqVar.bhv.aXd);
                        hqVar.bhw.bhy = E[0];
                        hqVar.bhw.bhz = E[1];
                        return true;
                    }
                    hqVar.bhw.bhy = "err_not_started";
                    return true;
                case 2:
                    if (!this.Ox) {
                        return true;
                    }
                    l.awf().awa();
                    return true;
                default:
                    return true;
            }
        }
    }

    private static l awe() {
        l lVar = (l) ak.yP().fY("plugin.location");
        if (lVar != null) {
            return lVar;
        }
        lVar = new l();
        ak.yP().a("plugin.location", lVar);
        return lVar;
    }

    public static com.tencent.mm.plugin.location.model.a.a awf() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (awe().gSA == null) {
            awe().gSA = new com.tencent.mm.plugin.location.model.a.a();
        }
        return awe().gSA;
    }

    public static k awg() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (awe().gSJ == null) {
            awe().gSJ = new k();
        }
        return awe().gSJ;
    }

    public static j awh() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (awe().gSK == null) {
            awe().gSK = new j();
        }
        return awe().gSK;
    }

    public static o awi() {
        if (awe().gSE == null) {
            awe().gSE = new o();
        }
        return awe().gSE;
    }

    public static p awj() {
        if (awe().gSF == null) {
            awe().gSF = new p();
        }
        return awe().gSF;
    }

    public static i awk() {
        if (awe().gSG == null) {
            awe().gSG = new i();
        }
        return awe().gSG;
    }

    public static m awl() {
        if (awe().gSH == null) {
            awe().gSH = new m();
        }
        return awe().gSH;
    }

    public static void F(at atVar) {
        if (atVar != null && atVar.field_msgId != 0) {
            com.tencent.mm.storage.at.b Mz = com.tencent.mm.storage.at.b.Mz(atVar.field_content);
            ak.vy().a(new x((float) Mz.gRL, (float) Mz.gRK, atVar.field_msgId), 0);
        }
    }

    public static String awm() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.xp()).append("trackroom/").toString();
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        com.tencent.mm.v.d.c.a(Integer.valueOf(48), this.gSC);
        com.tencent.mm.v.d.c.a(Integer.valueOf(61), this.gSD);
        ak.yU().a("trackmsg", this.gSQ, true);
        ak.vy().a(424, this.gSL);
        com.tencent.mm.sdk.c.a.nhr.e(this.gSx);
        com.tencent.mm.sdk.c.a.nhr.e(this.gSy);
        com.tencent.mm.sdk.c.a.nhr.e(this.gSM);
        com.tencent.mm.sdk.c.a.nhr.e(this.gSN);
        com.tencent.mm.sdk.c.a.nhr.e(this.gSO);
        com.tencent.mm.sdk.c.a.nhr.e(this.gSP);
        com.tencent.mm.sdk.c.a.nhr.e(this.gSz);
        com.tencent.mm.pluginsdk.j.a.lxP = awi();
        com.tencent.mm.pluginsdk.j.a.lxQ = awj();
        com.tencent.mm.pluginsdk.j.a.lxS = awl();
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (awe().gSI == null) {
            awe().gSI = new d();
        }
        com.tencent.mm.plugin.e.c.a.gZR = awe().gSI;
    }

    public final void th() {
        if (this.gSE != null) {
            this.gSE.gTe = null;
            this.gSE.stop();
            this.gSE.mp(1);
        }
        com.tencent.mm.v.d.c.aw(Integer.valueOf(48));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(61));
        ak.yU().b("trackmsg", this.gSQ, true);
        ak.vy().b(424, this.gSL);
        com.tencent.mm.sdk.c.a.nhr.f(this.gSx);
        com.tencent.mm.sdk.c.a.nhr.f(this.gSy);
        com.tencent.mm.sdk.c.a.nhr.f(this.gSM);
        com.tencent.mm.sdk.c.a.nhr.f(this.gSN);
        com.tencent.mm.sdk.c.a.nhr.f(this.gSO);
        com.tencent.mm.sdk.c.a.nhr.f(this.gSP);
        com.tencent.mm.sdk.c.a.nhr.f(this.gSz);
        if (this.gSG != null) {
            i iVar = this.gSG;
            iVar.awd();
            iVar.dKi.clear();
        }
        if (this.gSJ != null) {
            this.gSJ.stop();
        }
        if (this.gSK != null) {
            awg().a(this.gSK);
        }
    }

    public final void aH(boolean z) {
    }
}
