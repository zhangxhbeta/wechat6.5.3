package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import org.json.JSONObject;

public final class w extends j implements a {
    ac cnC;
    Context context;
    int duration = 0;
    int fEU = 0;
    View fIV;
    int gef;
    int geg;
    double iVE = 0.0d;
    private int index;
    int jzA = 0;
    int jzB = 0;
    boolean jzC = false;
    private boolean jzD = false;
    private boolean jzE = true;
    boolean jzF = false;
    private boolean jzG = false;
    boolean jzJ = true;
    b jzK;
    boolean jzL = false;
    private boolean jzM = false;
    private boolean jzN = false;
    public z jzS = null;
    public SnsAdNativeLandingPagesVideoPlayerLoadingBar jzT;
    ProgressBar jzU;
    boolean jzV = true;
    int jzW = 0;
    boolean jzX = true;
    boolean jzY = false;
    boolean jzZ = true;
    int jzn;
    VideoSightView jzo;
    ImageView jzp;
    boolean jzq = true;
    MMPinProgressBtn jzr;
    ImageView jzs;
    TextView jzt;
    long jzu = 0;
    int jzv = 0;
    private int jzw = 0;
    int jzx = 0;
    int jzy = 0;

    public w(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
        this.context = context;
        this.cnC = ad.aqz();
    }

    protected final int aGY() {
        return 2130904427;
    }

    public final View aTM() {
        LayoutParams layoutParams;
        ViewParent parent;
        if (!e.aR(d.cI("adId", ((r) this.jxU).jwd))) {
            this.jzJ = false;
        }
        if (!e.aR(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + z.Kg(((r) this.jxU).jwc))) {
            this.jzZ = false;
        }
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        View view = this.dtW;
        ViewGroup viewGroup = (ViewGroup) view.findViewById(2131759251);
        this.jzo = new VideoSightView(this.context);
        this.jzo.fD(false);
        this.jzo.aPw();
        viewGroup.addView(this.jzo, 0, new LinearLayout.LayoutParams(-1, -1));
        if (((r) this.jxU).jwe != 1) {
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(width, height);
            view.setPadding((int) ((r) this.jxU).jvK, (int) ((r) this.jxU).jvI, (int) ((r) this.jxU).jvL, (int) ((r) this.jxU).jvJ);
            viewGroup.setLayoutParams(layoutParams2);
            view.setLayoutParams(layoutParams2);
        } else if (((int) ((r) this.jxU).width) > 0) {
            int i;
            int i2 = (width * ((int) ((r) this.jxU).height)) / ((int) ((r) this.jxU).width);
            if (i2 <= height) {
                i = i2;
                i2 = width;
            } else if (((int) ((r) this.jxU).height) > 0) {
                i2 = (height * ((int) ((r) this.jxU).width)) / ((int) ((r) this.jxU).height);
                i = height;
            } else {
                i2 = width;
                i = height;
            }
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i);
            view.setPadding((int) ((r) this.jxU).jvK, (int) ((r) this.jxU).jvI, (int) ((r) this.jxU).jvL, (int) ((r) this.jxU).jvJ);
            viewGroup.setLayoutParams(layoutParams3);
            view.setLayoutParams(layoutParams3);
        } else {
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
            view.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
        }
        d.a("adId", ((r) this.jxU).jwd, false, 1000000001, 0, new a(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void aRx() {
            }

            public final void aTV() {
            }

            public final void Bg(String str) {
                this.jAa.jzo.setImageBitmap(BitmapFactory.decodeFile(str));
            }
        });
        this.jzt = (TextView) view.findViewById(2131759209);
        this.jzt.setText(this.context.getString(2131232297));
        this.fIV = view.findViewById(2131759253);
        if (this.fIV != null) {
            layoutParams = new RelativeLayout.LayoutParams(width, height);
            parent = this.fIV.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.fIV);
            }
            ((ViewGroup) view).addView(this.fIV, layoutParams);
        }
        layoutParams = new RelativeLayout.LayoutParams(width - com.tencent.mm.bd.a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.a(this.context, this.context.getResources().getDimension(2131493158));
        this.jzT = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.context);
        this.jzT.setVisibility(0);
        this.jzo.fE(true);
        this.jzT.iUG = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void aPv() {
            }

            public final void pB(int i) {
                v.i("MicroMsg.Sns.AdLandingPageStreamVideoComponent", "onSeek time " + i);
                this.jAa.iVE = (double) i;
                if (this.jAa.jzq) {
                    this.jAa.aUe();
                } else {
                    this.jAa.aUf();
                }
                this.jAa.jzo.i((double) i);
            }
        };
        this.jzT.d(new OnClickListener(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void onClick(View view) {
                this.jAa.jzV = true;
                if (this.jAa.jzo.isPlaying()) {
                    this.jAa.aPy();
                    this.jAa.jzB = 4;
                } else {
                    if (this.jAa.jzq) {
                        this.jAa.aUe();
                    } else {
                        this.jAa.aUf();
                        this.jAa.jzL = true;
                        this.jAa.jzK.a(this.jAa, true);
                    }
                    this.jAa.aUd();
                    this.jAa.jzB = 3;
                }
                w wVar = this.jAa;
                wVar.jzW++;
            }
        });
        this.jzT.fA(this.jzo.isPlaying());
        this.jzT.setVisibility(0);
        this.jzT.py(0);
        ((ViewGroup) view).addView(this.jzT, layoutParams);
        this.jzp = (ImageView) view.findViewById(2131759254);
        this.jzp.setVisibility(0);
        this.jzp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void onClick(View view) {
                w wVar = this.jAa;
                wVar.jzy++;
                if (this.jAa.jzq) {
                    this.jAa.aUf();
                    if (this.jAa.jzo.isPlaying()) {
                        this.jAa.jzo.start();
                        this.jAa.cnC.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 jAb;

                            {
                                this.jAb = r1;
                            }

                            public final void run() {
                                this.jAb.jAa.jzT.fA(true);
                            }
                        });
                        this.jAa.jzu = System.currentTimeMillis();
                    }
                    this.jAa.jzo.i(this.jAa.jzo.aPB());
                    this.jAa.jzL = true;
                    this.jAa.jzK.a(this.jAa, true);
                } else {
                    this.jAa.aUe();
                }
                this.jAa.jzC = true;
            }
        });
        this.jzp.setPadding(0, 0, com.tencent.mm.bd.a.fromDPToPix(this.context, 8), com.tencent.mm.bd.a.fromDPToPix(this.context, 13));
        parent = this.jzp.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jzp);
        }
        ((ViewGroup) view).addView(this.jzp);
        this.jzs = (ImageView) view.findViewById(2131755281);
        this.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2131165914));
        this.jzs.setVisibility(8);
        this.jzs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void onClick(View view) {
                this.jAa.jzV = true;
                this.jAa.aUd();
                this.jAa.jzX = false;
                if (!this.jAa.jzC) {
                    this.jAa.aUf();
                    this.jAa.jzL = true;
                    this.jAa.jzK.a(this.jAa, true);
                    this.jAa.jzC = true;
                } else if (this.jAa.jzq) {
                    this.jAa.aUe();
                } else {
                    this.jAa.aUf();
                    this.jAa.jzL = true;
                    this.jAa.jzK.a(this.jAa, true);
                }
                this.jAa.jzB = 3;
                this.jAa.jzT.setVisibility(0);
                this.jAa.jzp.setVisibility(0);
                this.jAa.fIV.setVisibility(0);
                com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                    final /* synthetic */ AnonymousClass8 jAc;

                    {
                        this.jAc = r1;
                    }

                    public final void run() {
                        if (!this.jAc.jAa.jzY) {
                            if (this.jAc.jAa.jzS != null) {
                                this.jAc.jAa.jzS.gm(false);
                            }
                            this.jAc.jAa.jzT.setVisibility(4);
                            this.jAc.jAa.jzp.setVisibility(8);
                            this.jAc.jAa.fIV.setVisibility(4);
                        }
                    }
                }, 3000);
            }
        });
        this.jzo.iVc = new g.a(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void abH() {
            }

            public final void bp(int i, int i2) {
                this.jAa.jzo.stop();
            }

            public final void pa() {
                w wVar = this.jAa;
                wVar.jzx++;
                this.jAa.jzT.setVisibility(0);
                this.jAa.jzp.setVisibility(0);
                this.jAa.fIV.setVisibility(0);
                this.jAa.jzo.stop();
                this.jAa.iVE = 0.0d;
                this.jAa.cnC.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 jAd;

                    {
                        this.jAd = r1;
                    }

                    public final void run() {
                        this.jAd.jAa.jzT.py(0);
                        this.jAd.jAa.jzT.fA(false);
                    }
                });
                if (this.jAa.jzu != 0) {
                    wVar = this.jAa;
                    wVar.jzv = (int) ((System.currentTimeMillis() - this.jAa.jzu) + ((long) wVar.jzv));
                    this.jAa.jzu = 0;
                }
            }

            public final int bq(final int i, final int i2) {
                com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 jAd;

                    public final void run() {
                        v.i("MicroMsg.Sns.AdLandingPageStreamVideoComponent", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            this.jAd.jAa.duration = i2;
                            this.jAd.jAa.jzn = i2;
                        }
                        if (this.jAd.jAa.jzT.iUN != i2) {
                            this.jAd.jAa.jzT.pz(i2);
                        }
                        this.jAd.jAa.jzT.py(i);
                        this.jAd.jAa.iVE = (double) i;
                    }
                });
                return 0;
            }

            public final void br(int i, int i2) {
                this.jAa.geg = i;
                this.jAa.gef = i2;
            }
        };
        this.jzo.lUB = false;
        this.jzT.setVisibility(4);
        this.jzp.setVisibility(8);
        this.fIV.setVisibility(4);
        this.jzo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void onClick(View view) {
                boolean z = true;
                if (!"".equals(this.jAa.jzo.iUW.iTJ) && this.jAa.jzo.iUW.iTJ != null) {
                    this.jAa.jzY = true;
                    if (this.jAa.jzT.getVisibility() == 0) {
                        this.jAa.jzT.setVisibility(4);
                        this.jAa.jzp.setVisibility(8);
                        this.jAa.fIV.setVisibility(4);
                    } else {
                        this.jAa.jzT.setVisibility(0);
                        this.jAa.jzp.setVisibility(0);
                        this.jAa.fIV.setVisibility(0);
                    }
                    if (this.jAa.jzS != null) {
                        z zVar = this.jAa.jzS;
                        if (this.jAa.jzT.getVisibility() != 0) {
                            z = false;
                        }
                        zVar.gm(z);
                    }
                }
            }
        });
        this.jzU = (ProgressBar) view.findViewById(2131757495);
        this.jzU.setVisibility(8);
        this.jzr = (MMPinProgressBtn) view.findViewById(2131759252);
        this.jzr.setVisibility(0);
        this.jzr.bKj();
        d.a("adId", ((r) this.jxU).jwd, false, 1000000001, 0, new a(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void aRx() {
            }

            public final void aTV() {
            }

            public final void Bg(String str) {
                this.jAa.jzo.v(BitmapFactory.decodeFile(str));
            }
        });
        aUg();
        this.dtW = view;
        return view;
    }

    private void aUg() {
        d.a("adId", ((r) this.jxU).jwc, false, 62, new d.b(this) {
            final /* synthetic */ w jAa;

            {
                this.jAa = r1;
            }

            public final void Bi(String str) {
                if (!this.jAa.jzo.isPlaying()) {
                    this.jAa.jzU.setVisibility(8);
                    this.jAa.jzr.setVisibility(8);
                    this.jAa.jzo.fD(false);
                    if (!str.equals(this.jAa.jzo.iUW.iTJ)) {
                        this.jAa.jzo.setVideoPath(str);
                        if (this.jAa.jzT.iUN != this.jAa.jzo.getDuration()) {
                            this.jAa.jzT.pz(this.jAa.jzo.getDuration());
                        }
                    }
                }
            }

            public final void Bj(String str) {
                v.e("MicroMsg.Sns.AdLandingPageStreamVideoComponent", str);
                this.jAa.jzU.setVisibility(8);
                this.jAa.jzr.setVisibility(8);
                this.jAa.jzs.setImageResource(2130839161);
                this.jAa.jzs.setVisibility(0);
                this.jAa.jzt.setVisibility(0);
                this.jAa.jzo.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass12 jAe;

                    {
                        this.jAe = r1;
                    }

                    public final void onClick(View view) {
                        this.jAe.jAa.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.jAe.jAa.context, 2131165914));
                        this.jAe.jAa.jzs.setVisibility(8);
                        this.jAe.jAa.jzt.setVisibility(8);
                        this.jAe.jAa.jzr.setVisibility(0);
                        this.jAe.jAa.jzr.bKj();
                        this.jAe.jAa.aUg();
                    }
                });
            }

            public final void Bk(String str) {
                this.jAa.jzo.setVideoPath(str);
                this.jAa.jzo.fD(false);
                this.jAa.jzU.setVisibility(8);
                this.jAa.jzr.setVisibility(8);
                this.jAa.jzF = true;
                this.jAa.K(this.jAa.jzA, this.jAa.fEU, this.jAa.fEU);
            }
        });
    }

    final void aUd() {
        if (this.jzF && !this.jzo.isPlaying()) {
            this.jzs.setVisibility(8);
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ w jAa;

                {
                    this.jAa = r1;
                }

                public final void run() {
                    this.jAa.jzT.fA(true);
                    this.jAa.jzo.start();
                    if (!this.jAa.jzq && this.jAa.iVE > 9.999999974752427E-7d) {
                        this.jAa.jzo.i(this.jAa.iVE);
                    }
                }
            });
            this.jzu = System.currentTimeMillis();
            this.jzw++;
        }
    }

    final void aPy() {
        if (this.jzF && this.jzo.isPlaying()) {
            if (!this.jzV) {
                this.jzs.setVisibility(0);
            }
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ w jAa;

                {
                    this.jAa = r1;
                }

                public final void run() {
                    this.jAa.iVE = this.jAa.jzo.aPB();
                    this.jAa.jzo.pause();
                    this.jAa.jzT.fA(false);
                }
            });
            if (this.jzu != 0) {
                this.jzv = (int) (((long) this.jzv) + (System.currentTimeMillis() - this.jzu));
                this.jzu = 0;
            }
        }
    }

    final void aUe() {
        this.jzp.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2130838451));
        this.jzo.fB(false);
        this.jzo.dJ(true);
        this.jzq = true;
    }

    final void aUf() {
        this.jzp.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2130838452));
        this.jzo.fB(true);
        this.jzo.dJ(false);
        this.jzq = false;
    }

    public final void aTO() {
        super.aTO();
    }

    public final void aTP() {
        super.aTP();
        aPy();
        this.jzL = false;
        if (this.jzD || this.jzE) {
            this.jzE = false;
            this.jzD = false;
            if (this.jzB == 1) {
                this.jzB = 2;
            }
        }
    }

    public final void aTU() {
        super.aTU();
        this.jzo.detach();
        this.jzo.fy(false);
        this.jzo.iUW.clear();
    }

    public final void K(int i, int i2, int i3) {
        super.K(i, i2, i3);
        if (i != 0 && i2 != 0) {
            this.jzA = i;
            this.fEU = i2;
            if (this.jzF && i >= 0) {
                if (((float) i) < 0.5f * ((float) i2)) {
                    this.jzL = false;
                    if (this.jzD || this.jzE) {
                        this.jzE = false;
                        this.jzD = false;
                        aPy();
                        if (this.jzB == 1) {
                            this.jzB = 2;
                        }
                    }
                } else if ((!this.jzD || this.jzE) && this.jzF) {
                    this.jzL = false;
                    this.jzE = false;
                    this.jzD = true;
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) aa.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    if (!this.jzX || (this.jzX && activeNetworkInfo != null && activeNetworkInfo.getType() == 1)) {
                        if (this.jzS != null) {
                            this.jzS.gm(true);
                        }
                        this.jzT.setVisibility(0);
                        this.jzp.setVisibility(0);
                        this.fIV.setVisibility(0);
                        com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                            final /* synthetic */ w jAa;

                            {
                                this.jAa = r1;
                            }

                            public final void run() {
                                if (!this.jAa.jzY) {
                                    if (this.jAa.jzS != null) {
                                        this.jAa.jzS.gm(false);
                                    }
                                    this.jAa.jzT.setVisibility(4);
                                    this.jAa.jzp.setVisibility(8);
                                    this.jAa.fIV.setVisibility(4);
                                }
                            }
                        }, 3000);
                    }
                    if (this.jzX) {
                        if (activeNetworkInfo == null || !(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                            this.jzs.setVisibility(0);
                            this.jzV = false;
                            this.jzG = false;
                        } else {
                            this.jzG = true;
                            this.jzX = false;
                        }
                    }
                    if (this.jzB == 0) {
                        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                            if (this.jzC) {
                                if (this.jzq) {
                                    aUe();
                                }
                                aUf();
                                this.jzL = true;
                                this.jzK.a(this, false);
                            } else {
                                if (!this.jzM) {
                                    aUe();
                                }
                                aUf();
                                this.jzL = true;
                                this.jzK.a(this, false);
                            }
                            this.jzB = 1;
                        } else {
                            return;
                        }
                    } else if (this.jzB == 2) {
                        if (this.jzC) {
                            if (this.jzq) {
                                aUe();
                            }
                            aUf();
                            this.jzL = true;
                            this.jzK.a(this, false);
                        } else {
                            if (!this.jzM) {
                                aUe();
                            }
                            aUf();
                            this.jzL = true;
                            this.jzK.a(this, false);
                        }
                        aUd();
                        this.jzB = 1;
                        return;
                    } else if (this.jzB == 3) {
                        if (this.jzC) {
                            if (this.jzq) {
                                aUe();
                            }
                        } else if (!this.jzM) {
                            aUe();
                        }
                        aUf();
                        this.jzL = true;
                        this.jzK.a(this, false);
                    } else {
                        return;
                    }
                    aUd();
                }
            }
        }
    }

    public final boolean x(JSONObject jSONObject) {
        if (!super.x(jSONObject)) {
            return false;
        }
        try {
            String Kg;
            JSONObject jSONObject2;
            jSONObject.put("streamVideoDuraion", this.jzo.getDuration() * BaseReportManager.MAX_READ_COUNT);
            jSONObject.put("playTimeInterval", this.jzv);
            jSONObject.put("playCount", this.jzw);
            jSONObject.put("playCompletedCount", this.jzx);
            jSONObject.put("clickPlayControlCount", this.jzW);
            jSONObject.put("clickVoiceControlCount", this.jzy);
            jSONObject.put("isAutoPlay", this.jzG ? "1" : "0");
            if (!this.jzJ) {
                Kg = z.Kg(((r) this.jxU).jwd);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Kg);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            if (!this.jzZ) {
                Kg = z.Kg(((r) this.jxU).jwc);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Kg);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("streamVideoUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.Sns.AdLandingPageStreamVideoComponent", e, "", new Object[0]);
            return false;
        }
    }

    protected final void aTS() {
        v.i("MicroMsg.Sns.AdLandingPageStreamVideoComponent", getClass().getName() + "not support update now");
    }

    public final boolean aTI() {
        return this.jzL;
    }

    public final void gk(boolean z) {
        if (z) {
            if (!this.jzN) {
                this.jzN = true;
            } else {
                return;
            }
        }
        aUe();
        this.jzC = true;
        this.jzL = false;
    }

    public final void a(b bVar, int i, boolean z) {
        this.jzK = bVar;
        this.index = i;
        this.jzM = z;
        if (z) {
            aUf();
        } else {
            aUe();
        }
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean aTJ() {
        return this.jzM;
    }
}
