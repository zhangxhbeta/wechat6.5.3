package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ad;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.p;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

final class ActionMenuPresenter extends android.support.v7.view.menu.b implements android.support.v4.view.d.a {
    d RF;
    private Drawable RG;
    private boolean RH;
    private boolean RI;
    private boolean RJ;
    private int RK;
    private int RL;
    int RM;
    boolean RN;
    private boolean RO;
    private boolean RP;
    boolean RQ;
    private int RR;
    private final SparseBooleanArray RS = new SparseBooleanArray();
    private View RT;
    e RU;
    a RV;
    c RW;
    private b RX;
    final f RY = new f();
    int RZ;

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int Sf;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.Sf = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Sf);
        }
    }

    private class c implements Runnable {
        final /* synthetic */ ActionMenuPresenter Sa;
        private e Sb;

        public c(ActionMenuPresenter actionMenuPresenter, e eVar) {
            this.Sa = actionMenuPresenter;
            this.Sb = eVar;
        }

        public final void run() {
            android.support.v7.view.menu.f fVar = this.Sa.dV;
            if (fVar.Px != null) {
                fVar.Px.b(fVar);
            }
            View view = (View) this.Sa.Pb;
            if (!(view == null || view.getWindowToken() == null || !this.Sb.dQ())) {
                this.Sa.RU = this.Sb;
            }
            this.Sa.RW = null;
        }
    }

    private class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        final /* synthetic */ ActionMenuPresenter Sa;

        private b(ActionMenuPresenter actionMenuPresenter) {
            this.Sa = actionMenuPresenter;
        }

        public final ListPopupWindow dt() {
            return this.Sa.RV != null ? this.Sa.RV.Qs : null;
        }
    }

    private class f implements android.support.v7.view.menu.l.a {
        final /* synthetic */ ActionMenuPresenter Sa;

        private f(ActionMenuPresenter actionMenuPresenter) {
            this.Sa = actionMenuPresenter;
        }

        public final boolean d(android.support.v7.view.menu.f fVar) {
            if (fVar == null) {
                return false;
            }
            this.Sa.RZ = ((p) fVar).getItem().getItemId();
            android.support.v7.view.menu.l.a aVar = this.Sa.dU;
            return aVar != null ? aVar.d(fVar) : false;
        }

        public final void a(android.support.v7.view.menu.f fVar, boolean z) {
            if (fVar instanceof p) {
                ((p) fVar).QA.D(false);
            }
            android.support.v7.view.menu.l.a aVar = this.Sa.dU;
            if (aVar != null) {
                aVar.a(fVar, z);
            }
        }
    }

    private class a extends k {
        private p PT;
        final /* synthetic */ ActionMenuPresenter Sa;

        public a(ActionMenuPresenter actionMenuPresenter, Context context, p pVar) {
            boolean z = false;
            this.Sa = actionMenuPresenter;
            super(context, pVar, null, false, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.PT = pVar;
            if (!((h) pVar.getItem()).dM()) {
                this.hy = actionMenuPresenter.RF == null ? (View) actionMenuPresenter.Pb : actionMenuPresenter.RF;
            }
            this.PS = actionMenuPresenter.RY;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            this.Pn = z;
        }

        public final void onDismiss() {
            super.onDismiss();
            this.Sa.RV = null;
            this.Sa.RZ = 0;
        }
    }

    private class d extends AppCompatImageView implements android.support.v7.widget.ActionMenuView.a {
        final /* synthetic */ ActionMenuPresenter Sa;
        private final float[] Sc = new float[2];

        public d(final ActionMenuPresenter actionMenuPresenter, Context context) {
            this.Sa = actionMenuPresenter;
            super(context, null, android.support.v7.a.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new android.support.v7.widget.ListPopupWindow.b(this, this) {
                final /* synthetic */ d Se;

                public final ListPopupWindow dt() {
                    if (this.Se.Sa.RU == null) {
                        return null;
                    }
                    return this.Se.Sa.RU.Qs;
                }

                public final boolean du() {
                    this.Se.Sa.showOverflowMenu();
                    return true;
                }

                public final boolean ef() {
                    if (this.Se.Sa.RW != null) {
                        return false;
                    }
                    this.Se.Sa.hideOverflowMenu();
                    return true;
                }
            });
        }

        public final boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.Sa.showOverflowMenu();
            }
            return true;
        }

        public final boolean dr() {
            return false;
        }

        public final boolean ds() {
            return false;
        }

        protected final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class e extends k {
        final /* synthetic */ ActionMenuPresenter Sa;

        public e(ActionMenuPresenter actionMenuPresenter, Context context, android.support.v7.view.menu.f fVar, View view) {
            this.Sa = actionMenuPresenter;
            super(context, fVar, view, true, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.PS = actionMenuPresenter.RY;
        }

        public final void onDismiss() {
            super.onDismiss();
            if (this.Sa.dV != null) {
                this.Sa.dV.close();
            }
            this.Sa.RU = null;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, android.support.v7.a.a.h.JK, android.support.v7.a.a.h.JJ);
    }

    public final void a(Context context, android.support.v7.view.menu.f fVar) {
        boolean z = true;
        super.a(context, fVar);
        Resources resources = context.getResources();
        android.support.v7.view.a m = android.support.v7.view.a.m(context);
        if (!this.RJ) {
            if (VERSION.SDK_INT < 19 && ad.b(ViewConfiguration.get(m.mContext))) {
                z = false;
            }
            this.RI = z;
        }
        if (!this.RP) {
            this.RK = m.mContext.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.RN) {
            this.RM = m.mContext.getResources().getInteger(g.JH);
        }
        int i = this.RK;
        if (this.RI) {
            if (this.RF == null) {
                this.RF = new d(this, this.OX);
                if (this.RH) {
                    this.RF.setImageDrawable(this.RG);
                    this.RG = null;
                    this.RH = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.RF.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.RF.getMeasuredWidth();
        } else {
            this.RF = null;
        }
        this.RL = i;
        this.RR = (int) (56.0f * resources.getDisplayMetrics().density);
        this.RT = null;
    }

    public final void ec() {
        this.RI = true;
        this.RJ = true;
    }

    public final m c(ViewGroup viewGroup) {
        m c = super.c(viewGroup);
        ((ActionMenuView) c).a(this);
        return c;
    }

    public final View a(h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.dP()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.c(layoutParams));
        }
        return actionView;
    }

    public final void a(h hVar, android.support.v7.view.menu.m.a aVar) {
        aVar.a(hVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.OO = (ActionMenuView) this.Pb;
        if (this.RX == null) {
            this.RX = new b();
        }
        actionMenuItemView.OQ = this.RX;
    }

    public final boolean e(h hVar) {
        return hVar.dM();
    }

    public final void f(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ((View) this.Pb).getParent();
        super.f(z);
        ((View) this.Pb).requestLayout();
        if (this.dV != null) {
            android.support.v7.view.menu.f fVar = this.dV;
            fVar.dF();
            ArrayList arrayList = fVar.PA;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                android.support.v4.view.d dVar = ((h) arrayList.get(i)).PX;
                if (dVar != null) {
                    dVar.we = this;
                }
            }
        }
        ArrayList dG = this.dV != null ? this.dV.dG() : null;
        if (this.RI && dG != null) {
            i = dG.size();
            if (i == 1) {
                int i4;
                if (((h) dG.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.RF == null) {
                this.RF = new d(this, this.OX);
            }
            ViewGroup viewGroup = (ViewGroup) this.RF.getParent();
            if (viewGroup != this.Pb) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.RF);
                }
                ((ActionMenuView) this.Pb).addView(this.RF, ActionMenuView.eh());
            }
        } else if (this.RF != null && this.RF.getParent() == this.Pb) {
            ((ViewGroup) this.Pb).removeView(this.RF);
        }
        ((ActionMenuView) this.Pb).RI = this.RI;
    }

    public final boolean c(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.RF) {
            return false;
        }
        return super.c(viewGroup, i);
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        View view;
        p pVar2 = pVar;
        while (pVar2.QA != this.dV) {
            pVar2 = (p) pVar2.QA;
        }
        h item = pVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.Pb;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof android.support.v7.view.menu.m.a) && ((android.support.v7.view.menu.m.a) childAt).C() == item) {
                    view = childAt;
                    break;
                }
            }
        }
        view = null;
        if (view == null) {
            if (this.RF == null) {
                return false;
            }
            view = this.RF;
        }
        this.RZ = pVar.getItem().getItemId();
        this.RV = new a(this, this.mContext, pVar);
        this.RV.hy = view;
        if (this.RV.dQ()) {
            super.a(pVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean showOverflowMenu() {
        if (!this.RI || isOverflowMenuShowing() || this.dV == null || this.Pb == null || this.RW != null || this.dV.dG().isEmpty()) {
            return false;
        }
        this.RW = new c(this, new e(this, this.mContext, this.dV, this.RF));
        ((View) this.Pb).post(this.RW);
        super.a(null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.RW == null || this.Pb == null) {
            k kVar = this.RU;
            if (kVar == null) {
                return false;
            }
            kVar.dismiss();
            return true;
        }
        ((View) this.Pb).removeCallbacks(this.RW);
        this.RW = null;
        return true;
    }

    public final boolean ed() {
        return hideOverflowMenu() | ee();
    }

    public final boolean ee() {
        if (this.RV == null) {
            return false;
        }
        this.RV.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        return this.RU != null && this.RU.isShowing();
    }

    public final boolean E() {
        int i;
        ArrayList dE = this.dV.dE();
        int size = dE.size();
        int i2 = this.RM;
        int i3 = this.RL;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.Pb;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            h hVar = (h) dE.get(i6);
            if (hVar.dO()) {
                i4++;
            } else if (hVar.dN()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.RQ && hVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.RI && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.RS;
        sparseBooleanArray.clear();
        if (this.RO) {
            int i7 = i3 / this.RR;
            i5 = ((i3 % this.RR) / i7) + this.RR;
            i = i7;
        } else {
            i5 = 0;
            i = 0;
        }
        i2 = 0;
        int i8 = 0;
        i4 = i;
        while (i8 < size) {
            h hVar2 = (h) dE.get(i8);
            View a;
            int i9;
            if (hVar2.dO()) {
                a = a(hVar2, this.RT, viewGroup);
                if (this.RT == null) {
                    this.RT = a;
                }
                if (this.RO) {
                    i = i4 - ActionMenuView.d(a, i5, i4, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i4;
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = hVar2.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                hVar2.H(true);
                i7 = i9;
                i2 = i6;
            } else if (hVar2.dN()) {
                boolean z;
                int groupId = hVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.RO || i4 > 0);
                if (z3) {
                    a = a(hVar2, this.RT, viewGroup);
                    if (this.RT == null) {
                        this.RT = a;
                    }
                    if (this.RO) {
                        int d = ActionMenuView.d(a, i5, i4, makeMeasureSpec, 0);
                        i4 -= d;
                        if (d == 0) {
                            i = 0;
                        }
                    } else {
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i9 = a.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.RO) {
                        z = i & (i3 >= 0 ? 1 : 0);
                        i9 = i4;
                    } else {
                        z = i & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i4;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i8; i6++) {
                        hVar = (h) dE.get(i6);
                        if (hVar.getGroupId() == groupId) {
                            if (hVar.dM()) {
                                i4++;
                            }
                            hVar.H(false);
                        }
                    }
                    i = i4;
                } else {
                    i = i6;
                }
                if (z) {
                    i--;
                }
                hVar2.H(z);
                i4 = i2;
                i7 = i3;
                i2 = i;
                i = i9;
            } else {
                hVar2.H(false);
                i = i4;
                i7 = i3;
                i4 = i2;
                i2 = i6;
            }
            i8++;
            i3 = i7;
            i6 = i2;
            i2 = i4;
            i4 = i;
        }
        return true;
    }

    public final void a(android.support.v7.view.menu.f fVar, boolean z) {
        ed();
        super.a(fVar, z);
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.Sf = this.RZ;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.Sf > 0) {
                MenuItem findItem = this.dV.findItem(savedState.Sf);
                if (findItem != null) {
                    a((p) findItem.getSubMenu());
                }
            }
        }
    }

    public final void q(boolean z) {
        if (z) {
            super.a(null);
        } else {
            this.dV.D(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.Pb = actionMenuView;
        actionMenuView.dV = this.dV;
    }
}
