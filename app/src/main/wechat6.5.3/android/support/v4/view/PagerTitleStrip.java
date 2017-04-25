package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements a {
    private static final int[] wZ = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] xa = new int[]{16843660};
    private static final b xd;
    private int tD;
    ViewPager wO;
    TextView wP;
    TextView wQ;
    TextView wR;
    private int wS = -1;
    private float wT = -1.0f;
    int wU;
    private boolean wV;
    private boolean wW;
    private final a wX = new a();
    private WeakReference<t> wY;
    private int xb;
    int xc;

    interface b {
        void b(TextView textView);
    }

    private class a extends DataSetObserver implements d, e {
        private int xe;
        final /* synthetic */ PagerTitleStrip xf;

        private a(PagerTitleStrip pagerTitleStrip) {
            this.xf = pagerTitleStrip;
        }

        public final void a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            this.xf.a(i, f, false);
        }

        public final void W(int i) {
            float f = 0.0f;
            if (this.xe == 0) {
                this.xf.a(this.xf.wO.xB, this.xf.wO.xA);
                if (this.xf.wT >= 0.0f) {
                    f = this.xf.wT;
                }
                this.xf.a(this.xf.wO.xB, f, true);
            }
        }

        public final void X(int i) {
            this.xe = i;
        }

        public final void b(t tVar, t tVar2) {
            this.xf.a(tVar, tVar2);
        }

        public final void onChanged() {
            float f = 0.0f;
            this.xf.a(this.xf.wO.xB, this.xf.wO.xA);
            if (this.xf.wT >= 0.0f) {
                f = this.xf.wT;
            }
            this.xf.a(this.xf.wO.xB, f, true);
        }
    }

    static class c implements b {
        c() {
        }

        public final void b(TextView textView) {
            textView.setSingleLine();
        }
    }

    static class d implements b {
        d() {
        }

        public final void b(TextView textView) {
            textView.setTransformationMethod(new a(textView.getContext()));
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            xd = new d();
        } else {
            xd = new c();
        }
    }

    private static void b(TextView textView) {
        xd.b(textView);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        View textView = new TextView(context);
        this.wP = textView;
        addView(textView);
        textView = new TextView(context);
        this.wQ = textView;
        addView(textView);
        textView = new TextView(context);
        this.wR = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, wZ);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.wP.setTextAppearance(context, resourceId);
            this.wQ.setTextAppearance(context, resourceId);
            this.wR.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.wP.setTextSize(0, f);
            this.wQ.setTextSize(0, f);
            this.wR.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.wP.setTextColor(dimensionPixelSize);
            this.wQ.setTextColor(dimensionPixelSize);
            this.wR.setTextColor(dimensionPixelSize);
        }
        this.tD = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.xc = this.wQ.getTextColors().getDefaultColor();
        this.xb = 153;
        int i = (this.xb << 24) | (this.xc & 16777215);
        this.wP.setTextColor(i);
        this.wR.setTextColor(i);
        this.wP.setEllipsize(TruncateAt.END);
        this.wQ.setEllipsize(TruncateAt.END);
        this.wR.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, xa);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            b(this.wP);
            b(this.wQ);
            b(this.wR);
        } else {
            this.wP.setSingleLine();
            this.wQ.setSingleLine();
            this.wR.setSingleLine();
        }
        this.wU = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void V(int i) {
        this.wU = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            t tVar = viewPager.xA;
            viewPager.a(this.wX);
            viewPager.ym = this.wX;
            this.wO = viewPager;
            a(this.wY != null ? (t) this.wY.get() : null, tVar);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.wO != null) {
            a(this.wO.xA, null);
            this.wO.a(null);
            this.wO.ym = null;
            this.wO = null;
        }
    }

    final void a(int i, t tVar) {
        if (tVar != null) {
            tVar.getCount();
        }
        this.wV = true;
        this.wP.setText(null);
        this.wQ.setText(null);
        this.wR.setText(null);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.wP.measure(makeMeasureSpec, makeMeasureSpec2);
        this.wQ.measure(makeMeasureSpec, makeMeasureSpec2);
        this.wR.measure(makeMeasureSpec, makeMeasureSpec2);
        this.wS = i;
        if (!this.wW) {
            a(i, this.wT, false);
        }
        this.wV = false;
    }

    public void requestLayout() {
        if (!this.wV) {
            super.requestLayout();
        }
    }

    final void a(t tVar, t tVar2) {
        if (tVar != null) {
            tVar.unregisterDataSetObserver(this.wX);
            this.wY = null;
        }
        if (tVar2 != null) {
            tVar2.registerDataSetObserver(this.wX);
            this.wY = new WeakReference(tVar2);
        }
        if (this.wO != null) {
            this.wS = -1;
            this.wT = -1.0f;
            a(this.wO.xB, tVar2);
            requestLayout();
        }
    }

    void a(int i, float f, boolean z) {
        if (i != this.wS) {
            a(i, this.wO.xA);
        } else if (!z && f == this.wT) {
            return;
        }
        this.wW = true;
        int measuredWidth = this.wP.getMeasuredWidth();
        int measuredWidth2 = this.wQ.getMeasuredWidth();
        int measuredWidth3 = this.wR.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i3 = ((width - i3) - ((int) (f2 * ((float) i4)))) - i2;
        i4 = i3 + measuredWidth2;
        int baseline = this.wP.getBaseline();
        measuredWidth2 = this.wQ.getBaseline();
        i2 = this.wR.getBaseline();
        int max = Math.max(Math.max(baseline, measuredWidth2), i2);
        baseline = max - baseline;
        measuredWidth2 = max - measuredWidth2;
        max -= i2;
        int measuredHeight = this.wR.getMeasuredHeight() + max;
        i2 = Math.max(Math.max(this.wP.getMeasuredHeight() + baseline, this.wQ.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            case 16:
                height = (((height - paddingTop) - paddingBottom) - i2) / 2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            case 80:
                height = (height - paddingBottom) - i2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            default:
                i2 = paddingTop + baseline;
                baseline = paddingTop + measuredWidth2;
                measuredWidth2 = paddingTop + max;
                break;
        }
        this.wQ.layout(i3, baseline, i4, this.wQ.getMeasuredHeight() + baseline);
        baseline = Math.min(paddingLeft, (i3 - this.wU) - measuredWidth);
        this.wP.layout(baseline, i2, measuredWidth + baseline, this.wP.getMeasuredHeight() + i2);
        baseline = Math.max((width - paddingRight) - measuredWidth3, this.wU + i4);
        this.wR.layout(baseline, measuredWidth2, baseline + measuredWidth3, this.wR.getMeasuredHeight() + measuredWidth2);
        this.wT = f;
        this.wW = false;
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.wP.measure(childMeasureSpec2, childMeasureSpec);
        this.wQ.measure(childMeasureSpec2, childMeasureSpec);
        this.wR.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.wQ.getMeasuredHeight());
        }
        setMeasuredDimension(size, y.resolveSizeAndState(paddingTop, i2, y.M(this.wQ) << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.wO != null) {
            if (this.wT >= 0.0f) {
                f = this.wT;
            }
            a(this.wS, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
