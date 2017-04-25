package android.support.v7.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.f;
import android.support.v4.view.y;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ab.AnonymousClass2;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends h {
    private boolean WA;
    int WB;
    int WC;
    private boolean WD;
    SavedState WE;
    final a WF;
    int Wj;
    private c Wu;
    ab Wv;
    private boolean Ww;
    private boolean Wx;
    boolean Wy;
    private boolean Wz;

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
        int WR;
        boolean WS;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.WQ = parcel.readInt();
            this.WR = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.WS = z;
        }

        public SavedState(SavedState savedState) {
            this.WQ = savedState.WQ;
            this.WR = savedState.WR;
            this.WS = savedState.WS;
        }

        final boolean fh() {
            return this.WQ >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.WQ);
            parcel.writeInt(this.WR);
            parcel.writeInt(this.WS ? 1 : 0);
        }
    }

    class a {
        final /* synthetic */ LinearLayoutManager WG;
        int WH;
        boolean WI;
        int kB;

        a(LinearLayoutManager linearLayoutManager) {
            this.WG = linearLayoutManager;
        }

        final void fg() {
            this.WH = this.WI ? this.WG.Wv.fo() : this.WG.Wv.fn();
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.kB + ", mCoordinate=" + this.WH + ", mLayoutFromEnd=" + this.WI + '}';
        }

        public final void aS(View view) {
            if (this.WI) {
                this.WH = this.WG.Wv.aV(view) + this.WG.Wv.fm();
            } else {
                this.WH = this.WG.Wv.aU(view);
            }
            this.kB = h.bd(view);
        }
    }

    protected static class b {
        public boolean NJ;
        public int WJ;
        public boolean WK;
        public boolean mFinished;

        protected b() {
        }
    }

    static class c {
        boolean VX = true;
        int VY;
        int VZ;
        int WL;
        int WM = 0;
        boolean WN = false;
        int WO;
        List<s> WP = null;
        int Wa;
        int Wb;
        boolean Wf;
        int vI;

        c() {
        }

        final boolean k(p pVar) {
            return this.VZ >= 0 && this.VZ < pVar.getItemCount();
        }

        final View a(l lVar) {
            if (this.WP != null) {
                int size = this.WP.size();
                int i = 0;
                while (i < size) {
                    View view = ((s) this.WP.get(i)).aal;
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    if (layoutParams.Zy.isRemoved() || this.VZ != layoutParams.Zy.gg()) {
                        i++;
                    } else {
                        aT(view);
                        return view;
                    }
                }
                return null;
            }
            View bc = lVar.bc(this.VZ);
            this.VZ += this.Wa;
            return bc;
        }

        public final void aT(View view) {
            View view2;
            int size = this.WP.size();
            View view3 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int gg;
                View view4;
                view2 = ((s) this.WP.get(i2)).aal;
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                if (!(view2 == view || layoutParams.Zy.isRemoved())) {
                    gg = (layoutParams.Zy.gg() - this.VZ) * this.Wa;
                    if (gg >= 0 && gg < i) {
                        if (gg == 0) {
                            break;
                        }
                        view4 = view2;
                        i2++;
                        view3 = view4;
                        i = gg;
                    }
                }
                gg = i;
                view4 = view3;
                i2++;
                view3 = view4;
                i = gg;
            }
            view2 = view3;
            if (view2 == null) {
                this.VZ = -1;
            } else {
                this.VZ = ((LayoutParams) view2.getLayoutParams()).Zy.gg();
            }
        }
    }

    public LinearLayoutManager() {
        this(1, false);
    }

    public LinearLayoutManager(int i, boolean z) {
        this.Wx = false;
        this.Wy = false;
        this.Wz = false;
        this.WA = true;
        this.WB = -1;
        this.WC = Integer.MIN_VALUE;
        this.WE = null;
        this.WF = new a(this);
        setOrientation(i);
        q(null);
        if (this.Wx) {
            this.Wx = false;
            requestLayout();
        }
        this.Zt = true;
    }

    public LayoutParams eR() {
        return new LayoutParams(-2, -2);
    }

    public final void a(RecyclerView recyclerView, l lVar) {
        super.a(recyclerView, lVar);
        if (this.WD) {
            d(lVar);
            lVar.clear();
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.setFromIndex(fe());
            a.setToIndex(ff());
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.WE != null) {
            return new SavedState(this.WE);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            eZ();
            boolean z = this.Ww ^ this.Wy;
            savedState.WS = z;
            View fd;
            if (z) {
                fd = fd();
                savedState.WR = this.Wv.fo() - this.Wv.aV(fd);
                savedState.WQ = h.bd(fd);
                return savedState;
            }
            fd = fc();
            savedState.WQ = h.bd(fd);
            savedState.WR = this.Wv.aU(fd) - this.Wv.fn();
            return savedState;
        }
        savedState.WQ = -1;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.WE = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final boolean eV() {
        return this.Wj == 0;
    }

    public final boolean eW() {
        return this.Wj == 1;
    }

    public final void setOrientation(int i) {
        if (i == 0 || i == 1) {
            q(null);
            if (i != this.Wj) {
                this.Wj = i;
                this.Wv = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
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

    public final View aR(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int bd = i - h.bd(getChildAt(0));
        if (bd >= 0 && bd < childCount) {
            View childAt = getChildAt(bd);
            if (h.bd(childAt) == i) {
                return childAt;
            }
        }
        return super.aR(i);
    }

    private int a(p pVar) {
        int i;
        if (pVar.ZM != -1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.Wv.fp();
        }
        return 0;
    }

    public void a(RecyclerView recyclerView, int i) {
        o anonymousClass1 = new z(this, recyclerView.getContext()) {
            final /* synthetic */ LinearLayoutManager WG;

            public final PointF aS(int i) {
                return this.WG.aS(i);
            }
        };
        anonymousClass1.ZM = 0;
        a(anonymousClass1);
    }

    public final PointF aS(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < h.bd(getChildAt(0))) {
            z = true;
        }
        if (z != this.Wy) {
            i2 = -1;
        }
        if (this.Wj == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void c(l lVar, p pVar) {
        if (!(this.WE == null && this.WB == -1) && pVar.getItemCount() == 0) {
            d(lVar);
            return;
        }
        Object obj;
        View aR;
        int fm;
        int aW;
        int fn;
        int min;
        int fo;
        if (this.WE != null && this.WE.fh()) {
            this.WB = this.WE.WQ;
        }
        eZ();
        this.Wu.VX = false;
        eX();
        a aVar = this.WF;
        aVar.kB = -1;
        aVar.WH = Integer.MIN_VALUE;
        aVar.WI = false;
        this.WF.WI = this.Wy ^ this.Wz;
        a aVar2 = this.WF;
        if (pVar.aac || this.WB == -1) {
            obj = null;
        } else if (this.WB < 0 || this.WB >= pVar.getItemCount()) {
            this.WB = -1;
            this.WC = Integer.MIN_VALUE;
            obj = null;
        } else {
            aVar2.kB = this.WB;
            if (this.WE == null || !this.WE.fh()) {
                if (this.WC == Integer.MIN_VALUE) {
                    aR = aR(this.WB);
                    if (aR == null) {
                        if (getChildCount() > 0) {
                            aVar2.WI = (this.WB < h.bd(getChildAt(0))) == this.Wy;
                        }
                        aVar2.fg();
                    } else if (this.Wv.aW(aR) > this.Wv.fp()) {
                        aVar2.fg();
                    } else if (this.Wv.aU(aR) - this.Wv.fn() < 0) {
                        aVar2.WH = this.Wv.fn();
                        aVar2.WI = false;
                    } else if (this.Wv.fo() - this.Wv.aV(aR) < 0) {
                        aVar2.WH = this.Wv.fo();
                        aVar2.WI = true;
                    } else {
                        aVar2.WH = aVar2.WI ? this.Wv.aV(aR) + this.Wv.fm() : this.Wv.aU(aR);
                    }
                    obj = 1;
                } else {
                    aVar2.WI = this.Wy;
                    if (this.Wy) {
                        aVar2.WH = this.Wv.fo() - this.WC;
                    } else {
                        aVar2.WH = this.Wv.fn() + this.WC;
                    }
                }
                obj = 1;
            } else {
                aVar2.WI = this.WE.WS;
                if (aVar2.WI) {
                    aVar2.WH = this.Wv.fo() - this.WE.WR;
                } else {
                    aVar2.WH = this.Wv.fn() + this.WE.WR;
                }
                obj = 1;
            }
        }
        if (obj == null) {
            if (getChildCount() != 0) {
                View view;
                if (this.Zq == null) {
                    view = null;
                } else {
                    aR = this.Zq.getFocusedChild();
                    view = (aR == null || this.Yh.aO(aR)) ? null : aR;
                }
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    if (layoutParams.Zy.isRemoved() || layoutParams.Zy.gg() < 0 || layoutParams.Zy.gg() >= pVar.getItemCount()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        fm = aVar2.WG.Wv.fm();
                        if (fm >= 0) {
                            aVar2.aS(view);
                        } else {
                            aVar2.kB = h.bd(view);
                            if (aVar2.WI) {
                                fm = (aVar2.WG.Wv.fo() - fm) - aVar2.WG.Wv.aV(view);
                                aVar2.WH = aVar2.WG.Wv.fo() - fm;
                                if (fm > 0) {
                                    aW = aVar2.WH - aVar2.WG.Wv.aW(view);
                                    fn = aVar2.WG.Wv.fn();
                                    min = aW - (Math.min(aVar2.WG.Wv.aU(view) - fn, 0) + fn);
                                    if (min < 0) {
                                        aVar2.WH = Math.min(fm, -min) + aVar2.WH;
                                    }
                                }
                            } else {
                                aW = aVar2.WG.Wv.aU(view);
                                fn = aW - aVar2.WG.Wv.fn();
                                aVar2.WH = aW;
                                if (fn > 0) {
                                    fm = (aVar2.WG.Wv.fo() - Math.min(0, (aVar2.WG.Wv.fo() - fm) - aVar2.WG.Wv.aV(view))) - (aW + aVar2.WG.Wv.aW(view));
                                    if (fm < 0) {
                                        aVar2.WH -= Math.min(fn, -fm);
                                    }
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            aVar2.fg();
                            if (this.Wz) {
                                fm = pVar.getItemCount() - 1;
                            } else {
                                fm = 0;
                            }
                            aVar2.kB = fm;
                        }
                    }
                }
                if (this.Ww == this.Wz) {
                    aR = aVar2.WI ? d(lVar, pVar) : e(lVar, pVar);
                    if (aR != null) {
                        aVar2.aS(aR);
                        if (!pVar.aac && eU()) {
                            obj = (this.Wv.aU(aR) >= this.Wv.fo() || this.Wv.aV(aR) < this.Wv.fn()) ? 1 : null;
                            if (obj != null) {
                                aVar2.WH = aVar2.WI ? this.Wv.fo() : this.Wv.fn();
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            aVar2.fg();
                            if (this.Wz) {
                                fm = 0;
                            } else {
                                fm = pVar.getItemCount() - 1;
                            }
                            aVar2.kB = fm;
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                aVar2.fg();
                if (this.Wz) {
                    fm = pVar.getItemCount() - 1;
                } else {
                    fm = 0;
                }
                aVar2.kB = fm;
            }
        }
        fm = a(pVar);
        if (this.Wu.WO >= 0) {
            min = 0;
        } else {
            min = fm;
            fm = 0;
        }
        min += this.Wv.fn();
        fm += this.Wv.getEndPadding();
        if (!(!pVar.aac || this.WB == -1 || this.WC == Integer.MIN_VALUE)) {
            View aR2 = aR(this.WB);
            if (aR2 != null) {
                if (this.Wy) {
                    fo = (this.Wv.fo() - this.Wv.aV(aR2)) - this.WC;
                } else {
                    fo = this.WC - (this.Wv.aU(aR2) - this.Wv.fn());
                }
                if (fo > 0) {
                    min += fo;
                } else {
                    fm -= fo;
                }
            }
        }
        fo = this.WF.WI ? this.Wy ? 1 : -1 : this.Wy ? -1 : 1;
        a(lVar, pVar, this.WF, fo);
        b(lVar);
        this.Wu.Wf = fa();
        this.Wu.WN = pVar.aac;
        if (this.WF.WI) {
            b(this.WF);
            this.Wu.WM = min;
            a(lVar, this.Wu, pVar, false);
            min = this.Wu.vI;
            aW = this.Wu.VZ;
            if (this.Wu.VY > 0) {
                fm += this.Wu.VY;
            }
            a(this.WF);
            this.Wu.WM = fm;
            c cVar = this.Wu;
            cVar.VZ += this.Wu.Wa;
            a(lVar, this.Wu, pVar, false);
            fo = this.Wu.vI;
            if (this.Wu.VY > 0) {
                fm = this.Wu.VY;
                I(aW, min);
                this.Wu.WM = fm;
                a(lVar, this.Wu, pVar, false);
                fm = this.Wu.vI;
            } else {
                fm = min;
            }
            min = fm;
            fm = fo;
        } else {
            a(this.WF);
            this.Wu.WM = fm;
            a(lVar, this.Wu, pVar, false);
            fm = this.Wu.vI;
            fo = this.Wu.VZ;
            if (this.Wu.VY > 0) {
                min += this.Wu.VY;
            }
            b(this.WF);
            this.Wu.WM = min;
            c cVar2 = this.Wu;
            cVar2.VZ += this.Wu.Wa;
            a(lVar, this.Wu, pVar, false);
            min = this.Wu.vI;
            if (this.Wu.VY > 0) {
                aW = this.Wu.VY;
                H(fo, fm);
                this.Wu.WM = aW;
                a(lVar, this.Wu, pVar, false);
                fm = this.Wu.vI;
            }
        }
        if (getChildCount() <= 0) {
            fo = min;
            min = fm;
        } else if ((this.Wy ^ this.Wz) != 0) {
            fo = a(fm, lVar, pVar, true);
            min += fo;
            fm += fo;
            fo = b(min, lVar, pVar, false);
            fm += fo;
            fo = min + fo;
            min = fm;
        } else {
            fo = b(min, lVar, pVar, true);
            min += fo;
            fm += fo;
            fo = a(fm, lVar, pVar, false);
            fm += fo;
            fo = min + fo;
            min = fm;
        }
        if (pVar.aae && getChildCount() != 0 && !pVar.aac && eU()) {
            int i = 0;
            fn = 0;
            List list = lVar.ZH;
            int size = list.size();
            int bd = h.bd(getChildAt(0));
            int i2 = 0;
            while (i2 < size) {
                s sVar = (s) list.get(i2);
                if (sVar.isRemoved()) {
                    fm = fn;
                    aW = i;
                } else {
                    if (((sVar.gg() < bd) != this.Wy ? -1 : 1) == -1) {
                        aW = this.Wv.aW(sVar.aal) + i;
                        fm = fn;
                    } else {
                        fm = this.Wv.aW(sVar.aal) + fn;
                        aW = i;
                    }
                }
                i = aW;
                i2++;
                fn = fm;
            }
            this.Wu.WP = list;
            if (i > 0) {
                I(h.bd(fc()), fo);
                this.Wu.WM = i;
                this.Wu.VY = 0;
                this.Wu.aT(null);
                a(lVar, this.Wu, pVar, false);
            }
            if (fn > 0) {
                H(h.bd(fd()), min);
                this.Wu.WM = fn;
                this.Wu.VY = 0;
                this.Wu.aT(null);
                a(lVar, this.Wu, pVar, false);
            }
            this.Wu.WP = null;
        }
        if (!pVar.aac) {
            this.WB = -1;
            this.WC = Integer.MIN_VALUE;
            ab abVar = this.Wv;
            abVar.XY = abVar.fp();
        }
        this.Ww = this.Wz;
        this.WE = null;
    }

    void a(l lVar, p pVar, a aVar, int i) {
    }

    private int a(int i, l lVar, p pVar, boolean z) {
        int fo = this.Wv.fo() - i;
        if (fo <= 0) {
            return 0;
        }
        fo = -c(-fo, lVar, pVar);
        int i2 = i + fo;
        if (!z) {
            return fo;
        }
        i2 = this.Wv.fo() - i2;
        if (i2 <= 0) {
            return fo;
        }
        this.Wv.aW(i2);
        return fo + i2;
    }

    private int b(int i, l lVar, p pVar, boolean z) {
        int fn = i - this.Wv.fn();
        if (fn <= 0) {
            return 0;
        }
        fn = -c(fn, lVar, pVar);
        int i2 = i + fn;
        if (!z) {
            return fn;
        }
        i2 -= this.Wv.fn();
        if (i2 <= 0) {
            return fn;
        }
        this.Wv.aW(-i2);
        return fn - i2;
    }

    private void a(a aVar) {
        H(aVar.kB, aVar.WH);
    }

    private void H(int i, int i2) {
        this.Wu.VY = this.Wv.fo() - i2;
        this.Wu.Wa = this.Wy ? -1 : 1;
        this.Wu.VZ = i;
        this.Wu.Wb = 1;
        this.Wu.vI = i2;
        this.Wu.WL = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        I(aVar.kB, aVar.WH);
    }

    private void I(int i, int i2) {
        this.Wu.VY = i2 - this.Wv.fn();
        this.Wu.VZ = i;
        this.Wu.Wa = this.Wy ? 1 : -1;
        this.Wu.Wb = -1;
        this.Wu.vI = i2;
        this.Wu.WL = Integer.MIN_VALUE;
    }

    protected final boolean eY() {
        return y.I(this.Zq) == 1;
    }

    final void eZ() {
        if (this.Wu == null) {
            this.Wu = new c();
        }
        if (this.Wv == null) {
            ab anonymousClass1;
            switch (this.Wj) {
                case 0:
                    anonymousClass1 = new android.support.v7.widget.ab.AnonymousClass1(this);
                    break;
                case 1:
                    anonymousClass1 = new AnonymousClass2(this);
                    break;
                default:
                    throw new IllegalArgumentException("invalid orientation");
            }
            this.Wv = anonymousClass1;
        }
    }

    public final void aT(int i) {
        this.WB = i;
        this.WC = Integer.MIN_VALUE;
        if (this.WE != null) {
            this.WE.WQ = -1;
        }
        requestLayout();
    }

    public int a(int i, l lVar, p pVar) {
        if (this.Wj == 1) {
            return 0;
        }
        return c(i, lVar, pVar);
    }

    public int b(int i, l lVar, p pVar) {
        if (this.Wj == 0) {
            return 0;
        }
        return c(i, lVar, pVar);
    }

    public final int b(p pVar) {
        return h(pVar);
    }

    public final int c(p pVar) {
        return h(pVar);
    }

    public final int d(p pVar) {
        return i(pVar);
    }

    public final int e(p pVar) {
        return i(pVar);
    }

    public final int f(p pVar) {
        return j(pVar);
    }

    public final int g(p pVar) {
        return j(pVar);
    }

    private int h(p pVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eZ();
        ab abVar = this.Wv;
        View O = O(!this.WA);
        if (this.WA) {
            z = false;
        }
        return ah.a(pVar, abVar, O, P(z), this, this.WA, this.Wy);
    }

    private int i(p pVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eZ();
        ab abVar = this.Wv;
        View O = O(!this.WA);
        if (this.WA) {
            z = false;
        }
        return ah.a(pVar, abVar, O, P(z), this, this.WA);
    }

    private int j(p pVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eZ();
        ab abVar = this.Wv;
        View O = O(!this.WA);
        if (this.WA) {
            z = false;
        }
        return ah.b(pVar, abVar, O, P(z), this, this.WA);
    }

    private void a(int i, int i2, boolean z, p pVar) {
        int i3 = -1;
        int i4 = 1;
        this.Wu.Wf = fa();
        this.Wu.WM = a(pVar);
        this.Wu.Wb = i;
        View fd;
        c cVar;
        if (i == 1) {
            c cVar2 = this.Wu;
            cVar2.WM += this.Wv.getEndPadding();
            fd = fd();
            cVar = this.Wu;
            if (!this.Wy) {
                i3 = 1;
            }
            cVar.Wa = i3;
            this.Wu.VZ = h.bd(fd) + this.Wu.Wa;
            this.Wu.vI = this.Wv.aV(fd);
            i3 = this.Wv.aV(fd) - this.Wv.fo();
        } else {
            fd = fc();
            cVar = this.Wu;
            cVar.WM += this.Wv.fn();
            cVar = this.Wu;
            if (!this.Wy) {
                i4 = -1;
            }
            cVar.Wa = i4;
            this.Wu.VZ = h.bd(fd) + this.Wu.Wa;
            this.Wu.vI = this.Wv.aU(fd);
            i3 = (-this.Wv.aU(fd)) + this.Wv.fn();
        }
        this.Wu.VY = i2;
        if (z) {
            c cVar3 = this.Wu;
            cVar3.VY -= i3;
        }
        this.Wu.WL = i3;
    }

    private boolean fa() {
        return this.Wv.getMode() == 0 && this.Wv.getEnd() == 0;
    }

    private int c(int i, l lVar, p pVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.Wu.VX = true;
        eZ();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, pVar);
        int a = this.Wu.WL + a(lVar, this.Wu, pVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.Wv.aW(-i);
        this.Wu.WO = i;
        return i;
    }

    public final void q(String str) {
        if (this.WE == null) {
            super.q(str);
        }
    }

    private void a(l lVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, lVar);
                }
                return;
            }
            while (i > i2) {
                a(i, lVar);
                i--;
            }
        }
    }

    private void a(l lVar, c cVar) {
        if (cVar.VX && !cVar.Wf) {
            int i;
            int childCount;
            int end;
            if (cVar.Wb == -1) {
                i = cVar.WL;
                childCount = getChildCount();
                if (i >= 0) {
                    end = this.Wv.getEnd() - i;
                    if (this.Wy) {
                        for (i = 0; i < childCount; i++) {
                            if (this.Wv.aU(getChildAt(i)) < end) {
                                a(lVar, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = childCount - 1; i >= 0; i--) {
                        if (this.Wv.aU(getChildAt(i)) < end) {
                            a(lVar, childCount - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            childCount = cVar.WL;
            if (childCount >= 0) {
                end = getChildCount();
                if (this.Wy) {
                    for (i = end - 1; i >= 0; i--) {
                        if (this.Wv.aV(getChildAt(i)) > childCount) {
                            a(lVar, end - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < end; i++) {
                    if (this.Wv.aV(getChildAt(i)) > childCount) {
                        a(lVar, 0, i);
                        return;
                    }
                }
            }
        }
    }

    private int a(l lVar, c cVar, p pVar, boolean z) {
        int i = cVar.VY;
        if (cVar.WL != Integer.MIN_VALUE) {
            if (cVar.VY < 0) {
                cVar.WL += cVar.VY;
            }
            a(lVar, cVar);
        }
        int i2 = cVar.VY + cVar.WM;
        b bVar = new b();
        while (true) {
            if ((!cVar.Wf && i2 <= 0) || !cVar.k(pVar)) {
                break;
            }
            bVar.WJ = 0;
            bVar.mFinished = false;
            bVar.WK = false;
            bVar.NJ = false;
            a(lVar, pVar, cVar, bVar);
            if (!bVar.mFinished) {
                cVar.vI += bVar.WJ * cVar.Wb;
                if (!(bVar.WK && this.Wu.WP == null && pVar.aac)) {
                    cVar.VY -= bVar.WJ;
                    i2 -= bVar.WJ;
                }
                if (cVar.WL != Integer.MIN_VALUE) {
                    cVar.WL += bVar.WJ;
                    if (cVar.VY < 0) {
                        cVar.WL += cVar.VY;
                    }
                    a(lVar, cVar);
                }
                if (z && bVar.NJ) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.VY;
    }

    void a(l lVar, p pVar, c cVar, b bVar) {
        View a = cVar.a(lVar);
        if (a == null) {
            bVar.mFinished = true;
            return;
        }
        int paddingRight;
        int i;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (cVar.WP == null) {
            if (this.Wy == (cVar.Wb == -1)) {
                super.c(a, -1, false);
            } else {
                super.c(a, 0, false);
            }
        } else {
            if (this.Wy == (cVar.Wb == -1)) {
                super.c(a, -1, true);
            } else {
                super.c(a, 0, true);
            }
        }
        LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
        Rect bb = this.Zq.bb(a);
        int i2 = (bb.left + bb.right) + 0;
        int i3 = (bb.bottom + bb.top) + 0;
        i2 = h.b(this.Zx, this.Zv, i2 + (((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin), layoutParams2.width, eV());
        i3 = h.b(this.QW, this.Zw, i3 + (((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin), layoutParams2.height, eW());
        if (a(a, i2, i3, layoutParams2)) {
            a.measure(i2, i3);
        }
        bVar.WJ = this.Wv.aW(a);
        if (this.Wj == 1) {
            if (eY()) {
                paddingRight = this.Zx - getPaddingRight();
                i3 = paddingRight - this.Wv.aX(a);
            } else {
                i3 = getPaddingLeft();
                paddingRight = this.Wv.aX(a) + i3;
            }
            if (cVar.Wb == -1) {
                i2 = cVar.vI - bVar.WJ;
                i = i3;
                i3 = paddingRight;
                paddingRight = cVar.vI;
            } else {
                i2 = cVar.vI;
                i = i3;
                i3 = paddingRight;
                paddingRight = cVar.vI + bVar.WJ;
            }
        } else {
            i2 = getPaddingTop();
            paddingRight = this.Wv.aX(a) + i2;
            if (cVar.Wb == -1) {
                i3 = cVar.vI;
                i = cVar.vI - bVar.WJ;
            } else {
                i = cVar.vI;
                i3 = cVar.vI + bVar.WJ;
            }
        }
        h.g(a, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, paddingRight - layoutParams.bottomMargin);
        if (layoutParams.Zy.isRemoved() || layoutParams.Zy.gu()) {
            bVar.WK = true;
        }
        bVar.NJ = a.isFocusable();
    }

    final boolean fb() {
        if (!(this.Zw == 1073741824 || this.Zv == 1073741824)) {
            boolean z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final int aU(int i) {
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (this.Wj != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.Wj != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                return this.Wj == 0 ? 1 : Integer.MIN_VALUE;
            case 130:
                return this.Wj == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View fc() {
        return getChildAt(this.Wy ? getChildCount() - 1 : 0);
    }

    private View fd() {
        return getChildAt(this.Wy ? 0 : getChildCount() - 1);
    }

    private View O(boolean z) {
        if (this.Wy) {
            return a(getChildCount() - 1, -1, z, true);
        }
        return a(0, getChildCount(), z, true);
    }

    private View P(boolean z) {
        if (this.Wy) {
            return a(0, getChildCount(), z, true);
        }
        return a(getChildCount() - 1, -1, z, true);
    }

    private View d(l lVar, p pVar) {
        return this.Wy ? f(lVar, pVar) : g(lVar, pVar);
    }

    private View e(l lVar, p pVar) {
        return this.Wy ? g(lVar, pVar) : f(lVar, pVar);
    }

    private View f(l lVar, p pVar) {
        return a(lVar, pVar, 0, getChildCount(), pVar.getItemCount());
    }

    private View g(l lVar, p pVar) {
        return a(lVar, pVar, getChildCount() - 1, -1, pVar.getItemCount());
    }

    View a(l lVar, p pVar, int i, int i2, int i3) {
        View view = null;
        eZ();
        int fn = this.Wv.fn();
        int fo = this.Wv.fo();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bd = h.bd(childAt);
            if (bd >= 0 && bd < i3) {
                if (((LayoutParams) childAt.getLayoutParams()).Zy.isRemoved()) {
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

    public final int fe() {
        View a = a(0, getChildCount(), false, true);
        return a == null ? -1 : h.bd(a);
    }

    public final int ff() {
        View a = a(getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return h.bd(a);
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        eZ();
        int fn = this.Wv.fn();
        int fo = this.Wv.fo();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int aU = this.Wv.aU(childAt);
            int aV = this.Wv.aV(childAt);
            if (aU < fo && aV > fn) {
                if (!z) {
                    return childAt;
                }
                if (aU >= fn && aV <= fo) {
                    return childAt;
                }
                if (view == null) {
                    i += i3;
                    view = childAt;
                }
            }
            childAt = view;
            i += i3;
            view = childAt;
        }
        return view;
    }

    public View a(View view, int i, l lVar, p pVar) {
        eX();
        if (getChildCount() == 0) {
            return null;
        }
        int aU = aU(i);
        if (aU == Integer.MIN_VALUE) {
            return null;
        }
        View e;
        eZ();
        if (aU == -1) {
            e = e(lVar, pVar);
        } else {
            e = d(lVar, pVar);
        }
        if (e == null) {
            return null;
        }
        View fc;
        eZ();
        a(aU, (int) (0.33333334f * ((float) this.Wv.fp())), false, pVar);
        this.Wu.WL = Integer.MIN_VALUE;
        this.Wu.VX = false;
        a(lVar, this.Wu, pVar, true);
        if (aU == -1) {
            fc = fc();
        } else {
            fc = fd();
        }
        if (fc == e || !fc.isFocusable()) {
            return null;
        }
        return fc;
    }

    public boolean eU() {
        return this.WE == null && this.Ww == this.Wz;
    }
}
