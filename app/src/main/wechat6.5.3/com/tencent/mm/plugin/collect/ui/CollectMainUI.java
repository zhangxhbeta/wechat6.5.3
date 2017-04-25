package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.collect.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.LinkedList;
import java.util.List;

public class CollectMainUI extends WalletPreferenceUI implements com.tencent.mm.plugin.collect.b.a.a {
    private static int eXk;
    private static int eXn = -1;
    private static int eXo = -1;
    private static int eXp = -1;
    private static int eXq = -1;
    private Vibrator eWH;
    private TextView eWI = null;
    private ImageView eWJ = null;
    private ImageView eWK = null;
    private TextView eWL = null;
    private TextView eWM = null;
    private TextView eWN = null;
    private TextView eWO = null;
    private View eWP = null;
    private TextView eWQ = null;
    private Dialog eWR = null;
    private View eWS = null;
    private View eWT = null;
    private View eWU = null;
    private boolean eWV = false;
    private View eWW = null;
    private ImageView eWX;
    private TextView eWY;
    private TextView eWZ;
    private Bitmap eXa = null;
    private String eXb = null;
    private String eXc = null;
    private boolean eXd = true;
    private List<a> eXe = new LinkedList();
    private double eXf;
    private String eXg = null;
    private String eXh = null;
    private boolean eXi = false;
    private long eXj;
    private View eXl;
    private b eXm = new b();
    private f ezq = null;

    private class b {
        final /* synthetic */ CollectMainUI eXr;
        boolean eXw;
        LinkedList<a> eXx;

        private b(CollectMainUI collectMainUI) {
            this.eXr = collectMainUI;
            this.eXx = new LinkedList();
        }

        public final void aem() {
            if (this.eXw) {
                v.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.eXx.size());
            } else if (!this.eXx.isEmpty()) {
                final a aVar = (a) this.eXx.poll();
                this.eXw = true;
                this.eXr.aef();
                this.eXr.eWW.setLayoutParams(new LayoutParams(this.eXr.eWS.getWidth(), this.eXr.eWS.getHeight()));
                if (this.eXr.eXi) {
                    this.eXr.eWW.setPadding(0, CollectMainUI.eXq, 0, 0);
                } else {
                    this.eXr.eWW.setPadding(0, CollectMainUI.eXp, 0, 0);
                }
                this.eXr.eWY.setText(e.a(this.eXr.nDR.nEl, aVar.caJ, this.eXr.eWY.getTextSize()));
                com.tencent.mm.pluginsdk.ui.a.b.m(this.eXr.eWX, aVar.username);
                this.eXr.eWZ.setText(com.tencent.mm.wallet_core.ui.e.d(aVar.eWz, aVar.cpl));
                this.eXr.eWW.setVisibility(0);
                final AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
                int i = 0;
                for (int i2 = 0; i2 < this.eXr.eXe.size(); i2++) {
                    if (((a) this.eXr.eXe.get(i2)).eWA.equals(aVar.eWA)) {
                        i = i2;
                    }
                }
                float aeh = (float) CollectMainUI.eXn;
                float height = 0.0f + ((float) (this.eXr.eWS.getHeight() / 2));
                if (this.eXr.eWP.getVisibility() == 0) {
                    height += (float) this.eXr.eWP.getHeight();
                }
                height += (float) ((i * CollectMainUI.eXo) + (CollectMainUI.eXo / 2));
                int[] iArr = new int[2];
                this.eXr.eWS.getLocationInWindow(iArr);
                animationSet.addAnimation(new TranslateAnimation(0.0f, aeh, 0.0f, (float) ((int) (height + ((float) (iArr[1] - CollectMainUI.eXk))))));
                animationSet.setDuration(300);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ b eXz;

                    public final void onAnimationEnd(Animation animation) {
                        this.eXz.eXr.eWW.setVisibility(8);
                        v.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + aVar.eWA);
                        for (int i = 0; i < this.eXz.eXr.eXe.size(); i++) {
                            if (((a) this.eXz.eXr.eXe.get(i)).eWA.equals(aVar.eWA)) {
                                ((a) this.eXz.eXr.eXe.get(i)).eIX = true;
                                v.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + aVar.eWA);
                                break;
                            }
                        }
                        this.eXz.eXr.aef();
                        this.eXz.eXw = false;
                        this.eXz.aem();
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(300);
                scaleAnimation.setInterpolator(new LinearInterpolator());
                scaleAnimation.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ b eXz;

                    public final void onAnimationEnd(Animation animation) {
                        animationSet.setStartOffset(1700);
                        this.eXz.eXr.eWW.startAnimation(animationSet);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                        this.eXz.eXr.eWW.setVisibility(0);
                    }
                });
                this.eXr.eWW.startAnimation(scaleAnimation);
            }
        }
    }

    class a extends c {
        public boolean eIX = false;
        final /* synthetic */ CollectMainUI eXr;

        public a(CollectMainUI collectMainUI, c cVar) {
            this.eXr = collectMainUI;
            this.username = cVar.username;
            this.eWA = cVar.eWA;
            this.eWz = cVar.eWz;
            this.eWB = cVar.eWB;
            this.scene = cVar.scene;
            this.status = cVar.status;
            this.caJ = cVar.caJ;
        }
    }

    static /* synthetic */ boolean d(CollectMainUI collectMainUI) {
        if (collectMainUI.eXa == null || collectMainUI.eXa.isRecycled()) {
            return false;
        }
        int i;
        if (collectMainUI.eXi) {
            g.iuh.h(11343, new Object[]{Integer.valueOf(1), Integer.valueOf((int) Math.round(collectMainUI.eXf * 100.0d))});
        } else {
            g.iuh.h(11343, new Object[]{Integer.valueOf(0)});
        }
        if (collectMainUI.eWV) {
            i = 0;
        } else {
            collectMainUI.eWU = ((ViewStub) collectMainUI.findViewById(2131756366)).inflate();
            collectMainUI.eWV = true;
            i = 250;
        }
        collectMainUI.eWU.setVisibility(4);
        ((ImageView) collectMainUI.eWU.findViewById(2131756389)).setImageBitmap(collectMainUI.eXa);
        a((ImageView) collectMainUI.eWU.findViewById(2131756391));
        TextView textView = (TextView) collectMainUI.eWU.findViewById(2131756392);
        textView.setText(e.a(collectMainUI, collectMainUI.getString(2131234481, new Object[]{com.tencent.mm.wallet_core.ui.e.er(k.xF())}), textView.getTextSize()));
        textView = (TextView) collectMainUI.eWU.findViewById(2131756393);
        TextView textView2 = (TextView) collectMainUI.eWU.findViewById(2131756394);
        if (collectMainUI.eXi) {
            if (be.kS(collectMainUI.eXh)) {
                textView.setVisibility(8);
            } else {
                textView.setText(collectMainUI.eXh);
                textView.setVisibility(0);
            }
            textView2.setText(com.tencent.mm.wallet_core.ui.e.d(collectMainUI.eXf, collectMainUI.eXg));
            textView2.setVisibility(0);
        } else {
            textView.setVisibility(8);
            textView2.setVisibility(8);
        }
        ad.g(new Runnable(collectMainUI) {
            final /* synthetic */ CollectMainUI eXr;

            {
                this.eXr = r1;
            }

            public final void run() {
                Bitmap createBitmap = Bitmap.createBitmap(this.eXr.eWU.getWidth(), this.eXr.eWU.getHeight(), Config.ARGB_8888);
                this.eXr.eWU.draw(new Canvas(createBitmap));
                try {
                    String str = l.bqT() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                    d.a(createBitmap, 100, CompressFormat.PNG, str, false);
                    Toast.makeText(this.eXr.nDR.nEl, this.eXr.getString(2131232244, new Object[]{str}), 1).show();
                    l.c(str, this.eXr.nDR.nEl);
                } catch (Exception e) {
                    v.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + e.getMessage());
                }
                this.eXr.eWU.setVisibility(8);
            }
        }, (long) i);
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        cU().cV().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131689474)));
        View customView = cU().cV().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131755264);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(2131689783));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(2131690127));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(2131689477));
        }
        ak.yW();
        boolean equals = ((String) com.tencent.mm.model.c.vf().get(327731, "0")).equals("0");
        overridePendingTransition(2130968680, 2130968677);
        if (equals) {
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, k.xT() ? 2131231951 : 2131231950, 2131231952, new OnClickListener(this) {
                final /* synthetic */ CollectMainUI eXr;

                {
                    this.eXr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            ak.yW();
            com.tencent.mm.model.c.vf().set(327731, "1");
            ak.yW();
            com.tencent.mm.model.c.vf().iB(true);
        }
        this.eXb = getIntent().getStringExtra("ftf_pay_url");
        this.eXd = getIntent().getBooleanExtra("ftf_can_set_amount", true);
        v.i("MicroMsg.CollectMainUI", "ftfpayurl null & try to get userinfo");
        final ql qlVar = new ql();
        qlVar.bpT = new Runnable(this) {
            final /* synthetic */ CollectMainUI eXr;

            public final void run() {
                v.i("MicroMsg.CollectMainUI", "Get user info suc");
                com.tencent.mm.e.a.ql.b bVar = qlVar.brL;
                if (bVar.errCode == 0 && !be.kS(bVar.brQ)) {
                    this.eXr.eXb = bVar.brQ;
                    if (this.eXr.eWR != null) {
                        this.eXr.eWR.dismiss();
                    }
                    this.eXr.acO();
                } else if (bVar.errCode != 0) {
                    v.e("MicroMsg.CollectMainUI", "Get user info fail, errcode=" + bVar.errCode);
                    String str = bVar.biS;
                    if (be.kS(str)) {
                        str = this.eXr.getString(2131236155);
                    }
                    com.tencent.mm.ui.base.g.a(this.eXr.nDR.nEl, str, null, false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass5 eXt;

                        {
                            this.eXt = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.eXt.eXr.finish();
                        }
                    });
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(qlVar, Looper.myLooper());
        this.eWR = com.tencent.mm.wallet_core.ui.g.a(this, false, new OnCancelListener(this) {
            final /* synthetic */ CollectMainUI eXr;

            {
                this.eXr = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.eXr.eWR != null) {
                    this.eXr.eWR.dismiss();
                }
            }
        });
        com.tencent.mm.plugin.collect.a.a.aeb();
        com.tencent.mm.plugin.collect.b.a aec = com.tencent.mm.plugin.collect.a.a.aec();
        if (!aec.eAR.contains(this)) {
            aec.eAR.add(this);
        }
        NI();
        this.eWH = (Vibrator) getSystemService("vibrator");
        this.eXj = be.Nh();
        if (eXn < 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            eXn = (displayMetrics.widthPixels / 2) - com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.nDR.nEl, 20.0f);
            eXo = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.nDR.nEl, 60.0f);
            eXp = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.nDR.nEl, 40.0f);
            eXq = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.nDR.nEl, 70.0f);
        }
        n.dB(16, 0);
    }

    protected void onDestroy() {
        if (this.eWJ != null) {
            this.eWJ.setImageBitmap(null);
        }
        Bitmap bitmap = this.eXa;
        if (!(bitmap == null || bitmap.isRecycled())) {
            v.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        if (this.eWR != null) {
            this.eWR.dismiss();
        }
        com.tencent.mm.plugin.collect.a.a.aeb();
        com.tencent.mm.plugin.collect.a.a.aec().eAR.remove(this);
        this.eWH.cancel();
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131231965);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CollectMainUI eXr;

            {
                this.eXr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eXr.finish();
                return true;
            }
        });
        aeg();
        this.ezq = this.ocZ;
        this.eWP = findViewById(2131756384);
        this.eWI = (TextView) findViewById(2131756379);
        this.eWM = (TextView) findViewById(2131756377);
        this.eWL = (TextView) findViewById(2131756378);
        this.eWN = (TextView) findViewById(2131756385);
        this.eWS = (RelativeLayout) findViewById(2131756374);
        this.eWT = findViewById(2131756386);
        this.eXl = LayoutInflater.from(this).inflate(2130903386, null, false);
        this.eWO = (TextView) this.eXl.findViewById(2131756372);
        this.eWO.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CollectMainUI eXr;

            {
                this.eXr = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.pluginsdk.wallet.e.L(this.eXr.nDR.nEl, 0);
            }
        });
        this.gMx.addFooterView(this.eXl, null, false);
        this.gMx.setFooterDividersEnabled(false);
        this.eWJ = (ImageView) findViewById(2131756381);
        this.eWK = (ImageView) findViewById(2131756383);
        this.eWQ = (TextView) findViewById(2131756375);
        a(this.eWK);
        this.eWJ.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ CollectMainUI eXr;

            {
                this.eXr = r1;
            }

            public final boolean onLongClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.eXr.getString(2131231959));
                linkedList2.add(Integer.valueOf(0));
                com.tencent.mm.ui.base.g.a(this.eXr.nDR.nEl, this.eXr.getString(2131231960), linkedList, linkedList2, null, true, new com.tencent.mm.ui.base.g.d(this) {
                    final /* synthetic */ AnonymousClass9 eXu;

                    {
                        this.eXu = r1;
                    }

                    public final void bw(int i, int i2) {
                        switch (i2) {
                            case 0:
                                if (this.eXu.eXr.eXa == null || this.eXu.eXr.eXa.isRecycled()) {
                                    v.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
                                    Toast.makeText(this.eXu.eXr.nDR.nEl, this.eXu.eXr.getString(2131231963), 1).show();
                                } else if (!CollectMainUI.d(this.eXu.eXr)) {
                                    Toast.makeText(this.eXu.eXr.nDR.nEl, this.eXu.eXr.getString(2131231963), 1).show();
                                }
                                this.eXu.eXr.ocZ.notifyDataSetChanged();
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.eWW = findViewById(2131756368);
        this.eWX = (ImageView) findViewById(2131756369);
        this.eWY = (TextView) findViewById(2131756370);
        this.eWZ = (TextView) findViewById(2131756371);
        acO();
        this.eWS.postDelayed(new Runnable(this) {
            final /* synthetic */ CollectMainUI eXr;

            {
                this.eXr = r1;
            }

            public final void run() {
                int[] iArr = new int[2];
                this.eXr.eWS.getLocationInWindow(iArr);
                CollectMainUI.eXk = iArr[1];
            }
        }, 300);
        final qk qkVar = new qk();
        qkVar.brG.brI = "8";
        qkVar.bpT = new Runnable(this) {
            final /* synthetic */ CollectMainUI eXr;

            public final void run() {
                if (be.kS(qkVar.brH.brJ)) {
                    v.i("MicroMsg.CollectMainUI", "no bulletin data");
                } else {
                    com.tencent.mm.wallet_core.ui.e.a((TextView) this.eXr.findViewById(2131756367), qkVar.brH.brJ, qkVar.brH.content, qkVar.brH.url);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qkVar);
    }

    private void acO() {
        if (be.kS(this.eXb)) {
            v.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
            return;
        }
        aeg();
        aee();
        aef();
        am bfP = com.tencent.mm.plugin.wallet_core.model.f.bfP();
        int i = this.eXi ? 33 : 32;
        if (bfP != null) {
            g.iuh.h(13447, new Object[]{Integer.valueOf(i), bfP.maR, bfP.maS, this.eXb, Double.valueOf(this.eXf), Long.valueOf(be.Nh()), Long.valueOf(bfP.maQ)});
        }
    }

    private void aee() {
        this.eWJ.setImageBitmap(null);
        this.eWK.setVisibility(8);
        if (this.eXi) {
            if (be.kS(this.eXc)) {
                v.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
                return;
            }
            this.eXa = com.tencent.mm.bb.a.a.b(this, this.eXc, 0, 3);
        } else if (be.kS(this.eXb)) {
            v.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
            return;
        } else {
            this.eXa = com.tencent.mm.bb.a.a.b(this, this.eXb, 0, 3);
        }
        if (this.eXa == null || this.eXa.isRecycled()) {
            this.eWK.setVisibility(8);
            v.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + be.ma(this.eXc));
        } else {
            this.eWJ.setImageBitmap(this.eXa);
            this.eWK.setVisibility(0);
        }
        if (this.eXi) {
            this.eWM.setText(com.tencent.mm.wallet_core.ui.e.d(this.eXf, this.eXg));
            this.eWM.setVisibility(0);
            if (be.kS(this.eXh)) {
                this.eWL.setVisibility(8);
                return;
            }
            this.eWL.setText(this.eXh);
            this.eWL.setVisibility(0);
            return;
        }
        this.eWM.setVisibility(8);
        this.eWL.setVisibility(8);
    }

    private static void a(ImageView imageView) {
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, k.xF(), 0.06f, false);
    }

    private void aef() {
        double d;
        if (this.eXe == null || this.eXe.size() <= 0) {
            d = 0.0d;
        } else {
            this.eWS.setBackgroundResource(2130838043);
            this.ezq.removeAll();
            d = 0.0d;
            for (int i = 0; i < this.eXe.size(); i++) {
                a aVar;
                a aVar2 = (a) this.eXe.get(i);
                String valueOf = String.valueOf(i);
                if (i == this.eXe.size() - 1) {
                    aVar = new a(this, (byte) 0);
                } else {
                    aVar = new a(this);
                }
                aVar.setKey(valueOf);
                valueOf = aVar2.caJ;
                if (be.kS(valueOf) && !be.kS(aVar2.username)) {
                    valueOf = com.tencent.mm.wallet_core.ui.e.er(aVar2.username);
                }
                aVar.mTitle = valueOf;
                aVar.bZy = aVar2.username;
                if (aVar2.status == 0) {
                    aVar.setSummary(2131231957);
                } else if (aVar2.status == 1) {
                    if (aVar2.eIX) {
                        d += aVar2.eWz;
                        aVar.setSummary(com.tencent.mm.wallet_core.ui.e.d(aVar2.eWz, aVar2.cpl));
                    } else {
                        aVar.setSummary(2131231956);
                    }
                    this.ezq.a(aVar);
                } else if (aVar2.status == 2) {
                    aVar.setSummary(2131231955);
                }
                this.ezq.a(aVar);
            }
            this.ezq.notifyDataSetChanged();
            this.eWN.setText(com.tencent.mm.wallet_core.ui.e.d(d, ((a) this.eXe.get(0)).cpl));
            this.eWN.setVisibility(0);
        }
        if (d <= 0.0d || this.eXe.size() <= 0) {
            this.eWO.setVisibility(8);
            this.eWN.setVisibility(8);
            this.eWP.setVisibility(8);
            this.eWT.setVisibility(8);
            return;
        }
        this.eWO.setVisibility(0);
        if (this.eXe.size() > 1) {
            this.eWP.setVisibility(0);
            this.eWT.setVisibility(0);
        }
    }

    private void aeg() {
        if (!this.eXd) {
            this.nDR.bAi();
        } else if (this.eXi) {
            a(0, getString(2131231954), new OnMenuItemClickListener(this) {
                final /* synthetic */ CollectMainUI eXr;

                {
                    this.eXr = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.eXr.eXi = false;
                    this.eXr.aeg();
                    this.eXr.aee();
                    return false;
                }
            }, com.tencent.mm.ui.k.b.nEW);
        } else {
            a(0, getString(2131231953), new OnMenuItemClickListener(this) {
                final /* synthetic */ CollectMainUI eXr;

                {
                    this.eXr = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(this.eXr.nDR.nEl, CollectCreateQRCodeUI.class);
                    this.eXr.startActivityForResult(intent, Downloads.RECV_BUFFER_SIZE);
                    return false;
                }
            }, com.tencent.mm.ui.k.b.nEW);
        }
    }

    protected final int getLayoutId() {
        return 2130903385;
    }

    public final int Oo() {
        return 2131099662;
    }

    public final int YA() {
        return 2130903387;
    }

    public final boolean f(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final void b(c cVar) {
        Object obj = null;
        v.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
        if (this.eWH != null) {
            this.eWH.vibrate(50);
        }
        if (((long) cVar.eWB) < this.eXj) {
            v.d("MicroMsg.CollectMainUI", "Recieve but time out ");
            return;
        }
        Object obj2;
        int i = 0;
        while (i < this.eXe.size()) {
            if (cVar.status == 0 && be.ma(cVar.username).equals(((a) this.eXe.get(i)).username) && ((a) this.eXe.get(i)).status == 2) {
                this.eXe.remove(i);
                this.eXe.add(i, new a(this, cVar));
                obj2 = 1;
                break;
            } else if (cVar.eWA.equals(((a) this.eXe.get(i)).eWA)) {
                v.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + cVar.eWA);
                if (((a) this.eXe.get(i)).status == 0) {
                    ((a) this.eXe.get(i)).status = cVar.status;
                    ((a) this.eXe.get(i)).eWz = cVar.eWz;
                    ((a) this.eXe.get(i)).cpl = cVar.cpl;
                    if (cVar.status == 1) {
                        a aVar = (a) this.eXe.get(i);
                        this.eXm.eXx.add(aVar);
                    }
                }
                int i2 = 1;
            } else {
                i++;
            }
        }
        obj2 = null;
        if (obj2 == null) {
            for (i = 0; i < this.eXe.size(); i++) {
                if (cVar.eWB > ((c) this.eXe.get(i)).eWB) {
                    this.eXe.add(i, new a(this, cVar));
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                this.eXe.add(new a(this, cVar));
            }
        }
        ad.o(new Runnable(this) {
            final /* synthetic */ CollectMainUI eXr;

            {
                this.eXr = r1;
            }

            public final void run() {
                this.eXr.aef();
                this.eXr.eXm.aem();
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                if (i2 != -1 || intent == null) {
                    this.eXi = false;
                } else {
                    this.eXc = intent.getStringExtra("ftf_pay_url");
                    this.eXf = intent.getDoubleExtra("ftf_fixed_fee", 0.0d);
                    this.eXg = intent.getStringExtra("ftf_fixed_fee_type");
                    this.eXh = intent.getStringExtra("ftf_fixed_desc");
                    this.eXi = true;
                }
                acO();
                return;
            default:
                return;
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968676, 2130968681);
    }
}
