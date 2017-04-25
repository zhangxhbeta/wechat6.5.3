package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int[] xv = new int[]{16842931};
    private static final Comparator<b> xx = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((b) obj).position - ((b) obj2).position;
        }
    };
    private static final Interpolator xy = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private static final h yq = new h();
    private final ArrayList<b> eg = new ArrayList();
    private final Rect ep = new Rect();
    private VelocityTracker fj;
    private int fk = -1;
    private boolean iB;
    private int iD;
    private boolean oQ;
    private float wL;
    private float wM;
    t xA;
    public int xB;
    private int xC = -1;
    private Parcelable xD = null;
    private ClassLoader xE = null;
    private Scroller xF;
    private boolean xG;
    private g xH;
    private int xI;
    private Drawable xJ;
    private int xK;
    private int xL;
    private float xM = -3.4028235E38f;
    private float xN = Float.MAX_VALUE;
    private int xO;
    private int xP;
    private boolean xQ;
    private boolean xR;
    public int xS = 1;
    private boolean xT;
    private int xU;
    private int xV;
    private float xW;
    private float xX;
    private int xY;
    private int xZ;
    private int xe = 0;
    private int xw;
    private final b xz = new b();
    private int ya;
    private int yb;
    private boolean yc;
    private i yd;
    private i ye;
    private boolean yf = true;
    private boolean yg = false;
    private boolean yh;
    private int yi;
    private List<e> yj;
    public e yk;
    private e yl;
    d ym;
    private f yn;
    private int yo;
    private ArrayList<View> yp;
    private final Runnable yr = new Runnable(this) {
        final /* synthetic */ ViewPager ys;

        {
            this.ys = r1;
        }

        public final void run() {
            this.ys.Y(0);
            this.ys.populate();
        }
    };

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public int gravity;
        int position;
        float yv = 0.0f;
        public boolean yx;
        boolean yy;
        int yz;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.xv);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        });
        int position;
        Parcelable yA;
        ClassLoader yB;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.yA, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.yA = parcel.readParcelable(classLoader);
            this.yB = classLoader;
        }
    }

    interface a {
    }

    static class b {
        int position;
        Object yt;
        boolean yu;
        float yv;
        float yw;

        b() {
        }
    }

    interface d {
        void b(t tVar, t tVar2);
    }

    public interface e {
        void W(int i);

        void X(int i);

        void a(int i, float f, int i2);
    }

    public interface f {
    }

    private class g extends DataSetObserver {
        final /* synthetic */ ViewPager ys;

        private g(ViewPager viewPager) {
            this.ys = viewPager;
        }

        public final void onChanged() {
            this.ys.bT();
        }

        public final void onInvalidated() {
            this.ys.bT();
        }
    }

    static class h implements Comparator<View> {
        h() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.yx != layoutParams2.yx) {
                return layoutParams.yx ? 1 : -1;
            } else {
                return layoutParams.position - layoutParams2.position;
            }
        }
    }

    class c extends a {
        final /* synthetic */ ViewPager ys;

        c(ViewPager viewPager) {
            this.ys = viewPager;
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            android.support.v4.view.a.f a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.setScrollable(cb());
            if (accessibilityEvent.getEventType() == 4096 && this.ys.xA != null) {
                a.setItemCount(this.ys.xA.getCount());
                a.setFromIndex(this.ys.xB);
                a.setToIndex(this.ys.xB);
            }
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            bVar.setClassName(ViewPager.class.getName());
            bVar.setScrollable(cb());
            if (this.ys.canScrollHorizontally(1)) {
                bVar.addAction(4096);
            }
            if (this.ys.canScrollHorizontally(-1)) {
                bVar.addAction(8192);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.ys.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.ys.Z(this.ys.xB + 1);
                    return true;
                case 8192:
                    if (!this.ys.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.ys.Z(this.ys.xB - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean cb() {
            return this.ys.xA != null && this.ys.xA.getCount() > 1;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.xF = new Scroller(context2, xy);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.iD = ad.a(viewConfiguration);
        this.xY = (int) (400.0f * f);
        this.xZ = viewConfiguration.getScaledMaximumFlingVelocity();
        this.yd = new i(context2);
        this.ye = new i(context2);
        this.ya = (int) (25.0f * f);
        this.yb = (int) (2.0f * f);
        this.xU = (int) (16.0f * f);
        y.a((View) this, new c(this));
        if (y.F(this) == 0) {
            y.h(this, 1);
        }
        y.b((View) this, new s(this) {
            private final Rect ep = new Rect();
            final /* synthetic */ ViewPager ys;

            {
                this.ys = r2;
            }

            public final ao a(View view, ao aoVar) {
                ao a = y.a(view, aoVar);
                if (a.isConsumed()) {
                    return a;
                }
                Rect rect = this.ep;
                rect.left = a.getSystemWindowInsetLeft();
                rect.top = a.getSystemWindowInsetTop();
                rect.right = a.getSystemWindowInsetRight();
                rect.bottom = a.getSystemWindowInsetBottom();
                int childCount = this.ys.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ao b = y.b(this.ys.getChildAt(i), a);
                    rect.left = Math.min(b.getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(b.getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(b.getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(b.getSystemWindowInsetBottom(), rect.bottom);
                }
                return a.d(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.yr);
        if (!(this.xF == null || this.xF.isFinished())) {
            this.xF.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void Y(int i) {
        int i2 = 0;
        if (this.xe != i) {
            this.xe = i;
            if (this.yn != null) {
                int i3 = i != 0 ? 1 : 0;
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    y.a(getChildAt(i4), i3 != 0 ? 2 : 0, null);
                }
            }
            if (this.yk != null) {
                this.yk.X(i);
            }
            if (this.yj != null) {
                int size = this.yj.size();
                while (i2 < size) {
                    e eVar = (e) this.yj.get(i2);
                    if (eVar != null) {
                        eVar.X(i);
                    }
                    i2++;
                }
            }
            if (this.yl != null) {
                this.yl.X(i);
            }
        }
    }

    public final void a(t tVar) {
        if (this.xA != null) {
            int i;
            this.xA.a(null);
            for (i = 0; i < this.eg.size(); i++) {
                b bVar = (b) this.eg.get(i);
                this.xA.a(this, bVar.position, bVar.yt);
            }
            this.xA.bb();
            this.eg.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).yx) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.xB = 0;
            scrollTo(0, 0);
        }
        t tVar2 = this.xA;
        this.xA = tVar;
        this.xw = 0;
        if (this.xA != null) {
            if (this.xH == null) {
                this.xH = new g();
            }
            this.xA.a(this.xH);
            this.xR = false;
            boolean z = this.yf;
            this.yf = true;
            this.xw = this.xA.getCount();
            if (this.xC >= 0) {
                this.xA.a(this.xD, this.xE);
                a(this.xC, false, true);
                this.xC = -1;
                this.xD = null;
                this.xE = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        if (this.ym != null && tVar2 != tVar) {
            this.ym.b(tVar2, tVar);
        }
    }

    private int bS() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void Z(int i) {
        boolean z;
        this.xR = false;
        if (this.yf) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    public final void k(int i, boolean z) {
        this.xR = false;
        a(i, z, false);
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.xA == null || this.xA.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.xB != i || this.eg.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.xA.getCount()) {
                i = this.xA.getCount() - 1;
            }
            int i3 = this.xS;
            if (i > this.xB + i3 || i < this.xB - i3) {
                for (int i4 = 0; i4 < this.eg.size(); i4++) {
                    ((b) this.eg.get(i4)).yu = true;
                }
            }
            if (this.xB != i) {
                z3 = true;
            }
            if (this.yf) {
                this.xB = i;
                if (z3) {
                    ad(i);
                }
                requestLayout();
                return;
            }
            aa(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int bS;
        b ab = ab(i);
        if (ab != null) {
            bS = (int) (((float) bS()) * Math.max(this.xM, Math.min(ab.yw, this.xN)));
        } else {
            bS = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.xF == null || this.xF.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.xG ? this.xF.getCurrX() : this.xF.getStartX();
                    this.xF.abortAnimation();
                    setScrollingCacheEnabled(false);
                    i3 = currX;
                } else {
                    i3 = getScrollX();
                }
                int scrollY = getScrollY();
                bS -= i3;
                int i4 = 0 - scrollY;
                if (bS == 0 && i4 == 0) {
                    r(false);
                    populate();
                    Y(0);
                } else {
                    setScrollingCacheEnabled(true);
                    Y(2);
                    currX = bS();
                    int i5 = currX / 2;
                    float sin = (((float) i5) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(bS))) / ((float) currX)) - 0.5f)) * 0.4712389167638204d))))) + ((float) i5);
                    int abs = Math.abs(i2);
                    i5 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4 : (int) (((((float) Math.abs(bS)) / ((((float) currX) * 1.0f) + ((float) this.xI))) + 1.0f) * 100.0f), 600);
                    this.xG = false;
                    this.xF.startScroll(i3, scrollY, bS, i4, i5);
                    y.E(this);
                }
            }
            if (z2) {
                ad(i);
                return;
            }
            return;
        }
        if (z2) {
            ad(i);
        }
        r(false);
        scrollTo(bS, 0);
        ac(bS);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.yo == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.yp.get(i2)).getLayoutParams()).yz;
    }

    final e a(e eVar) {
        e eVar2 = this.yl;
        this.yl = eVar;
        return eVar2;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.xJ;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.xJ;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private b k(int i, int i2) {
        b bVar = new b();
        bVar.position = i;
        bVar.yt = this.xA.b(this, i);
        bVar.yv = 1.0f;
        if (i2 < 0 || i2 >= this.eg.size()) {
            this.eg.add(bVar);
        } else {
            this.eg.add(i2, bVar);
        }
        return bVar;
    }

    final void bT() {
        int max;
        int count = this.xA.getCount();
        this.xw = count;
        boolean z = this.eg.size() < (this.xS * 2) + 1 && this.eg.size() < count;
        boolean z2 = false;
        int i = this.xB;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.eg.size()) {
            int i3;
            boolean z4;
            boolean z5;
            b bVar = (b) this.eg.get(i2);
            int j = this.xA.j(bVar.yt);
            if (j != -1) {
                if (j == -2) {
                    this.eg.remove(i2);
                    i2--;
                    if (!z2) {
                        z2 = true;
                    }
                    this.xA.a(this, bVar.position, bVar.yt);
                    if (this.xB == bVar.position) {
                        i3 = i2;
                        z4 = z2;
                        max = Math.max(0, Math.min(this.xB, count - 1));
                        z5 = true;
                    } else {
                        i3 = i2;
                        z4 = z2;
                        max = i;
                        z5 = true;
                    }
                } else if (bVar.position != j) {
                    if (bVar.position == this.xB) {
                        i = j;
                    }
                    bVar.position = j;
                    i3 = i2;
                    z4 = z2;
                    max = i;
                    z5 = true;
                }
                z3 = z5;
                i = max;
                z2 = z4;
                i2 = i3 + 1;
            }
            i3 = i2;
            z4 = z2;
            max = i;
            z5 = z3;
            z3 = z5;
            i = max;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.xA.bb();
        }
        Collections.sort(this.eg, xx);
        if (z3) {
            max = getChildCount();
            for (i2 = 0; i2 < max; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.yx) {
                    layoutParams.yv = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    public final void populate() {
        aa(this.xB);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aa(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.xB;
        r0 = r18;
        if (r3 == r0) goto L_0x030c;
    L_0x0009:
        r0 = r17;
        r2 = r0.xB;
        r0 = r17;
        r2 = r0.ab(r2);
        r0 = r18;
        r1 = r17;
        r1.xB = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.xA;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.bU();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.xR;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.bU();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.xS;
        r4 = 0;
        r0 = r17;
        r5 = r0.xB;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.xA;
        r11 = r4.getCount();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.xB;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.xw;
        if (r11 == r2) goto L_0x00c3;
    L_0x005b:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00b9 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00b9 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00b9 }
    L_0x0067:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r17;
        r5 = r0.xw;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.xA;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00b9:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0067;
    L_0x00c3:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00c6:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0309;
    L_0x00d0:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        r6 = r2.position;
        r0 = r17;
        r7 = r0.xB;
        if (r6 < r7) goto L_0x0156;
    L_0x00e2:
        r6 = r2.position;
        r0 = r17;
        r7 = r0.xB;
        if (r6 != r7) goto L_0x0309;
    L_0x00ea:
        if (r2 != 0) goto L_0x0306;
    L_0x00ec:
        if (r11 <= 0) goto L_0x0306;
    L_0x00ee:
        r0 = r17;
        r2 = r0.xB;
        r0 = r17;
        r2 = r0.k(r2, r4);
        r9 = r2;
    L_0x00f9:
        if (r9 == 0) goto L_0x0270;
    L_0x00fb:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x015b;
    L_0x0100:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x010a:
        r13 = r17.bS();
        if (r13 > 0) goto L_0x015d;
    L_0x0110:
        r5 = 0;
    L_0x0111:
        r0 = r17;
        r6 = r0.xB;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x011f:
        if (r8 < 0) goto L_0x01a3;
    L_0x0121:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x016d;
    L_0x0125:
        if (r8 >= r10) goto L_0x016d;
    L_0x0127:
        if (r2 == 0) goto L_0x01a3;
    L_0x0129:
        r14 = r2.position;
        if (r8 != r14) goto L_0x0153;
    L_0x012d:
        r14 = r2.yu;
        if (r14 != 0) goto L_0x0153;
    L_0x0131:
        r0 = r17;
        r14 = r0.eg;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.xA;
        r2 = r2.yt;
        r0 = r17;
        r14.a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x016b;
    L_0x0149:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0153:
        r8 = r8 + -1;
        goto L_0x011f;
    L_0x0156:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00c6;
    L_0x015b:
        r2 = 0;
        goto L_0x010a;
    L_0x015d:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.yv;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0111;
    L_0x016b:
        r2 = 0;
        goto L_0x0153;
    L_0x016d:
        if (r2 == 0) goto L_0x0187;
    L_0x016f:
        r14 = r2.position;
        if (r8 != r14) goto L_0x0187;
    L_0x0173:
        r2 = r2.yv;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x0185;
    L_0x017a:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        goto L_0x0153;
    L_0x0185:
        r2 = 0;
        goto L_0x0153;
    L_0x0187:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.k(r8, r2);
        r2 = r2.yv;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x01a1;
    L_0x0196:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        goto L_0x0153;
    L_0x01a1:
        r2 = 0;
        goto L_0x0153;
    L_0x01a3:
        r5 = r9.yv;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x026b;
    L_0x01ad:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0211;
    L_0x01b7:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        r6 = r2;
    L_0x01c2:
        if (r13 > 0) goto L_0x0213;
    L_0x01c4:
        r2 = 0;
        r4 = r2;
    L_0x01c6:
        r0 = r17;
        r2 = r0.xB;
        r2 = r2 + 1;
        r15 = r6;
        r6 = r8;
        r8 = r2;
        r2 = r15;
    L_0x01d0:
        if (r8 >= r11) goto L_0x026b;
    L_0x01d2:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0221;
    L_0x01d6:
        if (r8 <= r12) goto L_0x0221;
    L_0x01d8:
        if (r2 == 0) goto L_0x026b;
    L_0x01da:
        r10 = r2.position;
        if (r8 != r10) goto L_0x0301;
    L_0x01de:
        r10 = r2.yu;
        if (r10 != 0) goto L_0x0301;
    L_0x01e2:
        r0 = r17;
        r10 = r0.eg;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.xA;
        r2 = r2.yt;
        r0 = r17;
        r10.a(r0, r8, r2);
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x021f;
    L_0x01fe:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0208:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x020b:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x01d0;
    L_0x0211:
        r6 = 0;
        goto L_0x01c2;
    L_0x0213:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x01c6;
    L_0x021f:
        r2 = 0;
        goto L_0x0208;
    L_0x0221:
        if (r2 == 0) goto L_0x0246;
    L_0x0223:
        r10 = r2.position;
        if (r8 != r10) goto L_0x0246;
    L_0x0227:
        r2 = r2.yv;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0244;
    L_0x0236:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0240:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x020b;
    L_0x0244:
        r2 = 0;
        goto L_0x0240;
    L_0x0246:
        r0 = r17;
        r2 = r0.k(r8, r6);
        r6 = r6 + 1;
        r2 = r2.yv;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0269;
    L_0x025b:
        r0 = r17;
        r2 = r0.eg;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0265:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x020b;
    L_0x0269:
        r2 = 0;
        goto L_0x0265;
    L_0x026b:
        r0 = r17;
        r0.a(r9, r7, r3);
    L_0x0270:
        r0 = r17;
        r3 = r0.xA;
        if (r9 == 0) goto L_0x02b7;
    L_0x0276:
        r2 = r9.yt;
    L_0x0278:
        r3.d(r2);
        r0 = r17;
        r2 = r0.xA;
        r2.bb();
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x0288:
        if (r3 >= r4) goto L_0x02b9;
    L_0x028a:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.yz = r3;
        r6 = r2.yx;
        if (r6 != 0) goto L_0x02b3;
    L_0x029c:
        r6 = r2.yv;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x02b3;
    L_0x02a3:
        r0 = r17;
        r5 = r0.ao(r5);
        if (r5 == 0) goto L_0x02b3;
    L_0x02ab:
        r6 = r5.yv;
        r2.yv = r6;
        r5 = r5.position;
        r2.position = r5;
    L_0x02b3:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0288;
    L_0x02b7:
        r2 = 0;
        goto L_0x0278;
    L_0x02b9:
        r17.bU();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02c2:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x02ff;
    L_0x02c8:
        r0 = r17;
        r2 = r0.ap(r2);
    L_0x02ce:
        if (r2 == 0) goto L_0x02d8;
    L_0x02d0:
        r2 = r2.position;
        r0 = r17;
        r3 = r0.xB;
        if (r2 == r3) goto L_0x0023;
    L_0x02d8:
        r2 = 0;
    L_0x02d9:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02df:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.ao(r3);
        if (r4 == 0) goto L_0x02fc;
    L_0x02ed:
        r4 = r4.position;
        r0 = r17;
        r5 = r0.xB;
        if (r4 != r5) goto L_0x02fc;
    L_0x02f5:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x02fc:
        r2 = r2 + 1;
        goto L_0x02d9;
    L_0x02ff:
        r2 = 0;
        goto L_0x02ce;
    L_0x0301:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x020b;
    L_0x0306:
        r9 = r2;
        goto L_0x00f9;
    L_0x0309:
        r2 = r5;
        goto L_0x00ea;
    L_0x030c:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.aa(int):void");
    }

    private void bU() {
        if (this.yo != 0) {
            if (this.yp == null) {
                this.yp = new ArrayList();
            } else {
                this.yp.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.yp.add(getChildAt(i));
            }
            Collections.sort(this.yp, yq);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        float f;
        int i2;
        b bVar3;
        float f2;
        int i3;
        int count = this.xA.getCount();
        int bS = bS();
        if (bS > 0) {
            f = ((float) this.xI) / ((float) bS);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            bS = bVar2.position;
            float f3;
            int i4;
            int i5;
            if (bS < bVar.position) {
                f3 = (bVar2.yw + bVar2.yv) + f;
                i2 = 0;
                i4 = bS + 1;
                while (i4 <= bVar.position && i2 < this.eg.size()) {
                    bVar3 = (b) this.eg.get(i2);
                    while (i4 > bVar3.position && i2 < this.eg.size() - 1) {
                        i2++;
                        bVar3 = (b) this.eg.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 < bVar3.position) {
                        i3++;
                        f2 = (1.0f + f) + f2;
                    }
                    bVar3.yw = f2;
                    f2 += bVar3.yv + f;
                    bS = i3 + 1;
                    f3 = f2;
                    i4 = bS;
                }
            } else if (bS > bVar.position) {
                i2 = this.eg.size() - 1;
                f3 = bVar2.yw;
                i4 = bS - 1;
                while (i4 >= bVar.position && i2 >= 0) {
                    bVar3 = (b) this.eg.get(i2);
                    while (i4 < bVar3.position && i2 > 0) {
                        i2--;
                        bVar3 = (b) this.eg.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 > bVar3.position) {
                        i3--;
                        f2 -= 1.0f + f;
                    }
                    f2 -= bVar3.yv + f;
                    bVar3.yw = f2;
                    bS = i3 - 1;
                    f3 = f2;
                    i4 = bS;
                }
            }
        }
        int size = this.eg.size();
        f2 = bVar.yw;
        i3 = bVar.position - 1;
        this.xM = bVar.position == 0 ? bVar.yw : -3.4028235E38f;
        this.xN = bVar.position == count + -1 ? (bVar.yw + bVar.yv) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            bVar3 = (b) this.eg.get(i2);
            while (i3 > bVar3.position) {
                i3--;
                f2 -= 1.0f + f;
            }
            f2 -= bVar3.yv + f;
            bVar3.yw = f2;
            if (bVar3.position == 0) {
                this.xM = f2;
            }
            i3--;
        }
        f2 = (bVar.yw + bVar.yv) + f;
        i3 = bVar.position + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            bVar3 = (b) this.eg.get(i2);
            while (i3 < bVar3.position) {
                i3++;
                f2 += 1.0f + f;
            }
            if (bVar3.position == count - 1) {
                this.xN = (bVar3.yv + f2) - 1.0f;
            }
            bVar3.yw = f2;
            f2 += bVar3.yv + f;
            i3++;
        }
        this.yg = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.xB;
        if (this.xA != null) {
            savedState.yA = this.xA.bc();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.xA != null) {
                this.xA.a(savedState.yA, savedState.yB);
                a(savedState.position, false, true);
                return;
            }
            this.xC = savedState.position;
            this.xD = savedState.yA;
            this.xE = savedState.yB;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.yx |= view instanceof a;
        if (!this.oQ) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.yx) {
            layoutParams3.yy = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.oQ) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private b ao(View view) {
        for (int i = 0; i < this.eg.size(); i++) {
            b bVar = (b) this.eg.get(i);
            if (this.xA.a(view, bVar.yt)) {
                return bVar;
            }
        }
        return null;
    }

    private b ap(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return ao(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private b ab(int i) {
        for (int i2 = 0; i2 < this.eg.size(); i2++) {
            b bVar = (b) this.eg.get(i2);
            if (bVar.position == i) {
                return bVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yf = true;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.xV = Math.min(measuredWidth / 10, this.xU);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.yx) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i5 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.xO = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.xP = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.oQ = true;
        populate();
        this.oQ = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.yx) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.yv * ((float) paddingLeft)), 1073741824), this.xP);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.xI;
            int i6 = this.xI;
            if (i3 <= 0 || this.eg.isEmpty()) {
                b ab = ab(this.xB);
                i5 = (int) ((ab != null ? Math.min(ab.yw, this.xN) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
                if (i5 != getScrollX()) {
                    r(false);
                    scrollTo(i5, getScrollY());
                }
            } else if (this.xF.isFinished()) {
                scrollTo((int) (((float) (i5 + ((i - getPaddingLeft()) - getPaddingRight()))) * (((float) getScrollX()) / ((float) (i6 + ((i3 - getPaddingLeft()) - getPaddingRight()))))), getScrollY());
            } else {
                this.xF.setFinalX(this.xB * bS());
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            LayoutParams layoutParams;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.yx) {
                    int i9 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.yx) {
                    b ao = ao(childAt2);
                    if (ao != null) {
                        i5 = ((int) (ao.yw * ((float) max))) + paddingLeft;
                        if (layoutParams.yy) {
                            layoutParams.yy = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.yv * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.xK = paddingTop;
        this.xL = i6 - paddingBottom;
        this.yi = i7;
        if (this.yf) {
            a(this.xB, false, 0, false);
        }
        this.yf = false;
    }

    public void computeScroll() {
        this.xG = true;
        if (this.xF.isFinished() || !this.xF.computeScrollOffset()) {
            r(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.xF.getCurrX();
        int currY = this.xF.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!ac(currX)) {
                this.xF.abortAnimation();
                scrollTo(0, currY);
            }
        }
        y.E(this);
    }

    private boolean ac(int i) {
        if (this.eg.size() == 0) {
            this.yh = false;
            a(0, 0.0f, 0);
            if (this.yh) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b bX = bX();
        int bS = bS();
        int i2 = this.xI + bS;
        float f = ((float) this.xI) / ((float) bS);
        int i3 = bX.position;
        float f2 = ((((float) i) / ((float) bS)) - bX.yw) / (bX.yv + f);
        bS = (int) (((float) i2) * f2);
        this.yh = false;
        a(i3, f2, bS);
        if (this.yh) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        if (this.yi > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.yx) {
                    int max;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.yk != null) {
            this.yk.a(i, f, i2);
        }
        if (this.yj != null) {
            paddingRight = this.yj.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                e eVar = (e) this.yj.get(paddingLeft);
                if (eVar != null) {
                    eVar.a(i, f, i2);
                }
            }
        }
        if (this.yl != null) {
            this.yl.a(i, f, i2);
        }
        if (this.yn != null) {
            getScrollX();
            paddingRight = getChildCount();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).yx) {
                    childAt2.getLeft();
                    bS();
                }
            }
        }
        this.yh = true;
    }

    private void ad(int i) {
        if (this.yk != null) {
            this.yk.W(i);
        }
        if (this.yj != null) {
            int size = this.yj.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) this.yj.get(i2);
                if (eVar != null) {
                    eVar.W(i);
                }
            }
        }
        if (this.yl != null) {
            this.yl.W(i);
        }
    }

    private void r(boolean z) {
        int scrollX;
        boolean z2 = this.xe == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.xF.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.xF.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.xF.getCurrX();
                int currY = this.xF.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        ac(currX);
                    }
                }
            }
        }
        this.xR = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.eg.size(); scrollX++) {
            b bVar = (b) this.eg.get(scrollX);
            if (bVar.yu) {
                bVar.yu = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            y.a((View) this, this.yr);
        } else {
            this.yr.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
        if (action == 3 || action == 1) {
            bV();
            return false;
        }
        if (action != 0) {
            if (this.iB) {
                return true;
            }
            if (this.xT) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.wL = x;
                this.xW = x;
                x = motionEvent.getY();
                this.wM = x;
                this.xX = x;
                this.fk = n.c(motionEvent, 0);
                this.xT = false;
                this.xG = true;
                this.xF.computeScrollOffset();
                if (this.xe == 2 && Math.abs(this.xF.getFinalX() - this.xF.getCurrX()) > this.yb) {
                    this.xF.abortAnimation();
                    this.xR = false;
                    populate();
                    this.iB = true;
                    bW();
                    Y(1);
                    break;
                }
                r(false);
                this.iB = false;
                break;
                break;
            case 2:
                action = this.fk;
                if (action != -1) {
                    action = n.b(motionEvent, action);
                    float d = n.d(motionEvent, action);
                    float f = d - this.xW;
                    float abs = Math.abs(f);
                    float e = n.e(motionEvent, action);
                    float abs2 = Math.abs(e - this.wM);
                    if (f != 0.0f) {
                        x = this.xW;
                        boolean z = (x < ((float) this.xV) && f > 0.0f) || (x > ((float) (getWidth() - this.xV)) && f < 0.0f);
                        if (!z && a(this, false, (int) f, (int) d, (int) e)) {
                            this.xW = d;
                            this.xX = e;
                            this.xT = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.iD) && 0.5f * abs > abs2) {
                        this.iB = true;
                        bW();
                        Y(1);
                        this.xW = f > 0.0f ? this.wL + ((float) this.iD) : this.wL - ((float) this.iD);
                        this.xX = e;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.iD)) {
                        this.xT = true;
                    }
                    if (this.iB && o(d)) {
                        y.E(this);
                        break;
                    }
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        return this.iB;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.yc) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.xA == null || this.xA.getCount() == 0) {
            return false;
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        float x;
        int i;
        float f;
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                this.xF.abortAnimation();
                this.xR = false;
                populate();
                x = motionEvent.getX();
                this.wL = x;
                this.xW = x;
                x = motionEvent.getY();
                this.wM = x;
                this.xX = x;
                this.fk = n.c(motionEvent, 0);
                break;
            case 1:
                if (this.iB) {
                    VelocityTracker velocityTracker = this.fj;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.xZ);
                    int a = (int) x.a(velocityTracker, this.fk);
                    this.xR = true;
                    int bS = bS();
                    int scrollX = getScrollX();
                    b bX = bX();
                    float f2 = ((float) this.xI) / ((float) bS);
                    i = bX.position;
                    f = ((((float) scrollX) / ((float) bS)) - bX.yw) / (bX.yv + f2);
                    if (Math.abs((int) (n.d(motionEvent, n.b(motionEvent, this.fk)) - this.wL)) <= this.ya || Math.abs(a) <= this.xY) {
                        scrollX = (int) ((((float) i) + f) + (i >= this.xB ? 0.4f : 0.6f));
                    } else {
                        if (a <= 0) {
                            i++;
                        }
                        scrollX = i;
                    }
                    if (this.eg.size() > 0) {
                        scrollX = Math.max(((b) this.eg.get(0)).position, Math.min(scrollX, ((b) this.eg.get(this.eg.size() - 1)).position));
                    }
                    a(scrollX, true, true, a);
                    z = bV();
                    break;
                }
                break;
            case 2:
                if (!this.iB) {
                    i = n.b(motionEvent, this.fk);
                    if (i == -1) {
                        z = bV();
                        break;
                    }
                    float d = n.d(motionEvent, i);
                    f = Math.abs(d - this.xW);
                    float e = n.e(motionEvent, i);
                    x = Math.abs(e - this.xX);
                    if (f > ((float) this.iD) && f > x) {
                        this.iB = true;
                        bW();
                        if (d - this.wL > 0.0f) {
                            x = this.wL + ((float) this.iD);
                        } else {
                            x = this.wL - ((float) this.iD);
                        }
                        this.xW = x;
                        this.xX = e;
                        Y(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.iB) {
                    z = o(n.d(motionEvent, n.b(motionEvent, this.fk))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.iB) {
                    a(this.xB, true, 0, false);
                    z = bV();
                    break;
                }
                break;
            case 5:
                i = n.e(motionEvent);
                this.xW = n.d(motionEvent, i);
                this.fk = n.c(motionEvent, i);
                break;
            case 6:
                h(motionEvent);
                this.xW = n.d(motionEvent, n.b(motionEvent, this.fk));
                break;
        }
        if (z) {
            y.E(this);
        }
        return true;
    }

    private boolean bV() {
        this.fk = -1;
        this.iB = false;
        this.xT = false;
        if (this.fj != null) {
            this.fj.recycle();
            this.fj = null;
        }
        return this.yd.cv() | this.ye.cv();
    }

    private void bW() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean o(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.xW - f;
        this.xW = f;
        float scrollX = ((float) getScrollX()) + f3;
        int bS = bS();
        float f4 = ((float) bS) * this.xM;
        float f5 = ((float) bS) * this.xN;
        b bVar = (b) this.eg.get(0);
        b bVar2 = (b) this.eg.get(this.eg.size() - 1);
        if (bVar.position != 0) {
            f4 = bVar.yw * ((float) bS);
            z = false;
        } else {
            z = true;
        }
        if (bVar2.position != this.xA.getCount() - 1) {
            f2 = bVar2.yw * ((float) bS);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.yd.t(Math.abs(f4 - scrollX) / ((float) bS));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.ye.t(Math.abs(scrollX - f2) / ((float) bS));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.xW += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        ac((int) f4);
        return z3;
    }

    private b bX() {
        float f;
        int bS = bS();
        float scrollX = bS > 0 ? ((float) getScrollX()) / ((float) bS) : 0.0f;
        if (bS > 0) {
            f = ((float) this.xI) / ((float) bS);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        b bVar = null;
        while (i2 < this.eg.size()) {
            int i3;
            b bVar2;
            b bVar3 = (b) this.eg.get(i2);
            b bVar4;
            if (obj != null || bVar3.position == i + 1) {
                bVar4 = bVar3;
                i3 = i2;
                bVar2 = bVar4;
            } else {
                bVar3 = this.xz;
                bVar3.yw = (f2 + f3) + f;
                bVar3.position = i + 1;
                bVar3.yv = 1.0f;
                bVar4 = bVar3;
                i3 = i2 - 1;
                bVar2 = bVar4;
            }
            f2 = bVar2.yw;
            f3 = (bVar2.yv + f2) + f;
            if (obj == null && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f3 || i3 == this.eg.size() - 1) {
                return bVar2;
            }
            f3 = f2;
            i = bVar2.position;
            obj = null;
            f2 = bVar2.yv;
            bVar = bVar2;
            i2 = i3 + 1;
        }
        return bVar;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int B = y.B(this);
        if (B == 0 || (B == 1 && this.xA != null && this.xA.getCount() > 1)) {
            int width;
            if (!this.yd.isFinished()) {
                B = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.xM * ((float) width));
                this.yd.setSize(i, width);
                i = this.yd.draw(canvas) | 0;
                canvas.restoreToCount(B);
            }
            if (!this.ye.isFinished()) {
                B = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.xN + 1.0f)) * ((float) width));
                this.ye.setSize(height, width);
                i |= this.ye.draw(canvas);
                canvas.restoreToCount(B);
            }
        } else {
            this.yd.finish();
            this.ye.finish();
        }
        if (i != 0) {
            y.E(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.xI > 0 && this.xJ != null && this.eg.size() > 0 && this.xA != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.xI) / ((float) width);
            b bVar = (b) this.eg.get(0);
            float f2 = bVar.yw;
            int size = this.eg.size();
            int i = bVar.position;
            int i2 = ((b) this.eg.get(size - 1)).position;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bVar.position && i3 < size) {
                    i3++;
                    bVar = (b) this.eg.get(i3);
                }
                if (i4 == bVar.position) {
                    f3 = (bVar.yw + bVar.yv) * ((float) width);
                    f2 = (bVar.yw + bVar.yv) + f;
                } else {
                    f3 = (1.0f + f2) * ((float) width);
                    f2 += 1.0f + f;
                }
                if (((float) this.xI) + f3 > ((float) scrollX)) {
                    this.xJ.setBounds(Math.round(f3), this.xK, Math.round(((float) this.xI) + f3), this.xL);
                    this.xJ.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void h(MotionEvent motionEvent) {
        int e = n.e(motionEvent);
        if (n.c(motionEvent, e) == this.fk) {
            e = e == 0 ? 1 : 0;
            this.xW = n.d(motionEvent, e);
            this.fk = n.c(motionEvent, e);
            if (this.fj != null) {
                this.fj.clear();
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.xQ != z) {
            this.xQ = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.xA == null) {
            return false;
        }
        int bS = bS();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) bS) * this.xM))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) bS) * this.xN))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && y.f(view, -i)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 1;
        r2 = super.dispatchKeyEvent(r5);
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = r5.getAction();
        if (r2 != 0) goto L_0x0015;
    L_0x000e:
        r2 = r5.getKeyCode();
        switch(r2) {
            case 21: goto L_0x001a;
            case 22: goto L_0x0021;
            case 61: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r2 = 17;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x0028:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r2 < r3) goto L_0x0015;
    L_0x002e:
        r2 = android.support.v4.view.f.a(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.view.f.a(r5, r1);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.arrowScroll(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arrowScroll(int r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 66;
        r7 = 17;
        r4 = 1;
        r3 = 0;
        r2 = r9.findFocus();
        if (r2 != r9) goto L_0x003e;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r1 = android.view.FocusFinder.getInstance();
        r1 = r1.findNextFocus(r9, r0, r10);
        if (r1 == 0) goto L_0x00b3;
    L_0x0018:
        if (r1 == r0) goto L_0x00b3;
    L_0x001a:
        if (r10 != r7) goto L_0x0098;
    L_0x001c:
        r2 = r9.ep;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.ep;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x0093;
    L_0x002e:
        if (r2 < r3) goto L_0x0093;
    L_0x0030:
        r0 = r9.bY();
    L_0x0034:
        if (r0 == 0) goto L_0x003d;
    L_0x0036:
        r1 = android.view.SoundEffectConstants.getContantForFocusDirection(r10);
        r9.playSoundEffect(r1);
    L_0x003d:
        return r0;
    L_0x003e:
        if (r2 == 0) goto L_0x00cb;
    L_0x0040:
        r0 = r2.getParent();
    L_0x0044:
        r5 = r0 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x00ce;
    L_0x0048:
        if (r0 != r9) goto L_0x007c;
    L_0x004a:
        r0 = r4;
    L_0x004b:
        if (r0 != 0) goto L_0x00cb;
    L_0x004d:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        r5.append(r0);
        r0 = r2.getParent();
    L_0x0061:
        r2 = r0 instanceof android.view.ViewGroup;
        if (r2 == 0) goto L_0x0081;
    L_0x0065:
        r2 = " => ";
        r2 = r5.append(r2);
        r6 = r0.getClass();
        r6 = r6.getSimpleName();
        r2.append(r6);
        r0 = r0.getParent();
        goto L_0x0061;
    L_0x007c:
        r0 = r0.getParent();
        goto L_0x0044;
    L_0x0081:
        r0 = new java.lang.StringBuilder;
        r2 = "arrowScroll tried to find focus based on non-child current focused view ";
        r0.<init>(r2);
        r2 = r5.toString();
        r0.append(r2);
        r0 = r1;
        goto L_0x000e;
    L_0x0093:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x0098:
        if (r10 != r8) goto L_0x00c8;
    L_0x009a:
        r2 = r9.ep;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.ep;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x00ae;
    L_0x00ac:
        if (r2 <= r3) goto L_0x00c2;
    L_0x00ae:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x00b3:
        if (r10 == r7) goto L_0x00b7;
    L_0x00b5:
        if (r10 != r4) goto L_0x00bd;
    L_0x00b7:
        r0 = r9.bY();
        goto L_0x0034;
    L_0x00bd:
        if (r10 == r8) goto L_0x00c2;
    L_0x00bf:
        r0 = 2;
        if (r10 != r0) goto L_0x00c8;
    L_0x00c2:
        r0 = r9.bZ();
        goto L_0x0034;
    L_0x00c8:
        r0 = r3;
        goto L_0x0034;
    L_0x00cb:
        r0 = r2;
        goto L_0x000e;
    L_0x00ce:
        r0 = r3;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.arrowScroll(int):boolean");
    }

    private Rect a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private boolean bY() {
        if (this.xB <= 0) {
            return false;
        }
        k(this.xB - 1, true);
        return true;
    }

    private boolean bZ() {
        if (this.xA == null || this.xB >= this.xA.getCount() - 1) {
            return false;
        }
        k(this.xB + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b ao = ao(childAt);
                    if (ao != null && ao.position == this.xB) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.xB) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.xB && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.xB && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
