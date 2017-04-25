package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.j;
import com.tencent.mm.plugin.shake.b.j.b;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class g extends b implements e {
    private static int iOH = 0;
    private float bYf = -1000.0f;
    private float bYg = -1000.0f;
    private a bYl = new a(this) {
        final /* synthetic */ g iPf;

        {
            this.iPf = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return true;
            }
            if (this.iPf.bYf == -1000.0f && this.iPf.bYg == -1000.0f) {
                this.iPf.bYf = f2;
                this.iPf.bYg = f;
                k.aNU().bYf = this.iPf.bYf;
                k.aNU().bYg = this.iPf.bYg;
                if (this.iPf.iPe) {
                    v.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
                    this.iPf.aNY();
                }
            }
            return false;
        }
    };
    private c cCR;
    public int eCZ;
    public int exT = 0;
    private boolean gjR = false;
    public String gux = "";
    private long iOI = 0;
    private c iPc;
    private e iPd = new e();
    private boolean iPe = false;
    private ac mHandler = new ac();

    public g(j.a aVar) {
        super(aVar);
    }

    public final void init() {
        iOH = k.aNU().iOH;
        this.iOI = k.aNU().iOI;
        this.bYf = k.aNU().bYf;
        this.bYg = k.aNU().bYg;
        ak.vy().a(1250, this);
        aNA();
    }

    public final void reset() {
        if (this.iPc != null) {
            ak.vy().c(this.iPc);
        }
    }

    public final void start() {
        init();
        reset();
        if (this.cCR == null) {
            aNA();
        }
        this.cCR.a(this.bYl);
        d aNU = k.aNU();
        CharSequence charSequence = "key_shake_card_item";
        Object obj = (TextUtils.isEmpty(charSequence) || !aNU.eBj.containsKey(charSequence)) ? null : aNU.eBj.get(charSequence);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.iOI;
        if (obj == null || !(obj instanceof e)) {
            boolean z;
            if (this.iOI == 0) {
                z = true;
            } else if (currentTimeMillis >= 0) {
                z = true;
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.h(11666, new Object[]{Integer.valueOf(this.exT)});
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ g iPf;

                    {
                        this.iPf = r1;
                    }

                    public final void run() {
                        this.iPf.iPd.eCZ = 3;
                        this.iPf.eCZ = this.iPf.iPd.eCZ;
                        this.iPf.iPd.iOO = k.aNU().iOJ;
                        if (this.iPf.iOn != null) {
                            this.iPf.iOn.a(1250, this.iPf.iPd, 2);
                        }
                    }
                }, 3000);
                v.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
                z = false;
            }
            if (!z) {
                return;
            }
            if (this.gjR) {
                v.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
                return;
            } else if (this.bYf == -1000.0f || this.bYg == -1000.0f) {
                this.iPe = true;
                v.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ g iPf;

                    {
                        this.iPf = r1;
                    }

                    public final void run() {
                        if (!this.iPf.gjR) {
                            this.iPf.aNY();
                        }
                    }
                }, 4000);
                return;
            } else {
                aNY();
                return;
            }
        }
        this.iOn.a(1250, (e) obj, 1);
        k.aNU().putValue("key_shake_card_item", null);
        v.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
    }

    private void aNY() {
        if (this.gjR) {
            v.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
            return;
        }
        this.gjR = true;
        this.iPe = false;
        v.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
        this.iPc = new c(this.bYg, this.bYf, this.exT, this.gux);
        ak.vy().a(this.iPc, 0);
    }

    public final void pause() {
        YU();
    }

    public final void resume() {
        if (this.cCR != null) {
            this.cCR.a(this.bYl, true);
        }
    }

    public final void aNB() {
        ak.vy().b(1250, this);
        YU();
        super.aNB();
    }

    private void aNA() {
        this.cCR = c.FY();
        this.cCR.a(this.bYl, true);
    }

    private void YU() {
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            e eVar = this.iPd;
            e eVar2 = cVar.iOG;
            eVar.eCZ = eVar2.eCZ;
            eVar.eBK = eVar2.eBK;
            eVar.bom = eVar2.bom;
            eVar.title = eVar2.title;
            eVar.eBN = eVar2.eBN;
            eVar.eBO = eVar2.eBO;
            eVar.eCD = eVar2.eCD;
            eVar.eBM = eVar2.eBM;
            eVar.coN = eVar2.coN;
            eVar.iOH = eVar2.iOH;
            eVar.iOK = eVar2.iOK;
            eVar.iOL = eVar2.iOL;
            eVar.iOM = eVar2.iOM;
            eVar.iON = eVar2.iON;
            eVar.iOO = eVar2.iOO;
            eVar.eBR = eVar2.eBR;
            eVar.iOP = eVar2.iOP;
            eVar.iOQ = eVar2.iOQ;
            this.eCZ = this.iPd.eCZ;
            v.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.eCZ + "  frequency_level:" + iOH + " control_flag:" + this.iPd.iOK);
            if (i == 0 && i2 == 0) {
                iOH = this.iPd.iOH;
                v.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
                if (this.iOn != null) {
                    this.iOn.a(1250, this.iPd, 1);
                }
                aNZ();
            } else if (!(i == 5 && i2 == -1) && (i != 4 || i2 == 0)) {
                v.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.iOn != null) {
                    this.iOn.a(1250, this.iPd, 2);
                }
                aNZ();
            } else {
                v.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.iOn != null) {
                    this.iOn.a(1250, this.iPd, 2);
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long pp = (long) com.tencent.mm.plugin.shake.c.c.a.pp(com.tencent.mm.plugin.shake.c.c.a.aOm());
                v.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is " + pp);
                this.iOI = currentTimeMillis + pp;
            }
            k.aNU().iOH = iOH;
            k.aNU().iOI = this.iOI;
            this.gjR = false;
        }
    }

    private void aNZ() {
        long po;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (com.tencent.mm.plugin.shake.c.c.a.pn(iOH)) {
            v.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
            po = (long) com.tencent.mm.plugin.shake.c.c.a.po(iOH);
        } else {
            v.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
            po = (long) com.tencent.mm.plugin.shake.c.c.a.pp(com.tencent.mm.plugin.shake.c.c.a.aOm());
        }
        v.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is " + po);
        this.iOI = po + currentTimeMillis;
    }
}
