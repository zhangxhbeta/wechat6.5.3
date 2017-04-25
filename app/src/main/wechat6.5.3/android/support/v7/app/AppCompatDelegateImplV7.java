package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.s;
import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v4.view.am;
import android.support.v4.view.ao;
import android.support.v4.view.g;
import android.support.v4.view.j;
import android.support.v4.view.y;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.as;
import android.support.v7.widget.h;
import android.support.v7.widget.t;
import android.support.v7.widget.x;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.FileUtils;

class AppCompatDelegateImplV7 extends e implements j, android.support.v7.view.menu.f.a {
    private TextView EI;
    private t FV;
    private a FW;
    private d FX;
    android.support.v7.view.b FY;
    ActionBarContextView FZ;
    PopupWindow Ga;
    Runnable Gb;
    ah Gc = null;
    private boolean Gd;
    ViewGroup Ge;
    private View Gf;
    private boolean Gg;
    private boolean Gh;
    private boolean Gi;
    private PanelFeatureState[] Gj;
    private PanelFeatureState Gk;
    private boolean Gl;
    private boolean Gm;
    private int Gn;
    private final Runnable Go = new Runnable(this) {
        final /* synthetic */ AppCompatDelegateImplV7 Gr;

        {
            this.Gr = r1;
        }

        public final void run() {
            if ((this.Gr.Gn & 1) != 0) {
                AppCompatDelegateImplV7.a(this.Gr, 0);
            }
            if ((this.Gr.Gn & 4096) != 0) {
                AppCompatDelegateImplV7.a(this.Gr, (int) MMGIFException.D_GIF_ERR_DATA_TOO_BIG);
            }
            this.Gr.Gm = false;
            this.Gr.Gn = 0;
        }
    };
    private boolean Gp;
    private j Gq;
    private Rect hc;
    private Rect hd;

    private static final class PanelFeatureState {
        boolean Db;
        e GA;
        Context GB;
        boolean GC;
        boolean GD;
        public boolean GE;
        boolean GF = false;
        boolean GG;
        Bundle GH;
        int Gv;
        ViewGroup Gw;
        View Gx;
        View Gy;
        f Gz;
        int background;
        int gravity;
        int windowAnimations;
        int x;
        int y;

        private static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            boolean Db;
            int Gv;
            Bundle iQ;

            private SavedState() {
            }

            static /* synthetic */ SavedState a(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.Gv = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.Db = z;
                if (savedState.Db) {
                    savedState.iQ = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.Gv);
                parcel.writeInt(this.Db ? 1 : 0);
                if (this.Db) {
                    parcel.writeBundle(this.iQ);
                }
            }
        }

        PanelFeatureState(int i) {
            this.Gv = i;
        }

        final void e(f fVar) {
            if (fVar != this.Gz) {
                if (this.Gz != null) {
                    this.Gz.b(this.GA);
                }
                this.Gz = fVar;
                if (fVar != null && this.GA != null) {
                    fVar.a(this.GA);
                }
            }
        }
    }

    private final class a implements android.support.v7.view.menu.l.a {
        final /* synthetic */ AppCompatDelegateImplV7 Gr;

        private a(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.Gr = appCompatDelegateImplV7;
        }

        public final boolean d(f fVar) {
            Callback callback = this.Gr.Eo.getCallback();
            if (callback != null) {
                callback.onMenuOpened(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, fVar);
            }
            return true;
        }

        public final void a(f fVar, boolean z) {
            this.Gr.c(fVar);
        }
    }

    class b implements android.support.v7.view.b.a {
        final /* synthetic */ AppCompatDelegateImplV7 Gr;
        private android.support.v7.view.b.a Gt;

        public b(AppCompatDelegateImplV7 appCompatDelegateImplV7, android.support.v7.view.b.a aVar) {
            this.Gr = appCompatDelegateImplV7;
            this.Gt = aVar;
        }

        public final boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.Gt.a(bVar, menu);
        }

        public final boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.Gt.b(bVar, menu);
        }

        public final boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.Gt.a(bVar, menuItem);
        }

        public final void a(android.support.v7.view.b bVar) {
            this.Gt.a(bVar);
            if (this.Gr.Ga != null) {
                this.Gr.Eo.getDecorView().removeCallbacks(this.Gr.Gb);
            }
            if (this.Gr.FZ != null) {
                this.Gr.dc();
                this.Gr.Gc = y.U(this.Gr.FZ).p(0.0f);
                this.Gr.Gc.a(new am(this) {
                    final /* synthetic */ b Gu;

                    {
                        this.Gu = r1;
                    }

                    public final void q(View view) {
                        this.Gu.Gr.FZ.setVisibility(8);
                        if (this.Gu.Gr.Ga != null) {
                            this.Gu.Gr.Ga.dismiss();
                        } else if (this.Gu.Gr.FZ.getParent() instanceof View) {
                            y.Y((View) this.Gu.Gr.FZ.getParent());
                        }
                        this.Gu.Gr.FZ.removeAllViews();
                        this.Gu.Gr.Gc.a(null);
                        this.Gu.Gr.Gc = null;
                    }
                });
            }
            this.Gr.FY = null;
        }
    }

    private class c extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImplV7 Gr;

        public c(AppCompatDelegateImplV7 appCompatDelegateImplV7, Context context) {
            this.Gr = appCompatDelegateImplV7;
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.Gr.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                boolean z = x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
                if (z) {
                    this.Gr.a(this.Gr.au(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(h.eD().a(getContext(), i, false));
        }
    }

    private final class d implements android.support.v7.view.menu.l.a {
        final /* synthetic */ AppCompatDelegateImplV7 Gr;

        private d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.Gr = appCompatDelegateImplV7;
        }

        public final void a(f fVar, boolean z) {
            Menu menu;
            f dH = fVar.dH();
            boolean z2 = dH != fVar;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.Gr;
            if (z2) {
                menu = dH;
            }
            PanelFeatureState a = appCompatDelegateImplV7.a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.Gr.a(a.Gv, a, (Menu) dH);
                this.Gr.a(a, true);
                return;
            }
            this.Gr.a(a, z);
        }

        public final boolean d(f fVar) {
            if (fVar == null && this.Gr.FH) {
                Callback callback = this.Gr.Eo.getCallback();
                if (!(callback == null || this.Gr.FM)) {
                    callback.onMenuOpened(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, fVar);
                }
            }
            return true;
        }
    }

    static /* synthetic */ void a(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        PanelFeatureState au = appCompatDelegateImplV7.au(i);
        if (au.Gz != null) {
            Bundle bundle = new Bundle();
            au.Gz.e(bundle);
            if (bundle.size() > 0) {
                au.GH = bundle;
            }
            au.Gz.dA();
            au.Gz.clear();
        }
        au.GG = true;
        au.GF = true;
        if ((i == MMGIFException.D_GIF_ERR_DATA_TOO_BIG || i == 0) && appCompatDelegateImplV7.FV != null) {
            au = appCompatDelegateImplV7.au(0);
            if (au != null) {
                au.GC = false;
                appCompatDelegateImplV7.b(au, null);
            }
        }
    }

    static /* synthetic */ int b(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (appCompatDelegateImplV7.FZ == null || !(appCompatDelegateImplV7.FZ.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) appCompatDelegateImplV7.FZ.getLayoutParams();
            if (appCompatDelegateImplV7.FZ.isShown()) {
                if (appCompatDelegateImplV7.hc == null) {
                    appCompatDelegateImplV7.hc = new Rect();
                    appCompatDelegateImplV7.hd = new Rect();
                }
                Rect rect = appCompatDelegateImplV7.hc;
                Rect rect2 = appCompatDelegateImplV7.hd;
                rect.set(0, i, 0, 0);
                as.a(appCompatDelegateImplV7.Ge, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (appCompatDelegateImplV7.Gf == null) {
                        appCompatDelegateImplV7.Gf = new View(appCompatDelegateImplV7.mContext);
                        appCompatDelegateImplV7.Gf.setBackgroundColor(appCompatDelegateImplV7.mContext.getResources().getColor(android.support.v7.a.a.c.HX));
                        appCompatDelegateImplV7.Ge.addView(appCompatDelegateImplV7.Gf, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = appCompatDelegateImplV7.Gf.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            appCompatDelegateImplV7.Gf.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (appCompatDelegateImplV7.Gf == null) {
                    i3 = 0;
                }
                if (!(appCompatDelegateImplV7.FJ || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                appCompatDelegateImplV7.FZ.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (appCompatDelegateImplV7.Gf != null) {
            View view = appCompatDelegateImplV7.Gf;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    static /* synthetic */ void d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        if (appCompatDelegateImplV7.FV != null) {
            appCompatDelegateImplV7.FV.eb();
        }
        if (appCompatDelegateImplV7.Ga != null) {
            appCompatDelegateImplV7.Eo.getDecorView().removeCallbacks(appCompatDelegateImplV7.Gb);
            if (appCompatDelegateImplV7.Ga.isShowing()) {
                try {
                    appCompatDelegateImplV7.Ga.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            appCompatDelegateImplV7.Ga = null;
        }
        appCompatDelegateImplV7.dc();
        PanelFeatureState au = appCompatDelegateImplV7.au(0);
        if (au != null && au.Gz != null) {
            au.Gz.close();
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, c cVar) {
        super(context, window, cVar);
    }

    public void onCreate(Bundle bundle) {
        if ((this.FD instanceof Activity) && s.b((Activity) this.FD) != null) {
            ActionBar actionBar = this.FG;
            if (actionBar == null) {
                this.Gp = true;
            } else {
                actionBar.w(true);
            }
        }
    }

    public final void cW() {
        db();
    }

    public final void cZ() {
        db();
        if (this.FH && this.FG == null) {
            if (this.FD instanceof Activity) {
                this.FG = new n((Activity) this.FD, this.FI);
            } else if (this.FD instanceof Dialog) {
                this.FG = new n((Dialog) this.FD);
            }
            if (this.FG != null) {
                this.FG.w(this.Gp);
            }
        }
    }

    public final View findViewById(int i) {
        db();
        return this.Eo.findViewById(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.FH && this.Gd) {
            ActionBar cV = cV();
            if (cV != null) {
                cV.onConfigurationChanged(configuration);
            }
        }
    }

    public final void onStop() {
        ActionBar cV = cV();
        if (cV != null) {
            cV.x(false);
        }
    }

    public final void onPostResume() {
        ActionBar cV = cV();
        if (cV != null) {
            cV.x(true);
        }
    }

    public final void setContentView(View view) {
        db();
        ViewGroup viewGroup = (ViewGroup) this.Ge.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.FD.onContentChanged();
    }

    public final void setContentView(int i) {
        db();
        ViewGroup viewGroup = (ViewGroup) this.Ge.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.FD.onContentChanged();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        db();
        ViewGroup viewGroup = (ViewGroup) this.Ge.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.FD.onContentChanged();
    }

    public final void addContentView(View view, LayoutParams layoutParams) {
        db();
        ((ViewGroup) this.Ge.findViewById(16908290)).addView(view, layoutParams);
        this.FD.onContentChanged();
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.FG != null) {
            this.FG.onDestroy();
            this.FG = null;
        }
    }

    private void db() {
        if (!this.Gd) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(k.bl);
            if (obtainStyledAttributes.hasValue(k.KS)) {
                View view;
                View view2;
                if (obtainStyledAttributes.getBoolean(k.Lb, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(k.KS, false)) {
                    requestWindowFeature(MMGIFException.D_GIF_ERR_DATA_TOO_BIG);
                }
                if (obtainStyledAttributes.getBoolean(k.KT, false)) {
                    requestWindowFeature(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
                }
                if (obtainStyledAttributes.getBoolean(k.KU, false)) {
                    requestWindowFeature(10);
                }
                this.FK = obtainStyledAttributes.getBoolean(k.KQ, false);
                obtainStyledAttributes.recycle();
                LayoutInflater from = LayoutInflater.from(this.mContext);
                if (this.FL) {
                    view = this.FJ ? (ViewGroup) from.inflate(android.support.v7.a.a.h.JW, null) : (ViewGroup) from.inflate(android.support.v7.a.a.h.JV, null);
                    if (VERSION.SDK_INT >= 21) {
                        y.b(view, new android.support.v4.view.s(this) {
                            final /* synthetic */ AppCompatDelegateImplV7 Gr;

                            {
                                this.Gr = r1;
                            }

                            public final ao a(View view, ao aoVar) {
                                int systemWindowInsetTop = aoVar.getSystemWindowInsetTop();
                                int b = AppCompatDelegateImplV7.b(this.Gr, systemWindowInsetTop);
                                if (systemWindowInsetTop != b) {
                                    aoVar = aoVar.d(aoVar.getSystemWindowInsetLeft(), b, aoVar.getSystemWindowInsetRight(), aoVar.getSystemWindowInsetBottom());
                                }
                                return y.a(view, aoVar);
                            }
                        });
                        view2 = view;
                    } else {
                        ((x) view).a(new android.support.v7.widget.x.a(this) {
                            final /* synthetic */ AppCompatDelegateImplV7 Gr;

                            {
                                this.Gr = r1;
                            }

                            public final void d(Rect rect) {
                                rect.top = AppCompatDelegateImplV7.b(this.Gr, rect.top);
                            }
                        });
                        view2 = view;
                    }
                } else if (this.FK) {
                    r0 = (ViewGroup) from.inflate(android.support.v7.a.a.h.JO, null);
                    this.FI = false;
                    this.FH = false;
                    view2 = r0;
                } else if (this.FH) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                    r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.mContext, typedValue.resourceId) : this.mContext).inflate(android.support.v7.a.a.h.JX, null);
                    this.FV = (t) r0.findViewById(android.support.v7.a.a.f.Ji);
                    this.FV.b(this.Eo.getCallback());
                    if (this.FI) {
                        this.FV.ay(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
                    }
                    if (this.Gg) {
                        this.FV.ay(2);
                    }
                    if (this.Gh) {
                        this.FV.ay(5);
                    }
                    view2 = r0;
                } else {
                    view2 = null;
                }
                if (view2 == null) {
                    throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.FH + ", windowActionBarOverlay: " + this.FI + ", android:windowIsFloating: " + this.FK + ", windowActionModeOverlay: " + this.FJ + ", windowNoTitle: " + this.FL + " }");
                }
                if (this.FV == null) {
                    this.EI = (TextView) view2.findViewById(android.support.v7.a.a.f.title);
                }
                as.bv(view2);
                ViewGroup viewGroup = (ViewGroup) this.Eo.findViewById(16908290);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view2.findViewById(android.support.v7.a.a.f.IV);
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                this.Eo.setContentView(view2);
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
                contentFrameLayout.Vd = new android.support.v7.widget.ContentFrameLayout.a(this) {
                    final /* synthetic */ AppCompatDelegateImplV7 Gr;

                    {
                        this.Gr = r1;
                    }

                    public final void onDetachedFromWindow() {
                        AppCompatDelegateImplV7.d(this.Gr);
                    }
                };
                this.Ge = view2;
                CharSequence title = this.FD instanceof Activity ? ((Activity) this.FD).getTitle() : this.up;
                if (!TextUtils.isEmpty(title)) {
                    f(title);
                }
                ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.Ge.findViewById(16908290);
                view = this.Eo.getDecorView();
                contentFrameLayout2.Vc.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                if (y.ai(contentFrameLayout2)) {
                    contentFrameLayout2.requestLayout();
                }
                TypedArray obtainStyledAttributes2 = this.mContext.obtainStyledAttributes(k.bl);
                int i = k.KZ;
                if (contentFrameLayout2.UW == null) {
                    contentFrameLayout2.UW = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i, contentFrameLayout2.UW);
                i = k.La;
                if (contentFrameLayout2.UX == null) {
                    contentFrameLayout2.UX = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i, contentFrameLayout2.UX);
                if (obtainStyledAttributes2.hasValue(k.KX)) {
                    i = k.KX;
                    if (contentFrameLayout2.UY == null) {
                        contentFrameLayout2.UY = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout2.UY);
                }
                if (obtainStyledAttributes2.hasValue(k.KY)) {
                    i = k.KY;
                    if (contentFrameLayout2.UZ == null) {
                        contentFrameLayout2.UZ = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout2.UZ);
                }
                if (obtainStyledAttributes2.hasValue(k.KV)) {
                    i = k.KV;
                    if (contentFrameLayout2.Va == null) {
                        contentFrameLayout2.Va = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout2.Va);
                }
                if (obtainStyledAttributes2.hasValue(k.KW)) {
                    i = k.KW;
                    if (contentFrameLayout2.Vb == null) {
                        contentFrameLayout2.Vb = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout2.Vb);
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout2.requestLayout();
                this.Gd = true;
                PanelFeatureState au = au(0);
                if (!this.FM) {
                    if (au == null || au.Gz == null) {
                        invalidatePanelMenu(MMGIFException.D_GIF_ERR_DATA_TOO_BIG);
                        return;
                    }
                    return;
                }
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            i = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
        } else if (i == 9) {
            i = MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
        }
        if (this.FL && i == MMGIFException.D_GIF_ERR_DATA_TOO_BIG) {
            return false;
        }
        if (this.FH && i == 1) {
            this.FH = false;
        }
        switch (i) {
            case 1:
                dd();
                this.FL = true;
                return true;
            case 2:
                dd();
                this.Gg = true;
                return true;
            case 5:
                dd();
                this.Gh = true;
                return true;
            case 10:
                dd();
                this.FJ = true;
                return true;
            case MMGIFException.D_GIF_ERR_DATA_TOO_BIG /*108*/:
                dd();
                this.FH = true;
                return true;
            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                dd();
                this.FI = true;
                return true;
            default:
                return this.Eo.requestFeature(i);
        }
    }

    final void f(CharSequence charSequence) {
        if (this.FV != null) {
            this.FV.e(charSequence);
        } else if (this.FG != null) {
            this.FG.e(charSequence);
        } else if (this.EI != null) {
            this.EI.setText(charSequence);
        }
    }

    final void ar(int i) {
        if (i == MMGIFException.D_GIF_ERR_DATA_TOO_BIG) {
            ActionBar cV = cV();
            if (cV != null) {
                cV.y(false);
            }
        } else if (i == 0) {
            PanelFeatureState au = au(i);
            if (au.Db) {
                a(au, false);
            }
        }
    }

    final boolean as(int i) {
        if (i != MMGIFException.D_GIF_ERR_DATA_TOO_BIG) {
            return false;
        }
        ActionBar cV = cV();
        if (cV == null) {
            return true;
        }
        cV.y(true);
        return true;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        Callback callback = this.Eo.getCallback();
        if (!(callback == null || this.FM)) {
            PanelFeatureState a = a(fVar.dH());
            if (a != null) {
                return callback.onMenuItemSelected(a.Gv, menuItem);
            }
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.FV == null || !this.FV.dY() || (ad.b(ViewConfiguration.get(this.mContext)) && !this.FV.dZ())) {
            PanelFeatureState au = au(0);
            au.GF = true;
            a(au, false);
            a(au, null);
            return;
        }
        Callback callback = this.Eo.getCallback();
        if (this.FV.isOverflowMenuShowing()) {
            this.FV.hideOverflowMenu();
            if (!this.FM) {
                callback.onPanelClosed(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, au(0).Gz);
            }
        } else if (callback != null && !this.FM) {
            if (this.Gm && (this.Gn & 1) != 0) {
                this.Eo.getDecorView().removeCallbacks(this.Go);
                this.Go.run();
            }
            PanelFeatureState au2 = au(0);
            if (au2.Gz != null && !au2.GG && callback.onPreparePanel(0, au2.Gy, au2.Gz)) {
                callback.onMenuOpened(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, au2.Gz);
                this.FV.showOverflowMenu();
            }
        }
    }

    public final void invalidateOptionsMenu() {
        ActionBar cV = cV();
        if (cV == null || !cV.cS()) {
            invalidatePanelMenu(0);
        }
    }

    final void dc() {
        if (this.Gc != null) {
            this.Gc.cancel();
        }
    }

    final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar cV = cV();
        if (cV != null && cV.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.Gk == null || !a(this.Gk, keyEvent.getKeyCode(), keyEvent)) {
            if (this.Gk == null) {
                PanelFeatureState au = au(0);
                b(au, keyEvent);
                boolean a = a(au, keyEvent.getKeyCode(), keyEvent);
                au.GC = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.Gk == null) {
            return true;
        } else {
            this.Gk.GD = true;
            return true;
        }
    }

    final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.FD.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (keyCode) {
                case 4:
                    this.Gl = (keyEvent.getFlags() & FileUtils.S_IWUSR) != 0;
                    break;
                case 82:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState au = au(0);
                    if (au.Db) {
                        return true;
                    }
                    b(au, keyEvent);
                    return true;
            }
            if (VERSION.SDK_INT < 11) {
                onKeyShortcut(keyCode, keyEvent);
            }
            return false;
        }
        PanelFeatureState au2;
        switch (keyCode) {
            case 4:
                z = this.Gl;
                this.Gl = false;
                au2 = au(0);
                if (au2 == null || !au2.Db) {
                    if (this.FY != null) {
                        this.FY.finish();
                        z = true;
                    } else {
                        ActionBar cV = cV();
                        z = cV != null && cV.collapseActionView();
                    }
                    if (z) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(au2, true);
                    return true;
                }
                break;
            case 82:
                if (this.FY != null) {
                    return true;
                }
                au2 = au(0);
                if (this.FV == null || !this.FV.dY() || ad.b(ViewConfiguration.get(this.mContext))) {
                    if (au2.Db || au2.GD) {
                        z = au2.Db;
                        a(au2, true);
                    } else {
                        if (au2.GC) {
                            if (au2.GG) {
                                au2.GC = false;
                                z = b(au2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                a(au2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.FV.isOverflowMenuShowing()) {
                    z = this.FV.hideOverflowMenu();
                } else {
                    if (!this.FM && b(au2, keyEvent)) {
                        z = this.FV.showOverflowMenu();
                    }
                    z = false;
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
                if (audioManager == null) {
                    return true;
                }
                audioManager.playSoundEffect(0);
                return true;
        }
        return false;
    }

    public final void cX() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            g.a(from, this);
        } else {
            g.a(from);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
        r7 = this;
        r3 = 1;
        r4 = 0;
        r0 = r7.a(r9, r10, r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x004f;
    L_0x000f:
        r2 = r3;
    L_0x0010:
        r0 = r7.Gq;
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r0 = new android.support.v7.app.j;
        r0.<init>();
        r7.Gq = r0;
    L_0x001b:
        if (r2 == 0) goto L_0x0072;
    L_0x001d:
        r0 = r8;
        r0 = (android.view.ViewParent) r0;
        if (r0 != 0) goto L_0x0051;
    L_0x0022:
        r0 = r4;
    L_0x0023:
        if (r0 == 0) goto L_0x0072;
    L_0x0025:
        r0 = r3;
    L_0x0026:
        r5 = r7.Gq;
        if (r0 == 0) goto L_0x0169;
    L_0x002a:
        if (r8 == 0) goto L_0x0169;
    L_0x002c:
        r0 = r8.getContext();
    L_0x0030:
        r2 = android.support.v7.app.j.a(r0, r11, r2, r3);
        r0 = 0;
        r1 = -1;
        r6 = r9.hashCode();
        switch(r6) {
            case -1946472170: goto L_0x00f4;
            case -1455429095: goto L_0x00cd;
            case -1346021293: goto L_0x00e7;
            case -938935918: goto L_0x0074;
            case -937446323: goto L_0x00aa;
            case -658531749: goto L_0x0101;
            case -339785223: goto L_0x009f;
            case 776382189: goto L_0x00c1;
            case 1125864064: goto L_0x007e;
            case 1413872058: goto L_0x00da;
            case 1601505219: goto L_0x00b5;
            case 1666676343: goto L_0x0094;
            case 2001146706: goto L_0x0089;
            default: goto L_0x003d;
        };
    L_0x003d:
        r4 = r1;
    L_0x003e:
        switch(r4) {
            case 0: goto L_0x010e;
            case 1: goto L_0x0115;
            case 2: goto L_0x011c;
            case 3: goto L_0x0123;
            case 4: goto L_0x012a;
            case 5: goto L_0x0131;
            case 6: goto L_0x0138;
            case 7: goto L_0x013f;
            case 8: goto L_0x0146;
            case 9: goto L_0x014d;
            case 10: goto L_0x0154;
            case 11: goto L_0x015b;
            case 12: goto L_0x0162;
            default: goto L_0x0041;
        };
    L_0x0041:
        if (r0 != 0) goto L_0x0049;
    L_0x0043:
        if (r10 == r2) goto L_0x0049;
    L_0x0045:
        r0 = r5.a(r2, r9, r11);
    L_0x0049:
        if (r0 == 0) goto L_0x0008;
    L_0x004b:
        android.support.v7.app.j.a(r0, r11);
        goto L_0x0008;
    L_0x004f:
        r2 = r4;
        goto L_0x0010;
    L_0x0051:
        r1 = r7.Eo;
        r5 = r1.getDecorView();
        r1 = r0;
    L_0x0058:
        if (r1 != 0) goto L_0x005c;
    L_0x005a:
        r0 = r3;
        goto L_0x0023;
    L_0x005c:
        if (r1 == r5) goto L_0x006b;
    L_0x005e:
        r0 = r1 instanceof android.view.View;
        if (r0 == 0) goto L_0x006b;
    L_0x0062:
        r0 = r1;
        r0 = (android.view.View) r0;
        r0 = android.support.v4.view.y.ak(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x006b:
        r0 = r4;
        goto L_0x0023;
    L_0x006d:
        r1 = r1.getParent();
        goto L_0x0058;
    L_0x0072:
        r0 = r4;
        goto L_0x0026;
    L_0x0074:
        r3 = "TextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x007d:
        goto L_0x003e;
    L_0x007e:
        r4 = "ImageView";
        r4 = r9.equals(r4);
        if (r4 == 0) goto L_0x003d;
    L_0x0087:
        r4 = r3;
        goto L_0x003e;
    L_0x0089:
        r3 = "Button";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x0092:
        r4 = 2;
        goto L_0x003e;
    L_0x0094:
        r3 = "EditText";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x009d:
        r4 = 3;
        goto L_0x003e;
    L_0x009f:
        r3 = "Spinner";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x00a8:
        r4 = 4;
        goto L_0x003e;
    L_0x00aa:
        r3 = "ImageButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x00b3:
        r4 = 5;
        goto L_0x003e;
    L_0x00b5:
        r3 = "CheckBox";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x00be:
        r4 = 6;
        goto L_0x003e;
    L_0x00c1:
        r3 = "RadioButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x00ca:
        r4 = 7;
        goto L_0x003e;
    L_0x00cd:
        r3 = "CheckedTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x00d6:
        r4 = 8;
        goto L_0x003e;
    L_0x00da:
        r3 = "AutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x00e3:
        r4 = 9;
        goto L_0x003e;
    L_0x00e7:
        r3 = "MultiAutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x00f0:
        r4 = 10;
        goto L_0x003e;
    L_0x00f4:
        r3 = "RatingBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x00fd:
        r4 = 11;
        goto L_0x003e;
    L_0x0101:
        r3 = "SeekBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x003d;
    L_0x010a:
        r4 = 12;
        goto L_0x003e;
    L_0x010e:
        r0 = new android.support.v7.widget.AppCompatTextView;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x0115:
        r0 = new android.support.v7.widget.AppCompatImageView;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x011c:
        r0 = new android.support.v7.widget.AppCompatButton;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x0123:
        r0 = new android.support.v7.widget.AppCompatEditText;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x012a:
        r0 = new android.support.v7.widget.AppCompatSpinner;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x0131:
        r0 = new android.support.v7.widget.AppCompatImageButton;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x0138:
        r0 = new android.support.v7.widget.AppCompatCheckBox;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x013f:
        r0 = new android.support.v7.widget.AppCompatRadioButton;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x0146:
        r0 = new android.support.v7.widget.AppCompatCheckedTextView;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x014d:
        r0 = new android.support.v7.widget.AppCompatAutoCompleteTextView;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x0154:
        r0 = new android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x015b:
        r0 = new android.support.v7.widget.AppCompatRatingBar;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x0162:
        r0 = new android.support.v7.widget.AppCompatSeekBar;
        r0.<init>(r2, r11);
        goto L_0x0041;
    L_0x0169:
        r0 = r10;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    View a(String str, Context context, AttributeSet attributeSet) {
        if (this.FD instanceof Factory) {
            View onCreateView = ((Factory) this.FD).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r2 = -2;
        r3 = 0;
        r9 = 1;
        r0 = r11.Db;
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r10.FM;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r11.Gv;
        if (r0 != 0) goto L_0x0032;
    L_0x0011:
        r4 = r10.mContext;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0022:
        r0 = r9;
    L_0x0023:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002d:
        r4 = r9;
    L_0x002e:
        if (r0 == 0) goto L_0x0032;
    L_0x0030:
        if (r4 != 0) goto L_0x000c;
    L_0x0032:
        r0 = r10.Eo;
        r0 = r0.getCallback();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.Gv;
        r5 = r11.Gz;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.a(r11, r9);
        goto L_0x000c;
    L_0x0048:
        r0 = r3;
        goto L_0x0023;
    L_0x004a:
        r4 = r3;
        goto L_0x002e;
    L_0x004c:
        r0 = r10.mContext;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000c;
    L_0x005a:
        r0 = r10.b(r11, r12);
        if (r0 == 0) goto L_0x000c;
    L_0x0060:
        r0 = r11.Gw;
        if (r0 == 0) goto L_0x0068;
    L_0x0064:
        r0 = r11.GF;
        if (r0 == 0) goto L_0x01e4;
    L_0x0068:
        r0 = r11.Gw;
        if (r0 != 0) goto L_0x0153;
    L_0x006c:
        r0 = r10.da();
        r1 = new android.util.TypedValue;
        r1.<init>();
        r4 = r0.getResources();
        r4 = r4.newTheme();
        r5 = r0.getTheme();
        r4.setTo(r5);
        r5 = android.support.v7.a.a.a.actionBarPopupTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x0092;
    L_0x008d:
        r5 = r1.resourceId;
        r4.applyStyle(r5, r9);
    L_0x0092:
        r5 = android.support.v7.a.a.a.HQ;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x014c;
    L_0x009b:
        r1 = r1.resourceId;
        r4.applyStyle(r1, r9);
    L_0x00a0:
        r1 = new android.support.v7.view.d;
        r1.<init>(r0, r3);
        r0 = r1.getTheme();
        r0.setTo(r4);
        r11.GB = r1;
        r0 = android.support.v7.a.a.k.bl;
        r0 = r1.obtainStyledAttributes(r0);
        r1 = android.support.v7.a.a.k.KR;
        r1 = r0.getResourceId(r1, r3);
        r11.background = r1;
        r1 = android.support.v7.a.a.k.KP;
        r1 = r0.getResourceId(r1, r3);
        r11.windowAnimations = r1;
        r0.recycle();
        r0 = new android.support.v7.app.AppCompatDelegateImplV7$c;
        r1 = r11.GB;
        r0.<init>(r10, r1);
        r11.Gw = r0;
        r0 = 81;
        r11.gravity = r0;
        r0 = r11.Gw;
        if (r0 == 0) goto L_0x000c;
    L_0x00d8:
        r0 = r11.Gy;
        if (r0 == 0) goto L_0x0166;
    L_0x00dc:
        r0 = r11.Gy;
        r11.Gx = r0;
        r0 = r9;
    L_0x00e1:
        if (r0 == 0) goto L_0x000c;
    L_0x00e3:
        r0 = r11.Gx;
        if (r0 == 0) goto L_0x01e1;
    L_0x00e7:
        r0 = r11.Gy;
        if (r0 == 0) goto L_0x01d2;
    L_0x00eb:
        r0 = r9;
    L_0x00ec:
        if (r0 == 0) goto L_0x000c;
    L_0x00ee:
        r0 = r11.Gx;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x01f7;
    L_0x00f6:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x00fc:
        r0 = r11.background;
        r4 = r11.Gw;
        r4.setBackgroundResource(r0);
        r0 = r11.Gx;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x0116;
    L_0x010b:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x0116;
    L_0x010f:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.Gx;
        r0.removeView(r4);
    L_0x0116:
        r0 = r11.Gw;
        r4 = r11.Gx;
        r0.addView(r4, r1);
        r0 = r11.Gx;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x012a;
    L_0x0125:
        r0 = r11.Gx;
        r0.requestFocus();
    L_0x012a:
        r1 = r2;
    L_0x012b:
        r11.GD = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.x;
        r4 = r11.y;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.gravity;
        r0.gravity = r1;
        r1 = r11.windowAnimations;
        r0.windowAnimations = r1;
        r1 = r11.Gw;
        r8.addView(r1, r0);
        r11.Db = r9;
        goto L_0x000c;
    L_0x014c:
        r1 = android.support.v7.a.a.j.Ke;
        r4.applyStyle(r1, r9);
        goto L_0x00a0;
    L_0x0153:
        r0 = r11.GF;
        if (r0 == 0) goto L_0x00d8;
    L_0x0157:
        r0 = r11.Gw;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x00d8;
    L_0x015f:
        r0 = r11.Gw;
        r0.removeAllViews();
        goto L_0x00d8;
    L_0x0166:
        r0 = r11.Gz;
        if (r0 == 0) goto L_0x01cf;
    L_0x016a:
        r0 = r10.FX;
        if (r0 != 0) goto L_0x0175;
    L_0x016e:
        r0 = new android.support.v7.app.AppCompatDelegateImplV7$d;
        r0.<init>();
        r10.FX = r0;
    L_0x0175:
        r0 = r10.FX;
        r1 = r11.Gz;
        if (r1 != 0) goto L_0x0187;
    L_0x017b:
        r0 = 0;
    L_0x017c:
        r0 = (android.view.View) r0;
        r11.Gx = r0;
        r0 = r11.Gx;
        if (r0 == 0) goto L_0x01cf;
    L_0x0184:
        r0 = r9;
        goto L_0x00e1;
    L_0x0187:
        r1 = r11.GA;
        if (r1 != 0) goto L_0x01a1;
    L_0x018b:
        r1 = new android.support.v7.view.menu.e;
        r4 = r11.GB;
        r5 = android.support.v7.a.a.h.JS;
        r1.<init>(r4, r5);
        r11.GA = r1;
        r1 = r11.GA;
        r1.dU = r0;
        r0 = r11.Gz;
        r1 = r11.GA;
        r0.a(r1);
    L_0x01a1:
        r1 = r11.GA;
        r0 = r11.Gw;
        r4 = r1.Po;
        if (r4 != 0) goto L_0x01cc;
    L_0x01a9:
        r4 = r1.CE;
        r5 = android.support.v7.a.a.h.JP;
        r0 = r4.inflate(r5, r0, r3);
        r0 = (android.support.v7.view.menu.ExpandedMenuView) r0;
        r1.Po = r0;
        r0 = r1.Pr;
        if (r0 != 0) goto L_0x01c0;
    L_0x01b9:
        r0 = new android.support.v7.view.menu.e$a;
        r0.<init>(r1);
        r1.Pr = r0;
    L_0x01c0:
        r0 = r1.Po;
        r4 = r1.Pr;
        r0.setAdapter(r4);
        r0 = r1.Po;
        r0.setOnItemClickListener(r1);
    L_0x01cc:
        r0 = r1.Po;
        goto L_0x017c;
    L_0x01cf:
        r0 = r3;
        goto L_0x00e1;
    L_0x01d2:
        r0 = r11.GA;
        r0 = r0.getAdapter();
        r0 = r0.getCount();
        if (r0 <= 0) goto L_0x01e1;
    L_0x01de:
        r0 = r9;
        goto L_0x00ec;
    L_0x01e1:
        r0 = r3;
        goto L_0x00ec;
    L_0x01e4:
        r0 = r11.Gy;
        if (r0 == 0) goto L_0x01f4;
    L_0x01e8:
        r0 = r11.Gy;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x01f4;
    L_0x01f0:
        r0 = r0.width;
        if (r0 == r1) goto L_0x012b;
    L_0x01f4:
        r1 = r2;
        goto L_0x012b;
    L_0x01f7:
        r1 = r0;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.FM) {
            return false;
        }
        if (panelFeatureState.GC) {
            return true;
        }
        if (!(this.Gk == null || this.Gk == panelFeatureState)) {
            a(this.Gk, false);
        }
        Callback callback = this.Eo.getCallback();
        if (callback != null) {
            panelFeatureState.Gy = callback.onCreatePanelView(panelFeatureState.Gv);
        }
        boolean z = panelFeatureState.Gv == 0 || panelFeatureState.Gv == MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
        if (z && this.FV != null) {
            this.FV.ea();
        }
        if (panelFeatureState.Gy == null && !(z && (this.FG instanceof k))) {
            if (panelFeatureState.Gz == null || panelFeatureState.GG) {
                if (panelFeatureState.Gz == null) {
                    Context dVar;
                    f fVar;
                    Context context = this.mContext;
                    if ((panelFeatureState.Gv == 0 || panelFeatureState.Gv == MMGIFException.D_GIF_ERR_DATA_TOO_BIG) && this.FV != null) {
                        Theme newTheme;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = context.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            newTheme = context.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                            newTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (newTheme == null) {
                                newTheme = context.getResources().newTheme();
                                newTheme.setTo(theme);
                            }
                            newTheme.applyStyle(typedValue.resourceId, true);
                        }
                        Theme theme2 = newTheme;
                        if (theme2 != null) {
                            dVar = new android.support.v7.view.d(context, 0);
                            dVar.getTheme().setTo(theme2);
                            fVar = new f(dVar);
                            fVar.a((android.support.v7.view.menu.f.a) this);
                            panelFeatureState.e(fVar);
                            if (panelFeatureState.Gz == null) {
                                return false;
                            }
                        }
                    }
                    dVar = context;
                    fVar = new f(dVar);
                    fVar.a((android.support.v7.view.menu.f.a) this);
                    panelFeatureState.e(fVar);
                    if (panelFeatureState.Gz == null) {
                        return false;
                    }
                }
                if (z && this.FV != null) {
                    if (this.FW == null) {
                        this.FW = new a();
                    }
                    this.FV.a(panelFeatureState.Gz, this.FW);
                }
                panelFeatureState.Gz.dA();
                if (callback.onCreatePanelMenu(panelFeatureState.Gv, panelFeatureState.Gz)) {
                    panelFeatureState.GG = false;
                } else {
                    panelFeatureState.e(null);
                    if (!z || this.FV == null) {
                        return false;
                    }
                    this.FV.a(null, this.FW);
                    return false;
                }
            }
            panelFeatureState.Gz.dA();
            if (panelFeatureState.GH != null) {
                panelFeatureState.Gz.f(panelFeatureState.GH);
                panelFeatureState.GH = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.Gy, panelFeatureState.Gz)) {
                boolean z2;
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                panelFeatureState.GE = z2;
                panelFeatureState.Gz.setQwertyMode(panelFeatureState.GE);
                panelFeatureState.Gz.dB();
            } else {
                if (z && this.FV != null) {
                    this.FV.a(null, this.FW);
                }
                panelFeatureState.Gz.dB();
                return false;
            }
        }
        panelFeatureState.GC = true;
        panelFeatureState.GD = false;
        this.Gk = panelFeatureState;
        return true;
    }

    private void c(f fVar) {
        if (!this.Gi) {
            this.Gi = true;
            this.FV.eb();
            Callback callback = this.Eo.getCallback();
            if (!(callback == null || this.FM)) {
                callback.onPanelClosed(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, fVar);
            }
            this.Gi = false;
        }
    }

    private void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.Gv == 0 && this.FV != null && this.FV.isOverflowMenuShowing()) {
            c(panelFeatureState.Gz);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.Db || panelFeatureState.Gw == null)) {
            windowManager.removeView(panelFeatureState.Gw);
            if (z) {
                a(panelFeatureState.Gv, panelFeatureState, null);
            }
        }
        panelFeatureState.GC = false;
        panelFeatureState.GD = false;
        panelFeatureState.Db = false;
        panelFeatureState.Gx = null;
        panelFeatureState.GF = true;
        if (this.Gk == panelFeatureState) {
            this.Gk = null;
        }
    }

    private void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.Gj.length) {
                panelFeatureState = this.Gj[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.Gz;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.Db) && !this.FM) {
            this.FD.onPanelClosed(i, menu);
        }
    }

    private PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.Gj;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.Gz == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private PanelFeatureState au(int i) {
        Object obj = this.Gj;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.Gj = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.GC || b(panelFeatureState, keyEvent)) && panelFeatureState.Gz != null) {
            return panelFeatureState.Gz.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void invalidatePanelMenu(int i) {
        this.Gn |= 1 << i;
        if (!this.Gm) {
            y.a(this.Eo.getDecorView(), this.Go);
            this.Gm = true;
        }
    }

    private void dd() {
        if (this.Gd) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
}
