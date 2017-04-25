package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.support.v4.view.al;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.y;
import android.support.v7.a.a.k;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d extends ActionBar implements android.support.v7.widget.ActionBarOverlayLayout.a {
    private static final Interpolator Hj = new AccelerateInterpolator();
    private static final Interpolator Hk = new DecelerateInterpolator();
    private static final boolean Hl = (VERSION.SDK_INT >= 14);
    u GR;
    private boolean GU;
    private ArrayList<Object> GV = new ArrayList();
    private boolean HA;
    private boolean HB;
    private boolean HC;
    private boolean HD = true;
    private h HE;
    private boolean HF;
    final al HH = new am(this) {
        final /* synthetic */ d nPo;

        {
            this.nPo = r1;
        }

        public final void q(View view) {
            if (this.nPo.Hz && this.nPo.Hq != null) {
                y.c(this.nPo.Hq, 0.0f);
                y.c(this.nPo.Ho, 0.0f);
            }
            this.nPo.Ho.setVisibility(8);
            this.nPo.Ho.J(false);
            this.nPo.HE = null;
            d dVar = this.nPo;
            if (dVar.Hw != null) {
                dVar.Hw.a(dVar.Hv);
                dVar.Hv = null;
                dVar.Hw = null;
            }
        }
    };
    final al HI = new am(this) {
        final /* synthetic */ d nPo;

        {
            this.nPo = r1;
        }

        public final void q(View view) {
            this.nPo.HE = null;
            this.nPo.Ho.requestLayout();
        }
    };
    final an HJ = new an(this) {
        final /* synthetic */ d nPo;

        {
            this.nPo = r1;
        }

        public final void cc() {
            ((View) this.nPo.Ho.getParent()).invalidate();
        }
    };
    private Context Hm;
    private ActionBarContainer Ho;
    private ActionBarContextView Hp;
    private View Hq;
    private boolean Ht;
    b Hv;
    android.support.v7.view.b.a Hw;
    private int Hy = 0;
    private boolean Hz = true;
    private Context mContext;
    a nPn;
    private Activity pP;

    public class a extends b implements android.support.v7.view.menu.f.a {
        private final Context HL;
        private android.support.v7.view.b.a HM;
        private WeakReference<View> HN;
        private final f dV;
        final /* synthetic */ d nPo;

        public a(d dVar, Context context, android.support.v7.view.b.a aVar) {
            this.nPo = dVar;
            this.HL = context;
            this.HM = aVar;
            f fVar = new f(context);
            this.dV = fVar;
            this.dV.a((android.support.v7.view.menu.f.a) this);
        }

        public final MenuInflater getMenuInflater() {
            return new g(this.HL);
        }

        public final Menu getMenu() {
            return this.dV;
        }

        public final void finish() {
            if (this.nPo.nPn == this) {
                if (d.a(this.nPo.HA, this.nPo.HB, false)) {
                    this.HM.a(this);
                } else {
                    this.nPo.Hv = this;
                    this.nPo.Hw = this.HM;
                }
                this.HM = null;
                this.nPo.C(false);
                this.nPo.Hp.dS();
                this.nPo.GR.eM().sendAccessibilityEvent(32);
                this.nPo.nPn = null;
            }
        }

        public final void invalidate() {
            if (this.nPo.nPn == this) {
                this.dV.dA();
                try {
                    this.HM.b(this, this.dV);
                } finally {
                    this.dV.dB();
                }
            }
        }

        public final boolean di() {
            this.dV.dA();
            try {
                boolean a = this.HM.a((b) this, this.dV);
                return a;
            } finally {
                this.dV.dB();
            }
        }

        public final void setCustomView(View view) {
            this.nPo.Hp.setCustomView(view);
            this.HN = new WeakReference(view);
        }

        public final void setSubtitle(CharSequence charSequence) {
            this.nPo.Hp.setSubtitle(charSequence);
        }

        public final void setTitle(CharSequence charSequence) {
            this.nPo.Hp.setTitle(charSequence);
        }

        public final void setTitle(int i) {
            setTitle(this.nPo.mContext.getResources().getString(i));
        }

        public final void setSubtitle(int i) {
            setSubtitle(this.nPo.mContext.getResources().getString(i));
        }

        public final CharSequence getTitle() {
            return this.nPo.Hp.up;
        }

        public final CharSequence getSubtitle() {
            return this.nPo.Hp.uq;
        }

        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            this.nPo.Hp.K(z);
        }

        public final boolean isTitleOptional() {
            return this.nPo.Hp.Rc;
        }

        public final View getCustomView() {
            return this.HN != null ? (View) this.HN.get() : null;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            if (this.HM != null) {
                return this.HM.a((b) this, menuItem);
            }
            return false;
        }

        public final void b(f fVar) {
            if (this.HM != null) {
                invalidate();
                this.nPo.Hp.showOverflowMenu();
            }
        }
    }

    public d(Activity activity, ViewGroup viewGroup) {
        u uVar;
        this.pP = activity;
        View findViewById = viewGroup.findViewById(android.support.v7.a.a.f.IU);
        if (findViewById instanceof u) {
            uVar = (u) findViewById;
        } else if (findViewById instanceof Toolbar) {
            uVar = ((Toolbar) findViewById).hb();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(findViewById).toString() != null ? findViewById.getClass().getSimpleName() : "null");
        }
        this.GR = uVar;
        this.Hp = (ActionBarContextView) viewGroup.findViewById(android.support.v7.a.a.f.IZ);
        this.Ho = (ActionBarContainer) viewGroup.findViewById(android.support.v7.a.a.f.IW);
        if (this.GR == null || this.Hp == null || this.Ho == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        boolean z;
        this.mContext = this.GR.getContext();
        if ((this.GR.getDisplayOptions() & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.Ht = true;
        }
        android.support.v7.view.a.m(this.mContext).dk();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
        obtainStyledAttributes.getBoolean(19, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(24, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        this.Hq = null;
    }

    public final void setElevation(float f) {
        y.g(this.Ho, f);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        LayoutParams layoutParams = this.GR.eM().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = com.tencent.mm.compatible.util.a.e(this.pP);
        }
        this.GR.eM().setLayoutParams(layoutParams);
    }

    public final void onWindowVisibilityChanged(int i) {
        this.Hy = i;
    }

    public final void x(boolean z) {
        this.HF = z;
        if (!z && this.HE != null) {
            this.HE.cancel();
        }
    }

    public final void y(boolean z) {
        if (z != this.GU) {
            this.GU = z;
            int size = this.GV.size();
            for (int i = 0; i < size; i++) {
                this.GV.get(i);
            }
        }
    }

    public final void cN() {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(2130903079, this.GR.eM(), false));
    }

    public final void cP() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void cQ() {
        setDisplayOptions(0, 8);
    }

    public final void cR() {
        setDisplayOptions(16, 16);
    }

    public final void e(CharSequence charSequence) {
        this.GR.e(charSequence);
    }

    public final void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.Ht = true;
        }
        this.GR.setDisplayOptions(i);
    }

    private void setDisplayOptions(int i, int i2) {
        int displayOptions = this.GR.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.Ht = true;
        }
        this.GR.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.Ho.l(drawable);
    }

    public final View getCustomView() {
        return this.GR.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.GR.getTitle();
    }

    public final int getDisplayOptions() {
        return this.GR.getDisplayOptions();
    }

    public final b a(android.support.v7.view.b.a aVar) {
        if (this.nPn != null) {
            this.nPn.finish();
        }
        this.Hp.dT();
        b aVar2 = new a(this, this.Hp.getContext(), aVar);
        if (!aVar2.di()) {
            return null;
        }
        aVar2.invalidate();
        this.Hp.c(aVar2);
        C(true);
        this.Hp.sendAccessibilityEvent(32);
        this.nPn = aVar2;
        return aVar2;
    }

    public final int getHeight() {
        return this.Ho.getHeight();
    }

    public final void A(boolean z) {
        this.Hz = z;
    }

    public final void show() {
        if (this.HA) {
            this.HA = false;
            B(false);
        }
    }

    public final void df() {
        if (this.HB) {
            this.HB = false;
            B(true);
        }
    }

    public final void hide() {
        if (!this.HA) {
            this.HA = true;
            B(false);
        }
    }

    public final void dg() {
        if (!this.HB) {
            this.HB = true;
            B(true);
        }
    }

    private static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void B(boolean z) {
        float f;
        h hVar;
        ah r;
        if (a(this.HA, this.HB, this.HC)) {
            if (!this.HD) {
                this.HD = true;
                if (this.HE != null) {
                    this.HE.cancel();
                }
                this.Ho.setVisibility(0);
                if (this.Hy == 0 && Hl && (this.HF || z)) {
                    y.c(this.Ho, 0.0f);
                    f = (float) (-this.Ho.getHeight());
                    if (z) {
                        int[] iArr = new int[]{0, 0};
                        this.Ho.getLocationInWindow(iArr);
                        f -= (float) iArr[1];
                    }
                    y.c(this.Ho, f);
                    hVar = new h();
                    r = y.U(this.Ho).r(0.0f);
                    r.a(this.HJ);
                    hVar.g(r);
                    if (this.Hz && this.Hq != null) {
                        y.c(this.Hq, f);
                        hVar.g(y.U(this.Hq).r(0.0f));
                    }
                    hVar.c(Hk);
                    hVar.dp();
                    hVar.b(this.HI);
                    this.HE = hVar;
                    hVar.start();
                    return;
                }
                y.d(this.Ho, 1.0f);
                y.c(this.Ho, 0.0f);
                if (this.Hz && this.Hq != null) {
                    y.c(this.Hq, 0.0f);
                }
                this.HI.q(null);
            }
        } else if (this.HD) {
            this.HD = false;
            if (this.HE != null) {
                this.HE.cancel();
            }
            if (this.Hy == 0 && Hl && (this.HF || z)) {
                y.d(this.Ho, 1.0f);
                this.Ho.J(true);
                hVar = new h();
                f = (float) (-this.Ho.getHeight());
                if (z) {
                    int[] iArr2 = new int[]{0, 0};
                    this.Ho.getLocationInWindow(iArr2);
                    f -= (float) iArr2[1];
                }
                r = y.U(this.Ho).r(f);
                r.a(this.HJ);
                hVar.g(r);
                if (this.Hz && this.Hq != null) {
                    hVar.g(y.U(this.Hq).r(f));
                }
                hVar.c(Hj);
                hVar.dp();
                hVar.b(this.HH);
                this.HE = hVar;
                hVar.start();
                return;
            }
            this.HH.q(null);
        }
    }

    public final boolean isShowing() {
        int height = this.Ho.getHeight();
        return this.HD && (height == 0 || height > 0);
    }

    public final void C(boolean z) {
        ah b;
        ah b2;
        if (z) {
            if (!this.HC) {
                this.HC = true;
                B(false);
            }
        } else if (this.HC) {
            this.HC = false;
            B(false);
        }
        if (z) {
            b = this.GR.b(8, 100);
            b2 = this.Hp.b(0, 200);
        } else {
            b2 = this.GR.b(0, 200);
            b = this.Hp.b(8, 100);
        }
        h hVar = new h();
        hVar.a(b, b2);
        hVar.start();
    }

    public final Context getThemedContext() {
        if (this.Hm == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.Hm = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.Hm = this.mContext;
            }
        }
        return this.Hm;
    }

    public final void dh() {
        if (this.HE != null) {
            this.HE.cancel();
            this.HE = null;
        }
    }

    public final boolean collapseActionView() {
        if (this.GR == null || !this.GR.hasExpandedActionView()) {
            return false;
        }
        this.GR.collapseActionView();
        return true;
    }

    public final void setCustomView(View view) {
        this.GR.setCustomView(view);
    }

    public final void cO() {
        this.GR.setIcon(2130839576);
    }

    public final void setLogo(Drawable drawable) {
        this.GR.setLogo(drawable);
    }

    public final void w(boolean z) {
        if (!this.Ht) {
            setDisplayHomeAsUpEnabled(z);
        }
    }
}
