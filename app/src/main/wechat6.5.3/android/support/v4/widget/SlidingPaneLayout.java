package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mmdb.database.SQLiteDebug;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final d CV;
    private int CH;
    private int CI;
    private Drawable CJ;
    private Drawable CK;
    private final int CL;
    private boolean CM;
    private View CN;
    private float CO;
    private float CP;
    private int CQ;
    private int CR;
    private final u CS;
    private boolean CT;
    private final ArrayList<b> CU;
    private final Rect gF;
    private float wL;
    private float wM;
    private boolean xT;
    private boolean yf;

    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] wZ = new int[]{16843137};
        boolean CY;
        boolean CZ;
        Paint Da;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, wZ);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean Db;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Db = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Db ? 1 : 0);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ SlidingPaneLayout CW;
        final View CX;

        b(SlidingPaneLayout slidingPaneLayout, View view) {
            this.CW = slidingPaneLayout;
            this.CX = view;
        }

        public final void run() {
            if (this.CX.getParent() == this.CW) {
                y.a(this.CX, 0, null);
                this.CW.aE(this.CX);
            }
            this.CW.CU.remove(this);
        }
    }

    interface d {
        void b(SlidingPaneLayout slidingPaneLayout, View view);
    }

    class a extends android.support.v4.view.a {
        final /* synthetic */ SlidingPaneLayout CW;
        private final Rect gF = new Rect();

        a(SlidingPaneLayout slidingPaneLayout) {
            this.CW = slidingPaneLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
            super.a(view, a);
            Rect rect = this.gF;
            a.getBoundsInParent(rect);
            bVar.setBoundsInParent(rect);
            a.getBoundsInScreen(rect);
            bVar.setBoundsInScreen(rect);
            bVar.setVisibleToUser(a.isVisibleToUser());
            bVar.setPackageName(a.getPackageName());
            bVar.setClassName(a.getClassName());
            bVar.setContentDescription(a.getContentDescription());
            bVar.setEnabled(a.isEnabled());
            bVar.setClickable(a.isClickable());
            bVar.setFocusable(a.isFocusable());
            bVar.setFocused(a.isFocused());
            bVar.setAccessibilityFocused(a.isAccessibilityFocused());
            bVar.setSelected(a.isSelected());
            bVar.setLongClickable(a.isLongClickable());
            bVar.addAction(a.getActions());
            android.support.v4.view.a.b.yS.d(bVar.yT, android.support.v4.view.a.b.yS.C(a.yT));
            a.recycle();
            bVar.setClassName(SlidingPaneLayout.class.getName());
            bVar.setSource(view);
            ViewParent J = y.J(view);
            if (J instanceof View) {
                bVar.setParent((View) J);
            }
            int childCount = this.CW.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.CW.getChildAt(i);
                if (!aG(childAt) && childAt.getVisibility() == 0) {
                    y.h(childAt, 1);
                    bVar.addChild(childAt);
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (aG(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        private boolean aG(View view) {
            return this.CW.aF(view);
        }
    }

    private class c extends android.support.v4.widget.u.a {
        final /* synthetic */ SlidingPaneLayout CW;

        private c(SlidingPaneLayout slidingPaneLayout) {
            this.CW = slidingPaneLayout;
        }

        public final boolean a(View view, int i) {
            if (this.CW.xT) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).CY;
        }

        public final void j(int i) {
            if (this.CW.CS.DU != 0) {
                return;
            }
            if (this.CW.CO == 0.0f) {
                this.CW.aD(this.CW.CN);
                SlidingPaneLayout slidingPaneLayout = this.CW;
                this.CW.CN;
                slidingPaneLayout.sendAccessibilityEvent(32);
                this.CW.CT = false;
                return;
            }
            slidingPaneLayout = this.CW;
            this.CW.CN;
            slidingPaneLayout.sendAccessibilityEvent(32);
            this.CW.CT = true;
        }

        public final void e(View view, int i) {
            this.CW.cF();
        }

        public final void a(View view, int i, int i2) {
            SlidingPaneLayout.a(this.CW, i);
            this.CW.invalidate();
        }

        public final void a(View view, float f, float f2) {
            int paddingRight;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.CW.cH()) {
                paddingRight = layoutParams.rightMargin + this.CW.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && this.CW.CO > 0.5f)) {
                    paddingRight += this.CW.CQ;
                }
                paddingRight = (this.CW.getWidth() - paddingRight) - this.CW.CN.getWidth();
            } else {
                paddingRight = layoutParams.leftMargin + this.CW.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && this.CW.CO > 0.5f)) {
                    paddingRight += this.CW.CQ;
                }
            }
            this.CW.CS.p(paddingRight, view.getTop());
            this.CW.invalidate();
        }

        public final int s(View view) {
            return this.CW.CQ;
        }

        public final int c(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) this.CW.CN.getLayoutParams();
            if (this.CW.cH()) {
                int width = this.CW.getWidth() - ((layoutParams.rightMargin + this.CW.getPaddingRight()) + this.CW.CN.getWidth());
                return Math.max(Math.min(i, width), width - this.CW.CQ);
            }
            width = layoutParams.leftMargin + this.CW.getPaddingLeft();
            return Math.min(Math.max(i, width), this.CW.CQ + width);
        }

        public final int b(View view, int i) {
            return view.getTop();
        }

        public final void m(int i, int i2) {
            this.CW.CS.m(this.CW.CN, i2);
        }
    }

    static class e implements d {
        e() {
        }

        public void b(SlidingPaneLayout slidingPaneLayout, View view) {
            y.b(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class f extends e {
        private Method Dc;
        private Field Dd;

        f() {
            try {
                this.Dc = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.Dd = View.class.getDeclaredField("mRecreateDisplayList");
                this.Dd.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
        }

        public final void b(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.Dc == null || this.Dd == null) {
                view.invalidate();
                return;
            }
            try {
                this.Dd.setBoolean(view, true);
                this.Dc.invoke(view, null);
            } catch (Exception e) {
            }
            super.b(slidingPaneLayout, view);
        }
    }

    static class g extends e {
        g() {
        }

        public final void b(SlidingPaneLayout slidingPaneLayout, View view) {
            y.a(view, ((LayoutParams) view.getLayoutParams()).Da);
        }
    }

    static /* synthetic */ void a(SlidingPaneLayout slidingPaneLayout, int i) {
        if (slidingPaneLayout.CN == null) {
            slidingPaneLayout.CO = 0.0f;
            return;
        }
        boolean cH = slidingPaneLayout.cH();
        LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.CN.getLayoutParams();
        int width = slidingPaneLayout.CN.getWidth();
        if (cH) {
            i = (slidingPaneLayout.getWidth() - i) - width;
        }
        slidingPaneLayout.CO = ((float) (i - ((cH ? layoutParams.rightMargin : layoutParams.leftMargin) + (cH ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft())))) / ((float) slidingPaneLayout.CQ);
        if (slidingPaneLayout.CR != 0) {
            slidingPaneLayout.z(slidingPaneLayout.CO);
        }
        if (layoutParams.CZ) {
            slidingPaneLayout.a(slidingPaneLayout.CN, slidingPaneLayout.CO, slidingPaneLayout.CH);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            CV = new g();
        } else if (i >= 16) {
            CV = new f();
        } else {
            CV = new e();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.CH = -858993460;
        this.yf = true;
        this.gF = new Rect();
        this.CU = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.CL = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        y.a((View) this, new a(this));
        y.h(this, 1);
        this.CS = u.a((ViewGroup) this, 0.5f, new c());
        this.CS.Ee = f * 400.0f;
    }

    final void aD(View view) {
        int left;
        int right;
        int top;
        int bottom;
        int childCount;
        int i;
        View childAt;
        int i2;
        int max;
        boolean cH = cH();
        int width = cH ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = cH ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null) {
            Object obj;
            if (y.K(view)) {
                obj = 1;
            } else {
                if (VERSION.SDK_INT < 18) {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        obj = background.getOpacity() == -1 ? 1 : null;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                left = view.getLeft();
                right = view.getRight();
                top = view.getTop();
                bottom = view.getBottom();
                childCount = getChildCount();
                i = 0;
                while (i < childCount) {
                    childAt = getChildAt(i);
                    if (childAt != view) {
                        if (cH) {
                            i2 = width;
                        } else {
                            i2 = paddingLeft;
                        }
                        max = Math.max(i2, childAt.getLeft());
                        int max2 = Math.max(paddingTop, childAt.getTop());
                        if (cH) {
                            i2 = paddingLeft;
                        } else {
                            i2 = width;
                        }
                        i2 = Math.min(i2, childAt.getRight());
                        int min = Math.min(height, childAt.getBottom());
                        if (max >= left || max2 < r3 || i2 > r4 || min > r2) {
                            i2 = 0;
                        } else {
                            i2 = 4;
                        }
                        childAt.setVisibility(i2);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
        bottom = 0;
        top = 0;
        right = 0;
        left = 0;
        childCount = getChildCount();
        i = 0;
        while (i < childCount) {
            childAt = getChildAt(i);
            if (childAt != view) {
                if (cH) {
                    i2 = width;
                } else {
                    i2 = paddingLeft;
                }
                max = Math.max(i2, childAt.getLeft());
                int max22 = Math.max(paddingTop, childAt.getTop());
                if (cH) {
                    i2 = paddingLeft;
                } else {
                    i2 = width;
                }
                i2 = Math.min(i2, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= left) {
                }
                i2 = 0;
                childAt.setVisibility(i2);
                i++;
            } else {
                return;
            }
        }
    }

    final void cF() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yf = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.yf = true;
        int size = this.CU.size();
        for (int i = 0; i < size; i++) {
            ((b) this.CU.get(i)).run();
        }
        this.CU.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int makeMeasureSpec;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (isInEditMode()) {
            if (mode != Integer.MIN_VALUE && mode == 0) {
                i3 = mode2;
                i4 = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                mode2 = 0;
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                size2 = mode2;
                break;
            default:
                mode2 = 0;
                size2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.CN = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = mode2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            boolean z2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.CZ = false;
                mode2 = i6;
                mode = i7;
                f2 = f;
                z2 = z;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f += layoutParams.weight;
                    if (layoutParams.width == 0) {
                        mode2 = i6;
                        mode = i7;
                        f2 = f;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                } else {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, makeMeasureSpec);
                mode = childAt.getMeasuredWidth();
                makeMeasureSpec = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && makeMeasureSpec > i7) {
                    i7 = Math.min(makeMeasureSpec, size2);
                }
                makeMeasureSpec = i6 - mode;
                boolean z3 = makeMeasureSpec < 0;
                layoutParams.CY = z3;
                z3 |= z;
                if (layoutParams.CY) {
                    this.CN = childAt;
                }
                mode2 = makeMeasureSpec;
                f2 = f;
                z2 = z3;
                mode = i7;
            }
            i5++;
            z = z2;
            i7 = mode;
            i6 = mode2;
            f = f2;
        }
        if (z || f > 0.0f) {
            int i8 = paddingLeft - this.CL;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.weight <= 0.0f) ? null : 1;
                        makeMeasureSpec = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.CN) {
                            if (layoutParams.weight > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    mode2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                    if (makeMeasureSpec != mode2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.weight * ((float) Math.max(0, i6))) / f)) + makeMeasureSpec, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (makeMeasureSpec > i8 || layoutParams.weight > 0.0f)) {
                            if (obj == null) {
                                mode2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                            } else {
                                mode2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), mode2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.CM = z;
        if (this.CS.DU != 0 && !z) {
            this.CS.abort();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean cH = cH();
        if (cH) {
            this.CS.Eg = 2;
        } else {
            this.CS.Eg = 1;
        }
        int i6 = i3 - i;
        int paddingRight = cH ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = cH ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.yf) {
            float f = (this.CM && this.CT) ? 1.0f : 0.0f;
            this.CO = f;
        }
        int i7 = 0;
        int i8 = paddingRight;
        while (i7 < childCount) {
            int i9;
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i11 = 0;
                if (layoutParams.CY) {
                    int min = (Math.min(paddingRight, (i6 - paddingLeft) - this.CL) - i8) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.CQ = min;
                    i9 = cH ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.CZ = ((i8 + i9) + min) + (measuredWidth / 2) > i6 - paddingLeft;
                    i5 = (int) (((float) min) * this.CO);
                    i10 = i8 + (i9 + i5);
                    this.CO = ((float) i5) / ((float) this.CQ);
                } else {
                    if (!this.CM || this.CR == 0) {
                        i5 = 0;
                    } else {
                        i5 = (int) ((1.0f - this.CO) * ((float) this.CR));
                    }
                    i11 = i5;
                    i10 = paddingRight;
                }
                if (cH) {
                    i9 = (i6 - i10) + i11;
                    i5 = i9 - measuredWidth;
                } else {
                    i5 = i10 - i11;
                    i9 = i5 + measuredWidth;
                }
                childAt.layout(i5, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i5 = childAt.getWidth() + paddingRight;
                i9 = i10;
            } else {
                i5 = paddingRight;
                i9 = i8;
            }
            i7++;
            paddingRight = i5;
            i8 = i9;
        }
        if (this.yf) {
            if (this.CM) {
                if (this.CR != 0) {
                    z(this.CO);
                }
                if (((LayoutParams) this.CN.getLayoutParams()).CZ) {
                    a(this.CN, this.CO, this.CH);
                }
            } else {
                for (i5 = 0; i5 < childCount; i5++) {
                    a(getChildAt(i5), 0.0f, this.CH);
                }
            }
            aD(this.CN);
        }
        this.yf = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.yf = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.CM) {
            this.CT = view == this.CN;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.n.d(r7);
        r0 = r6.CM;
        if (r0 != 0) goto L_0x002b;
    L_0x000a:
        if (r3 != 0) goto L_0x002b;
    L_0x000c:
        r0 = r6.getChildCount();
        if (r0 <= r1) goto L_0x002b;
    L_0x0012:
        r0 = r6.getChildAt(r1);
        if (r0 == 0) goto L_0x002b;
    L_0x0018:
        r4 = r7.getX();
        r4 = (int) r4;
        r5 = r7.getY();
        r5 = (int) r5;
        r0 = android.support.v4.widget.u.f(r0, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0028:
        r0 = r1;
    L_0x0029:
        r6.CT = r0;
    L_0x002b:
        r0 = r6.CM;
        if (r0 == 0) goto L_0x0035;
    L_0x002f:
        r0 = r6.xT;
        if (r0 == 0) goto L_0x0041;
    L_0x0033:
        if (r3 == 0) goto L_0x0041;
    L_0x0035:
        r0 = r6.CS;
        r0.cancel();
        r2 = super.onInterceptTouchEvent(r7);
    L_0x003e:
        return r2;
    L_0x003f:
        r0 = r2;
        goto L_0x0029;
    L_0x0041:
        r0 = 3;
        if (r3 == r0) goto L_0x0046;
    L_0x0044:
        if (r3 != r1) goto L_0x004c;
    L_0x0046:
        r0 = r6.CS;
        r0.cancel();
        goto L_0x003e;
    L_0x004c:
        switch(r3) {
            case 0: goto L_0x005c;
            case 1: goto L_0x004f;
            case 2: goto L_0x007e;
            default: goto L_0x004f;
        };
    L_0x004f:
        r0 = r2;
    L_0x0050:
        r3 = r6.CS;
        r3 = r3.j(r7);
        if (r3 != 0) goto L_0x005a;
    L_0x0058:
        if (r0 == 0) goto L_0x003e;
    L_0x005a:
        r2 = r1;
        goto L_0x003e;
    L_0x005c:
        r6.xT = r2;
        r0 = r7.getX();
        r3 = r7.getY();
        r6.wL = r0;
        r6.wM = r3;
        r4 = r6.CN;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = android.support.v4.widget.u.f(r4, r0, r3);
        if (r0 == 0) goto L_0x004f;
    L_0x0074:
        r0 = r6.CN;
        r0 = r6.aF(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x007c:
        r0 = r1;
        goto L_0x0050;
    L_0x007e:
        r0 = r7.getX();
        r3 = r7.getY();
        r4 = r6.wL;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r6.wM;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r6.CS;
        r4 = r4.iD;
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x004f;
    L_0x009d:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x004f;
    L_0x00a1:
        r0 = r6.CS;
        r0.cancel();
        r6.xT = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.CM) {
            return super.onTouchEvent(motionEvent);
        }
        this.CS.k(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.wL = x;
                this.wM = y;
                break;
            case 1:
                if (aF(this.CN)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.wL;
                    float f2 = y - this.wM;
                    int i = this.CS.iD;
                    if ((f * f) + (f2 * f2) < ((float) (i * i)) && u.f(this.CN, (int) x, (int) y)) {
                        cG();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private boolean cG() {
        if (!this.yf && !y(0.0f)) {
            return false;
        }
        this.CT = false;
        return true;
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((WebView.NIGHT_MODE_COLOR & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.Da == null) {
                layoutParams.Da = new Paint();
            }
            layoutParams.Da.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (y.H(view) != 2) {
                y.a(view, 2, layoutParams.Da);
            }
            aE(view);
        } else if (y.H(view) != 0) {
            if (layoutParams.Da != null) {
                layoutParams.Da.setColorFilter(null);
            }
            Runnable bVar = new b(this, view);
            this.CU.add(bVar);
            y.a((View) this, bVar);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.CM || layoutParams.CY || this.CN == null)) {
            canvas.getClipBounds(this.gF);
            if (cH()) {
                this.gF.left = Math.max(this.gF.left, this.CN.getRight());
            } else {
                this.gF.right = Math.min(this.gF.right, this.CN.getLeft());
            }
            canvas.clipRect(this.gF);
        }
        if (VERSION.SDK_INT < 11) {
            if (layoutParams.CZ && this.CO > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.Da);
                    z = false;
                    canvas.restoreToCount(save);
                    return z;
                }
                new StringBuilder("drawChild: child view ").append(view).append(" returned null drawing cache");
            } else if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
        }
        z = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return z;
    }

    private void aE(View view) {
        CV.b(this, view);
    }

    private boolean y(float f) {
        if (!this.CM) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.CN.getLayoutParams();
        if (cH()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.CQ) * f)) + ((float) this.CN.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.CQ) * f));
        }
        if (!this.CS.e(this.CN, width, this.CN.getTop())) {
            return false;
        }
        cF();
        y.E(this);
        return true;
    }

    public void computeScroll() {
        if (!this.CS.cL()) {
            return;
        }
        if (this.CM) {
            y.E(this);
        } else {
            this.CS.abort();
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (cH()) {
            drawable = this.CK;
        } else {
            drawable = this.CJ;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (cH()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void z(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        float f2;
        boolean cH = cH();
        LayoutParams layoutParams = (LayoutParams) this.CN.getLayoutParams();
        if (layoutParams.CZ) {
            if ((cH ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt != this.CN) {
                        i2 = (int) ((1.0f - this.CP) * ((float) this.CR));
                        this.CP = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.CR));
                        if (cH) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            if (cH) {
                                f2 = 1.0f - this.CP;
                            } else {
                                f2 = this.CP - 1.0f;
                            }
                            a(childAt, f2, this.CI);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt != this.CN) {
                i2 = (int) ((1.0f - this.CP) * ((float) this.CR));
                this.CP = f;
                i2 -= (int) ((1.0f - f) * ((float) this.CR));
                if (cH) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (cH) {
                        f2 = 1.0f - this.CP;
                    } else {
                        f2 = this.CP - 1.0f;
                    }
                    a(childAt, f2, this.CI);
                }
            }
        }
    }

    final boolean aF(View view) {
        if (view == null) {
            return false;
        }
        return this.CM && ((LayoutParams) view.getLayoutParams()).CZ && this.CO > 0.0f;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.CM ? !this.CM || this.CO == 1.0f : this.CT;
        savedState.Db = z;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (!savedState.Db) {
                cG();
            } else if (this.yf || y(1.0f)) {
                this.CT = true;
            }
            this.CT = savedState.Db;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean cH() {
        return y.I(this) == 1;
    }
}
