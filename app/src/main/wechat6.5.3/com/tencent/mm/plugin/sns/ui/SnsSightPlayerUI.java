package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.ng;
import com.tencent.mm.e.a.nk;
import com.tencent.mm.e.a.no;
import com.tencent.mm.e.a.np;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.d;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.a.a.h;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.a.a.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;

@a(3)
public class SnsSightPlayerUI extends MMActivity implements d.a, b {
    private String bdZ = "";
    private String bde = "";
    private aib boL = null;
    private int bqS = 0;
    private String cPu = "";
    private boolean cvW = false;
    private int duration = 0;
    Bundle eIW;
    private boolean eIX = false;
    g eIY;
    private int eIZ = 0;
    private int eJa = 0;
    private int eJb = 0;
    private int eJc = 0;
    com.tencent.mm.pluginsdk.ui.tools.g eJz = null;
    public l eyZ;
    private int fNz = 0;
    private TextView fQK = null;
    private boolean fQL = false;
    private VelocityTracker fj;
    private GestureDetector fjR;
    private float gpp = 0.0f;
    n.d hkn = new n.d(this) {
        final /* synthetic */ SnsSightPlayerUI jSZ;

        {
            this.jSZ = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            Intent intent;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    k Bq = ad.aSE().Bq(this.jSZ.bde);
                    if (Bq != null) {
                        v.i("MicroMsg.SnsSightPlayerUI", "expose id " + Bq.aUq());
                    }
                    intent.putExtra("k_expose_msg_id", Bq == null ? Integer.valueOf(0) : Bq.aUq());
                    intent.putExtra("k_username", Bq == null ? "" : Bq.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    c.b(this.jSZ, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    k Bq2 = ad.aSE().Bq(this.jSZ.bde);
                    if (Bq2 != null) {
                        bp bpVar = new bp();
                        com.tencent.mm.plugin.sns.j.a.a(bpVar, Bq2);
                        bpVar.aZd.aXH = this.jSZ;
                        bpVar.aZd.aZl = 17;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                        if (this.jSZ.jdE) {
                            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(Bq2.aUQ(), 11, 5, "", 2), 0);
                            j.a(j.d.Sight, j.c.Fav, e.Full, 0, Bq2);
                        }
                        if (this.jSZ.scene == 0) {
                            nk nkVar = new nk();
                            nkVar.boD.bap = Bq2.aUL();
                            nkVar.boD.boC = i.g(Bq2);
                            com.tencent.mm.sdk.c.a.nhr.z(nkVar);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    this.jSZ.jRn = true;
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", 3);
                    intent2.putExtra("select_is_ret", true);
                    intent2.putExtra("mutil_select_is_ret", true);
                    intent2.putExtra("image_path", this.jSZ.imagePath);
                    intent2.putExtra("Retr_Msg_Type", 11);
                    c.a(this.jSZ, ".ui.transmit.SelectConversationUI", intent2, 4097);
                    return;
                case 4:
                    k Bq3 = ad.aSE().Bq(this.jSZ.bde);
                    if (Bq3 != null) {
                        intent = new Intent();
                        if (Bq3.aUp().mWq.mol == 15 && ((aib) Bq3.aUp().mWq.mom.get(0)) == null) {
                            v.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
                            return;
                        }
                        intent.putExtra("exdevice_open_scene_type", 2);
                        intent.putExtra("sns_local_id", this.jSZ.bde);
                        intent.putExtra("sns_send_data_ui_activity", true);
                        c.a(this.jSZ, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private int iUu = 0;
    ViewGroup iVC;
    private int iVK = 0;
    private int iVL = 0;
    public int iVR = 0;
    private TextView iVo = null;
    private boolean iVp = false;
    private d iVr;
    private String imagePath = "";
    private boolean isInit = false;
    private ImageView jKJ;
    private float jMj = 1.0f;
    private int jMk = 0;
    private int jMl = 0;
    private boolean jRn = false;
    private float jRo = 0.0f;
    private boolean jRp = false;
    private boolean jRq = false;
    private boolean jRr = false;
    OnCreateContextMenuListener jRs = new OnCreateContextMenuListener(this) {
        final /* synthetic */ SnsSightPlayerUI jSZ;

        {
            this.jSZ = r1;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            int i;
            cp cpVar;
            if (be.KL(com.tencent.mm.h.j.sU().getValue("SIGHTCannotTransmitForFav")) == 0) {
                v.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.aR(this.jSZ.imagePath)), Boolean.valueOf(FileOp.aR(this.jSZ.cPu))});
                if (FileOp.aR(this.jSZ.imagePath) && r3) {
                    contextMenu.add(0, 3, 0, this.jSZ.getString(2131235368));
                    i = 1;
                    if (c.EH("favorite")) {
                        contextMenu.add(0, 2, 0, this.jSZ.getString(2131234180));
                    }
                    if (i != 0) {
                        cpVar = new cp();
                        cpVar.bay.bap = this.jSZ.bde;
                        com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                        if (cpVar.baz.aZW) {
                            contextMenu.add(0, 4, 0, this.jSZ.getString(2131231834));
                        }
                    }
                    if (!this.jSZ.jdE) {
                        contextMenu.add(0, 1, 0, this.jSZ.nDR.nEl.getString(2131235547));
                    }
                }
            }
            i = 0;
            if (c.EH("favorite")) {
                contextMenu.add(0, 2, 0, this.jSZ.getString(2131234180));
            }
            if (i != 0) {
                cpVar = new cp();
                cpVar.bay.bap = this.jSZ.bde;
                com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                if (cpVar.baz.aZW) {
                    contextMenu.add(0, 4, 0, this.jSZ.getString(2131231834));
                }
            }
            if (!this.jSZ.jdE) {
                contextMenu.add(0, 1, 0, this.jSZ.nDR.nEl.getString(2131235547));
            }
        }
    };
    private h jSS = new h("SnsSightPlayerUI");
    private String jST = "";
    private TextView jSU = null;
    private MMPinProgressBtn jSV = null;
    private k jSW = null;
    private String jSX = "";
    private RelativeLayout jSY;
    private boolean jdE = false;
    private int scene = 0;

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.nDR.bAj();
        ad.aSz().a((b) this);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(2131689547));
        }
        if (com.tencent.mm.compatible.util.d.dW(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.eIW = bundle;
        this.iVr = new d();
        this.cPu = getIntent().getStringExtra("intent_videopath");
        this.imagePath = getIntent().getStringExtra("intent_thumbpath");
        this.bde = getIntent().getStringExtra("intent_localid");
        this.jdE = getIntent().getBooleanExtra("intent_isad", false);
        this.jSW = ad.aSE().Bq(this.bde);
        if (this.jdE) {
            boolean z;
            if (this.jSW == null) {
                z = false;
            } else {
                this.boL = (aib) this.jSW.aUp().mWq.mom.get(0);
                String cA = al.cA(ad.xh(), this.boL.gID);
                this.jSX = cA + i.j(this.boL);
                this.bdZ = cA + i.c(this.boL);
                z = true;
            }
            if (!z) {
                finish();
                return;
            }
        }
        if (ak.oJ() != null) {
            ak.oJ().pU();
        }
        this.jSS.jcz = be.Nj();
        this.jSY = (RelativeLayout) findViewById(2131759250);
        this.jSY.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.jSZ.abE();
                return true;
            }
        });
        v.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.sl() + " initView: fullpath:" + this.cPu + ", imagepath:" + this.imagePath);
        this.eIY = new g(this.nDR.nEl);
        this.jKJ = (ImageView) findViewById(2131755841);
        this.jKJ.setLayerType(2, null);
        this.iVo = (TextView) findViewById(2131757003);
        this.jSV = (MMPinProgressBtn) findViewById(2131759193);
        this.iVC = (ViewGroup) findViewById(2131756998);
        this.eJz = o.do(this.nDR.nEl);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fQK = (TextView) findViewById(2131759210);
        this.iVC.addView((View) this.eJz, 0, layoutParams);
        this.jSU = (TextView) findViewById(2131759453);
        this.jSU.setText("");
        if (!this.jdE) {
            this.jSU.setVisibility(8);
        }
        if (this.jdE) {
            if (this.boL == null) {
                this.fQK.setVisibility(8);
            } else if (be.kS(this.boL.mHW)) {
                v.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
                final azr aUp = this.jSW.aUp();
                com.tencent.mm.plugin.sns.storage.b aUm = this.jSW.aUm();
                CharSequence charSequence = aUm.jux;
                final String str = aUm.juy;
                if (be.kS(charSequence) || be.kS(str)) {
                    this.fQK.setVisibility(8);
                } else {
                    this.fQK.setVisibility(0);
                    this.fQK.setText(charSequence);
                    this.fQK.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsSightPlayerUI jSZ;

                        public final void onClick(View view) {
                            if (j.b.Sight.value != 0) {
                                j.a(j.a.DetailInVideo, aUp.gID, this.jSZ.jSW.aUo() == null ? "" : this.jSZ.jSW.aUo().jpt, 1, j.b.Sight.value, aUp.gln, null, aUp.gID, 0, 0, 0);
                            }
                            final Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", aUp.jGu);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("useJs", true);
                            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jSZ.jSW.aUQ(), 18, 5, "", 2), 0);
                            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass7 jTc;

                                public final void run() {
                                    com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.jTc.jSZ);
                                    this.jTc.jSZ.finish();
                                }
                            });
                        }
                    });
                }
            } else {
                cA = getResources().getString(2131235359);
                if (this.boL.jZD / 60 > 0) {
                    cA = cA + getResources().getString(2131235361, new Object[]{Integer.valueOf(this.boL.jZD / 60)});
                }
                if (this.boL.jZD % 60 > 0) {
                    cA = cA + getResources().getString(2131235362, new Object[]{Integer.valueOf(this.boL.jZD % 60)});
                }
                this.fQK.setText(cA + getResources().getString(2131235360));
                this.fQK.setVisibility(0);
                this.fQK.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsSightPlayerUI jSZ;

                    {
                        this.jSZ = r1;
                    }

                    public final void onClick(View view) {
                        if (this.jSZ.jSW.qC(32)) {
                            j.a(j.b.Sight, j.a.EnterCompleteVideo, this.jSZ.jSW);
                        }
                        Intent intent = new Intent();
                        String cA = al.cA(ad.xh(), this.jSZ.boL.gID);
                        String j = i.j(this.jSZ.boL);
                        intent.setClass(this.jSZ, VideoAdPlayerUI.class);
                        intent.putExtra("KFullVideoPath", cA + j);
                        intent.putExtra("KThumbPath", this.jSZ.imagePath);
                        intent.putExtra("IsAd", true);
                        intent.putExtra("KStremVideoUrl", this.jSZ.boL.mHW);
                        intent.putExtra("KThumUrl", be.kS(this.jSZ.boL.mHZ) ? this.jSZ.boL.mHP : this.jSZ.boL.mHZ);
                        intent.putExtra("KMediaId", this.jSZ.boL.gID);
                        intent.putExtra("KUrl", this.jSZ.boL.glb);
                        intent.putExtra("KViewId", this.jSZ.jSW.aUQ());
                        azr aUp = this.jSZ.jSW.aUp();
                        String str = "KSta_StremVideoAduxInfo";
                        if (this.jSZ.jSW.aUo() == null) {
                            cA = "";
                        } else {
                            cA = this.jSZ.jSW.aUo().jpt;
                        }
                        intent.putExtra(str, cA);
                        intent.putExtra("KSta_StremVideoPublishId", aUp.gID);
                        intent.putExtra("KSta_SourceType", 1);
                        intent.putExtra("KSta_Scene", j.b.Sight.value);
                        intent.putExtra("KSta_FromUserName", aUp.gln);
                        intent.putExtra("KSta_SnSId", aUp.gID);
                        intent.putExtra("KSta_SnsStatExtStr", aUp.jGu);
                        intent.putExtra("KMediaVideoTime", this.jSZ.boL.jZD);
                        intent.putExtra("KMediaTitle", be.kS(this.jSZ.boL.mIa) ? aUp.mWn : this.jSZ.boL.mIa);
                        com.tencent.mm.plugin.sns.storage.b aUm = this.jSZ.jSW.aUm();
                        if (aUm != null && aUm.juw == 0) {
                            intent.putExtra("StreamWording", aUm.jux);
                            intent.putExtra("StremWebUrl", aUm.juy);
                        }
                        k Bq = ad.aSE().Bq(this.jSZ.bde);
                        com.tencent.mm.modelsns.a gh = this.jSZ.scene == 0 ? com.tencent.mm.modelsns.a.gh(747) : com.tencent.mm.modelsns.a.gi(747);
                        gh.kj(i.g(Bq)).gk(Bq.field_type).bg(true).kj(Bq.aUR()).gk(this.jSZ.boL.jZD);
                        gh.JF();
                        gh = this.jSZ.scene == 0 ? com.tencent.mm.modelsns.a.gh(748) : com.tencent.mm.modelsns.a.gi(748);
                        gh.kj(i.g(Bq)).gk(Bq.field_type).bg(true).kj(Bq.aUR()).gk(this.jSZ.boL.jZD);
                        gh.b(intent, "intent_key_StatisticsOplog");
                        this.jSZ.startActivity(intent);
                        ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jSZ.jSW.aUQ(), 14, 5, "", 2), 0);
                        if (this.jSZ.scene == 0) {
                            ng ngVar = new ng();
                            ngVar.boz.bhY = true;
                            com.tencent.mm.sdk.c.a.nhr.z(ngVar);
                        }
                    }
                });
            }
            com.tencent.mm.pluginsdk.ui.tools.n.a(this.fQK, (VideoSightView) this.eJz);
        } else {
            this.fQK.setVisibility(8);
        }
        this.eJz.a(new com.tencent.mm.pluginsdk.ui.tools.g.a(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final void abH() {
                v.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.sl() + " onPrepared");
                this.jSZ.fC(true);
            }

            public final void bp(int i, int i2) {
                v.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.jSZ.eJz.stop();
                if (!this.jSZ.fQL) {
                    this.jSZ.fQL = true;
                    com.tencent.mm.sdk.b.b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.aOU() + "[SnsSightPlayerUI] on play video error, what " + i + " extra " + i2 + ", path=" + be.ah(this.jSZ.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                    final String c = this.jSZ.imagePath;
                    final Bitmap a = com.tencent.mm.ae.n.GH().a(c, com.tencent.mm.bd.a.getDensity(this.jSZ.nDR.nEl), this.jSZ.nDR.nEl, -1);
                    com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 jTd;

                        public final void run() {
                            ImageView imageView = (ImageView) this.jTd.jSZ.findViewById(2131756999);
                            if (imageView != null) {
                                imageView.setImageBitmap(a);
                                imageView.setVisibility(0);
                            }
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.fromFile(new File(c)), "video/*");
                            try {
                                this.jTd.jSZ.nDR.nEl.startActivity(Intent.createChooser(intent, this.jTd.jSZ.nDR.nEl.getString(2131232752)));
                            } catch (Exception e) {
                                v.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                                com.tencent.mm.ui.base.g.f(this.jTd.jSZ.nDR.nEl, 2131232691, 2131232692);
                            }
                        }
                    });
                }
            }

            public final void pa() {
                v.d("MicroMsg.SnsSightPlayerUI", "on completion");
                if (!this.jSZ.jdE) {
                    this.jSZ.iVo.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 jTd;

                        {
                            this.jTd = r1;
                        }

                        public final void run() {
                            if (this.jTd.jSZ.iVo.getVisibility() != 0) {
                                this.jTd.jSZ.iVo.setVisibility(0);
                                this.jTd.jSZ.iVo.startAnimation(AnimationUtils.loadAnimation(this.jTd.jSZ.nDR.nEl, 2130968622));
                            }
                        }
                    });
                }
                this.jSZ.eJz.fD(true);
                com.tencent.mm.plugin.sns.a.a.a.a aVar = this.jSZ.jSS.jcB;
                aVar.jdw++;
                this.jSZ.fC(false);
            }

            public final int bq(int i, int i2) {
                return 0;
            }

            public final void br(int i, int i2) {
            }
        });
        findViewById(2131756998).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final void onClick(View view) {
                this.jSZ.abE();
            }
        });
        ((View) this.eJz).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final void onClick(View view) {
                this.jSZ.abE();
            }
        });
        this.fjR = new GestureDetector(this.nDR.nEl, new SimpleOnGestureListener(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float translationX = (((View) this.jSZ.eJz).getTranslationX() + motionEvent2.getX()) - motionEvent.getX();
                float translationY = (((View) this.jSZ.eJz).getTranslationY() + motionEvent2.getY()) - motionEvent.getY();
                if (this.jSZ.jRp) {
                    ((View) this.jSZ.eJz).setTranslationX(translationX);
                    ((View) this.jSZ.eJz).setTranslationY(translationY);
                }
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                this.jSZ.jRr = true;
                super.onLongPress(motionEvent);
            }
        });
        ((View) this.eJz).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 1.0f;
                this.jSZ.fjR.onTouchEvent(motionEvent);
                if (this.jSZ.fj == null) {
                    this.jSZ.fj = VelocityTracker.obtain();
                }
                this.jSZ.fj.addMovement(motionEvent);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.jSZ.gpp = motionEvent.getX();
                        this.jSZ.jRo = motionEvent.getY();
                        break;
                    case 1:
                        if (this.jSZ.jRq) {
                            ((View) this.jSZ.eJz).setPivotX((float) (this.jSZ.iVC.getWidth() / 2));
                            ((View) this.jSZ.eJz).setPivotY((float) (this.jSZ.iVC.getHeight() / 2));
                            ((View) this.jSZ.eJz).setScaleX(1.0f);
                            ((View) this.jSZ.eJz).setScaleY(1.0f);
                            ((View) this.jSZ.eJz).setTranslationX(0.0f);
                            ((View) this.jSZ.eJz).setTranslationY(0.0f);
                            SnsSightPlayerUI snsSightPlayerUI = this.jSZ;
                            if (snsSightPlayerUI.eyZ == null) {
                                snsSightPlayerUI.eyZ = new l(snsSightPlayerUI.nDR.nEl);
                            }
                            snsSightPlayerUI.eyZ.a((View) snsSightPlayerUI.eJz, snsSightPlayerUI.jRs, snsSightPlayerUI.hkn);
                            if (this.jSZ.fQK != null) {
                                this.jSZ.fQK.setVisibility(0);
                            }
                            this.jSZ.jRp = false;
                            this.jSZ.jRr = false;
                            break;
                        } else if (!this.jSZ.jRp || this.jSZ.jRr) {
                            this.jSZ.jRr = false;
                            break;
                        } else {
                            this.jSZ.abE();
                            this.jSZ.jRr = false;
                            return true;
                        }
                        break;
                    case 2:
                        float translationX = ((View) this.jSZ.eJz).getTranslationX();
                        float translationY = ((View) this.jSZ.eJz).getTranslationY();
                        VelocityTracker n = this.jSZ.fj;
                        n.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT);
                        int xVelocity = (int) n.getXVelocity();
                        int yVelocity = (int) n.getYVelocity();
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || this.jSZ.jRr) && !this.jSZ.jRp) {
                            this.jSZ.jRp = false;
                        } else {
                            float height = 1.0f - (translationY / ((float) this.jSZ.iVC.getHeight()));
                            if (height <= 1.0f) {
                                f = height;
                            }
                            if (((yVelocity > 0 && f < this.jSZ.jMj) || yVelocity < 0) && ((double) f) >= 0.5d) {
                                this.jSZ.jMk = (int) translationX;
                                this.jSZ.jMl = (int) translationY;
                                this.jSZ.jMj = f;
                                if (this.jSZ.fQK != null) {
                                    this.jSZ.fQK.setVisibility(8);
                                }
                                ((View) this.jSZ.eJz).setPivotX((float) (this.jSZ.iVC.getWidth() / 2));
                                ((View) this.jSZ.eJz).setPivotY((float) (this.jSZ.iVC.getHeight() / 2));
                                ((View) this.jSZ.eJz).setScaleX(f);
                                ((View) this.jSZ.eJz).setScaleY(f);
                                this.jSZ.jKJ.setAlpha(f);
                            }
                            this.jSZ.jRp = true;
                        }
                        if (translationY > 200.0f) {
                            this.jSZ.jRq = false;
                        } else if (translationY > 10.0f) {
                            this.jSZ.jRq = true;
                        }
                        if (translationY > 50.0f) {
                            ((View) this.jSZ.eJz).setOnLongClickListener(null);
                        }
                        if (this.jSZ.fj != null) {
                            this.jSZ.fj.recycle();
                            this.jSZ.fj = null;
                        }
                        if (this.jSZ.jRp) {
                            return true;
                        }
                        break;
                }
                return false;
            }
        });
        if (FileOp.aR(this.cPu)) {
            if (this.cPu != null) {
                this.eJz.stop();
                this.eJz.setVideoPath(this.cPu);
            }
            this.jSV.setVisibility(8);
            this.jSS.jcx = 1;
        } else {
            ad.aSz().a(this.boL, 6, null, com.tencent.mm.storage.ak.nvx);
            this.jSV.setVisibility(0);
            this.jSV.bKj();
            this.jSS.jcx = 0;
        }
        v.d("MicroMsg.SnsSightPlayerUI", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        pn pnVar = new pn();
        pnVar.bqP.type = 1;
        com.tencent.mm.sdk.c.a.nhr.z(pnVar);
        if (this.eyZ == null) {
            this.eyZ = new l(this.nDR.nEl);
        }
        this.eyZ.a((View) this.eJz, this.jRs, this.hkn);
        ((View) this.eJz).post(new Runnable(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.jSZ.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (this.jSZ.eJz instanceof VideoSightView) {
                    ((VideoSightView) this.jSZ.eJz).pv(displayMetrics.widthPixels);
                }
                ((View) this.jSZ.eJz).requestLayout();
                ((View) this.jSZ.eJz).postInvalidate();
            }
        });
    }

    public void finish() {
        if (!this.cvW) {
            super.finish();
            this.cvW = true;
        }
    }

    private void fC(boolean z) {
        this.eJz.start();
        this.duration = this.eJz.getDuration();
        v.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
        this.iVr.a(this);
        if (z) {
            this.jSS.jcB.jdA = getResources().getConfiguration().orientation == 2 ? 2 : 1;
            this.jSS.jcB.jdB = be.Nj();
            this.jSS.jcB.jdz = 2;
        }
    }

    private void aPy() {
        v.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
        this.eJz.pause();
        this.eJz.onDetach();
        this.iVr.aN(false);
    }

    protected final int getLayoutId() {
        return 2130904492;
    }

    public void onDestroy() {
        boolean z = true;
        super.onDestroy();
        if (this.jdE) {
            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.d(this.jSW.aUQ(), this.scene == 0 ? 1 : 2, this.jSS.jcy, null, null, 2, this.jSS.aQV()), 0);
        }
        v.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
        if (this.jdE && this.jSW != null && this.jSW.qC(32)) {
            j.a(j.b.Sight, j.a.LeavelFullScreen, this.jSW);
        }
        ad.aSz().b((b) this);
        com.tencent.mm.modelsns.a m = com.tencent.mm.modelsns.a.m(getIntent());
        if (m != null) {
            if (this.jdE) {
                if (be.kS(this.boL.mHW)) {
                    z = false;
                }
                m.bg(z);
            } else {
                m.bg(false);
            }
            m.update();
            m.JF();
        }
        if (ak.oJ() != null) {
            ak.oJ().pT();
        }
        if (this.eJz != null) {
            this.eJz.a(null);
            this.eJz.stop();
            this.eJz.onDetach();
        }
        if (!this.iVp) {
            pn pnVar = new pn();
            pnVar.bqP.type = 0;
            pnVar.bqP.bqQ = this.iUu;
            pnVar.bqP.bqR = this.fNz;
            pnVar.bqP.bqS = this.bqS;
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
        }
        this.iVr.aN(false);
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
                    this.iVC.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ SnsSightPlayerUI jSZ;

                        {
                            this.jSZ = r1;
                        }

                        public final boolean onPreDraw() {
                            this.jSZ.iVC.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.jSZ.eIY.a(this.jSZ.iVC, this.jSZ.jKJ, null);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (!this.isInit) {
            v.i("MicroMsg.SnsSightPlayerUI", "initOrientation " + getResources().getConfiguration().orientation);
            if (getResources().getConfiguration().orientation == 2) {
                L(getResources().getConfiguration().orientation, true);
            }
            this.isInit = true;
        }
        if (this.iVL == 0 || this.iVK == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.iVL = displayMetrics.heightPixels;
            this.iVK = displayMetrics.widthPixels;
        }
        if (this.jRn && FileOp.aR(this.cPu)) {
            fC(false);
            this.jRn = false;
        }
    }

    public void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        v.i("MicroMsg.SnsSightPlayerUI", "onpause  " + i);
        re(i);
        if (this.jRn) {
            aPy();
            return;
        }
        aPy();
        v.v("check", "onclick");
        new ac().post(new Runnable(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final void run() {
                this.jSZ.finish();
            }
        });
    }

    public final void abE() {
        int width = this.iVC.getWidth();
        int height = this.iVC.getHeight();
        if (!(this.eJb == 0 || this.eJc == 0)) {
            height = (int) ((((float) width) / ((float) this.eJb)) * ((float) this.eJc));
        }
        this.eIY.du(width, height);
        this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
        if (((double) this.jMj) != 1.0d) {
            width = w.en(this.nDR.nEl);
            this.eIY.oSK = 1.0f / this.jMj;
            if (!(this.jMk == 0 && this.jMl == 0)) {
                this.eIY.dv(((int) (((float) (this.iVC.getWidth() / 2)) * (1.0f - this.jMj))) + this.jMk, (int) ((((float) ((width + this.iVC.getHeight()) / 2)) - (((float) (height / 2)) * this.jMj)) + ((float) this.jMl)));
            }
        }
        this.eIY.a(this.iVC, this.jKJ, new g.b(this) {
            final /* synthetic */ SnsSightPlayerUI jSZ;

            {
                this.jSZ = r1;
            }

            public final void onAnimationStart() {
                if (this.jSZ.fQK != null) {
                    this.jSZ.fQK.setVisibility(8);
                }
            }

            public final void onAnimationEnd() {
                new ac().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 jTa;

                    {
                        this.jTa = r1;
                    }

                    public final void run() {
                        this.jTa.jSZ.finish();
                        this.jTa.jSZ.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    public void onBackPressed() {
        abE();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : be.g(stringExtra.split(","))) {
                    if (this.scene == 0) {
                        k Bq = ad.aSE().Bq(this.bde);
                        if (Bq != null) {
                            if (m.dE(str)) {
                                no noVar = new no();
                                noVar.boH.boC = i.g(Bq);
                                noVar.boH.bap = Bq.aUL();
                                com.tencent.mm.sdk.c.a.nhr.z(noVar);
                            } else {
                                np npVar = new np();
                                npVar.boI.boC = i.g(Bq);
                                npVar.boI.bap = Bq.aUL();
                                com.tencent.mm.sdk.c.a.nhr.z(npVar);
                            }
                        }
                    }
                    azr aUp = this.jSW.aUp();
                    if (this.jdE) {
                        com.tencent.mm.plugin.sns.storage.b aUm = this.jSW.aUm();
                        ayk com_tencent_mm_protocal_c_ayk = new ayk();
                        com_tencent_mm_protocal_c_ayk.mtD = this.boL.jZD;
                        com_tencent_mm_protocal_c_ayk.cqg = this.boL.mHW;
                        if (aUp.mWq.mol == 15) {
                            com_tencent_mm_protocal_c_ayk.cqm = this.jSW.aUo().jpt;
                            com_tencent_mm_protocal_c_ayk.cqn = aUp.gID;
                        } else {
                            com_tencent_mm_protocal_c_ayk.cqm = aUp.mWv.cqm;
                            com_tencent_mm_protocal_c_ayk.cqn = aUp.mWv.cqn;
                        }
                        com_tencent_mm_protocal_c_ayk.cqi = be.kS(this.boL.mIa) ? aUp.mWn : this.boL.mIa;
                        if (be.kS(this.boL.mHZ)) {
                            stringExtra = this.boL.mHP;
                        } else {
                            stringExtra = this.boL.mHZ;
                        }
                        com_tencent_mm_protocal_c_ayk.cql = stringExtra;
                        if (aUm != null && aUm.juw == 0) {
                            com_tencent_mm_protocal_c_ayk.cqk = aUm.juy;
                            com_tencent_mm_protocal_c_ayk.cqj = aUm.jux;
                        }
                        com_tencent_mm_protocal_c_ayk.cqk = aUm.jue;
                        v.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[]{str, this.cPu, this.imagePath, this.boL.mHW, Integer.valueOf(this.boL.jZD), com_tencent_mm_protocal_c_ayk.cql, Integer.valueOf(i.zZ(this.cPu))});
                        com.tencent.mm.pluginsdk.j.a.bmt().a(this, str, this.cPu, this.imagePath, 43, r7, com_tencent_mm_protocal_c_ayk, false, false, aUp.jGu);
                    } else {
                        v.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[]{str, this.cPu, this.imagePath, Integer.valueOf(i.zZ(this.cPu))});
                        com.tencent.mm.pluginsdk.j.a.bmt().a(this, str, this.cPu, this.imagePath, 43, r7, aUp.jGu);
                    }
                    if (stringExtra2 != null) {
                        com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra2, str);
                    }
                    com.tencent.mm.ui.snackbar.a.f(this, getString(2131233278));
                    if (this.jdE) {
                        j.c cVar;
                        int el;
                        ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jSW.aUQ(), 12, 5, "", 2), 0);
                        boolean dE = m.dE(str);
                        j.d dVar = j.d.Sight;
                        if (dE) {
                            cVar = j.c.Chatroom;
                        } else {
                            cVar = j.c.Chat;
                        }
                        e eVar = e.Full;
                        if (dE) {
                            el = com.tencent.mm.model.i.el(str);
                        } else {
                            el = 0;
                        }
                        j.a(dVar, cVar, eVar, el, this.jSW);
                    }
                }
            } else if (this.jdE) {
                ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jSW.aUQ(), 13, 5, "", 2), 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void Aa(String str) {
    }

    public final void ai(String str, boolean z) {
    }

    public final void aRc() {
    }

    public final void aj(String str, boolean z) {
        v.i("MicroMsg.SnsSightPlayerUI", "onSightFinish " + str);
        if (this.jdE && !be.kS(str) && this.boL != null && str.equals(this.boL.gID) && FileOp.aR(this.cPu)) {
            this.jSS.jcx = 1;
            this.eJz.setVideoPath(this.cPu);
            fC(true);
            if (this.jSV != null) {
                this.jSV.setVisibility(8);
            }
        }
    }

    protected final int NO() {
        return 7;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + configuration.orientation + " " + this.iVR);
        if (this.iVR != configuration.orientation) {
            int i = configuration.orientation;
            L(configuration.orientation, false);
            this.iVR = configuration.orientation;
        }
    }

    private void L(int i, boolean z) {
        if (this.iVL == 0 || this.iVK == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.iVL = displayMetrics.heightPixels;
            this.iVK = displayMetrics.widthPixels;
        }
        LayoutParams layoutParams = this.iVC.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jSU.getLayoutParams();
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (i == 1) {
            layoutParams3.width = this.iVK;
            layoutParams3.height = (int) (((((double) this.iVK) * 1.0d) * 240.0d) / 320.0d);
            layoutParams2.addRule(12, 0);
            layoutParams2.addRule(1, 0);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(3, this.iVC.getId());
            findViewById(2131757003).setVisibility(0);
        } else {
            layoutParams3.height = this.iVK;
            layoutParams3.width = (int) (((((double) this.iVK) * 1.0d) * 320.0d) / 240.0d);
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(1, this.iVC.getId());
            findViewById(2131757003).setVisibility(8);
        }
        v.i("MicroMsg.SnsSightPlayerUI", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.eJz).setLayoutParams(layoutParams3);
        if (this.eJz instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.eJz).co(layoutParams3.width, layoutParams3.height);
        }
        layoutParams.height = layoutParams3.height;
        layoutParams.width = layoutParams3.width;
        this.iVo.setLayoutParams(layoutParams2);
        this.iVC.setLayoutParams(layoutParams);
        ((View) this.eJz).requestLayout();
        if (!z) {
            re(i);
        }
    }

    private void re(int i) {
        if (this.jdE && this.eJz.isPlaying()) {
            if (this.duration == 0) {
                this.duration = this.eJz.getDuration();
            }
            this.jSS.pP(this.duration);
            this.jSS.jcB.jdB = be.Nj();
            this.jSS.jcB.jdA = i == 2 ? 2 : 1;
            this.jSS.jcB.jdz = 2;
            v.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.jSS.jcB.jdA);
        }
    }
}
