package com.tencent.mm.ui.mogic;

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
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.ad;
import android.support.v4.view.n;
import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import junit.framework.Assert;

public class WxViewPager extends ViewGroup {
    private static final e oPO = new e();
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
    private final ArrayList<b> eg = new ArrayList();
    private final Rect ep = new Rect();
    public VelocityTracker fj;
    private int fk = -1;
    public boolean iB;
    private int iD;
    private final b oPL = new b();
    private d oPM;
    public long oPN;
    private boolean oQ;
    public float wL;
    private float wM;
    public t xA;
    public int xB;
    private int xC = -1;
    private Parcelable xD = null;
    private ClassLoader xE = null;
    public Scroller xF;
    public int xI;
    private Drawable xJ;
    private int xK;
    private int xL;
    private float xM = -3.4028235E38f;
    private float xN = Float.MAX_VALUE;
    private int xO;
    private int xP;
    private boolean xQ;
    private boolean xR;
    private int xS = 1;
    private boolean xT;
    private int xU;
    private int xV;
    public float xW;
    public float xX;
    private int xY;
    private int xZ;
    private int xe = 0;
    private int xw;
    private int ya;
    private int yb;
    public boolean yc;
    private i yd;
    private i ye;
    private boolean yf = true;
    private boolean yg = false;
    private boolean yh;
    private int yi;
    private android.support.v4.view.ViewPager.e yk;
    private android.support.v4.view.ViewPager.e yl;
    private f yn;
    private int yo;
    private ArrayList<View> yp;
    private final Runnable yr = new Runnable(this) {
        final /* synthetic */ WxViewPager oPP;

        {
            this.oPP = r1;
        }

        public final void run() {
            this.oPP.Y(0);
            this.oPP.populate();
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, WxViewPager.xv);
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

    private class d extends DataSetObserver {
        final /* synthetic */ WxViewPager oPP;

        private d(WxViewPager wxViewPager) {
            this.oPP = wxViewPager;
        }

        public final void onChanged() {
            this.oPP.bT();
        }

        public final void onInvalidated() {
            this.oPP.bT();
        }
    }

    static class e implements Comparator<View> {
        e() {
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

    class c extends android.support.v4.view.a {
        final /* synthetic */ WxViewPager oPP;

        c(WxViewPager wxViewPager) {
            this.oPP = wxViewPager;
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(WxViewPager.class.getName());
            android.support.v4.view.a.f cl = android.support.v4.view.a.f.cl();
            cl.setScrollable(cb());
            if (accessibilityEvent.getEventType() == 4096 && this.oPP.xA != null) {
                cl.setItemCount(this.oPP.xA.getCount());
                cl.setFromIndex(this.oPP.xB);
                cl.setToIndex(this.oPP.xB);
            }
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            bVar.setClassName(WxViewPager.class.getName());
            bVar.setScrollable(cb());
            if (this.oPP.canScrollHorizontally(1)) {
                bVar.addAction(4096);
            }
            if (this.oPP.canScrollHorizontally(-1)) {
                bVar.addAction(8192);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.oPP.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.oPP.Z(this.oPP.xB + 1);
                    return true;
                case 8192:
                    if (!this.oPP.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.oPP.Z(this.oPP.xB - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean cb() {
            return this.oPP.xA != null && this.oPP.xA.getCount() > 1;
        }
    }

    public WxViewPager(Context context, AttributeSet attributeSet) {
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
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.yr);
        super.onDetachedFromWindow();
    }

    public final void Y(int i) {
        if (this.xe != i) {
            this.xe = i;
            if (this.yn != null) {
                Object obj = i != 0 ? 1 : null;
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    y.a(getChildAt(i2), obj != null ? 2 : 0, null);
                }
            }
            if (this.yk != null) {
                this.yk.X(i);
            }
        }
    }

    public void a(t tVar) {
        if (this.xA != null) {
            int i;
            this.xA.unregisterDataSetObserver(this.oPM);
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
        this.xA = tVar;
        this.xw = 0;
        if (this.xA != null) {
            if (this.oPM == null) {
                this.oPM = new d();
            }
            this.xA.registerDataSetObserver(this.oPM);
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
                if (z3 && this.yk != null) {
                    this.yk.W(i);
                }
                if (z3 && this.yl != null) {
                    this.yl.W(i);
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
        b yc = yc(i);
        int i3 = 0;
        if (yc != null) {
            i3 = (int) (((float) bS()) * Math.max(this.xM, Math.min(yc.yw, this.xN)));
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int i4 = i3 - scrollX;
                int i5 = 0 - scrollY;
                if (i4 == 0 && i5 == 0) {
                    r(false);
                    populate();
                    Y(0);
                } else {
                    setScrollingCacheEnabled(true);
                    Y(2);
                    i3 = bS();
                    int i6 = i3 / 2;
                    float f = (float) i6;
                    float sin = (((float) i6) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(i4))) / ((float) i3)) - 0.5f)) * 0.4712389167638204d))))) + f;
                    int abs = Math.abs(i2);
                    if (abs > 0) {
                        i3 = Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4;
                    } else {
                        i3 = (int) (((((float) Math.abs(i4)) / ((((float) i3) * 1.0f) + ((float) this.xI))) + 3.0f) * 100.0f);
                    }
                    this.xF.startScroll(scrollX, scrollY, i4, i5, Math.min(i3, 600));
                    y.E(this);
                }
            }
            if (z2 && this.yk != null) {
                this.yk.W(i);
            }
            if (z2 && this.yl != null) {
                this.yl.W(i);
                return;
            }
            return;
        }
        if (z2 && this.yk != null) {
            this.yk.W(i);
        }
        if (z2 && this.yl != null) {
            this.yl.W(i);
        }
        r(false);
        scrollTo(i3, 0);
        ac(i3);
    }

    public void b(android.support.v4.view.ViewPager.e eVar) {
        this.yk = eVar;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.yo == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.yp.get(i2)).getLayoutParams()).yz;
    }

    public final void yb(int i) {
        if (i <= 0) {
            new StringBuilder("Requested offscreen page limit ").append(i).append(" too small; defaulting to 1");
            i = 1;
        }
        if (i != this.xS) {
            this.xS = i;
            populate();
        }
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

    private b dr(int i, int i2) {
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
            int max;
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

    final void populate() {
        aa(this.xB);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aa(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.xB;
        r0 = r19;
        if (r4 == r0) goto L_0x0328;
    L_0x000a:
        r0 = r18;
        r2 = r0.xB;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.xB;
        r0 = r18;
        r3 = r0.yc(r3);
        r0 = r19;
        r1 = r18;
        r1.xB = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.xA;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.bU();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.xR;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.bU();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.xS;
        r5 = 0;
        r0 = r18;
        r6 = r0.xB;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.xA;
        r12 = r5.getCount();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.xB;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.xw;
        if (r12 == r2) goto L_0x00d2;
    L_0x006a:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00c8 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00c8 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c8 }
    L_0x0076:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r18;
        r5 = r0.xw;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.xA;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c8:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0076;
    L_0x00d2:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00d5:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x0325;
    L_0x00df:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
        r7 = r2.position;
        r0 = r18;
        r8 = r0.xB;
        if (r7 < r8) goto L_0x0167;
    L_0x00f1:
        r7 = r2.position;
        r0 = r18;
        r8 = r0.xB;
        if (r7 != r8) goto L_0x0325;
    L_0x00f9:
        if (r2 != 0) goto L_0x0322;
    L_0x00fb:
        if (r12 <= 0) goto L_0x0322;
    L_0x00fd:
        r0 = r18;
        r2 = r0.xB;
        r0 = r18;
        r2 = r0.dr(r2, r5);
        r10 = r2;
    L_0x0108:
        if (r10 == 0) goto L_0x028b;
    L_0x010a:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x016c;
    L_0x010f:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r8);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
    L_0x0119:
        r14 = r18.bS();
        if (r14 > 0) goto L_0x016e;
    L_0x011f:
        r6 = 0;
    L_0x0120:
        r0 = r18;
        r7 = r0.xB;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0130:
        if (r9 < 0) goto L_0x01b4;
    L_0x0132:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x017e;
    L_0x0136:
        if (r9 >= r11) goto L_0x017e;
    L_0x0138:
        if (r2 == 0) goto L_0x01b4;
    L_0x013a:
        r15 = r2.position;
        if (r9 != r15) goto L_0x0164;
    L_0x013e:
        r15 = r2.yu;
        if (r15 != 0) goto L_0x0164;
    L_0x0142:
        r0 = r18;
        r15 = r0.eg;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.xA;
        r2 = r2.yt;
        r0 = r18;
        r15.a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x017c;
    L_0x015a:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
    L_0x0164:
        r9 = r9 + -1;
        goto L_0x0130;
    L_0x0167:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00d5;
    L_0x016c:
        r2 = 0;
        goto L_0x0119;
    L_0x016e:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.yv;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0120;
    L_0x017c:
        r2 = 0;
        goto L_0x0164;
    L_0x017e:
        if (r2 == 0) goto L_0x0198;
    L_0x0180:
        r15 = r2.position;
        if (r9 != r15) goto L_0x0198;
    L_0x0184:
        r2 = r2.yv;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x0196;
    L_0x018b:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
        goto L_0x0164;
    L_0x0196:
        r2 = 0;
        goto L_0x0164;
    L_0x0198:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.dr(r9, r2);
        r2 = r2.yv;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x01b2;
    L_0x01a7:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
        goto L_0x0164;
    L_0x01b2:
        r2 = 0;
        goto L_0x0164;
    L_0x01b4:
        r6 = r10.yv;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0286;
    L_0x01be:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x0228;
    L_0x01c8:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r9);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
        r7 = r2;
    L_0x01d3:
        if (r14 > 0) goto L_0x022a;
    L_0x01d5:
        r2 = 0;
        r5 = r2;
    L_0x01d7:
        r0 = r18;
        r2 = r0.xB;
        r2 = r2 + 1;
        r16 = r7;
        r7 = r9;
        r9 = r2;
        r2 = r16;
    L_0x01e3:
        if (r9 >= r12) goto L_0x0286;
    L_0x01e5:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x0238;
    L_0x01e9:
        if (r9 <= r13) goto L_0x0238;
    L_0x01eb:
        if (r2 == 0) goto L_0x0286;
    L_0x01ed:
        r11 = r2.position;
        if (r9 != r11) goto L_0x031b;
    L_0x01f1:
        r11 = r2.yu;
        if (r11 != 0) goto L_0x031b;
    L_0x01f5:
        r0 = r18;
        r11 = r0.eg;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.xA;
        r2 = r2.yt;
        r0 = r18;
        r11.a(r0, r9, r2);
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0236;
    L_0x0211:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
    L_0x021b:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x0220:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x01e3;
    L_0x0228:
        r7 = 0;
        goto L_0x01d3;
    L_0x022a:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x01d7;
    L_0x0236:
        r2 = 0;
        goto L_0x021b;
    L_0x0238:
        if (r2 == 0) goto L_0x025f;
    L_0x023a:
        r11 = r2.position;
        if (r9 != r11) goto L_0x025f;
    L_0x023e:
        r2 = r2.yv;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x025d;
    L_0x024d:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
    L_0x0257:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x025d:
        r2 = 0;
        goto L_0x0257;
    L_0x025f:
        r0 = r18;
        r2 = r0.dr(r9, r7);
        r7 = r7 + 1;
        r2 = r2.yv;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0284;
    L_0x0274:
        r0 = r18;
        r2 = r0.eg;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.b) r2;
    L_0x027e:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x0284:
        r2 = 0;
        goto L_0x027e;
    L_0x0286:
        r0 = r18;
        r0.a(r10, r8, r4);
    L_0x028b:
        r0 = r18;
        r4 = r0.xA;
        if (r10 == 0) goto L_0x02d2;
    L_0x0291:
        r2 = r10.yt;
    L_0x0293:
        r4.d(r2);
        r0 = r18;
        r2 = r0.xA;
        r2.bb();
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x02a3:
        if (r4 >= r5) goto L_0x02d4;
    L_0x02a5:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (com.tencent.mm.ui.mogic.WxViewPager.LayoutParams) r2;
        r2.yz = r4;
        r7 = r2.yx;
        if (r7 != 0) goto L_0x02ce;
    L_0x02b7:
        r7 = r2.yv;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x02ce;
    L_0x02be:
        r0 = r18;
        r6 = r0.cZ(r6);
        if (r6 == 0) goto L_0x02ce;
    L_0x02c6:
        r7 = r6.yv;
        r2.yv = r7;
        r6 = r6.position;
        r2.position = r6;
    L_0x02ce:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x02a3;
    L_0x02d2:
        r2 = 0;
        goto L_0x0293;
    L_0x02d4:
        r18.bU();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02dd:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0319;
    L_0x02e3:
        r0 = r18;
        r2 = r0.da(r2);
    L_0x02e9:
        if (r2 == 0) goto L_0x02f3;
    L_0x02eb:
        r2 = r2.position;
        r0 = r18;
        r4 = r0.xB;
        if (r2 == r4) goto L_0x002f;
    L_0x02f3:
        r2 = 0;
    L_0x02f4:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x02fa:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.cZ(r4);
        if (r5 == 0) goto L_0x0316;
    L_0x0308:
        r5 = r5.position;
        r0 = r18;
        r6 = r0.xB;
        if (r5 != r6) goto L_0x0316;
    L_0x0310:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x0316:
        r2 = r2 + 1;
        goto L_0x02f4;
    L_0x0319:
        r2 = 0;
        goto L_0x02e9;
    L_0x031b:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x0322:
        r10 = r2;
        goto L_0x0108;
    L_0x0325:
        r2 = r6;
        goto L_0x00f9;
    L_0x0328:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.mogic.WxViewPager.aa(int):void");
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
            Collections.sort(this.yp, oPO);
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
        Assert.assertNotNull(layoutParams2);
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

    private b cZ(View view) {
        for (int i = 0; i < this.eg.size(); i++) {
            b bVar = (b) this.eg.get(i);
            if (this.xA.a(view, bVar.yt)) {
                return bVar;
            }
        }
        return null;
    }

    private b da(View view) {
        while (true) {
            WxViewPager parent = view.getParent();
            if (parent == this) {
                return cZ(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private b yc(int i) {
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
                if ((layoutParams == null || !layoutParams.yx) && layoutParams != null) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.yv * ((float) paddingLeft)), 1073741824), this.xP);
                }
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            q(i, i3, this.xI, this.xI);
        }
    }

    public final void q(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.eg.isEmpty()) {
            b yc = yc(this.xB);
            int min = (int) ((yc != null ? Math.min(yc.yw, this.xN) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                r(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.xF.isFinished()) {
            this.xF.startScroll(paddingLeft, 0, (int) (yc(this.xB).yw * ((float) i)), 0, this.xF.getDuration() - this.xF.timePassed());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
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
                    b cZ = cZ(childAt2);
                    if (cZ != null) {
                        i5 = ((int) (cZ.yw * ((float) max))) + paddingLeft;
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
        b bIO = bIO();
        int bS = bS();
        int i2 = this.xI + bS;
        float f = ((float) this.xI) / ((float) bS);
        int i3 = bIO.position;
        float f2 = ((((float) i) / ((float) bS)) - bIO.yw) / (bIO.yv + f);
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

    private void r(boolean z) {
        int scrollX;
        boolean z2 = this.xe == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.xF.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.xF.getCurrX();
            int currY = this.xF.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.xR = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.eg.size(); scrollX++) {
            b bVar = (b) this.eg.get(scrollX);
            if (bVar.yu) {
                bVar.yu = false;
                z3 = true;
            }
        }
        if (!z3) {
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
            this.iB = false;
            this.xT = false;
            this.fk = -1;
            if (this.fj == null) {
                return false;
            }
            this.fj.recycle();
            this.fj = null;
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
                this.xF.computeScrollOffset();
                if (this.xe == 2 && Math.abs(this.xF.getFinalX() - this.xF.getCurrX()) > this.yb) {
                    this.xF.abortAnimation();
                    this.xR = false;
                    populate();
                    this.iB = true;
                    Y(1);
                    break;
                }
                r(false);
                this.iB = false;
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
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.xA == null || this.xA.getCount() == 0) {
            return false;
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        float x;
        int bS;
        float f;
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                this.xF.abortAnimation();
                this.xR = false;
                populate();
                this.iB = true;
                Y(1);
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
                    bS = bS();
                    int scrollX = getScrollX();
                    b bIO = bIO();
                    int i = bIO.position;
                    f = ((((float) scrollX) / ((float) bS)) - bIO.yw) / bIO.yv;
                    bS = n.b(motionEvent, this.fk);
                    if (bS < 0) {
                        bS = 0;
                    }
                    if (Math.abs((int) (n.d(motionEvent, bS) - this.wL)) <= this.ya || Math.abs(a) <= this.xY) {
                        bS = (int) ((i >= this.xB ? 0.6f : 0.4f) + (((float) i) + f));
                    } else {
                        bS = a > 0 ? i : i + 1;
                    }
                    if (this.eg.size() > 0) {
                        bS = Math.max(bCI(), Math.min(bS, bCJ()));
                    }
                    a(bS, true, true, a);
                    this.fk = -1;
                    cD();
                    z = this.ye.cv() | this.yd.cv();
                    break;
                }
                break;
            case 2:
                if (!this.iB) {
                    bS = n.b(motionEvent, this.fk);
                    float d = n.d(motionEvent, bS);
                    float abs = Math.abs(d - this.xW);
                    f = n.e(motionEvent, bS);
                    x = Math.abs(f - this.xX);
                    if (abs > ((float) this.iD) && abs > x) {
                        this.iB = true;
                        if (d - this.wL > 0.0f) {
                            x = this.wL + ((float) this.iD);
                        } else {
                            x = this.wL - ((float) this.iD);
                        }
                        this.xW = x;
                        this.xX = f;
                        Y(1);
                        setScrollingCacheEnabled(true);
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
                    this.fk = -1;
                    cD();
                    z = this.ye.cv() | this.yd.cv();
                    break;
                }
                break;
            case 5:
                bS = n.e(motionEvent);
                this.xW = n.d(motionEvent, bS);
                this.fk = n.c(motionEvent, bS);
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

    private b bIO() {
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
                bVar3 = this.oPL;
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

    public int bCI() {
        return ((b) this.eg.get(0)).position;
    }

    public int bCJ() {
        return ((b) this.eg.get(this.eg.size() - 1)).position;
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
                    this.xJ.setBounds((int) f3, this.xK, (int) ((((float) this.xI) + f3) + 0.5f), this.xL);
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

    private void cD() {
        this.iB = false;
        this.xT = false;
        if (this.fj != null) {
            this.fj.recycle();
            this.fj = null;
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.mogic.WxViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.mogic.WxViewPager.arrowScroll(int):boolean");
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
        WxViewPager parent = view.getParent();
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
        Assert.assertNotNull(arrayList);
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b cZ = cZ(childAt);
                    if (cZ != null && cZ.position == this.xB) {
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
                b cZ = cZ(childAt);
                if (cZ != null && cZ.position == this.xB) {
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
            i2 = childCount;
            childCount = 0;
        } else {
            childCount--;
            i2 = -1;
        }
        while (childCount != i2) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                b cZ = cZ(childAt);
                if (cZ != null && cZ.position == this.xB && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            childCount += i3;
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
                b cZ = cZ(childAt);
                if (cZ != null && cZ.position == this.xB && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
