package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.h;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.y;
import android.support.v7.widget.i;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.List;

@android.support.design.widget.CoordinatorLayout.b(a.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private ColorStateList hK;
    private Mode hL;
    private int hM;
    private int hN;
    private int hO;
    private int hP;
    private boolean hQ;
    private final Rect hR;
    private i hS;
    private l hT;

    public static class a extends Behavior<FloatingActionButton> {
        private static final boolean hU = (VERSION.SDK_INT >= 11);
        private Rect gF;
        private u hV;
        private float hW;

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            int i3 = 0;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List n = coordinatorLayout.n(floatingActionButton);
            int size = n.size();
            for (i2 = 0; i2 < size; i2++) {
                View view2 = (View) n.get(i2);
                if ((view2 instanceof AppBarLayout) && a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.d(floatingActionButton, i);
            Rect c = floatingActionButton.hR;
            if (c != null && c.centerX() > 0 && c.centerY() > 0) {
                d dVar = (d) floatingActionButton.getLayoutParams();
                i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin ? c.right : floatingActionButton.getLeft() <= dVar.leftMargin ? -c.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - dVar.bottomMargin) {
                    i3 = c.bottom;
                } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                    i3 = -c.top;
                }
                floatingActionButton.offsetTopAndBottom(i3);
                floatingActionButton.offsetLeftAndRight(i2);
            }
            return true;
        }

        public final /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            final FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof SnackbarLayout) {
                float min;
                float f = 0.0f;
                List n = coordinatorLayout.n(floatingActionButton);
                int size = n.size();
                int i = 0;
                while (i < size) {
                    View view3 = (View) n.get(i);
                    if (view3 instanceof SnackbarLayout) {
                        boolean z;
                        if (floatingActionButton.getVisibility() == 0 && view3.getVisibility() == 0) {
                            Rect rect = coordinatorLayout.hc;
                            coordinatorLayout.a((View) floatingActionButton, floatingActionButton.getParent() != coordinatorLayout, rect);
                            Rect rect2 = coordinatorLayout.hd;
                            coordinatorLayout.a(view3, view3.getParent() != coordinatorLayout, rect2);
                            z = rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
                        } else {
                            z = false;
                        }
                        if (z) {
                            min = Math.min(f, y.R(view3) - ((float) view3.getHeight()));
                            i++;
                            f = min;
                        }
                    }
                    min = f;
                    i++;
                    f = min;
                }
                if (this.hW != f) {
                    min = y.R(floatingActionButton);
                    if (this.hV != null && this.hV.lk.isRunning()) {
                        this.hV.lk.cancel();
                    }
                    if (!floatingActionButton.isShown() || Math.abs(min - f) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                        y.c(floatingActionButton, f);
                    } else {
                        if (this.hV == null) {
                            this.hV = aa.az();
                            this.hV.setInterpolator(a.es);
                            this.hV.a(new c(this) {
                                final /* synthetic */ a hY;

                                public final void a(u uVar) {
                                    y.c(floatingActionButton, uVar.lk.aB());
                                }
                            });
                        }
                        this.hV.e(min, f);
                        this.hV.lk.start();
                    }
                    this.hW = f;
                }
            } else if (view2 instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            }
            return false;
        }

        public final /* bridge */ /* synthetic */ boolean e(View view) {
            return hU && (view instanceof SnackbarLayout);
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            if (((d) floatingActionButton.getLayoutParams()).hx != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.lO != 0) {
                return false;
            }
            if (this.gF == null) {
                this.gF = new Rect();
            }
            Rect rect = this.gF;
            x.a(coordinatorLayout, appBarLayout, rect);
            int i2 = rect.bottom;
            int J = appBarLayout.J();
            int T = y.T(appBarLayout);
            if (T != 0) {
                i = (T * 2) + J;
            } else {
                T = appBarLayout.getChildCount();
                if (T > 0) {
                    i = (y.T(appBarLayout.getChildAt(T - 1)) * 2) + J;
                }
            }
            if (i2 <= i) {
                floatingActionButton.X().a(null, false);
            } else {
                floatingActionButton.X().b(null, false);
            }
            return true;
        }
    }

    private class b implements p {
        final /* synthetic */ FloatingActionButton hZ;

        private b(FloatingActionButton floatingActionButton) {
            this.hZ = floatingActionButton;
        }

        public final float Y() {
            return ((float) this.hZ.W()) / 2.0f;
        }

        public final void c(int i, int i2, int i3, int i4) {
            this.hZ.hR.set(i, i2, i3, i4);
            this.hZ.setPadding(this.hZ.hP + i, this.hZ.hP + i2, this.hZ.hP + i3, this.hZ.hP + i4);
        }

        public final void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public final boolean Z() {
            return this.hZ.hQ;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        Mode mode;
        super(context, attributeSet, i);
        this.hR = new Rect();
        t.g(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.bV, i, h.aQ);
        this.hK = obtainStyledAttributes.getColorStateList(android.support.design.a.i.bW);
        switch (obtainStyledAttributes.getInt(android.support.design.a.i.bX, -1)) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            default:
                mode = null;
                break;
        }
        this.hL = mode;
        this.hN = obtainStyledAttributes.getColor(android.support.design.a.i.cc, 0);
        this.hO = obtainStyledAttributes.getInt(android.support.design.a.i.ca, 0);
        this.hM = obtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.bY, 0);
        float dimension = obtainStyledAttributes.getDimension(android.support.design.a.i.bZ, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(android.support.design.a.i.cb, 0.0f);
        this.hQ = obtainStyledAttributes.getBoolean(android.support.design.a.i.cd, false);
        obtainStyledAttributes.recycle();
        this.hS = new i(this, android.support.v7.widget.h.eD());
        this.hS.a(attributeSet, i);
        this.hP = (W() - ((int) getResources().getDimension(android.support.design.a.d.ag))) / 2;
        X().a(this.hK, this.hL, this.hN, this.hM);
        l X = X();
        if (X.ir != dimension) {
            X.ir = dimension;
            X.i(dimension);
        }
        l X2 = X();
        if (X2.is != dimension2) {
            X2.is = dimension2;
            X2.j(dimension2);
        }
        X().ae();
    }

    protected void onMeasure(int i, int i2) {
        int W = W();
        W = Math.min(resolveAdjustedSize(W, i), resolveAdjustedSize(W, i2));
        setMeasuredDimension((this.hR.left + W) + this.hR.right, (W + this.hR.top) + this.hR.bottom);
    }

    public ColorStateList getBackgroundTintList() {
        return this.hK;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.hK != colorStateList) {
            this.hK = colorStateList;
            X().setBackgroundTintList(colorStateList);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.hL;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.hL != mode) {
            this.hL = mode;
            X().setBackgroundTintMode(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundColor(int i) {
    }

    public void setImageResource(int i) {
        this.hS.setImageResource(i);
    }

    final int W() {
        switch (this.hO) {
            case 1:
                return getResources().getDimensionPixelSize(android.support.design.a.d.ah);
            default:
                return getResources().getDimensionPixelSize(android.support.design.a.d.aj);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l X = X();
        if (X.ac()) {
            if (X.iw == null) {
                X.iw = new OnPreDrawListener(X) {
                    final /* synthetic */ l ix;

                    {
                        this.ix = r1;
                    }

                    public final boolean onPreDraw() {
                        this.ix.ad();
                        return true;
                    }
                };
            }
            X.iu.getViewTreeObserver().addOnPreDrawListener(X.iw);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l X = X();
        if (X.iw != null) {
            X.iu.getViewTreeObserver().removeOnPreDrawListener(X.iw);
            X.iw = null;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        X().b(getDrawableState());
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        X().aa();
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private l X() {
        if (this.hT == null) {
            int i = VERSION.SDK_INT;
            l mVar = i >= 21 ? new m(this, new b()) : i >= 14 ? new k(this, new b()) : new j(this, new b());
            this.hT = mVar;
        }
        return this.hT;
    }
}
