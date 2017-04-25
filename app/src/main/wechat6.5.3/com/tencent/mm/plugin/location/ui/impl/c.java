package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.location.model.h;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.location.ui.g;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.6;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

public final class c extends b implements e {
    private static int gYr = 11;
    private static int gYs = 12;
    private static int gYt = 13;
    private static int gYu = 14;
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ c gYy;

        {
            this.gYy = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            v.d("MicroMsg.MMPoiMapUI", "onLocationChanged, slat=%f, slng=%f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            if (this.gYy.gXY == -1000.0d || this.gYy.gXZ == -1000.0d) {
                v.d("MicroMsg.MMPoiMapUI", "first get location");
                String str = ((int) (1000000.0f * f2)) + "," + ((int) (1000000.0f * f));
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrB, str);
                this.gYy.gXY = (double) f2;
                this.gYy.gXZ = (double) f;
                this.gYy.gYk = f2;
                this.gYy.gYl = f;
                this.gYy.lat = this.gYy.gXY;
                this.gYy.lng = this.gYy.gXZ;
                this.gYy.gXI.i(this.gYy.lat, this.gYy.lng);
                this.gYy.gUC.getIController().animateTo(this.gYy.gXY, this.gYy.gXZ, d.dV(false));
                if (!this.gYy.gYa) {
                    this.gYy.NH();
                }
            }
            return true;
        }
    };
    private String cUh = "";
    private String gSb = "";
    protected PoiHeaderView gXH;
    private PickPoi gXI;
    private MMLoadMoreListView gXJ;
    private MMLoadMoreListView gXK;
    private View gXL;
    private e gXM;
    private e gXN;
    private View gXO;
    private ImageButton gXP;
    private h gXQ = null;
    private f gXR = null;
    private View gXS;
    private ImageButton gXT;
    SearchViewNotRealTimeHelper gXU;
    private TextView gXV;
    private com.tencent.mm.plugin.location.ui.e gXW;
    private g gXX;
    private double gXY = -1000.0d;
    private double gXZ = -1000.0d;
    FrameLayout gXw;
    private View gXy;
    private boolean gYa = false;
    private int gYb = 0;
    private RelativeLayout gYc;
    private int gYd;
    private int gYe;
    private int gYf;
    private boolean gYg = true;
    private boolean gYh = false;
    private boolean gYi = false;
    private FrameLayout gYj;
    private float gYk;
    private float gYl;
    private int gYm = 0;
    private long gYn = -1;
    private long gYo = -1;
    private long gYp = -1;
    private int gYq = -1;
    private boolean gYv = false;
    private double lat = -1000.0d;
    private double lng = -1000.0d;
    private TextView titleView;

    class a extends TranslateAnimation {
        private List<View> gYA = new ArrayList();
        final /* synthetic */ c gYy;

        public a(c cVar, float f) {
            this.gYy = cVar;
            super(0.0f, 0.0f, 0.0f, f);
        }

        public final a axm() {
            setFillEnabled(true);
            setFillAfter(true);
            return this;
        }

        public final a bT(View view) {
            this.gYA.add(view);
            return this;
        }

        public final void axn() {
            for (int i = 0; i < this.gYA.size(); i++) {
                ((View) this.gYA.get(i)).startAnimation(this);
            }
        }
    }

    static /* synthetic */ void f(c cVar) {
        int i = 1;
        v.i("MicroMsg.MMPoiMapUI", "loadingmore");
        if (cVar.gXQ != null) {
            v.i("MicroMsg.MMPoiMapUI", "scene is doing");
            return;
        }
        byte[] bArr;
        if (cVar.gYa) {
            if (cVar.gXN.buffer == null) {
                v.i("MicroMsg.MMPoiMapUI", "buffer is null");
                return;
            }
            bArr = cVar.gXN.buffer;
        } else if (cVar.gXM.buffer == null) {
            v.i("MicroMsg.MMPoiMapUI", "buffer is null");
            return;
        } else {
            bArr = cVar.gXM.buffer;
        }
        int i2 = cVar.gYb == 0 ? 0 : 1;
        double d = cVar.lat;
        double d2 = cVar.lng;
        if (cVar.gYa) {
            i = 0;
        }
        cVar.gXQ = new h(bArr, d, d2, i2, i, (double) cVar.gYl, (double) cVar.gYk, cVar.gSb, cVar.cUh);
        ak.vy().a(cVar.gXQ, 0);
        cVar.gYm++;
    }

    static /* synthetic */ void p(c cVar) {
        int i = cVar.gXM.gYI;
        Intent intent = new Intent();
        Parcelable locationIntent = new LocationIntent();
        if (i >= 0 && i < cVar.gXM.getCount()) {
            f mv = cVar.gXM.mv(i);
            locationIntent.lat = mv.aIl;
            locationIntent.lng = mv.aIm;
            locationIntent.cJy = mv.gYZ;
            locationIntent.gUr = mv.mName;
            locationIntent.label = mv.gYP;
            locationIntent.gRO = mv.gYQ;
            locationIntent.lyP = mv.type;
            locationIntent.bhu = cVar.gUC.getZoomLevel();
            switch (cVar.type) {
                case 0:
                    i = gYr;
                    int i2 = cVar.gXM.gYI;
                    if (cVar.gYv) {
                        i = gYt;
                    }
                    cVar.bM(i, i2);
                    break;
            }
            intent.putExtra("KLocationIntent", locationIntent);
            cVar.aXH.setResult(-1, intent);
            cVar.aXH.finish();
        }
    }

    static /* synthetic */ void u(c cVar) {
        cVar.gYa = true;
        cVar.gXK.bCj();
        cVar.gXK.nWA = new com.tencent.mm.ui.base.MMLoadMoreListView.a(cVar) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void adB() {
                c.f(this.gYy);
            }
        };
        cVar.gXK.setOnItemClickListener(new OnItemClickListener(cVar) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f fVar = null;
                if (this.gYy.gXN.gYI < this.gYy.gXN.getCount()) {
                    fVar = this.gYy.gXN.mv(i);
                }
                this.gYy.gXR = fVar;
                this.gYy.a(fVar);
            }
        });
        cVar.gXJ.setVisibility(8);
        cVar.gXK.setVisibility(0);
        cVar.gXK.setAdapter(cVar.gXN);
        cVar.gXK.bCj();
        cVar.findViewById(2131758187).setVisibility(8);
        cVar.gXU.setVisibility(0);
        new ac().post(new Runnable(cVar) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void run() {
                SearchViewNotRealTimeHelper searchViewNotRealTimeHelper = this.gYy.gXU;
                searchViewNotRealTimeHelper.ocq.post(new 6(searchViewNotRealTimeHelper));
                b bVar = this.gYy;
                InputMethodManager inputMethodManager = (InputMethodManager) bVar.aXH.getSystemService("input_method");
                if (inputMethodManager != null) {
                    View currentFocus = bVar.aXH.getCurrentFocus();
                    if (currentFocus != null && currentFocus.getWindowToken() != null) {
                        inputMethodManager.toggleSoftInput(0, 2);
                    }
                }
            }
        });
    }

    public c(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(457, this);
        this.gYq = (int) (System.currentTimeMillis() / 1000);
        this.titleView = (TextView) findViewById(2131758190);
        this.titleView.setText(getString(2131233539));
        this.gYc = (RelativeLayout) findViewById(2131758564);
        this.gXJ = (MMLoadMoreListView) this.aXH.findViewById(2131758566);
        this.gXK = (MMLoadMoreListView) this.aXH.findViewById(2131758568);
        this.gXL = this.aXH.findViewById(2131758570);
        this.gXV = (TextView) findViewById(2131758569);
        this.gXP = (ImageButton) findViewById(2131757409);
        this.gXP.setContentDescription(getString(2131233522));
        this.gXH = (PoiHeaderView) findViewById(2131758565);
        this.gUC.setBuiltInZoomControls(false);
        this.gXw = (FrameLayout) findViewById(2131757407);
        this.gXW = new com.tencent.mm.plugin.location.ui.e(this.aXH, this.gUC);
        this.gXX = new g(this.aXH, this.gUC);
        this.gXI = new PickPoi(this.aXH);
        ((ImageView) this.gXI.gTL).setImageResource(2130838479);
        this.gXw.addView(this.gXI);
        this.gXO = findViewById(2131758567);
        this.gXy = this.aXH.findViewById(2131758188);
        this.gXS = (LinearLayout) this.aXH.findViewById(2131758194);
        this.gXS.setVisibility(0);
        switch (this.type) {
            case 0:
                ((TextView) findViewById(2131755265)).setText(2131233538);
                break;
            case 3:
                ((TextView) findViewById(2131755265)).setText(2131231103);
                break;
            case 8:
                ((TextView) findViewById(2131755265)).setText(2131231065);
                break;
        }
        this.gXT = (ImageButton) findViewById(2131758192);
        this.gXT.setContentDescription(getString(2131234859));
        this.gXU = (SearchViewNotRealTimeHelper) findViewById(2131758561);
        eb(false);
        this.gXM = new e(this.aXH);
        this.gXN = new e(this.aXH);
        this.gXN.gYJ = true;
        this.gXI.gYF = this.gXM;
        this.gXJ.setAdapter(this.gXM);
        this.gXJ.setOnTouchListener(new OnTouchListener(this) {
            private float gYw;
            private short gYx = (short) 0;
            final /* synthetic */ c gYy;

            {
                this.gYy = r2;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.gYy.gYg) {
                    return true;
                }
                switch (motionEvent.getAction()) {
                    case 0:
                        v.d("MicroMsg.MMPoiMapUI", "newpoi action down %s", new Object[]{Float.valueOf(motionEvent.getRawY())});
                        this.gYw = motionEvent.getRawY();
                        this.gYy.gYh = false;
                        break;
                    case 1:
                        v.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
                        this.gYy.gYh = false;
                        break;
                    case 2:
                        v.d("MicroMsg.MMPoiMapUI", "newpoi action move %s", new Object[]{Float.valueOf(motionEvent.getRawY())});
                        if (this.gYy.gYh) {
                            v.d("MicroMsg.MMPoiMapUI", "newpoi blocked");
                            this.gYy.gXJ.setSelection(0);
                        }
                        float rawY = this.gYw - motionEvent.getRawY();
                        if (Math.abs(rawY) < ((float) b.a(this.gYy.aXH, 20.0f))) {
                            this.gYx = (short) 0;
                        } else if (rawY > 0.0f) {
                            this.gYx = (short) 1;
                        } else {
                            this.gYx = (short) -1;
                        }
                        if ((this.gYy.axk() <= this.gYy.gYe && this.gYx == (short) 1) || ((!this.gYy.gXJ.nWD && this.gYx == (short) -1 && this.gYy.axk() < this.gYy.gYd) || (this.gYx == (short) -1 && this.gYy.axk() >= this.gYy.gYd))) {
                            return false;
                        }
                        if (!this.gYy.gYg || this.gYx == (short) 0) {
                            return true;
                        }
                        v.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[]{Short.valueOf(this.gYx)});
                        if (this.gYx == (short) 1) {
                            this.gYy.a(true, 200);
                            return false;
                        }
                        this.gYy.a(false, 200);
                        return false;
                }
                return false;
            }
        });
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrB, "");
        if (!be.kS(str) && (this.gXY == -1000.0d || this.gXZ == -1000.0d)) {
            String[] split = str.split(",");
            v.i("MicroMsg.MMPoiMapUI", "lastlocationinfo " + str);
            if (split.length == 2) {
                float KL = (float) ((((double) be.KL(split[0])) * 1.0d) / 1000000.0d);
                float KL2 = (float) ((((double) be.KL(split[1])) * 1.0d) / 1000000.0d);
                if (this.gUC != null) {
                    this.gUC.getIController().setCenter((double) KL, (double) KL2);
                }
            }
        }
        this.gXJ.nWA = new com.tencent.mm.ui.base.MMLoadMoreListView.a(this) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void adB() {
                c.f(this.gYy);
            }
        };
        this.gXP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void onClick(View view) {
                this.gYy.gUC.getIController().animateTo(this.gYy.gXY, this.gYy.gXZ);
                this.gYy.lat = this.gYy.gXY;
                this.gYy.lng = this.gYy.gXZ;
                this.gYy.gXI.i(this.gYy.lat, this.gYy.lng);
                this.gYy.gXP.setBackgroundResource(2130838483);
                this.gYy.gXP.setEnabled(true);
                this.gYy.NH();
                this.gYy.gYv = false;
                this.gYy.gXM.gYv = false;
            }
        });
        this.gXy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void onClick(View view) {
                this.gYy.bM(c.gYs, this.gYy.gXM.gYI);
                this.gYy.axg();
                this.gYy.aXH.finish();
            }
        });
        this.gXS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void onClick(View view) {
                c.p(this.gYy);
            }
        });
        this.gXJ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                v.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[]{Integer.valueOf(i)});
                if (!this.gYy.gYa) {
                    if (i >= this.gYy.gXM.getCount()) {
                        v.i("MicroMsg.MMPoiMapUI", "wrong position");
                        return;
                    }
                    f mv = this.gYy.gXM.mv(i);
                    if (mv.type == 0) {
                        View r = this.gYy.gXX;
                        double d = mv.aIl;
                        double d2 = mv.aIm;
                        if (r.gUj) {
                            r.gUC.updateViewLayout(r, d, d2);
                        } else {
                            r.gUj = true;
                            r.gUC.addView(r, d, d2);
                        }
                        this.gYy.gXP.setBackgroundResource(2130838482);
                    } else {
                        this.gYy.gXX.remove();
                        this.gYy.gXP.setEnabled(true);
                    }
                    this.gYy.gUC.getIController().animateTo(mv.aIl, mv.aIm);
                    this.gYy.gXM.gYI = i;
                    this.gYy.gXM.notifyDataSetChanged();
                }
                this.gYy.gYv = false;
            }
        });
        this.gXT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final void onClick(View view) {
                if (!this.gYy.gYa) {
                    c.u(this.gYy);
                }
                this.gYy.gXN.clean();
                this.gYy.gXK.setAdapter(this.gYy.gXN);
                this.gYy.gXN.notifyDataSetChanged();
                this.gYy.gXL.setVisibility(8);
            }
        });
        this.gXU.L(getString(2131233535));
        this.gXU.oUF = new com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a(this) {
            final /* synthetic */ c gYy;

            {
                this.gYy = r1;
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void pA(String str) {
                v.i("MicroMsg.MMPoiMapUI", "onSearchBtnClick");
                this.gYy.gXV.setVisibility(8);
                this.gYy.gXL.setVisibility(0);
                this.gYy.gXN.clean();
                this.gYy.gXN.notifyDataSetChanged();
                this.gYy.cUh = str;
                this.gYy.gXK.bCj();
                this.gYy.NH();
                this.gYy.axg();
            }

            public final void YC() {
            }

            public final void YD() {
                v.v("MicroMsg.MMPoiMapUI", "on search home btn click");
                this.gYy.bM(c.gYu, this.gYy.gXN.gYI);
                this.gYy.a(null);
            }
        };
        this.gYj = (FrameLayout) findViewById(2131758563);
        this.gYd = b.a(this.aXH, 280.0f);
        this.gYe = b.a(this.aXH, 150.0f);
        int dw = com.tencent.mm.bd.a.dw(this.aXH);
        int identifier = aa.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            identifier = aa.getResources().getDimensionPixelSize(identifier);
        } else {
            identifier = 0;
        }
        dw = ((dw - this.gYe) - identifier) - com.tencent.mm.bd.a.N(this.aXH, 2131493015);
        if (dw > com.tencent.mm.bd.a.N(this.aXH, 2131493560)) {
            v.i("MicroMsg.MMPoiMapUI", "reset listview height: %s, statusBar: %s, actionBar: %s", new Object[]{Integer.valueOf(dw), Integer.valueOf(identifier), Integer.valueOf(r3)});
            LayoutParams layoutParams = this.gYc.getLayoutParams();
            layoutParams.height = dw;
            this.gYc.setLayoutParams(layoutParams);
        }
    }

    public final com.tencent.mm.plugin.e.d axi() {
        return (com.tencent.mm.plugin.e.d) this.aXH.findViewById(2131755380);
    }

    private void a(final boolean z, long j) {
        a aVar;
        a aVar2;
        this.gYg = false;
        if (z) {
            aVar = new a(this, (float) (-(axk() - this.gYe)));
            aVar2 = new a(this, (float) ((-(axk() - this.gYe)) / 2));
        } else {
            aVar = new a(this, (float) (this.gYd - axk()));
            aVar2 = new a(this, (float) ((this.gYd - axk()) / 2));
        }
        AnimationListener anonymousClass11 = new AnimationListener(this) {
            final /* synthetic */ c gYy;

            public final void onAnimationStart(Animation animation) {
                v.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
                this.gYy.gYg = false;
                this.gYy.gYh = true;
            }

            public final void onAnimationEnd(Animation animation) {
                this.gYy.gYg = true;
                if (z) {
                    this.gYy.mu(this.gYy.gYe);
                    this.gYy.gYi = true;
                } else {
                    this.gYy.mu(this.gYy.gYd);
                    this.gYy.gYi = false;
                }
                this.gYy.gYc.clearAnimation();
                this.gYy.gXP.clearAnimation();
                this.gYy.gYj.clearAnimation();
                this.gYy.gXJ.clearFocus();
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        aVar.setDuration(200);
        aVar = aVar.axm();
        aVar.setAnimationListener(anonymousClass11);
        aVar.bT(this.gYc).bT(this.gXP).axn();
        aVar2.setDuration(200);
        aVar2.axm().bT(this.gYj).axn();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        v.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent");
        if (this.gYa) {
            a(null);
            bM(gYu, this.gXN.gYI);
            return false;
        }
        bM(gYs, this.gXM.gYI);
        this.aXH.finish();
        return true;
    }

    private void a(f fVar) {
        this.cUh = "";
        this.gYa = false;
        this.gXL.setVisibility(8);
        this.gXK.setVisibility(8);
        this.gXU.setVisibility(8);
        this.gXU.Pw("");
        this.gXV.setVisibility(8);
        this.gXJ.setVisibility(0);
        this.gXJ.setAdapter(this.gXM);
        this.gXM.notifyDataSetChanged();
        findViewById(2131758187).setVisibility(0);
        axg();
        if (fVar != null) {
            this.gUC.getIController().setCenter(fVar.aIl, fVar.aIm);
            this.lat = ((double) this.gUC.getMapCenterX()) / 1000000.0d;
            this.lng = ((double) this.gUC.getMapCenterY()) / 1000000.0d;
            PickPoi pickPoi = this.gXI;
            pickPoi.i(this.lat, this.lng);
            pickPoi.gYE = false;
            NH();
        }
    }

    public final void axj() {
        PickPoi pickPoi = this.gXI;
        pickPoi.gTL.clearAnimation();
        pickPoi.gTL.startAnimation(pickPoi.gTK);
        this.lat = ((double) this.gUC.getMapCenterX()) / 1000000.0d;
        this.lng = ((double) this.gUC.getMapCenterY()) / 1000000.0d;
        this.gXI.i(this.lat, this.lng);
        this.gXP.setBackgroundResource(2130838482);
        if (this.gYi) {
            a(false, 200);
        }
        NH();
        this.gYv = false;
        this.gXM.gYv = false;
    }

    private void NH() {
        int i = 1;
        if (this.gXX != null) {
            this.gXX.remove();
        }
        double d = this.lat;
        this.gSb = ((int) (d * 1000000.0d)) + "_" + ((int) (this.lng * 1000000.0d)) + "_" + this.cUh;
        if (this.gSb.equals(this.gXM.apU)) {
            v.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[]{this.gSb});
            return;
        }
        byte[] bArr;
        int i2;
        if (this.gYa) {
            this.gXK.bCj();
            this.gXN.clean();
            this.gXN.vV(this.gSb);
            bArr = this.gXN.buffer;
            this.gXN.notifyDataSetChanged();
        } else {
            this.gXJ.bCj();
            this.gXM.clean();
            this.gXM.vV(this.gSb);
            this.gXM.notifyDataSetChanged();
            bArr = this.gXM.buffer;
            this.gXO.setVisibility(0);
            eb(false);
            if (this.gXI.gYE) {
                this.gXM.b(this.gXI.gYD);
            }
        }
        if (this.gYb == 0) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        double d2 = this.lat;
        double d3 = this.lng;
        if (this.gYa) {
            i = 0;
        }
        this.gXQ = new h(bArr, d2, d3, i2, i, (double) this.gYl, (double) this.gYk, this.gSb, this.cUh);
        ak.vy().a(this.gXQ, 0);
        this.gYm++;
        if (this.gYp == -1) {
            this.gYp = System.currentTimeMillis();
        }
    }

    private void bM(int i, int i2) {
        String str;
        if (this.gXY == -1000.0d || this.gXZ == -1000.0d) {
            str = "null/null";
        } else {
            str = String.format("%f/%f", new Object[]{Double.valueOf(this.gXY), Double.valueOf(this.gXZ)});
        }
        v.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.gYp), Long.valueOf(this.gYo), Long.valueOf(this.gYn), Integer.valueOf(this.gYm), str, Integer.valueOf(this.gYq)});
        com.tencent.mm.plugin.report.service.g.iuh.h(11135, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.gYp), Long.valueOf(this.gYo), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.gYn), Integer.valueOf(this.gYm), str, "", Integer.valueOf(this.gYq), "", p.rJ()});
    }

    public final void onResume() {
        super.onResume();
        com.tencent.mm.modelgeo.c.FY().a(this.bYl);
        com.tencent.mm.plugin.location.ui.e eVar = this.gXW;
        eVar.gUh.a(eVar.bYl);
    }

    public final void onPause() {
        super.onPause();
        com.tencent.mm.modelgeo.c.FY().c(this.bYl);
        com.tencent.mm.plugin.location.ui.e eVar = this.gXW;
        eVar.gUh.c(eVar.bYl);
    }

    private void eb(boolean z) {
        v.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[]{Boolean.valueOf(z)});
        this.gXS.setEnabled(z);
        findViewById(2131755265).setEnabled(z);
        this.gXT.setEnabled(z);
    }

    public final void onDestroy() {
        super.onDestroy();
        ak.vy().b(457, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 457 && i == 0 && i2 == 0) {
            this.gXQ = null;
            h hVar = (h) kVar;
            if (hVar.gSb.equals(this.gSb)) {
                v.i("MicroMsg.MMPoiMapUI", "isend " + hVar.eDI);
                if (this.gYn == -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.gYo = currentTimeMillis;
                    this.gYn = currentTimeMillis;
                } else {
                    this.gYo = System.currentTimeMillis();
                }
                if (this.gYa) {
                    this.gXL.setVisibility(8);
                    if (this.gXN.getCount() == 0 && hVar.gKQ != null && hVar.gKQ.size() == 0) {
                        this.gXV.setVisibility(0);
                        this.gXK.bCj();
                        return;
                    }
                    this.gXN.a(hVar.gKQ, hVar.gSa, hVar.eDI, hVar.gSb);
                    this.gXN.notifyDataSetChanged();
                    if (this.gXN.eDI) {
                        this.gXK.bCj();
                        return;
                    }
                    this.gXK.bCi();
                    this.gXK.bCk();
                    return;
                }
                if (this.gXH != null) {
                    xm xmVar = (xm) hVar.cif.czl.czs;
                    PoiHeaderView poiHeaderView = this.gXH;
                    CharSequence charSequence = xmVar.mzO;
                    String str2 = xmVar.mzt;
                    String str3 = xmVar.glb;
                    ak.yW();
                    String wP = com.tencent.mm.model.c.wP();
                    v.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[]{str2, str3});
                    poiHeaderView.gUx = str3;
                    poiHeaderView.gUy = "";
                    if (be.kS(charSequence) || be.kS(str2)) {
                        poiHeaderView.setVisibility(8);
                        poiHeaderView.eRp.setVisibility(8);
                        poiHeaderView.gUz.setVisibility(8);
                    } else {
                        poiHeaderView.setVisibility(0);
                        poiHeaderView.eRp.setVisibility(0);
                        poiHeaderView.gUz.setVisibility(0);
                        poiHeaderView.eRp.setText(charSequence);
                        SimpleImageView simpleImageView = poiHeaderView.gUz;
                        simpleImageView.imagePath = wP;
                        simpleImageView.url = str2;
                        simpleImageView.gVE = 0;
                        simpleImageView.fQm = 0;
                        if (str2 == null || str2.length() == 0) {
                            simpleImageView.setVisibility(8);
                        } else if (str2.startsWith("http")) {
                            r0 = BitmapFactory.decodeFile(simpleImageView.imagePath + com.tencent.mm.a.g.m(str2.getBytes()));
                            if (r0 != null) {
                                if (simpleImageView.gVE > 0 && simpleImageView.fQm > 0) {
                                    r0 = com.tencent.mm.sdk.platformtools.d.a(r0, simpleImageView.gVE, simpleImageView.fQm, true, false);
                                }
                                simpleImageView.setImageBitmap(r0);
                            } else {
                                com.tencent.mm.sdk.i.e.a(new a(str2, simpleImageView.handler), "SimpleImageView_download");
                            }
                        } else if (com.tencent.mm.a.e.aR(str2)) {
                            r0 = (simpleImageView.gVE <= 0 || simpleImageView.fQm <= 0) ? com.tencent.mm.sdk.platformtools.d.JV(str2) : com.tencent.mm.sdk.platformtools.d.b(str2, simpleImageView.gVE, simpleImageView.fQm, true);
                            if (r0 == null) {
                                simpleImageView.setVisibility(8);
                            } else {
                                simpleImageView.setImageBitmap(r0);
                            }
                        } else {
                            simpleImageView.setVisibility(8);
                        }
                    }
                }
                this.gXO.setVisibility(8);
                eb(true);
                if (this.gXR != null) {
                    for (f fVar : hVar.gKQ) {
                        if (fVar.gYP != null && fVar.mName != null && fVar.gYP.equals(this.gXR.gYP) && fVar.mName.equals(this.gXR.mName)) {
                            hVar.gKQ.remove(fVar);
                            break;
                        }
                    }
                    this.gXM.b(this.gXR);
                    this.gXR = null;
                    this.gYv = true;
                    this.gXM.gYv = true;
                }
                this.gXM.a(hVar.gKQ, hVar.gSa, hVar.eDI, hVar.gSb);
                this.gXM.gYI = 0;
                this.gXM.notifyDataSetChanged();
                if (this.gXM.eDI) {
                    this.gXJ.bCj();
                    return;
                }
                this.gXJ.bCi();
                this.gXJ.bCk();
                return;
            }
            v.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.gSb + " " + hVar.gSb);
        }
    }

    public final void mu(int i) {
        ((FrameLayout.LayoutParams) this.gYc.getLayoutParams()).topMargin = i;
        ((FrameLayout.LayoutParams) this.gXP.getLayoutParams()).topMargin = i - b.a(this.aXH, 65.0f);
        int i2 = (i - this.gYf) / 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYj.getLayoutParams();
        if (i == this.gYe) {
            layoutParams.topMargin = b.a(this.aXH, -65.0f);
        } else if (i == this.gYd) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = i2 + layoutParams.topMargin;
        }
        this.gYj.requestLayout();
        this.gYf = i;
        this.gYc.requestLayout();
        this.gXP.requestLayout();
    }

    public final int axk() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.gYc.getLayoutParams();
        this.gYf = marginLayoutParams.topMargin;
        return marginLayoutParams.topMargin;
    }
}
