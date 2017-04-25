package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
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
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ai;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class n extends ActionBar implements android.support.v7.widget.ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!n.class.desiredAssertionStatus());
    private static final Interpolator Hj = new AccelerateInterpolator();
    private static final Interpolator Hk = new DecelerateInterpolator();
    private static final boolean Hl;
    private u GR;
    private boolean GU;
    private ArrayList<Object> GV = new ArrayList();
    private boolean HA;
    private boolean HB;
    private boolean HC;
    private boolean HD = true;
    private h HE;
    private boolean HF;
    boolean HG;
    final al HH = new am(this) {
        final /* synthetic */ n HK;

        {
            this.HK = r1;
        }

        public final void q(View view) {
            if (this.HK.Hz && this.HK.Hq != null) {
                y.c(this.HK.Hq, 0.0f);
                y.c(this.HK.Ho, 0.0f);
            }
            this.HK.Ho.setVisibility(8);
            this.HK.Ho.J(false);
            this.HK.HE = null;
            n nVar = this.HK;
            if (nVar.Hw != null) {
                nVar.Hw.a(nVar.Hv);
                nVar.Hv = null;
                nVar.Hw = null;
            }
            if (this.HK.Hn != null) {
                y.Y(this.HK.Hn);
            }
        }
    };
    final al HI = new am(this) {
        final /* synthetic */ n HK;

        {
            this.HK = r1;
        }

        public final void q(View view) {
            this.HK.HE = null;
            this.HK.Ho.requestLayout();
        }
    };
    final an HJ = new an(this) {
        final /* synthetic */ n HK;

        {
            this.HK = r1;
        }

        public final void cc() {
            ((View) this.HK.Ho.getParent()).invalidate();
        }
    };
    private Context Hm;
    private ActionBarOverlayLayout Hn;
    private ActionBarContainer Ho;
    private ActionBarContextView Hp;
    private View Hq;
    private ai Hr;
    private int Hs = -1;
    private boolean Ht;
    a Hu;
    b Hv;
    android.support.v7.view.b.a Hw;
    private boolean Hx;
    private int Hy = 0;
    private boolean Hz = true;
    private ArrayList<Object> jS = new ArrayList();
    private Context mContext;
    private Dialog oy;
    private Activity pP;

    public class a extends b implements android.support.v7.view.menu.f.a {
        final /* synthetic */ n HK;
        private final Context HL;
        private android.support.v7.view.b.a HM;
        private WeakReference<View> HN;
        private final f dV;

        public a(n nVar, Context context, android.support.v7.view.b.a aVar) {
            this.HK = nVar;
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
            if (this.HK.Hu == this) {
                if (n.a(this.HK.HA, this.HK.HB, false)) {
                    this.HM.a(this);
                } else {
                    this.HK.Hv = this;
                    this.HK.Hw = this.HM;
                }
                this.HM = null;
                this.HK.C(false);
                this.HK.Hp.dS();
                this.HK.GR.eM().sendAccessibilityEvent(32);
                this.HK.Hn.setHideOnContentScrollEnabled(this.HK.HG);
                this.HK.Hu = null;
            }
        }

        public final void invalidate() {
            if (this.HK.Hu == this) {
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
            this.HK.Hp.setCustomView(view);
            this.HN = new WeakReference(view);
        }

        public final void setSubtitle(CharSequence charSequence) {
            this.HK.Hp.setSubtitle(charSequence);
        }

        public final void setTitle(CharSequence charSequence) {
            this.HK.Hp.setTitle(charSequence);
        }

        public final void setTitle(int i) {
            setTitle(this.HK.mContext.getResources().getString(i));
        }

        public final void setSubtitle(int i) {
            setSubtitle(this.HK.mContext.getResources().getString(i));
        }

        public final CharSequence getTitle() {
            return this.HK.Hp.up;
        }

        public final CharSequence getSubtitle() {
            return this.HK.Hp.uq;
        }

        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            this.HK.Hp.K(z);
        }

        public final boolean isTitleOptional() {
            return this.HK.Hp.Rc;
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
                this.HK.Hp.showOverflowMenu();
            }
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        Hl = z;
    }

    public n(Activity activity, boolean z) {
        this.pP = activity;
        View decorView = activity.getWindow().getDecorView();
        aI(decorView);
        if (!z) {
            this.Hq = decorView.findViewById(16908290);
        }
    }

    public n(Dialog dialog) {
        this.oy = dialog;
        aI(dialog.getWindow().getDecorView());
    }

    private void aI(View view) {
        View view2;
        u uVar;
        this.Hn = (ActionBarOverlayLayout) view.findViewById(android.support.v7.a.a.f.Ji);
        if (this.Hn != null) {
            view2 = this.Hn;
            view2.Rx = this;
            if (view2.getWindowToken() != null) {
                view2.Rx.onWindowVisibilityChanged(view2.Rh);
                if (view2.Rq != 0) {
                    view2.onWindowSystemUiVisibilityChanged(view2.Rq);
                    y.Y(view2);
                }
            }
        }
        view2 = view.findViewById(android.support.v7.a.a.f.IU);
        if (view2 instanceof u) {
            uVar = (u) view2;
        } else if (view2 instanceof Toolbar) {
            uVar = ((Toolbar) view2).hb();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(view2).toString() != null ? view2.getClass().getSimpleName() : "null");
        }
        this.GR = uVar;
        this.Hp = (ActionBarContextView) view.findViewById(android.support.v7.a.a.f.IZ);
        this.Ho = (ActionBarContainer) view.findViewById(android.support.v7.a.a.f.IW);
        if (this.GR == null || this.Hp == null || this.Ho == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.GR.getContext();
        if ((this.GR.getDisplayOptions() & 4) != 0) {
            this.Ht = true;
        }
        android.support.v7.view.a m = android.support.v7.view.a.m(this.mContext);
        m.dk();
        z(m.dj());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(k.Kq, false)) {
            if (this.Hn.Rm) {
                this.HG = true;
                this.Hn.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(k.Ko, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void setElevation(float f) {
        y.g(this.Ho, f);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        z(android.support.v7.view.a.m(this.mContext).dj());
    }

    private void z(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.Hx = z;
        if (this.Hx) {
            this.Ho.a(null);
            this.GR.b(this.Hr);
        } else {
            this.GR.b(null);
            this.Ho.a(this.Hr);
        }
        if (this.GR.getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.Hr != null) {
            if (z2) {
                this.Hr.setVisibility(0);
                if (this.Hn != null) {
                    y.Y(this.Hn);
                }
            } else {
                this.Hr.setVisibility(8);
            }
        }
        u uVar = this.GR;
        if (this.Hx || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        uVar.N(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.Hn;
        if (this.Hx || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.Rn = z4;
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

    public final boolean requestFocus() {
        ViewGroup eM = this.GR.eM();
        if (eM == null || eM.hasFocus()) {
            return false;
        }
        eM.requestFocus();
        return true;
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
        if (this.Hu != null) {
            this.Hu.finish();
        }
        this.Hn.setHideOnContentScrollEnabled(false);
        this.Hp.dT();
        b aVar2 = new a(this, this.Hp.getContext(), aVar);
        if (!aVar2.di()) {
            return null;
        }
        aVar2.invalidate();
        this.Hp.c(aVar2);
        C(true);
        this.Hp.sendAccessibilityEvent(32);
        this.Hu = aVar2;
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
                } else {
                    y.d(this.Ho, 1.0f);
                    y.c(this.Ho, 0.0f);
                    if (this.Hz && this.Hq != null) {
                        y.c(this.Hq, 0.0f);
                    }
                    this.HI.q(null);
                }
                if (this.Hn != null) {
                    y.Y(this.Hn);
                }
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
        return this.HD && (height == 0 || this.Hn.dW() < height);
    }

    public final void C(boolean z) {
        ah b;
        ah b2;
        if (z) {
            if (!this.HC) {
                this.HC = true;
                if (this.Hn != null) {
                    ActionBarOverlayLayout.dU();
                }
                B(false);
            }
        } else if (this.HC) {
            this.HC = false;
            if (this.Hn != null) {
                ActionBarOverlayLayout.dU();
            }
            B(false);
        }
        if (z) {
            b = this.GR.b(4, 100);
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
