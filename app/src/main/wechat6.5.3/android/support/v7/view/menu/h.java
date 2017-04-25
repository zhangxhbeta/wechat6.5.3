package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.l.e;
import android.support.v7.view.menu.m.a;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class h implements b {
    static String Qb;
    static String Qc;
    static String Qd;
    static String Qe;
    private final int OD;
    private final int OE;
    final int OF;
    private CharSequence OG;
    private Intent OH;
    private char OI;
    private char OJ;
    private Drawable OK;
    private int OL = 0;
    private OnMenuItemClickListener OM;
    private p PT;
    private Runnable PU;
    int PV = 0;
    private View PW;
    public d PX;
    private e PY;
    private boolean PZ = false;
    ContextMenuInfo Qa;
    f dV;
    private final int dW;
    private int tM = 16;
    private CharSequence up;

    public final /* synthetic */ MenuItem setActionView(int i) {
        Context context = this.dV.mContext;
        aJ(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        return aJ(view);
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    h(f fVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.dV = fVar;
        this.dW = i2;
        this.OD = i;
        this.OE = i3;
        this.OF = i4;
        this.up = charSequence;
        this.PV = i5;
    }

    public final boolean dI() {
        if ((this.OM != null && this.OM.onMenuItemClick(this)) || this.dV.b(this.dV.dH(), (MenuItem) this)) {
            return true;
        }
        if (this.PU != null) {
            this.PU.run();
            return true;
        }
        if (this.OH != null) {
            try {
                this.dV.mContext.startActivity(this.OH);
                return true;
            } catch (ActivityNotFoundException e) {
            }
        }
        if (this.PX == null || !this.PX.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.tM & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.tM |= 16;
        } else {
            this.tM &= -17;
        }
        this.dV.h(false);
        return this;
    }

    public final int getGroupId() {
        return this.OD;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.dW;
    }

    public final int getOrder() {
        return this.OE;
    }

    public final Intent getIntent() {
        return this.OH;
    }

    public final MenuItem setIntent(Intent intent) {
        this.OH = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.OJ;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.OJ != c) {
            this.OJ = Character.toLowerCase(c);
            this.dV.h(false);
        }
        return this;
    }

    public final char getNumericShortcut() {
        return this.OI;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.OI != c) {
            this.OI = c;
            this.dV.h(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.OI = c;
        this.OJ = Character.toLowerCase(c2);
        this.dV.h(false);
        return this;
    }

    final char dJ() {
        return this.dV.dy() ? this.OJ : this.OI;
    }

    final boolean dK() {
        return this.dV.dz() && dJ() != '\u0000';
    }

    public final SubMenu getSubMenu() {
        return this.PT;
    }

    public final boolean hasSubMenu() {
        return this.PT != null;
    }

    public final void b(p pVar) {
        this.PT = pVar;
        pVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.up;
    }

    final CharSequence a(a aVar) {
        return (aVar == null || !aVar.D()) ? getTitle() : getTitleCondensed();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.up = charSequence;
        this.dV.h(false);
        if (this.PT != null) {
            this.PT.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.dV.mContext.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.OG != null ? this.OG : this.up;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.OG = charSequence;
        this.dV.h(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.OK != null) {
            return this.OK;
        }
        if (this.OL == 0) {
            return null;
        }
        Drawable a = android.support.v7.widget.h.eD().a(this.dV.mContext, this.OL, false);
        this.OL = 0;
        this.OK = a;
        return a;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.OL = 0;
        this.OK = drawable;
        this.dV.h(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.OK = null;
        this.OL = i;
        this.dV.h(false);
        return this;
    }

    public final boolean isCheckable() {
        return (this.tM & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.tM;
        this.tM = (z ? 1 : 0) | (this.tM & -2);
        if (i != this.tM) {
            this.dV.h(false);
        }
        return this;
    }

    public final void E(boolean z) {
        this.tM = (z ? 4 : 0) | (this.tM & -5);
    }

    public final boolean dL() {
        return (this.tM & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.tM & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.tM & 4) != 0) {
            f fVar = this.dV;
            int groupId = getGroupId();
            int size = fVar.eg.size();
            for (int i = 0; i < size; i++) {
                h hVar = (h) fVar.eg.get(i);
                if (hVar.getGroupId() == groupId && hVar.dL() && hVar.isCheckable()) {
                    hVar.F(hVar == this);
                }
            }
        } else {
            F(z);
        }
        return this;
    }

    private void F(boolean z) {
        int i;
        int i2 = this.tM;
        int i3 = this.tM & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.tM = i | i3;
        if (i2 != this.tM) {
            this.dV.h(false);
        }
    }

    public final boolean isVisible() {
        if (this.PX == null || !this.PX.overridesItemVisibility()) {
            if ((this.tM & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.tM & 8) == 0 && this.PX.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    final boolean G(boolean z) {
        int i = this.tM;
        this.tM = (z ? 0 : 8) | (this.tM & -9);
        if (i != this.tM) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (G(z)) {
            this.dV.dC();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.OM = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.up != null ? this.up.toString() : null;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.Qa;
    }

    public final boolean dM() {
        return (this.tM & 32) == 32;
    }

    public final boolean dN() {
        return (this.PV & 1) == 1;
    }

    public final boolean dO() {
        return (this.PV & 2) == 2;
    }

    public final void H(boolean z) {
        if (z) {
            this.tM |= 32;
        } else {
            this.tM &= -33;
        }
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.PV = i;
                this.dV.dD();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    private b aJ(View view) {
        this.PW = view;
        this.PX = null;
        if (view != null && view.getId() == -1 && this.dW > 0) {
            view.setId(this.dW);
        }
        this.dV.dD();
        return this;
    }

    public final View getActionView() {
        if (this.PW != null) {
            return this.PW;
        }
        if (this.PX == null) {
            return null;
        }
        this.PW = this.PX.onCreateActionView(this);
        return this.PW;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final d bx() {
        return this.PX;
    }

    public final b a(d dVar) {
        if (this.PX != null) {
            d dVar2 = this.PX;
            dVar2.wf = null;
            dVar2.we = null;
        }
        this.PW = null;
        this.PX = dVar;
        this.dV.h(true);
        if (this.PX != null) {
            this.PX.a(new d.b(this) {
                final /* synthetic */ h Qf;

                {
                    this.Qf = r1;
                }

                public final void bN() {
                    this.Qf.dV.dC();
                }
            });
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!dP()) {
            return false;
        }
        if (this.PY == null || this.PY.onMenuItemActionExpand(this)) {
            return this.dV.g(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.PV & 8) == 0) {
            return false;
        }
        if (this.PW == null) {
            return true;
        }
        if (this.PY == null || this.PY.onMenuItemActionCollapse(this)) {
            return this.dV.h(this);
        }
        return false;
    }

    public final b a(e eVar) {
        this.PY = eVar;
        return this;
    }

    public final boolean dP() {
        if ((this.PV & 8) == 0) {
            return false;
        }
        if (this.PW == null && this.PX != null) {
            this.PW = this.PX.onCreateActionView(this);
        }
        if (this.PW != null) {
            return true;
        }
        return false;
    }

    public final void I(boolean z) {
        this.PZ = z;
        this.dV.h(false);
    }

    public final boolean isActionViewExpanded() {
        return this.PZ;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
