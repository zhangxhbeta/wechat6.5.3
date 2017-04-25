package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.mm.plugin.appbrand.config.a.c;
import com.tencent.mm.plugin.appbrand.page.h.AnonymousClass12;
import com.tencent.mm.plugin.appbrand.page.h.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.page.h.AnonymousClass6;
import com.tencent.mm.plugin.appbrand.page.h.AnonymousClass9;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class e extends SwipeBackLayout implements a, j.a {
    protected f dNh;
    private boolean dNi;
    boolean dNj = false;

    public abstract h QZ();

    public abstract String Ra();

    public abstract void b(String str, String str2, int[] iArr);

    protected abstract View getContentView();

    public abstract void loadUrl(String str);

    public abstract boolean nV(String str);

    public e(Context context, f fVar) {
        super(context);
        this.dNh = fVar;
        setLayoutParams(new LayoutParams(-1, -1));
        init();
        this.pew = false;
        ks(true);
        addView(getContentView());
        this.Hq = getContentView();
        this.peB = this;
    }

    public void OE() {
        j.b(this);
    }

    public void QW() {
        boolean z = true;
        v.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[]{Ra()});
        j.b(this);
        if (this.dNh.dNC.size() == 1) {
            z = false;
        }
        this.hVC = z;
        this.paQ = false;
        this.dNi = false;
    }

    public void QX() {
        v.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[]{Ra()});
        this.hVC = false;
        j.a(this);
        this.dNi = true;
    }

    protected void QY() {
        v.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[]{Ra()});
    }

    public final void hide() {
        if (this.dNi) {
            setVisibility(4);
        }
    }

    protected final h Rc() {
        f fVar = this.dNh;
        if (fVar.dNE == null) {
            return new h(fVar.getContext(), fVar.dzg);
        }
        h hVar = fVar.dNE;
        fVar.dNE = null;
        hVar.setVisibility(0);
        fVar.removeView(hVar);
        return hVar;
    }

    private c Rd() {
        com.tencent.mm.plugin.appbrand.config.a aVar = this.dNh.dNB;
        String ov = com.tencent.mm.plugin.appbrand.k.j.ov(Ra());
        return aVar.dCt.containsKey(ov) ? (c) aVar.dCt.get(ov) : com.tencent.mm.plugin.appbrand.config.a.b(null, aVar.dCs);
    }

    protected final void Re() {
        c Rd = Rd();
        h QZ = QZ();
        String str = Rd.dCA;
        String str2 = Rd.dCz;
        int bn = d.bn(str, QZ.getContext().getResources().getColor(2131690051));
        if (QZ.getContext() instanceof Activity) {
            int systemUiVisibility;
            Window window = ((Activity) QZ.getContext()).getWindow();
            if (VERSION.SDK_INT >= 23 && !f.Sl()) {
                systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                window.getDecorView().setSystemUiVisibility("black".equals(str2) ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
                systemUiVisibility = bn;
            } else if (VERSION.SDK_INT >= 21) {
                systemUiVisibility = "black".equals(str2) ? f.e(bn, 0.78f) : bn;
            }
            window.setStatusBarColor(systemUiVisibility);
        }
        if (com.tencent.mm.plugin.appbrand.a.ms(this.dNh.dzg).scene != 1023) {
            QZ().dOg.bF(false);
            QZ().dOg.bE(false);
        } else if (this.dNh.dNC.size() == 1) {
            QZ().dOg.bF(true);
        } else {
            QZ().dOg.bF(false);
            QZ().dOg.bE(true);
        }
    }

    protected final void Rf() {
        c Rd = Rd();
        QZ().of(Rd.dCy);
        h QZ = QZ();
        QZ.runOnUiThread(new AnonymousClass2(QZ, Rd.dCA));
        QZ = QZ();
        QZ.runOnUiThread(new AnonymousClass6(QZ, Rd.dCz));
        QZ = QZ();
        QZ.runOnUiThread(new AnonymousClass9(QZ, Rd.dCD));
        QZ = QZ();
        QZ.runOnUiThread(new AnonymousClass12(QZ, Rd.dCE, Rd.dCB));
        QZ().dNn.setBackgroundColor(d.bn(Rd.dCB, -1));
    }

    private void a(String str, n nVar) {
        Map hashMap = new HashMap();
        hashMap.put("path", com.tencent.mm.plugin.appbrand.k.j.ov(Ra()));
        hashMap.put("query", com.tencent.mm.plugin.appbrand.k.j.ow(Ra()));
        if (nVar != null) {
            hashMap.put("openType", nVar.toString());
        }
        com.tencent.mm.plugin.appbrand.k.a.p(hashMap);
        QZ().a(str, new JSONObject(hashMap).toString(), null);
    }

    public final void a(n nVar) {
        a("onAppRoute", nVar);
        v.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[]{nVar.toString(), Ra()});
    }

    public final void Rg() {
        a("onAppRouteDone", null);
        v.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[]{Ra()});
    }

    protected static boolean d(int[] iArr, int i) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final void I(float f) {
        if (this.dNi) {
            if (f != 1.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.j.m(getContentView(), 0.0f);
            return;
        }
        com.tencent.mm.ui.tools.j.m(getContentView(), (((float) (getContentView().getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }

    public final void c(boolean z, int i) {
        long j = 120;
        if (z) {
            View contentView = getContentView();
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(contentView, j, 0.0f, null);
            return;
        }
        contentView = getContentView();
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(contentView, j, (float) ((getContentView().getWidth() * -1) / 4), null);
    }

    public final boolean Ri() {
        return false;
    }

    public final void Rj() {
        this.dNh.Rl();
    }

    public final void Rk() {
        this.dNj = true;
    }

    public final void onCancel() {
        this.dNj = false;
    }
}
