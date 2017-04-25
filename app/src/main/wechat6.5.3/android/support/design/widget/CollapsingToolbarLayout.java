package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ao;
import android.support.v4.view.s;
import android.support.v4.view.y;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.WebView;

public class CollapsingToolbarLayout extends FrameLayout {
    private ao eC;
    private View gA;
    private int gB;
    private int gC;
    private int gD;
    private int gE;
    private final Rect gF;
    private final f gG;
    private boolean gH;
    private boolean gI;
    private Drawable gJ;
    private Drawable gK;
    int gL;
    boolean gM;
    u gN;
    private android.support.design.widget.AppBarLayout.a gO;
    private int gP;
    private boolean gw;
    private int gx;
    private Toolbar gy;
    private View gz;

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        int gR = 0;
        float gS = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bq);
            this.gR = obtainStyledAttributes.getInt(i.br, 0);
            this.gS = obtainStyledAttributes.getFloat(i.bt, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.widget.FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class a implements android.support.design.widget.AppBarLayout.a {
        final /* synthetic */ CollapsingToolbarLayout gQ;

        private a(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.gQ = collapsingToolbarLayout;
        }

        public final void a(AppBarLayout appBarLayout, int i) {
            int systemWindowInsetTop;
            int i2 = WebView.NORMAL_MODE_ALPHA;
            int i3 = 1;
            int i4 = 0;
            this.gQ.gP = i;
            if (this.gQ.eC != null) {
                systemWindowInsetTop = this.gQ.eC.getSystemWindowInsetTop();
            } else {
                systemWindowInsetTop = 0;
            }
            int I = appBarLayout.I();
            int childCount = this.gQ.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.gQ.getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                z l = CollapsingToolbarLayout.k(childAt);
                switch (layoutParams.gR) {
                    case 1:
                        if ((this.gQ.getHeight() - systemWindowInsetTop) + i < childAt.getHeight()) {
                            break;
                        }
                        l.f(-i);
                        break;
                    case 2:
                        l.f(Math.round(layoutParams.gS * ((float) (-i))));
                        break;
                    default:
                        break;
                }
            }
            if (!(this.gQ.gJ == null && this.gQ.gK == null)) {
                View view = this.gQ;
                boolean z = this.gQ.getHeight() + i < (y.T(this.gQ) * 2) + systemWindowInsetTop;
                if (!y.ai(view) || view.isInEditMode()) {
                    i3 = 0;
                }
                if (view.gM != z) {
                    if (i3 != 0) {
                        if (z) {
                            i4 = WebView.NORMAL_MODE_ALPHA;
                        }
                        view.S();
                        if (view.gN == null) {
                            Interpolator interpolator;
                            view.gN = aa.az();
                            view.gN.setDuration(600);
                            u uVar = view.gN;
                            if (i4 > view.gL) {
                                interpolator = a.et;
                            } else {
                                interpolator = a.eu;
                            }
                            uVar.setInterpolator(interpolator);
                            view.gN.a(new c(view) {
                                final /* synthetic */ CollapsingToolbarLayout gQ;

                                {
                                    this.gQ = r1;
                                }

                                public final void a(u uVar) {
                                    this.gQ.r(uVar.lk.aA());
                                }
                            });
                        } else if (view.gN.lk.isRunning()) {
                            view.gN.lk.cancel();
                        }
                        view.gN.e(view.gL, i4);
                        view.gN.lk.start();
                    } else {
                        if (!z) {
                            i2 = 0;
                        }
                        view.r(i2);
                    }
                    view.gM = z;
                }
            }
            if (this.gQ.gK != null && systemWindowInsetTop > 0) {
                y.E(this.gQ);
            }
            this.gQ.gG.e(((float) Math.abs(i)) / ((float) ((this.gQ.getHeight() - y.T(this.gQ)) - systemWindowInsetTop)));
            if (Math.abs(i) == I) {
                y.g((View) appBarLayout, appBarLayout.eA);
            } else {
                y.g((View) appBarLayout, 0.0f);
            }
        }
    }

    static /* synthetic */ ao a(CollapsingToolbarLayout collapsingToolbarLayout, ao aoVar) {
        if (collapsingToolbarLayout.eC != aoVar) {
            collapsingToolbarLayout.eC = aoVar;
            collapsingToolbarLayout.requestLayout();
        }
        return aoVar.cd();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return T();
    }

    protected /* synthetic */ android.widget.FrameLayout.LayoutParams m3generateDefaultLayoutParams() {
        return T();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable = null;
        super(context, attributeSet, i);
        this.gw = true;
        this.gF = new Rect();
        t.g(context);
        this.gG = new f(this);
        this.gG.a(a.ev);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bu, i, h.aO);
        this.gG.m(obtainStyledAttributes.getInt(i.by, 8388691));
        this.gG.n(obtainStyledAttributes.getInt(i.bv, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.bz, 0);
        this.gE = dimensionPixelSize;
        this.gD = dimensionPixelSize;
        this.gC = dimensionPixelSize;
        this.gB = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(i.bC)) {
            this.gB = obtainStyledAttributes.getDimensionPixelSize(i.bC, 0);
        }
        if (obtainStyledAttributes.hasValue(i.bB)) {
            this.gD = obtainStyledAttributes.getDimensionPixelSize(i.bB, 0);
        }
        if (obtainStyledAttributes.hasValue(i.bD)) {
            this.gC = obtainStyledAttributes.getDimensionPixelSize(i.bD, 0);
        }
        if (obtainStyledAttributes.hasValue(i.bA)) {
            this.gE = obtainStyledAttributes.getDimensionPixelSize(i.bA, 0);
        }
        this.gH = obtainStyledAttributes.getBoolean(i.bH, true);
        this.gG.setText(obtainStyledAttributes.getText(i.bG));
        this.gG.p(h.aK);
        this.gG.o(h.aJ);
        if (obtainStyledAttributes.hasValue(i.bE)) {
            this.gG.p(obtainStyledAttributes.getResourceId(i.bE, 0));
        }
        if (obtainStyledAttributes.hasValue(i.bw)) {
            this.gG.o(obtainStyledAttributes.getResourceId(i.bw, 0));
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(i.bx);
        if (this.gJ != drawable2) {
            if (this.gJ != null) {
                this.gJ.setCallback(null);
            }
            this.gJ = drawable2 != null ? drawable2.mutate() : null;
            if (this.gJ != null) {
                this.gJ.setBounds(0, 0, getWidth(), getHeight());
                this.gJ.setCallback(this);
                this.gJ.setAlpha(this.gL);
            }
            y.E(this);
        }
        drawable2 = obtainStyledAttributes.getDrawable(i.bF);
        if (this.gK != drawable2) {
            if (this.gK != null) {
                this.gK.setCallback(null);
            }
            if (drawable2 != null) {
                drawable = drawable2.mutate();
            }
            this.gK = drawable;
            if (this.gK != null) {
                boolean z;
                if (this.gK.isStateful()) {
                    this.gK.setState(getDrawableState());
                }
                android.support.v4.b.a.a.b(this.gK, y.I(this));
                drawable = this.gK;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable.setVisible(z, false);
                this.gK.setCallback(this);
                this.gK.setAlpha(this.gL);
            }
            y.E(this);
        }
        this.gx = obtainStyledAttributes.getResourceId(i.bI, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        y.b((View) this, new s(this) {
            final /* synthetic */ CollapsingToolbarLayout gQ;

            {
                this.gQ = r1;
            }

            public final ao a(View view, ao aoVar) {
                return CollapsingToolbarLayout.a(this.gQ, aoVar);
            }
        });
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.gO == null) {
                this.gO = new a();
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            android.support.design.widget.AppBarLayout.a aVar = this.gO;
            if (!(aVar == null || appBarLayout.eD.contains(aVar))) {
                appBarLayout.eD.add(aVar);
            }
        }
        y.Y(this);
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.gO != null && (parent instanceof AppBarLayout)) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            android.support.design.widget.AppBarLayout.a aVar = this.gO;
            if (aVar != null) {
                appBarLayout.eD.remove(aVar);
            }
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        S();
        if (this.gy == null && this.gJ != null && this.gL > 0) {
            this.gJ.mutate().setAlpha(this.gL);
            this.gJ.draw(canvas);
        }
        if (this.gH && this.gI) {
            this.gG.draw(canvas);
        }
        if (this.gK != null && this.gL > 0) {
            int systemWindowInsetTop = this.eC != null ? this.eC.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.gK.setBounds(0, -this.gP, getWidth(), systemWindowInsetTop - this.gP);
                this.gK.mutate().setAlpha(this.gL);
                this.gK.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        S();
        if (view == this.gy && this.gJ != null && this.gL > 0) {
            this.gJ.mutate().setAlpha(this.gL);
            this.gJ.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.gJ != null) {
            this.gJ.setBounds(0, 0, i, i2);
        }
    }

    final void S() {
        if (this.gw) {
            View view;
            this.gy = null;
            this.gz = null;
            if (this.gx != -1) {
                this.gy = (Toolbar) findViewById(this.gx);
                if (this.gy != null) {
                    view = this.gy;
                    CollapsingToolbarLayout parent = view.getParent();
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = parent;
                        }
                        parent = parent.getParent();
                    }
                    this.gz = view;
                }
            }
            if (this.gy == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    view = getChildAt(i);
                    if (view instanceof Toolbar) {
                        toolbar = (Toolbar) view;
                        break;
                    }
                }
                toolbar = null;
                this.gy = toolbar;
            }
            if (!(this.gH || this.gA == null)) {
                ViewParent parent2 = this.gA.getParent();
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(this.gA);
                }
            }
            if (this.gH && this.gy != null) {
                if (this.gA == null) {
                    this.gA = new View(getContext());
                }
                if (this.gA.getParent() == null) {
                    this.gy.addView(this.gA, -1, -1);
                }
            }
            this.gw = false;
        }
    }

    protected void onMeasure(int i, int i2) {
        S();
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.gH && this.gA != null) {
            boolean z2 = y.ak(this.gA) && this.gA.getVisibility() == 0;
            this.gI = z2;
            if (this.gI) {
                if (this.gz == null || this.gz == this) {
                    i5 = 0;
                } else {
                    i5 = ((LayoutParams) this.gz.getLayoutParams()).bottomMargin;
                }
                x.a(this, this.gA, this.gF);
                this.gG.b(this.gF.left, (i4 - this.gF.height()) - i5, this.gF.right, i4 - i5);
                if (y.I(this) != 1) {
                    i6 = 0;
                }
                f fVar = this.gG;
                i5 = i6 != 0 ? this.gD : this.gB;
                int i8 = this.gF.bottom + this.gC;
                int i9 = i3 - i;
                if (i6 != 0) {
                    i6 = this.gB;
                } else {
                    i6 = this.gD;
                }
                fVar.a(i5, i8, i9 - i6, (i4 - i2) - this.gE);
                this.gG.Q();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            View childAt = getChildAt(i7);
            if (!(this.eC == null || y.Z(childAt))) {
                int systemWindowInsetTop = this.eC.getSystemWindowInsetTop();
                if (childAt.getTop() < systemWindowInsetTop) {
                    y.i(childAt, systemWindowInsetTop);
                }
            }
            k(childAt).aC();
            i7++;
        }
        if (this.gy != null) {
            if (this.gH && TextUtils.isEmpty(this.gG.mText)) {
                this.gG.setText(this.gy.aee);
            }
            if (this.gz == null || this.gz == this) {
                setMinimumHeight(j(this.gy));
            } else {
                setMinimumHeight(j(this.gz));
            }
        }
    }

    private static int j(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    private static z k(View view) {
        z zVar = (z) view.getTag(e.aw);
        if (zVar != null) {
            return zVar;
        }
        zVar = new z(view);
        view.setTag(e.aw, zVar);
        return zVar;
    }

    final void r(int i) {
        if (i != this.gL) {
            if (!(this.gJ == null || this.gy == null)) {
                y.E(this.gy);
            }
            this.gL = i;
            y.E(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.gK;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        drawable = this.gJ;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.gJ || drawable == this.gK;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.gK == null || this.gK.isVisible() == z)) {
            this.gK.setVisible(z, false);
        }
        if (this.gJ != null && this.gJ.isVisible() != z) {
            this.gJ.setVisible(z, false);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams T() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
