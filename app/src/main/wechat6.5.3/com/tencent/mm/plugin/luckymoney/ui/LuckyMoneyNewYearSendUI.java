package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.c.ad;
import com.tencent.mm.plugin.luckymoney.c.j;
import com.tencent.mm.plugin.luckymoney.c.k;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

@a(3)
public class LuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    private Dialog dxy = null;
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ LuckyMoneyNewYearSendUI hgz;

        {
            this.hgz = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131757886) {
                g.iuh.h(13079, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                if (this.hgz.hcc == 1 && this.hgz.hgc && !TextUtils.isEmpty(this.hgz.hgx) && !TextUtils.isEmpty(this.hgz.hgd) && !TextUtils.isEmpty(this.hgz.hge) && this.hgz.hgf > 0) {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with last post image data!");
                    LuckyMoneyNewYearSendUI.g(this.hgz);
                } else if (this.hgz.hcc == 1 && this.hgz.hgc && !TextUtils.isEmpty(this.hgz.hgx)) {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with new image data!");
                    this.hgz.ays();
                    if (this.hgz.hgg == null) {
                        this.hgz.hgg = new j();
                    }
                    j i = this.hgz.hgg;
                    String c = this.hgz.hgx;
                    j.a anonymousClass1 = new j.a(this) {
                        final /* synthetic */ AnonymousClass1 hgA;

                        {
                            this.hgA = r1;
                        }

                        public final void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, boolean z) {
                            if (z) {
                                v.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image success, to send HB");
                                this.hgA.hgz.hgd = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                                this.hgA.hgz.hge = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                                this.hgA.hgz.hgf = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                                this.hgA.hgz.mHandler.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 hgB;

                                    {
                                        this.hgB = r1;
                                    }

                                    public final void run() {
                                        LuckyMoneyNewYearSendUI.g(this.hgB.hgA.hgz);
                                    }
                                });
                                return;
                            }
                            this.hgA.hgz.mHandler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 hgB;

                                {
                                    this.hgB = r1;
                                }

                                public final void run() {
                                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image fail!");
                                    if (this.hgB.hgA.hgz.dxy != null && this.hgB.hgA.hgz.dxy.isShowing()) {
                                        this.hgB.hgA.hgz.dxy.hide();
                                    }
                                    com.tencent.mm.ui.base.g.bf(this.hgB.hgA.hgz, this.hgB.hgA.hgz.getString(2131233675));
                                }
                            });
                        }
                    };
                    i.fvY = j.axI();
                    i.hbp = anonymousClass1;
                    i.hbq = c;
                    v.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: sendImg. imageId:%s", new Object[]{i.fvY});
                    h hVar = new h();
                    hVar.cFQ = true;
                    hVar.cFR = i;
                    hVar.field_mediaId = r2;
                    hVar.field_fullpath = c;
                    hVar.field_thumbpath = "";
                    hVar.field_fileType = b.MediaType_FILE;
                    hVar.field_talker = "";
                    hVar.field_priority = b.cEA;
                    hVar.field_needStorage = false;
                    hVar.field_isStreamMedia = false;
                    hVar.field_appType = 0;
                    hVar.field_bzScene = 0;
                    if (!com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
                        v.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. clientid:%s", new Object[]{r2});
                    }
                } else {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with not image data!");
                    this.hgz.hgx = "";
                    this.hgz.hgd = "";
                    this.hgz.hge = "";
                    this.hgz.hgf = 0;
                    LuckyMoneyNewYearSendUI.g(this.hgz);
                }
            } else if (view.getId() == 2131757874) {
                this.hgz.finish();
                g.iuh.h(13079, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
            } else if (view.getId() == 2131757877 || view.getId() == 2131757878) {
                LuckyMoneyNewYearSendUI.l(this.hgz);
                g.iuh.h(13079, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
            } else if (view.getId() == 2131757881) {
                this.hgz.hgd = "";
                this.hgz.hge = "";
                this.hgz.hgf = 0;
                LuckyMoneyNewYearSendUI.m(this.hgz);
                g.iuh.h(13079, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            } else if (view.getId() == 2131757885) {
                LuckyMoneyAutoScrollView n = this.hgz.hfS;
                n.hdQ = false;
                n.hdH.setVisibility(0);
                n.hdI.setVisibility(0);
                n.hdJ.setVisibility(0);
                n.hdK.setVisibility(4);
                n.hdL.setVisibility(4);
                n.hdM.setVisibility(4);
                this.hgz.ayt();
                g.iuh.h(13079, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
            } else if (view.getId() == 2131757880) {
                LuckyMoneyNewYearSendUI.p(this.hgz);
            }
        }
    };
    private Button fpp;
    private String hbU;
    private int hbW;
    private int hcP;
    private String hcT;
    private int hcU;
    private int hcc = 0;
    private LinkedList<k> hcd;
    private TextView hdY;
    private LuckyMoneyAutoScrollView hfS;
    private TextView hfT;
    private ImageView hfY;
    private View hfZ;
    private ImageView hga;
    private boolean hgc = false;
    private String hgd = "";
    private String hge = "";
    private int hgf;
    private j hgg;
    private View hgp;
    private View hgq;
    private ImageView hgr;
    private TextView hgs;
    private ImageView hgt;
    private LinearLayout hgu;
    private String hgv;
    private boolean hgw = true;
    private String hgx = "";
    private int hgy = 0;
    private Bitmap mBitmap;
    private ac mHandler = new ac();

    static /* synthetic */ void g(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
        g.iuh.h(11701, new Object[]{Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
        String xF = com.tencent.mm.model.k.xF();
        luckyMoneyNewYearSendUI.b(new ad(luckyMoneyNewYearSendUI.hbW, luckyMoneyNewYearSendUI.hbU, n.wa(xF), luckyMoneyNewYearSendUI.hgv, xF, com.tencent.mm.model.k.xH(), luckyMoneyNewYearSendUI.hcP, luckyMoneyNewYearSendUI.hgd, luckyMoneyNewYearSendUI.hge, luckyMoneyNewYearSendUI.hgf), false);
        luckyMoneyNewYearSendUI.ays();
    }

    static /* synthetic */ void l(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSelectPicture");
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "galleryMode %s", new Object[]{luckyMoneyNewYearSendUI.nDR.nEl.getSharedPreferences(aa.bti(), 0).getString("gallery", "1")});
        if (luckyMoneyNewYearSendUI.nDR.nEl.getSharedPreferences(aa.bti(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
            l.a(luckyMoneyNewYearSendUI, 2, null);
        } else {
            l.U(luckyMoneyNewYearSendUI);
        }
    }

    static /* synthetic */ void m(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "doDeletePic");
        luckyMoneyNewYearSendUI.hgc = false;
        luckyMoneyNewYearSendUI.hgx = "";
        luckyMoneyNewYearSendUI.hgd = "";
        luckyMoneyNewYearSendUI.hge = "";
        luckyMoneyNewYearSendUI.hgf = 0;
        luckyMoneyNewYearSendUI.av();
    }

    static /* synthetic */ void p(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearSendUI.hgx)) {
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "image path is empty!");
            return;
        }
        g.iuh.h(13079, new Object[]{Integer.valueOf(7), Integer.valueOf(1)});
        new h(luckyMoneyNewYearSendUI, com.tencent.mm.model.k.xF(), luckyMoneyNewYearSendUI.hgx).k(false, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
        this.hgv = getIntent().getStringExtra("key_username");
        this.hcP = getIntent().getIntExtra("key_way", 0);
        this.hcU = getIntent().getIntExtra("pay_channel", -1);
        if (be.kS(this.hgv)) {
            v.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        NI();
        j(new com.tencent.mm.plugin.luckymoney.c.v("v1.0"));
        g.iuh.h(13079, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
    }

    protected void onDestroy() {
        ak.yW();
        c.vf().a(t.a.nso, this.hgx);
        ak.yW();
        c.vf().a(t.a.nsp, this.hgd);
        ak.yW();
        c.vf().a(t.a.nsq, this.hge);
        ak.yW();
        c.vf().a(t.a.nsr, Integer.valueOf(this.hgf));
        super.onDestroy();
        if (this.dxy != null && this.dxy.isShowing()) {
            this.dxy.dismiss();
        }
    }

    protected final void NI() {
        oa(8);
        this.hgp = findViewById(2131757873);
        this.hfT = (TextView) findViewById(2131757884);
        this.hfS = (LuckyMoneyAutoScrollView) findViewById(2131757883);
        this.hdY = (TextView) findViewById(2131757882);
        this.fpp = (Button) findViewById(2131757886);
        this.fpp.setOnClickListener(this.eFl);
        ((ImageView) findViewById(2131757874)).setOnClickListener(this.eFl);
        this.hgq = findViewById(2131757876);
        this.hgr = (ImageView) findViewById(2131757877);
        this.hgr.setOnClickListener(this.eFl);
        this.hfY = (ImageView) findViewById(2131757875);
        this.hgs = (TextView) findViewById(2131757878);
        this.hgs.setOnClickListener(this.eFl);
        this.hfZ = findViewById(2131757879);
        this.hga = (ImageView) findViewById(2131757880);
        this.hga.setOnClickListener(this.eFl);
        this.hgt = (ImageView) findViewById(2131757881);
        this.hgt.setOnClickListener(this.eFl);
        this.hgu = (LinearLayout) findViewById(2131757885);
        this.hgu.setOnClickListener(this.eFl);
        ak.yW();
        this.hgx = (String) c.vf().get(t.a.nso, "");
        ak.yW();
        this.hgd = (String) c.vf().get(t.a.nsp, "");
        ak.yW();
        this.hge = (String) c.vf().get(t.a.nsq, "");
        ak.yW();
        this.hgf = ((Integer) c.vf().get(t.a.nsr, Integer.valueOf(0))).intValue();
        if (TextUtils.isEmpty(this.hgx) || TextUtils.isEmpty(this.hgd) || TextUtils.isEmpty(this.hge) || this.hgf <= 0) {
            v.e("MicroMsg.LuckyMoneyNewYearSendUI", "count not fetch last post image data!");
        } else {
            this.hgc = true;
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "last post image data is valid");
        }
        if (!this.hgc || TextUtils.isEmpty(this.hgx)) {
            v.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:initPictureImage() mIsShowPic:" + this.hgc + ", mImagePath:" + this.hgx);
            return;
        }
        Bitmap Y = n.Y(this.hgx, false);
        if (Y != null) {
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
            Bitmap bitmap = this.mBitmap;
            this.mBitmap = Y;
            this.hga.setImageBitmap(this.mBitmap);
            if (bitmap != null && bitmap.isRecycled()) {
                bitmap.recycle();
                return;
            }
            return;
        }
        v.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
    }

    private void av() {
        LayoutParams layoutParams;
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if (this.hgc && this.hcc == 1) {
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the picture!");
            this.hgq.setVisibility(8);
            this.hfZ.setVisibility(0);
            this.hfY.setVisibility(8);
        } else if (this.hcc == 1) {
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the camera btn!");
            this.hgq.setVisibility(0);
            this.hfZ.setVisibility(8);
            this.hfY.setVisibility(0);
        } else {
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the new year wording!");
            this.hgq.setVisibility(8);
            this.hfZ.setVisibility(8);
            this.hfY.setVisibility(0);
        }
        if (this.hcd == null || this.hcd.size() <= 0) {
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
            this.hgu.setVisibility(8);
        } else {
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
            this.hgu.setVisibility(0);
        }
        if (this.hcc == 1) {
            layoutParams = (LayoutParams) this.hfY.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493504);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131493502);
            this.hfY.setLayoutParams(layoutParams);
            this.hfY.invalidate();
        } else {
            layoutParams = (LayoutParams) this.hfY.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493503);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131493501);
            this.hfY.setLayoutParams(layoutParams);
            this.hfY.invalidate();
        }
        if (this.hgc) {
            layoutParams = (LayoutParams) this.hdY.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131493499);
            this.hdY.setLayoutParams(layoutParams);
            this.hdY.invalidate();
            this.hdY.setTextSize(1, 17.0f);
            this.hfT.setTextSize(1, 16.0f);
            this.hfS.bN(getResources().getDimensionPixelOffset(2131493510), getResources().getDimensionPixelOffset(2131493507));
            layoutParams = (LayoutParams) this.hfS.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493495);
            this.hfS.setLayoutParams(layoutParams);
            this.hfS.invalidate();
            layoutParams = (LayoutParams) this.hgu.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493497);
            this.hgu.setLayoutParams(layoutParams);
            this.hgu.invalidate();
            return;
        }
        layoutParams = (LayoutParams) this.hdY.getLayoutParams();
        layoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131493498);
        this.hdY.setLayoutParams(layoutParams);
        this.hdY.invalidate();
        this.hdY.setTextSize(1, 20.0f);
        this.hfT.setTextSize(1, 18.0f);
        this.hfS.bN(getResources().getDimensionPixelOffset(2131493509), getResources().getDimensionPixelOffset(2131493506));
        layoutParams = (LayoutParams) this.hfS.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493494);
        this.hfS.setLayoutParams(layoutParams);
        this.hfS.invalidate();
        layoutParams = (LayoutParams) this.hgu.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493496);
        this.hgu.setLayoutParams(layoutParams);
        this.hgu.invalidate();
    }

    protected final int getLayoutId() {
        return 2130903896;
    }

    private void ays() {
        if (this.dxy == null) {
            this.dxy = com.tencent.mm.wallet_core.ui.g.a(this.nDR.nEl, true, new OnCancelListener(this) {
                final /* synthetic */ LuckyMoneyNewYearSendUI hgz;

                {
                    this.hgz = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.hgz.dxy != null && this.hgz.dxy.isShowing()) {
                        this.hgz.dxy.hide();
                    }
                    if (this.hgz.nDR.dtW.getVisibility() == 8 || this.hgz.nDR.dtW.getVisibility() == 4) {
                        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
                        this.hgz.finish();
                    }
                    this.hgz.hdT.axF();
                }
            });
        } else if (!this.dxy.isShowing()) {
            this.dxy.show();
        }
    }

    private void ayt() {
        int i;
        if (this.hcd == null || this.hcd.size() <= 0) {
            v.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
            i = -1;
        } else {
            ak.yW();
            i = c.ww();
            int size = this.hcd.size();
            i = (new Random((long) i).nextInt(size) + ((int) (System.currentTimeMillis() % ((long) size)))) % size;
            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:" + i);
        }
        this.hgy = i;
        if (this.hgy >= 0 && this.hgy < this.hcd.size()) {
            this.hbW = ((k) this.hcd.get(this.hgy)).hbs;
            this.hbU = ((k) this.hcd.get(this.hgy)).hbt;
        }
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.hgy + " randomAmount:" + this.hbW + " randomWishing:" + this.hbU);
        this.hfS.wc(e.m(((double) this.hbW) / 100.0d));
        this.hfS.a(new LuckyMoneyAutoScrollView.a(this) {
            final /* synthetic */ LuckyMoneyNewYearSendUI hgz;

            {
                this.hgz = r1;
            }

            public final void aye() {
                if (this.hgz.hgw) {
                    this.hgz.hdY.setVisibility(4);
                    n.a(this.hgz.nDR.nEl, this.hgz.hdY, this.hgz.hbU);
                    Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500);
                    alphaAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass3 hgC;

                        {
                            this.hgC = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                            this.hgC.hgz.hdY.setVisibility(0);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                        }
                    });
                    this.hgz.hdY.startAnimation(alphaAnimation);
                    this.hgz.hgw = false;
                    return;
                }
                n.a(this.hgz.nDR.nEl, this.hgz.hdY, this.hgz.hbU);
                this.hgz.hdY.invalidate();
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + kVar.getType());
        if (kVar instanceof com.tencent.mm.plugin.luckymoney.c.v) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.luckymoney.c.v vVar = (com.tencent.mm.plugin.luckymoney.c.v) kVar;
                this.hbW = vVar.hbW;
                this.hbU = vVar.hbU;
                this.hcc = vVar.hcc;
                this.hcd = vVar.hcd;
                if (this.hcc == 0) {
                    v.e("MicroMsg.LuckyMoneyNewYearSendUI", "scenePicSwitch is 0, clear local picture data!");
                } else {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "cans how picture!");
                }
                ayt();
                av();
                oa(0);
                n.a(this.hgp, null);
                return true;
            }
            finish();
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.c.ac) {
            if (this.dxy != null && this.dxy.isShowing()) {
                this.dxy.hide();
            }
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                com.tencent.mm.plugin.luckymoney.c.ac acVar = (com.tencent.mm.plugin.luckymoney.c.ac) kVar;
                this.hcT = acVar.hcj;
                r1 = new PayInfo();
                r1.fTG = acVar.hci;
                r1.bkq = 37;
                r1.bkh = this.hcU;
                com.tencent.mm.pluginsdk.wallet.e.a(this, r1, 1);
                return true;
            }
            v.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        } else if (kVar instanceof ad) {
            if (this.dxy != null && this.dxy.isShowing()) {
                this.dxy.hide();
            }
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ad adVar = (ad) kVar;
                this.hcT = adVar.hcj;
                r1 = new PayInfo();
                r1.fTG = adVar.hci;
                r1.bkq = 37;
                r1.bkh = this.hcU;
                com.tencent.mm.pluginsdk.wallet.e.a(this, r1, 1);
                return true;
            }
            v.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
                    g.iuh.h(11701, new Object[]{Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2)});
                    if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                        RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                        if (realnameGuideHelper != null) {
                            boolean z2;
                            if (realnameGuideHelper.a(this, null, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ LuckyMoneyNewYearSendUI hgz;

                                {
                                    this.hgz = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.hgz.finish();
                                }
                            })) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            z = z2;
                        }
                    }
                    com.tencent.mm.ui.base.g.bf(this, getString(2131233278));
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb!");
                    n.v(this.hcT, this.hgv, 3);
                    if (!z) {
                        finish();
                        return;
                    }
                    return;
                }
                v.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
                return;
            case 2:
                if (intent == null) {
                    v.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_PIC");
                    return;
                } else if (i2 == -1) {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    CharSequence stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (!TextUtils.isEmpty(stringExtra) || (stringArrayListExtra != null && stringArrayListExtra.size() > 0)) {
                        if (TextUtils.isEmpty(stringExtra)) {
                            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePathList is valid!");
                            str = (String) stringArrayListExtra.get(0);
                        } else {
                            v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePath is valid!");
                            str = stringExtra;
                        }
                        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "REQUEST_CODE_FROM_PIC filePath %s", new Object[]{stringExtra});
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.cgq + "temp.avatar");
                        intent2.putExtra("CropImage_ImgPath", str);
                        intent2.putExtra("CropImage_Filter", false);
                        intent2.putExtra("CropImage_from_scene", 1);
                        com.tencent.mm.plugin.luckymoney.a.drp.a(this, intent2, 3);
                        return;
                    }
                    v.e("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture failed, imagePath and imagePathList is null!");
                    return;
                } else {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture cancel or failed!");
                    return;
                }
            case 3:
                if (intent == null) {
                    v.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_CROP");
                    return;
                } else if (i2 == -1) {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    str = intent.getStringExtra("CropImage_OutputPath");
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "new crop image path:" + str);
                    if (TextUtils.isEmpty(str) || !str.equals(this.hgx)) {
                        this.hgd = "";
                        this.hge = "";
                        this.hgf = 0;
                    } else {
                        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "the path is same as last image");
                    }
                    this.hgx = str;
                    Bitmap Y = n.Y(this.hgx, false);
                    if (Y != null) {
                        v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
                        Bitmap bitmap = this.mBitmap;
                        this.mBitmap = Y;
                        this.hga.setImageBitmap(this.mBitmap);
                        this.hgc = true;
                        av();
                        if (bitmap != null && bitmap.isRecycled()) {
                            bitmap.recycle();
                            return;
                        }
                        return;
                    }
                    v.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
                    return;
                } else {
                    v.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:do crop image fail for REQUEST_CODE_FROM_CROP");
                    return;
                }
            default:
                return;
        }
    }
}
