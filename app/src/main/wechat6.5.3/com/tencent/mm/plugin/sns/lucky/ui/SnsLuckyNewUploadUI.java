package com.tencent.mm.plugin.sns.lucky.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.nh;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.e.au.1;
import com.tencent.mm.plugin.sns.g.g;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.plugin.sns.lucky.b.b;
import com.tencent.mm.plugin.sns.lucky.b.o;
import com.tencent.mm.plugin.sns.lucky.b.t;
import com.tencent.mm.plugin.sns.lucky.view.LuckyNewPreview;
import com.tencent.mm.plugin.sns.lucky.view.LuckySnsUploadSayFooter;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnsLuckyNewUploadUI extends MMActivity {
    private ac cnC = new ac(Looper.getMainLooper());
    private View fhF;
    private Point jgb = null;
    private ImageView jhA;
    private View jhB;
    private View jhC;
    private TextView jhD;
    private View jhE;
    private TextView jhF;
    private LuckyNewPreview jhG;
    private SnsEditText jhH;
    private LuckySnsUploadSayFooter jhI;
    private String jhJ;
    private boolean jhK;
    private au jhL;
    private String jhM = "";
    private String jhN = "";
    private int jhO = 0;
    private int jhP = 0;
    private ArrayList<String> jhQ;
    private boolean jhR = false;
    private int jhS = 0;
    private boolean jhT = false;
    private OnClickListener jhU = new OnClickListener(this) {
        final /* synthetic */ SnsLuckyNewUploadUI jhX;

        {
            this.jhX = r1;
        }

        public final void onClick(View view) {
            SnsLuckyNewUploadUI.b(this.jhX);
        }
    };
    private float jhV;
    private float jhW;
    private View jhs;
    private TextView jht;
    private TextView jhu;
    private View jhv;
    private ImageView jhw;
    private View jhx;
    private ImageView jhy;
    private TextView jhz;

    static /* synthetic */ void a(SnsLuckyNewUploadUI snsLuckyNewUploadUI, String str, boolean z, List list) {
        if (snsLuckyNewUploadUI.jhL == null) {
            snsLuckyNewUploadUI.jhL = new au(21);
        }
        boolean z2 = snsLuckyNewUploadUI.jhL.jol;
        if (z2) {
            v.i("MicroMsg.SnsLuckyUploadUI", "isAsyncDone");
        } else {
            v.i("MicroMsg.SnsLuckyUploadUI", "isAsync Not Done");
            snsLuckyNewUploadUI.jhL = new au(21);
        }
        if (z) {
            snsLuckyNewUploadUI.jhL.qp(1);
        } else {
            snsLuckyNewUploadUI.jhL.qp(0);
        }
        if (!be.kS(str)) {
            snsLuckyNewUploadUI.jhL.AG(str);
            snsLuckyNewUploadUI.jhL.AL(str);
        }
        v.i("MicroMsg.SnsLuckyUploadUI", "mediaPath " + snsLuckyNewUploadUI.jhJ);
        if (!(z2 || be.kS(snsLuckyNewUploadUI.jhJ))) {
            snsLuckyNewUploadUI.jhL.cF(snsLuckyNewUploadUI.jhJ, "");
        }
        snsLuckyNewUploadUI.jhL.bo(list);
        snsLuckyNewUploadUI.jhL.commit();
        if (!(snsLuckyNewUploadUI.jhS == 1 || list == null)) {
            list.size();
        }
        o aRh = o.aRh();
        i f = t.f(a.nsa);
        if (f.jqD == null || be.kS(f.jqD.jqA)) {
            f.jqD = new g();
            f.jqD.jqA = aRh.jeU;
            f.jqD.jqB = 0;
        }
        if (be.kS(f.jqD.jqA) || !f.jqD.jqA.equals(aRh.jeU)) {
            f.jqD = new g();
            f.jqD.jqA = aRh.jeU;
            f.jqD.jqB = 1;
        } else {
            g gVar = f.jqD;
            gVar.jqB++;
        }
        v.i("MicroMsg.NewYearSnsCtrlV2", "updatePostCount " + f.jqD.jqB + " postId: " + aRh.jeU);
        try {
            ak.yW();
            c.vf().a(a.nsa, new String(f.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            v.w("MicroMsg.NewYearSnsCtrlV2", "updatePostCount save exception:" + e.getLocalizedMessage());
        }
        com.tencent.mm.sdk.c.a.nhr.z(new nh());
        b.kZ(6);
        System.currentTimeMillis();
        snsLuckyNewUploadUI.setResult(-1);
        snsLuckyNewUploadUI.finish();
    }

    static /* synthetic */ void b(SnsLuckyNewUploadUI snsLuckyNewUploadUI) {
        try {
            b.kZ(2);
            v.i("MicroMsg.SnsLuckyUploadUI", "galleryMode %s", new Object[]{snsLuckyNewUploadUI.nDR.nEl.getSharedPreferences(aa.bti(), 0).getString("gallery", "1")});
            if (snsLuckyNewUploadUI.nDR.nEl.getSharedPreferences(aa.bti(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
                l.a(snsLuckyNewUploadUI, 1, null);
            } else {
                l.a(snsLuckyNewUploadUI, 1, 1, 4, null);
            }
            System.currentTimeMillis();
        } catch (Exception e) {
            v.e("MicroMsg.SnsLuckyUploadUI", "selectPic error: %s", new Object[]{e.getMessage()});
        }
    }

    static /* synthetic */ Animator g(SnsLuckyNewUploadUI snsLuckyNewUploadUI) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhw, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhs, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jht, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhC, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
        new AnimatorSet().playTogether(new Animator[]{duration, duration2, duration3, duration4});
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(snsLuckyNewUploadUI, 50);
        int fromDPToPix2 = com.tencent.mm.bd.a.fromDPToPix(snsLuckyNewUploadUI, 250);
        int fromDPToPix3 = snsLuckyNewUploadUI.azJ().y - com.tencent.mm.bd.a.fromDPToPix(snsLuckyNewUploadUI, 40);
        Animator duration5 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhF, "translationY", new float[]{(float) fromDPToPix2, 0.0f}).setDuration(200);
        duration5.addListener(new AnimatorListenerAdapter(snsLuckyNewUploadUI) {
            final /* synthetic */ SnsLuckyNewUploadUI jhX;

            {
                this.jhX = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.jhX.jhF.setVisibility(0);
            }
        });
        ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhH, "translationY", new float[]{(float) fromDPToPix3, 0.0f}).setDuration(200).addListener(new AnimatorListenerAdapter(snsLuckyNewUploadUI) {
            final /* synthetic */ SnsLuckyNewUploadUI jhX;

            {
                this.jhX = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.jhX.jhH.setVisibility(0);
            }
        });
        ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhI, "translationY", new float[]{(float) fromDPToPix, 0.0f}).setDuration(200).addListener(new AnimatorListenerAdapter(snsLuckyNewUploadUI) {
            final /* synthetic */ SnsLuckyNewUploadUI jhX;

            {
                this.jhX = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.jhX.jhI.setVisibility(0);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(new Animator[]{duration3, duration});
        fromDPToPix = (-snsLuckyNewUploadUI.jhv.getTop()) - com.tencent.mm.bd.a.fromDPToPix(snsLuckyNewUploadUI, 20);
        duration3 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhA, "translationY", new float[]{0.0f, (float) fromDPToPix}).setDuration(200);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhA, "scaleX", new float[]{1.0f, snsLuckyNewUploadUI.jhV}).setDuration(200);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhA, "scaleY", new float[]{1.0f, snsLuckyNewUploadUI.jhW}).setDuration(200);
        duration = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhB, "translationY", new float[]{0.0f, (float) fromDPToPix}).setDuration(200);
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhB, "scaleX", new float[]{1.0f, snsLuckyNewUploadUI.jhV}).setDuration(200);
        ObjectAnimator duration9 = ObjectAnimator.ofFloat(snsLuckyNewUploadUI.jhB, "scaleY", new float[]{1.0f, snsLuckyNewUploadUI.jhW}).setDuration(200);
        Animator animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{duration3, duration, duration8, duration9, duration6, duration7});
        animatorSet2.addListener(new AnimatorListenerAdapter(snsLuckyNewUploadUI) {
            final /* synthetic */ SnsLuckyNewUploadUI jhX;

            {
                this.jhX = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                this.jhX.jhA.setVisibility(8);
                this.jhX.jhB.setVisibility(8);
                this.jhX.jhG.setVisibility(0);
                LuckyNewPreview q = this.jhX.jhG;
                if (q.bitmap != null) {
                    e.a(new Runnable(q) {
                        final /* synthetic */ LuckyNewPreview jih;

                        {
                            this.jih = r1;
                        }

                        public final void run() {
                            long currentTimeMillis = System.currentTimeMillis();
                            this.jih.bitmap = d.c(this.jih.bitmap, 23);
                            new Canvas(this.jih.bitmap).drawColor(Color.argb(51, 255, 255, 255));
                            v.i("MicroMsg.LuckyNewPreview", "blurBitmap " + (System.currentTimeMillis() - currentTimeMillis));
                            this.jih.cnC.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 jii;

                                {
                                    this.jii = r1;
                                }

                                public final void run() {
                                    this.jii.jih.jig.setImageBitmap(this.jii.jih.bitmap);
                                }
                            });
                        }
                    }, "setImageBitmap");
                }
            }
        });
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(duration5).with(animatorSet2);
        animatorSet3.setInterpolator(new AccelerateDecelerateInterpolator());
        duration5 = new AnimatorSet();
        duration5.playTogether(new Animator[]{r4, animatorSet3, animatorSet});
        return duration5;
    }

    static /* synthetic */ void h(SnsLuckyNewUploadUI snsLuckyNewUploadUI) {
        snsLuckyNewUploadUI.jhs.setVisibility(8);
        snsLuckyNewUploadUI.jht.setVisibility(8);
        snsLuckyNewUploadUI.jhw.setVisibility(8);
    }

    static /* synthetic */ void j(SnsLuckyNewUploadUI snsLuckyNewUploadUI) {
        LuckySnsUploadSayFooter luckySnsUploadSayFooter = snsLuckyNewUploadUI.jhI;
        SnsEditText snsEditText = snsLuckyNewUploadUI.jhH;
        luckySnsUploadSayFooter.jij = snsEditText;
        snsEditText.setOnClickListener(new OnClickListener(luckySnsUploadSayFooter) {
            final /* synthetic */ LuckySnsUploadSayFooter jil;

            {
                this.jil = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                if (this.jil.getVisibility() == 8) {
                    this.jil.setVisibility(0);
                }
                if (this.jil.hhM.getVisibility() == 0) {
                    i = 1;
                }
                if (i != 0) {
                    this.jil.SR();
                }
            }
        });
        snsEditText.setOnEditorActionListener(new OnEditorActionListener(luckySnsUploadSayFooter) {
            final /* synthetic */ LuckySnsUploadSayFooter jil;

            {
                this.jil = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        ad.g(new Runnable(luckySnsUploadSayFooter) {
            final /* synthetic */ LuckySnsUploadSayFooter jil;

            {
                this.jil = r1;
            }

            public final void run() {
                this.jil.jij.performClick();
                this.jil.jij.requestFocus();
                this.jil.aWn.aJs();
            }
        }, 200);
    }

    protected final int getLayoutId() {
        return 2130903907;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.SnsLuckyUploadUI", "onCreate snsluckyuploadui");
        Fd("");
        NI();
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLuckyNewUploadUI jhX;

            {
                this.jhX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jhX.aRF();
                return false;
            }
        }, 2131165937);
        bzU();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(2131690048));
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING");
        sendBroadcast(intent);
    }

    private void aRF() {
        if (this.jhT) {
            com.tencent.mm.ui.base.g.a(this, 2131235573, 0, 2131230903, 2131231010, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SnsLuckyNewUploadUI jhX;

                {
                    this.jhX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.jhX.setResult(0, new Intent());
                    this.jhX.finish();
                }
            }, null, 2131689512);
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        aRF();
    }

    protected final void NI() {
        super.NI();
        cU().cV().setBackgroundDrawable(getResources().getDrawable(2131690032));
        this.jhL = new au(21);
        this.fhF = findViewById(2131757947);
        this.jhs = findViewById(2131757948);
        this.jhu = (TextView) findViewById(2131757749);
        this.jht = (TextView) findViewById(2131757949);
        this.jhv = findViewById(2131757950);
        this.jhA = (ImageView) findViewById(2131757956);
        this.jhw = (ImageView) findViewById(2131757951);
        this.jhx = findViewById(2131757952);
        this.jhy = (ImageView) findViewById(2131757954);
        this.jhz = (TextView) findViewById(2131757955);
        this.jhC = findViewById(2131757957);
        this.jhD = (TextView) findViewById(2131757958);
        this.jhB = findViewById(2131757953);
        this.jhx.setOnClickListener(this.jhU);
        o aRh = o.aRh();
        if (be.kS(aRh.jeA)) {
            this.jhC.setVisibility(8);
            v.i("MicroMsg.SnsLuckyUploadUI", "PostTips is null");
        } else {
            this.jhD.setText(be.ah(aRh.jeA, ""));
            b.kZ(58);
            this.jhK = true;
        }
        String str = null;
        if (u.bsV()) {
            str = "font_1.otf";
        } else if (u.bsW()) {
            str = "font_2.otf";
        }
        if (!be.kS(str)) {
            this.jhu.setTypeface(Typeface.createFromAsset(getAssets(), str));
        }
        this.jhE = findViewById(2131757960);
        this.jhG = (LuckyNewPreview) findViewById(2131757961);
        this.jhH = (SnsEditText) findViewById(2131757963);
        this.jhI = (LuckySnsUploadSayFooter) findViewById(2131757964);
        this.jhF = (TextView) findViewById(2131757962);
        this.jhG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyNewUploadUI jhX;

            {
                this.jhX = r1;
            }

            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                arrayList.add(this.jhX.jhJ);
                Intent intent = new Intent();
                intent.setClass(this.jhX, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", 0);
                intent.putExtra("sns_gallery_temp_paths", arrayList);
                b.kZ(4);
                System.currentTimeMillis();
                this.jhX.startActivityForResult(intent, 7);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        LuckySnsUploadSayFooter luckySnsUploadSayFooter = this.jhI;
        if (luckySnsUploadSayFooter.hhM != null) {
            luckySnsUploadSayFooter.hhM.ahl();
            luckySnsUploadSayFooter.hhM.destroy();
        }
        com.tencent.mm.plugin.sns.e.ad.aSA().aTe();
    }

    protected void onPause() {
        super.onPause();
        axg();
    }

    public final void aRG() {
        if (this.jhI.getVisibility() == 0) {
            v.d("MicroMsg.SnsLuckyUploadUI", "onKeyboardStateChanged: %s", new Object[]{Integer.valueOf(this.nDR.nEB)});
            if (this.nDR.nEB == 1) {
                this.jhI.SR();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList stringArrayListExtra;
        int height;
        int i3;
        v.i("MicroMsg.SnsLuckyUploadUI", "onActivityResult requestCode %d resultCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            if (intent != null) {
                stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra.size() > 0) {
                    v.d("MicroMsg.SnsLuckyUploadUI", "REQUEST_CODE_FROM_PIC filePath %s", new Object[]{(String) stringArrayListExtra.get(0)});
                    b.kZ(3);
                    System.currentTimeMillis();
                    this.jhJ = r0;
                    v.i("MicroMsg.SnsLuckyUploadUI", "startCrop ");
                    this.jhL = new au(21);
                    new 1(this.jhL, this.jhJ, "").l(new String[]{""});
                    if (!be.kS(this.jhJ)) {
                        this.jhy.setVisibility(8);
                        this.jhz.setVisibility(8);
                        height = cU().cV().getHeight();
                        if (height == 0) {
                            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                            height = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(2131493014) : getResources().getDimensionPixelSize(2131493015);
                        }
                        Point point = new Point();
                        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this, 54);
                        i3 = azJ().y - height;
                        if (this instanceof Activity) {
                            Rect rect = new Rect();
                            ((Activity) this).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            height = ((Activity) this).getWindow().getDecorView().getHeight();
                            height = height - rect.height() >= 0 ? height - rect.height() : rect.top;
                        } else {
                            height = com.tencent.mm.bd.a.fromDPToPix(this, 20);
                        }
                        int aA = (i3 - height) - j.aA(this);
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.jhF.getLayoutParams();
                        int lineHeight = (((this.jhF.getLineHeight() + this.jhF.getPaddingTop()) + this.jhF.getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin;
                        int fromDPToPix2 = com.tencent.mm.bd.a.fromDPToPix(this, 40);
                        height = 0;
                        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                            height = com.tencent.mm.bd.a.fromDPToPix(this, 40);
                        }
                        i3 = (((aA - fromDPToPix) - lineHeight) - fromDPToPix2) - height;
                        v.d("MicroMsg.SnsLuckyUploadUI", "result: %s, minEditShowHeight: %s, remainHeight: %s, sayFooterHeight: %s, picDescTotalHeight: %s, 100dp: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(fromDPToPix), Integer.valueOf(aA), Integer.valueOf(fromDPToPix2), Integer.valueOf(lineHeight), Integer.valueOf(com.tencent.mm.bd.a.fromDPToPix(this, 100))});
                        if (i3 < com.tencent.mm.bd.a.fromDPToPix(this, 100)) {
                            height = (((aA - ((int) ((this.jhH.getTextSize() * 2.0f) + ((float) this.jhH.getPaddingTop())))) - lineHeight) - fromDPToPix2) - height;
                            v.d("MicroMsg.SnsLuckyUploadUI", "result is less than %sdp, re-calculated result: %s, minEditShowHeight: %s", new Object[]{Integer.valueOf(100), Integer.valueOf(height), Integer.valueOf((int) ((this.jhH.getTextSize() * 2.0f) + ((float) this.jhH.getPaddingTop())))});
                        } else {
                            height = i3;
                        }
                        if (height > com.tencent.mm.bd.a.fromDPToPix(this, 140)) {
                            height = com.tencent.mm.bd.a.fromDPToPix(this, 140);
                            v.d("MicroMsg.SnsLuckyUploadUI", "result is bigger than %sdp, trim it", new Object[]{Integer.valueOf(140)});
                        }
                        point.x = (height * 4) / 3;
                        point.y = height;
                        v.d("MicroMsg.SnsLuckyUploadUI", "button size, width: %d, height: %d, previewImgSize: %s", new Object[]{Integer.valueOf(this.jhx.getWidth()), Integer.valueOf(this.jhx.getHeight()), point});
                        i3 = Math.max(height, point.x);
                        height = Math.max(fromDPToPix, point.y);
                        while (true) {
                            if (i3 <= 200 && height <= 200) {
                                break;
                            }
                            i3 /= 2;
                            height /= 2;
                        }
                        Bitmap b = d.b(this.jhJ, height, i3, true);
                        i3 = 0;
                        Exif exif = new Exif();
                        try {
                            v.e("MicroMsg.SnsLuckyUploadUI", "parseFromFile ret = " + exif.parseFromFile(this.jhJ));
                            i3 = exif.getOrientationInDegree();
                        } catch (IOException e) {
                            v.e("MicroMsg.SnsLuckyUploadUI", "Can't read EXIF from " + this.jhJ);
                        }
                        if (i3 > 0) {
                            b = d.b(b, (float) i3);
                        }
                        this.jhA.setImageBitmap(b);
                        this.jhA.setVisibility(0);
                        LuckyNewPreview luckyNewPreview = this.jhG;
                        fromDPToPix = point.x;
                        aA = point.y;
                        LayoutParams layoutParams = luckyNewPreview.getLayoutParams();
                        layoutParams.width = fromDPToPix;
                        layoutParams.height = aA;
                        luckyNewPreview.setLayoutParams(layoutParams);
                        luckyNewPreview.width = fromDPToPix;
                        luckyNewPreview.height = aA;
                        this.jhG.setImageBitmap(b);
                        this.jhV = ((float) point.x) / ((float) this.jhx.getWidth());
                        this.jhW = ((float) point.y) / ((float) this.jhx.getHeight());
                        v.d("MicroMsg.SnsLuckyUploadUI", "previewScaleX: %s, previewScaleY: %s", new Object[]{Float.valueOf(this.jhV), Float.valueOf(this.jhW)});
                        this.cnC.postDelayed(new Runnable(this) {
                            final /* synthetic */ SnsLuckyNewUploadUI jhX;

                            {
                                this.jhX = r1;
                            }

                            public final void run() {
                                Animator g = SnsLuckyNewUploadUI.g(this.jhX);
                                g.addListener(new AnimatorListenerAdapter(this) {
                                    final /* synthetic */ AnonymousClass7 jhZ;

                                    {
                                        this.jhZ = r1;
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        SnsLuckyNewUploadUI.h(this.jhZ.jhX);
                                        this.jhZ.jhX.a(0, this.jhZ.jhX.getString(2131231149), new OnMenuItemClickListener(this.jhZ.jhX) {
                                            final /* synthetic */ SnsLuckyNewUploadUI jhX;

                                            {
                                                this.jhX = r1;
                                            }

                                            public final boolean onMenuItemClick(MenuItem menuItem) {
                                                if (!this.jhX.isFinishing()) {
                                                    f.oR(22);
                                                    com.tencent.mm.ui.tools.a.c yn = com.tencent.mm.ui.tools.a.c.b(this.jhX.jhH).yn(com.tencent.mm.h.b.sE());
                                                    yn.oWy = true;
                                                    yn.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                                                        final /* synthetic */ AnonymousClass6 jhY;

                                                        {
                                                            this.jhY = r1;
                                                        }

                                                        public final void qK(String str) {
                                                            SnsLuckyNewUploadUI.a(this.jhY.jhX, this.jhY.jhX.jhH.getText().toString(), this.jhY.jhX.jhR, this.jhY.jhX.jhQ);
                                                        }

                                                        public final void adq() {
                                                        }

                                                        public final void adr() {
                                                            com.tencent.mm.ui.base.g.f(this.jhY.jhX, 2131235575, 2131235576);
                                                        }
                                                    });
                                                }
                                                return false;
                                            }
                                        }, k.b.nEZ);
                                        SnsLuckyNewUploadUI.j(this.jhZ.jhX);
                                        this.jhZ.jhX.jhx.setOnClickListener(null);
                                        this.jhZ.jhX.jhT = true;
                                    }
                                });
                                g.start();
                            }
                        }, 600);
                    }
                }
            } else {
                return;
            }
        }
        if (i == 5) {
            if (intent != null) {
                fromDPToPix = intent.getIntExtra("Ktag_range_index", 0);
                if (fromDPToPix >= 2) {
                    this.jhM = intent.getStringExtra("Klabel_name_list");
                    this.jhN = intent.getStringExtra("Kother_user_name_list");
                    List list;
                    if (be.kS(this.jhM)) {
                        list = null;
                    } else {
                        list = Arrays.asList(this.jhM.split(","));
                    }
                    List list2;
                    if (be.kS(this.jhN)) {
                        list2 = null;
                    } else {
                        list2 = Arrays.asList(this.jhN.split(","));
                    }
                    this.jhQ = new ArrayList();
                    if (r1 != null && r1.size() > 0) {
                        for (String vv : r1) {
                            List<String> vy = com.tencent.mm.pluginsdk.j.a.bmu().vy(com.tencent.mm.pluginsdk.j.a.bmu().vv(vv));
                            if (vy == null || vy.size() == 0) {
                                v.e("MicroMsg.SnsLuckyUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                                break;
                            }
                            for (String vv2 : vy) {
                                if (!this.jhQ.contains(vv2)) {
                                    this.jhQ.add(vv2);
                                    v.d("MicroMsg.SnsLuckyUploadUI", "dz:name : %s", new Object[]{vv2});
                                }
                            }
                        }
                    }
                    if (r1 != null) {
                        i3 = 0;
                        for (String vv22 : r1) {
                            if (be.kS(vv22)) {
                                height = i3;
                            } else {
                                height = i3 + 1;
                            }
                            i3 = height;
                        }
                        this.jhO = i3;
                    }
                    this.jhP = 0;
                    if (r2 != null && r2.size() > 0) {
                        for (String vv222 : r2) {
                            if (!this.jhQ.contains(vv222)) {
                                this.jhQ.add(vv222);
                                this.jhP++;
                            }
                        }
                    }
                    if (fromDPToPix == 2) {
                        this.jhR = false;
                    } else {
                        this.jhR = true;
                    }
                }
                if (1 == fromDPToPix) {
                    this.jhS = 1;
                } else {
                    this.jhS = 0;
                }
            } else {
                return;
            }
        }
        if (i == 7) {
            stringArrayListExtra = intent.getStringArrayListExtra("sns_gallery_temp_paths");
            i3 = intent.getIntExtra("sns_update_preview_image_count", 0);
            v.d("MicroMsg.SnsLuckyUploadUI", "paths.size: %s, count: %d", new Object[]{stringArrayListExtra, Integer.valueOf(i3)});
            if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                System.currentTimeMillis();
                b.kZ(5);
                axg();
                this.jhJ = null;
                this.jhs.setAlpha(1.0f);
                this.jhs.setVisibility(0);
                this.jht.setAlpha(1.0f);
                this.jht.setVisibility(0);
                this.jhw.setAlpha(1.0f);
                this.jhw.setVisibility(0);
                this.jhB.setAlpha(1.0f);
                this.jhB.setTranslationY(1.0f);
                this.jhB.setScaleX(1.0f);
                this.jhB.setScaleY(1.0f);
                this.jhB.setVisibility(0);
                this.jhA.setAlpha(1.0f);
                this.jhA.setTranslationY(1.0f);
                this.jhA.setScaleX(1.0f);
                this.jhA.setScaleY(1.0f);
                this.jhA.setVisibility(8);
                this.jhA.setImageBitmap(null);
                this.jhy.setVisibility(0);
                this.jhz.setVisibility(0);
                this.jhC.setAlpha(1.0f);
                if (this.jhK) {
                    this.jhC.setVisibility(0);
                } else {
                    this.jhC.setVisibility(8);
                }
                this.jhG.setVisibility(4);
                this.jhG.setImageBitmap(null);
                this.jhF.setTranslationY(1.0f);
                this.jhF.setVisibility(4);
                this.jhH.setTranslationY(1.0f);
                this.jhH.setVisibility(8);
                this.jhI.setTranslationY(1.0f);
                this.jhI.setVisibility(8);
                this.jhx.setOnClickListener(this.jhU);
                this.nDR.bAi();
            }
        }
        LuckySnsUploadSayFooter luckySnsUploadSayFooter = this.jhI;
        if (intent != null && i == 5) {
            luckySnsUploadSayFooter.jik.a(i, i2, intent, null);
        }
    }

    private Point azJ() {
        if (this.jgb == null) {
            this.jgb = new Point();
            getWindowManager().getDefaultDisplay().getSize(this.jgb);
        }
        return this.jgb;
    }

    protected final int NO() {
        return 1;
    }
}
