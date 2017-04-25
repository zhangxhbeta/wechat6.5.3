package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.e;
import android.support.v4.view.n;
import android.support.v4.view.y;
import android.support.v7.a.a.k;
import android.support.v7.view.c;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionMenuView.d;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private Context QD;
    ActionMenuView QE;
    private boolean QI;
    private boolean QJ;
    private int Sg;
    android.support.v7.view.menu.l.a Si;
    android.support.v7.view.menu.f.a Sj;
    private final h Ts;
    TextView adN;
    TextView adO;
    ImageButton adP;
    private ImageView adQ;
    private Drawable adR;
    private CharSequence adS;
    private ImageButton adT;
    View adU;
    int adV;
    int adW;
    private int adX;
    private int adY;
    private int adZ;
    private int aea;
    private int aeb;
    private int aec;
    final ag aed;
    public CharSequence aee;
    CharSequence aef;
    private int aeg;
    private int aeh;
    private final ArrayList<View> aei;
    final ArrayList<View> aej;
    private final int[] aek;
    private b ael;
    private final d aem;
    private aq aen;
    private ActionMenuPresenter aeo;
    a aep;
    boolean aeq;
    private final Runnable aer;
    private int tD;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aev;
        boolean aew;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.aev = parcel.readInt();
            this.aew = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aev);
            parcel.writeInt(this.aew ? 1 : 0);
        }
    }

    public interface b {
        boolean ej();
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int aeu;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.aeu = 0;
        }

        public LayoutParams() {
            super(-2, -2);
            this.aeu = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.aeu = 0;
            this.aeu = layoutParams.aeu;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.aeu = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.aeu = 0;
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.aeu = 0;
        }
    }

    private class a implements l {
        final /* synthetic */ Toolbar aes;
        h aet;
        f dV;

        private a(Toolbar toolbar) {
            this.aes = toolbar;
        }

        public final void a(Context context, f fVar) {
            if (!(this.dV == null || this.aet == null)) {
                this.dV.h(this.aet);
            }
            this.dV = fVar;
        }

        public final void f(boolean z) {
            Object obj = null;
            if (this.aet != null) {
                if (this.dV != null) {
                    int size = this.dV.size();
                    for (int i = 0; i < size; i++) {
                        if (this.dV.getItem(i) == this.aet) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    c(this.aet);
                }
            }
        }

        public final boolean a(p pVar) {
            return false;
        }

        public final void a(f fVar, boolean z) {
        }

        public final boolean E() {
            return false;
        }

        public final boolean b(h hVar) {
            Toolbar.b(this.aes);
            if (this.aes.adT.getParent() != this.aes) {
                this.aes.addView(this.aes.adT);
            }
            this.aes.adU = hVar.getActionView();
            this.aet = hVar;
            if (this.aes.adU.getParent() != this.aes) {
                android.view.ViewGroup.LayoutParams ha = Toolbar.ha();
                ha.gravity = 8388611 | (this.aes.adX & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
                ha.aeu = 2;
                this.aes.adU.setLayoutParams(ha);
                this.aes.addView(this.aes.adU);
            }
            Toolbar toolbar = this.aes;
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (!(((LayoutParams) childAt.getLayoutParams()).aeu == 2 || childAt == toolbar.QE)) {
                    toolbar.removeViewAt(childCount);
                    toolbar.aej.add(childAt);
                }
            }
            this.aes.requestLayout();
            hVar.I(true);
            if (this.aes.adU instanceof c) {
                ((c) this.aes.adU).onActionViewExpanded();
            }
            return true;
        }

        public final boolean c(h hVar) {
            if (this.aes.adU instanceof c) {
                ((c) this.aes.adU).onActionViewCollapsed();
            }
            this.aes.removeView(this.aes.adU);
            this.aes.removeView(this.aes.adT);
            this.aes.adU = null;
            Toolbar toolbar = this.aes;
            for (int size = toolbar.aej.size() - 1; size >= 0; size--) {
                toolbar.addView((View) toolbar.aej.get(size));
            }
            toolbar.aej.clear();
            this.aet = null;
            this.aes.requestLayout();
            hVar.I(false);
            return true;
        }

        public final int getId() {
            return 0;
        }

        public final Parcelable onSaveInstanceState() {
            return null;
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
        }
    }

    static /* synthetic */ void b(Toolbar toolbar) {
        if (toolbar.adT == null) {
            toolbar.adT = new ImageButton(toolbar.getContext(), null, android.support.v7.a.a.a.HS);
            toolbar.adT.setImageDrawable(toolbar.adR);
            toolbar.adT.setContentDescription(toolbar.adS);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (toolbar.adX & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            layoutParams.aeu = 2;
            toolbar.adT.setLayoutParams(layoutParams);
            toolbar.adT.setOnClickListener(new OnClickListener(toolbar) {
                final /* synthetic */ Toolbar aes;

                {
                    this.aes = r1;
                }

                public final void onClick(View view) {
                    this.aes.collapseActionView();
                }
            });
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return f(layoutParams);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aed = new ag();
        this.tD = 8388627;
        this.aei = new ArrayList();
        this.aej = new ArrayList();
        this.aek = new int[2];
        this.aem = new d(this) {
            final /* synthetic */ Toolbar aes;

            {
                this.aes = r1;
            }

            public final boolean ej() {
                if (this.aes.ael != null) {
                    return this.aes.ael.ej();
                }
                return false;
            }
        };
        this.aer = new Runnable(this) {
            final /* synthetic */ Toolbar aes;

            {
                this.aes = r1;
            }

            public final void run() {
                this.aes.showOverflowMenu();
            }
        };
        ap a = ap.a(getContext(), attributeSet, k.dC, i);
        this.adV = a.getResourceId(k.Na, 0);
        this.adW = a.getResourceId(k.MS, 0);
        this.tD = a.adM.getInteger(k.ME, this.tD);
        this.adX = 48;
        int dimensionPixelOffset = a.getDimensionPixelOffset(k.MZ, 0);
        this.aec = dimensionPixelOffset;
        this.aeb = dimensionPixelOffset;
        this.aea = dimensionPixelOffset;
        this.adZ = dimensionPixelOffset;
        dimensionPixelOffset = a.getDimensionPixelOffset(k.MX, -1);
        if (dimensionPixelOffset >= 0) {
            this.adZ = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.MW, -1);
        if (dimensionPixelOffset >= 0) {
            this.aea = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.MY, -1);
        if (dimensionPixelOffset >= 0) {
            this.aeb = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.MV, -1);
        if (dimensionPixelOffset >= 0) {
            this.aec = dimensionPixelOffset;
        }
        this.adY = a.getDimensionPixelSize(k.MN, -1);
        dimensionPixelOffset = a.getDimensionPixelOffset(k.MK, Integer.MIN_VALUE);
        int dimensionPixelOffset2 = a.getDimensionPixelOffset(k.MH, Integer.MIN_VALUE);
        int dimensionPixelSize = a.getDimensionPixelSize(k.MI, 0);
        int dimensionPixelSize2 = a.getDimensionPixelSize(k.MJ, 0);
        ag agVar = this.aed;
        agVar.aaQ = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            agVar.aaO = dimensionPixelSize;
            agVar.aaL = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            agVar.aaP = dimensionPixelSize2;
            agVar.aaM = dimensionPixelSize2;
        }
        if (!(dimensionPixelOffset == Integer.MIN_VALUE && dimensionPixelOffset2 == Integer.MIN_VALUE)) {
            this.aed.Y(dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.adR = a.getDrawable(k.MG);
        this.adS = a.getText(k.MF);
        CharSequence text = a.getText(k.MU);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        text = a.getText(k.MR);
        if (!TextUtils.isEmpty(text)) {
            setSubtitle(text);
        }
        this.QD = getContext();
        setPopupTheme(a.getResourceId(k.MQ, 0));
        Drawable drawable = a.getDrawable(k.MP);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        text = a.getText(k.MO);
        if (!TextUtils.isEmpty(text)) {
            setNavigationContentDescription(text);
        }
        drawable = a.getDrawable(k.ML);
        if (drawable != null) {
            setLogo(drawable);
        }
        text = a.getText(k.MM);
        if (!TextUtils.isEmpty(text)) {
            if (!TextUtils.isEmpty(text)) {
                gX();
            }
            if (this.adQ != null) {
                this.adQ.setContentDescription(text);
            }
        }
        if (a.hasValue(k.Nb)) {
            dimensionPixelOffset = a.bz(k.Nb);
            this.aeg = dimensionPixelOffset;
            if (this.adN != null) {
                this.adN.setTextColor(dimensionPixelOffset);
            }
        }
        if (a.hasValue(k.MT)) {
            dimensionPixelOffset = a.bz(k.MT);
            this.aeh = dimensionPixelOffset;
            if (this.adO != null) {
                this.adO.setTextColor(dimensionPixelOffset);
            }
        }
        a.adM.recycle();
        this.Ts = h.eD();
    }

    public final void setPopupTheme(int i) {
        if (this.Sg != i) {
            this.Sg = i;
            if (i == 0) {
                this.QD = getContext();
            } else {
                this.QD = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ag agVar = this.aed;
        if (i != 1) {
            z = false;
        }
        if (z != agVar.gc) {
            agVar.gc = z;
            if (!agVar.aaQ) {
                agVar.aaL = agVar.aaO;
                agVar.aaM = agVar.aaP;
            } else if (z) {
                agVar.aaL = agVar.vL != Integer.MIN_VALUE ? agVar.vL : agVar.aaO;
                agVar.aaM = agVar.aaN != Integer.MIN_VALUE ? agVar.aaN : agVar.aaP;
            } else {
                agVar.aaL = agVar.aaN != Integer.MIN_VALUE ? agVar.aaN : agVar.aaO;
                agVar.aaM = agVar.vL != Integer.MIN_VALUE ? agVar.vL : agVar.aaP;
            }
        }
    }

    public final boolean isOverflowMenuShowing() {
        if (this.QE != null) {
            ActionMenuView actionMenuView = this.QE;
            boolean z = actionMenuView.Sh != null && actionMenuView.Sh.isOverflowMenuShowing();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        if (this.QE != null) {
            ActionMenuView actionMenuView = this.QE;
            boolean z = actionMenuView.Sh != null && actionMenuView.Sh.showOverflowMenu();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void a(f fVar, ActionMenuPresenter actionMenuPresenter) {
        if (fVar != null || this.QE != null) {
            gY();
            f fVar2 = this.QE.dV;
            if (fVar2 != fVar) {
                if (fVar2 != null) {
                    fVar2.b(this.aeo);
                    fVar2.b(this.aep);
                }
                if (this.aep == null) {
                    this.aep = new a();
                }
                actionMenuPresenter.RQ = true;
                if (fVar != null) {
                    fVar.a((l) actionMenuPresenter, this.QD);
                    fVar.a(this.aep, this.QD);
                } else {
                    actionMenuPresenter.a(this.QD, null);
                    this.aep.a(this.QD, null);
                    actionMenuPresenter.f(true);
                    this.aep.f(true);
                }
                this.QE.setPopupTheme(this.Sg);
                this.QE.a(actionMenuPresenter);
                this.aeo = actionMenuPresenter;
            }
        }
    }

    public final void setLogo(Drawable drawable) {
        if (drawable != null) {
            gX();
            if (!bt(this.adQ)) {
                e(this.adQ, true);
            }
        } else if (this.adQ != null && bt(this.adQ)) {
            removeView(this.adQ);
            this.aej.remove(this.adQ);
        }
        if (this.adQ != null) {
            this.adQ.setImageDrawable(drawable);
        }
    }

    private void gX() {
        if (this.adQ == null) {
            this.adQ = new ImageView(getContext());
        }
    }

    public final void collapseActionView() {
        h hVar = this.aep == null ? null : this.aep.aet;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public final void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.adN == null) {
                Context context = getContext();
                this.adN = new TextView(context);
                this.adN.setSingleLine();
                this.adN.setEllipsize(TruncateAt.END);
                if (this.adV != 0) {
                    this.adN.setTextAppearance(context, this.adV);
                }
                if (this.aeg != 0) {
                    this.adN.setTextColor(this.aeg);
                }
            }
            if (!bt(this.adN)) {
                e(this.adN, true);
            }
        } else if (this.adN != null && bt(this.adN)) {
            removeView(this.adN);
            this.aej.remove(this.adN);
        }
        if (this.adN != null) {
            this.adN.setText(charSequence);
        }
        this.aee = charSequence;
    }

    public final void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.adO == null) {
                Context context = getContext();
                this.adO = new TextView(context);
                this.adO.setSingleLine();
                this.adO.setEllipsize(TruncateAt.END);
                if (this.adW != 0) {
                    this.adO.setTextAppearance(context, this.adW);
                }
                if (this.aeh != 0) {
                    this.adO.setTextColor(this.aeh);
                }
            }
            if (!bt(this.adO)) {
                e(this.adO, true);
            }
        } else if (this.adO != null && bt(this.adO)) {
            removeView(this.adO);
            this.aej.remove(this.adO);
        }
        if (this.adO != null) {
            this.adO.setText(charSequence);
        }
        this.aef = charSequence;
    }

    public final CharSequence getNavigationContentDescription() {
        return this.adP != null ? this.adP.getContentDescription() : null;
    }

    public final void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            gZ();
        }
        if (this.adP != null) {
            this.adP.setContentDescription(charSequence);
        }
    }

    public final void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            gZ();
            if (!bt(this.adP)) {
                e(this.adP, true);
            }
        } else if (this.adP != null && bt(this.adP)) {
            removeView(this.adP);
            this.aej.remove(this.adP);
        }
        if (this.adP != null) {
            this.adP.setImageDrawable(drawable);
        }
    }

    public final void setNavigationOnClickListener(OnClickListener onClickListener) {
        gZ();
        this.adP.setOnClickListener(onClickListener);
    }

    public final Menu getMenu() {
        gY();
        if (this.QE.dV == null) {
            f fVar = (f) this.QE.getMenu();
            if (this.aep == null) {
                this.aep = new a();
            }
            this.QE.Sh.RQ = true;
            fVar.a(this.aep, this.QD);
        }
        return this.QE.getMenu();
    }

    private void gY() {
        if (this.QE == null) {
            this.QE = new ActionMenuView(getContext());
            this.QE.setPopupTheme(this.Sg);
            this.QE.Sn = this.aem;
            this.QE.a(this.Si, this.Sj);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388613 | (this.adX & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            this.QE.setLayoutParams(layoutParams);
            e(this.QE, false);
        }
    }

    private void gZ() {
        if (this.adP == null) {
            this.adP = new ImageButton(getContext(), null, android.support.v7.a.a.a.HS);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (this.adX & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            this.adP.setLayoutParams(layoutParams);
        }
    }

    private void e(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = f(layoutParams);
        }
        layoutParams.aeu = 1;
        if (!z || this.adU == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.aej.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.aep == null || this.aep.aet == null)) {
            savedState.aev = this.aep.aet.getItemId();
        }
        savedState.aew = isOverflowMenuShowing();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu menu = this.QE != null ? this.QE.dV : null;
            if (!(savedState.aev == 0 || this.aep == null || menu == null)) {
                MenuItem findItem = menu.findItem(savedState.aev);
                if (findItem != null) {
                    android.support.v4.view.l.b(findItem);
                }
            }
            if (savedState.aew) {
                removeCallbacks(this.aer);
                post(this.aer);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.aer);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = n.d(motionEvent);
        if (d == 0) {
            this.QI = false;
        }
        if (!this.QI) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (d == 0 && !onTouchEvent) {
                this.QI = true;
            }
        }
        if (d == 1 || d == 3) {
            this.QI = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int d = n.d(motionEvent);
        if (d == 9) {
            this.QJ = false;
        }
        if (!this.QJ) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (d == 9 && !onHoverEvent) {
                this.QJ = true;
            }
        }
        if (d == 10 || d == 3) {
            this.QJ = false;
        }
        return true;
    }

    private void i(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int combineMeasuredStates;
        int i5;
        Object obj;
        int[] iArr = this.aek;
        if (as.bu(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (bq(this.adP)) {
            i(this.adP, i, 0, i2, this.adY);
            i6 = this.adP.getMeasuredWidth() + br(this.adP);
            max = Math.max(0, this.adP.getMeasuredHeight() + bs(this.adP));
            combineMeasuredStates = as.combineMeasuredStates(0, y.M(this.adP));
            i5 = max;
        } else {
            combineMeasuredStates = 0;
            i5 = 0;
        }
        if (bq(this.adT)) {
            i(this.adT, i, 0, i2, this.adY);
            i6 = this.adT.getMeasuredWidth() + br(this.adT);
            i5 = Math.max(i5, this.adT.getMeasuredHeight() + bs(this.adT));
            combineMeasuredStates = as.combineMeasuredStates(combineMeasuredStates, y.M(this.adT));
        }
        ag agVar = this.aed;
        int i7 = agVar.gc ? agVar.aaM : agVar.aaL;
        int max2 = Math.max(i7, i6) + 0;
        iArr[i4] = Math.max(0, i7 - i6);
        i6 = 0;
        if (bq(this.QE)) {
            i(this.QE, i, max2, i2, this.adY);
            i6 = this.QE.getMeasuredWidth() + br(this.QE);
            i5 = Math.max(i5, this.QE.getMeasuredHeight() + bs(this.QE));
            combineMeasuredStates = as.combineMeasuredStates(combineMeasuredStates, y.M(this.QE));
        }
        agVar = this.aed;
        i7 = agVar.gc ? agVar.aaL : agVar.aaM;
        max2 += Math.max(i7, i6);
        iArr[i3] = Math.max(0, i7 - i6);
        if (bq(this.adU)) {
            max2 += a(this.adU, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.adU.getMeasuredHeight() + bs(this.adU));
            combineMeasuredStates = as.combineMeasuredStates(combineMeasuredStates, y.M(this.adU));
        }
        if (bq(this.adQ)) {
            max2 += a(this.adQ, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.adQ.getMeasuredHeight() + bs(this.adQ));
            combineMeasuredStates = as.combineMeasuredStates(combineMeasuredStates, y.M(this.adQ));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = combineMeasuredStates;
        int i9 = i5;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).aeu == 0 && bq(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i9, childAt.getMeasuredHeight() + bs(childAt));
                i6 = as.combineMeasuredStates(i8, y.M(childAt));
                i7 = max;
            } else {
                i6 = i8;
                i7 = i9;
            }
            i3++;
            i8 = i6;
            i9 = i7;
        }
        i7 = 0;
        i6 = 0;
        int i10 = this.aeb + this.aec;
        max = this.adZ + this.aea;
        if (bq(this.adN)) {
            a(this.adN, i, max2 + max, i2, i10, iArr);
            i7 = br(this.adN) + this.adN.getMeasuredWidth();
            i6 = this.adN.getMeasuredHeight() + bs(this.adN);
            i8 = as.combineMeasuredStates(i8, y.M(this.adN));
        }
        if (bq(this.adO)) {
            i7 = Math.max(i7, a(this.adO, i, max2 + max, i2, i10 + i6, iArr));
            i6 += this.adO.getMeasuredHeight() + bs(this.adO);
            i8 = as.combineMeasuredStates(i8, y.M(this.adO));
        }
        i6 = Math.max(i9, i6) + (getPaddingTop() + getPaddingBottom());
        max = y.resolveSizeAndState(Math.max((i7 + max2) + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, WebView.NIGHT_MODE_COLOR & i8);
        i6 = y.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i2, i8 << 16);
        if (this.aeq) {
            max2 = getChildCount();
            for (i7 = 0; i7 < max2; i7++) {
                View childAt2 = getChildAt(i7);
                if (bq(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i6 = 0;
        }
        setMeasuredDimension(max, i6);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int paddingTop;
        int measuredWidth;
        if (y.I(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.aek;
        iArr[1] = 0;
        iArr[0] = 0;
        int T = y.T(this);
        if (!bq(this.adP)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = b(this.adP, i8, iArr, T);
            i5 = paddingLeft;
        } else {
            i5 = a(this.adP, paddingLeft, iArr, T);
        }
        if (bq(this.adT)) {
            if (obj != null) {
                i8 = b(this.adT, i8, iArr, T);
            } else {
                i5 = a(this.adT, i5, iArr, T);
            }
        }
        if (bq(this.QE)) {
            if (obj != null) {
                i5 = a(this.QE, i5, iArr, T);
            } else {
                i8 = b(this.QE, i8, iArr, T);
            }
        }
        iArr[0] = Math.max(0, this.aed.aaL - i5);
        iArr[1] = Math.max(0, this.aed.aaM - ((width - paddingRight) - i8));
        i5 = Math.max(i5, this.aed.aaL);
        i8 = Math.min(i8, (width - paddingRight) - this.aed.aaM);
        if (bq(this.adU)) {
            if (obj != null) {
                i8 = b(this.adU, i8, iArr, T);
            } else {
                i5 = a(this.adU, i5, iArr, T);
            }
        }
        if (!bq(this.adQ)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = b(this.adQ, i8, iArr, T);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = a(this.adQ, i5, iArr, T);
        }
        boolean bq = bq(this.adN);
        boolean bq2 = bq(this.adO);
        i5 = 0;
        if (bq) {
            LayoutParams layoutParams = (LayoutParams) this.adN.getLayoutParams();
            i5 = (layoutParams.bottomMargin + (layoutParams.topMargin + this.adN.getMeasuredHeight())) + 0;
        }
        if (bq2) {
            layoutParams = (LayoutParams) this.adO.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.adO.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (bq || bq2) {
            layoutParams = (LayoutParams) (bq ? this.adN : this.adO).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (bq2 ? this.adO : this.adN).getLayoutParams();
            Object obj2 = ((!bq || this.adN.getMeasuredWidth() <= 0) && (!bq2 || this.adO.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case 48:
                    paddingTop = (layoutParams.topMargin + getPaddingTop()) + this.aeb;
                    break;
                case 80:
                    paddingTop = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.aec) - measuredHeight;
                    break;
                default:
                    paddingTop = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop < layoutParams.topMargin + this.aeb) {
                        i8 = layoutParams.topMargin + this.aeb;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop) - paddingTop2;
                        if (measuredHeight < layoutParams.bottomMargin + this.aec) {
                            i8 = Math.max(0, paddingTop - ((layoutParams2.bottomMargin + this.aec) - measuredHeight));
                        } else {
                            i8 = paddingTop;
                        }
                    }
                    paddingTop = paddingTop2 + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.adZ : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (bq) {
                    layoutParams = (LayoutParams) this.adN.getLayoutParams();
                    measuredWidth = i5 - this.adN.getMeasuredWidth();
                    i6 = this.adN.getMeasuredHeight() + paddingTop;
                    this.adN.layout(measuredWidth, paddingTop, i5, i6);
                    paddingTop = i6 + layoutParams.bottomMargin;
                    i6 = measuredWidth - this.aea;
                } else {
                    i6 = i5;
                }
                if (bq2) {
                    layoutParams = (LayoutParams) this.adO.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop;
                    this.adO.layout(i5 - this.adO.getMeasuredWidth(), measuredWidth, i5, this.adO.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i5 - this.aea;
                    i8 = layoutParams.bottomMargin;
                    i8 = measuredWidth;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.adZ : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (bq) {
                    layoutParams = (LayoutParams) this.adN.getLayoutParams();
                    i5 = this.adN.getMeasuredWidth() + i7;
                    measuredWidth = this.adN.getMeasuredHeight() + paddingTop;
                    this.adN.layout(i7, paddingTop, i5, measuredWidth);
                    i8 = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.aea;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop;
                }
                if (bq2) {
                    layoutParams = (LayoutParams) this.adO.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop = this.adO.getMeasuredWidth() + i7;
                    this.adO.layout(i7, i5, paddingTop, this.adO.getMeasuredHeight() + i5);
                    i5 = this.aea + paddingTop;
                    i8 = layoutParams.bottomMargin;
                    i8 = i5;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        a(this.aei, 3);
        int size = this.aei.size();
        measuredWidth = i7;
        for (i5 = 0; i5 < size; i5++) {
            measuredWidth = a((View) this.aei.get(i5), measuredWidth, iArr, T);
        }
        a(this.aei, 5);
        i7 = this.aei.size();
        i5 = 0;
        measuredHeight = i6;
        while (i5 < i7) {
            i6 = b((View) this.aei.get(i5), measuredHeight, iArr, T);
            i5++;
            measuredHeight = i6;
        }
        a(this.aei, 1);
        List list = this.aei;
        i6 = iArr[0];
        i7 = iArr[1];
        paddingTop2 = list.size();
        size = i6;
        paddingTop = i7;
        i6 = 0;
        i7 = 0;
        while (i6 < paddingTop2) {
            View view = (View) list.get(i6);
            layoutParams = (LayoutParams) view.getLayoutParams();
            size = layoutParams.leftMargin - size;
            i8 = layoutParams.rightMargin - paddingTop;
            paddingBottom = Math.max(0, size);
            int max = Math.max(0, i8);
            size = Math.max(0, -size);
            paddingTop = Math.max(0, -i8);
            i6++;
            i7 += (view.getMeasuredWidth() + paddingBottom) + max;
        }
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i7 / 2);
        i5 = i8 + i7;
        if (i8 < measuredWidth) {
            i8 = measuredWidth;
        } else if (i5 > measuredHeight) {
            i8 -= i5 - measuredHeight;
        }
        paddingLeft = this.aei.size();
        measuredWidth = 0;
        i5 = i8;
        while (measuredWidth < paddingLeft) {
            i8 = a((View) this.aei.get(measuredWidth), i5, iArr, T);
            measuredWidth++;
            i5 = i8;
        }
        this.aei.clear();
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = o(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = o(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int o(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        switch (i3) {
            case 16:
            case 48:
            case 80:
                break;
            default:
                i3 = this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                break;
        }
        switch (i3) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i4;
                i3 = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - i3) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i4 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - i3;
                    i4 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i4 + i3;
        }
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (y.I(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = e.getAbsoluteGravity(i, y.I(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.aeu == 0 && bq(childAt) && bA(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.aeu == 0 && bq(childAt2) && bA(layoutParams.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int bA(int i) {
        int I = y.I(this);
        int absoluteGravity = e.getAbsoluteGravity(i, I) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return I == 1 ? 5 : 3;
        }
    }

    private boolean bq(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int br(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.view.k.b(marginLayoutParams) + android.support.v4.view.k.a(marginLayoutParams);
    }

    private static int bs(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private static LayoutParams f(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams ha() {
        return new LayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public final u hb() {
        if (this.aen == null) {
            this.aen = new aq(this);
        }
        return this.aen;
    }

    private boolean bt(View view) {
        return view.getParent() == this || this.aej.contains(view);
    }
}
