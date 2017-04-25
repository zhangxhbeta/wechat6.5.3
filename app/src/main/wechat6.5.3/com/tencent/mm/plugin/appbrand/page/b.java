package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.page.h.c;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b extends e {
    private String dMS;
    private boolean dMT = false;
    private LinearLayout dMU;
    private d dMV;
    private FrameLayout dMW;
    private h dMX = Rc();
    private Map<String, h> dMY = new HashMap();
    private LinkedList<a> dMZ = new LinkedList();
    private HashSet<h> dNa = new HashSet();

    private static abstract class a implements Runnable {
        boolean QK;
        private boolean dNe;

        public abstract void Rb();

        private a() {
            this.dNe = false;
            this.QK = false;
        }

        public void run() {
            boolean z = (this.dNe || this.QK) ? false : true;
            if (z) {
                this.dNe = true;
                Rb();
            }
        }
    }

    public b(Context context, f fVar) {
        super(context, fVar);
    }

    protected final View getContentView() {
        if (this.dMU == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            this.dMW = new FrameLayout(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.dMW.setLayoutParams(layoutParams);
            this.dMV = QV();
            if ("top".equals(this.dNh.dNB.dCu.dCJ)) {
                linearLayout.addView(this.dMV);
                linearLayout.addView(this.dMW);
            } else {
                linearLayout.addView(this.dMW);
                linearLayout.addView(this.dMV);
            }
            this.dMU = linearLayout;
        }
        return this.dMU;
    }

    private d QV() {
        int i;
        d dVar = new d(getContext());
        com.tencent.mm.plugin.appbrand.config.a.d dVar2 = this.dNh.dNB.dCu;
        dVar.dVC = dVar2.dCJ;
        String str = dVar2.coN;
        String str2 = dVar2.dCK;
        String str3 = dVar2.dCB;
        String str4 = dVar2.dCL;
        dVar.dVD = com.tencent.mm.plugin.webview.ui.tools.d.bn(str, dVar.getResources().getColor(2131689909));
        dVar.dVE = com.tencent.mm.plugin.webview.ui.tools.d.bn(str2, dVar.getResources().getColor(2131690123));
        float fromDPToPix = (float) com.tencent.mm.bd.a.fromDPToPix(dVar.getContext(), 1);
        if (fromDPToPix / 2.0f > 1.0f) {
            i = (int) (fromDPToPix / 2.0f);
        } else {
            i = 1;
        }
        new GradientDrawable().setColor(com.tencent.mm.plugin.webview.ui.tools.d.bn(str3, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        if ("white".equals(str4)) {
            gradientDrawable.setStroke(i, Color.parseColor("#33ffffff"));
        } else {
            gradientDrawable.setStroke(i, Color.parseColor("#33000000"));
        }
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{r2, gradientDrawable});
        if ("top".equals(dVar.dVC)) {
            layerDrawable.setLayerInset(1, -i, -i, -i, -i);
        } else {
            layerDrawable.setLayerInset(1, -i, 0, -i, -i);
        }
        dVar.dVB.setImageDrawable(layerDrawable);
        Iterator it = dVar2.bjA.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            str2 = eVar.url;
            str3 = eVar.text;
            str4 = eVar.bll;
            str = eVar.dCM;
            a aVar = new a();
            try {
                aVar.us = d.oG(str4);
                aVar.dVJ = d.oG(str);
            } catch (Exception e) {
                v.e("MicroMsg.AppBrandPageTabBar", e.getMessage());
            }
            aVar.dVK = str3;
            aVar.mUrl = str2;
            if (aVar.dVK == null && (aVar.us == null || aVar.dVJ == null)) {
                v.e("MicroMsg.AppBrandPageTabBar", "illegal data");
            } else {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(dVar.getContext()).inflate(2130903118, dVar.dVA, false);
                dVar.a(linearLayout, aVar, false);
                linearLayout.setOnClickListener(new OnClickListener(dVar) {
                    final /* synthetic */ d dVI;

                    {
                        this.dVI = r1;
                    }

                    public final void onClick(View view) {
                        this.dVI.hA(this.dVI.dVA.indexOfChild(view));
                        d.b(this.dVI);
                    }
                });
                dVar.dVF.add(aVar);
                dVar.dVA.addView(linearLayout);
            }
        }
        dVar.dVH = new com.tencent.mm.plugin.appbrand.widget.d.b(this) {
            final /* synthetic */ b dNb;

            {
                this.dNb = r1;
            }

            public final void nW(String str) {
                this.dNb.dNh.nZ(str);
            }
        };
        return dVar;
    }

    public final void loadUrl(final String str) {
        if (!str.equals(this.dMS)) {
            int oH = this.dMV.oH(str);
            if (oH >= 0) {
                this.dMS = str;
                this.dMV.hA(oH);
                if (this.dMY.get(str) == null) {
                    final h nT = nT(str);
                    Rf();
                    final Runnable anonymousClass2 = new a(this) {
                        final /* synthetic */ b dNb;

                        public final void Rb() {
                            this.dNb.nU(str);
                        }
                    };
                    final long currentTimeMillis = System.currentTimeMillis();
                    nT.a(new c(this) {
                        final /* synthetic */ b dNb;

                        public final void onReady() {
                            nT.b((c) this);
                            this.dNb.post(anonymousClass2);
                            long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                            v.i("MicroMsg.AppBrandMultiplePage", "Tab page onReady received, time: %d", new Object[]{Long.valueOf(currentTimeMillis)});
                        }
                    });
                    this.dMZ.add(anonymousClass2);
                    postDelayed(anonymousClass2, 500);
                    nT.oe(str);
                    return;
                }
                Iterator it = this.dMZ.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    removeCallbacks(aVar);
                    aVar.QK = true;
                }
                this.dMZ.clear();
                nU(str);
            }
        }
    }

    private synchronized h nT(String str) {
        View view;
        if (this.dMX != null) {
            view = this.dMX;
            this.dMX = null;
        } else {
            view = Rc();
        }
        view.setVisibility(4);
        this.dMY.put(str, view);
        this.dMW.addView(view);
        return view;
    }

    private void nU(String str) {
        h hVar = (h) this.dMY.get(str);
        hVar.setVisibility(4);
        h hVar2 = null;
        for (h hVar3 : this.dMY.values()) {
            h hVar32;
            if (hVar32.getVisibility() != 0) {
                hVar32 = hVar2;
            }
            hVar2 = hVar32;
        }
        hVar.setVisibility(0);
        hVar.removeView(hVar.dOg);
        if (this.dMU.indexOfChild(hVar.dOg) == -1) {
            this.dMU.addView(hVar.dOg, 0);
        }
        if (hVar2 != null) {
            hVar2.setVisibility(4);
            this.dMU.removeView(hVar2.dOg);
        }
        if (this.dMT) {
            hVar.Rq();
            if (hVar2 != null) {
                hVar2.Qi();
            }
            Re();
        }
    }

    public final boolean nV(String str) {
        return this.dMV.oH(str) != -1;
    }

    public final void QW() {
        super.QW();
        Re();
        QZ().Rq();
        this.dMT = true;
    }

    public final void QX() {
        super.QX();
        QZ().Qi();
        this.dMT = false;
    }

    protected final void QY() {
        super.QY();
        if (this.dMX != null) {
            this.dMX.onDestroy();
        }
        for (h onDestroy : this.dMY.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void b(String str, String str2, int[] iArr) {
        if (this.dMX != null && e.d(iArr, this.dMX.hashCode())) {
            this.dMX.aP(str, str2);
        }
        for (h hVar : this.dMY.values()) {
            if (e.d(iArr, hVar.hashCode())) {
                hVar.aP(str, str2);
            }
        }
    }

    public final void OE() {
        super.OE();
        if (this.dMX != null) {
            this.dMX.OE();
        }
        for (h OE : this.dMY.values()) {
            OE.OE();
        }
    }

    public final synchronized h QZ() {
        h hVar;
        if (this.dMX != null) {
            hVar = this.dMX;
        } else {
            hVar = (h) this.dMY.get(this.dMS);
        }
        return hVar;
    }

    public final String Ra() {
        return this.dMS;
    }
}
