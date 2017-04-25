package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.v;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.tencent.mmdb.FileUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements android.support.v4.view.o, v {
    private static final int[] XZ = new int[]{16843830};
    private static final boolean Ya;
    static final boolean Yb;
    private static final Class<?>[] Yc = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private static final Interpolator Zf = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private final int[] Cn;
    private final int[] Co;
    private final boolean YA;
    private List<Object> YB;
    public boolean YC;
    private int YD;
    android.support.v4.widget.i YE;
    android.support.v4.widget.i YF;
    android.support.v4.widget.i YG;
    android.support.v4.widget.i YH;
    public e YI;
    private int YJ;
    private int YK;
    private int YL;
    private int YM;
    private int YN;
    private final int YO;
    private final int YP;
    private float YQ;
    final r YR;
    final p YS;
    public j YT;
    private List<j> YU;
    boolean YV;
    boolean YW;
    public a YX;
    private boolean YY;
    private ac YZ;
    private final n Yd;
    final l Ye;
    private SavedState Yf;
    e Yg;
    public s Yh;
    final ar Yi;
    private boolean Yj;
    private final Runnable Yk;
    private a Yl;
    public h Ym;
    private m Yn;
    private final ArrayList<g> Yo;
    private final ArrayList<i> Yp;
    private i Yq;
    private boolean Yr;
    public boolean Ys;
    boolean Yt;
    private int Yu;
    private boolean Yv;
    public boolean Yw;
    private boolean Yx;
    private int Yy;
    private boolean Yz;
    private d Za;
    private final int[] Zb;
    private android.support.v4.view.p Zc;
    private final int[] Zd;
    private Runnable Ze;
    private final b Zg;
    private final Rect ep;
    private VelocityTracker fj;
    private int iD;
    private final AccessibilityManager jk;
    private int xe;

    public static class LayoutParams extends MarginLayoutParams {
        final Rect VS = new Rect();
        boolean ZA = false;
        s Zy;
        boolean Zz = true;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable ZL;

        SavedState(Parcel parcel) {
            super(parcel);
            this.ZL = parcel.readParcelable(h.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.ZL, 0);
        }
    }

    public static abstract class a<VH extends s> {
        public final b Zi = new b();
        boolean Zj = false;

        public abstract VH a(ViewGroup viewGroup, int i);

        public abstract void a(VH vh, int i);

        public abstract int getItemCount();

        public void a(VH vh, int i, List<Object> list) {
            a((s) vh, i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public long getItemId(int i) {
            return -1;
        }

        public void a(VH vh) {
        }

        public final void a(c cVar) {
            this.Zi.registerObserver(cVar);
        }

        public final void b(c cVar) {
            this.Zi.unregisterObserver(cVar);
        }

        public final void b(int i, int i2, Object obj) {
            this.Zi.b(i, i2, obj);
        }

        public final void O(int i, int i2) {
            this.Zi.O(i, i2);
        }

        public final void P(int i, int i2) {
            this.Zi.P(i, i2);
        }

        public final void Q(int i, int i2) {
            this.Zi.Q(i, i2);
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public final void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public final void b(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).c(i, i2, obj);
            }
        }

        public final void P(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).S(i, i2);
            }
        }

        public final void Q(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).T(i, i2);
            }
        }

        public final void O(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).U(i, i2);
            }
        }
    }

    public static abstract class c {
        public void onChanged() {
        }

        public void R(int i, int i2) {
        }

        public void c(int i, int i2, Object obj) {
            R(i, i2);
        }

        public void S(int i, int i2) {
        }

        public void T(int i, int i2) {
        }

        public void U(int i, int i2) {
        }
    }

    public interface d {
        int fT();
    }

    public static abstract class e {
        public a Zk = null;
        private ArrayList<Object> Zl = new ArrayList();
        long Zm = 120;
        long Zn = 120;
        long Zo = 250;
        long Zp = 250;

        interface a {
            void m(s sVar);
        }

        public static class b {
            public int bottom;
            public int left;
            public int right;
            public int top;

            public final b n(s sVar) {
                View view = sVar.aal;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        public abstract boolean a(s sVar, s sVar2, b bVar, b bVar2);

        public abstract void d(s sVar);

        public abstract boolean d(s sVar, b bVar, b bVar2);

        public abstract boolean e(s sVar, b bVar, b bVar2);

        public abstract void eN();

        public abstract void eP();

        public abstract boolean f(s sVar, b bVar, b bVar2);

        public abstract boolean isRunning();

        static int j(s sVar) {
            int y = sVar.tM & 14;
            if (sVar.gn()) {
                return 4;
            }
            if ((y & 4) != 0) {
                return y;
            }
            int i = sVar.aam;
            int gh = sVar.gh();
            if (i == -1 || gh == -1 || i == gh) {
                return y;
            }
            return y | 2048;
        }

        public final void k(s sVar) {
            if (this.Zk != null) {
                this.Zk.m(sVar);
            }
        }

        public boolean l(s sVar) {
            return true;
        }

        public boolean a(s sVar, List<Object> list) {
            return l(sVar);
        }

        public final void fU() {
            int size = this.Zl.size();
            for (int i = 0; i < size; i++) {
                this.Zl.get(i);
            }
            this.Zl.clear();
        }
    }

    public static abstract class g {
        public void a(Rect rect, View view, RecyclerView recyclerView) {
            ((LayoutParams) view.getLayoutParams()).Zy.gg();
            rect.set(0, 0, 0, 0);
        }
    }

    public static abstract class h {
        int QW;
        s Yh;
        RecyclerView Zq;
        o Zr;
        boolean Zs = false;
        boolean Zt = false;
        boolean Zu = true;
        int Zv;
        int Zw;
        int Zx;
        boolean hh = false;

        public abstract LayoutParams eR();

        static /* synthetic */ void a(h hVar, o oVar) {
            if (hVar.Zr == oVar) {
                hVar.Zr = null;
            }
        }

        final void y(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.Zq = null;
                this.Yh = null;
                this.Zx = 0;
                this.QW = 0;
            } else {
                this.Zq = recyclerView;
                this.Yh = recyclerView.Yh;
                this.Zx = recyclerView.getWidth();
                this.QW = recyclerView.getHeight();
            }
            this.Zv = 1073741824;
            this.Zw = 1073741824;
        }

        final void V(int i, int i2) {
            this.Zx = MeasureSpec.getSize(i);
            this.Zv = MeasureSpec.getMode(i);
            if (this.Zv == 0 && !RecyclerView.Yb) {
                this.Zx = 0;
            }
            this.QW = MeasureSpec.getSize(i2);
            this.Zw = MeasureSpec.getMode(i2);
            if (this.Zw == 0 && !RecyclerView.Yb) {
                this.QW = 0;
            }
        }

        final void W(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int childCount = getChildCount();
            if (childCount == 0) {
                this.Zq.M(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int bh = bh(childAt) - layoutParams.leftMargin;
                int bj = layoutParams.rightMargin + bj(childAt);
                int bi = bi(childAt) - layoutParams.topMargin;
                int bk = layoutParams.bottomMargin + bk(childAt);
                if (bh >= i7) {
                    bh = i7;
                }
                if (bj <= i6) {
                    bj = i6;
                }
                if (bi >= i3) {
                    bi = i3;
                }
                if (bk <= i4) {
                    bk = i4;
                }
                i5++;
                i6 = bj;
                i3 = bi;
                i7 = bh;
                i4 = bk;
            }
            this.Zq.ep.set(i7, i3, i6, i4);
            a(this.Zq.ep, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            setMeasuredDimension(j(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), y.S(this.Zq)), j(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), y.T(this.Zq)));
        }

        public final void requestLayout() {
            if (this.Zq != null) {
                this.Zq.requestLayout();
            }
        }

        public static int j(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void q(String str) {
            if (this.Zq != null) {
                this.Zq.q(str);
            }
        }

        public boolean eU() {
            return false;
        }

        final void b(RecyclerView recyclerView, l lVar) {
            this.hh = false;
            a(recyclerView, lVar);
        }

        public final boolean removeCallbacks(Runnable runnable) {
            if (this.Zq != null) {
                return this.Zq.removeCallbacks(runnable);
            }
            return false;
        }

        public void a(RecyclerView recyclerView, l lVar) {
        }

        public void c(l lVar, p pVar) {
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams e(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int a(int i, l lVar, p pVar) {
            return 0;
        }

        public int b(int i, l lVar, p pVar) {
            return 0;
        }

        public boolean eV() {
            return false;
        }

        public boolean eW() {
            return false;
        }

        public void aT(int i) {
        }

        public void a(RecyclerView recyclerView, int i) {
        }

        public final void a(o oVar) {
            if (!(this.Zr == null || oVar == this.Zr || !this.Zr.ZO)) {
                this.Zr.stop();
            }
            this.Zr = oVar;
            o oVar2 = this.Zr;
            oVar2.Zq = this.Zq;
            oVar2.XX = this;
            if (oVar2.ZM == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            oVar2.Zq.YS.ZM = oVar2.ZM;
            oVar2.ZO = true;
            oVar2.ZN = true;
            oVar2.ZP = oVar2.Zq.Ym.aR(oVar2.ZM);
            oVar2.Zq.YR.gd();
        }

        public final boolean fV() {
            return this.Zr != null && this.Zr.ZO;
        }

        void c(View view, int i, boolean z) {
            s aY = RecyclerView.aY(view);
            if (z || aY.isRemoved()) {
                this.Zq.Yi.A(aY);
            } else {
                this.Zq.Yi.B(aY);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (aY.gk() || aY.gi()) {
                if (aY.gi()) {
                    aY.gj();
                } else {
                    aY.gl();
                }
                this.Yh.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.Zq) {
                int indexOfChild = this.Yh.indexOfChild(view);
                if (i == -1) {
                    i = this.Yh.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.Zq.indexOfChild(view));
                } else if (indexOfChild != i) {
                    h hVar = this.Zq.Ym;
                    View childAt = hVar.getChildAt(indexOfChild);
                    if (childAt == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + indexOfChild);
                    }
                    hVar.aX(indexOfChild);
                    LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    s aY2 = RecyclerView.aY(childAt);
                    if (aY2.isRemoved()) {
                        hVar.Zq.Yi.A(aY2);
                    } else {
                        hVar.Zq.Yi.B(aY2);
                    }
                    hVar.Yh.a(childAt, i, layoutParams2, aY2.isRemoved());
                }
            } else {
                this.Yh.a(view, i, false);
                layoutParams.Zz = true;
                if (this.Zr != null && this.Zr.ZO) {
                    o oVar = this.Zr;
                    if (RecyclerView.ba(view) == oVar.ZM) {
                        oVar.ZP = view;
                    }
                }
            }
            if (layoutParams.ZA) {
                aY.aal.invalidate();
                layoutParams.ZA = false;
            }
        }

        private void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                s sVar = this.Yh;
                int aK = sVar.aK(i);
                View childAt = sVar.UR.getChildAt(aK);
                if (childAt != null) {
                    if (sVar.US.aM(aK)) {
                        sVar.aN(childAt);
                    }
                    sVar.UR.removeViewAt(aK);
                }
            }
        }

        public static int bd(View view) {
            return ((LayoutParams) view.getLayoutParams()).Zy.gg();
        }

        public final View be(View view) {
            if (this.Zq == null) {
                return null;
            }
            ViewParent viewParent = this.Zq;
            ViewParent parent = view.getParent();
            View view2 = view;
            while (parent != null && parent != viewParent && (parent instanceof View)) {
                View view3 = (View) parent;
                view2 = view3;
                parent = view3.getParent();
            }
            if (parent == viewParent) {
                view3 = view2;
            } else {
                view3 = null;
            }
            if (view3 == null) {
                return null;
            }
            if (this.Yh.aO(view3)) {
                return null;
            }
            return view3;
        }

        public View aR(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                s aY = RecyclerView.aY(childAt);
                if (aY != null && aY.gg() == i && !aY.gf() && (this.Zq.YS.aac || !aY.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        private void aX(int i) {
            getChildAt(i);
            this.Yh.detachViewFromParent(i);
        }

        public final void a(View view, l lVar) {
            s sVar = this.Yh;
            int indexOfChild = sVar.UR.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (sVar.US.aM(indexOfChild)) {
                    sVar.aN(view);
                }
                sVar.UR.removeViewAt(indexOfChild);
            }
            lVar.bl(view);
        }

        public final void a(int i, l lVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            lVar.bl(childAt);
        }

        public final int getChildCount() {
            return this.Yh != null ? this.Yh.getChildCount() : 0;
        }

        public final View getChildAt(int i) {
            return this.Yh != null ? this.Yh.getChildAt(i) : null;
        }

        public final int getPaddingLeft() {
            return this.Zq != null ? this.Zq.getPaddingLeft() : 0;
        }

        public final int getPaddingTop() {
            return this.Zq != null ? this.Zq.getPaddingTop() : 0;
        }

        public final int getPaddingRight() {
            return this.Zq != null ? this.Zq.getPaddingRight() : 0;
        }

        public final int getPaddingBottom() {
            return this.Zq != null ? this.Zq.getPaddingBottom() : 0;
        }

        public void aY(int i) {
            if (this.Zq != null) {
                RecyclerView recyclerView = this.Zq;
                int childCount = recyclerView.Yh.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.Yh.getChildAt(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void aZ(int i) {
            if (this.Zq != null) {
                RecyclerView recyclerView = this.Zq;
                int childCount = recyclerView.Yh.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.Yh.getChildAt(i2).offsetTopAndBottom(i);
                }
            }
        }

        public final void b(l lVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                s aY = RecyclerView.aY(childAt);
                if (!aY.gf()) {
                    if (!aY.gn() || aY.isRemoved() || this.Zq.Yl.Zj) {
                        aX(childCount);
                        lVar.bn(childAt);
                        this.Zq.Yi.B(aY);
                    } else {
                        removeViewAt(childCount);
                        lVar.o(aY);
                    }
                }
            }
        }

        final void c(l lVar) {
            int size = lVar.ZE.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((s) lVar.ZE.get(i)).aal;
                s aY = RecyclerView.aY(view);
                if (!aY.gf()) {
                    aY.S(false);
                    if (aY.gp()) {
                        this.Zq.removeDetachedView(view, false);
                    }
                    if (this.Zq.YI != null) {
                        this.Zq.YI.d(aY);
                    }
                    aY.S(true);
                    lVar.bm(view);
                }
            }
            lVar.ZE.clear();
            if (lVar.ZF != null) {
                lVar.ZF.clear();
            }
            if (size > 0) {
                this.Zq.invalidate();
            }
        }

        final boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.Zu && k(view.getWidth(), i, layoutParams.width) && k(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        static boolean k(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    if (size >= i) {
                        return true;
                    }
                    return false;
                case 0:
                    return true;
                case 1073741824:
                    if (size == i) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        public static int b(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = i2;
                            break;
                        default:
                            max = 0;
                            break;
                    }
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static int bf(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).VS;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public static int bg(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).VS;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public static void g(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).VS;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public static int bh(View view) {
            return view.getLeft() - ((LayoutParams) view.getLayoutParams()).VS.left;
        }

        public static int bi(View view) {
            return view.getTop() - ((LayoutParams) view.getLayoutParams()).VS.top;
        }

        public static int bj(View view) {
            return ((LayoutParams) view.getLayoutParams()).VS.right + view.getRight();
        }

        public static int bk(View view) {
            return ((LayoutParams) view.getLayoutParams()).VS.bottom + view.getBottom();
        }

        public final void a(View view, Rect rect) {
            if (this.Zq == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.Zq.bb(view));
            }
        }

        public View a(View view, int i, l lVar, p pVar) {
            return null;
        }

        public void eQ() {
        }

        public void y(int i, int i2) {
        }

        public void z(int i, int i2) {
        }

        public void A(int i, int i2) {
        }

        public void B(int i, int i2) {
        }

        public int d(p pVar) {
            return 0;
        }

        public int b(p pVar) {
            return 0;
        }

        public int f(p pVar) {
            return 0;
        }

        public int e(p pVar) {
            return 0;
        }

        public int c(p pVar) {
            return 0;
        }

        public int g(p pVar) {
            return 0;
        }

        public final void X(int i, int i2) {
            this.Zq.M(i, i2);
        }

        public final void setMeasuredDimension(int i, int i2) {
            this.Zq.setMeasuredDimension(i, i2);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        final void fW() {
            if (this.Zr != null) {
                this.Zr.stop();
            }
        }

        public void ba(int i) {
        }

        public final void d(l lVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.aY(getChildAt(childCount)).gf()) {
                    a(childCount, lVar);
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            l lVar = this.Zq.Ye;
            p pVar = this.Zq.YS;
            android.support.v4.view.a.f a = android.support.v4.view.a.a.a(accessibilityEvent);
            if (this.Zq != null) {
                if (!(y.g(this.Zq, 1) || y.g(this.Zq, -1) || y.f(this.Zq, -1) || y.f(this.Zq, 1))) {
                    z = false;
                }
                a.setScrollable(z);
                if (this.Zq.Yl != null) {
                    a.setItemCount(this.Zq.Yl.getItemCount());
                }
            }
        }

        final void b(View view, android.support.v4.view.a.b bVar) {
            s aY = RecyclerView.aY(view);
            if (aY != null && !aY.isRemoved() && !this.Yh.aO(aY.aal)) {
                a(this.Zq.Ye, this.Zq.YS, view, bVar);
            }
        }

        public void a(l lVar, p pVar, View view, android.support.v4.view.a.b bVar) {
            int bd;
            int bd2 = eW() ? bd(view) : 0;
            if (eV()) {
                bd = bd(view);
            } else {
                bd = 0;
            }
            bVar.k(android.support.v4.view.a.b.l.a(bd2, 1, bd, 1, false));
        }

        public int a(l lVar, p pVar) {
            if (this.Zq == null || this.Zq.Yl == null || !eW()) {
                return 1;
            }
            return this.Zq.Yl.getItemCount();
        }

        public int b(l lVar, p pVar) {
            if (this.Zq == null || this.Zq.Yl == null || !eV()) {
                return 1;
            }
            return this.Zq.Yl.getItemCount();
        }

        final void z(RecyclerView recyclerView) {
            V(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean fb() {
            return false;
        }
    }

    public interface i {
        boolean fX();
    }

    public static abstract class j {
        public void e(RecyclerView recyclerView, int i) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class k {
        SparseArray<ArrayList<s>> ZB = new SparseArray();
        SparseIntArray ZC = new SparseIntArray();
        int ZD = 0;
    }

    public final class l {
        final ArrayList<s> ZE = new ArrayList();
        ArrayList<s> ZF = null;
        final ArrayList<s> ZG = new ArrayList();
        final List<s> ZH = Collections.unmodifiableList(this.ZE);
        private int ZI = 2;
        private k ZJ;
        private q ZK;
        final /* synthetic */ RecyclerView Zh;

        public l(RecyclerView recyclerView) {
            this.Zh = recyclerView;
        }

        public final void clear() {
            this.ZE.clear();
            fY();
        }

        public final int bb(int i) {
            if (i >= 0 && i < this.Zh.YS.getItemCount()) {
                return !this.Zh.YS.aac ? i : this.Zh.Yg.aG(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + this.Zh.YS.getItemCount());
            }
        }

        public final View bc(int i) {
            boolean z = true;
            if (i < 0 || i >= this.Zh.YS.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.Zh.YS.getItemCount());
            }
            boolean z2;
            s sVar;
            boolean z3;
            boolean z4;
            s sVar2;
            LayoutParams layoutParams;
            if (this.Zh.YS.aac) {
                s be = be(i);
                s sVar3 = be;
                z2 = be != null;
                sVar = sVar3;
            } else {
                sVar = null;
                z2 = false;
            }
            if (sVar == null) {
                sVar = o(i, false);
                if (sVar != null) {
                    if (sVar.isRemoved()) {
                        z3 = this.Zh.YS.aac;
                    } else if (sVar.kB < 0 || sVar.kB >= this.Zh.Yl.getItemCount()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + sVar);
                    } else {
                        z3 = (this.Zh.YS.aac || this.Zh.Yl.getItemViewType(sVar.kB) == sVar.aao) ? !this.Zh.Yl.Zj || sVar.aan == this.Zh.Yl.getItemId(sVar.kB) : false;
                    }
                    if (z3) {
                        z2 = true;
                    } else {
                        sVar.addFlags(4);
                        if (sVar.gi()) {
                            this.Zh.removeDetachedView(sVar.aal, false);
                            sVar.gj();
                        } else if (sVar.gk()) {
                            sVar.gl();
                        }
                        o(sVar);
                        sVar = null;
                    }
                }
            }
            if (sVar == null) {
                int aG = this.Zh.Yg.aG(i);
                if (aG < 0 || aG >= this.Zh.Yl.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + aG + ").state:" + this.Zh.YS.getItemCount());
                }
                View gb;
                ArrayList arrayList;
                a h;
                ViewGroup viewGroup;
                int itemViewType = this.Zh.Yl.getItemViewType(aG);
                if (this.Zh.Yl.Zj) {
                    sVar = b(this.Zh.Yl.getItemId(aG), itemViewType, false);
                    if (sVar != null) {
                        sVar.kB = aG;
                        z3 = true;
                        if (sVar == null && this.ZK != null) {
                            gb = this.ZK.gb();
                            if (gb != null) {
                                sVar = this.Zh.aP(gb);
                                if (sVar == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (sVar.gf()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (sVar == null) {
                            arrayList = (ArrayList) fZ().ZB.get(itemViewType);
                            if (arrayList != null || arrayList.isEmpty()) {
                                be = null;
                            } else {
                                int size = arrayList.size() - 1;
                                be = (s) arrayList.get(size);
                                arrayList.remove(size);
                            }
                            if (be != null) {
                                be.gs();
                                if (RecyclerView.Ya && (be.aal instanceof ViewGroup)) {
                                    c((ViewGroup) be.aal, false);
                                }
                            }
                            sVar = be;
                        }
                        if (sVar != null) {
                            h = this.Zh.Yl;
                            viewGroup = this.Zh;
                            android.support.v4.os.e.beginSection("RV CreateView");
                            sVar = h.a(viewGroup, itemViewType);
                            sVar.aao = itemViewType;
                            z4 = z3;
                            sVar2 = sVar;
                            android.support.v4.os.e.endSection();
                        } else {
                            z4 = z3;
                            sVar2 = sVar;
                        }
                    }
                }
                z3 = z2;
                gb = this.ZK.gb();
                if (gb != null) {
                    sVar = this.Zh.aP(gb);
                    if (sVar == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    } else if (sVar.gf()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
                if (sVar == null) {
                    arrayList = (ArrayList) fZ().ZB.get(itemViewType);
                    if (arrayList != null) {
                    }
                    be = null;
                    if (be != null) {
                        be.gs();
                        c((ViewGroup) be.aal, false);
                    }
                    sVar = be;
                }
                if (sVar != null) {
                    z4 = z3;
                    sVar2 = sVar;
                } else {
                    h = this.Zh.Yl;
                    viewGroup = this.Zh;
                    android.support.v4.os.e.beginSection("RV CreateView");
                    sVar = h.a(viewGroup, itemViewType);
                    sVar.aao = itemViewType;
                    z4 = z3;
                    sVar2 = sVar;
                    android.support.v4.os.e.endSection();
                }
            } else {
                sVar2 = sVar;
                z4 = z2;
            }
            if (z4 && !this.Zh.YS.aac && sVar2.bg(8192)) {
                sVar2.setFlags(0, 8192);
                if (this.Zh.YS.aad) {
                    e.j(sVar2);
                    e eVar = this.Zh.YI;
                    p pVar = this.Zh.YS;
                    sVar2.gr();
                    this.Zh.a(sVar2, new b().n(sVar2));
                }
            }
            if (this.Zh.YS.aac && sVar2.isBound()) {
                sVar2.aap = i;
                z2 = false;
            } else if (!sVar2.isBound() || sVar2.go() || sVar2.gn()) {
                int aG2 = this.Zh.Yg.aG(i);
                sVar2.aaz = this.Zh;
                a h2 = this.Zh.Yl;
                sVar2.kB = aG2;
                if (h2.Zj) {
                    sVar2.aan = h2.getItemId(aG2);
                }
                sVar2.setFlags(1, 519);
                android.support.v4.os.e.beginSection("RV OnBindView");
                h2.a(sVar2, aG2, sVar2.gr());
                sVar2.gq();
                android.support.v4.os.e.endSection();
                View view = sVar2.aal;
                if (this.Zh.fE()) {
                    if (y.F(view) == 0) {
                        y.h(view, 1);
                    }
                    if (!y.C(view)) {
                        y.a(view, this.Zh.YZ.aaA);
                    }
                }
                if (this.Zh.YS.aac) {
                    sVar2.aap = i;
                }
                z2 = true;
            } else {
                z2 = false;
            }
            android.view.ViewGroup.LayoutParams layoutParams2 = sVar2.aal.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) this.Zh.generateDefaultLayoutParams();
                sVar2.aal.setLayoutParams(layoutParams);
            } else if (this.Zh.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = (LayoutParams) this.Zh.generateLayoutParams(layoutParams2);
                sVar2.aal.setLayoutParams(layoutParams);
            }
            layoutParams.Zy = sVar2;
            if (!(z4 && r1)) {
                z = false;
            }
            layoutParams.ZA = z;
            return sVar2.aal;
        }

        private void c(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    c((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public final void bl(View view) {
            s aY = RecyclerView.aY(view);
            if (aY.gp()) {
                this.Zh.removeDetachedView(view, false);
            }
            if (aY.gi()) {
                aY.gj();
            } else if (aY.gk()) {
                aY.gl();
            }
            o(aY);
        }

        final void fY() {
            for (int size = this.ZG.size() - 1; size >= 0; size--) {
                bd(size);
            }
            this.ZG.clear();
        }

        final void bd(int i) {
            p((s) this.ZG.get(i));
            this.ZG.remove(i);
        }

        final void o(s sVar) {
            boolean z = true;
            int i = 0;
            if (sVar.gi() || sVar.aal.getParent() != null) {
                StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(sVar.gi()).append(" isAttached:");
                if (sVar.aal.getParent() == null) {
                    z = false;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (sVar.gp()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + sVar);
            } else if (sVar.gf()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                boolean t = s.t(sVar);
                if (this.Zh.Yl != null && t) {
                    this.Zh.Yl;
                }
                if (sVar.gt()) {
                    boolean z2;
                    if (!sVar.bg(14)) {
                        int size = this.ZG.size();
                        if (size == this.ZI && size > 0) {
                            bd(0);
                        }
                        if (size < this.ZI) {
                            this.ZG.add(sVar);
                            z2 = true;
                            if (z2) {
                                p(sVar);
                                i = 1;
                                z = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z = z2;
                    } else {
                        p(sVar);
                        i = 1;
                        z = z2;
                    }
                } else {
                    z = false;
                }
                this.Zh.Yi.C(sVar);
                if (!z && r1 == 0 && t) {
                    sVar.aaz = null;
                }
            }
        }

        private void p(s sVar) {
            y.a(sVar.aal, null);
            if (this.Zh.Yn != null) {
                this.Zh.Yn;
            }
            if (this.Zh.Yl != null) {
                this.Zh.Yl.a(sVar);
            }
            if (this.Zh.YS != null) {
                this.Zh.Yi.C(sVar);
            }
            sVar.aaz = null;
            k fZ = fZ();
            int i = sVar.aao;
            ArrayList arrayList = (ArrayList) fZ.ZB.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                fZ.ZB.put(i, arrayList);
                if (fZ.ZC.indexOfKey(i) < 0) {
                    fZ.ZC.put(i, 5);
                }
            }
            if (fZ.ZC.get(i) > arrayList.size()) {
                sVar.gs();
                arrayList.add(sVar);
            }
        }

        final void bm(View view) {
            s aY = RecyclerView.aY(view);
            aY.aaw = null;
            aY.aax = false;
            aY.gl();
            o(aY);
        }

        final void bn(View view) {
            s aY = RecyclerView.aY(view);
            if (!aY.bg(12) && aY.gu() && !RecyclerView.a(this.Zh, aY)) {
                if (this.ZF == null) {
                    this.ZF = new ArrayList();
                }
                aY.a(this, true);
                this.ZF.add(aY);
            } else if (!aY.gn() || aY.isRemoved() || this.Zh.Yl.Zj) {
                aY.a(this, false);
                this.ZE.add(aY);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        final void q(s sVar) {
            if (sVar.aax) {
                this.ZF.remove(sVar);
            } else {
                this.ZE.remove(sVar);
            }
            sVar.aaw = null;
            sVar.aax = false;
            sVar.gl();
        }

        private s be(int i) {
            int i2 = 0;
            if (this.ZF != null) {
                int size = this.ZF.size();
                if (size != 0) {
                    s sVar;
                    int i3 = 0;
                    while (i3 < size) {
                        sVar = (s) this.ZF.get(i3);
                        if (sVar.gk() || sVar.gg() != i) {
                            i3++;
                        } else {
                            sVar.addFlags(32);
                            return sVar;
                        }
                    }
                    if (this.Zh.Yl.Zj) {
                        int s = this.Zh.Yg.s(i, 0);
                        if (s > 0 && s < this.Zh.Yl.getItemCount()) {
                            long itemId = this.Zh.Yl.getItemId(s);
                            while (i2 < size) {
                                sVar = (s) this.ZF.get(i2);
                                if (sVar.gk() || sVar.aan != itemId) {
                                    i2++;
                                } else {
                                    sVar.addFlags(32);
                                    return sVar;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        private s o(int i, boolean z) {
            View view;
            int i2 = 0;
            int size = this.ZE.size();
            int i3 = 0;
            while (i3 < size) {
                s sVar = (s) this.ZE.get(i3);
                if (sVar.gk() || sVar.gg() != i || sVar.gn() || (!this.Zh.YS.aac && sVar.isRemoved())) {
                    i3++;
                } else {
                    sVar.addFlags(32);
                    return sVar;
                }
            }
            s sVar2 = this.Zh.Yh;
            int size2 = sVar2.UT.size();
            for (i3 = 0; i3 < size2; i3++) {
                View view2 = (View) sVar2.UT.get(i3);
                s aP = sVar2.UR.aP(view2);
                if (aP.gg() == i && !aP.gn() && !aP.isRemoved()) {
                    view = view2;
                    break;
                }
            }
            view = null;
            if (view != null) {
                sVar = RecyclerView.aY(view);
                s sVar3 = this.Zh.Yh;
                i2 = sVar3.UR.indexOfChild(view);
                if (i2 < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                } else if (sVar3.US.get(i2)) {
                    sVar3.US.clear(i2);
                    sVar3.aN(view);
                    int indexOfChild = this.Zh.Yh.indexOfChild(view);
                    if (indexOfChild == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + sVar);
                    }
                    this.Zh.Yh.detachViewFromParent(indexOfChild);
                    bn(view);
                    sVar.addFlags(8224);
                    return sVar;
                } else {
                    throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                }
            }
            i3 = this.ZG.size();
            while (i2 < i3) {
                sVar = (s) this.ZG.get(i2);
                if (sVar.gn() || sVar.gg() != i) {
                    i2++;
                } else {
                    this.ZG.remove(i2);
                    return sVar;
                }
            }
            return null;
        }

        private s b(long j, int i, boolean z) {
            int size;
            for (size = this.ZE.size() - 1; size >= 0; size--) {
                s sVar = (s) this.ZE.get(size);
                if (sVar.aan == j && !sVar.gk()) {
                    if (i == sVar.aao) {
                        sVar.addFlags(32);
                        if (!sVar.isRemoved() || this.Zh.YS.aac) {
                            return sVar;
                        }
                        sVar.setFlags(2, 14);
                        return sVar;
                    }
                    this.ZE.remove(size);
                    this.Zh.removeDetachedView(sVar.aal, false);
                    bm(sVar.aal);
                }
            }
            for (size = this.ZG.size() - 1; size >= 0; size--) {
                sVar = (s) this.ZG.get(size);
                if (sVar.aan == j) {
                    if (i == sVar.aao) {
                        this.ZG.remove(size);
                        return sVar;
                    }
                    bd(size);
                }
            }
            return null;
        }

        final k fZ() {
            if (this.ZJ == null) {
                this.ZJ = new k();
            }
            return this.ZJ;
        }
    }

    public interface m {
    }

    public static abstract class o {
        h XX;
        public int ZM = -1;
        boolean ZN;
        boolean ZO;
        View ZP;
        private final a ZQ = new a();
        RecyclerView Zq;

        public static class a {
            private int ZR;
            private int ZS;
            int ZT;
            private boolean ZU;
            private int ZV;
            private int lr;
            private Interpolator mInterpolator;

            static /* synthetic */ void a(a aVar, RecyclerView recyclerView) {
                if (aVar.ZT >= 0) {
                    int i = aVar.ZT;
                    aVar.ZT = -1;
                    RecyclerView.d(recyclerView, i);
                    aVar.ZU = false;
                } else if (!aVar.ZU) {
                    aVar.ZV = 0;
                } else if (aVar.mInterpolator != null && aVar.lr <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (aVar.lr <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    if (aVar.mInterpolator != null) {
                        recyclerView.YR.b(aVar.ZR, aVar.ZS, aVar.lr, aVar.mInterpolator);
                    } else if (aVar.lr == Integer.MIN_VALUE) {
                        recyclerView.YR.smoothScrollBy(aVar.ZR, aVar.ZS);
                    } else {
                        recyclerView.YR.l(aVar.ZR, aVar.ZS, aVar.lr);
                    }
                    aVar.ZV++;
                    aVar.ZU = false;
                }
            }

            public a() {
                this(0, 0);
            }

            private a(int i, int i2) {
                this.ZT = -1;
                this.ZU = false;
                this.ZV = 0;
                this.ZR = 0;
                this.ZS = 0;
                this.lr = Integer.MIN_VALUE;
                this.mInterpolator = null;
            }

            public final void a(int i, int i2, int i3, Interpolator interpolator) {
                this.ZR = i;
                this.ZS = i2;
                this.lr = i3;
                this.mInterpolator = interpolator;
                this.ZU = true;
            }
        }

        protected abstract void a(int i, int i2, a aVar);

        protected abstract void a(View view, a aVar);

        protected abstract void onStop();

        static /* synthetic */ void a(o oVar, int i, int i2) {
            boolean z = false;
            RecyclerView recyclerView = oVar.Zq;
            if (!oVar.ZO || oVar.ZM == -1 || recyclerView == null) {
                oVar.stop();
            }
            oVar.ZN = false;
            if (oVar.ZP != null) {
                if (RecyclerView.ba(oVar.ZP) == oVar.ZM) {
                    View view = oVar.ZP;
                    p pVar = recyclerView.YS;
                    oVar.a(view, oVar.ZQ);
                    a.a(oVar.ZQ, recyclerView);
                    oVar.stop();
                } else {
                    oVar.ZP = null;
                }
            }
            if (oVar.ZO) {
                p pVar2 = recyclerView.YS;
                oVar.a(i, i2, oVar.ZQ);
                if (oVar.ZQ.ZT >= 0) {
                    z = true;
                }
                a.a(oVar.ZQ, recyclerView);
                if (!z) {
                    return;
                }
                if (oVar.ZO) {
                    oVar.ZN = true;
                    recyclerView.YR.gd();
                    return;
                }
                oVar.stop();
            }
        }

        protected final void stop() {
            if (this.ZO) {
                onStop();
                this.Zq.YS.ZM = -1;
                this.ZP = null;
                this.ZM = -1;
                this.ZN = false;
                this.ZO = false;
                h.a(this.XX, this);
                this.XX = null;
                this.Zq = null;
            }
        }
    }

    public static class p {
        int ZM = -1;
        int ZW = 1;
        private SparseArray<Object> ZX;
        int ZY = 0;
        int ZZ = 0;
        int aaa = 0;
        boolean aab = false;
        boolean aac = false;
        boolean aad = false;
        boolean aae = false;
        boolean aaf = false;
        boolean aag = false;

        final void bf(int i) {
            if ((this.ZW & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.ZW));
            }
        }

        public final int getItemCount() {
            return this.aac ? this.ZZ - this.aaa : this.ZY;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.ZM + ", mData=" + this.ZX + ", mItemCount=" + this.ZY + ", mPreviousLayoutItemCount=" + this.ZZ + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.aaa + ", mStructureChanged=" + this.aab + ", mInPreLayout=" + this.aac + ", mRunSimpleAnimations=" + this.aad + ", mRunPredictiveAnimations=" + this.aae + '}';
        }
    }

    public static abstract class q {
        public abstract View gb();
    }

    private class r implements Runnable {
        final /* synthetic */ RecyclerView Zh;
        int aah;
        int aai;
        private boolean aaj = false;
        private boolean aak = false;
        android.support.v4.widget.q iA;
        private Interpolator mInterpolator = RecyclerView.Zf;

        public r(RecyclerView recyclerView) {
            this.Zh = recyclerView;
            this.iA = android.support.v4.widget.q.a(recyclerView.getContext(), RecyclerView.Zf);
        }

        public final void run() {
            if (this.Zh.Ym == null) {
                stop();
                return;
            }
            this.aak = false;
            this.aaj = true;
            this.Zh.fr();
            android.support.v4.widget.q qVar = this.iA;
            o oVar = this.Zh.Ym.Zr;
            if (qVar.computeScrollOffset()) {
                int itemCount;
                int i;
                int currVelocity;
                int i2;
                View view;
                Object obj;
                Object obj2;
                int currX = qVar.getCurrX();
                int currY = qVar.getCurrY();
                int i3 = currX - this.aah;
                int i4 = currY - this.aai;
                int i5 = 0;
                int i6 = 0;
                this.aah = currX;
                this.aai = currY;
                int i7 = 0;
                int i8 = 0;
                if (this.Zh.Yl != null) {
                    this.Zh.fs();
                    this.Zh.fC();
                    android.support.v4.os.e.beginSection("RV Scroll");
                    if (i3 != 0) {
                        i5 = this.Zh.Ym.a(i3, this.Zh.Ye, this.Zh.YS);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.Zh.Ym.b(i4, this.Zh.Ye, this.Zh.YS);
                        i8 = i4 - i6;
                    }
                    android.support.v4.os.e.endSection();
                    this.Zh.fP();
                    this.Zh.fD();
                    this.Zh.R(false);
                    if (!(oVar == null || oVar.ZN || !oVar.ZO)) {
                        itemCount = this.Zh.YS.getItemCount();
                        if (itemCount == 0) {
                            oVar.stop();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                            if (!this.Zh.Yo.isEmpty()) {
                                this.Zh.invalidate();
                            }
                            if (y.B(this.Zh) != 2) {
                                this.Zh.L(i3, i4);
                            }
                            if (!(i6 == 0 && i8 == 0)) {
                                currVelocity = (int) qVar.getCurrVelocity();
                                if (i6 == currX) {
                                    itemCount = i6 >= 0 ? -currVelocity : i6 <= 0 ? currVelocity : 0;
                                    i2 = itemCount;
                                } else {
                                    i2 = 0;
                                }
                                if (i8 != currY) {
                                    currVelocity = 0;
                                } else if (i8 < 0) {
                                    currVelocity = -currVelocity;
                                } else if (i8 <= 0) {
                                    currVelocity = 0;
                                }
                                if (y.B(this.Zh) != 2) {
                                    view = this.Zh;
                                    if (i2 < 0) {
                                        view.fv();
                                        view.YE.ah(-i2);
                                    } else if (i2 > 0) {
                                        view.fw();
                                        view.YG.ah(i2);
                                    }
                                    if (currVelocity < 0) {
                                        view.fx();
                                        view.YF.ah(-currVelocity);
                                    } else if (currVelocity > 0) {
                                        view.fy();
                                        view.YH.ah(currVelocity);
                                    }
                                    if (!(i2 == 0 && currVelocity == 0)) {
                                        y.E(view);
                                    }
                                }
                                if ((i2 != 0 || i6 == currX || qVar.getFinalX() == 0) && (currVelocity != 0 || i8 == currY || qVar.getFinalY() == 0)) {
                                    qVar.abortAnimation();
                                }
                            }
                            if (!(i5 == 0 && i7 == 0)) {
                                this.Zh.N(i5, i7);
                            }
                            if (!this.Zh.awakenScrollBars()) {
                                this.Zh.invalidate();
                            }
                            obj = (i4 == 0 && this.Zh.Ym.eW() && i7 == i4) ? 1 : null;
                            obj2 = (i3 == 0 && this.Zh.Ym.eV() && i5 == i3) ? 1 : null;
                            obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                            if (!qVar.isFinished() || obj2 == null) {
                                this.Zh.Y(0);
                            } else {
                                gd();
                            }
                        } else {
                            if (oVar.ZM >= itemCount) {
                                oVar.ZM = itemCount - 1;
                            }
                            o.a(oVar, i3 - i7, i4 - i8);
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.Zh.Yo.isEmpty()) {
                    this.Zh.invalidate();
                }
                if (y.B(this.Zh) != 2) {
                    this.Zh.L(i3, i4);
                }
                currVelocity = (int) qVar.getCurrVelocity();
                if (i6 == currX) {
                    i2 = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = itemCount;
                }
                if (i8 != currY) {
                    currVelocity = 0;
                } else if (i8 < 0) {
                    currVelocity = -currVelocity;
                } else if (i8 <= 0) {
                    currVelocity = 0;
                }
                if (y.B(this.Zh) != 2) {
                    view = this.Zh;
                    if (i2 < 0) {
                        view.fv();
                        view.YE.ah(-i2);
                    } else if (i2 > 0) {
                        view.fw();
                        view.YG.ah(i2);
                    }
                    if (currVelocity < 0) {
                        view.fx();
                        view.YF.ah(-currVelocity);
                    } else if (currVelocity > 0) {
                        view.fy();
                        view.YH.ah(currVelocity);
                    }
                    y.E(view);
                }
                qVar.abortAnimation();
                this.Zh.N(i5, i7);
                if (this.Zh.awakenScrollBars()) {
                    this.Zh.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (qVar.isFinished()) {
                }
                this.Zh.Y(0);
            }
            if (oVar != null) {
                if (oVar.ZN) {
                    o.a(oVar, 0, 0);
                }
                if (!this.aak) {
                    oVar.stop();
                }
            }
            this.aaj = false;
            if (this.aak) {
                gd();
            }
        }

        final void gd() {
            if (this.aaj) {
                this.aak = true;
                return;
            }
            this.Zh.removeCallbacks(this);
            y.a(this.Zh, (Runnable) this);
        }

        public final void smoothScrollBy(int i, int i2) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.Zh.getWidth() : this.Zh.getHeight();
            int i3 = width / 2;
            float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i3)) + ((float) i3);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(sin / ((float) sqrt))) * 4;
            } else {
                round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            l(i, i2, Math.min(round, 2000));
        }

        public final void l(int i, int i2, int i3) {
            b(i, i2, i3, RecyclerView.Zf);
        }

        public final void b(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.iA = android.support.v4.widget.q.a(this.Zh.getContext(), interpolator);
            }
            this.Zh.Y(2);
            this.aai = 0;
            this.aah = 0;
            this.iA.startScroll(0, 0, i, i2, i3);
            gd();
        }

        public final void stop() {
            this.Zh.removeCallbacks(this);
            this.iA.abortAnimation();
        }
    }

    public static abstract class s {
        private static final List<Object> aas = Collections.EMPTY_LIST;
        public final View aal;
        int aam = -1;
        public long aan = -1;
        int aao = -1;
        int aap = -1;
        s aaq = null;
        s aar = null;
        List<Object> aat = null;
        List<Object> aau = null;
        private int aav = 0;
        private l aaw = null;
        private boolean aax = false;
        private int aay = 0;
        RecyclerView aaz;
        int kB = -1;
        private int tM;

        static /* synthetic */ void r(s sVar) {
            sVar.aay = y.F(sVar.aal);
            y.h(sVar.aal, 4);
        }

        static /* synthetic */ void s(s sVar) {
            y.h(sVar.aal, sVar.aay);
            sVar.aay = 0;
        }

        static /* synthetic */ boolean t(s sVar) {
            return (sVar.tM & 16) == 0 && y.D(sVar.aal);
        }

        static /* synthetic */ boolean x(s sVar) {
            return (sVar.tM & 16) != 0;
        }

        public s(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.aal = view;
        }

        final void p(int i, boolean z) {
            if (this.aam == -1) {
                this.aam = this.kB;
            }
            if (this.aap == -1) {
                this.aap = this.kB;
            }
            if (z) {
                this.aap += i;
            }
            this.kB += i;
            if (this.aal.getLayoutParams() != null) {
                ((LayoutParams) this.aal.getLayoutParams()).Zz = true;
            }
        }

        final void ge() {
            this.aam = -1;
            this.aap = -1;
        }

        final boolean gf() {
            return (this.tM & FileUtils.S_IWUSR) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.aap == -1 ? this.kB : this.aap;
        }

        public final int gg() {
            return this.aap == -1 ? this.kB : this.aap;
        }

        public final int gh() {
            if (this.aaz == null) {
                return -1;
            }
            return this.aaz.h(this);
        }

        final boolean gi() {
            return this.aaw != null;
        }

        final void gj() {
            this.aaw.q(this);
        }

        final boolean gk() {
            return (this.tM & 32) != 0;
        }

        final void gl() {
            this.tM &= -33;
        }

        final void gm() {
            this.tM &= -257;
        }

        final void a(l lVar, boolean z) {
            this.aaw = lVar;
            this.aax = z;
        }

        final boolean gn() {
            return (this.tM & 4) != 0;
        }

        final boolean go() {
            return (this.tM & 2) != 0;
        }

        final boolean isBound() {
            return (this.tM & 1) != 0;
        }

        public final boolean isRemoved() {
            return (this.tM & 8) != 0;
        }

        final boolean bg(int i) {
            return (this.tM & i) != 0;
        }

        final boolean gp() {
            return (this.tM & FileUtils.S_IRUSR) != 0;
        }

        final void setFlags(int i, int i2) {
            this.tM = (this.tM & (i2 ^ -1)) | (i & i2);
        }

        final void addFlags(int i) {
            this.tM |= i;
        }

        final void R(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((this.tM & 1024) == 0) {
                if (this.aat == null) {
                    this.aat = new ArrayList();
                    this.aau = Collections.unmodifiableList(this.aat);
                }
                this.aat.add(obj);
            }
        }

        final void gq() {
            if (this.aat != null) {
                this.aat.clear();
            }
            this.tM &= -1025;
        }

        final List<Object> gr() {
            if ((this.tM & 1024) != 0) {
                return aas;
            }
            if (this.aat == null || this.aat.size() == 0) {
                return aas;
            }
            return this.aau;
        }

        final void gs() {
            this.tM = 0;
            this.kB = -1;
            this.aam = -1;
            this.aan = -1;
            this.aap = -1;
            this.aav = 0;
            this.aaq = null;
            this.aar = null;
            gq();
            this.aay = 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.kB + " id=" + this.aan + ", oldPos=" + this.aam + ", pLpos:" + this.aap);
            if (gi()) {
                stringBuilder.append(" scrap ").append(this.aax ? "[changeScrap]" : "[attachedScrap]");
            }
            if (gn()) {
                stringBuilder.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder.append(" unbound");
            }
            if (go()) {
                stringBuilder.append(" update");
            }
            if (isRemoved()) {
                stringBuilder.append(" removed");
            }
            if (gf()) {
                stringBuilder.append(" ignored");
            }
            if (gp()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!gt()) {
                stringBuilder.append(" not recyclable(" + this.aav + ")");
            }
            Object obj = ((this.tM & 512) != 0 || gn()) ? 1 : null;
            if (obj != null) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.aal.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public final void S(boolean z) {
            this.aav = z ? this.aav - 1 : this.aav + 1;
            if (this.aav < 0) {
                this.aav = 0;
                new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
            } else if (!z && this.aav == 1) {
                this.tM |= 16;
            } else if (z && this.aav == 0) {
                this.tM &= -17;
            }
        }

        public final boolean gt() {
            return (this.tM & 16) == 0 && !y.D(this.aal);
        }

        final boolean gu() {
            return (this.tM & 2) != 0;
        }
    }

    private class f implements a {
        final /* synthetic */ RecyclerView Zh;

        private f(RecyclerView recyclerView) {
            this.Zh = recyclerView;
        }

        public final void m(s sVar) {
            sVar.S(true);
            if (sVar.aaq != null && sVar.aar == null) {
                sVar.aaq = null;
            }
            sVar.aar = null;
            if (!s.x(sVar) && !RecyclerView.c(this.Zh, sVar.aal) && sVar.gp()) {
                this.Zh.removeDetachedView(sVar.aal, false);
            }
        }
    }

    private class n extends c {
        final /* synthetic */ RecyclerView Zh;

        private n(RecyclerView recyclerView) {
            this.Zh = recyclerView;
        }

        public final void onChanged() {
            this.Zh.q(null);
            boolean z = this.Zh.Yl.Zj;
            this.Zh.YS.aab = true;
            RecyclerView.n(this.Zh);
            if (!this.Zh.Yg.ey()) {
                this.Zh.requestLayout();
            }
        }

        public final void c(int i, int i2, Object obj) {
            Object obj2 = 1;
            this.Zh.q(null);
            e eVar = this.Zh.Yg;
            eVar.Ti.add(eVar.a(4, i, i2, obj));
            eVar.To |= 4;
            if (eVar.Ti.size() != 1) {
                obj2 = null;
            }
            if (obj2 != null) {
                ga();
            }
        }

        public final void S(int i, int i2) {
            int i3 = 1;
            this.Zh.q(null);
            e eVar = this.Zh.Yg;
            eVar.Ti.add(eVar.a(1, i, i2, null));
            eVar.To |= 1;
            if (eVar.Ti.size() != 1) {
                i3 = 0;
            }
            if (i3 != 0) {
                ga();
            }
        }

        public final void T(int i, int i2) {
            Object obj = 1;
            this.Zh.q(null);
            e eVar = this.Zh.Yg;
            eVar.Ti.add(eVar.a(2, i, i2, null));
            eVar.To |= 2;
            if (eVar.Ti.size() != 1) {
                obj = null;
            }
            if (obj != null) {
                ga();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void U(int r6, int r7) {
            /*
            r5 = this;
            r4 = 0;
            r0 = 1;
            r1 = r5.Zh;
            r1.q(r4);
            r1 = r5.Zh;
            r1 = r1.Yg;
            if (r6 == r7) goto L_0x002c;
        L_0x000d:
            r2 = r1.Ti;
            r3 = 8;
            r3 = r1.a(r3, r6, r7, r4);
            r2.add(r3);
            r2 = r1.To;
            r2 = r2 | 8;
            r1.To = r2;
            r1 = r1.Ti;
            r1 = r1.size();
            if (r1 != r0) goto L_0x002c;
        L_0x0026:
            if (r0 == 0) goto L_0x002b;
        L_0x0028:
            r5.ga();
        L_0x002b:
            return;
        L_0x002c:
            r0 = 0;
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.n.U(int, int):void");
        }

        private void ga() {
            if (this.Zh.YA && this.Zh.Ys && this.Zh.Yr) {
                y.a(this.Zh, this.Zh.Yk);
                return;
            }
            this.Zh.Yz = true;
            this.Zh.requestLayout();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, s sVar, b bVar, b bVar2) {
        recyclerView.f(sVar);
        sVar.S(false);
        if (recyclerView.YI.d(sVar, bVar, bVar2)) {
            recyclerView.fG();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        aY(view);
        if (recyclerView.YB != null) {
            for (int size = recyclerView.YB.size() - 1; size >= 0; size--) {
                recyclerView.YB.get(size);
            }
        }
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, s sVar) {
        return recyclerView.YI == null || recyclerView.YI.a(sVar, sVar.gr());
    }

    static /* synthetic */ void b(RecyclerView recyclerView, s sVar, b bVar, b bVar2) {
        sVar.S(false);
        if (recyclerView.YI.e(sVar, bVar, bVar2)) {
            recyclerView.fG();
        }
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        boolean z;
        boolean z2 = true;
        recyclerView.fs();
        s sVar = recyclerView.Yh;
        int indexOfChild = sVar.UR.indexOfChild(view);
        if (indexOfChild == -1) {
            sVar.aN(view);
            z = true;
        } else if (sVar.US.get(indexOfChild)) {
            sVar.US.aM(indexOfChild);
            sVar.aN(view);
            sVar.UR.removeViewAt(indexOfChild);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            s aY = aY(view);
            recyclerView.Ye.q(aY);
            recyclerView.Ye.o(aY);
        }
        if (z) {
            z2 = false;
        }
        recyclerView.R(z2);
        return z;
    }

    static /* synthetic */ void d(RecyclerView recyclerView, int i) {
        if (recyclerView.Ym != null) {
            recyclerView.Ym.aT(i);
            recyclerView.awakenScrollBars();
        }
    }

    static /* synthetic */ void n(RecyclerView recyclerView) {
        if (!recyclerView.YC) {
            int i;
            recyclerView.YC = true;
            int eK = recyclerView.Yh.eK();
            for (i = 0; i < eK; i++) {
                s aY = aY(recyclerView.Yh.aL(i));
                if (!(aY == null || aY.gf())) {
                    aY.addFlags(512);
                }
            }
            l lVar = recyclerView.Ye;
            int size = lVar.ZG.size();
            for (i = 0; i < size; i++) {
                s sVar = (s) lVar.ZG.get(i);
                if (sVar != null) {
                    sVar.addFlags(512);
                }
            }
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        Ya = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        Yb = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.Yd = new n();
        this.Ye = new l(this);
        this.Yi = new ar();
        this.Yk = new Runnable(this) {
            final /* synthetic */ RecyclerView Zh;

            {
                this.Zh = r1;
            }

            public final void run() {
                if (this.Zh.Yt && !this.Zh.isLayoutRequested()) {
                    if (this.Zh.Yw) {
                        this.Zh.Yv = true;
                    } else {
                        this.Zh.fr();
                    }
                }
            }
        };
        this.ep = new Rect();
        this.Yo = new ArrayList();
        this.Yp = new ArrayList();
        this.Yu = 0;
        this.YC = false;
        this.YD = 0;
        this.YI = new v();
        this.xe = 0;
        this.YJ = -1;
        this.YQ = Float.MIN_VALUE;
        this.YR = new r(this);
        this.YS = new p();
        this.YV = false;
        this.YW = false;
        this.YX = new f();
        this.YY = false;
        this.Zb = new int[2];
        this.Cn = new int[2];
        this.Co = new int[2];
        this.Zd = new int[2];
        this.Ze = new Runnable(this) {
            final /* synthetic */ RecyclerView Zh;

            {
                this.Zh = r1;
            }

            public final void run() {
                if (this.Zh.YI != null) {
                    this.Zh.YI.eN();
                }
                this.Zh.YY = false;
            }
        };
        this.Zg = new b(this) {
            final /* synthetic */ RecyclerView Zh;

            {
                this.Zh = r1;
            }

            public final void a(s sVar, b bVar, b bVar2) {
                this.Zh.Ye.q(sVar);
                RecyclerView.a(this.Zh, sVar, bVar, bVar2);
            }

            public final void b(s sVar, b bVar, b bVar2) {
                RecyclerView.b(this.Zh, sVar, bVar, bVar2);
            }

            public final void c(s sVar, b bVar, b bVar2) {
                sVar.S(false);
                if (this.Zh.YC) {
                    if (this.Zh.YI.a(sVar, sVar, bVar, bVar2)) {
                        this.Zh.fG();
                    }
                } else if (this.Zh.YI.f(sVar, bVar, bVar2)) {
                    this.Zh.fG();
                }
            }

            public final void i(s sVar) {
                this.Zh.Ym.a(sVar.aal, this.Zh.Ye);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.YA = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.iD = viewConfiguration.getScaledTouchSlop();
        this.YO = viewConfiguration.getScaledMinimumFlingVelocity();
        this.YP = viewConfiguration.getScaledMaximumFlingVelocity();
        if (y.B(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.YI.Zk = this.YX;
        this.Yg = new e(new a(this) {
            final /* synthetic */ RecyclerView Zh;

            {
                this.Zh = r1;
            }

            public final s aH(int i) {
                s aY;
                RecyclerView recyclerView = this.Zh;
                int eK = recyclerView.Yh.eK();
                for (int i2 = 0; i2 < eK; i2++) {
                    aY = RecyclerView.aY(recyclerView.Yh.aL(i2));
                    if (aY != null && !aY.isRemoved() && aY.kB == i) {
                        break;
                    }
                }
                aY = null;
                if (aY == null || this.Zh.Yh.aO(aY.aal)) {
                    return null;
                }
                return aY;
            }

            public final void t(int i, int i2) {
                this.Zh.d(i, i2, true);
                this.Zh.YV = true;
                p pVar = this.Zh.YS;
                pVar.aaa += i2;
            }

            public final void u(int i, int i2) {
                this.Zh.d(i, i2, false);
                this.Zh.YV = true;
            }

            public final void a(int i, int i2, Object obj) {
                int i3;
                RecyclerView recyclerView = this.Zh;
                int eK = recyclerView.Yh.eK();
                int i4 = i + i2;
                for (i3 = 0; i3 < eK; i3++) {
                    View aL = recyclerView.Yh.aL(i3);
                    s aY = RecyclerView.aY(aL);
                    if (aY != null && !aY.gf() && aY.kB >= i && aY.kB < i4) {
                        aY.addFlags(2);
                        aY.R(obj);
                        ((LayoutParams) aL.getLayoutParams()).Zz = true;
                    }
                }
                l lVar = recyclerView.Ye;
                eK = i + i2;
                for (i3 = lVar.ZG.size() - 1; i3 >= 0; i3--) {
                    s sVar = (s) lVar.ZG.get(i3);
                    if (sVar != null) {
                        i4 = sVar.gg();
                        if (i4 >= i && i4 < eK) {
                            sVar.addFlags(2);
                            lVar.bd(i3);
                        }
                    }
                }
                this.Zh.YW = true;
            }

            public final void d(b bVar) {
                f(bVar);
            }

            private void f(b bVar) {
                switch (bVar.of) {
                    case 1:
                        this.Zh.Ym.y(bVar.Tp, bVar.Tr);
                        return;
                    case 2:
                        this.Zh.Ym.z(bVar.Tp, bVar.Tr);
                        return;
                    case 4:
                        this.Zh.Ym.A(bVar.Tp, bVar.Tr);
                        return;
                    case 8:
                        this.Zh.Ym.B(bVar.Tp, bVar.Tr);
                        return;
                    default:
                        return;
                }
            }

            public final void e(b bVar) {
                f(bVar);
            }

            public final void v(int i, int i2) {
                int i3;
                RecyclerView recyclerView = this.Zh;
                int eK = recyclerView.Yh.eK();
                for (i3 = 0; i3 < eK; i3++) {
                    s aY = RecyclerView.aY(recyclerView.Yh.aL(i3));
                    if (!(aY == null || aY.gf() || aY.kB < i)) {
                        aY.p(i2, false);
                        recyclerView.YS.aab = true;
                    }
                }
                l lVar = recyclerView.Ye;
                int size = lVar.ZG.size();
                for (i3 = 0; i3 < size; i3++) {
                    s sVar = (s) lVar.ZG.get(i3);
                    if (sVar != null && sVar.kB >= i) {
                        sVar.p(i2, true);
                    }
                }
                recyclerView.requestLayout();
                this.Zh.YV = true;
            }

            public final void w(int i, int i2) {
                int i3;
                int i4;
                int i5;
                int i6;
                int i7 = -1;
                RecyclerView recyclerView = this.Zh;
                int eK = recyclerView.Yh.eK();
                if (i < i2) {
                    i3 = -1;
                    i4 = i2;
                    i5 = i;
                } else {
                    i3 = 1;
                    i4 = i;
                    i5 = i2;
                }
                for (i6 = 0; i6 < eK; i6++) {
                    s aY = RecyclerView.aY(recyclerView.Yh.aL(i6));
                    if (aY != null && aY.kB >= r4 && aY.kB <= r3) {
                        if (aY.kB == i) {
                            aY.p(i2 - i, false);
                        } else {
                            aY.p(i3, false);
                        }
                        recyclerView.YS.aab = true;
                    }
                }
                l lVar = recyclerView.Ye;
                if (i < i2) {
                    i4 = i2;
                    i5 = i;
                } else {
                    i7 = 1;
                    i4 = i;
                    i5 = i2;
                }
                int size = lVar.ZG.size();
                for (i6 = 0; i6 < size; i6++) {
                    s sVar = (s) lVar.ZG.get(i6);
                    if (sVar != null && sVar.kB >= r4 && sVar.kB <= r3) {
                        if (sVar.kB == i) {
                            sVar.p(i2 - i, false);
                        } else {
                            sVar.p(i7, false);
                        }
                    }
                }
                recyclerView.requestLayout();
                this.Zh.YV = true;
            }
        });
        this.Yh = new s(new b(this) {
            final /* synthetic */ RecyclerView Zh;

            {
                this.Zh = r1;
            }

            public final int getChildCount() {
                return this.Zh.getChildCount();
            }

            public final void addView(View view, int i) {
                this.Zh.addView(view, i);
                RecyclerView.a(this.Zh, view);
            }

            public final int indexOfChild(View view) {
                return this.Zh.indexOfChild(view);
            }

            public final void removeViewAt(int i) {
                View childAt = this.Zh.getChildAt(i);
                if (childAt != null) {
                    this.Zh.bc(childAt);
                }
                this.Zh.removeViewAt(i);
            }

            public final View getChildAt(int i) {
                return this.Zh.getChildAt(i);
            }

            public final void removeAllViews() {
                int childCount = this.Zh.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    this.Zh.bc(getChildAt(i));
                }
                this.Zh.removeAllViews();
            }

            public final s aP(View view) {
                return RecyclerView.aY(view);
            }

            public final void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
                s aY = RecyclerView.aY(view);
                if (aY != null) {
                    if (aY.gp() || aY.gf()) {
                        aY.gm();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + aY);
                    }
                }
                this.Zh.attachViewToParent(view, i, layoutParams);
            }

            public final void detachViewFromParent(int i) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    s aY = RecyclerView.aY(childAt);
                    if (aY != null) {
                        if (!aY.gp() || aY.gf()) {
                            aY.addFlags(FileUtils.S_IRUSR);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + aY);
                        }
                    }
                }
                this.Zh.detachViewFromParent(i);
            }

            public final void aQ(View view) {
                s aY = RecyclerView.aY(view);
                if (aY != null) {
                    s.r(aY);
                }
            }

            public final void aR(View view) {
                s aY = RecyclerView.aY(view);
                if (aY != null) {
                    s.s(aY);
                }
            }
        });
        if (y.F(this) == 0) {
            y.h(this, 1);
        }
        this.jk = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.YZ = new ac(this);
        y.a((View) this, this.YZ);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.d.a.a.cB, i, 0);
            String string = obtainStyledAttributes.getString(android.support.v7.d.a.a.NE);
            obtainStyledAttributes.recycle();
            if (string != null) {
                String trim = string.trim();
                if (trim.length() != 0) {
                    string = trim.charAt(0) == '.' ? context.getPackageName() + trim : trim.contains(".") ? trim : RecyclerView.class.getPackage().getName() + '.' + trim;
                    try {
                        Object[] objArr;
                        Constructor constructor;
                        Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(string).asSubclass(h.class);
                        try {
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                            constructor = asSubclass.getConstructor(Yc);
                        } catch (Throwable e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        a((h) constructor.newInstance(objArr));
                    } catch (Throwable e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + string, e2);
                    } catch (Throwable e3) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + string, e3);
                    } catch (Throwable e32) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e32);
                    } catch (Throwable e322) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e322);
                    } catch (Throwable e3222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + string, e3222);
                    } catch (Throwable e32222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + string, e32222);
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, XZ, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z2);
    }

    public void setClipToPadding(boolean z) {
        if (z != this.Yj) {
            fz();
        }
        this.Yj = z;
        super.setClipToPadding(z);
        if (this.Yt) {
            requestLayout();
        }
    }

    public void a(a aVar) {
        if (this.Yw) {
            q("Do not setLayoutFrozen in layout or scroll");
            this.Yw = false;
            if (!(!this.Yv || this.Ym == null || this.Yl == null)) {
                requestLayout();
            }
            this.Yv = false;
        }
        if (this.Yl != null) {
            this.Yl.b(this.Yd);
        }
        if (this.YI != null) {
            this.YI.eP();
        }
        if (this.Ym != null) {
            this.Ym.d(this.Ye);
            this.Ym.c(this.Ye);
        }
        this.Ye.clear();
        this.Yg.reset();
        a aVar2 = this.Yl;
        this.Yl = aVar;
        if (aVar != null) {
            aVar.a(this.Yd);
        }
        l lVar = this.Ye;
        a aVar3 = this.Yl;
        lVar.clear();
        k fZ = lVar.fZ();
        if (aVar2 != null) {
            fZ.ZD--;
        }
        if (fZ.ZD == 0) {
            fZ.ZB.clear();
        }
        if (aVar3 != null) {
            fZ.ZD++;
        }
        this.YS.aab = true;
        fO();
        requestLayout();
    }

    public int getBaseline() {
        if (this.Ym != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void a(h hVar) {
        if (hVar != this.Ym) {
            ft();
            if (this.Ym != null) {
                if (this.Yr) {
                    this.Ym.b(this, this.Ye);
                }
                this.Ym.y(null);
            }
            this.Ye.clear();
            s sVar = this.Yh;
            a aVar = sVar.US;
            while (true) {
                aVar.UU = 0;
                if (aVar.UV == null) {
                    break;
                }
                aVar = aVar.UV;
            }
            for (int size = sVar.UT.size() - 1; size >= 0; size--) {
                sVar.UR.aR((View) sVar.UT.get(size));
                sVar.UT.remove(size);
            }
            sVar.UR.removeAllViews();
            this.Ym = hVar;
            if (hVar != null) {
                if (hVar.Zq != null) {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView: " + hVar.Zq);
                }
                this.Ym.y(this);
                if (this.Yr) {
                    this.Ym.hh = true;
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.Yf != null) {
            savedState.ZL = this.Yf.ZL;
        } else if (this.Ym != null) {
            savedState.ZL = this.Ym.onSaveInstanceState();
        } else {
            savedState.ZL = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.Yf = (SavedState) parcelable;
            super.onRestoreInstanceState(this.Yf.getSuperState());
            if (this.Ym != null && this.Yf.ZL != null) {
                this.Ym.onRestoreInstanceState(this.Yf.ZL);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void f(s sVar) {
        View view = sVar.aal;
        boolean z = view.getParent() == this;
        this.Ye.q(aP(view));
        if (sVar.gp()) {
            this.Yh.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            s sVar2 = this.Yh;
            int indexOfChild = sVar2.UR.indexOfChild(view);
            if (indexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            sVar2.US.set(indexOfChild);
            sVar2.aM(view);
        } else {
            this.Yh.a(view, -1, true);
        }
    }

    private void Y(int i) {
        if (i != this.xe) {
            this.xe = i;
            if (i != 2) {
                fu();
            }
            if (this.Ym != null) {
                this.Ym.ba(i);
            }
            if (this.YT != null) {
                this.YT.e(this, i);
            }
            if (this.YU != null) {
                for (int size = this.YU.size() - 1; size >= 0; size--) {
                    ((j) this.YU.get(size)).e(this, i);
                }
            }
        }
    }

    public final void a(g gVar) {
        if (this.Ym != null) {
            this.Ym.q("Cannot add item decoration during a scroll  or layout");
        }
        if (this.Yo.isEmpty()) {
            setWillNotDraw(false);
        }
        this.Yo.add(gVar);
        fM();
        requestLayout();
    }

    public final void a(j jVar) {
        if (this.YU == null) {
            this.YU = new ArrayList();
        }
        this.YU.add(jVar);
    }

    public void aT(int i) {
        if (!this.Yw) {
            ft();
            if (this.Ym != null) {
                this.Ym.aT(i);
                awakenScrollBars();
            }
        }
    }

    public void scrollTo(int i, int i2) {
    }

    public void scrollBy(int i, int i2) {
        if (this.Ym != null && !this.Yw) {
            boolean eV = this.Ym.eV();
            boolean eW = this.Ym.eW();
            if (eV || eW) {
                if (!eV) {
                    i = 0;
                }
                if (!eW) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    private void fr() {
        boolean z = false;
        if (!this.Yt) {
            return;
        }
        if (this.YC) {
            android.support.v4.os.e.beginSection("RV FullInvalidate");
            fJ();
            android.support.v4.os.e.endSection();
        } else if (!this.Yg.ey()) {
        } else {
            if (this.Yg.aF(4) && !this.Yg.aF(11)) {
                android.support.v4.os.e.beginSection("RV PartialInvalidate");
                fs();
                this.Yg.ew();
                if (!this.Yv) {
                    int childCount = this.Yh.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        s aY = aY(this.Yh.getChildAt(i));
                        if (aY != null && !aY.gf() && aY.gu()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        fJ();
                    } else {
                        this.Yg.ex();
                    }
                }
                R(true);
                android.support.v4.os.e.endSection();
            } else if (this.Yg.ey()) {
                android.support.v4.os.e.beginSection("RV FullInvalidate");
                fJ();
                android.support.v4.os.e.endSection();
            }
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        fr();
        if (this.Yl != null) {
            fs();
            fC();
            android.support.v4.os.e.beginSection("RV Scroll");
            if (i != 0) {
                i5 = this.Ym.a(i, this.Ye, this.YS);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.Ym.b(i2, this.Ye, this.YS);
                i4 = i2 - i6;
            }
            android.support.v4.os.e.endSection();
            fP();
            fD();
            R(false);
        }
        int i7 = i4;
        i4 = i5;
        i5 = i6;
        if (!this.Yo.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i5, i3, i7, this.Cn)) {
            this.YM -= this.Cn[0];
            this.YN -= this.Cn[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.Cn[0], (float) this.Cn[1]);
            }
            int[] iArr = this.Zd;
            iArr[0] = iArr[0] + this.Cn[0];
            iArr = this.Zd;
            iArr[1] = iArr[1] + this.Cn[1];
        } else if (y.B(this) != 2) {
            if (motionEvent != null) {
                float x = motionEvent.getX();
                float f = (float) i3;
                float y = motionEvent.getY();
                float f2 = (float) i7;
                Object obj = null;
                if (f < 0.0f) {
                    fv();
                    if (this.YE.h((-f) / ((float) getWidth()), 1.0f - (y / ((float) getHeight())))) {
                        obj = 1;
                    }
                } else if (f > 0.0f) {
                    fw();
                    if (this.YG.h(f / ((float) getWidth()), y / ((float) getHeight()))) {
                        obj = 1;
                    }
                }
                if (f2 < 0.0f) {
                    fx();
                    if (this.YF.h((-f2) / ((float) getHeight()), x / ((float) getWidth()))) {
                        obj = 1;
                    }
                } else if (f2 > 0.0f) {
                    fy();
                    if (this.YH.h(f2 / ((float) getHeight()), 1.0f - (x / ((float) getWidth())))) {
                        obj = 1;
                    }
                }
                if (!(obj == null && f == 0.0f && f2 == 0.0f)) {
                    y.E(this);
                }
            }
            L(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            N(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.Ym != null && this.Ym.eV()) {
            return this.Ym.b(this.YS);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.Ym != null && this.Ym.eV()) {
            return this.Ym.d(this.YS);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.Ym != null && this.Ym.eV()) {
            return this.Ym.f(this.YS);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.Ym != null && this.Ym.eW()) {
            return this.Ym.c(this.YS);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.Ym != null && this.Ym.eW()) {
            return this.Ym.e(this.YS);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.Ym != null && this.Ym.eW()) {
            return this.Ym.g(this.YS);
        }
        return 0;
    }

    final void fs() {
        this.Yu++;
        if (this.Yu == 1 && !this.Yw) {
            this.Yv = false;
        }
    }

    final void R(boolean z) {
        if (this.Yu <= 0) {
            this.Yu = 1;
        }
        if (!z) {
            this.Yv = false;
        }
        if (this.Yu == 1) {
            if (!(!z || !this.Yv || this.Yw || this.Ym == null || this.Yl == null)) {
                fJ();
            }
            if (!this.Yw) {
                this.Yv = false;
            }
        }
        this.Yu--;
    }

    private void ft() {
        Y(0);
        fu();
    }

    private void fu() {
        this.YR.stop();
        if (this.Ym != null) {
            this.Ym.fW();
        }
    }

    private void L(int i, int i2) {
        int i3 = 0;
        if (!(this.YE == null || this.YE.isFinished() || i <= 0)) {
            i3 = this.YE.cv();
        }
        if (!(this.YG == null || this.YG.isFinished() || i >= 0)) {
            i3 |= this.YG.cv();
        }
        if (!(this.YF == null || this.YF.isFinished() || i2 <= 0)) {
            i3 |= this.YF.cv();
        }
        if (!(this.YH == null || this.YH.isFinished() || i2 >= 0)) {
            i3 |= this.YH.cv();
        }
        if (i3 != 0) {
            y.E(this);
        }
    }

    final void fv() {
        if (this.YE == null) {
            this.YE = new android.support.v4.widget.i(getContext());
            if (this.Yj) {
                this.YE.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.YE.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void fw() {
        if (this.YG == null) {
            this.YG = new android.support.v4.widget.i(getContext());
            if (this.Yj) {
                this.YG.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.YG.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void fx() {
        if (this.YF == null) {
            this.YF = new android.support.v4.widget.i(getContext());
            if (this.Yj) {
                this.YF.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.YF.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    final void fy() {
        if (this.YH == null) {
            this.YH = new android.support.v4.widget.i(getContext());
            if (this.Yj) {
                this.YH.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.YH.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void fz() {
        this.YH = null;
        this.YF = null;
        this.YG = null;
        this.YE = null;
    }

    public View focusSearch(View view, int i) {
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(findNextFocus != null || this.Yl == null || this.Ym == null || fF() || this.Yw)) {
            fs();
            findNextFocus = this.Ym.a(view, i, this.Ye, this.YS);
            R(false);
        }
        return findNextFocus != null ? findNextFocus : super.focusSearch(view, i);
    }

    public void requestChildFocus(View view, View view2) {
        int i = (this.Ym.fV() || fF()) ? 1 : 0;
        if (i == 0 && view2 != null) {
            this.ep.set(0, 0, view2.getWidth(), view2.getHeight());
            android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.Zz) {
                    Rect rect = layoutParams2.VS;
                    Rect rect2 = this.ep;
                    rect2.left -= rect.left;
                    rect2 = this.ep;
                    rect2.right += rect.right;
                    rect2 = this.ep;
                    rect2.top -= rect.top;
                    rect2 = this.ep;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.ep);
            offsetRectIntoDescendantCoords(view, this.ep);
            requestChildRectangleOnScreen(view, this.ep, !this.Yt);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        h hVar = this.Ym;
        int paddingLeft = hVar.getPaddingLeft();
        int paddingTop = hVar.getPaddingTop();
        int paddingRight = hVar.Zx - hVar.getPaddingRight();
        int paddingBottom = hVar.QW - hVar.getPaddingBottom();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - paddingLeft);
        int min2 = Math.min(0, top - paddingTop);
        int max = Math.max(0, width - paddingRight);
        paddingBottom = Math.max(0, height - paddingBottom);
        if (y.I(hVar.Zq) != 1) {
            max = min != 0 ? min : Math.min(left - paddingLeft, max);
        } else if (max == 0) {
            max = Math.max(min, width - paddingRight);
        }
        min = min2 != 0 ? min2 : Math.min(top - paddingTop, paddingBottom);
        if (max == 0 && min == 0) {
            return false;
        }
        if (z) {
            scrollBy(max, min);
        } else if (!(this.Ym == null || this.Yw)) {
            if (!this.Ym.eV()) {
                max = 0;
            }
            if (!this.Ym.eW()) {
                min = 0;
            }
            if (!(max == 0 && min == 0)) {
                this.YR.smoothScrollBy(max, min);
            }
        }
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.YD = 0;
        this.Yr = true;
        this.Yt = false;
        if (this.Ym != null) {
            this.Ym.hh = true;
        }
        this.YY = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.YI != null) {
            this.YI.eP();
        }
        this.Yt = false;
        ft();
        this.Yr = false;
        if (this.Ym != null) {
            this.Ym.b(this, this.Ye);
        }
        removeCallbacks(this.Ze);
        a.hg();
    }

    public boolean isAttachedToWindow() {
        return this.Yr;
    }

    final void q(String str) {
        if (!fF()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (this.Yw) {
            return false;
        }
        int i2;
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.Yq = null;
        }
        int size = this.Yp.size();
        for (i2 = 0; i2 < size; i2++) {
            i iVar = (i) this.Yp.get(i2);
            if (iVar.fX() && action != 3) {
                this.Yq = iVar;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            fB();
            return true;
        } else if (this.Ym == null) {
            return false;
        } else {
            z = this.Ym.eV();
            boolean eW = this.Ym.eW();
            if (this.fj == null) {
                this.fj = VelocityTracker.obtain();
            }
            this.fj.addMovement(motionEvent);
            action = android.support.v4.view.n.d(motionEvent);
            size = android.support.v4.view.n.e(motionEvent);
            int i3;
            switch (action) {
                case 0:
                    if (this.Yx) {
                        this.Yx = false;
                    }
                    this.YJ = android.support.v4.view.n.c(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.YM = i;
                    this.YK = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.YN = i;
                    this.YL = i;
                    if (this.xe == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        Y(1);
                    }
                    int[] iArr = this.Zd;
                    this.Zd[1] = 0;
                    iArr[0] = 0;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (eW) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.fj.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    action = android.support.v4.view.n.b(motionEvent, this.YJ);
                    if (action >= 0) {
                        size = (int) (android.support.v4.view.n.d(motionEvent, action) + 0.5f);
                        action = (int) (android.support.v4.view.n.e(motionEvent, action) + 0.5f);
                        if (this.xe != 1) {
                            size -= this.YK;
                            action -= this.YL;
                            if (!z || Math.abs(size) <= this.iD) {
                                z = false;
                            } else {
                                this.YM = ((size < 0 ? -1 : 1) * this.iD) + this.YK;
                                z = true;
                            }
                            if (eW && Math.abs(action) > this.iD) {
                                i3 = this.YL;
                                i2 = this.iD;
                                if (action >= 0) {
                                    i = 1;
                                }
                                this.YN = i3 + (i * i2);
                                z = true;
                            }
                            if (z) {
                                Y(1);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.YJ).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    fB();
                    break;
                case 5:
                    this.YJ = android.support.v4.view.n.c(motionEvent, size);
                    i3 = (int) (android.support.v4.view.n.d(motionEvent, size) + 0.5f);
                    this.YM = i3;
                    this.YK = i3;
                    i3 = (int) (android.support.v4.view.n.e(motionEvent, size) + 0.5f);
                    this.YN = i3;
                    this.YL = i3;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (this.xe != 1) {
                return false;
            }
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.Yp.size();
        for (int i = 0; i < size; i++) {
            this.Yp.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
        r12 = this;
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r2 = 0;
        r11 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r8 = 1;
        r1 = 0;
        r0 = r12.Yw;
        if (r0 != 0) goto L_0x000f;
    L_0x000b:
        r0 = r12.Yx;
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r13.getAction();
        r3 = r12.Yq;
        if (r3 == 0) goto L_0x001d;
    L_0x0018:
        if (r0 != 0) goto L_0x0040;
    L_0x001a:
        r3 = 0;
        r12.Yq = r3;
    L_0x001d:
        if (r0 == 0) goto L_0x004e;
    L_0x001f:
        r0 = r12.Yp;
        r5 = r0.size();
        r3 = r1;
    L_0x0026:
        if (r3 >= r5) goto L_0x004e;
    L_0x0028:
        r0 = r12.Yp;
        r0 = r0.get(r3);
        r0 = (android.support.v7.widget.RecyclerView.i) r0;
        r6 = r0.fX();
        if (r6 == 0) goto L_0x004a;
    L_0x0036:
        r12.Yq = r0;
        r0 = r8;
    L_0x0039:
        if (r0 == 0) goto L_0x0050;
    L_0x003b:
        r12.fB();
        r1 = r8;
        goto L_0x000f;
    L_0x0040:
        r3 = 3;
        if (r0 == r3) goto L_0x0045;
    L_0x0043:
        if (r0 != r8) goto L_0x0048;
    L_0x0045:
        r0 = 0;
        r12.Yq = r0;
    L_0x0048:
        r0 = r8;
        goto L_0x0039;
    L_0x004a:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0026;
    L_0x004e:
        r0 = r1;
        goto L_0x0039;
    L_0x0050:
        r0 = r12.Ym;
        if (r0 == 0) goto L_0x000f;
    L_0x0054:
        r0 = r12.Ym;
        r5 = r0.eV();
        r0 = r12.Ym;
        r6 = r0.eW();
        r0 = r12.fj;
        if (r0 != 0) goto L_0x006a;
    L_0x0064:
        r0 = android.view.VelocityTracker.obtain();
        r12.fj = r0;
    L_0x006a:
        r9 = android.view.MotionEvent.obtain(r13);
        r0 = android.support.v4.view.n.d(r13);
        r3 = android.support.v4.view.n.e(r13);
        if (r0 != 0) goto L_0x0080;
    L_0x0078:
        r7 = r12.Zd;
        r10 = r12.Zd;
        r10[r8] = r1;
        r7[r1] = r1;
    L_0x0080:
        r7 = r12.Zd;
        r7 = r7[r1];
        r7 = (float) r7;
        r10 = r12.Zd;
        r10 = r10[r8];
        r10 = (float) r10;
        r9.offsetLocation(r7, r10);
        switch(r0) {
            case 0: goto L_0x009d;
            case 1: goto L_0x01a6;
            case 2: goto L_0x00dd;
            case 3: goto L_0x0263;
            case 4: goto L_0x0090;
            case 5: goto L_0x00c2;
            case 6: goto L_0x01a1;
            default: goto L_0x0090;
        };
    L_0x0090:
        if (r1 != 0) goto L_0x0097;
    L_0x0092:
        r0 = r12.fj;
        r0.addMovement(r9);
    L_0x0097:
        r9.recycle();
        r1 = r8;
        goto L_0x000f;
    L_0x009d:
        r0 = android.support.v4.view.n.c(r13, r1);
        r12.YJ = r0;
        r0 = r13.getX();
        r0 = r0 + r11;
        r0 = (int) r0;
        r12.YM = r0;
        r12.YK = r0;
        r0 = r13.getY();
        r0 = r0 + r11;
        r0 = (int) r0;
        r12.YN = r0;
        r12.YL = r0;
        if (r5 == 0) goto L_0x026d;
    L_0x00b9:
        r0 = r8;
    L_0x00ba:
        if (r6 == 0) goto L_0x00be;
    L_0x00bc:
        r0 = r0 | 2;
    L_0x00be:
        r12.startNestedScroll(r0);
        goto L_0x0090;
    L_0x00c2:
        r0 = android.support.v4.view.n.c(r13, r3);
        r12.YJ = r0;
        r0 = android.support.v4.view.n.d(r13, r3);
        r0 = r0 + r11;
        r0 = (int) r0;
        r12.YM = r0;
        r12.YK = r0;
        r0 = android.support.v4.view.n.e(r13, r3);
        r0 = r0 + r11;
        r0 = (int) r0;
        r12.YN = r0;
        r12.YL = r0;
        goto L_0x0090;
    L_0x00dd:
        r0 = r12.YJ;
        r0 = android.support.v4.view.n.b(r13, r0);
        if (r0 >= 0) goto L_0x00fb;
    L_0x00e5:
        r0 = new java.lang.StringBuilder;
        r2 = "Error processing scroll; pointer index for id ";
        r0.<init>(r2);
        r2 = r12.YJ;
        r0 = r0.append(r2);
        r2 = " not found. Did any MotionEvents get skipped?";
        r0.append(r2);
        goto L_0x000f;
    L_0x00fb:
        r2 = android.support.v4.view.n.d(r13, r0);
        r2 = r2 + r11;
        r4 = (int) r2;
        r0 = android.support.v4.view.n.e(r13, r0);
        r0 = r0 + r11;
        r7 = (int) r0;
        r0 = r12.YM;
        r2 = r0 - r4;
        r0 = r12.YN;
        r0 = r0 - r7;
        r3 = r12.Co;
        r10 = r12.Cn;
        r3 = r12.dispatchNestedPreScroll(r2, r0, r3, r10);
        if (r3 == 0) goto L_0x0145;
    L_0x0118:
        r3 = r12.Co;
        r3 = r3[r1];
        r2 = r2 - r3;
        r3 = r12.Co;
        r3 = r3[r8];
        r0 = r0 - r3;
        r3 = r12.Cn;
        r3 = r3[r1];
        r3 = (float) r3;
        r10 = r12.Cn;
        r10 = r10[r8];
        r10 = (float) r10;
        r9.offsetLocation(r3, r10);
        r3 = r12.Zd;
        r10 = r3[r1];
        r11 = r12.Cn;
        r11 = r11[r1];
        r10 = r10 + r11;
        r3[r1] = r10;
        r3 = r12.Zd;
        r10 = r3[r8];
        r11 = r12.Cn;
        r11 = r11[r8];
        r10 = r10 + r11;
        r3[r8] = r10;
    L_0x0145:
        r3 = r12.xe;
        if (r3 == r8) goto L_0x016e;
    L_0x0149:
        if (r5 == 0) goto L_0x026a;
    L_0x014b:
        r3 = java.lang.Math.abs(r2);
        r10 = r12.iD;
        if (r3 <= r10) goto L_0x026a;
    L_0x0153:
        if (r2 <= 0) goto L_0x0195;
    L_0x0155:
        r3 = r12.iD;
        r2 = r2 - r3;
    L_0x0158:
        r3 = r8;
    L_0x0159:
        if (r6 == 0) goto L_0x0169;
    L_0x015b:
        r10 = java.lang.Math.abs(r0);
        r11 = r12.iD;
        if (r10 <= r11) goto L_0x0169;
    L_0x0163:
        if (r0 <= 0) goto L_0x0199;
    L_0x0165:
        r3 = r12.iD;
        r0 = r0 - r3;
    L_0x0168:
        r3 = r8;
    L_0x0169:
        if (r3 == 0) goto L_0x016e;
    L_0x016b:
        r12.Y(r8);
    L_0x016e:
        r3 = r12.xe;
        if (r3 != r8) goto L_0x0090;
    L_0x0172:
        r3 = r12.Cn;
        r3 = r3[r1];
        r3 = r4 - r3;
        r12.YM = r3;
        r3 = r12.Cn;
        r3 = r3[r8];
        r3 = r7 - r3;
        r12.YN = r3;
        if (r5 == 0) goto L_0x019d;
    L_0x0184:
        if (r6 == 0) goto L_0x019f;
    L_0x0186:
        r0 = r12.a(r2, r0, r9);
        if (r0 == 0) goto L_0x0090;
    L_0x018c:
        r0 = r12.getParent();
        r0.requestDisallowInterceptTouchEvent(r8);
        goto L_0x0090;
    L_0x0195:
        r3 = r12.iD;
        r2 = r2 + r3;
        goto L_0x0158;
    L_0x0199:
        r3 = r12.iD;
        r0 = r0 + r3;
        goto L_0x0168;
    L_0x019d:
        r2 = r1;
        goto L_0x0184;
    L_0x019f:
        r0 = r1;
        goto L_0x0186;
    L_0x01a1:
        r12.m(r13);
        goto L_0x0090;
    L_0x01a6:
        r0 = r12.fj;
        r0.addMovement(r9);
        r0 = r12.fj;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7 = r12.YP;
        r7 = (float) r7;
        r0.computeCurrentVelocity(r3, r7);
        if (r5 == 0) goto L_0x0259;
    L_0x01b7:
        r0 = r12.fj;
        r3 = r12.YJ;
        r0 = android.support.v4.view.x.a(r0, r3);
        r0 = -r0;
        r3 = r0;
    L_0x01c1:
        if (r6 == 0) goto L_0x025c;
    L_0x01c3:
        r0 = r12.fj;
        r5 = r12.YJ;
        r0 = android.support.v4.view.x.b(r0, r5);
        r0 = -r0;
    L_0x01cc:
        r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r5 != 0) goto L_0x01d4;
    L_0x01d0:
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0250;
    L_0x01d4:
        r2 = (int) r3;
        r0 = (int) r0;
        r3 = r12.Ym;
        if (r3 == 0) goto L_0x0261;
    L_0x01da:
        r3 = r12.Yw;
        if (r3 != 0) goto L_0x0261;
    L_0x01de:
        r3 = r12.Ym;
        r5 = r3.eV();
        r3 = r12.Ym;
        r6 = r3.eW();
        if (r5 == 0) goto L_0x01f4;
    L_0x01ec:
        r3 = java.lang.Math.abs(r2);
        r7 = r12.YO;
        if (r3 >= r7) goto L_0x01f5;
    L_0x01f4:
        r2 = r1;
    L_0x01f5:
        if (r6 == 0) goto L_0x01ff;
    L_0x01f7:
        r3 = java.lang.Math.abs(r0);
        r7 = r12.YO;
        if (r3 >= r7) goto L_0x0268;
    L_0x01ff:
        r3 = r1;
    L_0x0200:
        if (r2 != 0) goto L_0x0204;
    L_0x0202:
        if (r3 == 0) goto L_0x0261;
    L_0x0204:
        r0 = (float) r2;
        r7 = (float) r3;
        r0 = r12.dispatchNestedPreFling(r0, r7);
        if (r0 != 0) goto L_0x0261;
    L_0x020c:
        if (r5 != 0) goto L_0x0210;
    L_0x020e:
        if (r6 == 0) goto L_0x025f;
    L_0x0210:
        r0 = r8;
    L_0x0211:
        r5 = (float) r2;
        r6 = (float) r3;
        r12.dispatchNestedFling(r5, r6, r0);
        if (r0 == 0) goto L_0x0261;
    L_0x0218:
        r0 = r12.YP;
        r0 = -r0;
        r5 = r12.YP;
        r2 = java.lang.Math.min(r2, r5);
        r2 = java.lang.Math.max(r0, r2);
        r0 = r12.YP;
        r0 = -r0;
        r5 = r12.YP;
        r3 = java.lang.Math.min(r3, r5);
        r3 = java.lang.Math.max(r0, r3);
        r10 = r12.YR;
        r0 = r10.Zh;
        r5 = 2;
        r0.Y(r5);
        r10.aai = r1;
        r10.aah = r1;
        r0 = r10.iA;
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r6 = r4;
        r0.a(r1, r2, r3, r4, r5, r6, r7);
        r10.gd();
        r0 = r8;
    L_0x024e:
        if (r0 != 0) goto L_0x0253;
    L_0x0250:
        r12.Y(r1);
    L_0x0253:
        r12.fA();
        r1 = r8;
        goto L_0x0090;
    L_0x0259:
        r3 = r2;
        goto L_0x01c1;
    L_0x025c:
        r0 = r2;
        goto L_0x01cc;
    L_0x025f:
        r0 = r1;
        goto L_0x0211;
    L_0x0261:
        r0 = r1;
        goto L_0x024e;
    L_0x0263:
        r12.fB();
        goto L_0x0090;
    L_0x0268:
        r3 = r0;
        goto L_0x0200;
    L_0x026a:
        r3 = r1;
        goto L_0x0159;
    L_0x026d:
        r0 = r1;
        goto L_0x00ba;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void fA() {
        if (this.fj != null) {
            this.fj.clear();
        }
        stopNestedScroll();
        int i = 0;
        if (this.YE != null) {
            i = this.YE.cv();
        }
        if (this.YF != null) {
            i |= this.YF.cv();
        }
        if (this.YG != null) {
            i |= this.YG.cv();
        }
        if (this.YH != null) {
            i |= this.YH.cv();
        }
        if (i != 0) {
            y.E(this);
        }
    }

    private void fB() {
        fA();
        Y(0);
    }

    private void m(MotionEvent motionEvent) {
        int e = android.support.v4.view.n.e(motionEvent);
        if (android.support.v4.view.n.c(motionEvent, e) == this.YJ) {
            e = e == 0 ? 1 : 0;
            this.YJ = android.support.v4.view.n.c(motionEvent, e);
            int d = (int) (android.support.v4.view.n.d(motionEvent, e) + 0.5f);
            this.YM = d;
            this.YK = d;
            e = (int) (android.support.v4.view.n.e(motionEvent, e) + 0.5f);
            this.YN = e;
            this.YL = e;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (!(this.Ym == null || this.Yw || (android.support.v4.view.n.g(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f2;
            float f3;
            if (this.Ym.eW()) {
                f2 = -android.support.v4.view.n.f(motionEvent, 9);
            } else {
                f2 = 0.0f;
            }
            if (this.Ym.eV()) {
                f3 = android.support.v4.view.n.f(motionEvent, 10);
            } else {
                f3 = 0.0f;
            }
            if (!(f2 == 0.0f && f3 == 0.0f)) {
                if (this.YQ == Float.MIN_VALUE) {
                    TypedValue typedValue = new TypedValue();
                    if (getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                        this.YQ = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
                    }
                    a((int) (f3 * f), (int) (f2 * f), motionEvent);
                }
                f = this.YQ;
                a((int) (f3 * f), (int) (f2 * f), motionEvent);
            }
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.Ym == null) {
            M(i, i2);
        } else if (this.Ym.Zt) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.Ym.X(i, i2);
            if (!z && this.Yl != null) {
                if (this.YS.ZW == 1) {
                    fK();
                }
                this.Ym.V(i, i2);
                this.YS.aag = true;
                fL();
                this.Ym.W(i, i2);
                if (this.Ym.fb()) {
                    this.Ym.V(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.YS.aag = true;
                    fL();
                    this.Ym.W(i, i2);
                }
            }
        } else if (this.Ys) {
            this.Ym.X(i, i2);
        } else {
            if (this.Yz) {
                fs();
                fI();
                if (this.YS.aae) {
                    this.YS.aac = true;
                } else {
                    this.Yg.ez();
                    this.YS.aac = false;
                }
                this.Yz = false;
                R(false);
            }
            if (this.Yl != null) {
                this.YS.ZY = this.Yl.getItemCount();
            } else {
                this.YS.ZY = 0;
            }
            fs();
            this.Ym.X(i, i2);
            R(false);
            this.YS.aac = false;
        }
    }

    final void M(int i, int i2) {
        setMeasuredDimension(h.j(i, getPaddingLeft() + getPaddingRight(), y.S(this)), h.j(i2, getPaddingTop() + getPaddingBottom(), y.T(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            fz();
        }
    }

    private void fC() {
        this.YD++;
    }

    private void fD() {
        this.YD--;
        if (this.YD <= 0) {
            this.YD = 0;
            int i = this.Yy;
            this.Yy = 0;
            if (i != 0 && fE()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                android.support.v4.view.a.a.a(obtain, i);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    final boolean fE() {
        return this.jk != null && this.jk.isEnabled();
    }

    private boolean fF() {
        return this.YD > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (fF()) {
            int b;
            if (accessibilityEvent != null) {
                b = android.support.v4.view.a.a.b(accessibilityEvent);
            } else {
                b = 0;
            }
            if (b != 0) {
                i = b;
            }
            this.Yy = i | this.Yy;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    private void fG() {
        if (!this.YY && this.Yr) {
            y.a((View) this, this.Ze);
            this.YY = true;
        }
    }

    private boolean fH() {
        return this.YI != null && this.Ym.eU();
    }

    private void fI() {
        boolean z;
        boolean z2 = true;
        if (this.YC) {
            this.Yg.reset();
            fO();
            this.Ym.eQ();
        }
        if (fH()) {
            this.Yg.ew();
        } else {
            this.Yg.ez();
        }
        boolean z3;
        if (this.YV || this.YW) {
            z3 = true;
        } else {
            z3 = false;
        }
        p pVar = this.YS;
        if (!this.Yt || this.YI == null || (!(this.YC || r0 || this.Ym.Zs) || (this.YC && !this.Yl.Zj))) {
            z = false;
        } else {
            z = true;
        }
        pVar.aad = z;
        p pVar2 = this.YS;
        if (!(this.YS.aad && r0 && !this.YC && fH())) {
            z2 = false;
        }
        pVar2.aae = z2;
    }

    private void fJ() {
        if (this.Yl != null && this.Ym != null) {
            boolean z;
            int i;
            int i2;
            this.YS.aag = false;
            if (this.YS.ZW == 1) {
                fK();
                this.Ym.z(this);
                fL();
            } else {
                e eVar = this.Yg;
                if (eVar.Tj.isEmpty() || eVar.Ti.isEmpty()) {
                    z = false;
                } else {
                    i = 1;
                }
                if (i == 0 && this.Ym.Zx == getWidth() && this.Ym.QW == getHeight()) {
                    this.Ym.z(this);
                } else {
                    this.Ym.z(this);
                    fL();
                }
            }
            this.YS.bf(4);
            fs();
            fC();
            this.YS.ZW = 1;
            if (this.YS.aad) {
                for (int childCount = this.Yh.getChildCount() - 1; childCount >= 0; childCount--) {
                    s aY = aY(this.Yh.getChildAt(childCount));
                    if (!aY.gf()) {
                        long g = g(aY);
                        b n = new b().n(aY);
                        s sVar = (s) this.Yi.aeL.get(g);
                        if (!(sVar == null || sVar.gf())) {
                            boolean z2 = this.Yi.z(sVar);
                            boolean z3 = this.Yi.z(aY);
                            if (!(z2 && sVar == aY)) {
                                b b = this.Yi.b(sVar, 4);
                                this.Yi.c(aY, n);
                                n = this.Yi.b(aY, 8);
                                if (b == null) {
                                    int childCount2 = this.Yh.getChildCount();
                                    i2 = 0;
                                    while (i2 < childCount2) {
                                        s aY2 = aY(this.Yh.getChildAt(i2));
                                        if (aY2 == aY || g(aY2) != g) {
                                            i2++;
                                        } else if (this.Yl == null || !this.Yl.Zj) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + aY2 + " \n View Holder 2:" + aY);
                                        } else {
                                            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + aY2 + " \n View Holder 2:" + aY);
                                        }
                                    }
                                    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(sVar).append(" cannot be found but it is necessary for ").append(aY);
                                } else {
                                    sVar.S(false);
                                    if (z2) {
                                        f(sVar);
                                    }
                                    if (sVar != aY) {
                                        if (z3) {
                                            f(aY);
                                        }
                                        sVar.aaq = aY;
                                        f(sVar);
                                        this.Ye.q(sVar);
                                        aY.S(false);
                                        aY.aar = sVar;
                                    }
                                    if (this.YI.a(sVar, aY, b, n)) {
                                        fG();
                                    }
                                }
                            }
                        }
                        this.Yi.c(aY, n);
                    }
                }
                this.Yi.a(this.Zg);
            }
            this.Ym.c(this.Ye);
            this.YS.ZZ = this.YS.ZY;
            this.YC = false;
            this.YS.aad = false;
            this.YS.aae = false;
            this.Ym.Zs = false;
            if (this.Ye.ZF != null) {
                this.Ye.ZF.clear();
            }
            fD();
            R(false);
            this.Yi.clear();
            i = this.Zb[0];
            i2 = this.Zb[1];
            if (this.Yh.getChildCount() == 0) {
                z = (i == 0 && i2 == 0) ? false : true;
            } else {
                d(this.Zb);
                z = (this.Zb[0] == i && this.Zb[1] == i2) ? false : true;
            }
            if (z) {
                N(0, 0);
            }
        }
    }

    private void fK() {
        int childCount;
        int i;
        s aY;
        this.YS.bf(1);
        this.YS.aag = false;
        fs();
        this.Yi.clear();
        fC();
        fI();
        p pVar = this.YS;
        boolean z = this.YS.aad && this.YW;
        pVar.aaf = z;
        this.YW = false;
        this.YV = false;
        this.YS.aac = this.YS.aae;
        this.YS.ZY = this.Yl.getItemCount();
        d(this.Zb);
        if (this.YS.aad) {
            childCount = this.Yh.getChildCount();
            for (i = 0; i < childCount; i++) {
                aY = aY(this.Yh.getChildAt(i));
                if (!aY.gf() && (!aY.gn() || this.Yl.Zj)) {
                    e.j(aY);
                    aY.gr();
                    this.Yi.b(aY, new b().n(aY));
                    if (!(!this.YS.aaf || !aY.gu() || aY.isRemoved() || aY.gf() || aY.gn())) {
                        this.Yi.a(g(aY), aY);
                    }
                }
            }
        }
        if (this.YS.aae) {
            childCount = this.Yh.eK();
            for (i = 0; i < childCount; i++) {
                aY = aY(this.Yh.aL(i));
                if (!aY.gf() && aY.aam == -1) {
                    aY.aam = aY.kB;
                }
            }
            z = this.YS.aab;
            this.YS.aab = false;
            this.Ym.c(this.Ye, this.YS);
            this.YS.aab = z;
            for (childCount = 0; childCount < this.Yh.getChildCount(); childCount++) {
                aY = aY(this.Yh.getChildAt(childCount));
                if (!aY.gf()) {
                    a aVar = (a) this.Yi.aeK.get(aY);
                    if (aVar == null || (aVar.flags & 4) == 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        e.j(aY);
                        z = aY.bg(8192);
                        aY.gr();
                        b n = new b().n(aY);
                        if (z) {
                            a(aY, n);
                        } else {
                            ar arVar = this.Yi;
                            aVar = (a) arVar.aeK.get(aY);
                            if (aVar == null) {
                                aVar = a.hf();
                                arVar.aeK.put(aY, aVar);
                            }
                            aVar.flags |= 2;
                            aVar.aeM = n;
                        }
                    }
                }
            }
            fN();
        } else {
            fN();
        }
        fD();
        R(false);
        this.YS.ZW = 2;
    }

    private void fL() {
        boolean z;
        fs();
        fC();
        this.YS.bf(6);
        this.Yg.ez();
        this.YS.ZY = this.Yl.getItemCount();
        this.YS.aaa = 0;
        this.YS.aac = false;
        this.Ym.c(this.Ye, this.YS);
        this.YS.aab = false;
        this.Yf = null;
        p pVar = this.YS;
        if (!this.YS.aad || this.YI == null) {
            z = false;
        } else {
            z = true;
        }
        pVar.aad = z;
        this.YS.ZW = 4;
        fD();
        R(false);
    }

    private void a(s sVar, b bVar) {
        sVar.setFlags(0, 8192);
        if (this.YS.aaf && sVar.gu() && !sVar.isRemoved() && !sVar.gf()) {
            this.Yi.a(g(sVar), sVar);
        }
        this.Yi.b(sVar, bVar);
    }

    private void d(int[] iArr) {
        int childCount = this.Yh.getChildCount();
        if (childCount == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < childCount) {
            int gg;
            s aY = aY(this.Yh.getChildAt(i3));
            if (!aY.gf()) {
                gg = aY.gg();
                if (gg < i) {
                    i = gg;
                }
                if (gg > i2) {
                    i2 = i;
                    i3++;
                    i = i2;
                    i2 = gg;
                }
            }
            gg = i2;
            i2 = i;
            i3++;
            i = i2;
            i2 = gg;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    protected void removeDetachedView(View view, boolean z) {
        s aY = aY(view);
        if (aY != null) {
            if (aY.gp()) {
                aY.gm();
            } else if (!aY.gf()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + aY);
            }
        }
        bc(view);
        super.removeDetachedView(view, z);
    }

    private long g(s sVar) {
        return this.Yl.Zj ? sVar.aan : (long) sVar.kB;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.support.v4.os.e.beginSection("RV OnLayout");
        fJ();
        android.support.v4.os.e.endSection();
        this.Yt = true;
    }

    public void requestLayout() {
        if (this.Yu != 0 || this.Yw) {
            this.Yv = true;
        } else {
            super.requestLayout();
        }
    }

    private void fM() {
        int i = 0;
        int eK = this.Yh.eK();
        for (int i2 = 0; i2 < eK; i2++) {
            ((LayoutParams) this.Yh.aL(i2).getLayoutParams()).Zz = true;
        }
        l lVar = this.Ye;
        eK = lVar.ZG.size();
        while (i < eK) {
            LayoutParams layoutParams = (LayoutParams) ((s) lVar.ZG.get(i)).aal.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.Zz = true;
            }
            i++;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2 = 1;
        int i3 = 0;
        super.draw(canvas);
        int size = this.Yo.size();
        for (i = 0; i < size; i++) {
            this.Yo.get(i);
        }
        if (this.YE == null || this.YE.isFinished()) {
            i = 0;
        } else {
            size = canvas.save();
            i = this.Yj ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i + (-getHeight())), 0.0f);
            if (this.YE == null || !this.YE.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            canvas.restoreToCount(size);
        }
        if (!(this.YF == null || this.YF.isFinished())) {
            int save = canvas.save();
            if (this.Yj) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.YF == null || !this.YF.draw(canvas)) {
                size = 0;
            } else {
                size = 1;
            }
            i |= size;
            canvas.restoreToCount(save);
        }
        if (!(this.YG == null || this.YG.isFinished())) {
            save = canvas.save();
            int width = getWidth();
            if (this.Yj) {
                size = getPaddingTop();
            } else {
                size = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-size), (float) (-width));
            if (this.YG == null || !this.YG.draw(canvas)) {
                size = 0;
            } else {
                size = 1;
            }
            i |= size;
            canvas.restoreToCount(save);
        }
        if (!(this.YH == null || this.YH.isFinished())) {
            size = canvas.save();
            canvas.rotate(180.0f);
            if (this.Yj) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.YH != null && this.YH.draw(canvas)) {
                i3 = 1;
            }
            i |= i3;
            canvas.restoreToCount(size);
        }
        if (i != 0 || this.YI == null || this.Yo.size() <= 0 || !this.YI.isRunning()) {
            i2 = i;
        }
        if (i2 != 0) {
            y.E(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.Yo.size();
        for (int i = 0; i < size; i++) {
            this.Yo.get(i);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.Ym.a((LayoutParams) layoutParams);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.Ym != null) {
            return this.Ym.eR();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.Ym != null) {
            return this.Ym.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.Ym != null) {
            return this.Ym.e(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    private void fN() {
        int i = 0;
        int eK = this.Yh.eK();
        for (int i2 = 0; i2 < eK; i2++) {
            s aY = aY(this.Yh.aL(i2));
            if (!aY.gf()) {
                aY.ge();
            }
        }
        l lVar = this.Ye;
        int size = lVar.ZG.size();
        for (eK = 0; eK < size; eK++) {
            ((s) lVar.ZG.get(eK)).ge();
        }
        size = lVar.ZE.size();
        for (eK = 0; eK < size; eK++) {
            ((s) lVar.ZE.get(eK)).ge();
        }
        if (lVar.ZF != null) {
            eK = lVar.ZF.size();
            while (i < eK) {
                ((s) lVar.ZF.get(i)).ge();
                i++;
            }
        }
    }

    final void d(int i, int i2, boolean z) {
        int i3 = i + i2;
        int eK = this.Yh.eK();
        for (int i4 = 0; i4 < eK; i4++) {
            s aY = aY(this.Yh.aL(i4));
            if (!(aY == null || aY.gf())) {
                if (aY.kB >= i3) {
                    aY.p(-i2, z);
                    this.YS.aab = true;
                } else if (aY.kB >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    aY.addFlags(8);
                    aY.p(i6, z);
                    aY.kB = i5;
                    this.YS.aab = true;
                }
            }
        }
        l lVar = this.Ye;
        int i7 = i + i2;
        for (i3 = lVar.ZG.size() - 1; i3 >= 0; i3--) {
            s sVar = (s) lVar.ZG.get(i3);
            if (sVar != null) {
                if (sVar.kB >= i7) {
                    sVar.p(-i2, z);
                } else if (sVar.kB >= i) {
                    sVar.addFlags(8);
                    lVar.bd(i3);
                }
            }
        }
        requestLayout();
    }

    private void fO() {
        int i;
        int eK = this.Yh.eK();
        for (i = 0; i < eK; i++) {
            s aY = aY(this.Yh.aL(i));
            if (!(aY == null || aY.gf())) {
                aY.addFlags(6);
            }
        }
        fM();
        l lVar = this.Ye;
        if (lVar.Zh.Yl == null || !lVar.Zh.Yl.Zj) {
            lVar.fY();
            return;
        }
        int size = lVar.ZG.size();
        for (i = 0; i < size; i++) {
            s sVar = (s) lVar.ZG.get(i);
            if (sVar != null) {
                sVar.addFlags(6);
                sVar.R(null);
            }
        }
    }

    public final s aP(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return aY(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public static s aY(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).Zy;
    }

    public static int aZ(View view) {
        s aY = aY(view);
        return aY != null ? aY.gh() : -1;
    }

    public static int ba(View view) {
        s aY = aY(view);
        return aY != null ? aY.gg() : -1;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    final Rect bb(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.Zz) {
            return layoutParams.VS;
        }
        Rect rect = layoutParams.VS;
        rect.set(0, 0, 0, 0);
        int size = this.Yo.size();
        for (int i = 0; i < size; i++) {
            this.ep.set(0, 0, 0, 0);
            ((g) this.Yo.get(i)).a(this.ep, view, this);
            rect.left += this.ep.left;
            rect.top += this.ep.top;
            rect.right += this.ep.right;
            rect.bottom += this.ep.bottom;
        }
        layoutParams.Zz = false;
        return rect;
    }

    final void N(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.YT != null) {
            this.YT.c(this, i, i2);
        }
        if (this.YU != null) {
            for (scrollY = this.YU.size() - 1; scrollY >= 0; scrollY--) {
                ((j) this.YU.get(scrollY)).c(this, i, i2);
            }
        }
    }

    private void fP() {
        int childCount = this.Yh.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Yh.getChildAt(i);
            s aP = aP(childAt);
            if (!(aP == null || aP.aar == null)) {
                View view = aP.aar.aal;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void bc(View view) {
        aY(view);
        if (this.YB != null) {
            for (int size = this.YB.size() - 1; size >= 0; size--) {
                this.YB.get(size);
            }
        }
    }

    public final int h(s sVar) {
        if (sVar.bg(524) || !sVar.isBound()) {
            return -1;
        }
        e eVar = this.Yg;
        int i = sVar.kB;
        int size = eVar.Ti.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) eVar.Ti.get(i2);
            switch (bVar.of) {
                case 1:
                    if (bVar.Tp > i) {
                        break;
                    }
                    i += bVar.Tr;
                    break;
                case 2:
                    if (bVar.Tp <= i) {
                        if (bVar.Tp + bVar.Tr <= i) {
                            i -= bVar.Tr;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (bVar.Tp != i) {
                        if (bVar.Tp < i) {
                            i--;
                        }
                        if (bVar.Tr > i) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i = bVar.Tr;
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        fQ().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return fQ().wt;
    }

    public boolean startNestedScroll(int i) {
        return fQ().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        fQ().stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return fQ().hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return fQ().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return fQ().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return fQ().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return fQ().dispatchNestedPreFling(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.Za == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.Za.fT();
    }

    private android.support.v4.view.p fQ() {
        if (this.Zc == null) {
            this.Zc = new android.support.v4.view.p(this);
        }
        return this.Zc;
    }
}
