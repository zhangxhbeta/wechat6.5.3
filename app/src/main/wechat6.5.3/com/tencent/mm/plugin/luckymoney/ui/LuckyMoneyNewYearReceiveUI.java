package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.c.ab;
import com.tencent.mm.plugin.luckymoney.c.ae;
import com.tencent.mm.plugin.luckymoney.c.e;
import com.tencent.mm.plugin.luckymoney.c.j;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import java.io.File;

@a(3)
public class LuckyMoneyNewYearReceiveUI extends LuckyMoneyBaseUI {
    private p dwg = null;
    private ImageView eXC;
    private int hcc = 0;
    private TextView hdY;
    private View heE;
    private String hei;
    private LuckyMoneyAutoScrollView hfS;
    private TextView hfT;
    private TextView hfU;
    private LinearLayout hfV;
    private TextView hfW;
    private ImageView hfX;
    private ImageView hfY;
    private View hfZ;
    private ImageView hga;
    private boolean hgb = false;
    private boolean hgc = false;
    private String hgd = "";
    private String hge = "";
    private int hgf;
    private j hgg;
    private boolean hgh = false;
    private String imagePath = "";
    private ac mHandler = new ac();

    static /* synthetic */ void a(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearReceiveUI.imagePath)) {
            v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "image path is empty!");
            return;
        }
        g.iuh.h(13079, new Object[]{Integer.valueOf(7), Integer.valueOf(2)});
        new h(luckyMoneyNewYearReceiveUI, k.xF(), luckyMoneyNewYearReceiveUI.imagePath).k(true, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_native_url");
        this.hgd = getIntent().getStringExtra("key_image_id");
        this.hge = getIntent().getStringExtra("key_image_aes_key");
        this.hgf = getIntent().getIntExtra("key_image_length", 0);
        v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageId:" + this.hgd + ", imageLength:" + this.hgf);
        Uri parse = Uri.parse(be.ma(stringExtra));
        try {
            this.hei = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        NI();
        if (be.kS(this.hei)) {
            finish();
            v.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
            return;
        }
        b(new ae(be.getInt(parse.getQueryParameter("channelid"), 1), this.hei, stringExtra, 1, "v1.0"), false);
        if (this.dwg != null) {
            this.dwg.show();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.hgh) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
    }

    protected final void NI() {
        this.heE = findViewById(2131757887);
        this.hfS = (LuckyMoneyAutoScrollView) findViewById(2131757891);
        this.hfT = (TextView) findViewById(2131757884);
        this.hdY = (TextView) findViewById(2131757890);
        this.eXC = (ImageView) findViewById(2131757897);
        this.hfV = (LinearLayout) findViewById(2131757892);
        this.hfW = (TextView) findViewById(2131757894);
        this.hfX = (ImageView) findViewById(2131757893);
        this.hfU = (TextView) findViewById(2131757898);
        this.hfY = (ImageView) findViewById(2131757875);
        this.hfZ = findViewById(2131757879);
        this.hga = (ImageView) findViewById(2131757880);
        this.hga.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyNewYearReceiveUI hgi;

            {
                this.hgi = r1;
            }

            public final void onClick(View view) {
                LuckyMoneyNewYearReceiveUI.a(this.hgi);
            }
        });
        ((ImageView) findViewById(2131757888)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyNewYearReceiveUI hgi;

            {
                this.hgi = r1;
            }

            public final void onClick(View view) {
                this.hgi.finish();
                g.iuh.h(13079, new Object[]{Integer.valueOf(6), Integer.valueOf(2)});
            }
        });
        oa(8);
        this.dwg = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131233521), true, new OnCancelListener(this) {
            final /* synthetic */ LuckyMoneyNewYearReceiveUI hgi;

            {
                this.hgi = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.hgi.dwg != null && this.hgi.dwg.isShowing()) {
                    this.hgi.dwg.dismiss();
                }
                this.hgi.hdT.axF();
                if (this.hgi.nDR.dtW.getVisibility() == 8 || this.hgi.nDR.dtW.getVisibility() == 4) {
                    v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
                    this.hgi.finish();
                }
            }
        });
    }

    private void ayr() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ LuckyMoneyNewYearReceiveUI hgi;

            {
                this.hgi = r1;
            }

            public final void run() {
                if (new File(this.hgi.imagePath).exists()) {
                    final Bitmap Y = n.Y(this.hgi.imagePath, true);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 hgl;

                        public final void run() {
                            this.hgl.hgi.hga.setImageBitmap(Y);
                        }

                        public final String toString() {
                            return super.toString() + "|renderView";
                        }
                    });
                    return;
                }
                v.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + this.hgi.imagePath + " is not exist!");
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (!(kVar instanceof ae)) {
            if (kVar instanceof ab) {
                if (this.dwg != null && this.dwg.isShowing()) {
                    this.dwg.hide();
                }
                if (i == 0 && i2 == 0) {
                    final ab abVar = (ab) kVar;
                    e eVar = abVar.hbH;
                    this.hfW.setText(abVar.hbH.haw);
                    this.hfS.wc(com.tencent.mm.wallet_core.ui.e.m(((double) abVar.hbH.bst) / 100.0d));
                    this.hfS.a(new LuckyMoneyAutoScrollView.a(this) {
                        final /* synthetic */ LuckyMoneyNewYearReceiveUI hgi;

                        public final void aye() {
                            this.hgi.hdY.setVisibility(4);
                            n.a(this.hgi.nDR.nEl, this.hgi.hdY, abVar.hbH.hay);
                            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation.setDuration(500);
                            alphaAnimation.setAnimationListener(new AnimationListener(this) {
                                final /* synthetic */ AnonymousClass7 hgo;

                                {
                                    this.hgo = r1;
                                }

                                public final void onAnimationStart(Animation animation) {
                                    this.hgo.hgi.hdY.setVisibility(0);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    if (com.tencent.mm.h.j.sU().getInt("PlayCoinSound", 0) > 0) {
                                        k.cg(this.hgo.hgi);
                                    }
                                    if (abVar.hbI != null) {
                                        abVar.hbI.a(this.hgo.hgi, null, null);
                                    }
                                }
                            });
                            this.hgi.hdY.startAnimation(alphaAnimation);
                        }
                    });
                    if (eVar.hav == 4 && !TextUtils.isEmpty(abVar.hbH.haw)) {
                        this.hfX.setVisibility(8);
                    }
                    oa(0);
                    n.a(this.heE, null);
                    return true;
                } else if (i2 == 416) {
                    if (this.dwg != null && this.dwg.isShowing()) {
                        this.dwg.hide();
                    }
                    this.hgh = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    return n.a(this, i2, kVar, bundle, true, null, null, 1004);
                }
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            LayoutParams layoutParams;
            final ae aeVar = (ae) kVar;
            this.hcc = aeVar.hcc;
            if (this.hcc == 1) {
                v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image data!");
                if (TextUtils.isEmpty(this.hge)) {
                    v.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageaeskey is empty!");
                }
                if (TextUtils.isEmpty(this.hgd) || TextUtils.isEmpty(this.hge) || this.hgf <= 0) {
                    v.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage() the parameter is illegeal!");
                } else {
                    v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage()!");
                    if (this.hgg == null) {
                        this.hgg = new j();
                    }
                    this.imagePath = n.wb(this.hgd) + ".temp";
                    if (new File(this.imagePath).exists()) {
                        v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:imagePath file is exist! update image");
                        ayr();
                    } else {
                        v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + this.imagePath + " is not exist!");
                        this.hgg.a(this.hgd, this.hge, this.hgf, this.imagePath, new j.a(this) {
                            final /* synthetic */ LuckyMoneyNewYearReceiveUI hgi;

                            {
                                this.hgi = r1;
                            }

                            public final void a(final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, final boolean z) {
                                this.hgi.mHandler.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 hgk;

                                    public final void run() {
                                        if (z) {
                                            v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "the download image data is success!");
                                            if (!TextUtils.isEmpty(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId) && com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId.equals(this.hgk.hgi.hgd)) {
                                                this.hgk.hgi.ayr();
                                                return;
                                            }
                                            return;
                                        }
                                        v.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image fail!");
                                        com.tencent.mm.ui.base.g.bf(this.hgk.hgi, this.hgk.hgi.getString(2131233609));
                                    }
                                });
                            }
                        });
                    }
                }
            } else {
                v.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "not to download image data!");
            }
            if (aeVar.axP()) {
                this.hgb = true;
                v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
                b.o(this.eXC, k.xF());
                findViewById(2131757896).setVisibility(8);
                findViewById(2131757875).setVisibility(0);
            } else {
                v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
                if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
                    b.o(this.eXC, getIntent().getStringExtra("key_username"));
                } else if (!TextUtils.isEmpty(aeVar.haA)) {
                    n.h(this.eXC, aeVar.haA);
                }
                n.a(this.nDR.nEl, this.hfU, aeVar.hcq);
                this.hgb = false;
            }
            if (aeVar.axP() || aeVar.haN != 0 || aeVar.hav == 4 || aeVar.hav == 5 || aeVar.hav == 1) {
                if (this.dwg != null && this.dwg.isShowing()) {
                    this.dwg.hide();
                }
                if (aeVar.hav != 5) {
                    this.hfS.wc(com.tencent.mm.wallet_core.ui.e.m(((double) aeVar.hcr) / 100.0d));
                    LuckyMoneyAutoScrollView luckyMoneyAutoScrollView = this.hfS;
                    luckyMoneyAutoScrollView.hdH.setVisibility(8);
                    luckyMoneyAutoScrollView.hdI.setVisibility(8);
                    luckyMoneyAutoScrollView.hdJ.setVisibility(8);
                    luckyMoneyAutoScrollView.hdK.setVisibility(0);
                    luckyMoneyAutoScrollView.hdL.setVisibility(0);
                    luckyMoneyAutoScrollView.hdM.setVisibility(0);
                    n.a(this.nDR.nEl, this.hdY, aeVar.hay);
                    this.hfW.setText(aeVar.haw);
                    if (aeVar.hav == 4 && !TextUtils.isEmpty(aeVar.haw)) {
                        this.hfX.setVisibility(8);
                    }
                } else {
                    findViewById(2131757889).setVisibility(8);
                    ((TextView) findViewById(2131757895)).setText(aeVar.haw);
                    ((TextView) findViewById(2131757895)).setVisibility(0);
                }
                oa(0);
                n.a(this.heE, null);
            } else if ("0".equals(aeVar.hbN)) {
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((MMActivity) this, this.hdT, aeVar.hbO, aeVar.hbP, aeVar.hbQ, aeVar.hbR, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                    final /* synthetic */ LuckyMoneyNewYearReceiveUI hgi;

                    public final boolean a(int i, int i2, String str, boolean z) {
                        v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                        if (i == 1) {
                            this.hgi.finish();
                        } else if (i == 2) {
                            this.hgi.b(aeVar.msgType, aeVar.aPW, aeVar.haB, aeVar.cCj);
                        } else if (i == 0 && z) {
                            this.hgi.b(aeVar.msgType, aeVar.aPW, aeVar.haB, aeVar.cCj);
                        }
                        return true;
                    }
                }, true, 1005);
            } else {
                b(aeVar.msgType, aeVar.aPW, aeVar.haB, aeVar.cCj);
            }
            v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "scenePicSwitch:" + this.hcc + ", imageId:" + this.hgd + ", imageLength:" + this.hgf);
            if (this.hcc != 1 || TextUtils.isEmpty(this.hgd) || TextUtils.isEmpty(this.hge) || this.hgf <= 0) {
                this.hgc = false;
                v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "don't show the picture!");
            } else {
                this.hgc = true;
                v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "show the picture!");
            }
            boolean z = (aeVar.hav == 5 || aeVar.hav == 1) ? false : true;
            v.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + aeVar.hav + ", isValidStatus is " + z);
            if (this.hgc && z) {
                this.hfZ.setVisibility(0);
                this.hfY.setVisibility(8);
            } else {
                this.hfZ.setVisibility(8);
                this.hfY.setVisibility(0);
            }
            if (this.hgc && z) {
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
            } else {
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
            }
            if (this.hgb) {
                layoutParams = (LayoutParams) this.hfV.getLayoutParams();
                if (this.hgc) {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493512);
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493513);
                }
                this.hfV.setLayoutParams(layoutParams);
                this.hfV.invalidate();
                this.hfW.setTextSize(1, 18.0f);
                return true;
            }
            layoutParams = (LayoutParams) this.hfV.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493511);
            this.hfV.setLayoutParams(layoutParams);
            this.hfV.invalidate();
            this.hfW.setTextSize(1, 12.0f);
            return true;
        } else {
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.hide();
            }
            return false;
        }
    }

    private void b(int i, int i2, String str, String str2) {
        b(new ab(i, i2, str, str2, n.axJ(), k.xH(), getIntent().getStringExtra("key_username"), "v1.0"), false);
    }

    protected final int getLayoutId() {
        return 2130903897;
    }
}
