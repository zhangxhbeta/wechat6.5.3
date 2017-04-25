package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.n;
import java.util.HashMap;
import java.util.LinkedList;

public final class f implements e {
    static int cVh = 0;
    Activity gZX;
    boolean hRY = false;
    private boolean hRZ = false;
    c hSa;
    private a hSb;
    private com.tencent.mm.sdk.c.c hSc = new com.tencent.mm.sdk.c.c<qp>(this) {
        final /* synthetic */ f hSe;

        {
            this.hSe = r2;
            this.nhz = qp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qp qpVar = (qp) bVar;
            if (qpVar instanceof qp) {
                if (qpVar.bsg.bpc != -1) {
                    v.i("MicroMsg.MallProductUI", "MallProduct pay result : cancel");
                } else if (!this.hSe.hRZ) {
                    v.i("MicroMsg.MallProductUI", "MallProduct pay result : ok");
                    this.hSe.aGx();
                    this.hSe.hRZ = true;
                }
                return true;
            }
            v.f("MicroMsg.MallProductUI", "mismatched event");
            return false;
        }
    };

    class AnonymousClass1 implements com.tencent.mm.sdk.platformtools.ad.a {
        private volatile int bpc;
        final /* synthetic */ m hSd;
        final /* synthetic */ f hSe;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(f fVar, Intent intent, m mVar) {
            this.hSe = fVar;
            this.val$intent = intent;
            this.hSd = mVar;
        }

        public final boolean AZ() {
            this.bpc = f.a(this.hSe, this.val$intent, this.hSd);
            return true;
        }

        public final boolean Ba() {
            switch (this.bpc) {
                case -1:
                    if (this.hSe.hSb != null) {
                        this.hSe.hSb.i(0, -1, this.hSe.gZX.getString(2131233760));
                        break;
                    }
                    break;
                case 0:
                    if (this.hSe.hSb != null) {
                        this.hSe.hSb.i(0, 0, "");
                        break;
                    }
                    break;
            }
            return true;
        }

        public final String toString() {
            return super.toString() + "|initData";
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ f hSe;
        final /* synthetic */ kk hSf;

        AnonymousClass2(f fVar, kk kkVar) {
            this.hSe = fVar;
            this.hSf = kkVar;
        }

        public final void run() {
            v.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(this.hSf.blz.errCode), Boolean.valueOf(this.hSf.blz.blA)});
            if (this.hSf.blz.errCode == 0) {
                c c = this.hSe.hSa;
                kk kkVar = this.hSf;
                bt btVar = new bt();
                btVar.gln = kkVar.blz.userName;
                btVar.mcl = kkVar.blz.blC;
                btVar.mcm = kkVar.blz.blD;
                btVar.cHd = kkVar.blz.blE;
                btVar.cHe = kkVar.blz.blF;
                btVar.cHl = kkVar.blz.blG;
                btVar.glo = kkVar.blz.blH;
                if (!(be.kS(btVar.gln) || be.kS(btVar.mcl))) {
                    c.hQi = btVar;
                }
            }
            this.hSe.hRY = false;
        }
    }

    public interface a {
        void i(int i, int i2, String str);
    }

    static /* synthetic */ int a(f fVar, Intent intent, m mVar) {
        cVh = intent.getIntExtra("key_product_scene", 3);
        String stringExtra = intent.getStringExtra("key_product_info");
        String stringExtra2 = intent.getStringExtra("key_product_id");
        String stringExtra3 = intent.getStringExtra("key_source_url");
        c cVar = fVar.hSa;
        if (!be.kS(stringExtra3)) {
            cVar.hQf = stringExtra3;
        }
        int i = -2;
        v.i("MicroMsg.MallProductUI", "Scene : " + cVh);
        switch (cVh) {
            case 1:
            case 2:
            case 4:
                if (!be.kS(stringExtra)) {
                    mVar = m.b(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.hSa.a(mVar, null);
                    stringExtra2 = mVar.hQC;
                    i = 0;
                    break;
                }
                break;
            case 3:
                if (!be.kS(stringExtra)) {
                    mVar = m.a(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.hSa.a(mVar, null);
                    stringExtra2 = mVar.hQC;
                    i = 0;
                    break;
                }
                break;
        }
        if (be.kS(stringExtra2)) {
            return -1;
        }
        ak.vy().a(new h(mVar, stringExtra2), 0);
        return i;
    }

    public f(Activity activity, a aVar) {
        this.gZX = activity;
        com.tencent.mm.plugin.product.a.a.aFW();
        this.hSa = com.tencent.mm.plugin.product.a.a.aFX();
        this.hSb = aVar;
    }

    public final void onStart() {
        ak.vy().a(553, this);
        ak.vy().a(554, this);
        ak.vy().a(555, this);
        ak.vy().a(556, this);
        ak.vy().a(557, this);
        ak.vy().a(578, this);
        ak.vy().a(579, this);
    }

    public final void onStop() {
        ak.vy().b(553, this);
        ak.vy().b(554, this);
        ak.vy().b(555, this);
        ak.vy().b(556, this);
        ak.vy().b(557, this);
        ak.vy().b(578, this);
        ak.vy().b(579, this);
    }

    public final void aGw() {
        m mVar = this.hSa.hQc;
        bp bpVar = new bp();
        qf qfVar = new qf();
        qg qgVar = new qg();
        qe qeVar = new qe();
        qgVar.Jn(k.xF());
        qgVar.Jo(k.xF());
        qgVar.uN(11);
        qgVar.dV(be.Ni());
        qeVar.Jg(mVar.hQG.name);
        qeVar.Jh(this.hSa.aGq());
        qeVar.uK(mVar.hQD);
        qeVar.Jj(this.hSa.a(mVar));
        qeVar.Ji(mVar.aGs());
        bpVar.aZd.title = mVar.hQG.name;
        bpVar.aZd.desc = this.hSa.aGq();
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 11;
        qfVar.a(qgVar);
        qfVar.b(qeVar);
        bpVar.aZd.aXH = this.gZX;
        bpVar.aZd.aZl = 5;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
    }

    private void aGx() {
        d aFY = com.tencent.mm.plugin.product.a.a.aFW().aFY();
        apv aGe = this.hSa.aGe();
        if (!(aGe == null || be.kS(aGe.glo) || aGe.glo.contains(";"))) {
            aFY.hQu.remove(aGe.glo);
            aFY.hQu.add(aGe.glo);
            aFY.aGr();
        }
        Intent intent = new Intent(this.gZX, MallProductUI.class);
        intent.putExtra("key_go_finish", true);
        intent.addFlags(67108864);
        this.gZX.startActivity(intent);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.MallProductUI", "errCode: " + i2 + ", errMsg: " + str);
        h hVar;
        if (i != 0 || i2 != 0) {
            switch (i2) {
                case -10010003:
                    v.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
                    if (kVar instanceof h) {
                        hVar = (h) kVar;
                        this.hSa.a(hVar.hQy, hVar.hQz);
                        if (this.hSb != null) {
                            this.hSb.i(i, i2, str);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    v.i("MicroMsg.MallProductUI", "unkown errCode " + i2);
                    if (be.kS(str)) {
                        str = i2 + " : " + this.gZX.getString(2131233760);
                    }
                    if (this.hSb != null) {
                        this.hSb.i(i, i2, str);
                        return;
                    }
                    return;
            }
        } else if (kVar instanceof h) {
            hVar = (h) kVar;
            this.hSa.a(hVar.hQy, hVar.hQz);
            if (this.hSb != null) {
                this.hSb.i(i, i2, str);
            }
            if (be.kS(hVar.hQy.hQC)) {
                g.iuh.h(11007, new Object[]{this.hSa.aGf(), hVar.hQx, Integer.valueOf(cVh), Integer.valueOf(1)});
                return;
            }
            g.iuh.h(11007, new Object[]{this.hSa.aGf(), hVar.hQy.hQC, Integer.valueOf(cVh), Integer.valueOf(1)});
        } else if (kVar instanceof j) {
            j jVar = (j) kVar;
            r0 = this.hSa;
            r1 = jVar.hQe;
            r2 = jVar.hQp;
            LinkedList linkedList = jVar.hQq;
            r0.hQe = r1;
            r0.hQq = linkedList;
            r0.hQp = r2;
            r0.nZ(0);
            this.gZX.startActivity(new Intent(this.gZX, MallProductSubmitUI.class));
            g.iuh.h(11009, new Object[]{this.hSa.aGf(), this.hSa.hQc.hQC, Integer.valueOf(cVh), Integer.valueOf(1)});
        } else if (!(kVar instanceof com.tencent.mm.plugin.product.b.f)) {
            if (kVar instanceof l) {
                r1 = ((l) kVar).hQB;
                int i3 = 6;
                if (cVh == 7) {
                    i3 = 1001;
                }
                v.d("MicroMsg.MallProductUI", "payScene:" + i3);
                com.tencent.mm.pluginsdk.wallet.e.a(this.gZX, r1, this.hSa.getAppId(), i3, 3);
                com.tencent.mm.sdk.c.a.nhr.e(this.hSc);
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.k) {
                com.tencent.mm.ui.base.g.bf(this.gZX, this.gZX.getString(2131233779));
                aGx();
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.g) {
                try {
                    this.gZX.dismissDialog(-10002);
                } catch (Exception e) {
                    v.e("MicroMsg.MallProductUI", e.toString());
                }
                r0 = this.hSa;
                r0.hQp = ((com.tencent.mm.plugin.product.b.g) kVar).hQp;
                r0.nZ(0);
            } else if (kVar instanceof i) {
                try {
                    this.gZX.dismissDialog(-10002);
                } catch (Exception e2) {
                    v.e("MicroMsg.MallProductUI", e2.toString());
                }
                i iVar = (i) kVar;
                r0 = this.hSa;
                r1 = iVar.mUrl;
                r2 = iVar.hQA;
                if (!(be.kS(r1) || r2 == null || r2.size() <= 0)) {
                    if (r0.hQt == null) {
                        r0.hQt = new HashMap();
                    }
                    r0.hQt.put(r1, r2);
                }
                if (this.hSb != null) {
                    this.hSb.i(i, i2, str);
                }
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    this.hSa.E(intent);
                    if (this.hSb != null) {
                        this.hSb.i(0, 0, "");
                    }
                    n vy = ak.vy();
                    c cVar = this.hSa;
                    vy.a(new com.tencent.mm.plugin.product.b.g(cVar.hQc != null ? cVar.hQc.hQC : "", this.hSa.hQe, this.hSa.hQi), 0);
                    return;
                }
                return;
            case 2:
                if (i2 == -1 && intent != null) {
                    this.hSa.E(intent);
                    ak.vy().a(new j(this.hSa.aGm(), cVh), 0);
                    return;
                }
                return;
            case 3:
                qp qpVar = new qp();
                qpVar.bsg.context = this.gZX;
                qpVar.bsg.bpc = i;
                qpVar.bsg.intent = intent;
                this.hSc.a(qpVar);
                return;
            case 4:
                if (this.hSb != null) {
                    this.hSb.i(0, 0, "");
                    return;
                }
                return;
            case Constants.THREAD_BITSET_SIZE /*10000*/:
                this.gZX.showDialog(-10002);
                ak.vy().a(new i(this.hSa.hQe, this.hSa.hQl), 0);
                return;
            default:
                return;
        }
    }
}
