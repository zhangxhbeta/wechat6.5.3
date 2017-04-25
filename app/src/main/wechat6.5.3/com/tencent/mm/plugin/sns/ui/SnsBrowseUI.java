package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.plugin.sns.a.a.f;
import com.tencent.mm.plugin.sns.a.a.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.lucky.b.b;
import com.tencent.mm.plugin.sns.lucky.b.x;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.g;
import java.util.List;

@a(3)
public class SnsBrowseUI extends SnsBaseGalleryUI implements r.a {
    private String bde;
    private int beW = 0;
    Bundle eIW;
    private boolean eIX = false;
    g eIY;
    private int eIZ = 0;
    private int eJa = 0;
    private int eJb = 0;
    private int eJc = 0;
    private int eww = 0;
    private int ewx = 0;
    private ImageView jKJ;
    private int jMc = 0;
    private boolean jMd = false;
    private boolean jMe = false;
    private u jMf;
    private int jMg;
    private int jMh;
    private int jMi = 0;
    private float jMj = 1.0f;
    private int jMk = 0;
    private int jMl = 0;
    private ac mHandler = new ac();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        NI();
        this.eIW = bundle;
    }

    public void onDestroy() {
        com.tencent.mm.modelsns.a gh;
        if (this.jMb != null) {
            int intExtra = getIntent().getIntExtra("K_ad_scene", -1);
            SnsInfoFlip snsInfoFlip = this.jMb;
            String str = this.bde;
            if (snsInfoFlip.jdE) {
                if (intExtra < 0) {
                    v.i("MicroMsg.SnsInfoFlip", "pass by scene " + intExtra);
                } else {
                    k Bq = ad.aSE().Bq(str);
                    if (Bq != null) {
                        if (snsInfoFlip.jPk >= 0) {
                            long longValue = snsInfoFlip.jOM.containsKey(Integer.valueOf(snsInfoFlip.jPk)) ? ((Long) snsInfoFlip.jOM.get(Integer.valueOf(snsInfoFlip.jPk))).longValue() : 0;
                            if (longValue > 0) {
                                long longValue2 = snsInfoFlip.jON.containsKey(Integer.valueOf(snsInfoFlip.jPk)) ? ((Long) snsInfoFlip.jON.get(Integer.valueOf(snsInfoFlip.jPk))).longValue() : 0;
                                longValue = be.az(longValue);
                                longValue2 += longValue;
                                snsInfoFlip.jON.put(Integer.valueOf(snsInfoFlip.jPk), Long.valueOf(longValue2));
                                v.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + snsInfoFlip.jPk + " curtime " + longValue2 + " passtime " + longValue);
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer.append("<desc>");
                        String str2 = "<item><id>%d</id><duration>%d</duration><count>%d</count></item>";
                        String str3 = "%d|%d|%d";
                        for (Integer num : snsInfoFlip.jOL.keySet()) {
                            int intValue = ((Integer) snsInfoFlip.jOL.get(num)).intValue();
                            int longValue3 = snsInfoFlip.jON.containsKey(num) ? (int) (((Long) snsInfoFlip.jON.get(num)).longValue() * 1) : 0;
                            stringBuffer.append(String.format(str2, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}));
                            stringBuffer2.append(String.format(str3, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}) + "&");
                        }
                        stringBuffer.append("</desc>");
                        str = stringBuffer2.toString();
                        str3 = str.endsWith("&") ? str.substring(0, str.length() - 1) : str;
                        i aSy = ad.aSy();
                        Object[] objArr = new Object[1];
                        objArr[0] = f.a(Bq.field_snsId, com.tencent.mm.plugin.sns.data.i.cE(Bq.field_snsId), Bq.aUR(), Integer.valueOf(intExtra), Long.valueOf(snsInfoFlip.jPc), Long.valueOf(System.currentTimeMillis()), str3, Integer.valueOf(snsInfoFlip.getCount()));
                        aSy.h(12014, objArr);
                        ak.vy().a(new c(Bq.aUQ(), 6, intExtra, stringBuffer.toString(), Bq.field_type == 1 ? 1 : 2), 0);
                        gh = com.tencent.mm.modelsns.a.gh(729);
                        gh.kj(com.tencent.mm.plugin.sns.data.i.cE(Bq.field_snsId)).kj(Bq.aUR()).gk(intExtra).kj(snsInfoFlip.jPc).kj(System.currentTimeMillis()).kj(str3).gk(snsInfoFlip.getCount());
                        gh.JF();
                    }
                }
            }
        }
        gh = com.tencent.mm.modelsns.a.m(getIntent());
        if (gh != null) {
            this.jMb.jPl.size();
            gh.gk(this.jMb.getCount()).gk(this.jMb.aWX());
            gh.update();
            gh.JF();
        }
        this.jMb.aWV();
        this.jMb.onDestroy();
        ad.aSB().M(this);
        if (this.jMd) {
            this.jMb.aWZ();
        }
        if (this.jMf != null) {
            this.jMf.stop();
        }
        super.onDestroy();
    }

    protected void onPause() {
        if (this.jMb != null) {
            this.jMb.onPause();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.jMb != null) {
            this.jMb.aWU();
        }
    }

    protected final int getLayoutId() {
        return 2130904439;
    }

    public void onStart() {
        Bundle bundle = this.eIW;
        if (!this.eIX) {
            this.eIX = true;
            if (VERSION.SDK_INT >= 12) {
                this.eIZ = getIntent().getIntExtra("img_gallery_top", 0);
                this.eJa = getIntent().getIntExtra("img_gallery_left", 0);
                this.eJb = getIntent().getIntExtra("img_gallery_width", 0);
                this.eJc = getIntent().getIntExtra("img_gallery_height", 0);
                this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
                if (bundle == null) {
                    this.jMb.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ SnsBrowseUI jMm;

                        {
                            this.jMm = r1;
                        }

                        public final boolean onPreDraw() {
                            this.jMm.jMb.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.jMm.eww = this.jMm.jMb.getWidth();
                            this.jMm.ewx = this.jMm.jMb.getHeight();
                            this.jMm.jMg = this.jMm.jMb.getWidth();
                            this.jMm.jMh = this.jMm.jMb.getHeight();
                            ad.aSB();
                            String C = com.tencent.mm.plugin.sns.e.g.C(this.jMm.jMb.aVD());
                            if (C != null) {
                                Options JS = d.JS(C);
                                this.jMm.jMh = (int) (((float) JS.outHeight) * (((float) this.jMm.jMg) / ((float) JS.outWidth)));
                                if (this.jMm.jMh > this.jMm.jMb.getHeight()) {
                                    this.jMm.jMh = this.jMm.jMb.getHeight();
                                }
                            }
                            this.jMm.eIY.du(this.jMm.jMg, this.jMm.jMh);
                            this.jMm.eIY.a(this.jMm.jMb, this.jMm.jKJ, null);
                            this.jMm.aWA();
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        v.d("MicroMsg.SnsPopMediasUI", "onStart ");
    }

    public final void XJ() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
        setResult(-1, new Intent());
        abE();
        return true;
    }

    protected final void NI() {
        this.eIY = new g(this.nDR.nEl);
        this.eIX = false;
        String ah = be.ah(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.bde = be.ah(getIntent().getStringExtra("sns_gallery_localId"), "");
        this.jMc = getIntent().getIntExtra("sns_gallery_position", 0);
        this.beW = getIntent().getIntExtra("sns_position", 0);
        this.jMd = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
        this.jMe = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
        k Bq = ad.aSE().Bq(this.bde);
        this.jKJ = (ImageView) findViewById(2131755841);
        this.jKJ.setLayerType(2, null);
        this.jMb = new SnsInfoFlip(this);
        this.jMb.setLayerType(2, null);
        this.jMb.jMd = this.jMd;
        this.jMb.jFr = true;
        List Aw = ah.Aw(this.bde);
        this.jMb.jOO = true;
        this.jMb.jOQ = true;
        this.jMb.qV(Bq.field_type);
        this.jMb.a(Aw, ah, this.jMc, this.jLW, this);
        SnsInfoFlip snsInfoFlip = this.jMb;
        com.tencent.mm.storage.ak bvR = com.tencent.mm.storage.ak.bvR();
        bvR.hrm = Bq.field_createTime;
        snsInfoFlip.jdP = bvR;
        addView(this.jMb);
        if (Bq != null && Bq.qC(32)) {
            this.jMb.jdE = true;
        }
        if (!x.h(Bq)) {
            v.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + Bq.field_userName + " " + Bq.field_snsId);
            finish();
        } else if (Bq.field_type == 21 && !Bq.field_userName.equals(com.tencent.mm.model.k.xF())) {
            this.jMf = new u(e.cni + "/Pictures/Screenshots/", new u.a(this) {
                final /* synthetic */ SnsBrowseUI jMm;

                {
                    this.jMm = r1;
                }

                public final void aWB() {
                    b.kZ(44);
                    com.tencent.mm.plugin.sns.lucky.c.a.a(4, ad.aSE().Bq(this.jMm.bde));
                }
            });
            this.jMf.start();
        }
    }

    public final void abE() {
        int i = this.eJb;
        int i2 = this.eJc;
        int i3 = this.eJa;
        int i4 = this.eIZ;
        if (!this.jMe) {
            fp fpVar = new fp();
            fpVar.beU.beX = this.jMb.jOJ.getSelectedItemPosition();
            fpVar.beU.beW = this.beW;
            com.tencent.mm.sdk.c.a.nhr.z(fpVar);
            i = fpVar.beV.aXX;
            i2 = fpVar.beV.aXY;
            i3 = fpVar.beV.aXV;
            i4 = fpVar.beV.aXW;
        }
        this.jMg = this.jMb.getWidth();
        this.jMh = this.jMb.getHeight();
        ad.aSB();
        String C = com.tencent.mm.plugin.sns.e.g.C(this.jMb.aVD());
        if (C != null) {
            Options JS = d.JS(C);
            this.jMh = (int) (((float) JS.outHeight) * (((float) this.jMg) / ((float) JS.outWidth)));
            if (this.jMh > this.jMb.getHeight()) {
                if (((double) this.jMh) < ((double) this.jMb.getHeight()) * 2.5d) {
                    this.jMi = this.jMh - this.jMb.getHeight();
                    if (this.jMb.getCount() == 1) {
                        i2 = (i2 * this.jMb.getHeight()) / this.jMh;
                        this.jMi = 0;
                    }
                }
                this.jMh = this.jMb.getHeight();
            }
        }
        this.eIY.du(this.jMg, this.jMh);
        this.eIY.m(i3, i4, i, i2);
        if (((double) this.jMj) != 1.0d) {
            this.eIY.oSK = 1.0f / this.jMj;
            if (!(this.jMk == 0 && this.jMl == 0)) {
                this.eIY.dv(((int) (((float) (this.jMb.getWidth() / 2)) * (1.0f - this.jMj))) + this.jMk, (int) (((float) ((this.jMb.getHeight() / 2) + this.jMl)) - (((float) (this.jMh / 2)) * this.jMj)));
            }
        }
        this.eIY.jCG = this.jMi;
        this.eIY.a(this.jMb, this.jKJ, new g.b(this) {
            final /* synthetic */ SnsBrowseUI jMm;

            {
                this.jMm = r1;
            }

            public final void onAnimationStart() {
                SnsInfoFlip snsInfoFlip = this.jMm.jMb;
                if (snsInfoFlip.jOW != null) {
                    snsInfoFlip.jOW.setVisibility(8);
                }
                this.jMm.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 jMn;

                    {
                        this.jMn = r1;
                    }

                    public final void run() {
                        SnsInfoFlip snsInfoFlip = this.jMn.jMm.jMb;
                        if (snsInfoFlip.jOJ != null) {
                            View selectedView = snsInfoFlip.jOJ.getSelectedView();
                            if (selectedView instanceof MultiTouchImageView) {
                                ((MultiTouchImageView) selectedView).bCO();
                            }
                        }
                    }
                }, 20);
            }

            public final void onAnimationEnd() {
                this.jMm.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 jMn;

                    {
                        this.jMn = r1;
                    }

                    public final void run() {
                        this.jMn.jMm.finish();
                        this.jMn.jMm.overridePendingTransition(0, 0);
                    }
                });
            }
        }, new g.a(this) {
            final /* synthetic */ SnsBrowseUI jMm;

            {
                this.jMm = r1;
            }

            public final void n(int i, int i2, int i3, int i4) {
                if (this.jMm.jMb.jOJ != null && VERSION.SDK_INT >= 18) {
                    this.jMm.jMb.jOJ.setClipBounds(new Rect(i, i2, i3, i4));
                }
            }
        });
    }

    public final void aWA() {
        final Gallery gallery = this.jMb.jOJ;
        if (gallery instanceof MMGestureGallery) {
            ((MMGestureGallery) gallery).oTq = new MMGestureGallery.b(this) {
                final /* synthetic */ SnsBrowseUI jMm;

                public final void x(float f, float f2) {
                    if ((this.jMm.ewx == 0 || this.jMm.eww == 0) && this.jMm.jMb != null) {
                        this.jMm.ewx = this.jMm.jMb.getHeight();
                        this.jMm.eww = this.jMm.jMb.getWidth();
                    }
                    if (this.jMm.ewx != 0) {
                        float f3 = 1.0f - (f2 / ((float) this.jMm.ewx));
                        if (f3 > 1.0f) {
                            f3 = 1.0f;
                        }
                        this.jMm.jMj = f3;
                        View selectedView = ((MMGestureGallery) gallery).getSelectedView();
                        if (selectedView instanceof MultiTouchImageView) {
                            selectedView.setPivotX((float) (this.jMm.eww / 2));
                            selectedView.setPivotY((float) (this.jMm.ewx / 2));
                            selectedView.setScaleX(f3);
                            selectedView.setScaleY(f3);
                            selectedView.setTranslationX(f);
                            selectedView.setTranslationY(f2);
                            this.jMm.jKJ.setAlpha(f3);
                        }
                    }
                }

                public final void y(float f, float f2) {
                    this.jMm.jMk = (int) f;
                    this.jMm.jMl = (int) f2;
                }
            };
        }
    }

    public final void aY(String str, int i) {
        if (this.jMb != null) {
            this.jMb.aWU();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsPopMediasUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int NO() {
        return 2;
    }

    public final void aZ(String str, int i) {
        this.jMc = i;
    }
}
