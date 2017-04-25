package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.b;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.os.c;
import android.support.v4.view.ao;
import android.support.v4.view.s;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@b(Behavior.class)
public class AppBarLayout extends LinearLayout {
    float eA;
    private int eB = 0;
    private ao eC;
    final List<a> eD;
    private int ew = -1;
    private int ex = -1;
    private int ey = -1;
    boolean ez;

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        int eU = 1;
        Interpolator eV;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bd);
            this.eU = obtainStyledAttributes.getInt(i.be, 0);
            if (obtainStyledAttributes.hasValue(i.bf)) {
                this.eV = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i.bf, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface a {
        void a(AppBarLayout appBarLayout, int i);
    }

    public static class Behavior extends HeaderBehavior<AppBarLayout> {
        private int eF;
        private boolean eG;
        private boolean eH;
        private u eI;
        private int eJ = -1;
        private boolean eK;
        private float eL;
        private WeakReference<View> eM;
        private a eN;

        protected static class SavedState extends BaseSavedState {
            public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new c<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            int eR;
            float eS;
            boolean eT;

            public SavedState(Parcel parcel) {
                super(parcel);
                this.eR = parcel.readInt();
                this.eS = parcel.readFloat();
                this.eT = parcel.readByte() != (byte) 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.eR);
                parcel.writeFloat(this.eS);
                parcel.writeByte((byte) (this.eT ? 1 : 0));
            }
        }

        public static abstract class a {
            public abstract boolean M();
        }

        public final /* bridge */ /* synthetic */ int L() {
            return super.L();
        }

        final /* synthetic */ int a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            view = (AppBarLayout) view;
            int K = K();
            if (i2 == 0 || K < i2 || K > i3) {
                this.eF = 0;
                return 0;
            }
            int a = n.a(i, i2, i3);
            if (K == a) {
                return 0;
            }
            int abs;
            int i4;
            int height;
            if (view.ez) {
                abs = Math.abs(a);
                int childCount = view.getChildCount();
                i4 = 0;
                while (i4 < childCount) {
                    View childAt = view.getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Interpolator interpolator = layoutParams.eV;
                    if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                        i4++;
                    } else {
                        if (interpolator != null) {
                            i4 = layoutParams.eU;
                            if ((i4 & 1) != 0) {
                                height = (layoutParams.bottomMargin + (childAt.getHeight() + layoutParams.topMargin)) + 0;
                                if ((i4 & 2) != 0) {
                                    height -= y.T(childAt);
                                }
                            } else {
                                height = 0;
                            }
                            if (y.Z(childAt)) {
                                height -= view.J();
                            }
                            if (height > 0) {
                                i4 = abs - childAt.getTop();
                                height = Math.round(interpolator.getInterpolation(((float) i4) / ((float) height)) * ((float) height));
                                height = (height + childAt.getTop()) * Integer.signum(a);
                            }
                        }
                        height = a;
                    }
                }
                height = a;
            } else {
                height = a;
            }
            boolean f = super.f(height);
            i4 = K - a;
            this.eF = a - height;
            if (!f && view.ez) {
                abs = coordinatorLayout.gZ.size();
                K = 0;
                a = 0;
                while (K < abs) {
                    View view2 = (View) coordinatorLayout.gZ.get(K);
                    if (view2 == view) {
                        height = 1;
                    } else {
                        if (a != 0) {
                            d dVar = (d) view2.getLayoutParams();
                            android.support.design.widget.CoordinatorLayout.Behavior behavior = dVar.ht;
                            if (behavior != null && dVar.c(coordinatorLayout, view2, view)) {
                                behavior.b(coordinatorLayout, view2, view);
                            }
                        }
                        height = a;
                    }
                    K++;
                    a = height;
                }
            }
            j(view);
            return i4;
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, (View) appBarLayout, savedState.getSuperState());
                this.eJ = savedState.eR;
                this.eL = savedState.eS;
                this.eK = savedState.eT;
                return;
            }
            super.a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.eJ = -1;
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!this.eH) {
                a(coordinatorLayout, appBarLayout);
            }
            this.eG = false;
            this.eH = false;
            this.eM = new WeakReference(view2);
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i != 0 && !this.eG) {
                int i2;
                int b;
                if (i < 0) {
                    i2 = -appBarLayout.I();
                    b = i2 + AppBarLayout.b(appBarLayout);
                } else {
                    i2 = -appBarLayout.I();
                    b = 0;
                }
                iArr[1] = b(coordinatorLayout, appBarLayout, i, i2, b);
            }
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, float f, boolean z) {
            boolean z2 = true;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (z) {
                int b;
                if (f < 0.0f) {
                    b = (-appBarLayout.I()) + AppBarLayout.b(appBarLayout);
                    if (K() < b) {
                        a(coordinatorLayout, appBarLayout, b);
                    }
                } else {
                    b = -appBarLayout.I();
                    if (K() > b) {
                        a(coordinatorLayout, appBarLayout, b);
                    }
                }
                z2 = false;
            } else {
                z2 = a(coordinatorLayout, appBarLayout, -appBarLayout.I(), -f);
            }
            this.eH = z2;
            return z2;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean a = super.a(coordinatorLayout, appBarLayout, i);
            int e = appBarLayout.eB;
            if (e != 0) {
                int i2 = (e & 4) != 0 ? 1 : 0;
                if ((e & 2) != 0) {
                    e = -appBarLayout.I();
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, e);
                    } else {
                        c(coordinatorLayout, appBarLayout, e);
                    }
                } else if ((e & 1) != 0) {
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, 0);
                    } else {
                        c(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.eJ >= 0) {
                View childAt = appBarLayout.getChildAt(this.eJ);
                e = -childAt.getBottom();
                super.f(this.eK ? y.T(childAt) + e : Math.round(((float) childAt.getHeight()) * this.eL) + e);
            }
            appBarLayout.eB = 0;
            this.eJ = -1;
            super.f(n.a(super.L(), -appBarLayout.I(), 0));
            j(appBarLayout);
            return a;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            View view2 = (AppBarLayout) view;
            if (((d) view2.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, view2, i, i2, i3, i4);
            }
            coordinatorLayout.a(view2, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && AppBarLayout.a(appBarLayout) && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight();
            if (z && this.eI != null) {
                this.eI.lk.cancel();
            }
            this.eM = null;
            return z;
        }

        final /* synthetic */ int b(View view) {
            return ((AppBarLayout) view).I();
        }

        public final /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = false;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable b = super.b(coordinatorLayout, appBarLayout);
            int L = super.L();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + L;
                if (childAt.getTop() + L > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.eR = i;
                    if (bottom == y.T(childAt)) {
                        z = true;
                    }
                    savedState.eT = z;
                    savedState.eS = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        public final /* synthetic */ void b(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i < 0) {
                b(coordinatorLayout, appBarLayout, i, -AppBarLayout.d(appBarLayout), 0);
                this.eG = true;
                return;
            }
            this.eG = false;
        }

        final /* synthetic */ int c(View view) {
            return -AppBarLayout.d((AppBarLayout) view);
        }

        final /* synthetic */ boolean d(View view) {
            if (this.eN != null) {
                return this.eN.M();
            }
            if (this.eM != null) {
                View view2 = (View) this.eM.get();
                if (view2 == null || !view2.isShown() || y.g(view2, -1)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ boolean f(int i) {
            return super.f(i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private void a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
            int K = K();
            if (K != i) {
                if (this.eI == null) {
                    this.eI = aa.az();
                    this.eI.setInterpolator(a.ev);
                    this.eI.a(new c(this) {
                        final /* synthetic */ Behavior eQ;

                        public final void a(u uVar) {
                            this.eQ.c(coordinatorLayout, appBarLayout, uVar.lk.aA());
                        }
                    });
                } else {
                    this.eI.lk.cancel();
                }
                this.eI.setDuration(Math.round(((((float) Math.abs(K - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.eI.e(K, i);
                this.eI.lk.start();
            } else if (this.eI != null && this.eI.lk.isRunning()) {
                this.eI.lk.cancel();
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int i;
            View view;
            int K = K();
            int childCount = appBarLayout.getChildCount();
            for (i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                if (childAt.getTop() <= (-K) && childAt.getBottom() >= (-K)) {
                    view = childAt;
                    break;
                }
            }
            view = null;
            if (view != null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.eU & 17) == 17) {
                    int T;
                    childCount = -view.getTop();
                    i = -view.getBottom();
                    if ((layoutParams.eU & 2) == 2) {
                        T = y.T(view) + i;
                    } else {
                        T = i;
                    }
                    if (K >= (T + childCount) / 2) {
                        T = childCount;
                    }
                    a(coordinatorLayout, appBarLayout, n.a(T, -appBarLayout.I(), 0));
                }
            }
        }

        private void j(AppBarLayout appBarLayout) {
            List h = appBarLayout.eD;
            int size = h.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) h.get(i);
                if (aVar != null) {
                    aVar.a(appBarLayout, super.L());
                }
            }
        }

        final int K() {
            return super.L() + this.eF;
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public final /* bridge */ /* synthetic */ int L() {
            return super.L();
        }

        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, view, i);
        }

        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cE);
            this.iI = obtainStyledAttributes.getDimensionPixelSize(i.cF, 0);
            obtainStyledAttributes.recycle();
        }

        public final boolean e(View view) {
            return view instanceof AppBarLayout;
        }

        public final boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            android.support.design.widget.CoordinatorLayout.Behavior behavior = ((d) view2.getLayoutParams()).ht;
            if (behavior instanceof Behavior) {
                int bottom = view2.getBottom() - view.getTop();
                y.i(view, ((((Behavior) behavior).eF + bottom) + this.iH) - o(view2));
            }
            return false;
        }

        final float f(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int I = appBarLayout.I();
                int b = AppBarLayout.b(appBarLayout);
                android.support.design.widget.CoordinatorLayout.Behavior behavior = ((d) appBarLayout.getLayoutParams()).ht;
                int K = behavior instanceof Behavior ? ((Behavior) behavior).K() : 0;
                if (b != 0 && I + K <= b) {
                    return 0.0f;
                }
                I -= b;
                if (I != 0) {
                    return (((float) K) / ((float) I)) + 1.0f;
                }
            }
            return 0.0f;
        }

        final View c(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        final int g(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).I();
            }
            return super.g(view);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m0generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public /* synthetic */ android.widget.LinearLayout.LayoutParams m1generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m2generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    static /* synthetic */ ao a(AppBarLayout appBarLayout, ao aoVar) {
        ao aoVar2 = null;
        if (y.Z(appBarLayout)) {
            aoVar2 = aoVar;
        }
        if (aoVar2 != appBarLayout.eC) {
            appBarLayout.eC = aoVar2;
            appBarLayout.H();
        }
        return aoVar;
    }

    static /* synthetic */ boolean a(AppBarLayout appBarLayout) {
        return appBarLayout.I() != 0;
    }

    static /* synthetic */ int b(AppBarLayout appBarLayout) {
        if (appBarLayout.ex != -1) {
            return appBarLayout.ex;
        }
        int i;
        int childCount = appBarLayout.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = appBarLayout.getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.eU;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
                i = i2;
            } else {
                i = (layoutParams.bottomMargin + layoutParams.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + y.T(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - y.T(childAt)) : i + measuredHeight;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        appBarLayout.ex = i;
        return i;
    }

    static /* synthetic */ int d(AppBarLayout appBarLayout) {
        if (appBarLayout.ey != -1) {
            return appBarLayout.ey;
        }
        int i;
        int childCount = appBarLayout.getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = appBarLayout.getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            i = layoutParams.eU;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (y.T(childAt) + appBarLayout.J());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        appBarLayout.ey = i;
        return i;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        int i = 1;
        int i2 = 0;
        super(context, attributeSet);
        setOrientation(1);
        t.g(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bc, 0, h.aN);
        this.eA = (float) obtainStyledAttributes.getDimensionPixelSize(i.bh, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(i.bg));
        if (obtainStyledAttributes.hasValue(i.bi)) {
            boolean z = obtainStyledAttributes.getBoolean(i.bi, false);
            boolean ai = y.ai(this);
            if (!z) {
                i = 2;
            }
            if (ai) {
                i2 = 4;
            }
            this.eB = i2 | i;
            requestLayout();
        }
        obtainStyledAttributes.recycle();
        aa.u(this);
        this.eD = new ArrayList();
        y.g((View) this, this.eA);
        y.b((View) this, new s(this) {
            final /* synthetic */ AppBarLayout eE;

            {
                this.eE = r1;
            }

            public final ao a(View view, ao aoVar) {
                return AppBarLayout.a(this.eE, aoVar);
            }
        });
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        H();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        H();
        this.ez = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).eV != null) {
                this.ez = true;
                return;
            }
        }
    }

    private void H() {
        this.ew = -1;
        this.ex = -1;
        this.ey = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final int I() {
        if (this.ew != -1) {
            return this.ew;
        }
        int T;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.eU;
            if ((i3 & 1) == 0) {
                break;
            }
            i += layoutParams.bottomMargin + (measuredHeight + layoutParams.topMargin);
            if ((i3 & 2) != 0) {
                T = i - y.T(childAt);
                break;
            }
        }
        T = i;
        T = Math.max(0, T - J());
        this.ew = T;
        return T;
    }

    final int J() {
        return this.eC != null ? this.eC.getSystemWindowInsetTop() : 0;
    }
}
