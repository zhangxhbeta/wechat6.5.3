package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.lv;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.g;
import com.tencent.mm.plugin.sns.e.p;
import com.tencent.mm.plugin.sns.lucky.b.b;
import com.tencent.mm.plugin.sns.lucky.b.c;
import com.tencent.mm.plugin.sns.lucky.b.m;
import com.tencent.mm.plugin.sns.lucky.b.o;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;
import java.util.Random;

@a(3)
public class SnsLuckyMoneyWantSeePhotoUI extends LuckyMoneyBaseUI implements c {
    private String bZy;
    private e cAR = new e(this) {
        final /* synthetic */ SnsLuckyMoneyWantSeePhotoUI jhr;

        {
            this.jhr = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "errType " + i + " errCode " + i2 + " errMsg " + str);
            if (kVar.getType() == 218) {
                p pVar = (p) kVar;
                if (this.jhr.dwg != null && this.jhr.dwg.isShowing()) {
                    this.jhr.dwg.dismiss();
                }
                if (this.jhr.jgZ == null || pVar.type != 10 || pVar.jkf != this.jhr.jgZ.jkf) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    b.kZ(90);
                    Intent intent = new Intent();
                    intent.setClass(this.jhr.nDR.nEl, SnsLuckyMoneyNewYearMedalUI.class);
                    intent.putExtra("key_way", 2);
                    this.jhr.nDR.nEl.startActivityForResult(intent, 2);
                    b.kZ(37);
                    com.tencent.mm.plugin.sns.lucky.c.a.a(6, this.jhr.jaC);
                    this.jhr.aRE();
                    return;
                }
                b.kZ(91);
                if (this.jhr.jhl != null) {
                    v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "netSceneOp error then mark svr down");
                    this.jhr.jhl.aRl();
                }
                this.jhr.wd(this.jhr.getString(2131235477));
            }
        }
    };
    private com.tencent.mm.ui.base.p dwg = null;
    private ProgressBar fpm;
    private Button fpp;
    private String ftu;
    private String hei;
    private com.tencent.mm.plugin.sns.storage.k jaC;
    private p jgZ;
    private String jgp;
    private awa jgq;
    private String jha;
    private String jhb;
    private String jhc;
    private aib jhd;
    private ImageView jhe;
    private SnsLuckyAdBannerImageView jhf;
    private TextView jhg;
    private View jhh;
    private View jhi;
    private LuckyRevealImageView jhj;
    private Long jhk;
    private com.tencent.mm.plugin.sns.lucky.b.p jhl;
    private a jhm = new a();
    public int jhn;
    public int jho;
    public int jhp;
    private long jhq = 0;

    static /* synthetic */ void k(SnsLuckyMoneyWantSeePhotoUI snsLuckyMoneyWantSeePhotoUI) {
        Bitmap c;
        if (snsLuckyMoneyWantSeePhotoUI.jaC != null) {
            aic aUD = snsLuckyMoneyWantSeePhotoUI.jaC.aUD();
            if (aUD == null || aUD.hav != 0) {
                snsLuckyMoneyWantSeePhotoUI.fpp.setVisibility(8);
            } else {
                snsLuckyMoneyWantSeePhotoUI.fpp.setVisibility(0);
            }
        } else {
            snsLuckyMoneyWantSeePhotoUI.fpp.setVisibility(8);
        }
        Boolean valueOf = Boolean.valueOf(true);
        if (be.kS(snsLuckyMoneyWantSeePhotoUI.jha)) {
            valueOf = Boolean.valueOf(false);
        } else {
            c = BackwardSupportUtil.b.c(snsLuckyMoneyWantSeePhotoUI.jha, com.tencent.mm.bd.a.getDensity(snsLuckyMoneyWantSeePhotoUI.nDR.nEl));
            if (!(c == null || c.isRecycled())) {
                snsLuckyMoneyWantSeePhotoUI.jhe.setImageBitmap(c);
            }
        }
        if (be.kS(snsLuckyMoneyWantSeePhotoUI.jhc)) {
            valueOf = Boolean.valueOf(false);
        } else {
            snsLuckyMoneyWantSeePhotoUI.jhg.setText(snsLuckyMoneyWantSeePhotoUI.jhc);
            snsLuckyMoneyWantSeePhotoUI.jhi.setVisibility(0);
        }
        if (be.kS(snsLuckyMoneyWantSeePhotoUI.jhb)) {
            valueOf = Boolean.valueOf(false);
        } else {
            c = d.decodeFile(snsLuckyMoneyWantSeePhotoUI.jhb, null);
            SnsLuckyAdBannerImageView snsLuckyAdBannerImageView = snsLuckyMoneyWantSeePhotoUI.jhf;
            snsLuckyAdBannerImageView.jgh = c;
            if (snsLuckyAdBannerImageView.jgh != null) {
                Bitmap createBitmap = Bitmap.createBitmap(snsLuckyAdBannerImageView.jgh.getWidth(), snsLuckyAdBannerImageView.jgh.getHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas();
                canvas.setBitmap(createBitmap);
                snsLuckyAdBannerImageView.jgi.set(-((float) com.tencent.mm.bd.a.fromDPToPix(snsLuckyAdBannerImageView.getContext(), 5)), (float) snsLuckyAdBannerImageView.padding, (float) (snsLuckyAdBannerImageView.jgh.getWidth() - snsLuckyAdBannerImageView.padding), (float) (snsLuckyAdBannerImageView.jgh.getHeight() - snsLuckyAdBannerImageView.padding));
                snsLuckyAdBannerImageView.evR.setAntiAlias(true);
                snsLuckyAdBannerImageView.evR.setDither(true);
                snsLuckyAdBannerImageView.evR.setFilterBitmap(true);
                snsLuckyAdBannerImageView.evR.setColor(snsLuckyAdBannerImageView.color);
                canvas.drawRoundRect(snsLuckyAdBannerImageView.jgi, snsLuckyAdBannerImageView.jgj, snsLuckyAdBannerImageView.jgj, snsLuckyAdBannerImageView.evR);
                snsLuckyAdBannerImageView.evR.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(c, 0.0f, 0.0f, snsLuckyAdBannerImageView.evR);
                snsLuckyAdBannerImageView.jgh = createBitmap;
                snsLuckyAdBannerImageView.setImageBitmap(snsLuckyAdBannerImageView.jgh);
            }
        }
        if (valueOf.booleanValue()) {
            snsLuckyMoneyWantSeePhotoUI.jhi.setVisibility(0);
            b.kZ(45);
            if (snsLuckyMoneyWantSeePhotoUI.jho <= 0 || snsLuckyMoneyWantSeePhotoUI.jhp <= 0) {
                b.kZ(52);
            } else {
                b.cq(snsLuckyMoneyWantSeePhotoUI.jho, 0);
                b.cq(snsLuckyMoneyWantSeePhotoUI.jho, snsLuckyMoneyWantSeePhotoUI.jhp);
            }
        } else {
            b.kZ(46);
            if (snsLuckyMoneyWantSeePhotoUI.jhn == 0) {
                b.kZ(47);
            } else if (be.kS(snsLuckyMoneyWantSeePhotoUI.jha) && ((be.kS(snsLuckyMoneyWantSeePhotoUI.jhc) || snsLuckyMoneyWantSeePhotoUI.jhc.length() == 0) && be.kS(snsLuckyMoneyWantSeePhotoUI.jhb))) {
                b.kZ(48);
                snsLuckyMoneyWantSeePhotoUI.aRC();
            } else if (be.kS(snsLuckyMoneyWantSeePhotoUI.jha)) {
                b.kZ(50);
                snsLuckyMoneyWantSeePhotoUI.aRC();
            } else if (be.kS(snsLuckyMoneyWantSeePhotoUI.jhc) || snsLuckyMoneyWantSeePhotoUI.jhc.length() == 0) {
                b.kZ(51);
                snsLuckyMoneyWantSeePhotoUI.aRC();
            } else if (be.kS(snsLuckyMoneyWantSeePhotoUI.jhb)) {
                b.kZ(49);
                snsLuckyMoneyWantSeePhotoUI.aRC();
            }
        }
        if (!valueOf.booleanValue()) {
            ((MarginLayoutParams) snsLuckyMoneyWantSeePhotoUI.jhh.getLayoutParams()).bottomMargin = com.tencent.mm.bd.a.fromDPToPix(snsLuckyMoneyWantSeePhotoUI, 60);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(218, this.cAR);
        this.hei = getIntent().getStringExtra("key_sendid");
        this.ftu = getIntent().getStringExtra("key_feedid");
        this.bZy = getIntent().getStringExtra("key_username");
        v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "mSnsLocalId " + this.ftu);
        this.jaC = ad.aSE().Bq(this.ftu);
        if (this.jaC != null) {
            this.jgq = ah.n(this.jaC);
            if (this.jgq != null) {
                awq com_tencent_mm_protocal_c_awq = this.jgq.mTz;
            }
        }
        aRB();
        this.jhl = com.tencent.mm.plugin.sns.lucky.b.p.aRk();
        com.tencent.mm.plugin.sns.lucky.b.p pVar = this.jhl;
        pVar.jfr = this;
        ak.vy().a(428, pVar);
        v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "sendid=" + be.ma(this.hei) + ", feedId=" + be.d(Long.valueOf(this.jaC.field_snsId)));
        NI();
        if (be.kS(this.jgp) || this.jhd == null) {
            aRB();
        }
        if (!be.kS(this.jgp) && this.jhd != null) {
            if (a.q(this.jhd)) {
                aRD();
                return;
            }
            this.fpm.setVisibility(0);
            int a = BackwardSupportUtil.b.a(this, 160.0f);
            int a2 = BackwardSupportUtil.b.a(this, 200.0f);
            int a3 = BackwardSupportUtil.b.a(this, 44.0f);
            g aSB = ad.aSB();
            aib com_tencent_mm_protocal_c_aib = this.jhd;
            String ab = i.ab(1, com_tencent_mm_protocal_c_aib.gID);
            String str = com_tencent_mm_protocal_c_aib.gID;
            n Ai = aSB.Ai(ab);
            Bitmap wm = i.b(Ai) ? Ai.wm() : null;
            LayoutParams layoutParams = this.jhj.getLayoutParams();
            layoutParams.width = a;
            layoutParams.height = a;
            if (wm != null) {
                double d;
                double width = (double) wm.getWidth();
                double height = (double) wm.getHeight();
                if (width <= 0.0d || height <= 0.0d) {
                    width = (double) a;
                    d = (double) a;
                } else {
                    d = Math.min(((double) a2) / width, ((double) a2) / height);
                    width *= d;
                    d *= height;
                    if (width < ((double) a3)) {
                        height = (((double) a3) * 1.0d) / width;
                        width *= height;
                        d *= height;
                    }
                    if (d < ((double) a3)) {
                        height = (((double) a3) * 1.0d) / d;
                        width *= height;
                        d *= height;
                    }
                    if (width > ((double) a2)) {
                        width = (double) a2;
                    }
                    if (d > ((double) a2)) {
                        d = (double) a2;
                    }
                }
                layoutParams.height = (int) d;
                layoutParams.width = (int) width;
            }
            this.jhj.setLayoutParams(layoutParams);
            ad.aSB().d(this.jhd, this.jhj, hashCode(), com.tencent.mm.storage.ak.nvx);
            aRD();
        }
    }

    private void aRB() {
        if (this.jaC == null) {
            this.jaC = ad.aSE().Bq(this.ftu);
        }
        if (this.jaC != null) {
            azr aUp = this.jaC.aUp();
            if (aUp != null) {
                List list = aUp.mWq.mom;
                if (list.size() > 0) {
                    this.jhd = (aib) list.get(0);
                    this.jgp = this.jhd.glb;
                    return;
                }
                v.e("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "mediaList is empty");
                return;
            }
            v.e("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "timelineObject is null");
        }
    }

    protected final void NI() {
        getWindow().setFlags(1024, 1024);
        this.nDR.bAj();
        this.dwg = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131233521), true, new OnCancelListener(this) {
            final /* synthetic */ SnsLuckyMoneyWantSeePhotoUI jhr;

            {
                this.jhr = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.jhr.dwg != null && this.jhr.dwg.isShowing()) {
                    this.jhr.dwg.dismiss();
                }
                this.jhr.hdT.axF();
                if (this.jhr.nDR.dtW.getVisibility() == 8 || this.jhr.nDR.dtW.getVisibility() == 4) {
                    v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "user cancel & finish");
                    this.jhr.finish();
                }
            }
        });
        if (this.dwg != null) {
            this.dwg.dismiss();
        }
        this.jhh = findViewById(2131759411);
        this.jhj = (LuckyRevealImageView) findViewById(2131759399);
        this.fpm = (ProgressBar) findViewById(2131757495);
        this.nDR.dtW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyWantSeePhotoUI jhr;

            {
                this.jhr = r1;
            }

            public final void onClick(View view) {
                this.jhr.finish();
            }
        });
        this.fpp = (Button) findViewById(2131759405);
        this.fpp.setVisibility(8);
        this.jhe = (ImageView) findViewById(2131759409);
        this.jhg = (TextView) findViewById(2131759410);
        this.jhf = (SnsLuckyAdBannerImageView) findViewById(2131759408);
        this.jhi = findViewById(2131759407);
        this.jhi.setVisibility(8);
        this.fpp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyWantSeePhotoUI jhr;

            {
                this.jhr = r1;
            }

            public final void onClick(View view) {
                boolean z = false;
                b.kZ(36);
                String cE = i.cE(this.jhr.jaC.field_snsId);
                if (this.jhr.dwg != null) {
                    this.jhr.dwg.show();
                }
                com.tencent.mm.plugin.sns.lucky.b.p c = this.jhr.jhl;
                v.i("MicroMsg.NewYearSnsFlowControlMgr", "check snsamount " + cE + " state: " + c.jfg);
                if (cE == null || cE.length() == 0) {
                    v.e("MicroMsg.NewYearSnsFlowControlMgr", "checkSnsAmountFlow, invalid arg, feedId is nil");
                } else if (((com.tencent.mm.plugin.sns.lucky.b.e) c.jfi.get(cE)) != null) {
                    v.e("MicroMsg.NewYearSnsFlowControlMgr", "checkSnsAmountFlow, skip, wait notify, feedId=%s", new Object[]{cE});
                } else if (c.jfm.contains(cE)) {
                    v.e("MicroMsg.NewYearSnsFlowControlMgr", "checkSnsAmountFlow, wait async in ui, feedId=%s", new Object[]{cE});
                } else {
                    boolean z2;
                    akh com_tencent_mm_protocal_c_akh;
                    long currentTimeMillis;
                    int i;
                    if (c.jfg == 2) {
                        if (cE == null || cE.length() == 0) {
                            v.e("MicroMsg.NewYearSnsFlowControlMgr", "feedId is null");
                            z2 = false;
                        } else {
                            com_tencent_mm_protocal_c_akh = (akh) c.jfj.get(cE);
                            if (com_tencent_mm_protocal_c_akh == null) {
                                v.i("MicroMsg.NewYearSnsFlowControlMgr", "isInCacheTime, not exist cache check item, feedId=%s", new Object[]{cE});
                                z2 = false;
                            } else if (com_tencent_mm_protocal_c_akh.aXy == 0) {
                                z2 = false;
                            } else {
                                currentTimeMillis = System.currentTimeMillis();
                                Long l = (Long) c.jfk.get(cE);
                                if (l == null) {
                                    z2 = false;
                                } else if (l.longValue() + ((long) (com_tencent_mm_protocal_c_akh.mLl * 1000)) > currentTimeMillis) {
                                    v.i("MicroMsg.NewYearSnsFlowControlMgr", "isInCacheTime curCacheStartTime %d  serverInterval %d curTime %d cachein", new Object[]{l, Integer.valueOf(com_tencent_mm_protocal_c_akh.mLl), Long.valueOf(currentTimeMillis)});
                                    z2 = true;
                                } else {
                                    v.i("MicroMsg.NewYearSnsFlowControlMgr", "isInCacheTime curCacheStartTime %d  serverInterval  %d curTime %d missin", new Object[]{l, Integer.valueOf(com_tencent_mm_protocal_c_akh.mLl), Long.valueOf(currentTimeMillis)});
                                    z2 = false;
                                }
                            }
                        }
                        if (z2) {
                            com_tencent_mm_protocal_c_akh = (akh) c.jfj.get(cE);
                            v.i("MicroMsg.NewYearSnsFlowControlMgr", "checkSnsAmountFlow isInCacheTime, feedId=%s, in cahce time, freeMode=%b", new Object[]{cE, Boolean.valueOf(false)});
                            c.a(cE, com_tencent_mm_protocal_c_akh);
                            z = true;
                        }
                    }
                    if (cE == null || cE.length() == 0) {
                        i = false;
                    } else if (c.jfi.size() == 0 || ((com.tencent.mm.plugin.sns.lucky.b.e) c.jfi.get(cE)) == null) {
                        z2 = false;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        v.i("MicroMsg.NewYearSnsFlowControlMgr", "checkSnsAmountFlow, isChecking skip check, feedId=%s", new Object[]{cE});
                        c.Ab(cE);
                    } else {
                        i = ak.vy().BJ();
                        v.i("MicroMsg.NewYearSnsFlowControlMgr", "getNetWorkState " + i);
                        if (i == 0) {
                            if (cE != null && cE.length() > 0) {
                                c.jfl.remove(cE);
                            }
                            if (c.jfr != null) {
                                c.jfr.aRe();
                            }
                        } else {
                            c.jfq = System.currentTimeMillis();
                            o aRh = o.aRh();
                            i = aRh.jew;
                            int i2 = aRh.jex;
                            if (i == 0 && i2 == 0) {
                                i2 = 4;
                                i = 0;
                            }
                            int pV = com.tencent.mm.plugin.sns.lucky.b.p.pV(i);
                            int pV2 = com.tencent.mm.plugin.sns.lucky.b.p.pV(i2);
                            int nextInt = new Random(System.currentTimeMillis()).nextInt(pV2 - pV) + pV;
                            v.d("MicroMsg.NewYearSnsFlowControlMgr", "getsvrDown lowLevel:" + i + " hightLevel :" + i2 + " randomMax: " + pV2 + " randomMin: " + pV + " waitTime: " + nextInt + " svrDownWaitTimeStart: " + c.jfo);
                            c.jfp = (long) nextInt;
                            if (nextInt == 0) {
                                c.jfp = 60000;
                            }
                            if (c.jfo + c.jfp >= System.currentTimeMillis()) {
                                v.v("MicroMsg.NewYearSnsFlowControlMgr", "svrDown wait time  " + c.jfo + " " + c.jfp);
                                i = 1;
                            } else {
                                z2 = false;
                            }
                            if (i != 0) {
                                v.i("MicroMsg.NewYearSnsFlowControlMgr", "checkSnsAmountFlow, skip check for svrdown, feedId=%s", new Object[]{cE});
                                c.Ab(cE);
                                z = true;
                            } else {
                                b.kZ(81);
                                currentTimeMillis = i.zY(cE);
                                com.tencent.mm.ba.b bVar = c.jfn;
                                m aRg = m.aRg();
                                if (aRg != null) {
                                    i = aRg.level;
                                } else {
                                    com_tencent_mm_protocal_c_akh = (akh) c.jfj.get(cE);
                                    i = com_tencent_mm_protocal_c_akh != null ? com_tencent_mm_protocal_c_akh.mLj : 0;
                                }
                                com.tencent.mm.plugin.sns.lucky.b.e eVar = new com.tencent.mm.plugin.sns.lucky.b.e(bVar, currentTimeMillis, i);
                                ak.vy().a(eVar, 0);
                                c.jfi.put(cE, eVar);
                                z = true;
                            }
                        }
                    }
                }
                if (!z) {
                    if (this.jhr.dwg != null && this.jhr.dwg.isShowing()) {
                        this.jhr.dwg.dismiss();
                    }
                    v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onNewYearSnsFlowContrlFail OnClickListener" + z);
                    this.jhr.wd(this.jhr.getString(2131235477));
                    b.kZ(39);
                    com.tencent.mm.plugin.sns.lucky.c.a.a(11, this.jhr.jaC);
                }
            }
        });
        this.nDR.dtW.setVisibility(0);
    }

    private void aRC() {
        lv lvVar = new lv();
        lvVar.bmZ.bna = true;
        lvVar.bmZ.key = 69;
        lvVar.bmZ.value = 1;
        lvVar.bmZ.type = 30;
        lvVar.bmZ.aYp = this.jhn;
        com.tencent.mm.sdk.c.a.nhr.z(lvVar);
    }

    private void aRD() {
        a aVar = this.jhm;
        aib com_tencent_mm_protocal_c_aib = this.jhd;
        a.a anonymousClass5 = new a.a(this) {
            final /* synthetic */ SnsLuckyMoneyWantSeePhotoUI jhr;

            {
                this.jhr = r1;
            }

            public final void aRx() {
                b.kZ(32);
            }

            public final void aRy() {
                v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onLoadFinished, mediaObj.Id: %s", new Object[]{this.jhr.jhd.gID});
                this.jhr.fpm.setVisibility(8);
                LayoutParams layoutParams = this.jhr.jhj.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.jhr.jhj.setLayoutParams(layoutParams);
                this.jhr.jhj.jfX = this.jhr.jhd;
                LuckyRevealImageView j = this.jhr.jhj;
                LuckyRevealImageView.jfC = com.tencent.mm.bd.a.fromDPToPix(j.getContext(), 50);
                LuckyRevealImageView.jfD = com.tencent.mm.bd.a.fromDPToPix(j.getContext(), 100);
                if (j.jfX != null) {
                    j.jfE = i.zS(al.cA(ad.xh(), j.jfX.gID) + i.h(j.jfX)).wm();
                    j.jfF = i.zS(al.cA(ad.xh(), j.jfX.gID) + i.g(j.jfX)).wm();
                    if (!(j.jfE == null || j.jfF == null)) {
                        Canvas canvas = new Canvas();
                        Bitmap createBitmap = Bitmap.createBitmap(j.jfF.getWidth(), j.jfF.getHeight(), Config.ARGB_8888);
                        canvas.setBitmap(createBitmap);
                        canvas.drawBitmap(j.jfF, 0.0f, 0.0f, null);
                        canvas.drawColor(j.jfH);
                        j.jfF = createBitmap;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            j.aRn();
                        } else {
                            j.cnC.post(new Runnable(j) {
                                final /* synthetic */ LuckyRevealImageView jgg;

                                {
                                    this.jgg = r1;
                                }

                                public final void run() {
                                    this.jgg.aRn();
                                }
                            });
                        }
                    }
                    com.tencent.mm.sdk.i.e.a(new Runnable(j) {
                        final /* synthetic */ LuckyRevealImageView jgg;

                        {
                            this.jgg = r1;
                        }

                        public final void run() {
                            LuckyRevealImageView.b(this.jgg);
                        }
                    }, "LuckyRevealImageView_prepare");
                }
                SnsLuckyMoneyWantSeePhotoUI.k(this.jhr);
            }

            public final void aRz() {
                v.e("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onLoadError");
                Toast.makeText(this.jhr, this.jhr.getString(2131235392), 0).show();
                if (this.jhr.fpm != null) {
                    this.jhr.fpm.setVisibility(8);
                }
            }

            public final void fR(boolean z) {
                if (!((be.kS(this.jhr.jha) && ((be.kS(this.jhr.jhc) || this.jhr.jhc.length() == 0) && be.kS(this.jhr.jhb))) || be.kS(this.jhr.jha) || be.kS(this.jhr.jhc) || this.jhr.jhc.length() == 0)) {
                    be.kS(this.jhr.jhb);
                }
                com.tencent.mm.plugin.sns.lucky.c.a.a(3, this.jhr.jaC);
                if (z) {
                    b.kZ(33);
                } else {
                    b.kZ(34);
                }
            }
        };
        if (com_tencent_mm_protocal_c_aib != null) {
            aVar.jgk = anonymousClass5;
            aVar.jfX = com_tencent_mm_protocal_c_aib;
            aVar.jgl = true;
            v.i("MicroMsg.SnsLuckyBigBlurImgLoader", "loadInternal, filename: %s", new Object[]{aVar.aRv()});
            if (FileOp.aR(aVar.aRv()) && FileOp.aR(aVar.aRo())) {
                v.d("MicroMsg.SnsLuckyBigBlurImgLoader", "load, local small blur bitmap and origin big bitmap exist, directly callback");
                aVar.aRt();
                return;
            }
            com.tencent.mm.sdk.i.e.c(new Runnable(aVar) {
                final /* synthetic */ a jgm;

                {
                    this.jgm = r1;
                }

                public final void run() {
                    if (this.jgm.jfX != null) {
                        a.b(this.jgm);
                    }
                }
            }, "SnsLuckyBigBlurImgLoader").start();
            aVar.handler.post(new Runnable(aVar) {
                final /* synthetic */ a jgm;

                {
                    this.jgm = r1;
                }

                public final void run() {
                    if (this.jgm.jgk != null) {
                        this.jgm.jgk.aRx();
                    }
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(218, this.cAR);
        a aVar = this.jhm;
        aVar.jfF = null;
        aVar.jfE = null;
        aVar.jgk = null;
        ad.aSz().b(aVar);
        com.tencent.mm.plugin.sns.lucky.b.p pVar = this.jhl;
        pVar.jfr = null;
        ak.vy().b(428, pVar);
        this.dwg = null;
        this.jhm = null;
        this.jhf.jgh = null;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904472;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onActivityResult " + i + " " + i2);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    aRE();
                    if (i == 2) {
                        com.tencent.mm.plugin.sns.lucky.c.a.a(12, this.jaC);
                    }
                    com.tencent.mm.sdk.c.a.nhr.z(new nv());
                    com.tencent.mm.plugin.sns.ui.al.d(this, this.ftu);
                    break;
                }
                return;
            case 2:
                if (i2 == -1) {
                    if (i == 2) {
                        com.tencent.mm.plugin.sns.lucky.c.a.a(12, this.jaC);
                    }
                    com.tencent.mm.sdk.c.a.nhr.z(new nv());
                    com.tencent.mm.plugin.sns.ui.al.d(this, this.ftu);
                    break;
                }
                break;
            default:
                return;
        }
        finish();
    }

    private void aRE() {
        com.tencent.mm.plugin.sns.storage.k Bq = ad.aSE().Bq(this.ftu);
        if (Bq != null) {
            aic aUD = Bq.aUD();
            if (aUD != null) {
                aUD.hav = 1;
                try {
                    Bq.field_postBuf = aUD.toByteArray();
                    awa n = ah.n(Bq);
                    if (n.mTz == null) {
                        n.mTz = new awq();
                    }
                    avx com_tencent_mm_protocal_c_avx = new avx();
                    com_tencent_mm_protocal_c_avx.mdw = com.tencent.mm.model.k.xF();
                    com_tencent_mm_protocal_c_avx.hNS = (int) (System.currentTimeMillis() / 1000);
                    com_tencent_mm_protocal_c_avx.mSR = new are();
                    n.mTz.mTZ.add(com_tencent_mm_protocal_c_avx);
                    n.mTz.mTY = n.mTz.mTZ.size();
                    Bq.aC(n.toByteArray());
                    ad.aSE().b(Bq.field_snsId, Bq);
                } catch (Exception e) {
                    v.e("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", e.getMessage() + "SnsInfo Storage the hbstatus error " + this.ftu + " " + (Bq == null ? "" : Long.valueOf(Bq.field_snsId)));
                }
            }
        }
    }

    public final void b(com.tencent.mm.ba.b bVar) {
        v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onNewYearSnsFlowContrl bFreeMode");
        this.jgZ = new p(this.jaC.field_snsId, 10, null, bVar);
        ak.vy().a(this.jgZ, 0);
    }

    public final void f(int i, List<Integer> list) {
        v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onNewYearSnsFlowContrl " + (list == null ? 0 : list.size()) + " " + i);
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
        i.cE(this.jaC.field_snsId);
        if (list == null || list.size() == 0) {
            list = o.aRh().pU(i);
        }
        int size = list.size();
        if (size == 0) {
            v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onCommonActionFail because count = 0");
            wd(getString(2131235477));
            return;
        }
        this.jhk = Long.valueOf(0);
        if (size == 1) {
            this.jhk = Long.valueOf(((Integer) list.get(0)).longValue());
        } else {
            this.jhk = Long.valueOf(((Integer) list.get(Math.abs(new Random(System.currentTimeMillis()).nextInt()) % size)).longValue());
        }
        if (System.currentTimeMillis() - this.jhq > 500) {
            Intent intent = new Intent();
            intent.setClass(this.nDR.nEl, SnsLuckyMoneyNewYearSendUI.class);
            intent.putExtra("key_way", 2);
            intent.putExtra("key_username", this.bZy);
            intent.putExtra("key_sendid", this.hei);
            intent.putExtra("key_feedid", this.ftu);
            intent.putExtra("key_lucky_money_value", this.jhk);
            this.nDR.nEl.startActivityForResult(intent, 1);
            b.kZ(38);
            com.tencent.mm.plugin.sns.lucky.c.a.a(5, this.jaC);
        }
        this.jhq = System.currentTimeMillis();
    }

    public final void aRd() {
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
        v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onNewYearSnsFlowContrlFail");
        wd(getString(2131235477));
        b.kZ(39);
        com.tencent.mm.plugin.sns.lucky.c.a.a(11, this.jaC);
    }

    public final void aRe() {
        v.i("MicroMsg.SnsLuckyMoneyWantSeePhotoUI", "onNewYearSnsFlowContrlNetFail");
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
        wd(getString(2131234019));
        b.kZ(39);
        com.tencent.mm.plugin.sns.lucky.c.a.a(11, this.jaC);
    }
}
