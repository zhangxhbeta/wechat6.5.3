package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.f;
import android.support.v4.view.y;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.p;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public final class StaggeredGridLayoutManager extends h {
    private int VM;
    private boolean WA;
    int WB;
    int WC;
    private int Wj;
    private boolean Wx;
    boolean Wy;
    private b[] ace;
    ab acf;
    ab acg;
    private int ach;
    private final y aci;
    private BitSet acj;
    LazySpanLookup ack;
    private int acl;
    private boolean acm;
    private boolean acn;
    private SavedState aco;
    private int acp;
    private final a acq;
    private boolean acr;
    private final Runnable acs;
    private final Rect gF;

    static class LazySpanLookup {
        List<FullSpanItem> acx;
        int[] mData;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new Creator<FullSpanItem>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            boolean acA;
            int acy;
            int[] acz;
            int kB;

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.kB = parcel.readInt();
                this.acy = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.acA = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.acz = new int[readInt];
                    parcel.readIntArray(this.acz);
                }
            }

            final int bt(int i) {
                return this.acz == null ? 0 : this.acz[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.kB);
                parcel.writeInt(this.acy);
                parcel.writeInt(this.acA ? 1 : 0);
                if (this.acz == null || this.acz.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.acz.length);
                parcel.writeIntArray(this.acz);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.kB + ", mGapDir=" + this.acy + ", mHasUnwantedGapAfter=" + this.acA + ", mGapPerSpan=" + Arrays.toString(this.acz) + '}';
            }
        }

        final int bp(int i) {
            if (this.acx != null) {
                for (int size = this.acx.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.acx.get(size)).kB >= i) {
                        this.acx.remove(size);
                    }
                }
            }
            return bq(i);
        }

        final int bq(int i) {
            if (this.mData == null) {
                return -1;
            }
            if (i >= this.mData.length) {
                return -1;
            }
            int i2;
            if (this.acx != null) {
                FullSpanItem bs = bs(i);
                if (bs != null) {
                    this.acx.remove(bs);
                }
                int size = this.acx.size();
                int i3 = 0;
                while (i3 < size) {
                    if (((FullSpanItem) this.acx.get(i3)).kB >= i) {
                        break;
                    }
                    i3++;
                }
                i3 = -1;
                if (i3 != -1) {
                    bs = (FullSpanItem) this.acx.get(i3);
                    this.acx.remove(i3);
                    i2 = bs.kB;
                    if (i2 != -1) {
                        Arrays.fill(this.mData, i, this.mData.length, -1);
                        return this.mData.length;
                    }
                    Arrays.fill(this.mData, i, i2 + 1, -1);
                    return i2 + 1;
                }
            }
            i2 = -1;
            if (i2 != -1) {
                Arrays.fill(this.mData, i, i2 + 1, -1);
                return i2 + 1;
            }
            Arrays.fill(this.mData, i, this.mData.length, -1);
            return this.mData.length;
        }

        final void br(int i) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.mData, -1);
            } else if (i >= this.mData.length) {
                Object obj = this.mData;
                int length = this.mData.length;
                while (length <= i) {
                    length *= 2;
                }
                this.mData = new int[length];
                System.arraycopy(obj, 0, this.mData, 0, obj.length);
                Arrays.fill(this.mData, obj.length, this.mData.length, -1);
            }
        }

        final void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.acx = null;
        }

        final void aa(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                br(i + i2);
                System.arraycopy(this.mData, i + i2, this.mData, i, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                if (this.acx != null) {
                    int i3 = i + i2;
                    for (int size = this.acx.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.acx.get(size);
                        if (fullSpanItem.kB >= i) {
                            if (fullSpanItem.kB < i3) {
                                this.acx.remove(size);
                            } else {
                                fullSpanItem.kB -= i2;
                            }
                        }
                    }
                }
            }
        }

        final void ab(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                br(i + i2);
                System.arraycopy(this.mData, i, this.mData, i + i2, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, i, i + i2, -1);
                if (this.acx != null) {
                    for (int size = this.acx.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.acx.get(size);
                        if (fullSpanItem.kB >= i) {
                            fullSpanItem.kB += i2;
                        }
                    }
                }
            }
        }

        public final void a(FullSpanItem fullSpanItem) {
            if (this.acx == null) {
                this.acx = new ArrayList();
            }
            int size = this.acx.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.acx.get(i);
                if (fullSpanItem2.kB == fullSpanItem.kB) {
                    this.acx.remove(i);
                }
                if (fullSpanItem2.kB >= fullSpanItem.kB) {
                    this.acx.add(i, fullSpanItem);
                    return;
                }
            }
            this.acx.add(fullSpanItem);
        }

        public final FullSpanItem bs(int i) {
            if (this.acx == null) {
                return null;
            }
            for (int size = this.acx.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.acx.get(size);
                if (fullSpanItem.kB == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem n(int i, int i2, int i3) {
            if (this.acx == null) {
                return null;
            }
            int size = this.acx.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.acx.get(i4);
                if (fullSpanItem.kB >= i2) {
                    return null;
                }
                if (fullSpanItem.kB >= i && (i3 == 0 || fullSpanItem.acy == i3 || fullSpanItem.acA)) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int WQ;
        boolean WS;
        boolean Wx;
        int acB;
        int acC;
        int[] acD;
        int acE;
        int[] acF;
        boolean acn;
        List<FullSpanItem> acx;

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.WQ = parcel.readInt();
            this.acB = parcel.readInt();
            this.acC = parcel.readInt();
            if (this.acC > 0) {
                this.acD = new int[this.acC];
                parcel.readIntArray(this.acD);
            }
            this.acE = parcel.readInt();
            if (this.acE > 0) {
                this.acF = new int[this.acE];
                parcel.readIntArray(this.acF);
            }
            this.Wx = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.WS = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.acn = z2;
            this.acx = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.acC = savedState.acC;
            this.WQ = savedState.WQ;
            this.acB = savedState.acB;
            this.acD = savedState.acD;
            this.acE = savedState.acE;
            this.acF = savedState.acF;
            this.Wx = savedState.Wx;
            this.WS = savedState.WS;
            this.acn = savedState.acn;
            this.acx = savedState.acx;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.WQ);
            parcel.writeInt(this.acB);
            parcel.writeInt(this.acC);
            if (this.acC > 0) {
                parcel.writeIntArray(this.acD);
            }
            parcel.writeInt(this.acE);
            if (this.acE > 0) {
                parcel.writeIntArray(this.acF);
            }
            if (this.Wx) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.WS) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.acn) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.acx);
        }
    }

    private class a {
        boolean WI;
        final /* synthetic */ StaggeredGridLayoutManager act;
        boolean acu;
        int kB;
        int vI;
    }

    class b {
        ArrayList<View> acG;
        int acH;
        int acI;
        int acJ;
        final /* synthetic */ StaggeredGridLayoutManager act;
        final int mIndex;

        final int bu(int i) {
            if (this.acH != Integer.MIN_VALUE) {
                return this.acH;
            }
            if (this.acG.size() == 0) {
                return i;
            }
            gO();
            return this.acH;
        }

        private void gO() {
            View view = (View) this.acG.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.acH = this.act.acf.aU(view);
            if (layoutParams.acw) {
                FullSpanItem bs = this.act.ack.bs(layoutParams.Zy.gg());
                if (bs != null && bs.acy == -1) {
                    this.acH -= bs.bt(this.mIndex);
                }
            }
        }

        final int gP() {
            if (this.acH != Integer.MIN_VALUE) {
                return this.acH;
            }
            gO();
            return this.acH;
        }

        final int bv(int i) {
            if (this.acI != Integer.MIN_VALUE) {
                return this.acI;
            }
            if (this.acG.size() == 0) {
                return i;
            }
            gQ();
            return this.acI;
        }

        private void gQ() {
            View view = (View) this.acG.get(this.acG.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.acI = this.act.acf.aV(view);
            if (layoutParams.acw) {
                FullSpanItem bs = this.act.ack.bs(layoutParams.Zy.gg());
                if (bs != null && bs.acy == 1) {
                    this.acI = bs.bt(this.mIndex) + this.acI;
                }
            }
        }

        final int gR() {
            if (this.acI != Integer.MIN_VALUE) {
                return this.acI;
            }
            gQ();
            return this.acI;
        }

        final void bo(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.acv = this;
            this.acG.add(0, view);
            this.acH = Integer.MIN_VALUE;
            if (this.acG.size() == 1) {
                this.acI = Integer.MIN_VALUE;
            }
            if (layoutParams.Zy.isRemoved() || layoutParams.Zy.gu()) {
                this.acJ += this.act.acf.aW(view);
            }
        }

        final void bp(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.acv = this;
            this.acG.add(view);
            this.acI = Integer.MIN_VALUE;
            if (this.acG.size() == 1) {
                this.acH = Integer.MIN_VALUE;
            }
            if (layoutParams.Zy.isRemoved() || layoutParams.Zy.gu()) {
                this.acJ += this.act.acf.aW(view);
            }
        }

        final void clear() {
            this.acG.clear();
            this.acH = Integer.MIN_VALUE;
            this.acI = Integer.MIN_VALUE;
            this.acJ = 0;
        }

        final void bw(int i) {
            this.acH = i;
            this.acI = i;
        }

        final void gS() {
            int size = this.acG.size();
            View view = (View) this.acG.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.acv = null;
            if (layoutParams.Zy.isRemoved() || layoutParams.Zy.gu()) {
                this.acJ -= this.act.acf.aW(view);
            }
            if (size == 1) {
                this.acH = Integer.MIN_VALUE;
            }
            this.acI = Integer.MIN_VALUE;
        }

        final void gT() {
            View view = (View) this.acG.remove(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.acv = null;
            if (this.acG.size() == 0) {
                this.acI = Integer.MIN_VALUE;
            }
            if (layoutParams.Zy.isRemoved() || layoutParams.Zy.gu()) {
                this.acJ -= this.act.acf.aW(view);
            }
            this.acH = Integer.MIN_VALUE;
        }

        final void bx(int i) {
            if (this.acH != Integer.MIN_VALUE) {
                this.acH += i;
            }
            if (this.acI != Integer.MIN_VALUE) {
                this.acI += i;
            }
        }

        public final View ac(int i, int i2) {
            View view = null;
            int size;
            View view2;
            if (i2 == -1) {
                size = this.acG.size();
                int i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.acG.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    boolean z;
                    if (h.bd(view2) > i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != this.act.Wx) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            for (size = this.acG.size() - 1; size >= 0; size--) {
                view2 = (View) this.acG.get(size);
                if (!view2.isFocusable()) {
                    break;
                }
                Object obj;
                if (h.bd(view2) > i) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != (!this.act.Wx ? 1 : null)) {
                    break;
                }
                view = view2;
            }
            return view;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        b acv;
        boolean acw;

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

        public final int gN() {
            if (this.acv == null) {
                return -1;
            }
            return this.acv.mIndex;
        }
    }

    private boolean gJ() {
        if (getChildCount() == 0 || this.acl == 0 || !this.hh) {
            return false;
        }
        int gL;
        int gM;
        if (this.Wy) {
            gL = gL();
            gM = gM();
        } else {
            gL = gM();
            gM = gL();
        }
        if (gL == 0 && gK() != null) {
            this.ack.clear();
            this.Zs = true;
            requestLayout();
            return true;
        } else if (!this.acr) {
            return false;
        } else {
            int i = this.Wy ? -1 : 1;
            FullSpanItem n = this.ack.n(gL, gM + 1, i);
            if (n == null) {
                this.acr = false;
                this.ack.bp(gM + 1);
                return false;
            }
            FullSpanItem n2 = this.ack.n(gL, n.kB, i * -1);
            if (n2 == null) {
                this.ack.bp(n.kB);
            } else {
                this.ack.bp(n2.kB + 1);
            }
            this.Zs = true;
            requestLayout();
            return true;
        }
    }

    public final void ba(int i) {
        if (i == 0) {
            gJ();
        }
    }

    public final void a(RecyclerView recyclerView, l lVar) {
        removeCallbacks(this.acs);
        for (int i = 0; i < this.VM; i++) {
            this.ace[i].clear();
        }
    }

    private View gK() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.VM);
        bitSet.set(0, this.VM, true);
        boolean z = (this.Wj == 1 && eY()) ? true : true;
        if (this.Wy) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        if (childCount < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = childCount;
        while (i3 != i) {
            boolean z2;
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.acv.mIndex)) {
                b bVar = layoutParams.acv;
                if (this.Wy) {
                    if (bVar.gR() < this.acf.fo()) {
                        z2 = !((LayoutParams) ((View) bVar.acG.get(bVar.acG.size() + -1)).getLayoutParams()).acw;
                    }
                    z2 = false;
                } else {
                    if (bVar.gP() > this.acf.fn()) {
                        z2 = !((LayoutParams) ((View) bVar.acG.get(0)).getLayoutParams()).acw;
                    }
                    z2 = false;
                }
                if (z2) {
                    return childAt;
                }
                bitSet.clear(layoutParams.acv.mIndex);
            }
            if (!(layoutParams.acw || i3 + i2 == i)) {
                View childAt2 = getChildAt(i3 + i2);
                int aV;
                if (this.Wy) {
                    childCount = this.acf.aV(childAt);
                    aV = this.acf.aV(childAt2);
                    if (childCount < aV) {
                        return childAt;
                    }
                    if (childCount == aV) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.acf.aU(childAt);
                    aV = this.acf.aU(childAt2);
                    if (childCount > aV) {
                        return childAt;
                    }
                    if (childCount == aV) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    boolean z3;
                    if (layoutParams.acv.mIndex - ((LayoutParams) childAt2.getLayoutParams()).acv.mIndex < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z >= false) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 != z3) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public final void q(String str) {
        if (this.aco == null) {
            super.q(str);
        }
    }

    private void eX() {
        boolean z = true;
        if (this.Wj == 1 || !eY()) {
            z = this.Wx;
        } else if (this.Wx) {
            z = false;
        }
        this.Wy = z;
    }

    private boolean eY() {
        return y.I(this.Zq) == 1;
    }

    public final void a(Rect rect, int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.Wj == 1) {
            paddingTop = h.j(i2, paddingTop + rect.height(), y.T(this.Zq));
            paddingRight = h.j(i, paddingRight + (this.ach * this.VM), y.S(this.Zq));
        } else {
            paddingRight = h.j(i, paddingRight + rect.width(), y.S(this.Zq));
            paddingTop = h.j(i2, paddingTop + (this.ach * this.VM), y.T(this.Zq));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public final void c(l lVar, p pVar) {
        Object obj = 1;
        while (true) {
            a aVar = this.acq;
            aVar.kB = -1;
            aVar.vI = Integer.MIN_VALUE;
            aVar.WI = false;
            aVar.acu = false;
            if (!(this.aco == null && this.WB == -1) && pVar.getItemCount() == 0) {
                d(lVar);
                return;
            }
            int i;
            int i2;
            Object obj2;
            int childCount;
            int i3;
            if (this.aco != null) {
                if (this.aco.acC > 0) {
                    if (this.aco.acC == this.VM) {
                        for (i = 0; i < this.VM; i++) {
                            this.ace[i].clear();
                            i2 = this.aco.acD[i];
                            if (i2 != Integer.MIN_VALUE) {
                                i2 = this.aco.WS ? i2 + this.acf.fo() : i2 + this.acf.fn();
                            }
                            this.ace[i].bw(i2);
                        }
                    } else {
                        SavedState savedState = this.aco;
                        savedState.acD = null;
                        savedState.acC = 0;
                        savedState.acE = 0;
                        savedState.acF = null;
                        savedState.acx = null;
                        this.aco.WQ = this.aco.acB;
                    }
                }
                this.acn = this.aco.acn;
                boolean z = this.aco.Wx;
                q(null);
                if (!(this.aco == null || this.aco.Wx == z)) {
                    this.aco.Wx = z;
                }
                this.Wx = z;
                requestLayout();
                eX();
                if (this.aco.WQ != -1) {
                    this.WB = this.aco.WQ;
                    aVar.WI = this.aco.WS;
                } else {
                    aVar.WI = this.Wy;
                }
                if (this.aco.acE > 1) {
                    this.ack.mData = this.aco.acF;
                    this.ack.acx = this.aco.acx;
                }
            } else {
                eX();
                aVar.WI = this.Wy;
            }
            if (pVar.aac || this.WB == -1) {
                obj2 = null;
            } else if (this.WB < 0 || this.WB >= pVar.getItemCount()) {
                this.WB = -1;
                this.WC = Integer.MIN_VALUE;
                obj2 = null;
            } else {
                if (this.aco == null || this.aco.WQ == -1 || this.aco.acC <= 0) {
                    View aR = aR(this.WB);
                    if (aR != null) {
                        aVar.kB = this.Wy ? gL() : gM();
                        if (this.WC != Integer.MIN_VALUE) {
                            if (aVar.WI) {
                                aVar.vI = (this.acf.fo() - this.WC) - this.acf.aV(aR);
                            } else {
                                aVar.vI = (this.acf.fn() + this.WC) - this.acf.aU(aR);
                            }
                            obj2 = 1;
                        } else if (this.acf.aW(aR) > this.acf.fp()) {
                            aVar.vI = aVar.WI ? this.acf.fo() : this.acf.fn();
                        } else {
                            i = this.acf.aU(aR) - this.acf.fn();
                            if (i < 0) {
                                aVar.vI = -i;
                            } else {
                                i = this.acf.fo() - this.acf.aV(aR);
                                if (i < 0) {
                                    aVar.vI = i;
                                } else {
                                    aVar.vI = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        aVar.kB = this.WB;
                        if (this.WC == Integer.MIN_VALUE) {
                            aVar.WI = bo(aVar.kB) == 1;
                            aVar.vI = aVar.WI ? aVar.act.acf.fo() : aVar.act.acf.fn();
                        } else {
                            i = this.WC;
                            if (aVar.WI) {
                                aVar.vI = aVar.act.acf.fo() - i;
                            } else {
                                aVar.vI = i + aVar.act.acf.fn();
                            }
                        }
                        aVar.acu = true;
                    }
                } else {
                    aVar.vI = Integer.MIN_VALUE;
                    aVar.kB = this.WB;
                }
                obj2 = 1;
            }
            if (obj2 == null) {
                int itemCount;
                if (this.acm) {
                    itemCount = pVar.getItemCount();
                    for (i2 = getChildCount() - 1; i2 >= 0; i2--) {
                        i = h.bd(getChildAt(i2));
                        if (i >= 0 && i < itemCount) {
                            break;
                        }
                    }
                    i = 0;
                } else {
                    itemCount = pVar.getItemCount();
                    childCount = getChildCount();
                    for (i2 = 0; i2 < childCount; i2++) {
                        i = h.bd(getChildAt(i2));
                        if (i >= 0 && i < itemCount) {
                            break;
                        }
                    }
                    i = 0;
                }
                aVar.kB = i;
                aVar.vI = Integer.MIN_VALUE;
            }
            if (this.aco == null && !(aVar.WI == this.acm && eY() == this.acn)) {
                this.ack.clear();
                aVar.acu = true;
            }
            if (getChildCount() > 0 && (this.aco == null || this.aco.acC <= 0)) {
                if (aVar.acu) {
                    for (i = 0; i < this.VM; i++) {
                        this.ace[i].clear();
                        if (aVar.vI != Integer.MIN_VALUE) {
                            this.ace[i].bw(aVar.vI);
                        }
                    }
                } else {
                    for (i2 = 0; i2 < this.VM; i2++) {
                        b bVar = this.ace[i2];
                        boolean z2 = this.Wy;
                        i3 = aVar.vI;
                        i = z2 ? bVar.bv(Integer.MIN_VALUE) : bVar.bu(Integer.MIN_VALUE);
                        bVar.clear();
                        if (i != Integer.MIN_VALUE && ((!z2 || i >= bVar.act.acf.fo()) && (z2 || i <= bVar.act.acf.fn()))) {
                            if (i3 != Integer.MIN_VALUE) {
                                i += i3;
                            }
                            bVar.acI = i;
                            bVar.acH = i;
                        }
                    }
                }
            }
            b(lVar);
            this.aci.VX = false;
            this.acr = false;
            bj(this.acg.fp());
            a(aVar.kB, pVar);
            if (aVar.WI) {
                bk(-1);
                a(lVar, this.aci, pVar);
                bk(1);
                this.aci.VZ = aVar.kB + this.aci.Wa;
                a(lVar, this.aci, pVar);
            } else {
                bk(1);
                a(lVar, this.aci, pVar);
                bk(-1);
                this.aci.VZ = aVar.kB + this.aci.Wa;
                a(lVar, this.aci, pVar);
            }
            if (this.acg.getMode() != 1073741824) {
                float f = 0.0f;
                i3 = getChildCount();
                childCount = 0;
                while (childCount < i3) {
                    float max;
                    View childAt = getChildAt(childCount);
                    float aW = (float) this.acg.aW(childAt);
                    if (aW >= f) {
                        max = Math.max(f, ((LayoutParams) childAt.getLayoutParams()).acw ? (1.0f * aW) / ((float) this.VM) : aW);
                    } else {
                        max = f;
                    }
                    childCount++;
                    f = max;
                }
                childCount = this.ach;
                i = Math.round(((float) this.VM) * f);
                if (this.acg.getMode() == Integer.MIN_VALUE) {
                    i = Math.min(i, this.acg.fp());
                }
                bj(i);
                if (this.ach != childCount) {
                    for (i2 = 0; i2 < i3; i2++) {
                        View childAt2 = getChildAt(i2);
                        LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (!layoutParams.acw) {
                            if (eY() && this.Wj == 1) {
                                childAt2.offsetLeftAndRight(((-((this.VM - 1) - layoutParams.acv.mIndex)) * this.ach) - ((-((this.VM - 1) - layoutParams.acv.mIndex)) * childCount));
                            } else {
                                int i4 = layoutParams.acv.mIndex * this.ach;
                                i = layoutParams.acv.mIndex * childCount;
                                if (this.Wj == 1) {
                                    childAt2.offsetLeftAndRight(i4 - i);
                                } else {
                                    childAt2.offsetTopAndBottom(i4 - i);
                                }
                            }
                        }
                    }
                }
            }
            if (getChildCount() > 0) {
                if (this.Wy) {
                    a(lVar, pVar, true);
                    b(lVar, pVar, false);
                } else {
                    b(lVar, pVar, true);
                    a(lVar, pVar, false);
                }
            }
            obj2 = null;
            if (!(obj == null || pVar.aac)) {
                obj = (this.acl == 0 || getChildCount() <= 0 || (!this.acr && gK() == null)) ? null : 1;
                if (obj != null) {
                    removeCallbacks(this.acs);
                    if (gJ()) {
                        obj2 = 1;
                    }
                }
                this.WB = -1;
                this.WC = Integer.MIN_VALUE;
            }
            this.acm = aVar.WI;
            this.acn = eY();
            this.aco = null;
            if (obj2 != null) {
                obj = null;
            } else {
                return;
            }
        }
    }

    private void bj(int i) {
        this.ach = i / this.VM;
        this.acp = MeasureSpec.makeMeasureSpec(i, this.acg.getMode());
    }

    public final boolean eU() {
        return this.aco == null;
    }

    public final int b(p pVar) {
        return h(pVar);
    }

    private int h(p pVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.acf;
        View X = X(!this.WA);
        if (this.WA) {
            z = false;
        }
        return ah.a(pVar, abVar, X, Y(z), this, this.WA, this.Wy);
    }

    public final int c(p pVar) {
        return h(pVar);
    }

    public final int d(p pVar) {
        return i(pVar);
    }

    private int i(p pVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.acf;
        View X = X(!this.WA);
        if (this.WA) {
            z = false;
        }
        return ah.a(pVar, abVar, X, Y(z), this, this.WA);
    }

    public final int e(p pVar) {
        return i(pVar);
    }

    public final int f(p pVar) {
        return j(pVar);
    }

    private int j(p pVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.acf;
        View X = X(!this.WA);
        if (this.WA) {
            z = false;
        }
        return ah.b(pVar, abVar, X, Y(z), this, this.WA);
    }

    public final int g(p pVar) {
        return j(pVar);
    }

    private void a(View view, int i, int i2, boolean z) {
        a(view, this.gF);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = i(i, layoutParams.leftMargin + this.gF.left, layoutParams.rightMargin + this.gF.right);
        int i4 = i(i2, layoutParams.topMargin + this.gF.top, layoutParams.bottomMargin + this.gF.bottom);
        if (a(view, i3, i4, (android.support.v7.widget.RecyclerView.LayoutParams) layoutParams)) {
            view.measure(i3, i4);
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

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.aco = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.aco != null) {
            return new SavedState(this.aco);
        }
        SavedState savedState = new SavedState();
        savedState.Wx = this.Wx;
        savedState.WS = this.acm;
        savedState.acn = this.acn;
        if (this.ack == null || this.ack.mData == null) {
            savedState.acE = 0;
        } else {
            savedState.acF = this.ack.mData;
            savedState.acE = savedState.acF.length;
            savedState.acx = this.ack.acx;
        }
        if (getChildCount() > 0) {
            int i;
            savedState.WQ = this.acm ? gL() : gM();
            View Y = this.Wy ? Y(true) : X(true);
            if (Y == null) {
                i = -1;
            } else {
                i = h.bd(Y);
            }
            savedState.acB = i;
            savedState.acC = this.VM;
            savedState.acD = new int[this.VM];
            for (i = 0; i < this.VM; i++) {
                int bv;
                if (this.acm) {
                    bv = this.ace[i].bv(Integer.MIN_VALUE);
                    if (bv != Integer.MIN_VALUE) {
                        bv -= this.acf.fo();
                    }
                } else {
                    bv = this.ace[i].bu(Integer.MIN_VALUE);
                    if (bv != Integer.MIN_VALUE) {
                        bv -= this.acf.fn();
                    }
                }
                savedState.acD[i] = bv;
            }
        } else {
            savedState.WQ = -1;
            savedState.acB = -1;
            savedState.acC = 0;
        }
        return savedState;
    }

    public final void a(l lVar, p pVar, View view, android.support.v4.view.a.b bVar) {
        int i = 1;
        int i2 = -1;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int gN;
            int i3;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.Wj == 0) {
                gN = layoutParams2.gN();
                if (layoutParams2.acw) {
                    i = this.VM;
                }
                i3 = gN;
                gN = i;
                i = -1;
            } else {
                gN = layoutParams2.gN();
                if (layoutParams2.acw) {
                    i = this.VM;
                    i3 = -1;
                    i2 = gN;
                    gN = -1;
                } else {
                    i3 = -1;
                    i2 = gN;
                    gN = -1;
                }
            }
            bVar.k(android.support.v4.view.a.b.l.a(i3, gN, i2, i, layoutParams2.acw));
            return;
        }
        super.b(view, bVar);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            View X = X(false);
            View Y = Y(false);
            if (X != null && Y != null) {
                int bd = h.bd(X);
                int bd2 = h.bd(Y);
                if (bd < bd2) {
                    a.setFromIndex(bd);
                    a.setToIndex(bd2);
                    return;
                }
                a.setFromIndex(bd2);
                a.setToIndex(bd);
            }
        }
    }

    public final int a(l lVar, p pVar) {
        if (this.Wj == 0) {
            return this.VM;
        }
        return super.a(lVar, pVar);
    }

    public final int b(l lVar, p pVar) {
        if (this.Wj == 1) {
            return this.VM;
        }
        return super.b(lVar, pVar);
    }

    private View X(boolean z) {
        int fn = this.acf.fn();
        int fo = this.acf.fo();
        int childCount = getChildCount();
        View view = null;
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            int aU = this.acf.aU(childAt);
            if (this.acf.aV(childAt) > fn && aU < fo) {
                if (aU >= fn || !z) {
                    return childAt;
                }
                if (view == null) {
                    i++;
                    view = childAt;
                }
            }
            childAt = view;
            i++;
            view = childAt;
        }
        return view;
    }

    private View Y(boolean z) {
        int fn = this.acf.fn();
        int fo = this.acf.fo();
        View view = null;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            int aU = this.acf.aU(childAt);
            int aV = this.acf.aV(childAt);
            if (aV > fn && aU < fo) {
                if (aV <= fo || !z) {
                    return childAt;
                }
                if (view == null) {
                    childCount--;
                    view = childAt;
                }
            }
            childAt = view;
            childCount--;
            view = childAt;
        }
        return view;
    }

    private void a(l lVar, p pVar, boolean z) {
        int bm = bm(Integer.MIN_VALUE);
        if (bm != Integer.MIN_VALUE) {
            bm = this.acf.fo() - bm;
            if (bm > 0) {
                bm -= -c(-bm, lVar, pVar);
                if (z && bm > 0) {
                    this.acf.aW(bm);
                }
            }
        }
    }

    private void b(l lVar, p pVar, boolean z) {
        int bl = bl(Integer.MAX_VALUE);
        if (bl != Integer.MAX_VALUE) {
            bl -= this.acf.fn();
            if (bl > 0) {
                bl -= c(bl, lVar, pVar);
                if (z && bl > 0) {
                    this.acf.aW(-bl);
                }
            }
        }
    }

    private void a(int i, p pVar) {
        int i2;
        int i3;
        boolean z;
        y yVar;
        boolean z2 = false;
        this.aci.VY = 0;
        this.aci.VZ = i;
        if (fV()) {
            i2 = pVar.ZM;
            if (i2 != -1) {
                if (this.Wy == (i2 < i)) {
                    i2 = this.acf.fp();
                    i3 = 0;
                } else {
                    i3 = this.acf.fp();
                    i2 = 0;
                }
                if (this.Zq == null && this.Zq.Yj) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.aci.Wd = i2 + this.acf.getEnd();
                    this.aci.Wc = -i3;
                } else {
                    this.aci.Wc = this.acf.fn() - i3;
                    this.aci.Wd = i2 + this.acf.fo();
                }
                this.aci.We = false;
                this.aci.VX = true;
                yVar = this.aci;
                if (this.acf.getMode() == 0 && this.acf.getEnd() == 0) {
                    z2 = true;
                }
                yVar.Wf = z2;
            }
        }
        i2 = 0;
        i3 = 0;
        if (this.Zq == null) {
        }
        z = false;
        if (z) {
            this.aci.Wd = i2 + this.acf.getEnd();
            this.aci.Wc = -i3;
        } else {
            this.aci.Wc = this.acf.fn() - i3;
            this.aci.Wd = i2 + this.acf.fo();
        }
        this.aci.We = false;
        this.aci.VX = true;
        yVar = this.aci;
        z2 = true;
        yVar.Wf = z2;
    }

    private void bk(int i) {
        int i2 = 1;
        this.aci.Wb = i;
        y yVar = this.aci;
        if (this.Wy != (i == -1)) {
            i2 = -1;
        }
        yVar.Wa = i2;
    }

    public final void aY(int i) {
        super.aY(i);
        for (int i2 = 0; i2 < this.VM; i2++) {
            this.ace[i2].bx(i);
        }
    }

    public final void aZ(int i) {
        super.aZ(i);
        for (int i2 = 0; i2 < this.VM; i2++) {
            this.ace[i2].bx(i);
        }
    }

    public final void z(int i, int i2) {
        m(i, i2, 2);
    }

    public final void y(int i, int i2) {
        m(i, i2, 1);
    }

    public final void eQ() {
        this.ack.clear();
        requestLayout();
    }

    public final void B(int i, int i2) {
        m(i, i2, 8);
    }

    public final void A(int i, int i2) {
        m(i, i2, 4);
    }

    private void m(int i, int i2, int i3) {
        int i4;
        int i5;
        int gL = this.Wy ? gL() : gM();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.ack.bq(i5);
        switch (i3) {
            case 1:
                this.ack.ab(i, i2);
                break;
            case 2:
                this.ack.aa(i, i2);
                break;
            case 8:
                this.ack.aa(i, 1);
                this.ack.ab(i2, 1);
                break;
        }
        if (i4 > gL) {
            if (i5 <= (this.Wy ? gM() : gL())) {
                requestLayout();
            }
        }
    }

    private int a(l lVar, y yVar, p pVar) {
        int i;
        int fn;
        this.acj.set(0, this.VM, true);
        if (this.aci.Wf) {
            if (yVar.Wb == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (yVar.Wb == 1) {
            i = yVar.Wd + yVar.VY;
        } else {
            i = yVar.Wc - yVar.VY;
        }
        Z(yVar.Wb, i);
        int fo = this.Wy ? this.acf.fo() : this.acf.fn();
        Object obj = null;
        while (true) {
            Object obj2 = (yVar.VZ < 0 || yVar.VZ >= pVar.getItemCount()) ? null : 1;
            if (obj2 != null && (this.aci.Wf || !this.acj.isEmpty())) {
                b bVar;
                int i2;
                int i3;
                int bv;
                View bc = lVar.bc(yVar.VZ);
                yVar.VZ += yVar.Wa;
                LayoutParams layoutParams = (LayoutParams) bc.getLayoutParams();
                int gg = layoutParams.Zy.gg();
                LazySpanLookup lazySpanLookup = this.ack;
                int i4 = (lazySpanLookup.mData == null || gg >= lazySpanLookup.mData.length) ? -1 : lazySpanLookup.mData[gg];
                Object obj3 = i4 == -1 ? 1 : null;
                if (obj3 != null) {
                    if (layoutParams.acw) {
                        bVar = this.ace[0];
                    } else {
                        if (bn(yVar.Wb)) {
                            i4 = this.VM - 1;
                            i2 = -1;
                            i3 = -1;
                        } else {
                            i4 = 0;
                            i2 = this.VM;
                            i3 = 1;
                        }
                        int i5;
                        int fn2;
                        int i6;
                        b bVar2;
                        int i7;
                        if (yVar.Wb == 1) {
                            bVar = null;
                            i5 = Integer.MAX_VALUE;
                            fn2 = this.acf.fn();
                            i6 = i4;
                            while (i6 != i2) {
                                bVar2 = this.ace[i6];
                                bv = bVar2.bv(fn2);
                                if (bv < i5) {
                                    i7 = bv;
                                } else {
                                    bVar2 = bVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                bVar = bVar2;
                            }
                        } else {
                            bVar = null;
                            i5 = Integer.MIN_VALUE;
                            fn2 = this.acf.fo();
                            i6 = i4;
                            while (i6 != i2) {
                                bVar2 = this.ace[i6];
                                bv = bVar2.bu(fn2);
                                if (bv > i5) {
                                    i7 = bv;
                                } else {
                                    bVar2 = bVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                bVar = bVar2;
                            }
                        }
                    }
                    lazySpanLookup = this.ack;
                    lazySpanLookup.br(gg);
                    lazySpanLookup.mData[gg] = bVar.mIndex;
                } else {
                    bVar = this.ace[i4];
                }
                layoutParams.acv = bVar;
                if (yVar.Wb == 1) {
                    super.c(bc, -1, false);
                } else {
                    super.c(bc, 0, false);
                }
                if (layoutParams.acw) {
                    if (this.Wj == 1) {
                        a(bc, this.acp, h.b(this.QW, this.Zw, 0, layoutParams.height, true), false);
                    } else {
                        a(bc, h.b(this.Zx, this.Zv, 0, layoutParams.width, true), this.acp, false);
                    }
                } else if (this.Wj == 1) {
                    a(bc, h.b(this.ach, this.Zv, 0, layoutParams.width, false), h.b(this.QW, this.Zw, 0, layoutParams.height, true), false);
                } else {
                    a(bc, h.b(this.Zx, this.Zv, 0, layoutParams.width, true), h.b(this.ach, this.Zw, 0, layoutParams.height, false), false);
                }
                FullSpanItem fullSpanItem;
                if (yVar.Wb == 1) {
                    i3 = layoutParams.acw ? bm(fo) : bVar.bv(fo);
                    i2 = i3 + this.acf.aW(bc);
                    if (obj3 == null || !layoutParams.acw) {
                        i4 = i3;
                        i3 = i2;
                    } else {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.acz = new int[this.VM];
                        for (i4 = 0; i4 < this.VM; i4++) {
                            fullSpanItem.acz[i4] = i3 - this.ace[i4].bv(i3);
                        }
                        fullSpanItem.acy = -1;
                        fullSpanItem.kB = gg;
                        this.ack.a(fullSpanItem);
                        i4 = i3;
                        i3 = i2;
                    }
                } else {
                    i3 = layoutParams.acw ? bl(fo) : bVar.bu(fo);
                    i2 = i3 - this.acf.aW(bc);
                    if (obj3 != null && layoutParams.acw) {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.acz = new int[this.VM];
                        for (i4 = 0; i4 < this.VM; i4++) {
                            fullSpanItem.acz[i4] = this.ace[i4].bu(i3) - i3;
                        }
                        fullSpanItem.acy = 1;
                        fullSpanItem.kB = gg;
                        this.ack.a(fullSpanItem);
                    }
                    i4 = i2;
                }
                if (layoutParams.acw && yVar.Wa == -1) {
                    if (obj3 == null) {
                        Object obj4;
                        if (yVar.Wb == 1) {
                            bv = this.ace[0].bv(Integer.MIN_VALUE);
                            for (i2 = 1; i2 < this.VM; i2++) {
                                if (this.ace[i2].bv(Integer.MIN_VALUE) != bv) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        } else {
                            bv = this.ace[0].bu(Integer.MIN_VALUE);
                            for (i2 = 1; i2 < this.VM; i2++) {
                                if (this.ace[i2].bu(Integer.MIN_VALUE) != bv) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        }
                        if (obj4 != null) {
                            FullSpanItem bs = this.ack.bs(gg);
                            if (bs != null) {
                                bs.acA = true;
                            }
                        }
                    }
                    this.acr = true;
                }
                if (yVar.Wb == 1) {
                    if (layoutParams.acw) {
                        for (i2 = this.VM - 1; i2 >= 0; i2--) {
                            this.ace[i2].bp(bc);
                        }
                    } else {
                        layoutParams.acv.bp(bc);
                    }
                } else if (layoutParams.acw) {
                    for (i2 = this.VM - 1; i2 >= 0; i2--) {
                        this.ace[i2].bo(bc);
                    }
                } else {
                    layoutParams.acv.bo(bc);
                }
                if (eY() && this.Wj == 1) {
                    i2 = layoutParams.acw ? this.acg.fo() : this.acg.fo() - (((this.VM - 1) - bVar.mIndex) * this.ach);
                    bv = i2;
                    i2 -= this.acg.aW(bc);
                } else {
                    i2 = layoutParams.acw ? this.acg.fn() : (bVar.mIndex * this.ach) + this.acg.fn();
                    bv = this.acg.aW(bc) + i2;
                }
                if (this.Wj == 1) {
                    h(bc, i2, i4, bv, i3);
                } else {
                    h(bc, i4, i2, i3, bv);
                }
                if (layoutParams.acw) {
                    Z(this.aci.Wb, i);
                } else {
                    a(bVar, this.aci.Wb, i);
                }
                a(lVar, this.aci);
                if (this.aci.We && bc.isFocusable()) {
                    if (layoutParams.acw) {
                        this.acj.clear();
                    } else {
                        this.acj.set(bVar.mIndex, false);
                    }
                }
                obj = 1;
            } else if (obj == null) {
                a(lVar, this.aci);
            }
        }
        if (obj == null) {
            a(lVar, this.aci);
        }
        if (this.aci.Wb == -1) {
            fn = this.acf.fn() - bl(this.acf.fn());
        } else {
            fn = bm(this.acf.fo()) - this.acf.fo();
        }
        return fn > 0 ? Math.min(yVar.VY, fn) : 0;
    }

    private void a(l lVar, y yVar) {
        int i = 1;
        if (yVar.VX && !yVar.Wf) {
            if (yVar.VY == 0) {
                if (yVar.Wb == -1) {
                    b(lVar, yVar.Wd);
                } else {
                    a(lVar, yVar.Wc);
                }
            } else if (yVar.Wb == -1) {
                r3 = yVar.Wc;
                int i2 = yVar.Wc;
                r1 = this.ace[0].bu(i2);
                while (i < this.VM) {
                    r2 = this.ace[i].bu(i2);
                    if (r2 > r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r3 - r1;
                if (i < 0) {
                    i = yVar.Wd;
                } else {
                    i = yVar.Wd - Math.min(i, yVar.VY);
                }
                b(lVar, i);
            } else {
                r3 = yVar.Wd;
                r1 = this.ace[0].bv(r3);
                while (i < this.VM) {
                    r2 = this.ace[i].bv(r3);
                    if (r2 < r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r1 - yVar.Wd;
                if (i < 0) {
                    i = yVar.Wc;
                } else {
                    i = Math.min(i, yVar.VY) + yVar.Wc;
                }
                a(lVar, i);
            }
        }
    }

    private static void h(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        h.g(view, layoutParams.leftMargin + i, layoutParams.topMargin + i2, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void Z(int i, int i2) {
        for (int i3 = 0; i3 < this.VM; i3++) {
            if (!this.ace[i3].acG.isEmpty()) {
                a(this.ace[i3], i, i2);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int i3 = bVar.acJ;
        if (i == -1) {
            if (i3 + bVar.gP() <= i2) {
                this.acj.set(bVar.mIndex, false);
            }
        } else if (bVar.gR() - i3 >= i2) {
            this.acj.set(bVar.mIndex, false);
        }
    }

    private int bl(int i) {
        int bu = this.ace[0].bu(i);
        for (int i2 = 1; i2 < this.VM; i2++) {
            int bu2 = this.ace[i2].bu(i);
            if (bu2 < bu) {
                bu = bu2;
            }
        }
        return bu;
    }

    private int bm(int i) {
        int bv = this.ace[0].bv(i);
        for (int i2 = 1; i2 < this.VM; i2++) {
            int bv2 = this.ace[i2].bv(i);
            if (bv2 > bv) {
                bv = bv2;
            }
        }
        return bv;
    }

    private void a(l lVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.acf.aV(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.acw) {
                    int i2 = 0;
                    while (i2 < this.VM) {
                        if (this.ace[i2].acG.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.VM; i2++) {
                        this.ace[i2].gT();
                    }
                } else if (layoutParams.acv.acG.size() != 1) {
                    layoutParams.acv.gT();
                } else {
                    return;
                }
                a(childAt, lVar);
            } else {
                return;
            }
        }
    }

    private void b(l lVar, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.acf.aU(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.acw) {
                    int i2 = 0;
                    while (i2 < this.VM) {
                        if (this.ace[i2].acG.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.VM; i2++) {
                        this.ace[i2].gS();
                    }
                } else if (layoutParams.acv.acG.size() != 1) {
                    layoutParams.acv.gS();
                } else {
                    return;
                }
                a(childAt, lVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean bn(int i) {
        if (this.Wj == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.Wy) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.Wy) != eY()) {
            return false;
        }
        return true;
    }

    public final boolean eW() {
        return this.Wj == 1;
    }

    public final boolean eV() {
        return this.Wj == 0;
    }

    public final int a(int i, l lVar, p pVar) {
        return c(i, lVar, pVar);
    }

    public final int b(int i, l lVar, p pVar) {
        return c(i, lVar, pVar);
    }

    private int bo(int i) {
        if (getChildCount() != 0) {
            if ((i < gM()) != this.Wy) {
                return -1;
            }
            return 1;
        } else if (this.Wy) {
            return 1;
        } else {
            return -1;
        }
    }

    public final void a(RecyclerView recyclerView, int i) {
        o anonymousClass1 = new z(this, recyclerView.getContext()) {
            final /* synthetic */ StaggeredGridLayoutManager act;

            public final PointF aS(int i) {
                int a = this.act.bo(i);
                if (a == 0) {
                    return null;
                }
                if (this.act.Wj == 0) {
                    return new PointF((float) a, 0.0f);
                }
                return new PointF(0.0f, (float) a);
            }
        };
        anonymousClass1.ZM = 0;
        a(anonymousClass1);
    }

    public final void aT(int i) {
        if (!(this.aco == null || this.aco.WQ == i)) {
            SavedState savedState = this.aco;
            savedState.acD = null;
            savedState.acC = 0;
            savedState.WQ = -1;
            savedState.acB = -1;
        }
        this.WB = i;
        this.WC = Integer.MIN_VALUE;
        requestLayout();
    }

    private int c(int i, l lVar, p pVar) {
        int gL;
        int i2;
        if (i > 0) {
            gL = gL();
            i2 = 1;
        } else {
            i2 = -1;
            gL = gM();
        }
        this.aci.VX = true;
        a(gL, pVar);
        bk(i2);
        this.aci.VZ = this.aci.Wa + gL;
        int abs = Math.abs(i);
        this.aci.VY = abs;
        i2 = a(lVar, this.aci, pVar);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.acf.aW(-i);
        this.acm = this.Wy;
        return i;
    }

    private int gL() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : h.bd(getChildAt(childCount - 1));
    }

    private int gM() {
        if (getChildCount() == 0) {
            return 0;
        }
        return h.bd(getChildAt(0));
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

    public final View a(View view, int i, l lVar, p pVar) {
        int i2 = 0;
        if (getChildCount() == 0) {
            return null;
        }
        View be = be(view);
        if (be == null) {
            return null;
        }
        int i3;
        eX();
        switch (i) {
            case 1:
                i3 = -1;
                break;
            case 2:
                i3 = 1;
                break;
            case 17:
                if (this.Wj != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 33:
                if (this.Wj != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 66:
                if (this.Wj != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            case 130:
                if (this.Wj != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            default:
                i3 = Integer.MIN_VALUE;
                break;
        }
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        int gL;
        View ac;
        LayoutParams layoutParams = (LayoutParams) be.getLayoutParams();
        boolean z = layoutParams.acw;
        b bVar = layoutParams.acv;
        if (i3 == 1) {
            gL = gL();
        } else {
            gL = gM();
        }
        a(gL, pVar);
        bk(i3);
        this.aci.VZ = this.aci.Wa + gL;
        this.aci.VY = (int) (0.33333334f * ((float) this.acf.fp()));
        this.aci.We = true;
        this.aci.VX = false;
        a(lVar, this.aci, pVar);
        this.acm = this.Wy;
        if (!z) {
            ac = bVar.ac(gL, i3);
            if (!(ac == null || ac == be)) {
                return ac;
            }
        }
        if (bn(i3)) {
            for (int i4 = this.VM - 1; i4 >= 0; i4--) {
                View ac2 = this.ace[i4].ac(gL, i3);
                if (ac2 != null && ac2 != be) {
                    return ac2;
                }
            }
        } else {
            while (i2 < this.VM) {
                ac = this.ace[i2].ac(gL, i3);
                if (ac != null && ac != be) {
                    return ac;
                }
                i2++;
            }
        }
        return null;
    }
}
