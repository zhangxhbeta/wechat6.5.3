package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.b.f;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.mp;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.e.a.oi;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public class SnsAdNativeLandingPagesUI extends MMActivity implements ak, e {
    private int bbT;
    String boC;
    private int eIZ = 0;
    private int eJa = 0;
    private int eJb = 0;
    private int eJc = 0;
    private ImageView evI;
    String fwh;
    String fwi;
    private SnsAdNativeLandingPagesScrollView jKA;
    private LinkedList<View> jKB = new LinkedList();
    private Map<Integer, h> jKC = new HashMap();
    private SparseArray<View> jKD = new SparseArray();
    private ImageView jKE;
    private ImageView jKF;
    private int jKG = 0;
    private boolean jKH = false;
    private boolean jKI = false;
    private ImageView jKJ;
    Bundle jKK;
    a jKL;
    private boolean jKM = false;
    private String jKN;
    private String jKO;
    private boolean jKP = false;
    private ImageView jKQ;
    String jKR;
    String jKS;
    boolean jKT = false;
    private boolean jKU = false;
    g jKV = new g();
    boolean jKW = false;
    private String jKX;
    private int jKY;
    private String jKZ;
    private int jKy;
    public LinkedList<c> jKz = new LinkedList();
    private String jLa;
    private String jLb;
    private LinearLayout jLc;
    private t jLd;
    private int jLe;
    private int jLf = -1;
    private int jLg = -1;
    private ac jLh = new ac();
    private String jpt;
    private String jup;
    private LinkedList<j> jvE = new LinkedList();
    private long jxX = 0;
    private int jyI = BaseReportManager.MAX_READ_COUNT;
    private int jyJ = 700;
    private int jyK = 250;
    private final Map<String, Bitmap> jyz = new WeakHashMap();
    private b jzK = new b(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

        {
            this.jLi = r1;
        }

        public final void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a aVar, boolean z) {
            if (this.jLi.jvE != null) {
                j jVar;
                int i;
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a aVar2;
                v.i("MicroMsg.SnsAdNativeLandingPagesUI", "oreh onAutoPlay index :%d, fause:%b, isNativeAdMode:%b", new Object[]{Integer.valueOf(aVar.getIndex()), Boolean.valueOf(z), Boolean.valueOf(aVar.aTJ())});
                int indexOf = this.jLi.jvE.indexOf(aVar);
                if (!(z || indexOf == 0)) {
                    jVar = (j) this.jLi.jvE.get(0);
                    if ((jVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a) && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a) jVar).aTI()) {
                        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "oreh [self]setSilence index :%d, because frist", new Object[]{Integer.valueOf(aVar.getIndex())});
                        aVar.gk(true);
                        return;
                    }
                }
                for (i = 0; i < indexOf; i++) {
                    jVar = (j) this.jLi.jvE.get(i);
                    if (jVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a) {
                        aVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a) jVar;
                        if (aVar2.aTI()) {
                            v.i("MicroMsg.SnsAdNativeLandingPagesUI", "oreh setSilence index :%d,  by:%d", new Object[]{Integer.valueOf(aVar2.getIndex()), Integer.valueOf(indexOf)});
                            aVar2.gk(false);
                        }
                    }
                }
                for (i = indexOf + 1; i < this.jLi.jvE.size(); i++) {
                    jVar = (j) this.jLi.jvE.get(i);
                    if (jVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a) {
                        aVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a) jVar;
                        if (aVar2.aTI()) {
                            v.i("MicroMsg.SnsAdNativeLandingPagesUI", "oreh setSilence index :%d  by:%d", new Object[]{Integer.valueOf(aVar2.getIndex()), Integer.valueOf(indexOf)});
                            aVar2.gk(false);
                            return;
                        }
                    }
                }
            }
        }
    };
    private long startTime;

    private static class a {
        public LinearLayout dVp;
        public ImageView jLH;
        public ImageView jLI;
        public boolean jLJ;
        public int jLK;

        private a() {
            this.jLH = null;
            this.dVp = null;
            this.jLI = null;
            this.jLJ = false;
            this.jLK = 0;
        }
    }

    static /* synthetic */ void a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, String str, ImageView imageView) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (Float.compare(snsAdNativeLandingPagesUI.jLd.width, 0.0f) > 0) {
            layoutParams.width = (int) snsAdNativeLandingPagesUI.jLd.width;
        } else {
            layoutParams.width = -1;
        }
        if (Float.compare(snsAdNativeLandingPagesUI.jLd.height, 0.0f) > 0) {
            layoutParams.height = (int) snsAdNativeLandingPagesUI.jLd.height;
        } else {
            layoutParams.height = -2;
        }
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = (int) snsAdNativeLandingPagesUI.jLd.jvJ;
        }
        imageView.setImageBitmap(decodeFile);
    }

    static /* synthetic */ void b(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, final a aVar) {
        if (aVar.jLJ) {
            Animation animationSet = new AnimationSet(true);
            Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -10.0f);
            translateAnimation.setDuration((long) snsAdNativeLandingPagesUI.jyJ);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            translateAnimation = new AlphaAnimation(0.8f, 0.3f);
            translateAnimation.setDuration((long) snsAdNativeLandingPagesUI.jyJ);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new AnimationListener(snsAdNativeLandingPagesUI) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    Animation animationSet = new AnimationSet(true);
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -10.0f, 0.0f);
                    translateAnimation.setDuration((long) this.jLi.jyJ);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) this.jLi.jyJ);
                    animationSet.addAnimation(translateAnimation);
                    translateAnimation = new AlphaAnimation(0.3f, 0.8f);
                    translateAnimation.setDuration((long) this.jLi.jyJ);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) this.jLi.jyJ);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass9 jLp;

                        {
                            this.jLp = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            SnsAdNativeLandingPagesUI.b(this.jLp.jLi, aVar);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    aVar.jLI.startAnimation(animationSet);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            aVar.jLI.startAnimation(animationSet);
        }
    }

    static /* synthetic */ void e(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.jKV;
        gVar.jBB++;
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 259);
        intent.putExtra("select_is_ret", true);
        com.tencent.mm.ay.c.a(snsAdNativeLandingPagesUI, ".ui.transmit.SelectConversationUI", intent, 0, new com.tencent.mm.ui.MMActivity.a(snsAdNativeLandingPagesUI) {
            final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

            {
                this.jLi = r1;
            }

            public final void a(int i, int i2, Intent intent) {
                if (i2 == -1) {
                    final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        v.e("MicroMsg.SnsAdNativeLandingPagesUI", "mmOnActivityResult fail, toUser is null");
                        return;
                    }
                    v.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI is ok");
                    final String w = this.jLi.jKN;
                    final Context context = this.jLi;
                    com.tencent.mm.pluginsdk.ui.applet.c.a(((MMActivity) context).nDR, this.jLi.fwi, this.jLi.jKR, this.jLi.jKS, true, context.getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                        final /* synthetic */ AnonymousClass13 jLB;

                        public final void a(boolean z, final String str, int i) {
                            if (z) {
                                final WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                wXMediaMessage.title = this.jLB.jLi.fwi;
                                wXMediaMessage.description = this.jLB.jLi.jKS;
                                WXWebpageObject wXWebpageObject = new WXWebpageObject();
                                wXWebpageObject.canvasPageXml = w;
                                wXWebpageObject.webpageUrl = this.jLB.jLi.fwh;
                                wXMediaMessage.mediaObject = wXWebpageObject;
                                if (this.jLB.jLi.jyz.containsKey(this.jLB.jLi.jKR)) {
                                    Bitmap bitmap = (Bitmap) this.jLB.jLi.jyz.get(this.jLB.jLi.jKR);
                                    if (!(bitmap == null || bitmap.isRecycled())) {
                                        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "thumb image is not null");
                                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                    }
                                    mp mpVar = new mp();
                                    mpVar.bnP.bhh = wXMediaMessage;
                                    mpVar.bnP.toUser = stringExtra;
                                    mpVar.bnP.bnQ = 49;
                                    mpVar.bnP.bnR = "";
                                    mpVar.bnP.bnS = "";
                                    com.tencent.mm.sdk.c.a.nhr.z(mpVar);
                                    if (!TextUtils.isEmpty(str)) {
                                        mr mrVar = new mr();
                                        mrVar.boa.bob = stringExtra;
                                        mrVar.boa.content = str;
                                        mrVar.boa.type = m.fp(stringExtra);
                                        mrVar.boa.flags = 0;
                                        com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                                    }
                                    com.tencent.mm.ui.base.g.bf(context, context.getString(2131231155));
                                    return;
                                }
                                z.Kg(this.jLB.jLi.jKR);
                                d.a("adId", this.jLB.jLi.jKR, false, 1000000001, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                                    final /* synthetic */ AnonymousClass1 jLD;

                                    public final void aRx() {
                                    }

                                    public final void aTV() {
                                    }

                                    public final void Bg(String str) {
                                        try {
                                            Bitmap decodeFile = BitmapFactory.decodeFile(str);
                                            this.jLD.jLB.jLi.jyz.put(this.jLD.jLB.jLi.jKR, decodeFile);
                                            if (!(decodeFile == null || decodeFile.isRecycled())) {
                                                v.i("MicroMsg.SnsAdNativeLandingPagesUI", "thumb image is not null");
                                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                decodeFile.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                                wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                            }
                                            mp mpVar = new mp();
                                            mpVar.bnP.bhh = wXMediaMessage;
                                            mpVar.bnP.toUser = stringExtra;
                                            mpVar.bnP.bnQ = 49;
                                            mpVar.bnP.bnR = "";
                                            mpVar.bnP.bnS = "";
                                            com.tencent.mm.sdk.c.a.nhr.z(mpVar);
                                            if (!TextUtils.isEmpty(str)) {
                                                mr mrVar = new mr();
                                                mrVar.boa.bob = stringExtra;
                                                mrVar.boa.content = str;
                                                mrVar.boa.type = m.fp(stringExtra);
                                                mrVar.boa.flags = 0;
                                                com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                                            }
                                            com.tencent.mm.ui.base.g.bf(context, context.getString(2131231155));
                                        } catch (Exception e) {
                                            v.e("MicroMsg.SnsAdNativeLandingPagesUI", "this has a error : " + e.toString());
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ void f(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.jKV;
        gVar.jBA++;
        String str = snsAdNativeLandingPagesUI.fwh;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline fail, link is null");
            return;
        }
        int i = snsAdNativeLandingPagesUI.eJb;
        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i);
        intent.putExtra("Ksnsupload_height", i);
        intent.putExtra("Ksnsupload_link", snsAdNativeLandingPagesUI.fwh);
        intent.putExtra("Ksnsupload_title", snsAdNativeLandingPagesUI.fwi);
        intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.jKR);
        intent.putExtra("Ksnsupload_canvas_info", snsAdNativeLandingPagesUI.jKN);
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, start activity");
        intent.putExtra("need_result", true);
        str = "sns_";
        if (snsAdNativeLandingPagesUI.bbT == 1 || snsAdNativeLandingPagesUI.bbT == 2 || snsAdNativeLandingPagesUI.bbT == 3 || snsAdNativeLandingPagesUI.bbT == 4 || snsAdNativeLandingPagesUI.bbT == 9 || snsAdNativeLandingPagesUI.bbT == 10 || snsAdNativeLandingPagesUI.bbT == 11) {
            str = "sns_" + snsAdNativeLandingPagesUI.boC;
        } else if (snsAdNativeLandingPagesUI.bbT == 5 || snsAdNativeLandingPagesUI.bbT == 6) {
            str = "msg_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        } else if (snsAdNativeLandingPagesUI.bbT == 7) {
            str = "fav_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getString("sns_landing_favid");
        }
        String fz = o.fz(str);
        o.yx().n(fz, true).l("prePublishId", str);
        intent.putExtra("reportSessionId", fz);
        com.tencent.mm.ay.c.a(snsAdNativeLandingPagesUI.nDR.nEl, "sns", ".ui.SnsUploadUI", intent, 1, false);
    }

    static /* synthetic */ void g(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        boolean z;
        g gVar = snsAdNativeLandingPagesUI.jKV;
        gVar.cWc++;
        bp bpVar = new bp();
        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "doFav snsAdNativeLadingPagesUI");
        long j = snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        String str = null;
        if (!be.kS(snsAdNativeLandingPagesUI.boC)) {
            str = ad.aSE().Bp(snsAdNativeLandingPagesUI.boC).aUL();
        }
        if ((snsAdNativeLandingPagesUI.bbT == 1 || snsAdNativeLandingPagesUI.bbT == 2 || snsAdNativeLandingPagesUI.bbT == 3 || snsAdNativeLandingPagesUI.bbT == 4 || snsAdNativeLandingPagesUI.bbT == 9 || snsAdNativeLandingPagesUI.bbT == 10 || snsAdNativeLandingPagesUI.bbT == 11) && !be.kS(str)) {
            oi oiVar = new oi();
            oiVar.bpn.bpp = str;
            oiVar.bpn.bpq = bpVar;
            oiVar.bpn.url = snsAdNativeLandingPagesUI.fwh;
            com.tencent.mm.sdk.c.a.nhr.z(oiVar);
            z = oiVar.bpo.aYN;
        } else {
            z = ((snsAdNativeLandingPagesUI.bbT == 5 || snsAdNativeLandingPagesUI.bbT == 6) && j != -2147483648L) ? com.tencent.mm.pluginsdk.model.d.a(bpVar, j) : false;
        }
        if (z) {
            bpVar.aZd.aZj = o.fz(be.ma(snsAdNativeLandingPagesUI.getIntent().getStringExtra("prePublishId")));
            bpVar.aZd.title = snsAdNativeLandingPagesUI.fwi;
            bpVar.aZd.desc = snsAdNativeLandingPagesUI.jKS;
            qf qfVar = bpVar.aZd.aZf;
            if (!(qfVar == null || qfVar.mtR == null || qfVar.mtR.size() <= 0 || qfVar.mtR.get(0) == null)) {
                ((pw) qfVar.mtR.get(0)).IV(snsAdNativeLandingPagesUI.jKN);
                ((pw) qfVar.mtR.get(0)).Iw(snsAdNativeLandingPagesUI.fwi);
                ((pw) qfVar.mtR.get(0)).Ix(snsAdNativeLandingPagesUI.jKS);
            }
            qfVar.Jl(snsAdNativeLandingPagesUI.fwi);
            qfVar.Jm(snsAdNativeLandingPagesUI.jKS);
            bpVar.aZd.aXH = snsAdNativeLandingPagesUI;
            bpVar.aZd.aZl = 34;
            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
            return;
        }
        if (bpVar.aZd.aZk == 0) {
            bpVar.aZd.aZk = 2131232661;
        }
        com.tencent.mm.ui.base.g.f(snsAdNativeLandingPagesUI.nDR.nEl, bpVar.aZd.aZk, 0);
    }

    static /* synthetic */ void k(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        final Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
        alphaAnimation.setDuration((long) snsAdNativeLandingPagesUI.jyI);
        alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        alphaAnimation.setStartOffset((long) snsAdNativeLandingPagesUI.jyI);
        alphaAnimation.setAnimationListener(new AnimationListener(snsAdNativeLandingPagesUI) {
            final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

            {
                this.jLi = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jLi.jKQ.setVisibility(0);
            }

            public final void onAnimationEnd(Animation animation) {
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 jLk;

                    {
                        this.jLk = r1;
                    }

                    public final void run() {
                        SnsAdNativeLandingPagesUI.u(this.jLk.jLi);
                    }
                }, 200);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        if (snsAdNativeLandingPagesUI.jLd == null || snsAdNativeLandingPagesUI.jLd.equals(snsAdNativeLandingPagesUI.jKQ.getTag())) {
            snsAdNativeLandingPagesUI.jKQ.startAnimation(alphaAnimation);
            return;
        }
        snsAdNativeLandingPagesUI.jKQ.setTag(snsAdNativeLandingPagesUI.jLd);
        d.a(snsAdNativeLandingPagesUI.jLd.iconUrl, 1000000001, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(snsAdNativeLandingPagesUI) {
            final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

            public final void aRx() {
            }

            public final void aTV() {
                this.jLi.jKQ.startAnimation(alphaAnimation);
            }

            public final void Bg(String str) {
                SnsAdNativeLandingPagesUI.a(this.jLi, str, this.jLi.jKQ);
                this.jLi.jKQ.startAnimation(alphaAnimation);
            }
        });
    }

    static /* synthetic */ void u(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -10.0f);
        translateAnimation.setDuration((long) snsAdNativeLandingPagesUI.jyJ);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(0.8f, 0.3f);
        translateAnimation.setDuration((long) snsAdNativeLandingPagesUI.jyJ);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new AnimationListener(snsAdNativeLandingPagesUI) {
            final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

            {
                this.jLi = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                Animation animationSet = new AnimationSet(true);
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -10.0f, 0.0f);
                translateAnimation.setDuration((long) this.jLi.jyJ);
                translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                translateAnimation.setStartTime((long) this.jLi.jyJ);
                animationSet.addAnimation(translateAnimation);
                translateAnimation = new AlphaAnimation(0.3f, 0.8f);
                translateAnimation.setDuration((long) this.jLi.jyJ);
                translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                translateAnimation.setStartTime((long) this.jLi.jyJ);
                animationSet.addAnimation(translateAnimation);
                animationSet.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass6 jLm;

                    {
                        this.jLm = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        SnsAdNativeLandingPagesUI.u(this.jLm.jLi);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jLi.jKQ.startAnimation(animationSet);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        snsAdNativeLandingPagesUI.jKQ.startAnimation(animationSet);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKK = bundle;
        this.nDR.bAj();
        this.startTime = System.currentTimeMillis();
        this.bbT = getIntent().getIntExtra("sns_landig_pages_from_source", 1);
        this.jKN = getIntent().getStringExtra("sns_landing_pages_xml");
        this.jKV.jpw = getIntent().getStringExtra("sns_landing_pages_expid");
        this.jKO = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
        this.boC = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
        this.jpt = getIntent().getStringExtra("sns_landing_pages_ux_info");
        this.jup = getIntent().getStringExtra("sns_landing_pages_aid");
        this.jKX = getIntent().getStringExtra("sns_landing_pages_traceid");
        k Bp = ad.aSE().Bp(this.boC);
        if (!(be.kS(this.boC) || Bp == null || !Bp.qC(32))) {
            this.jKT = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
        }
        if (this.jKO == null || "".equals(this.jKN)) {
            this.jKO = "adxml";
        }
        if (be.kS(this.jKN) || be.kS(this.jKO)) {
            v.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.jKN + ",landingPagesXmlPrex is " + this.jKO);
        } else {
            Map q = f.q(this.jKN, this.jKO);
            if (q == null) {
                v.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + this.jKN);
            } else {
                azr aUp;
                String zJ;
                if (this.bbT == 1 || this.bbT == 2) {
                    long j = 0;
                    if (Bp != null) {
                        j = Bp.field_snsId;
                    }
                    q.put("." + this.jKO + ".originSnsId", String.valueOf(j));
                    q.put("." + this.jKO + ".originUxInfo", this.jpt);
                    this.jKN = this.jKN.replace("<" + this.jKO + ">", "<" + this.jKO + ">\n<originSnsId>" + j + "</originSnsId>\n<originUxInfo>" + this.jpt + "</originUxInfo>");
                    this.jKV.jpt = this.jpt;
                    this.jKV.boC = String.valueOf(j);
                } else {
                    this.jKV.boC = (String) q.get("." + this.jKO + ".originSnsId");
                    this.jKV.jpt = (String) q.get("." + this.jKO + ".originUxInfo");
                }
                g gVar = this.jKV;
                com.tencent.mm.plugin.sns.storage.c cV = ad.aSF().cV(be.KM(this.jKV.boC));
                if (cV != null) {
                    aUp = cV.aUp();
                    if (aUp != null) {
                        zJ = com.tencent.mm.plugin.sns.a.a.f.zJ(aUp.jGu);
                    } else {
                        v.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
                        zJ = null;
                    }
                } else {
                    v.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[]{Long.valueOf(r6)});
                    zJ = "";
                }
                gVar.jBD = zJ;
                this.fwi = be.ah((String) q.get("." + this.jKO + ".adCanvasInfo.shareTitle"), "");
                this.fwh = be.ah((String) q.get("." + this.jKO + ".adCanvasInfo.shareWebUrl"), "");
                this.jKS = be.ah((String) q.get("." + this.jKO + ".adCanvasInfo.shareDesc"), "");
                this.jKY = be.KL(be.ah((String) q.get("." + this.jKO + ".adCanvasInfo.bizId"), ""));
                this.jKZ = be.ah((String) q.get("." + this.jKO + ".adCanvasInfo.shareAppId"), "");
                this.jLa = be.ah((String) q.get("." + this.jKO + ".adCanvasInfo.shareType"), "");
                this.jLb = be.ah((String) q.get("." + this.jKO + ".adCanvasInfo.userInfo"), "");
                this.jLe = be.KL(be.ah((String) q.get("." + this.jKO + ".adCanvasInfo.disableShareBitSet"), ""));
                String str = "." + this.jKO;
                zJ = (String) q.get(str + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
                if (TextUtils.isEmpty(zJ)) {
                    this.jLd = null;
                } else {
                    if (this.jLd == null) {
                        this.jLd = new t();
                    }
                    this.jLd.iconUrl = zJ;
                    int KL = be.KL((String) q.get(str + ".adCanvasInfo.sizeType"));
                    int KL2 = be.KL((String) q.get(str + ".adCanvasInfo.basicRootFontSize"));
                    int KL3 = be.KL((String) q.get(str + ".adCanvasInfo.basicWidth"));
                    int i = (KL2 == 0 && KL == 1) ? com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.jBf : KL2;
                    KL2 = (KL3 == 0 && KL == 1) ? com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.jBe : KL3;
                    this.jLd.jvJ = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(be.KN((String) q.get(str + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), KL, KL2, i);
                    this.jLd.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(be.KN((String) q.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), KL, KL2, i);
                    this.jLd.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(be.KN((String) q.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), KL, KL2, i);
                }
                this.jKz = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.j(this.jKN, this.jKO, this.jup, this.jKX);
                if (this.jKz.size() > 0) {
                    String str2 = "";
                    c cVar = (c) this.jKz.get(0);
                    if (cVar.jAW.size() > 0) {
                        n nVar = (n) cVar.jAW.get(0);
                        if (nVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) {
                            this.jKR = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) nVar).jvA;
                        } else if (nVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j) {
                            this.jKR = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j) nVar).jvA;
                        } else if (nVar instanceof l) {
                            this.jKR = ((l) nVar).jvC;
                            str2 = ((l) nVar).jvB;
                        }
                    }
                    if (Bp != null) {
                        aUp = Bp.aUp();
                        if (!(aUp == null || aUp.mWq == null || aUp.mWq.mom == null || aUp.mWq.mom.isEmpty())) {
                            aib com_tencent_mm_protocal_c_aib = (aib) aUp.mWq.mom.getFirst();
                            String str3 = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.i(com_tencent_mm_protocal_c_aib);
                            zJ = com_tencent_mm_protocal_c_aib.glb;
                            if (str2.equals(zJ)) {
                                zJ = d.cJ("adId", zJ);
                                if (!FileOp.aR(zJ) && FileOp.aR(str3)) {
                                    v.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[]{str3, zJ});
                                    FileOp.p(str3, zJ);
                                }
                            }
                        }
                    }
                }
                this.jKM = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                if (this.jKM) {
                    this.jKV.jBs = 0;
                    this.jKV.bYu = 0;
                } else {
                    this.jKV.jBs = 1;
                    this.jKV.bYu = 1;
                }
                this.jKV.jBt = this.bbT;
                this.jKV.jBu = 0;
                this.jKV.jBv = 0;
                this.jKV.jBw = 1;
                this.jKV.jBx = 0;
                ak.vy().a(1337, this);
            }
        }
        NI();
        if (this.jKY == 1) {
            ak.vy().a(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(this.jKZ, this.jLa, this.jLb), 0);
        }
    }

    protected final int NO() {
        return 1;
    }

    protected void onDestroy() {
        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy");
        ak.vy().b(1337, this);
        if (!this.jKW) {
            Iterator it = this.jvE.iterator();
            while (it.hasNext()) {
                ((j) it.next()).aTU();
            }
            this.jxX += System.currentTimeMillis() - this.startTime;
            this.jKV.jBz = (int) this.jxX;
            this.jKV.Z(this.jvE);
            String aUl = this.jKV.aUl();
            com.tencent.mm.plugin.report.service.g.iuh.Y(13387, aUl);
            v.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: " + aUl);
        }
        this.jvE.clear();
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        this.startTime = System.currentTimeMillis();
        qT(-1);
        this.jKA.aWp();
    }

    protected void onPause() {
        super.onPause();
        this.jxX += System.currentTimeMillis() - this.startTime;
        Iterator it = this.jvE.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.jxY) {
                jVar.aTP();
            }
        }
        SnsAdNativeLandingPagesScrollView snsAdNativeLandingPagesScrollView = this.jKA;
        snsAdNativeLandingPagesScrollView.removeCallbacks(snsAdNativeLandingPagesScrollView.jKw);
        snsAdNativeLandingPagesScrollView.jKq = false;
    }

    private void qT(int i) {
        if (i == -1) {
            i = this.jKA.getScrollY();
        }
        this.jKA.getScrollY();
        Iterator it = this.jvE.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            j jVar = (j) it.next();
            View view = jVar.getView();
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                if (this.jvE.getFirst() != null && this.jvE.getFirst() == jVar) {
                    i2 = iArr[1];
                }
                int i3 = (iArr[1] - i2) + 1;
                int i4 = i > i3 ? i : i3;
                int measuredHeight = this.jKA.getMeasuredHeight() + i > view.getMeasuredHeight() + i3 ? i3 + view.getMeasuredHeight() : this.jKA.getMeasuredHeight() + i;
                if (measuredHeight - i4 >= 2) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (jVar.jxY && i3 == 0) {
                    jVar.aTP();
                } else if (!(jVar.jxY || i3 == 0)) {
                    jVar.aTO();
                }
                if (i3 != 0 || (jVar instanceof w)) {
                    jVar.K(measuredHeight - i4, view.getMeasuredHeight(), this.jKA.getMeasuredHeight());
                }
            }
        }
    }

    public final void Rj() {
        this.jKV.bYu = 2;
        g gVar = this.jKV;
        gVar.jBx++;
        super.Rj();
    }

    private void aWs() {
        WindowManager windowManager = (WindowManager) this.nDR.nEl.getSystemService("window");
        final int width = windowManager.getDefaultDisplay().getWidth();
        final int height = windowManager.getDefaultDisplay().getHeight();
        this.jKB.clear();
        this.jvE.clear();
        LayoutInflater layoutInflater = (LayoutInflater) this.nDR.nEl.getSystemService("layout_inflater");
        for (int i = 0; i < this.jKz.size(); i++) {
            final c cVar = (c) this.jKz.get(i);
            if (cVar.jvR) {
                View view;
                a aVar;
                View view2 = (View) this.jKD.get(cVar.id);
                if (view2 != null) {
                    this.jLc.removeView(view2);
                    view = view2;
                } else {
                    view = layoutInflater.inflate(2130903082, null);
                }
                if (view.getTag() != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = new a();
                    aVar.jLH = (ImageView) view.findViewById(2131755291);
                    aVar.dVp = (LinearLayout) view.findViewById(2131755292);
                    aVar.jLI = (ImageView) view.findViewById(2131755293);
                    view.setTag(aVar);
                    aVar.dVp.removeAllViewsInLayout();
                    aVar.dVp.setMinimumHeight(height);
                }
                int i2 = 0;
                if (cVar.jAU != null && cVar.jAU.length() > 0) {
                    final String str = cVar.jAU;
                    final ImageView imageView = aVar.jLH;
                    if (this.jyz.containsKey(str)) {
                        imageView.setImageBitmap((Bitmap) this.jyz.get(str));
                    } else {
                        d.a("adId", str, false, 1000000001, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                            final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                            public final void aRx() {
                            }

                            public final void aTV() {
                                if (cVar.dCB != null && cVar.dCB.length() > 0) {
                                    int i = 0;
                                    try {
                                        i = Color.parseColor(cVar.dCB);
                                    } catch (Exception e) {
                                        v.e("MicroMsg.SnsAdNativeLandingPagesUI", "the color is error : " + cVar.dCB);
                                    }
                                    aVar.jLH.setVisibility(8);
                                    view.setBackgroundColor(i);
                                    aVar.jLH.setBackgroundColor(i);
                                    aVar.dVp.setBackgroundColor(i);
                                    if (i - -16777216 <= -1 - i) {
                                        aVar.jLI.setImageDrawable(com.tencent.mm.bd.a.a(this.jLi, 2130838833));
                                        if (this.jLi.jKz.getFirst() == cVar) {
                                            this.jLi.jKQ.setImageDrawable(com.tencent.mm.bd.a.a(this.jLi, 2130838833));
                                            return;
                                        }
                                        return;
                                    }
                                    aVar.jLI.setImageDrawable(com.tencent.mm.bd.a.a(this.jLi, 2130838832));
                                    if (this.jLi.jKz.getFirst() == cVar) {
                                        this.jLi.jKQ.setImageDrawable(com.tencent.mm.bd.a.a(this.jLi, 2130838832));
                                    }
                                }
                            }

                            public final void Bg(String str) {
                                Bitmap bitmap = null;
                                try {
                                    float max;
                                    if (cVar.jAV) {
                                        String cI = d.cI("adId", str + "_blurimg");
                                        if (FileOp.aR(cI)) {
                                            bitmap = BitmapFactory.decodeFile(cI);
                                        } else {
                                            Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                                            if (decodeFile != null) {
                                                if (decodeFile.getHeight() < height || decodeFile.getWidth() < width) {
                                                    max = Math.max((((float) width) * 1.0f) / ((float) decodeFile.getWidth()), (((float) height) * 1.0f) / ((float) decodeFile.getHeight()));
                                                } else {
                                                    max = 1.0f;
                                                }
                                                Bitmap a = com.tencent.mm.sdk.platformtools.d.a(decodeFile, max, max);
                                                com.tencent.mm.memory.n a2 = com.tencent.mm.plugin.sns.lucky.b.a.a(Bitmap.createBitmap(a, (a.getWidth() - width) >>> 1, (a.getHeight() - height) >>> 1, width, height), cI, Color.argb(com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX, 0, 0, 0), 180);
                                                if (a2 != null) {
                                                    bitmap = a2.wn();
                                                }
                                            }
                                        }
                                        imageView.setScaleType(ScaleType.CENTER_CROP);
                                    }
                                    if (bitmap == null) {
                                        bitmap = BitmapFactory.decodeFile(str);
                                        if (bitmap.getWidth() < width) {
                                            max = (((float) width) * 1.0f) / ((float) bitmap.getWidth());
                                            bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, max, max);
                                            if (bitmap.getHeight() > aVar.dVp.getHeight()) {
                                                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), aVar.dVp.getHeight());
                                            }
                                        }
                                    }
                                    imageView.setImageBitmap(bitmap);
                                } catch (Exception e) {
                                    v.e("MicroMsg.SnsAdNativeLandingPagesUI", "the backgroundCoverUrl is set error ,because " + e.toString());
                                }
                            }
                        });
                    }
                } else if (cVar.dCB != null && cVar.dCB.length() > 0) {
                    int parseColor;
                    try {
                        parseColor = Color.parseColor(cVar.dCB);
                    } catch (Exception e) {
                        v.e("MicroMsg.SnsAdNativeLandingPagesUI", "the color is error : " + cVar.dCB);
                        parseColor = 0;
                    }
                    aVar.jLH.setVisibility(8);
                    view.setBackgroundColor(parseColor);
                    aVar.jLH.setBackgroundColor(parseColor);
                    aVar.dVp.setBackgroundColor(parseColor);
                    if (parseColor - -16777216 <= -1 - parseColor) {
                        aVar.jLI.setImageDrawable(com.tencent.mm.bd.a.a(this, 2130838833));
                        if (this.jKz.getFirst() == cVar) {
                            this.jKQ.setImageDrawable(com.tencent.mm.bd.a.a(this, 2130838833));
                            i2 = parseColor;
                        }
                    } else {
                        aVar.jLI.setImageDrawable(com.tencent.mm.bd.a.a(this, 2130838832));
                        if (this.jKz.getFirst() == cVar) {
                            this.jKQ.setImageDrawable(com.tencent.mm.bd.a.a(this, 2130838832));
                        }
                    }
                    i2 = parseColor;
                }
                h hVar = (h) this.jKC.get(Integer.valueOf(i));
                if (hVar == null) {
                    hVar = new h(cVar.jAW, this, i2, aVar.dVp);
                    hVar.layout();
                    this.jKC.put(Integer.valueOf(i), hVar);
                } else {
                    hVar.bq(cVar.jAW);
                }
                a(hVar);
                if (!(this.jvE.isEmpty() || this.jvE.getLast() == null || !(this.jvE.getLast() instanceof w))) {
                    w wVar = (w) this.jvE.getLast();
                    aVar.jLI.setVisibility(4);
                    wVar.jzS = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z(this) {
                        final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                        public final void gm(boolean z) {
                            if (z) {
                                aVar.jLI.clearAnimation();
                                aVar.jLI.setVisibility(8);
                                aVar.jLI.setAlpha(0.0f);
                                return;
                            }
                            aVar.jLI.setAlpha(1.0f);
                            this.jLi.a(aVar);
                        }
                    };
                }
                if (this.jKz.getLast() == cVar) {
                    aVar.jLI.setVisibility(8);
                }
                this.jLc.addView(view);
                this.jKB.add(view);
                this.jKD.put(cVar.id, view);
            }
        }
    }

    private void a(h hVar) {
        for (j jVar : hVar.jBF == null ? Collections.EMPTY_LIST : hVar.jBF.values()) {
            if (jVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a) jVar).a(this.jzK, this.jvE.size(), this.jKT);
            }
            this.jvE.add(jVar);
        }
    }

    @TargetApi(16)
    protected final void NI() {
        super.NI();
        this.jLc = (LinearLayout) findViewById(2131759264);
        this.jKA = (SnsAdNativeLandingPagesScrollView) findViewById(2131755399);
        this.jKJ = (ImageView) findViewById(2131755841);
        this.jKF = (ImageView) findViewById(2131759265);
        this.evI = (ImageView) findViewById(2131759266);
        this.evI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

            {
                this.jLi = r1;
            }

            public final void onClick(View view) {
                this.jLi.abE();
            }
        });
        this.jKE = (ImageView) findViewById(2131759267);
        if (aWt()) {
            this.jKE.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                {
                    this.jLi = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.jLi, com.tencent.mm.ui.widget.f.pbS, false);
                    fVar.jXn = new com.tencent.mm.ui.base.n.c(this) {
                        final /* synthetic */ AnonymousClass16 jLE;

                        {
                            this.jLE = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            if (this.jLE.jLi.jLe == 0 || (this.jLE.jLi.jLe & 2) == 0) {
                                lVar.a(1, this.jLE.jLi.getString(2131234560), 2131165344);
                            }
                            if (this.jLE.jLi.jLe == 0 || (this.jLE.jLi.jLe & 1) == 0) {
                                lVar.a(2, this.jLE.jLi.getString(2131235369), 2131165334);
                            }
                            if ((this.jLE.jLi.jLe == 0 || (this.jLE.jLi.jLe & 4) == 0) && this.jLE.jLi.bbT != 7) {
                                lVar.a(3, this.jLE.jLi.getString(2131231780), 2131165326);
                            }
                        }
                    };
                    fVar.jXo = new com.tencent.mm.ui.base.n.d(this) {
                        final /* synthetic */ AnonymousClass16 jLE;

                        {
                            this.jLE = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 1:
                                    SnsAdNativeLandingPagesUI.e(this.jLE.jLi);
                                    return;
                                case 2:
                                    SnsAdNativeLandingPagesUI.f(this.jLE.jLi);
                                    return;
                                case 3:
                                    SnsAdNativeLandingPagesUI.g(this.jLE.jLi);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    fVar.pca = true;
                    fVar.bKh();
                }
            });
        } else {
            this.jKE.setVisibility(8);
        }
        this.jKQ = (ImageView) findViewById(2131759268);
        if (this.jKz == null || this.jKz.size() == 0) {
            v.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPages is null");
            return;
        }
        aWs();
        WindowManager windowManager = (WindowManager) this.nDR.nEl.getSystemService("window");
        windowManager.getDefaultDisplay().getWidth();
        final int height = windowManager.getDefaultDisplay().getHeight();
        this.jKL = new a(this.nDR.nEl);
        this.jKA.jKu = this;
        this.jKA.aWp();
        this.jKV.jBy = this.jvE.size();
        final View view = ((j) this.jvE.getFirst()).getView();
        ViewTreeObserver viewTreeObserver = this.jKA.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

            public final void onGlobalLayout() {
                if (!this.jLi.jKU) {
                    this.jLi.qT(-1);
                    this.jLi.jKU = true;
                    int height = ((j) this.jLi.jvE.getFirst()).getView().getHeight();
                    Iterator it = this.jLi.jvE.iterator();
                    int i = height;
                    while (it.hasNext()) {
                        j jVar = (j) it.next();
                        if (this.jLi.jvE.indexOf(jVar) != 0) {
                            height = jVar.getView().getHeight() + i;
                        } else {
                            height = i;
                        }
                        if (height >= height) {
                            SnsAdNativeLandingPagesUI.k(this.jLi);
                            return;
                        }
                        i = height;
                    }
                }
            }
        });
        if (view == null || !this.jKM) {
            this.jKA.post(new Runnable(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                {
                    this.jLi = r1;
                }

                public final void run() {
                    this.jLi.jKA.scrollTo(0, 0);
                }
            });
            getWindow().setFlags(1024, 1024);
            setRequestedOrientation(1);
        } else {
            this.eIZ = getIntent().getIntExtra("img_gallery_top", 0);
            this.eJa = getIntent().getIntExtra("img_gallery_left", 0);
            this.eJb = getIntent().getIntExtra("img_gallery_width", 0);
            this.eJc = getIntent().getIntExtra("img_gallery_height", 0);
            this.jKL.m(this.eJa, this.eIZ, this.eJb, this.eJc);
            this.evI.setVisibility(8);
            this.jKE.setVisibility(8);
            if (this.jKK == null) {
                viewTreeObserver.addOnPreDrawListener(new OnPreDrawListener(this) {
                    final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                    public final boolean onPreDraw() {
                        LinkedList linkedList = new LinkedList();
                        int height = ((j) this.jLi.jvE.getFirst()).getView().getHeight();
                        Iterator it = this.jLi.jvE.iterator();
                        int i = height;
                        while (it.hasNext()) {
                            j jVar = (j) it.next();
                            if (this.jLi.jvE.indexOf(jVar) != 0) {
                                i += jVar.getView().getHeight();
                                linkedList.add(jVar.getView());
                            }
                            height = i;
                            if (height >= height) {
                                SnsAdNativeLandingPagesUI.k(this.jLi);
                                break;
                            }
                            i = height;
                        }
                        this.jLi.evI.setVisibility(8);
                        this.jLi.jKE.setVisibility(8);
                        this.jLi.jKF.setVisibility(8);
                        this.jLi.jKA.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.jLi.jKL.a(view, linkedList, this.jLi.jKJ, new a.b(this) {
                            final /* synthetic */ AnonymousClass18 jLF;

                            {
                                this.jLF = r1;
                            }

                            public final void onAnimationStart() {
                            }

                            public final void onAnimationEnd() {
                                this.jLF.jLi.evI.setVisibility(0);
                                if (this.jLF.jLi.aWt()) {
                                    this.jLF.jLi.jKE.setVisibility(0);
                                }
                                this.jLF.jLi.jKF.setVisibility(0);
                                this.jLF.jLi.getWindow().setFlags(1024, 1024);
                                this.jLF.jLi.setRequestedOrientation(1);
                                this.jLF.jLi.qT(-1);
                                this.jLF.jLi.jKA.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 jLG;

                                    {
                                        this.jLG = r1;
                                    }

                                    public final void run() {
                                        this.jLG.jLF.jLi.jKA.scrollTo(0, 0);
                                    }
                                });
                            }
                        });
                        return true;
                    }
                });
            }
        }
        qT(-1);
    }

    protected final int getLayoutId() {
        return 2130904433;
    }

    private boolean aWt() {
        if (this.jLe == 0 || (this.jLe & 4) == 0 || (this.jLe & 2) == 0 || (this.jLe & 1) == 0) {
            return true;
        }
        return false;
    }

    private void cx(int i, int i2) {
        if (this.jLf == -1) {
            this.jLg = i;
            this.jLf = i2;
            this.jKA.smoothScrollTo(0, i);
            qT(i);
            this.jKA.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                {
                    this.jLi = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.jKy = i;
            final int i3 = this.jLg;
            com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                public final void run() {
                    if (i3 == this.jLi.jLg) {
                        this.jLi.aWu();
                    }
                }
            }, 250);
        }
    }

    private void aWu() {
        this.jLf = -1;
        this.jLg = -1;
        this.jKA.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

            {
                this.jLi = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    public final void c(SnsAdNativeLandingPagesScrollView snsAdNativeLandingPagesScrollView, int i) {
        if (!this.jKP) {
            int i2;
            int measuredHeight;
            this.jKQ.setVisibility(8);
            this.jKQ.setAlpha(0.0f);
            Iterator it = this.jKB.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                View view = (View) it.next();
                if (view.getTag() instanceof a) {
                    a aVar = (a) view.getTag();
                    if (i > (view.getMeasuredHeight() + i3) - aVar.jLI.getHeight() || this.jKA.getMeasuredHeight() + i < view.getMeasuredHeight() + i3) {
                        aVar.jLJ = false;
                        aVar.jLI.setVisibility(4);
                        aVar.jLI.clearAnimation();
                    } else if (!aVar.jLJ) {
                        j jVar = null;
                        Iterator it2 = this.jvE.iterator();
                        i2 = 0;
                        while (it2.hasNext()) {
                            j jVar2 = (j) it2.next();
                            View view2 = jVar2.getView();
                            int[] iArr = new int[2];
                            view2.getLocationOnScreen(iArr);
                            if (this.jvE.getFirst() != null && this.jvE.getFirst() == jVar2) {
                                i2 = iArr[1];
                            }
                            int i4 = iArr[1] - i2;
                            if (view2.getMeasuredHeight() + i4 > view.getMeasuredHeight() + i3) {
                                break;
                            }
                            int measuredHeight2 = this.jKA.getMeasuredHeight();
                            int measuredHeight3 = view2.getMeasuredHeight();
                            Object obj = null;
                            if (i4 + measuredHeight3 < i || i4 > i + measuredHeight2) {
                                obj = 1;
                            } else if (measuredHeight3 + i4 == i) {
                                obj = 1;
                            } else if (i4 == measuredHeight2 + i) {
                                obj = 1;
                            }
                            if ((obj == null ? 1 : null) != null) {
                                measuredHeight = this.jKA.getMeasuredHeight() + i > view2.getMeasuredHeight() + i4 ? view2.getMeasuredHeight() + i4 : this.jKA.getMeasuredHeight() + i;
                                if (measuredHeight <= view.getMeasuredHeight() + i3 && measuredHeight >= (view.getMeasuredHeight() + i3) - aVar.jLI.getHeight()) {
                                    jVar = jVar2;
                                }
                            }
                        }
                        if (jVar != null && (jVar instanceof w)) {
                            if ((((w) jVar).jzT.getVisibility() == 0 ? 1 : null) == null || this.jKB.getLast() == view) {
                                a(aVar);
                            }
                        } else if (this.jKB.getLast() != view) {
                            a(aVar);
                        }
                    }
                }
                i3 = view.getMeasuredHeight() + i3;
            }
            Object obj2 = (this.jLg == -1 || this.jLg < 0) ? null : 1;
            if (obj2 == null) {
                i2 = this.jKy;
                int i5;
                int i6;
                int i7;
                if (i > i2) {
                    measuredHeight = this.jKG;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    while (i7 < this.jKB.size() && i7 <= this.jKG) {
                        i6 += ((View) this.jKB.get(i7)).getMeasuredHeight();
                        i7++;
                    }
                    i7 = 0;
                    while (i7 < this.jKB.size()) {
                        if (((View) this.jKB.get(i7)).getMeasuredHeight() + i5 >= snsAdNativeLandingPagesScrollView.getMeasuredHeight() + i && snsAdNativeLandingPagesScrollView.getMeasuredHeight() + i > i5) {
                            break;
                        }
                        i5 += ((View) this.jKB.get(i7)).getMeasuredHeight();
                        i7++;
                    }
                    i7 = 0;
                    if (i7 <= measuredHeight) {
                        this.jKy = i;
                        qT(i);
                    } else if (i2 == i6 - snsAdNativeLandingPagesScrollView.getMeasuredHeight()) {
                        cx(i6, i2);
                        this.jKG++;
                    } else {
                        cx(i6 - snsAdNativeLandingPagesScrollView.getMeasuredHeight(), i2);
                    }
                } else if (i < i2) {
                    measuredHeight = this.jKG;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    while (i7 < this.jKB.size() && i7 < this.jKG) {
                        i6 += ((View) this.jKB.get(i7)).getMeasuredHeight();
                        i7++;
                    }
                    i7 = 0;
                    while (i7 < this.jKB.size()) {
                        if (((View) this.jKB.get(i7)).getMeasuredHeight() + i5 > i && i >= i5) {
                            break;
                        }
                        i5 += ((View) this.jKB.get(i7)).getMeasuredHeight();
                        i7++;
                    }
                    i7 = 0;
                    if (i7 >= measuredHeight) {
                        this.jKy = i;
                        qT(i);
                    } else if (i2 == i6) {
                        cx(i6 - snsAdNativeLandingPagesScrollView.getMeasuredHeight(), i2);
                        this.jKG--;
                    } else {
                        cx(i6, i2);
                    }
                }
            }
        }
    }

    private void a(final a aVar) {
        aVar.jLI.clearAnimation();
        if (aVar.jLK <= 0) {
            final Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
            alphaAnimation.setDuration((long) this.jyI);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            alphaAnimation.setStartOffset((long) this.jyI);
            alphaAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                public final void onAnimationStart(Animation animation) {
                    aVar.jLI.setVisibility(0);
                    aVar.jLJ = true;
                    a aVar = aVar;
                    aVar.jLK++;
                }

                public final void onAnimationEnd(Animation animation) {
                    new ac().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 jLo;

                        {
                            this.jLo = r1;
                        }

                        public final void run() {
                            aVar.jLI.setAlpha(1.0f);
                            SnsAdNativeLandingPagesUI.b(this.jLo.jLi, aVar);
                        }
                    }, 200);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.jLd == null || this.jLd.equals(aVar.jLI.getTag())) {
                aVar.jLI.startAnimation(alphaAnimation);
                return;
            }
            aVar.jLI.setTag(this.jLd);
            d.a(this.jLd.iconUrl, 1000000001, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                public final void aRx() {
                }

                public final void aTV() {
                    aVar.jLI.startAnimation(alphaAnimation);
                }

                public final void Bg(String str) {
                    SnsAdNativeLandingPagesUI.a(this.jLi, str, aVar.jLI);
                    aVar.jLI.startAnimation(alphaAnimation);
                }
            });
        }
    }

    public final void abE() {
        this.jKP = true;
        Iterator it = this.jvE.iterator();
        while (it.hasNext()) {
            ((j) it.next()).aTU();
        }
        this.jxX += System.currentTimeMillis() - this.startTime;
        this.jKV.jBz = (int) this.jxX;
        this.jKV.Z(this.jvE);
        String aUl = this.jKV.aUl();
        com.tencent.mm.plugin.report.service.g.iuh.Y(13387, aUl);
        this.jKW = true;
        v.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: " + aUl);
        if (this.jKM) {
            this.jKA.scrollTo(0, 0);
            if (this.jvE == null || this.jvE.isEmpty() || this.jvE.getFirst() == null) {
                finish();
                overridePendingTransition(0, 0);
                return;
            }
            final View view = ((j) this.jvE.getFirst()).getView();
            this.jKL.m(this.eJa, this.eIZ, this.eJb, this.eJc);
            final LinkedList linkedList = new LinkedList();
            Iterator it2 = this.jvE.iterator();
            while (it2.hasNext()) {
                j jVar = (j) it2.next();
                if (!(this.jvE.indexOf(jVar) == 0 || jVar.getView() == null)) {
                    linkedList.add(jVar.getView());
                }
            }
            com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                public final void run() {
                    a aVar = this.jLi.jKL;
                    View view = view;
                    LinkedList linkedList = linkedList;
                    View p = this.jLi.jKJ;
                    a.b anonymousClass1 = new a.b(this) {
                        final /* synthetic */ AnonymousClass10 jLs;

                        {
                            this.jLs = r1;
                        }

                        public final void onAnimationStart() {
                            this.jLs.jLi.evI.setVisibility(8);
                        }

                        public final void onAnimationEnd() {
                            new ac().post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 jLt;

                                {
                                    this.jLt = r1;
                                }

                                public final void run() {
                                    this.jLt.jLs.jLi.finish();
                                    this.jLt.jLs.jLi.overridePendingTransition(0, 0);
                                }
                            });
                        }
                    };
                    if (!(VERSION.SDK_INT < 12 || view == null || aVar.jCR == aVar.jCO || aVar.jCR == aVar.jCQ || aVar.jCR == aVar.jCN)) {
                        view.getLocationOnScreen(new int[2]);
                        aVar.j(view, true);
                        if (p != null) {
                            p.animate().setDuration(300).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
                        }
                        Animation animationSet = new AnimationSet(true);
                        Animation anonymousClass3 = new com.tencent.mm.plugin.sns.ui.a.AnonymousClass3(aVar, aVar.jCE, aVar.jCE, view, null);
                        anonymousClass3.setDuration(300);
                        anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
                        animationSet.addAnimation(anonymousClass3);
                        anonymousClass3 = new TranslateAnimation(0.0f, (float) aVar.jCA, 0.0f, (float) aVar.jCB);
                        anonymousClass3.setDuration(300);
                        anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
                        animationSet.addAnimation(anonymousClass3);
                        animationSet.setFillAfter(true);
                        animationSet.setAnimationListener(new com.tencent.mm.plugin.sns.ui.a.AnonymousClass4(aVar, anonymousClass1));
                        view.startAnimation(animationSet);
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((View) it.next()).setAlpha(0.0f);
                        }
                    }
                    this.jLi.jvE.clear();
                }
            }, 10);
            return;
        }
        finish();
    }

    public void onBackPressed() {
        abE();
    }

    public final void aWq() {
        aWu();
    }

    public final void aWr() {
        aWu();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i != 0 || i2 != 0) {
            v.e("MicroMsg.SnsAdNativeLandingPagesUI", "the netscene is error ,error type is " + i + " error msg is " + str);
        } else if (kVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) {
            final String str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) kVar).bjE;
            v.i("MicroMsg.SnsAdNativeLandingPagesUI", "the dynamic string is " + str2);
            this.jLh.removeCallbacksAndMessages(null);
            this.jLh.post(new Runnable(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI jLi;

                public final void run() {
                    this.jLi.jKz = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.c(this.jLi.jKN, this.jLi.jKO, str2, this.jLi.jup, this.jLi.jKX);
                    com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass11 jLv;

                        {
                            this.jLv = r1;
                        }

                        public final void run() {
                            this.jLv.jLi.aWs();
                        }
                    });
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                com.tencent.mm.ui.base.g.bf(this.nDR.nEl, this.nDR.nEl.getString(2131231155));
            }
        } else if (i == 2 && intent.getBooleanExtra("kfavorite", false)) {
            bp bpVar = new bp();
            com.tencent.mm.pluginsdk.model.d.a(bpVar, intent);
            bpVar.aZd.aXH = this;
            bpVar.aZd.aZl = 42;
            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        }
        super.onActivityResult(i, i2, intent);
    }
}
