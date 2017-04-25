package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.y;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.sdk.WebView;

public class LinearLayoutCompat extends ViewGroup {
    boolean Wg;
    private int Wh;
    private int Wi;
    private int Wj;
    private int Wk;
    private float Wl;
    private boolean Wm;
    private int[] Wn;
    private int[] Wo;
    private Drawable Wp;
    int Wq;
    private int Wr;
    private int Ws;
    private int Wt;
    private int tD;

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.cj);
            this.weight = obtainStyledAttributes.getFloat(k.Lh, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(k.Lg, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return ei();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return c(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return d(layoutParams);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.Wg = true;
        this.Wh = -1;
        this.Wi = 0;
        this.tD = 8388659;
        ap a = ap.a(context, attributeSet, k.ci, i);
        int i2 = a.getInt(k.Ll, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        i2 = a.getInt(k.Lk, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        boolean z2 = a.getBoolean(k.Li, true);
        if (!z2) {
            this.Wg = z2;
        }
        this.Wl = a.adM.getFloat(k.Lm, -1.0f);
        this.Wh = a.getInt(k.Lj, -1);
        this.Wm = a.getBoolean(k.Lp, false);
        Drawable drawable = a.getDrawable(k.Ln);
        if (drawable != this.Wp) {
            this.Wp = drawable;
            if (drawable != null) {
                this.Wq = drawable.getIntrinsicWidth();
                this.Wr = drawable.getIntrinsicHeight();
            } else {
                this.Wq = 0;
                this.Wr = 0;
            }
            if (drawable != null) {
                z = false;
            }
            setWillNotDraw(z);
            requestLayout();
        }
        this.Ws = a.getInt(k.Lq, 0);
        this.Wt = a.getDimensionPixelSize(k.Lo, 0);
        a.adM.recycle();
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected void onDraw(Canvas canvas) {
        if (this.Wp != null) {
            int childCount;
            int i;
            View childAt;
            if (this.Wj == 1) {
                childCount = getChildCount();
                i = 0;
                while (i < childCount) {
                    View childAt2 = getChildAt(i);
                    if (!(childAt2 == null || childAt2.getVisibility() == 8 || !aQ(i))) {
                        a(canvas, (childAt2.getTop() - ((LayoutParams) childAt2.getLayoutParams()).topMargin) - this.Wr);
                    }
                    i++;
                }
                if (aQ(childCount)) {
                    childAt = getChildAt(childCount - 1);
                    a(canvas, childAt == null ? (getHeight() - getPaddingBottom()) - this.Wr : ((LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom());
                    return;
                }
                return;
            }
            LayoutParams layoutParams;
            childCount = getChildCount();
            boolean bu = as.bu(this);
            i = 0;
            while (i < childCount) {
                View childAt3 = getChildAt(i);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !aQ(i))) {
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    b(canvas, bu ? layoutParams.rightMargin + childAt3.getRight() : (childAt3.getLeft() - layoutParams.leftMargin) - this.Wq);
                }
                i++;
            }
            if (aQ(childCount)) {
                int paddingLeft;
                childAt = getChildAt(childCount - 1);
                if (childAt == null) {
                    paddingLeft = bu ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.Wq;
                } else {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    paddingLeft = bu ? (childAt.getLeft() - layoutParams.leftMargin) - this.Wq : layoutParams.rightMargin + childAt.getRight();
                }
                b(canvas, paddingLeft);
            }
        }
    }

    private void a(Canvas canvas, int i) {
        this.Wp.setBounds(getPaddingLeft() + this.Wt, i, (getWidth() - getPaddingRight()) - this.Wt, this.Wr + i);
        this.Wp.draw(canvas);
    }

    private void b(Canvas canvas, int i) {
        this.Wp.setBounds(i, getPaddingTop() + this.Wt, this.Wq + i, (getHeight() - getPaddingBottom()) - this.Wt);
        this.Wp.draw(canvas);
    }

    public int getBaseline() {
        if (this.Wh < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.Wh) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.Wh);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.Wi;
            if (this.Wj == 1) {
                i = this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.Wk) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.Wk;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.Wh == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.Wj == 1) {
            int i3;
            int i4;
            int i5;
            int i6;
            int measuredWidth;
            int max;
            int i7;
            int i8;
            LayoutParams layoutParams;
            this.Wk = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            Object obj = 1;
            float f = 0.0f;
            int childCount = getChildCount();
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            Object obj2 = null;
            Object obj3 = null;
            int i13 = this.Wh;
            boolean z = this.Wm;
            int i14 = Integer.MIN_VALUE;
            int i15 = 0;
            while (i15 < childCount) {
                View childAt = getChildAt(i15);
                if (childAt == null) {
                    this.Wk += 0;
                    i3 = i15;
                } else {
                    Object obj4;
                    int combineMeasuredStates;
                    Object obj5;
                    float f2;
                    Object obj6;
                    if (childAt.getVisibility() != 8) {
                        Object obj7;
                        if (aQ(i15)) {
                            this.Wk += this.Wr;
                        }
                        LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                        float f3 = f + layoutParams2.weight;
                        if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                            i3 = this.Wk;
                            this.Wk = Math.max(i3, (layoutParams2.topMargin + i3) + layoutParams2.bottomMargin);
                            i4 = i14;
                            obj7 = 1;
                        } else {
                            i3 = Integer.MIN_VALUE;
                            if (layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                                i3 = 0;
                                layoutParams2.height = -2;
                            }
                            int i16 = i3;
                            e(childAt, i, 0, i2, f3 == 0.0f ? this.Wk : 0);
                            if (i16 != Integer.MIN_VALUE) {
                                layoutParams2.height = i16;
                            }
                            i3 = childAt.getMeasuredHeight();
                            i5 = this.Wk;
                            this.Wk = Math.max(i5, (((i5 + i3) + layoutParams2.topMargin) + layoutParams2.bottomMargin) + 0);
                            if (z) {
                                i4 = Math.max(i3, i14);
                                obj7 = obj3;
                            } else {
                                i4 = i14;
                                obj7 = obj3;
                            }
                        }
                        if (i13 >= 0 && i13 == i15 + 1) {
                            this.Wi = this.Wk;
                        }
                        if (i15 >= i13 || layoutParams2.weight <= 0.0f) {
                            Object obj8 = null;
                            if (mode == 1073741824 || layoutParams2.width != -1) {
                                obj4 = obj2;
                            } else {
                                obj4 = 1;
                                obj8 = 1;
                            }
                            i6 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                            measuredWidth = childAt.getMeasuredWidth() + i6;
                            max = Math.max(i9, measuredWidth);
                            combineMeasuredStates = as.combineMeasuredStates(i10, y.M(childAt));
                            obj5 = (obj == null || layoutParams2.width != -1) ? null : 1;
                            if (layoutParams2.weight > 0.0f) {
                                i3 = obj8 != null ? i6 : measuredWidth;
                                f2 = f3;
                                obj6 = obj5;
                                i7 = i11;
                                obj5 = obj7;
                                i14 = max;
                                int i17 = i4;
                                i4 = Math.max(i12, i3);
                                i3 = i17;
                            } else {
                                if (obj8 == null) {
                                    i6 = measuredWidth;
                                }
                                i3 = Math.max(i11, i6);
                                f2 = f3;
                                obj6 = obj5;
                                i7 = i3;
                                obj5 = obj7;
                                i3 = i4;
                                i4 = i12;
                                i14 = max;
                            }
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                    i3 = i14;
                    obj5 = obj3;
                    f2 = f;
                    obj6 = obj;
                    i4 = i12;
                    i7 = i11;
                    obj4 = obj2;
                    i14 = i9;
                    combineMeasuredStates = i10;
                    obj = obj6;
                    i12 = i4;
                    i11 = i7;
                    i10 = combineMeasuredStates;
                    i9 = i14;
                    i14 = i3;
                    obj2 = obj4;
                    i3 = i15 + 0;
                    f = f2;
                    obj3 = obj5;
                }
                i15 = i3 + 1;
            }
            if (this.Wk > 0 && aQ(childCount)) {
                this.Wk += this.Wr;
            }
            if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                this.Wk = 0;
                i8 = 0;
                while (i8 < childCount) {
                    View childAt2 = getChildAt(i8);
                    if (childAt2 == null) {
                        this.Wk += 0;
                        i3 = i8;
                    } else if (childAt2.getVisibility() == 8) {
                        i3 = i8 + 0;
                    } else {
                        layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        i6 = this.Wk;
                        this.Wk = Math.max(i6, (layoutParams.bottomMargin + ((i6 + i14) + layoutParams.topMargin)) + 0);
                        i3 = i8;
                    }
                    i8 = i3 + 1;
                }
            }
            this.Wk += getPaddingTop() + getPaddingBottom();
            i15 = y.resolveSizeAndState(Math.max(this.Wk, getSuggestedMinimumHeight()), i2, 0);
            i6 = (16777215 & i15) - this.Wk;
            int i18;
            if (obj3 != null || (i6 != 0 && f > 0.0f)) {
                if (this.Wl > 0.0f) {
                    f = this.Wl;
                }
                this.Wk = 0;
                i12 = 0;
                obj3 = obj;
                i18 = i11;
                i14 = i10;
                int i19 = i9;
                while (i12 < childCount) {
                    float f4;
                    Object obj9;
                    View childAt3 = getChildAt(i12);
                    if (childAt3.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt3.getLayoutParams();
                        float f5 = layoutParams.weight;
                        if (f5 > 0.0f) {
                            View view;
                            i8 = (int) ((((float) i6) * f5) / f);
                            f5 = f - f5;
                            i7 = i6 - i8;
                            i5 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width);
                            if (layoutParams.height != 0 || mode2 != 1073741824) {
                                i8 += childAt3.getMeasuredHeight();
                                if (i8 < 0) {
                                    i8 = 0;
                                }
                                view = childAt3;
                            } else if (i8 > 0) {
                                view = childAt3;
                            } else {
                                i8 = 0;
                                view = childAt3;
                            }
                            view.measure(i5, MeasureSpec.makeMeasureSpec(i8, 1073741824));
                            i5 = i7;
                            i6 = as.combineMeasuredStates(i14, y.M(childAt3) & -256);
                            f4 = f5;
                        } else {
                            f4 = f;
                            i5 = i6;
                            i6 = i14;
                        }
                        i4 = layoutParams.leftMargin + layoutParams.rightMargin;
                        i7 = childAt3.getMeasuredWidth() + i4;
                        i14 = Math.max(i19, i7);
                        obj = (mode == 1073741824 || layoutParams.width != -1) ? null : 1;
                        if (obj == null) {
                            i4 = i7;
                        }
                        i7 = Math.max(i18, i4);
                        obj9 = (obj3 == null || layoutParams.width != -1) ? null : 1;
                        max = this.Wk;
                        this.Wk = Math.max(max, (layoutParams.bottomMargin + ((childAt3.getMeasuredHeight() + max) + layoutParams.topMargin)) + 0);
                        i3 = i7;
                        measuredWidth = i14;
                    } else {
                        f4 = f;
                        obj9 = obj3;
                        i3 = i18;
                        measuredWidth = i19;
                        i5 = i6;
                        i6 = i14;
                    }
                    i12++;
                    obj3 = obj9;
                    i18 = i3;
                    i14 = i6;
                    i19 = measuredWidth;
                    i6 = i5;
                    f = f4;
                }
                this.Wk += getPaddingTop() + getPaddingBottom();
                i3 = i18;
                i10 = i14;
                i8 = i19;
                obj = obj3;
            } else {
                i18 = Math.max(i11, i12);
                if (z && mode2 != 1073741824) {
                    for (i8 = 0; i8 < childCount; i8++) {
                        View childAt4 = getChildAt(i8);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LayoutParams) childAt4.getLayoutParams()).weight <= 0.0f)) {
                            childAt4.measure(MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i14, 1073741824));
                        }
                    }
                }
                i3 = i18;
                i8 = i9;
            }
            if (obj != null || mode == 1073741824) {
                i3 = i8;
            }
            setMeasuredDimension(y.resolveSizeAndState(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i10), i15);
            if (obj2 != null) {
                F(childCount, i2);
                return;
            }
            return;
        }
        G(i, i2);
    }

    private boolean aQ(int i) {
        if (i == 0) {
            if ((this.Ws & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.Ws & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.Ws & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    private void F(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void G(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        int measuredHeight;
        int baseline;
        LayoutParams layoutParams;
        this.Wk = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int childCount = getChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.Wn == null || this.Wo == null) {
            this.Wn = new int[4];
            this.Wo = new int[4];
        }
        int[] iArr = this.Wn;
        int[] iArr2 = this.Wo;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.Wg;
        boolean z2 = this.Wm;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        while (i10 < childCount) {
            LayoutParams layoutParams2;
            int i11;
            Object obj5;
            Object obj6;
            int combineMeasuredStates;
            Object obj7;
            int i12;
            View childAt = getChildAt(i10);
            if (childAt == null) {
                this.Wk += 0;
                i3 = i10;
            } else {
                float f2;
                Object obj8;
                if (childAt.getVisibility() != 8) {
                    if (aQ(i10)) {
                        this.Wk += this.Wq;
                    }
                    layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    float f3 = f + layoutParams2.weight;
                    if (mode == 1073741824 && layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                        if (obj != null) {
                            this.Wk += layoutParams2.leftMargin + layoutParams2.rightMargin;
                        } else {
                            i3 = this.Wk;
                            this.Wk = Math.max(i3, (layoutParams2.leftMargin + i3) + layoutParams2.rightMargin);
                        }
                        if (z) {
                            i3 = MeasureSpec.makeMeasureSpec(0, 0);
                            childAt.measure(i3, i3);
                            i11 = i9;
                            obj5 = obj4;
                        } else {
                            i11 = i9;
                            i9 = 1;
                        }
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                            i3 = 0;
                            layoutParams2.width = -2;
                        }
                        int i13 = i3;
                        e(childAt, i, f3 == 0.0f ? this.Wk : 0, i2, 0);
                        if (i13 != Integer.MIN_VALUE) {
                            layoutParams2.width = i13;
                        }
                        i3 = childAt.getMeasuredWidth();
                        if (obj != null) {
                            this.Wk += ((layoutParams2.leftMargin + i3) + layoutParams2.rightMargin) + 0;
                        } else {
                            int i14 = this.Wk;
                            this.Wk = Math.max(i14, (((i14 + i3) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + 0);
                        }
                        if (z2) {
                            i11 = Math.max(i3, i9);
                            obj5 = obj4;
                        } else {
                            i11 = i9;
                            obj5 = obj4;
                        }
                    }
                    Object obj9 = null;
                    if (mode2 == 1073741824 || layoutParams2.height != -1) {
                        obj6 = obj3;
                    } else {
                        obj6 = 1;
                        obj9 = 1;
                    }
                    i4 = layoutParams2.topMargin + layoutParams2.bottomMargin;
                    measuredHeight = childAt.getMeasuredHeight() + i4;
                    combineMeasuredStates = as.combineMeasuredStates(i6, y.M(childAt));
                    if (z) {
                        baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            int i15 = ((((layoutParams2.gravity < 0 ? this.tD : layoutParams2.gravity) & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) >> 4) & -2) >> 1;
                            iArr[i15] = Math.max(iArr[i15], baseline);
                            iArr2[i15] = Math.max(iArr2[i15], measuredHeight - baseline);
                        }
                    }
                    baseline = Math.max(i5, measuredHeight);
                    obj7 = (obj2 == null || layoutParams2.height != -1) ? null : 1;
                    if (layoutParams2.weight > 0.0f) {
                        if (obj9 != null) {
                            i3 = i4;
                        } else {
                            i3 = measuredHeight;
                        }
                        f2 = f3;
                        obj8 = obj7;
                        i12 = i7;
                        obj7 = obj5;
                        i9 = baseline;
                        int i16 = i11;
                        i11 = Math.max(i8, i3);
                        i3 = i16;
                    } else {
                        if (obj9 == null) {
                            i4 = measuredHeight;
                        }
                        i3 = Math.max(i7, i4);
                        f2 = f3;
                        obj8 = obj7;
                        i12 = i3;
                        obj7 = obj5;
                        i3 = i11;
                        i11 = i8;
                        i9 = baseline;
                    }
                } else {
                    i3 = i9;
                    obj7 = obj4;
                    f2 = f;
                    obj8 = obj2;
                    i11 = i8;
                    i12 = i7;
                    obj6 = obj3;
                    i9 = i5;
                    combineMeasuredStates = i6;
                }
                obj2 = obj8;
                i8 = i11;
                i7 = i12;
                i6 = combineMeasuredStates;
                i5 = i9;
                i9 = i3;
                obj3 = obj6;
                i3 = i10 + 0;
                f = f2;
                obj4 = obj7;
            }
            i10 = i3 + 1;
        }
        if (this.Wk > 0 && aQ(childCount)) {
            this.Wk += this.Wq;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i4 = i5;
        } else {
            i4 = Math.max(i5, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.Wk = 0;
            i15 = 0;
            while (i15 < childCount) {
                View childAt2 = getChildAt(i15);
                if (childAt2 == null) {
                    this.Wk += 0;
                    i3 = i15;
                } else if (childAt2.getVisibility() == 8) {
                    i3 = i15 + 0;
                } else {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (obj != null) {
                        this.Wk = ((layoutParams.rightMargin + (layoutParams.leftMargin + i9)) + 0) + this.Wk;
                        i3 = i15;
                    } else {
                        measuredHeight = this.Wk;
                        this.Wk = Math.max(measuredHeight, (layoutParams.rightMargin + ((measuredHeight + i9) + layoutParams.leftMargin)) + 0);
                        i3 = i15;
                    }
                }
                i15 = i3 + 1;
            }
        }
        this.Wk += getPaddingLeft() + getPaddingRight();
        i5 = y.resolveSizeAndState(Math.max(this.Wk, getSuggestedMinimumWidth()), i, 0);
        measuredHeight = (16777215 & i5) - this.Wk;
        View view;
        if (obj4 != null || (measuredHeight != 0 && f > 0.0f)) {
            if (this.Wl > 0.0f) {
                f = this.Wl;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.Wk = 0;
            i8 = 0;
            obj5 = obj2;
            baseline = i7;
            int i17 = -1;
            i11 = i6;
            while (i8 < childCount) {
                float f4;
                View childAt3 = getChildAt(i8);
                if (childAt3 == null || childAt3.getVisibility() == 8) {
                    f4 = f;
                    i15 = measuredHeight;
                    i4 = baseline;
                    obj6 = obj5;
                    measuredHeight = i11;
                    i11 = i17;
                } else {
                    int childMeasureSpec;
                    float f5;
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    float f6 = layoutParams.weight;
                    if (f6 > 0.0f) {
                        i15 = (int) ((((float) measuredHeight) * f6) / f);
                        f6 = f - f6;
                        measuredHeight -= i15;
                        childMeasureSpec = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin, layoutParams.height);
                        if (layoutParams.width != 0 || mode != 1073741824) {
                            i15 += childAt3.getMeasuredWidth();
                            if (i15 < 0) {
                                i15 = 0;
                            }
                            view = childAt3;
                        } else if (i15 > 0) {
                            view = childAt3;
                        } else {
                            i15 = 0;
                            view = childAt3;
                        }
                        view.measure(MeasureSpec.makeMeasureSpec(i15, 1073741824), childMeasureSpec);
                        childMeasureSpec = as.combineMeasuredStates(i11, y.M(childAt3) & WebView.NIGHT_MODE_COLOR);
                        f5 = f6;
                        i12 = measuredHeight;
                    } else {
                        i12 = measuredHeight;
                        childMeasureSpec = i11;
                        f5 = f;
                    }
                    if (obj != null) {
                        this.Wk += ((childAt3.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + 0;
                    } else {
                        i15 = this.Wk;
                        this.Wk = Math.max(i15, (((childAt3.getMeasuredWidth() + i15) + layoutParams.leftMargin) + layoutParams.rightMargin) + 0);
                    }
                    obj7 = (mode2 == 1073741824 || layoutParams.height != -1) ? null : 1;
                    i14 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = childAt3.getMeasuredHeight() + i14;
                    i17 = Math.max(i17, measuredHeight);
                    if (obj7 != null) {
                        i15 = i14;
                    } else {
                        i15 = measuredHeight;
                    }
                    i14 = Math.max(baseline, i15);
                    obj7 = (obj5 == null || layoutParams.height != -1) ? null : 1;
                    if (z) {
                        i4 = childAt3.getBaseline();
                        if (i4 != -1) {
                            i3 = ((((layoutParams.gravity < 0 ? this.tD : layoutParams.gravity) & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i4);
                            iArr2[i3] = Math.max(iArr2[i3], measuredHeight - i4);
                        }
                    }
                    f4 = f5;
                    i4 = i14;
                    measuredHeight = childMeasureSpec;
                    obj6 = obj7;
                    i11 = i17;
                    i15 = i12;
                }
                i8++;
                obj5 = obj6;
                baseline = i4;
                i17 = i11;
                i11 = measuredHeight;
                f = f4;
                measuredHeight = i15;
            }
            this.Wk += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i17 = Math.max(i17, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            i3 = baseline;
            i6 = i11;
            i15 = i17;
            obj2 = obj5;
        } else {
            baseline = Math.max(i7, i8);
            if (z2 && mode != 1073741824) {
                for (i15 = 0; i15 < childCount; i15++) {
                    view = getChildAt(i15);
                    if (!(view == null || view.getVisibility() == 8 || ((LayoutParams) view.getLayoutParams()).weight <= 0.0f)) {
                        view.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = baseline;
            i15 = i4;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i15;
        }
        setMeasuredDimension((WebView.NIGHT_MODE_COLOR & i6) | i5, y.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i6 << 16));
        if (obj3 != null) {
            measuredHeight = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            for (int i18 = 0; i18 < childCount; i18++) {
                childAt = getChildAt(i18);
                if (childAt.getVisibility() != 8) {
                    layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams2.height == -1) {
                        combineMeasuredStates = layoutParams2.width;
                        layoutParams2.width = childAt.getMeasuredWidth();
                        measureChildWithMargins(childAt, i, 0, measuredHeight, 0);
                        layoutParams2.width = combineMeasuredStates;
                    }
                }
            }
        }
    }

    private void e(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
        r23 = this;
        r0 = r23;
        r3 = r0.Wj;
        r4 = 1;
        if (r3 != r4) goto L_0x00bd;
    L_0x0007:
        r8 = r23.getPaddingLeft();
        r3 = r27 - r25;
        r4 = r23.getPaddingRight();
        r9 = r3 - r4;
        r3 = r3 - r8;
        r4 = r23.getPaddingRight();
        r10 = r3 - r4;
        r11 = r23.getChildCount();
        r0 = r23;
        r3 = r0.tD;
        r3 = r3 & 112;
        r0 = r23;
        r4 = r0.tD;
        r5 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r5 = r5 & r4;
        switch(r3) {
            case 16: goto L_0x0053;
            case 80: goto L_0x0045;
            default: goto L_0x002f;
        };
    L_0x002f:
        r3 = r23.getPaddingTop();
    L_0x0033:
        r7 = 0;
        r6 = r3;
    L_0x0035:
        if (r7 >= r11) goto L_0x01d6;
    L_0x0037:
        r0 = r23;
        r12 = r0.getChildAt(r7);
        if (r12 != 0) goto L_0x0062;
    L_0x003f:
        r6 = r6 + 0;
        r3 = r7;
    L_0x0042:
        r7 = r3 + 1;
        goto L_0x0035;
    L_0x0045:
        r3 = r23.getPaddingTop();
        r3 = r3 + r28;
        r3 = r3 - r26;
        r0 = r23;
        r4 = r0.Wk;
        r3 = r3 - r4;
        goto L_0x0033;
    L_0x0053:
        r3 = r23.getPaddingTop();
        r4 = r28 - r26;
        r0 = r23;
        r6 = r0.Wk;
        r4 = r4 - r6;
        r4 = r4 / 2;
        r3 = r3 + r4;
        goto L_0x0033;
    L_0x0062:
        r3 = r12.getVisibility();
        r4 = 8;
        if (r3 == r4) goto L_0x01e2;
    L_0x006a:
        r13 = r12.getMeasuredWidth();
        r14 = r12.getMeasuredHeight();
        r3 = r12.getLayoutParams();
        r3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r3;
        r4 = r3.gravity;
        if (r4 >= 0) goto L_0x007d;
    L_0x007c:
        r4 = r5;
    L_0x007d:
        r15 = android.support.v4.view.y.I(r23);
        r4 = android.support.v4.view.e.getAbsoluteGravity(r4, r15);
        r4 = r4 & 7;
        switch(r4) {
            case 1: goto L_0x00ab;
            case 5: goto L_0x00b7;
            default: goto L_0x008a;
        };
    L_0x008a:
        r4 = r3.leftMargin;
        r4 = r4 + r8;
    L_0x008d:
        r0 = r23;
        r15 = r0.aQ(r7);
        if (r15 == 0) goto L_0x009a;
    L_0x0095:
        r0 = r23;
        r15 = r0.Wr;
        r6 = r6 + r15;
    L_0x009a:
        r15 = r3.topMargin;
        r6 = r6 + r15;
        r15 = r6 + 0;
        f(r12, r4, r15, r13, r14);
        r3 = r3.bottomMargin;
        r3 = r3 + r14;
        r3 = r3 + 0;
        r6 = r6 + r3;
        r3 = r7 + 0;
        goto L_0x0042;
    L_0x00ab:
        r4 = r10 - r13;
        r4 = r4 / 2;
        r4 = r4 + r8;
        r15 = r3.leftMargin;
        r4 = r4 + r15;
        r15 = r3.rightMargin;
        r4 = r4 - r15;
        goto L_0x008d;
    L_0x00b7:
        r4 = r9 - r13;
        r15 = r3.rightMargin;
        r4 = r4 - r15;
        goto L_0x008d;
    L_0x00bd:
        r5 = android.support.v7.widget.as.bu(r23);
        r8 = r23.getPaddingTop();
        r3 = r28 - r26;
        r4 = r23.getPaddingBottom();
        r12 = r3 - r4;
        r3 = r3 - r8;
        r4 = r23.getPaddingBottom();
        r13 = r3 - r4;
        r14 = r23.getChildCount();
        r0 = r23;
        r3 = r0.tD;
        r4 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r3 = r3 & r4;
        r0 = r23;
        r4 = r0.tD;
        r11 = r4 & 112;
        r0 = r23;
        r15 = r0.Wg;
        r0 = r23;
        r0 = r0.Wn;
        r16 = r0;
        r0 = r23;
        r0 = r0.Wo;
        r17 = r0;
        r4 = android.support.v4.view.y.I(r23);
        r3 = android.support.v4.view.e.getAbsoluteGravity(r3, r4);
        switch(r3) {
            case 1: goto L_0x0134;
            case 5: goto L_0x0125;
            default: goto L_0x0101;
        };
    L_0x0101:
        r9 = r23.getPaddingLeft();
    L_0x0105:
        r4 = 0;
        r3 = 1;
        if (r5 == 0) goto L_0x01de;
    L_0x0109:
        r4 = r14 + -1;
        r3 = -1;
        r5 = r4;
        r4 = r3;
    L_0x010e:
        r10 = 0;
    L_0x010f:
        if (r10 >= r14) goto L_0x01d6;
    L_0x0111:
        r3 = r4 * r10;
        r18 = r5 + r3;
        r0 = r23;
        r1 = r18;
        r19 = r0.getChildAt(r1);
        if (r19 != 0) goto L_0x0144;
    L_0x011f:
        r9 = r9 + 0;
        r3 = r10;
    L_0x0122:
        r10 = r3 + 1;
        goto L_0x010f;
    L_0x0125:
        r3 = r23.getPaddingLeft();
        r3 = r3 + r27;
        r3 = r3 - r25;
        r0 = r23;
        r4 = r0.Wk;
        r9 = r3 - r4;
        goto L_0x0105;
    L_0x0134:
        r3 = r23.getPaddingLeft();
        r4 = r27 - r25;
        r0 = r23;
        r6 = r0.Wk;
        r4 = r4 - r6;
        r4 = r4 / 2;
        r9 = r3 + r4;
        goto L_0x0105;
    L_0x0144:
        r3 = r19.getVisibility();
        r6 = 8;
        if (r3 == r6) goto L_0x01db;
    L_0x014c:
        r20 = r19.getMeasuredWidth();
        r21 = r19.getMeasuredHeight();
        r6 = -1;
        r3 = r19.getLayoutParams();
        r3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r3;
        if (r15 == 0) goto L_0x0169;
    L_0x015d:
        r7 = r3.height;
        r22 = -1;
        r0 = r22;
        if (r7 == r0) goto L_0x0169;
    L_0x0165:
        r6 = r19.getBaseline();
    L_0x0169:
        r7 = r3.gravity;
        if (r7 >= 0) goto L_0x016e;
    L_0x016d:
        r7 = r11;
    L_0x016e:
        r7 = r7 & 112;
        switch(r7) {
            case 16: goto L_0x01ad;
            case 48: goto L_0x019c;
            case 80: goto L_0x01b9;
            default: goto L_0x0173;
        };
    L_0x0173:
        r6 = r8;
    L_0x0174:
        r0 = r23;
        r1 = r18;
        r7 = r0.aQ(r1);
        if (r7 == 0) goto L_0x01d7;
    L_0x017e:
        r0 = r23;
        r7 = r0.Wq;
        r7 = r7 + r9;
    L_0x0183:
        r9 = r3.leftMargin;
        r7 = r7 + r9;
        r9 = r7 + 0;
        r0 = r19;
        r1 = r20;
        r2 = r21;
        f(r0, r9, r6, r1, r2);
        r3 = r3.rightMargin;
        r3 = r3 + r20;
        r3 = r3 + 0;
        r9 = r7 + r3;
        r3 = r10 + 0;
        goto L_0x0122;
    L_0x019c:
        r7 = r3.topMargin;
        r7 = r7 + r8;
        r22 = -1;
        r0 = r22;
        if (r6 == r0) goto L_0x01d9;
    L_0x01a5:
        r22 = 1;
        r22 = r16[r22];
        r6 = r22 - r6;
        r6 = r6 + r7;
        goto L_0x0174;
    L_0x01ad:
        r6 = r13 - r21;
        r6 = r6 / 2;
        r6 = r6 + r8;
        r7 = r3.topMargin;
        r6 = r6 + r7;
        r7 = r3.bottomMargin;
        r6 = r6 - r7;
        goto L_0x0174;
    L_0x01b9:
        r7 = r12 - r21;
        r0 = r3.bottomMargin;
        r22 = r0;
        r7 = r7 - r22;
        r22 = -1;
        r0 = r22;
        if (r6 == r0) goto L_0x01d9;
    L_0x01c7:
        r22 = r19.getMeasuredHeight();
        r6 = r22 - r6;
        r22 = 2;
        r22 = r17[r22];
        r6 = r22 - r6;
        r6 = r7 - r6;
        goto L_0x0174;
    L_0x01d6:
        return;
    L_0x01d7:
        r7 = r9;
        goto L_0x0183;
    L_0x01d9:
        r6 = r7;
        goto L_0x0174;
    L_0x01db:
        r3 = r10;
        goto L_0x0122;
    L_0x01de:
        r5 = r4;
        r4 = r3;
        goto L_0x010e;
    L_0x01e2:
        r3 = r7;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    private static void f(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public final void setOrientation(int i) {
        if (this.Wj != i) {
            this.Wj = i;
            requestLayout();
        }
    }

    public final void setGravity(int i) {
        if (this.tD != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 0) {
                i2 |= 48;
            }
            this.tD = i2;
            requestLayout();
        }
    }

    public LayoutParams c(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams ei() {
        if (this.Wj == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.Wj == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    protected LayoutParams d(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }
}
