package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.a.d;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.v4.view.y;
import android.support.v4.widget.r;
import android.support.v7.widget.h;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mmdb.database.SQLiteDebug;
import java.util.ArrayList;

public class TabLayout extends HorizontalScrollView {
    private static final android.support.v4.e.h.a<b> jR = new android.support.v4.e.h.c();
    private final ArrayList<b> jS;
    private b jT;
    private final a jU;
    private int jV;
    private int jW;
    private int jX;
    private int jY;
    private int jZ;
    private ColorStateList ka;
    private float kb;
    private float kc;
    private final int kd;
    private int ke;
    private final int kf;
    private final int kg;
    private final int kh;
    private int ki;
    private int kj;
    private u kk;
    private final android.support.v4.e.h.a<c> kl;
    private int mMode;

    private class a extends LinearLayout {
        final /* synthetic */ TabLayout km;
        int kn;
        final Paint ko;
        int kp = -1;
        float kq;
        private int kr = -1;
        private int ks = -1;
        u kt;

        a(TabLayout tabLayout, Context context) {
            this.km = tabLayout;
            super(context);
            setWillNotDraw(false);
            this.ko = new Paint();
        }

        protected final void onMeasure(int i, int i2) {
            Object obj = null;
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824 && this.km.mMode == 1 && this.km.kj == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    int max;
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        max = Math.max(i4, childAt.getMeasuredWidth());
                    } else {
                        max = i4;
                    }
                    i3++;
                    i4 = max;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (this.km.y(16) * 2)) {
                        i3 = 0;
                        while (i3 < childCount) {
                            Object obj2;
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                obj2 = obj;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                obj2 = 1;
                            }
                            i3++;
                            obj = obj2;
                        }
                    } else {
                        this.km.kj = 0;
                        this.km.j(false);
                        obj = 1;
                    }
                    if (obj != null) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.kt == null || !this.kt.lk.isRunning()) {
                at();
                return;
            }
            this.kt.lk.cancel();
            d(this.kp, Math.round(((float) this.kt.lk.getDuration()) * (1.0f - this.kt.lk.getAnimatedFraction())));
        }

        final void at() {
            int i;
            int i2;
            View childAt = getChildAt(this.kp);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (this.kq > 0.0f && this.kp < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.kp + 1);
                    i = (int) ((((float) i) * (1.0f - this.kq)) + (this.kq * ((float) childAt2.getLeft())));
                    i2 = (int) ((((float) i2) * (1.0f - this.kq)) + (((float) childAt2.getRight()) * this.kq));
                }
            }
            c(i, i2);
        }

        private void c(int i, int i2) {
            if (i != this.kr || i2 != this.ks) {
                this.kr = i;
                this.ks = i2;
                y.E(this);
            }
        }

        final void d(final int i, int i2) {
            if (this.kt != null && this.kt.lk.isRunning()) {
                this.kt.lk.cancel();
            }
            Object obj = y.I(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                at();
                return;
            }
            int i3;
            int i4;
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.kp) <= 1) {
                i3 = this.kr;
                i4 = this.ks;
            } else {
                int a = this.km.y(24);
                if (i < this.kp) {
                    if (obj == null) {
                        i4 = right + a;
                        i3 = i4;
                    }
                } else if (obj != null) {
                    i4 = right + a;
                    i3 = i4;
                }
                i4 = left - a;
                i3 = i4;
            }
            if (i3 != left || i4 != right) {
                u az = aa.az();
                this.kt = az;
                az.setInterpolator(a.es);
                az.setDuration(i2);
                az.e(0.0f, 1.0f);
                az.a(new c(this) {
                    final /* synthetic */ a ky;

                    public final void a(u uVar) {
                        float animatedFraction = uVar.lk.getAnimatedFraction();
                        this.ky.c(a.a(i3, left, animatedFraction), a.a(i4, right, animatedFraction));
                    }
                });
                az.lk.a(new android.support.design.widget.u.AnonymousClass2(az, new b(this) {
                    final /* synthetic */ a ky;

                    public final void au() {
                        this.ky.kp = i;
                        this.ky.kq = 0.0f;
                    }
                }));
                az.lk.start();
            }
        }

        public final void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.kr >= 0 && this.ks > this.kr) {
                canvas.drawRect((float) this.kr, (float) (getHeight() - this.kn), (float) this.ks, (float) getHeight(), this.ko);
            }
        }
    }

    public static final class b {
        Drawable jP;
        CharSequence kA;
        int kB;
        View kC;
        TabLayout kD;
        c kE;
        CharSequence mText;

        private b() {
            this.kB = -1;
        }

        public final void select() {
            if (this.kD == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.kD.a(this);
        }

        final void av() {
            if (this.kE != null) {
                this.kE.update();
            }
        }
    }

    class c extends LinearLayout implements OnLongClickListener {
        private View kC;
        private b kF;
        private TextView kG;
        private ImageView kH;
        private TextView kI;
        private ImageView kJ;
        private int kK = 2;
        final /* synthetic */ TabLayout km;

        static /* synthetic */ void a(c cVar, b bVar) {
            if (bVar != cVar.kF) {
                cVar.kF = bVar;
                cVar.update();
            }
        }

        public c(TabLayout tabLayout, Context context) {
            this.km = tabLayout;
            super(context);
            if (tabLayout.kd != 0) {
                setBackgroundDrawable(h.eD().a(context, tabLayout.kd, false));
            }
            y.c(this, tabLayout.jV, tabLayout.jW, tabLayout.jX, tabLayout.jY);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.kF == null) {
                return performClick;
            }
            this.kF.select();
            return true;
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
                if (this.kG != null) {
                    this.kG.setSelected(z);
                }
                if (this.kH != null) {
                    this.kH.setSelected(z);
                }
            }
        }

        @TargetApi(14)
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        @TargetApi(14)
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int f = this.km.ke;
            if (f > 0 && (mode == 0 || size > f)) {
                i = MeasureSpec.makeMeasureSpec(this.km.ke, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.kG != null) {
                getResources();
                float h = this.km.kb;
                size = this.kK;
                if (this.kH != null && this.kH.getVisibility() == 0) {
                    size = 1;
                } else if (this.kG != null && this.kG.getLineCount() > 1) {
                    h = this.km.kc;
                }
                float textSize = this.kG.getTextSize();
                int lineCount = this.kG.getLineCount();
                int c = r.c(this.kG);
                if (h != textSize || (c >= 0 && size != c)) {
                    if (this.km.mMode == 1 && h > textSize && lineCount == 1) {
                        Layout layout = this.kG.getLayout();
                        if (layout == null || layout.getLineWidth(0) * (h / layout.getPaint().getTextSize()) > ((float) layout.getWidth())) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.kG.setTextSize(0, h);
                        this.kG.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        final void update() {
            b bVar = this.kF;
            View view = bVar != null ? bVar.kC : null;
            if (view != null) {
                c parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(view);
                    }
                    addView(view);
                }
                this.kC = view;
                if (this.kG != null) {
                    this.kG.setVisibility(8);
                }
                if (this.kH != null) {
                    this.kH.setVisibility(8);
                    this.kH.setImageDrawable(null);
                }
                this.kI = (TextView) view.findViewById(16908308);
                if (this.kI != null) {
                    this.kK = r.c(this.kI);
                }
                this.kJ = (ImageView) view.findViewById(16908294);
            } else {
                if (this.kC != null) {
                    removeView(this.kC);
                    this.kC = null;
                }
                this.kI = null;
                this.kJ = null;
            }
            if (this.kC == null) {
                if (this.kH == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(f.az, this, false);
                    addView(imageView, 0);
                    this.kH = imageView;
                }
                if (this.kG == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(f.aA, this, false);
                    addView(textView);
                    this.kG = textView;
                    this.kK = r.c(this.kG);
                }
                this.kG.setTextAppearance(getContext(), this.km.jZ);
                if (this.km.ka != null) {
                    this.kG.setTextColor(this.km.ka);
                }
                a(this.kG, this.kH);
            } else if (this.kI != null || this.kJ != null) {
                a(this.kI, this.kJ);
            }
        }

        private void a(TextView textView, ImageView imageView) {
            CharSequence charSequence;
            CharSequence charSequence2;
            boolean z;
            Drawable drawable = this.kF != null ? this.kF.jP : null;
            if (this.kF != null) {
                charSequence = this.kF.mText;
            } else {
                charSequence = null;
            }
            if (this.kF != null) {
                charSequence2 = this.kF.kA;
            } else {
                charSequence2 = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequence2);
            }
            if (TextUtils.isEmpty(charSequence)) {
                z = false;
            } else {
                z = true;
            }
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                int a;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    a = this.km.y(8);
                } else {
                    a = 0;
                }
                if (a != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(charSequence2)) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public final boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.kF.kA, 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jS = new ArrayList();
        this.ke = Integer.MAX_VALUE;
        this.kl = new android.support.v4.e.h.b(12);
        t.g(context);
        setHorizontalScrollBarEnabled(false);
        this.jU = new a(this, context);
        super.addView(this.jU, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cR, i, android.support.design.a.h.aT);
        View view = this.jU;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.cW, 0);
        if (view.kn != dimensionPixelSize) {
            view.kn = dimensionPixelSize;
            y.E(view);
        }
        view = this.jU;
        dimensionPixelSize = obtainStyledAttributes.getColor(i.cV, 0);
        if (view.ko.getColor() != dimensionPixelSize) {
            view.ko.setColor(dimensionPixelSize);
            y.E(view);
        }
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i.da, 0);
        this.jY = dimensionPixelSize2;
        this.jX = dimensionPixelSize2;
        this.jW = dimensionPixelSize2;
        this.jV = dimensionPixelSize2;
        this.jV = obtainStyledAttributes.getDimensionPixelSize(i.dd, this.jV);
        this.jW = obtainStyledAttributes.getDimensionPixelSize(i.de, this.jW);
        this.jX = obtainStyledAttributes.getDimensionPixelSize(i.dc, this.jX);
        this.jY = obtainStyledAttributes.getDimensionPixelSize(i.db, this.jY);
        this.jZ = obtainStyledAttributes.getResourceId(i.dh, android.support.design.a.h.aL);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.jZ, i.dj);
        try {
            this.kb = (float) obtainStyledAttributes2.getDimensionPixelSize(i.dp, 0);
            this.ka = obtainStyledAttributes2.getColorStateList(i.do);
            if (obtainStyledAttributes.hasValue(i.di)) {
                this.ka = obtainStyledAttributes.getColorStateList(i.di);
            }
            if (obtainStyledAttributes.hasValue(i.dg)) {
                dimensionPixelSize2 = obtainStyledAttributes.getColor(i.dg, 0);
                dimensionPixelSize = this.ka.getDefaultColor();
                r4 = new int[2][];
                int[] iArr = new int[]{SELECTED_STATE_SET, dimensionPixelSize2};
                r4[1] = EMPTY_STATE_SET;
                iArr[1] = dimensionPixelSize;
                this.ka = new ColorStateList(r4, iArr);
            }
            this.kf = obtainStyledAttributes.getDimensionPixelSize(i.cY, -1);
            this.kg = obtainStyledAttributes.getDimensionPixelSize(i.cX, -1);
            this.kd = obtainStyledAttributes.getResourceId(i.cS, 0);
            this.ki = obtainStyledAttributes.getDimensionPixelSize(i.cT, 0);
            this.mMode = obtainStyledAttributes.getInt(i.cZ, 1);
            this.kj = obtainStyledAttributes.getInt(i.cU, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.kc = (float) resources.getDimensionPixelSize(d.ap);
            this.kh = resources.getDimensionPixelSize(d.ao);
            y.c(this.jU, this.mMode == 0 ? Math.max(0, this.ki - this.jV) : 0, 0, 0, 0);
            switch (this.mMode) {
                case 0:
                    this.jU.setGravity(8388611);
                    break;
                case 1:
                    this.jU.setGravity(1);
                    break;
            }
            j(true);
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private void x(int i) {
        int round = Math.round(((float) i) + 0.0f);
        if (round >= 0 && round < this.jU.getChildCount()) {
            a aVar = this.jU;
            if (aVar.kt != null && aVar.kt.lk.isRunning()) {
                aVar.kt.lk.cancel();
            }
            aVar.kp = i;
            aVar.kq = 0.0f;
            aVar.at();
            if (this.kk != null && this.kk.lk.isRunning()) {
                this.kk.lk.cancel();
            }
            scrollTo(a(i, 0.0f), 0);
            A(round);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return Math.max(0, ((this.jU.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight()) > 0;
    }

    private void a(b bVar, int i) {
        bVar.kB = i;
        this.jS.add(i, bVar);
        int size = this.jS.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((b) this.jS.get(i2)).kB = i2;
        }
    }

    public void addView(View view) {
        t(view);
    }

    public void addView(View view, int i) {
        t(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    private void t(View view) {
        if (view instanceof TabItem) {
            b bVar;
            TabItem tabItem = (TabItem) view;
            b bVar2 = (b) jR.bJ();
            if (bVar2 == null) {
                bVar = new b();
            } else {
                bVar = bVar2;
            }
            bVar.kD = this;
            c cVar = this.kl != null ? (c) this.kl.bJ() : null;
            if (cVar == null) {
                cVar = new c(this, getContext());
            }
            c.a(cVar, bVar);
            cVar.setFocusable(true);
            cVar.setMinimumWidth(as());
            bVar.kE = cVar;
            if (tabItem.mText != null) {
                bVar.mText = tabItem.mText;
                bVar.av();
            }
            if (tabItem.jP != null) {
                bVar.jP = tabItem.jP;
                bVar.av();
            }
            if (tabItem.jQ != 0) {
                bVar.kC = LayoutInflater.from(bVar.kE.getContext()).inflate(tabItem.jQ, bVar.kE, false);
                bVar.av();
            }
            boolean isEmpty = this.jS.isEmpty();
            if (bVar.kD != this) {
                throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
            }
            View view2 = bVar.kE;
            a aVar = this.jU;
            LayoutParams layoutParams = new LayoutParams(-2, -1);
            a(layoutParams);
            aVar.addView(view2, layoutParams);
            if (isEmpty) {
                view2.setSelected(true);
            }
            a(bVar, this.jS.size());
            if (isEmpty) {
                bVar.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LayoutParams layoutParams) {
        if (this.mMode == 1 && this.kj == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int y(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 1;
        int size = this.jS.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) this.jS.get(i5);
            if (bVar != null && bVar.jP != null && !TextUtils.isEmpty(bVar.mText)) {
                i3 = 1;
                break;
            }
        }
        i3 = 0;
        i3 = (y(i3 != 0 ? 72 : 48) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(i3, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
                break;
        }
        i3 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.kg > 0) {
                i3 = this.kg;
            } else {
                i3 -= y(56);
            }
            this.ke = i3;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mMode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        i3 = 0;
                        break;
                    } else {
                        i3 = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i4 = 0;
                    }
                    i3 = i4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void z(int i) {
        Object obj = null;
        if (i != -1) {
            if (getWindowToken() != null && y.ai(this)) {
                int i2;
                a aVar = this.jU;
                int childCount = aVar.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (aVar.getChildAt(i2).getWidth() <= 0) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    int scrollX = getScrollX();
                    i2 = a(i, 0.0f);
                    if (scrollX != i2) {
                        if (this.kk == null) {
                            this.kk = aa.az();
                            this.kk.setInterpolator(a.es);
                            this.kk.setDuration(SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
                            this.kk.a(new c(this) {
                                final /* synthetic */ TabLayout km;

                                {
                                    this.km = r1;
                                }

                                public final void a(u uVar) {
                                    this.km.scrollTo(uVar.lk.aA(), 0);
                                }
                            });
                        }
                        this.kk.e(scrollX, i2);
                        this.kk.lk.start();
                    }
                    this.jU.d(i, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
                    return;
                }
            }
            x(i);
        }
    }

    private void A(int i) {
        int childCount = this.jU.getChildCount();
        if (i < childCount && !this.jU.getChildAt(i).isSelected()) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.jU.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    final void a(b bVar) {
        if (this.jT != bVar) {
            int i = bVar != null ? bVar.kB : -1;
            if (i != -1) {
                A(i);
            }
            if ((this.jT == null || this.jT.kB == -1) && i != -1) {
                x(i);
            } else {
                z(i);
            }
            this.jT = bVar;
        } else if (this.jT != null) {
            z(bVar.kB);
        }
    }

    private int a(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        int width;
        View childAt = this.jU.getChildAt(i);
        View childAt2 = i + 1 < this.jU.getChildCount() ? this.jU.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * 0.0f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void j(boolean z) {
        for (int i = 0; i < this.jU.getChildCount(); i++) {
            View childAt = this.jU.getChildAt(i);
            childAt.setMinimumWidth(as());
            a((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private int as() {
        if (this.kf != -1) {
            return this.kf;
        }
        return this.mMode == 0 ? this.kh : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }
}
