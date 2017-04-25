package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ah;
import android.support.v4.view.am;
import android.support.v4.view.y;
import android.support.v7.a.a.a;
import android.support.v7.a.a.e;
import android.support.v7.a.a.f;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.l;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public final class aq implements u {
    Callback GS;
    private ActionMenuPresenter QF;
    private final h Ts;
    private Drawable aeA;
    private boolean aeB;
    private CharSequence aeC;
    boolean aeD;
    private int aeE;
    private int aeF;
    private Drawable aeG;
    private int aex;
    private View aey;
    private Drawable aez;
    Toolbar gy;
    private Drawable jP;
    private View kC;
    CharSequence up;
    private CharSequence uq;

    public aq(Toolbar toolbar) {
        this(toolbar, true, i.Kb, e.Io);
    }

    private aq(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        Context context;
        CharSequence charSequence = null;
        this.aeE = 0;
        this.aeF = 0;
        this.gy = toolbar;
        this.up = toolbar.aee;
        this.uq = toolbar.aef;
        this.aeB = this.up != null;
        if (toolbar.adP != null) {
            drawable = toolbar.adP.getDrawable();
        } else {
            drawable = null;
        }
        this.aeA = drawable;
        ap a = ap.a(toolbar.getContext(), null, k.aV, a.actionBarStyle);
        CharSequence text = a.getText(k.Kx);
        if (!TextUtils.isEmpty(text)) {
            this.aeB = true;
            j(text);
        }
        CharSequence text2 = a.getText(k.Kv);
        if (!TextUtils.isEmpty(text2)) {
            this.uq = text2;
            if ((this.aex & 8) != 0) {
                this.gy.setSubtitle(text2);
            }
        }
        Drawable drawable2 = a.getDrawable(k.Kt);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        drawable2 = a.getDrawable(k.Ks);
        if (this.aeA == null && drawable2 != null) {
            setIcon(drawable2);
        }
        drawable2 = a.getDrawable(k.Kr);
        if (drawable2 != null) {
            this.aeA = drawable2;
            he();
        }
        setDisplayOptions(a.getInt(k.Kn, 0));
        int resourceId = a.getResourceId(k.Km, 0);
        if (resourceId != 0) {
            setCustomView(LayoutInflater.from(this.gy.getContext()).inflate(resourceId, this.gy, false));
            setDisplayOptions(this.aex | 16);
        }
        resourceId = a.getLayoutDimension(k.Kp, 0);
        if (resourceId > 0) {
            LayoutParams layoutParams = this.gy.getLayoutParams();
            layoutParams.height = resourceId;
            this.gy.setLayoutParams(layoutParams);
        }
        resourceId = a.getDimensionPixelOffset(k.Kl, -1);
        int dimensionPixelOffset = a.getDimensionPixelOffset(k.Kk, -1);
        if (resourceId >= 0 || dimensionPixelOffset >= 0) {
            this.gy.aed.Y(Math.max(resourceId, 0), Math.max(dimensionPixelOffset, 0));
        }
        resourceId = a.getResourceId(k.Ky, 0);
        if (resourceId != 0) {
            Toolbar toolbar2;
            toolbar2 = this.gy;
            context = this.gy.getContext();
            toolbar2.adV = resourceId;
            if (toolbar2.adN != null) {
                toolbar2.adN.setTextAppearance(context, resourceId);
            }
        }
        resourceId = a.getResourceId(k.Kw, 0);
        if (resourceId != 0) {
            toolbar2 = this.gy;
            context = this.gy.getContext();
            toolbar2.adW = resourceId;
            if (toolbar2.adO != null) {
                toolbar2.adO.setTextAppearance(context, resourceId);
            }
        }
        resourceId = a.getResourceId(k.Ku, 0);
        if (resourceId != 0) {
            this.gy.setPopupTheme(resourceId);
        }
        a.adM.recycle();
        this.Ts = h.eD();
        if (i != this.aeF) {
            this.aeF = i;
            if (TextUtils.isEmpty(this.gy.getNavigationContentDescription())) {
                int i3 = this.aeF;
                if (i3 != 0) {
                    charSequence = this.gy.getContext().getString(i3);
                }
                this.aeC = charSequence;
                hd();
            }
        }
        this.aeC = this.gy.getNavigationContentDescription();
        drawable = this.Ts.a(this.gy.getContext(), i2, false);
        if (this.aeG != drawable) {
            this.aeG = drawable;
            he();
        }
        this.gy.setNavigationOnClickListener(new OnClickListener(this) {
            final android.support.v7.view.menu.a aeH = new android.support.v7.view.menu.a(this.aeI.gy.getContext(), this.aeI.up);
            final /* synthetic */ aq aeI;

            {
                this.aeI = r4;
            }

            public final void onClick(View view) {
                if (this.aeI.GS != null && this.aeI.aeD) {
                    this.aeI.GS.onMenuItemSelected(0, this.aeH);
                }
            }
        });
    }

    public final ViewGroup eM() {
        return this.gy;
    }

    public final Context getContext() {
        return this.gy.getContext();
    }

    public final boolean hasExpandedActionView() {
        Toolbar toolbar = this.gy;
        return (toolbar.aep == null || toolbar.aep.aet == null) ? false : true;
    }

    public final void collapseActionView() {
        this.gy.collapseActionView();
    }

    public final void b(Callback callback) {
        this.GS = callback;
    }

    public final void e(CharSequence charSequence) {
        if (!this.aeB) {
            j(charSequence);
        }
    }

    public final CharSequence getTitle() {
        return this.gy.aee;
    }

    private void j(CharSequence charSequence) {
        this.up = charSequence;
        if ((this.aex & 8) != 0) {
            this.gy.setTitle(charSequence);
        }
    }

    public final void setIcon(int i) {
        setIcon(this.Ts.a(this.gy.getContext(), 2130839576, false));
    }

    private void setIcon(Drawable drawable) {
        this.jP = drawable;
        hc();
    }

    public final void setLogo(Drawable drawable) {
        this.aez = drawable;
        hc();
    }

    private void hc() {
        Drawable drawable = null;
        if ((this.aex & 2) != 0) {
            drawable = (this.aex & 1) != 0 ? this.aez != null ? this.aez : this.jP : this.jP;
        }
        this.gy.setLogo(drawable);
    }

    public final boolean dY() {
        Toolbar toolbar = this.gy;
        return toolbar.getVisibility() == 0 && toolbar.QE != null && toolbar.QE.RI;
    }

    public final boolean isOverflowMenuShowing() {
        return this.gy.isOverflowMenuShowing();
    }

    public final boolean dZ() {
        Toolbar toolbar = this.gy;
        if (toolbar.QE != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.QE;
            if (actionMenuView.Sh != null) {
                ActionMenuPresenter actionMenuPresenter = actionMenuView.Sh;
                z = actionMenuPresenter.RW != null || actionMenuPresenter.isOverflowMenuShowing();
                if (z) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        return this.gy.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        Toolbar toolbar = this.gy;
        if (toolbar.QE != null) {
            ActionMenuView actionMenuView = toolbar.QE;
            boolean z = actionMenuView.Sh != null && actionMenuView.Sh.hideOverflowMenu();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void ea() {
        this.aeD = true;
    }

    public final void a(Menu menu, l.a aVar) {
        if (this.QF == null) {
            this.QF = new ActionMenuPresenter(this.gy.getContext());
            this.QF.dW = f.Ja;
        }
        this.QF.dU = aVar;
        this.gy.a((android.support.v7.view.menu.f) menu, this.QF);
    }

    public final void dismissPopupMenus() {
        Toolbar toolbar = this.gy;
        if (toolbar.QE != null) {
            toolbar.QE.dismissPopupMenus();
        }
    }

    public final int getDisplayOptions() {
        return this.aex;
    }

    public final void setDisplayOptions(int i) {
        int i2 = this.aex ^ i;
        this.aex = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    he();
                    hd();
                } else {
                    this.gy.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                hc();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.gy.setTitle(this.up);
                    this.gy.setSubtitle(this.uq);
                } else {
                    this.gy.setTitle(null);
                    this.gy.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.kC != null) {
                if ((i & 16) != 0) {
                    this.gy.addView(this.kC);
                } else {
                    this.gy.removeView(this.kC);
                }
            }
        }
    }

    public final void b(ai aiVar) {
        if (this.aey != null && this.aey.getParent() == this.gy) {
            this.gy.removeView(this.aey);
        }
        this.aey = aiVar;
        if (aiVar != null && this.aeE == 2) {
            this.gy.addView(this.aey, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.aey.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            aiVar.aaU = true;
        }
    }

    public final void N(boolean z) {
        Toolbar toolbar = this.gy;
        toolbar.aeq = z;
        toolbar.requestLayout();
    }

    public final int getNavigationMode() {
        return this.aeE;
    }

    public final void setCustomView(View view) {
        if (!(this.kC == null || (this.aex & 16) == 0)) {
            this.gy.removeView(this.kC);
        }
        this.kC = view;
        if (view != null && (this.aex & 16) != 0) {
            this.gy.addView(this.kC);
        }
    }

    public final View getCustomView() {
        return this.kC;
    }

    public final ah b(final int i, long j) {
        return y.U(this.gy).p(i == 0 ? 1.0f : 0.0f).c(j).a(new am(this) {
            private boolean QK = false;
            final /* synthetic */ aq aeI;

            public final void p(View view) {
                this.aeI.gy.setVisibility(0);
            }

            public final void q(View view) {
                if (!this.QK) {
                    this.aeI.gy.setVisibility(i);
                }
            }

            public final void ar(View view) {
                this.QK = true;
            }
        });
    }

    private void hd() {
        if ((this.aex & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.aeC)) {
            Toolbar toolbar = this.gy;
            int i = this.aeF;
            toolbar.setNavigationContentDescription(i != 0 ? toolbar.getContext().getText(i) : null);
            return;
        }
        this.gy.setNavigationContentDescription(this.aeC);
    }

    private void he() {
        if ((this.aex & 4) != 0) {
            this.gy.setNavigationIcon(this.aeA != null ? this.aeA : this.aeG);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.gy.setBackgroundDrawable(drawable);
    }

    public final int getHeight() {
        return this.gy.getHeight();
    }

    public final void setVisibility(int i) {
        this.gy.setVisibility(i);
    }

    public final int getVisibility() {
        return this.gy.getVisibility();
    }

    public final void a(l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        Toolbar toolbar = this.gy;
        toolbar.Si = aVar;
        toolbar.Sj = aVar2;
        if (toolbar.QE != null) {
            toolbar.QE.a(aVar, aVar2);
        }
    }

    public final Menu getMenu() {
        return this.gy.getMenu();
    }
}
