package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.g.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import org.json.JSONObject;

public final class v extends j implements a {
    ac cnC = ad.aqz();
    int duration = 0;
    ProgressBar elJ;
    int fEU = 0;
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
    boolean jzH = false;
    boolean jzI = true;
    boolean jzJ = true;
    b jzK;
    boolean jzL = false;
    private boolean jzM = false;
    private boolean jzN = false;
    int jzn;
    VideoSightView jzo;
    ImageView jzp;
    boolean jzq = true;
    MMPinProgressBtn jzr;
    ImageView jzs;
    TextView jzt;
    long jzu = System.currentTimeMillis();
    private int jzv = 0;
    private int jzw = 0;
    int jzx = 0;
    int jzy = 0;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar jzz;

    public v(Context context, l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
    }

    protected final int aGY() {
        return 2130904427;
    }

    protected final void aTS() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    }

    public final View aTM() {
        LayoutParams layoutParams;
        boolean z;
        if (!e.aR(d.cJ("adId", ((l) this.jxU).jvB))) {
            this.jzI = false;
        }
        if (!e.aR(d.cI("adId", ((l) this.jxU).jvC))) {
            this.jzJ = false;
        }
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        View view = this.dtW;
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        view.setPadding((int) ((l) this.jxU).jvK, (int) ((l) this.jxU).jvI, (int) ((l) this.jxU).jvL, (int) ((l) this.jxU).jvJ);
        view.setLayoutParams(layoutParams2);
        if (((l) this.jxU).jvD == 1) {
            view.setMinimumHeight(height);
        } else if (((int) ((l) this.jxU).height) > 0) {
            view.setMinimumHeight(((int) ((l) this.jxU).jvI) + (((int) ((l) this.jxU).height) + ((int) ((l) this.jxU).jvJ)));
        } else if (((int) ((l) this.jxU).width) > 0) {
            view.setMinimumHeight(((int) ((l) this.jxU).jvI) + (((width * ((int) ((l) this.jxU).height)) / ((int) ((l) this.jxU).width)) + ((int) ((l) this.jxU).jvJ)));
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(2131759251);
        this.jzo = new VideoSightView(this.context);
        this.jzo.aPw();
        this.jzo.iVc = new a(this) {
            final /* synthetic */ v jzO;

            {
                this.jzO = r1;
            }

            public final void abH() {
            }

            public final void bp(int i, int i2) {
                this.jzO.jzo.stop();
            }

            public final void pa() {
                this.jzO.jzo.fB(!this.jzO.jzq);
                if (this.jzO.jzH) {
                    this.jzO.jzH = false;
                    return;
                }
                v vVar = this.jzO;
                vVar.jzx++;
            }

            public final int bq(final int i, final int i2) {
                com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jzP;

                    public final void run() {
                        if (i2 > 0) {
                            this.jzP.jzO.duration = i2;
                            this.jzP.jzO.jzn = i2;
                        }
                        if (this.jzP.jzO.jzz.iUN != i2) {
                            this.jzP.jzO.jzz.pz(i2);
                        }
                        this.jzP.jzO.jzz.py(i);
                    }
                });
                return 0;
            }

            public final void br(int i, int i2) {
                this.jzO.geg = i;
                this.jzO.gef = i2;
            }
        };
        this.jzo.lUB = false;
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        if (((l) this.jxU).width <= 0.0f || ((l) this.jxU).height <= 0.0f || ((l) this.jxU).jvD == 1) {
            layoutParams = layoutParams3;
        } else {
            layoutParams = new LinearLayout.LayoutParams((int) ((l) this.jxU).width, (int) ((l) this.jxU).height);
        }
        viewGroup.addView(this.jzo, 0, layoutParams);
        this.jzp = (ImageView) view.findViewById(2131759254);
        this.jzp.setVisibility(8);
        this.jzp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ v jzO;

            {
                this.jzO = r1;
            }

            public final void onClick(View view) {
                v vVar = this.jzO;
                vVar.jzy++;
                if (this.jzO.jzq) {
                    this.jzO.aUf();
                    if (this.jzO.jzo.isPlaying()) {
                        this.jzO.cnC.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 jzQ;

                            {
                                this.jzQ = r1;
                            }

                            public final void run() {
                                this.jzQ.jzO.jzo.start();
                                this.jzQ.jzO.jzo.i(this.jzQ.jzO.jzo.aPB());
                                this.jzQ.jzO.jzz.fA(true);
                                this.jzQ.jzO.jzH = true;
                            }
                        });
                        this.jzO.jzu = System.currentTimeMillis();
                    }
                    this.jzO.jzL = true;
                    this.jzO.jzK.a(this.jzO, true);
                } else {
                    this.jzO.aUe();
                }
                this.jzO.jzC = true;
            }
        });
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.a(this.context, this.context.getResources().getDimension(2131493158));
        this.jzz = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.context);
        this.jzz.setVisibility(0);
        this.jzo.fE(true);
        ((ViewGroup) view).addView(this.jzz, layoutParams);
        this.jzz.iUG = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ v jzO;

            {
                this.jzO = r1;
            }

            public final void aPv() {
            }

            public final void pB(int i) {
                this.jzO.iVE = (double) i;
                this.jzO.jzo.i((double) i);
            }
        };
        this.jzz.d(new OnClickListener(this) {
            final /* synthetic */ v jzO;

            {
                this.jzO = r1;
            }

            public final void onClick(View view) {
                if (this.jzO.jzo.isPlaying()) {
                    this.jzO.aPy();
                    this.jzO.jzB = 4;
                    return;
                }
                this.jzO.aUd();
                this.jzO.jzB = 3;
            }
        });
        this.jzz.py(0);
        this.jzz.fA(this.jzo.isPlaying());
        this.jzz.setVisibility(8);
        this.jzz.py(0);
        this.jzp.setPadding(0, 0, com.tencent.mm.bd.a.fromDPToPix(this.context, 10), com.tencent.mm.bd.a.fromDPToPix(this.context, 7));
        this.jzs = (ImageView) view.findViewById(2131755281);
        this.jzt = (TextView) view.findViewById(2131759209);
        this.jzt.setText(this.context.getString(2131235393));
        this.elJ = (ProgressBar) view.findViewById(2131757495);
        this.elJ.setVisibility(8);
        this.jzr = (MMPinProgressBtn) view.findViewById(2131759252);
        this.jzr.setVisibility(8);
        g aSB = ad.aSB();
        if (FileOp.aR(d.cJ("adId", ((l) this.jxU).jvB))) {
            boolean z2;
            this.jzG = false;
            this.jzs.setVisibility(0);
            this.jzr.setVisibility(8);
            if (aSB.b(null, null) == 5) {
                this.jzG = true;
                z2 = true;
            } else {
                z2 = false;
            }
            this.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2131165914));
            this.jzs.setContentDescription(this.context.getString(2131234179));
            this.jzs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ v jzO;

                {
                    this.jzO = r1;
                }

                public final void onClick(View view) {
                    this.jzO.jzB = 3;
                    this.jzO.aUf();
                    this.jzO.aUc();
                    this.jzO.jzL = true;
                    this.jzO.jzK.a(this.jzO, true);
                    this.jzO.jzC = true;
                }
            });
            z = z2;
        } else if (f.aUk().Bn(((l) this.jxU).jvB)) {
            this.jzs.setOnClickListener(null);
            this.jzG = true;
            z = true;
        } else if (aSB.b(null, null) == 5) {
            this.jzs.setOnClickListener(null);
            this.jzG = true;
            z = true;
        } else {
            this.jzG = false;
            this.jzs.setVisibility(0);
            this.jzr.setVisibility(8);
            this.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2131165914));
            this.jzs.setContentDescription(this.context.getString(2131234179));
            this.jzs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ v jzO;

                {
                    this.jzO = r1;
                }

                public final void onClick(View view) {
                    this.jzO.jzB = 3;
                    this.jzO.aUf();
                    this.jzO.aUc();
                    this.jzO.jzL = true;
                    this.jzO.jzK.a(this.jzO, true);
                }
            });
            if (aSB.b(null, null) == 4) {
                this.jzt.setVisibility(0);
                z = false;
            } else {
                z = false;
            }
        }
        d.a("adId", ((l) this.jxU).jvC, false, 1000000001, 0, new d.a(this) {
            final /* synthetic */ v jzO;

            {
                this.jzO = r1;
            }

            public final void aRx() {
            }

            public final void aTV() {
            }

            public final void Bg(String str) {
                this.jzO.jzo.v(BitmapFactory.decodeFile(str));
            }
        });
        if (z) {
            this.jzB = 1;
            aUc();
        }
        this.dtW = view;
        return view;
    }

    private void aUc() {
        d.a("adId", ((l) this.jxU).jvB, false, new d.a(this) {
            final /* synthetic */ v jzO;

            {
                this.jzO = r1;
            }

            public final void aRx() {
                this.jzO.jzs.setVisibility(8);
                this.jzO.jzr.setVisibility(0);
                this.jzO.jzr.bKj();
                this.jzO.jzt.setVisibility(8);
                this.jzO.jzs.setOnClickListener(null);
            }

            public final void aTV() {
                this.jzO.jzr.setVisibility(8);
                this.jzO.jzs.setImageResource(2130839161);
                this.jzO.jzs.setVisibility(0);
                this.jzO.jzr.setVisibility(8);
                this.jzO.jzt.setVisibility(0);
                this.jzO.jzs.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass9 jzR;

                    {
                        this.jzR = r1;
                    }

                    public final void onClick(View view) {
                        this.jzR.jzO.jzB = 3;
                        this.jzR.jzO.aUc();
                    }
                });
            }

            public final void Bg(final String str) {
                if (this.jzO.jzo != null) {
                    this.jzO.jzp.setVisibility(0);
                    this.jzO.elJ.setVisibility(8);
                    this.jzO.iVE = 0.0d;
                    this.jzO.cnC.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 jzR;

                        public final void run() {
                            this.jzR.jzO.jzo.stop();
                            this.jzR.jzO.jzo.setVideoPath(str);
                        }
                    });
                    this.jzO.jzF = true;
                    this.jzO.jzs.setVisibility(8);
                    this.jzO.jzt.setVisibility(8);
                    this.jzO.jzr.setVisibility(8);
                    if (((float) this.jzO.jzA) > 0.5f * ((float) this.jzO.fEU) && !this.jzO.jzo.isPlaying()) {
                        this.jzO.aUd();
                    }
                }
            }
        });
    }

    final void aUd() {
        if (this.jzF && !this.jzo.isPlaying()) {
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ v jzO;

                {
                    this.jzO = r1;
                }

                public final void run() {
                    this.jzO.jzo.start();
                    if (!this.jzO.jzq && this.jzO.iVE > 9.999999974752427E-7d) {
                        this.jzO.jzo.i(this.jzO.iVE);
                    }
                    this.jzO.jzz.fA(true);
                }
            });
            this.jzu = System.currentTimeMillis();
            this.jzw++;
        }
    }

    final void aPy() {
        if (this.jzF && this.jzo.isPlaying()) {
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ v jzO;

                {
                    this.jzO = r1;
                }

                public final void run() {
                    this.jzO.iVE = this.jzO.jzo.aPB();
                    this.jzO.jzo.pause();
                    this.jzO.jzz.fA(false);
                }
            });
            this.jzv = (int) (((long) this.jzv) + (System.currentTimeMillis() - this.jzu));
        }
    }

    private void aUe() {
        this.jzo.dJ(true);
        this.jzo.fB(false);
        this.jzp.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2130838449));
        this.jzq = true;
    }

    private void aUf() {
        this.jzo.dJ(false);
        this.jzo.fB(true);
        this.jzp.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2130838450));
        this.jzq = false;
    }

    public final void aTO() {
        super.aTO();
    }

    public final void aTP() {
        super.aTP();
        this.jzL = false;
        if (this.jzD || this.jzE) {
            this.jzE = false;
            this.jzD = false;
            aPy();
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
                    if (this.jzB == 0) {
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
                        aUd();
                    } else if (this.jzB == 1) {
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
                        aUd();
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
                        this.jzB = 1;
                        aUd();
                    } else if (this.jzB == 3) {
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
                    }
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
            jSONObject.put("sightDuration", this.jzo.getDuration() * BaseReportManager.MAX_READ_COUNT);
            jSONObject.put("playTimeInterval", this.jzv);
            jSONObject.put("playCount", this.jzw);
            jSONObject.put("playCompletedCount", this.jzx);
            jSONObject.put("clickVoiceControlCount", this.jzy);
            jSONObject.put("isAutoPlay", this.jzG ? "1" : "0");
            if (!this.jzI) {
                Kg = z.Kg(((l) this.jxU).jvB);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Kg);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("sightUrlInfo", jSONObject2);
            }
            if (!this.jzJ) {
                Kg = z.Kg(((l) this.jxU).jvC);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Kg);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.AdLandingPageSightVideoComponent", e, "", new Object[0]);
            return false;
        }
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
