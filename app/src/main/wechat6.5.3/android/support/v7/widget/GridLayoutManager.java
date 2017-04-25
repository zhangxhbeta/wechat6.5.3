package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.y;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.p;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public final class GridLayoutManager extends LinearLayoutManager {
    boolean VL = false;
    int VM = -1;
    int[] VN;
    View[] VO;
    final SparseIntArray VP = new SparseIntArray();
    final SparseIntArray VQ = new SparseIntArray();
    b VR = new a();
    final Rect VS = new Rect();

    public static abstract class b {
        final SparseIntArray VV = new SparseIntArray();
        private boolean VW = false;

        final int D(int i, int i2) {
            if (!this.VW) {
                return C(i, i2);
            }
            int i3 = this.VV.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = C(i, i2);
            this.VV.put(i, i3);
            return i3;
        }

        public int C(int i, int i2) {
            if (1 == i2) {
                return 0;
            }
            int size;
            int i3;
            int i4;
            if (this.VW && this.VV.size() > 0) {
                size = this.VV.size() - 1;
                i3 = 0;
                while (i3 <= size) {
                    int i5 = (i3 + size) >>> 1;
                    if (this.VV.keyAt(i5) < i) {
                        i3 = i5 + 1;
                    } else {
                        size = i5 - 1;
                    }
                }
                size = i3 - 1;
                size = (size < 0 || size >= this.VV.size()) ? -1 : this.VV.keyAt(size);
                if (size >= 0) {
                    i3 = this.VV.get(size) + 1;
                    size++;
                    i4 = size;
                    size = i3;
                    for (i3 = i4; i3 < i; i3++) {
                        size++;
                        if (size == i2) {
                            size = 0;
                        } else if (size > i2) {
                            size = 1;
                        }
                    }
                    if (size + 1 > i2) {
                        return size;
                    }
                    return 0;
                }
            }
            size = 0;
            i3 = 0;
            i4 = size;
            size = i3;
            for (i3 = i4; i3 < i; i3++) {
                size++;
                if (size == i2) {
                    size = 0;
                } else if (size > i2) {
                    size = 1;
                }
            }
            if (size + 1 > i2) {
                return 0;
            }
            return size;
        }

        public static int E(int i, int i2) {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4++;
                if (i4 == i2) {
                    i3++;
                    i4 = 0;
                } else if (i4 > i2) {
                    i4 = 1;
                    i3++;
                }
            }
            if (i4 + 1 > i2) {
                return i3 + 1;
            }
            return i3;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        int VT = -1;
        int VU = 0;

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
    }

    public static final class a extends b {
        public final int C(int i, int i2) {
            return i % i2;
        }
    }

    public GridLayoutManager(Context context, int i) {
        if (i != this.VM) {
            this.VL = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.VM = i;
            this.VR.VV.clear();
        }
    }

    public final int a(l lVar, p pVar) {
        if (this.Wj == 0) {
            return this.VM;
        }
        if (pVar.getItemCount() <= 0) {
            return 0;
        }
        return a(lVar, pVar, pVar.getItemCount() - 1) + 1;
    }

    public final int b(l lVar, p pVar) {
        if (this.Wj == 1) {
            return this.VM;
        }
        if (pVar.getItemCount() <= 0) {
            return 0;
        }
        return a(lVar, pVar, pVar.getItemCount() - 1) + 1;
    }

    public final void a(l lVar, p pVar, View view, android.support.v4.view.a.b bVar) {
        boolean z = false;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(lVar, pVar, layoutParams2.Zy.gg());
            int i;
            int i2;
            if (this.Wj == 0) {
                i = layoutParams2.VT;
                i2 = layoutParams2.VU;
                boolean z2 = this.VM > 1 && layoutParams2.VU == this.VM;
                bVar.k(android.support.v4.view.a.b.l.a(i, i2, a, 1, z2));
                return;
            }
            i = layoutParams2.VT;
            i2 = layoutParams2.VU;
            if (this.VM > 1 && layoutParams2.VU == this.VM) {
                z = true;
            }
            bVar.k(android.support.v4.view.a.b.l.a(a, 1, i, i2, z));
            return;
        }
        super.b(view, bVar);
    }

    public final void c(l lVar, p pVar) {
        if (pVar.aac) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int gg = layoutParams.Zy.gg();
                this.VP.put(gg, layoutParams.VU);
                this.VQ.put(gg, layoutParams.VT);
            }
        }
        super.c(lVar, pVar);
        this.VP.clear();
        this.VQ.clear();
        if (!pVar.aac) {
            this.VL = false;
        }
    }

    public final void y(int i, int i2) {
        this.VR.VV.clear();
    }

    public final void eQ() {
        this.VR.VV.clear();
    }

    public final void z(int i, int i2) {
        this.VR.VV.clear();
    }

    public final void A(int i, int i2) {
        this.VR.VV.clear();
    }

    public final void B(int i, int i2) {
        this.VR.VV.clear();
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams eR() {
        if (this.Wj == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams e(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private void eS() {
        int paddingRight;
        if (this.Wj == 1) {
            paddingRight = (this.Zx - getPaddingRight()) - getPaddingLeft();
        } else {
            paddingRight = (this.QW - getPaddingBottom()) - getPaddingTop();
        }
        aP(paddingRight);
    }

    public final void a(Rect rect, int i, int i2) {
        if (this.VN == null) {
            super.a(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.Wj == 1) {
            paddingTop = h.j(i2, paddingTop + rect.height(), y.T(this.Zq));
            paddingRight = h.j(i, paddingRight + this.VN[this.VN.length - 1], y.S(this.Zq));
        } else {
            paddingRight = h.j(i, paddingRight + rect.width(), y.S(this.Zq));
            paddingTop = h.j(i2, paddingTop + this.VN[this.VN.length - 1], y.T(this.Zq));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    private void aP(int i) {
        int i2 = 0;
        int[] iArr = this.VN;
        int i3 = this.VM;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        iArr[0] = 0;
        int i4 = i / i3;
        int i5 = i % i3;
        int i6 = 0;
        for (int i7 = 1; i7 <= i3; i7++) {
            int i8;
            i2 += i5;
            if (i2 <= 0 || i3 - i2 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i2 -= i3;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        this.VN = iArr;
    }

    final void a(l lVar, p pVar, a aVar, int i) {
        Object obj = 1;
        super.a(lVar, pVar, aVar, i);
        eS();
        if (pVar.getItemCount() > 0 && !pVar.aac) {
            if (i != 1) {
                obj = null;
            }
            int b = b(lVar, pVar, aVar.kB);
            if (obj != null) {
                while (b > 0 && aVar.kB > 0) {
                    aVar.kB--;
                    b = b(lVar, pVar, aVar.kB);
                }
            } else {
                int itemCount = pVar.getItemCount() - 1;
                int i2 = aVar.kB;
                while (i2 < itemCount) {
                    int b2 = b(lVar, pVar, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                aVar.kB = i2;
            }
        }
        eT();
    }

    private void eT() {
        if (this.VO == null || this.VO.length != this.VM) {
            this.VO = new View[this.VM];
        }
    }

    public final int a(int i, l lVar, p pVar) {
        eS();
        eT();
        return super.a(i, lVar, pVar);
    }

    public final int b(int i, l lVar, p pVar) {
        eS();
        eT();
        return super.b(i, lVar, pVar);
    }

    final View a(l lVar, p pVar, int i, int i2, int i3) {
        int i4;
        View view = null;
        eZ();
        int fn = this.Wv.fn();
        int fo = this.Wv.fo();
        if (i2 > i) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bd = h.bd(childAt);
            if (bd >= 0 && bd < i3 && b(lVar, pVar, bd) == 0) {
                if (((android.support.v7.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).Zy.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                } else if (this.Wv.aU(childAt) < fo && this.Wv.aV(childAt) >= fn) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                }
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        return view != null ? view : view2;
    }

    private int a(l lVar, p pVar, int i) {
        if (!pVar.aac) {
            return b.E(i, this.VM);
        }
        int bb = lVar.bb(i);
        if (bb == -1) {
            return 0;
        }
        return b.E(bb, this.VM);
    }

    private int b(l lVar, p pVar, int i) {
        if (!pVar.aac) {
            return this.VR.D(i, this.VM);
        }
        int i2 = this.VQ.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = lVar.bb(i);
        if (i2 == -1) {
            return 0;
        }
        return this.VR.D(i2, this.VM);
    }

    private int c(l lVar, p pVar, int i) {
        if (!pVar.aac) {
            return 1;
        }
        int i2 = this.VP.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        return lVar.bb(i) == -1 ? 1 : 1;
    }

    final void a(l lVar, p pVar, c cVar, b bVar) {
        boolean z;
        int i;
        View a;
        int fq = this.Wv.fq();
        Object obj = fq != 1073741824 ? 1 : null;
        int i2 = getChildCount() > 0 ? this.VN[this.VM] : 0;
        if (obj != null) {
            eS();
        }
        if (cVar.Wa == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = this.VM;
        if (z) {
            i = 0;
        } else {
            i3 = b(lVar, pVar, cVar.VZ) + c(lVar, pVar, cVar.VZ);
            i = 0;
        }
        while (i < this.VM && cVar.k(pVar) && i3 > 0) {
            int i4 = cVar.VZ;
            int c = c(lVar, pVar, i4);
            if (c <= this.VM) {
                i3 -= c;
                if (i3 < 0) {
                    break;
                }
                a = cVar.a(lVar);
                if (a == null) {
                    break;
                }
                this.VO[i] = a;
                i++;
            } else {
                throw new IllegalArgumentException("Item at position " + i4 + " requires " + c + " spans but GridLayoutManager has only " + this.VM + " spans.");
            }
        }
        if (i == 0) {
            bVar.mFinished = true;
            return;
        }
        int b;
        int i5;
        int i6;
        int i7 = 0;
        float f = 0.0f;
        a(lVar, pVar, i, z);
        int i8 = 0;
        while (i8 < i) {
            a = this.VO[i8];
            if (cVar.WP == null) {
                if (z) {
                    super.c(a, -1, false);
                } else {
                    super.c(a, 0, false);
                }
            } else if (z) {
                super.c(a, -1, true);
            } else {
                super.c(a, 0, true);
            }
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            c = h.b(this.VN[layoutParams.VT + layoutParams.VU] - this.VN[layoutParams.VT], fq, 0, this.Wj == 0 ? layoutParams.height : layoutParams.width, false);
            b = h.b(this.Wv.fp(), this.Wv.getMode(), 0, this.Wj == 1 ? layoutParams.height : layoutParams.width, true);
            if (this.Wj == 1) {
                a(a, c, b, layoutParams.height == -1, false);
            } else {
                a(a, b, c, layoutParams.width == -1, false);
            }
            i3 = this.Wv.aW(a);
            if (i3 <= i7) {
                i3 = i7;
            }
            float aX = (((float) this.Wv.aX(a)) * 1.0f) / ((float) layoutParams.VU);
            if (aX <= f) {
                aX = f;
            }
            i8++;
            f = aX;
            i7 = i3;
        }
        if (obj != null) {
            aP(Math.max(Math.round(((float) this.VM) * f), i2));
            i5 = 0;
            i6 = 0;
            while (i6 < i) {
                a = this.VO[i6];
                LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = h.b(this.VN[layoutParams2.VT + layoutParams2.VU] - this.VN[layoutParams2.VT], 1073741824, 0, this.Wj == 0 ? layoutParams2.height : layoutParams2.width, false);
                b = h.b(this.Wv.fp(), this.Wv.getMode(), 0, this.Wj == 1 ? layoutParams2.height : layoutParams2.width, true);
                if (this.Wj == 1) {
                    a(a, c, b, false, true);
                } else {
                    a(a, b, c, false, true);
                }
                i3 = this.Wv.aW(a);
                if (i3 <= i5) {
                    i3 = i5;
                }
                i6++;
                i5 = i3;
            }
        } else {
            i5 = i7;
        }
        b = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        for (i6 = 0; i6 < i; i6++) {
            a = this.VO[i6];
            if (this.Wv.aW(a) != i5) {
                layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = h.b(this.VN[layoutParams2.VT + layoutParams2.VU] - this.VN[layoutParams2.VT], 1073741824, 0, this.Wj == 0 ? layoutParams2.height : layoutParams2.width, false);
                if (this.Wj == 1) {
                    a(a, c, b, true, true);
                } else {
                    a(a, b, c, true, true);
                }
            }
        }
        bVar.WJ = i5;
        b = 0;
        c = 0;
        i4 = 0;
        i3 = 0;
        if (this.Wj == 1) {
            if (cVar.Wb == -1) {
                i3 = cVar.vI;
                i4 = i3 - i5;
            } else {
                i4 = cVar.vI;
                i3 = i4 + i5;
            }
        } else if (cVar.Wb == -1) {
            c = cVar.vI;
            b = c - i5;
        } else {
            b = cVar.vI;
            c = b + i5;
        }
        int i9 = b;
        b = c;
        c = i4;
        i4 = i3;
        for (int i10 = 0; i10 < i; i10++) {
            View view = this.VO[i10];
            layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (this.Wj != 1) {
                c = this.VN[layoutParams2.VT] + getPaddingTop();
                i4 = this.Wv.aX(view) + c;
            } else if (eY()) {
                b = getPaddingLeft() + this.VN[layoutParams2.VT + layoutParams2.VU];
                i9 = b - this.Wv.aX(view);
            } else {
                i9 = this.VN[layoutParams2.VT] + getPaddingLeft();
                b = this.Wv.aX(view) + i9;
            }
            h.g(view, layoutParams2.leftMargin + i9, layoutParams2.topMargin + c, b - layoutParams2.rightMargin, i4 - layoutParams2.bottomMargin);
            if (layoutParams2.Zy.isRemoved() || layoutParams2.Zy.gu()) {
                bVar.WK = true;
            }
            bVar.NJ |= view.isFocusable();
        }
        Arrays.fill(this.VO, null);
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        a(view, this.VS);
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.Wj == 1) {
            i = i(i, layoutParams.leftMargin + this.VS.left, layoutParams.rightMargin + this.VS.right);
        }
        if (z || this.Wj == 0) {
            i2 = i(i2, layoutParams.topMargin + this.VS.top, layoutParams.bottomMargin + this.VS.bottom);
        }
        boolean a = z2 ? (this.Zu && h.k(view.getMeasuredWidth(), i, layoutParams.width) && h.k(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true : a(view, i, i2, layoutParams);
        if (a) {
            view.measure(i, i2);
        }
    }

    private static int i(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private void a(l lVar, p pVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i2 = -1;
            i = -1;
        }
        if (this.Wj == 1 && eY()) {
            i4 = -1;
            i5 = this.VM - 1;
            i6 = i3;
        } else {
            i4 = 1;
            i5 = 0;
            i6 = i3;
        }
        while (i6 != i) {
            View view = this.VO[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.VU = c(lVar, pVar, h.bd(view));
            if (i4 != -1 || layoutParams.VU <= 1) {
                layoutParams.VT = i5;
            } else {
                layoutParams.VT = i5 - (layoutParams.VU - 1);
            }
            i5 += layoutParams.VU * i4;
            i6 += i2;
        }
    }

    public final View a(View view, int i, l lVar, p pVar) {
        View be = be(view);
        if (be == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) be.getLayoutParams();
        int a = layoutParams.VT;
        int a2 = layoutParams.VT + layoutParams.VU;
        if (super.a(view, i, lVar, pVar) == null) {
            return null;
        }
        int childCount;
        int i2;
        int i3;
        if (((aU(i) == 1) != this.Wy ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            childCount = 0;
            i2 = 1;
            i3 = getChildCount();
        }
        Object obj = (this.Wj == 1 && eY()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = childCount;
        while (i6 != i3) {
            View childAt = getChildAt(i6);
            if (childAt == be) {
                break;
            }
            View view3;
            if (childAt.isFocusable()) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a3 = layoutParams.VT;
                int a4 = layoutParams.VT + layoutParams.VU;
                if (a3 == a && a4 == a2) {
                    return childAt;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = layoutParams.VT;
                    childCount = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = childAt;
                    view2 = view3;
                    i6 += i2;
                    i4 = i5;
                    i5 = childCount;
                }
            }
            childCount = i5;
            i5 = i4;
            view3 = view2;
            view2 = view3;
            i6 += i2;
            i4 = i5;
            i5 = childCount;
        }
        return view2;
    }

    public final boolean eU() {
        return this.WE == null && !this.VL;
    }
}
