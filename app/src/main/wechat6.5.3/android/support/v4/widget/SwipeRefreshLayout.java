package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements o, q {
    private static final String De = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] xv = new int[]{16842766};
    private Animation DA;
    private Animation DB;
    private Animation DC;
    private Animation DD;
    private float DE;
    private boolean DF;
    private int DG;
    private int DH;
    private boolean DI;
    private AnimationListener DJ = new AnimationListener(this) {
        final /* synthetic */ SwipeRefreshLayout DM;

        {
            this.DM = r1;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.DM.Dg) {
                this.DM.Dz.setAlpha(255);
                this.DM.Dz.start();
                if (this.DM.DF && this.DM.Df != null) {
                    this.DM.Df;
                }
                this.DM.Do = this.DM.Du.getTop();
                return;
            }
            this.DM.reset();
        }
    };
    private final Animation DK = new Animation(this) {
        final /* synthetic */ SwipeRefreshLayout DM;

        {
            this.DM = r1;
        }

        public final void applyTransformation(float f, Transformation transformation) {
            int j;
            if (this.DM.DI) {
                j = (int) this.DM.DE;
            } else {
                j = (int) (this.DM.DE - ((float) Math.abs(this.DM.Dy)));
            }
            this.DM.l((((int) (((float) (j - this.DM.Dw)) * f)) + this.DM.Dw) - this.DM.Du.getTop(), false);
            this.DM.Dz.u(1.0f - f);
        }
    };
    private final Animation DL = new Animation(this) {
        final /* synthetic */ SwipeRefreshLayout DM;

        {
            this.DM = r1;
        }

        public final void applyTransformation(float f, Transformation transformation) {
            this.DM.l((this.DM.Dw + ((int) (((float) (this.DM.Dy - this.DM.Dw)) * f))) - this.DM.Du.getTop(), false);
        }
    };
    private a Df;
    private boolean Dg = false;
    private float Dh = -1.0f;
    private float Di;
    private final p Dj;
    private final int[] Dk = new int[2];
    private final int[] Dl = new int[2];
    private boolean Dm;
    private int Dn;
    private int Do;
    private boolean Dp = false;
    private float Dq;
    private boolean Dr;
    private boolean Ds;
    private final DecelerateInterpolator Dt;
    private b Du;
    private int Dv = -1;
    protected int Dw;
    private float Dx;
    protected int Dy;
    private l Dz;
    private int fk = -1;
    private final r hr;
    private boolean iB;
    private int iD;
    private float wM;
    private View zI;

    public interface a {
    }

    private void reset() {
        this.Du.clearAnimation();
        this.Dz.stop();
        this.Du.setVisibility(8);
        al(255);
        if (this.Dr) {
            A(0.0f);
        } else {
            l(this.Dy - this.Do, true);
        }
        this.Do = this.Du.getTop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void al(int i) {
        this.Du.getBackground().setAlpha(i);
        this.Dz.setAlpha(i);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iD = ViewConfiguration.get(context).getScaledTouchSlop();
        this.Dn = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.Dt = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xv);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.DG = (int) (displayMetrics.density * 40.0f);
        this.DH = (int) (displayMetrics.density * 40.0f);
        this.Du = new b(getContext());
        this.Dz = new l(getContext(), this);
        this.Dz.BD.Ce = -328966;
        this.Du.setImageDrawable(this.Dz);
        this.Du.setVisibility(8);
        addView(this.Du);
        y.a(this);
        this.DE = displayMetrics.density * 64.0f;
        this.Dh = this.DE;
        this.hr = new r(this);
        this.Dj = new p(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.Dv < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.Dv;
        }
        if (i2 >= this.Dv) {
            return i2 + 1;
        }
        return i2;
    }

    private static boolean cI() {
        return VERSION.SDK_INT < 11;
    }

    private void A(float f) {
        if (cI()) {
            al((int) (255.0f * f));
            return;
        }
        y.e(this.Du, f);
        y.f(this.Du, f);
    }

    private void a(AnimationListener animationListener) {
        this.DA = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout DM;

            {
                this.DM = r1;
            }

            public final void applyTransformation(float f, Transformation transformation) {
                this.DM.A(1.0f - f);
            }
        };
        this.DA.setDuration(150);
        this.Du.Ai = animationListener;
        this.Du.clearAnimation();
        this.Du.startAnimation(this.DA);
    }

    private Animation o(final int i, final int i2) {
        if (this.Dr && cI()) {
            return null;
        }
        Animation anonymousClass3 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout DM;

            public final void applyTransformation(float f, Transformation transformation) {
                this.DM.Dz.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        anonymousClass3.setDuration(300);
        this.Du.Ai = null;
        this.Du.clearAnimation();
        this.Du.startAnimation(anonymousClass3);
        return anonymousClass3;
    }

    private void cJ() {
        if (this.zI == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.Du)) {
                    i++;
                } else {
                    this.zI = childAt;
                    return;
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.zI == null) {
                cJ();
            }
            if (this.zI != null) {
                View view = this.zI;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.Du.getMeasuredWidth();
                this.Du.layout((measuredWidth / 2) - (measuredHeight / 2), this.Do, (measuredWidth / 2) + (measuredHeight / 2), this.Do + this.Du.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.zI == null) {
            cJ();
        }
        if (this.zI != null) {
            int i3;
            this.zI.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.Du.measure(MeasureSpec.makeMeasureSpec(this.DG, 1073741824), MeasureSpec.makeMeasureSpec(this.DH, 1073741824));
            if (!(this.DI || this.Dp)) {
                this.Dp = true;
                i3 = -this.Du.getMeasuredHeight();
                this.Dy = i3;
                this.Do = i3;
            }
            this.Dv = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.Du) {
                    this.Dv = i3;
                    return;
                }
            }
        }
    }

    private boolean cK() {
        if (VERSION.SDK_INT >= 14) {
            return y.g(this.zI, -1);
        }
        if (!(this.zI instanceof AbsListView)) {
            return y.g(this.zI, -1) || this.zI.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.zI;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        cJ();
        int d = n.d(motionEvent);
        if (this.Ds && d == 0) {
            this.Ds = false;
        }
        if (!isEnabled() || this.Ds || cK() || this.Dg || this.Dm) {
            return false;
        }
        float g;
        switch (d) {
            case 0:
                l(this.Dy - this.Du.getTop(), true);
                this.fk = n.c(motionEvent, 0);
                this.iB = false;
                g = g(motionEvent, this.fk);
                if (g != -1.0f) {
                    this.Dq = g;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.iB = false;
                this.fk = -1;
                break;
            case 2:
                if (this.fk == -1) {
                    return false;
                }
                g = g(motionEvent, this.fk);
                if (g != -1.0f) {
                    if (g - this.Dq > ((float) this.iD) && !this.iB) {
                        this.wM = this.Dq + ((float) this.iD);
                        this.iB = true;
                        this.Dz.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                h(motionEvent);
                break;
        }
        return this.iB;
    }

    private static float g(MotionEvent motionEvent, int i) {
        int b = n.b(motionEvent, i);
        if (b < 0) {
            return -1.0f;
        }
        return n.e(motionEvent, b);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.zI instanceof AbsListView)) {
            return;
        }
        if (this.zI == null || y.ag(this.zI)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.Ds || this.Dg || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.hr.ww = i;
        startNestedScroll(i & 2);
        this.Di = 0.0f;
        this.Dm = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.Di > 0.0f) {
            if (((float) i2) > this.Di) {
                iArr[1] = i2 - ((int) this.Di);
                this.Di = 0.0f;
            } else {
                this.Di -= (float) i2;
                iArr[1] = i2;
            }
            B(this.Di);
        }
        if (this.DI && i2 > 0 && this.Di == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.Du.setVisibility(8);
        }
        int[] iArr2 = this.Dk;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.hr.ww;
    }

    public void onStopNestedScroll(View view) {
        this.hr.ww = 0;
        this.Dm = false;
        if (this.Di > 0.0f) {
            C(this.Di);
            this.Di = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.Dl);
        int i5 = this.Dl[1] + i4;
        if (i5 < 0 && !cK()) {
            this.Di = ((float) Math.abs(i5)) + this.Di;
            B(this.Di);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.Dj.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.Dj.wt;
    }

    public boolean startNestedScroll(int i) {
        return this.Dj.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.Dj.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.Dj.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.Dj.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.Dj.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.Dj.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.Dj.dispatchNestedPreFling(f, f2);
    }

    private static boolean d(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void B(float f) {
        this.Dz.u(true);
        float min = Math.min(1.0f, Math.abs(f / this.Dh));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.Dh;
        float f2 = this.DI ? this.DE - ((float) this.Dy) : this.DE;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.Dy;
        if (this.Du.getVisibility() != 0) {
            this.Du.setVisibility(0);
        }
        if (!this.Dr) {
            y.e(this.Du, 1.0f);
            y.f(this.Du, 1.0f);
        }
        if (this.Dr) {
            A(Math.min(1.0f, f / this.Dh));
        }
        if (f < this.Dh) {
            if (this.Dz.getAlpha() > 76 && !d(this.DB)) {
                this.DB = o(this.Dz.getAlpha(), 76);
            }
        } else if (this.Dz.getAlpha() < 255 && !d(this.DC)) {
            this.DC = o(this.Dz.getAlpha(), 255);
        }
        this.Dz.v(Math.min(0.8f, max * 0.8f));
        this.Dz.u(Math.min(1.0f, max));
        this.Dz.BD.setRotation(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        l(i - this.Do, true);
    }

    private void C(float f) {
        if (f <= this.Dh) {
            this.Dg = false;
            this.Dz.v(0.0f);
            AnimationListener animationListener = null;
            if (!this.Dr) {
                animationListener = new AnimationListener(this) {
                    final /* synthetic */ SwipeRefreshLayout DM;

                    {
                        this.DM = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (!this.DM.Dr) {
                            this.DM.a(null);
                        }
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                };
            }
            int i = this.Do;
            if (this.Dr) {
                this.Dw = i;
                if (cI()) {
                    this.Dx = (float) this.Dz.getAlpha();
                } else {
                    this.Dx = y.V(this.Du);
                }
                this.DD = new Animation(this) {
                    final /* synthetic */ SwipeRefreshLayout DM;

                    {
                        this.DM = r1;
                    }

                    public final void applyTransformation(float f, Transformation transformation) {
                        this.DM.A(this.DM.Dx + ((-this.DM.Dx) * f));
                        this.DM.l((this.DM.Dw + ((int) (((float) (this.DM.Dy - this.DM.Dw)) * f))) - this.DM.Du.getTop(), false);
                    }
                };
                this.DD.setDuration(150);
                if (animationListener != null) {
                    this.Du.Ai = animationListener;
                }
                this.Du.clearAnimation();
                this.Du.startAnimation(this.DD);
            } else {
                this.Dw = i;
                this.DL.reset();
                this.DL.setDuration(200);
                this.DL.setInterpolator(this.Dt);
                if (animationListener != null) {
                    this.Du.Ai = animationListener;
                }
                this.Du.clearAnimation();
                this.Du.startAnimation(this.DL);
            }
            this.Dz.u(false);
        } else if (!this.Dg) {
            this.DF = true;
            cJ();
            this.Dg = true;
            if (this.Dg) {
                int i2 = this.Do;
                AnimationListener animationListener2 = this.DJ;
                this.Dw = i2;
                this.DK.reset();
                this.DK.setDuration(200);
                this.DK.setInterpolator(this.Dt);
                if (animationListener2 != null) {
                    this.Du.Ai = animationListener2;
                }
                this.Du.clearAnimation();
                this.Du.startAnimation(this.DK);
                return;
            }
            a(this.DJ);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = n.d(motionEvent);
        if (this.Ds && d == 0) {
            this.Ds = false;
        }
        if (!isEnabled() || this.Ds || cK() || this.Dm) {
            return false;
        }
        float e;
        switch (d) {
            case 0:
                this.fk = n.c(motionEvent, 0);
                this.iB = false;
                break;
            case 1:
                d = n.b(motionEvent, this.fk);
                if (d < 0) {
                    return false;
                }
                e = (n.e(motionEvent, d) - this.wM) * 0.5f;
                this.iB = false;
                C(e);
                this.fk = -1;
                return false;
            case 2:
                d = n.b(motionEvent, this.fk);
                if (d < 0) {
                    return false;
                }
                e = (n.e(motionEvent, d) - this.wM) * 0.5f;
                if (this.iB) {
                    if (e > 0.0f) {
                        B(e);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                d = n.e(motionEvent);
                if (d >= 0) {
                    this.fk = n.c(motionEvent, d);
                    break;
                }
                return false;
            case 6:
                h(motionEvent);
                break;
        }
        return true;
    }

    private void l(int i, boolean z) {
        this.Du.bringToFront();
        this.Du.offsetTopAndBottom(i);
        this.Do = this.Du.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void h(MotionEvent motionEvent) {
        int e = n.e(motionEvent);
        if (n.c(motionEvent, e) == this.fk) {
            this.fk = n.c(motionEvent, e == 0 ? 1 : 0);
        }
    }
}
