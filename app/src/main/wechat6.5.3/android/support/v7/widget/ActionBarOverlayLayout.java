package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.support.v4.view.al;
import android.support.v4.view.am;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.y;
import android.support.v7.a.a.f;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.FileUtils;

public class ActionBarOverlayLayout extends ViewGroup implements q, t {
    static final int[] wZ = new int[]{android.support.v7.a.a.a.actionBarSize, 16842841};
    private final r Ct;
    private u GR;
    private boolean HG;
    private ah RA;
    private final al RB = new am(this) {
        final /* synthetic */ ActionBarOverlayLayout RE;

        {
            this.RE = r1;
        }

        public final void q(View view) {
            this.RE.RA = null;
            this.RE.Ro = false;
        }

        public final void ar(View view) {
            this.RE.RA = null;
            this.RE.Ro = false;
        }
    };
    private final Runnable RC = new Runnable(this) {
        final /* synthetic */ ActionBarOverlayLayout RE;

        {
            this.RE = r1;
        }

        public final void run() {
            this.RE.dX();
            this.RE.RA = y.U(this.RE.Rj).r(0.0f).a(this.RE.RB);
        }
    };
    private final Runnable RD = new Runnable(this) {
        final /* synthetic */ ActionBarOverlayLayout RE;

        {
            this.RE = r1;
        }

        public final void run() {
            this.RE.dX();
            this.RE.RA = y.U(this.RE.Rj).r((float) (-this.RE.Rj.getHeight())).a(this.RE.RB);
        }
    };
    private int Rg;
    public int Rh = 0;
    private ContentFrameLayout Ri;
    private ActionBarContainer Rj;
    private Drawable Rk;
    private boolean Rl;
    public boolean Rm;
    public boolean Rn;
    private boolean Ro;
    private int Rp;
    public int Rq;
    private final Rect Rr = new Rect();
    private final Rect Rs = new Rect();
    private final Rect Rt = new Rect();
    private final Rect Ru = new Rect();
    private final Rect Rv = new Rect();
    private final Rect Rw = new Rect();
    public a Rx;
    private final int Ry = 600;
    private android.support.v4.widget.q Rz;

    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface a {
        void A(boolean z);

        void df();

        void dg();

        void dh();

        void onWindowVisibilityChanged(int i);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
        this.Ct = new r(this);
    }

    private void init(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(wZ);
        this.Rg = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.Rk = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.Rk == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.Rl = z;
        this.Rz = android.support.v4.widget.q.a(context, null);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dX();
    }

    public static void dU() {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        init(getContext());
        y.Y(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        dV();
        int i2 = this.Rq ^ i;
        this.Rq = i;
        boolean z3 = (i & 4) == 0;
        if ((i & FileUtils.S_IRUSR) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Rx != null) {
            a aVar = this.Rx;
            if (z) {
                z2 = false;
            }
            aVar.A(z2);
            if (z3 || !z) {
                this.Rx.df();
            } else {
                this.Rx.dg();
            }
        }
        if ((i2 & FileUtils.S_IRUSR) != 0 && this.Rx != null) {
            y.Y(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.Rh = i;
        if (this.Rx != null) {
            this.Rx.onWindowVisibilityChanged(i);
        }
    }

    private static boolean a(View view, Rect rect, boolean z) {
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        dV();
        y.X(this);
        boolean a = a(this.Rj, rect, false);
        this.Ru.set(rect);
        as.a(this, this.Ru, this.Rr);
        if (!this.Rs.equals(this.Rr)) {
            this.Rs.set(this.Rr);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        dV();
        measureChildWithMargins(this.Rj, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.Rj.getLayoutParams();
        int max = Math.max(0, (this.Rj.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.Rj.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = as.combineMeasuredStates(0, y.M(this.Rj));
        boolean z = (y.X(this) & FileUtils.S_IRUSR) != 0;
        if (z) {
            i3 = this.Rg;
            if (this.Rn && this.Rj.QP != null) {
                i3 += this.Rg;
            }
        } else {
            i3 = this.Rj.getVisibility() != 8 ? this.Rj.getMeasuredHeight() : 0;
        }
        this.Rt.set(this.Rr);
        this.Rv.set(this.Ru);
        Rect rect;
        Rect rect2;
        if (this.Rm || z) {
            rect = this.Rv;
            rect.top = i3 + rect.top;
            rect2 = this.Rv;
            rect2.bottom += 0;
        } else {
            rect = this.Rt;
            rect.top = i3 + rect.top;
            rect2 = this.Rt;
            rect2.bottom += 0;
        }
        a(this.Ri, this.Rt, true);
        if (!this.Rw.equals(this.Rv)) {
            this.Rw.set(this.Rv);
            this.Ri.e(this.Rv);
        }
        measureChildWithMargins(this.Ri, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.Ri.getLayoutParams();
        int max3 = Math.max(max, (this.Ri.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i3 = Math.max(max2, layoutParams.bottomMargin + (this.Ri.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates2 = as.combineMeasuredStates(combineMeasuredStates, y.M(this.Ri));
        setMeasuredDimension(y.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), y.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.Rk != null && !this.Rl) {
            int bottom = this.Rj.getVisibility() == 0 ? (int) ((((float) this.Rj.getBottom()) + y.R(this.Rj)) + 0.5f) : 0;
            this.Rk.setBounds(0, bottom, getWidth(), this.Rk.getIntrinsicHeight() + bottom);
            this.Rk.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.Rj.getVisibility() != 0) {
            return false;
        }
        return this.HG;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.Ct.ww = i;
        this.Rp = dW();
        dX();
        if (this.Rx != null) {
            this.Rx.dh();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.Rp += i2;
        ax(this.Rp);
    }

    public void onStopNestedScroll(View view) {
        if (this.HG && !this.Ro) {
            if (this.Rp <= this.Rj.getHeight()) {
                dX();
                postDelayed(this.RC, 600);
                return;
            }
            dX();
            postDelayed(this.RD, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.HG || !z) {
            return false;
        }
        this.Rz.a(0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.Rz.getFinalY() > this.Rj.getHeight()) {
            z2 = true;
        }
        if (z2) {
            dX();
            this.RD.run();
        } else {
            dX();
            this.RC.run();
        }
        this.Ro = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.Ct.ww;
    }

    private void dV() {
        if (this.Ri == null) {
            u uVar;
            this.Ri = (ContentFrameLayout) findViewById(f.IV);
            this.Rj = (ActionBarContainer) findViewById(f.IW);
            View findViewById = findViewById(f.IU);
            if (findViewById instanceof u) {
                uVar = (u) findViewById;
            } else if (findViewById instanceof Toolbar) {
                uVar = ((Toolbar) findViewById).hb();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of " + findViewById.getClass().getSimpleName());
            }
            this.GR = uVar;
        }
    }

    public final void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.HG) {
            this.HG = z;
            if (!z) {
                dX();
                ax(0);
            }
        }
    }

    public final int dW() {
        return this.Rj != null ? -((int) y.R(this.Rj)) : 0;
    }

    private void ax(int i) {
        dX();
        y.c(this.Rj, (float) (-Math.max(0, Math.min(i, this.Rj.getHeight()))));
    }

    private void dX() {
        removeCallbacks(this.RC);
        removeCallbacks(this.RD);
        if (this.RA != null) {
            this.RA.cancel();
        }
    }

    public final void b(Callback callback) {
        dV();
        this.GR.b(callback);
    }

    public final void e(CharSequence charSequence) {
        dV();
        this.GR.e(charSequence);
    }

    public final void ay(int i) {
        boolean z = true;
        dV();
        switch (i) {
            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                this.Rm = true;
                if (getContext().getApplicationInfo().targetSdkVersion >= 19) {
                    z = false;
                }
                this.Rl = z;
                return;
            default:
                return;
        }
    }

    public final boolean dY() {
        dV();
        return this.GR.dY();
    }

    public final boolean isOverflowMenuShowing() {
        dV();
        return this.GR.isOverflowMenuShowing();
    }

    public final boolean dZ() {
        dV();
        return this.GR.dZ();
    }

    public final boolean showOverflowMenu() {
        dV();
        return this.GR.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        dV();
        return this.GR.hideOverflowMenu();
    }

    public final void ea() {
        dV();
        this.GR.ea();
    }

    public final void a(Menu menu, android.support.v7.view.menu.l.a aVar) {
        dV();
        this.GR.a(menu, aVar);
    }

    public final void eb() {
        dV();
        this.GR.dismissPopupMenus();
    }
}
