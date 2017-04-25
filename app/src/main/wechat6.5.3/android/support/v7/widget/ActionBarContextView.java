package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a {
    private TextView EI;
    private View QX;
    private LinearLayout QY;
    private TextView QZ;
    private int Ra;
    private int Rb;
    public boolean Rc;
    private int Rd;
    private View kC;
    public CharSequence up;
    public CharSequence uq;

    public final /* bridge */ /* synthetic */ ah b(int i, long j) {
        return super.b(i, j);
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ap a = ap.a(context, attributeSet, k.aZ, i);
        setBackgroundDrawable(a.getDrawable(k.KA));
        this.Ra = a.getResourceId(k.KE, 0);
        this.Rb = a.getResourceId(k.KD, 0);
        this.QG = a.getLayoutDimension(k.KC, 0);
        this.Rd = a.getResourceId(k.KB, h.JL);
        a.adM.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.QF != null) {
            this.QF.hideOverflowMenu();
            this.QF.ee();
        }
    }

    public final void aw(int i) {
        this.QG = i;
    }

    public final void setCustomView(View view) {
        if (this.kC != null) {
            removeView(this.kC);
        }
        this.kC = view;
        if (!(view == null || this.QY == null)) {
            removeView(this.QY);
            this.QY = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public final void setTitle(CharSequence charSequence) {
        this.up = charSequence;
        dR();
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.uq = charSequence;
        dR();
    }

    private void dR() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.QY == null) {
            LayoutInflater.from(getContext()).inflate(h.JI, this);
            this.QY = (LinearLayout) getChildAt(getChildCount() - 1);
            this.EI = (TextView) this.QY.findViewById(f.IY);
            this.QZ = (TextView) this.QY.findViewById(f.IX);
            if (this.Ra != 0) {
                this.EI.setTextAppearance(getContext(), this.Ra);
            }
            if (this.Rb != 0) {
                this.QZ.setTextAppearance(getContext(), this.Rb);
            }
        }
        this.EI.setText(this.up);
        this.QZ.setText(this.uq);
        Object obj2 = !TextUtils.isEmpty(this.up) ? 1 : null;
        if (TextUtils.isEmpty(this.uq)) {
            obj = null;
        }
        TextView textView = this.QZ;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.QY;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.QY.getParent() == null) {
            addView(this.QY);
        }
    }

    public final void c(final b bVar) {
        if (this.QX == null) {
            this.QX = LayoutInflater.from(getContext()).inflate(this.Rd, this, false);
            addView(this.QX);
        } else if (this.QX.getParent() == null) {
            addView(this.QX);
        }
        this.QX.findViewById(f.Jc).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView Rf;

            public final void onClick(View view) {
                bVar.finish();
            }
        });
        android.support.v7.view.menu.f fVar = (android.support.v7.view.menu.f) bVar.getMenu();
        if (this.QF != null) {
            this.QF.ed();
        }
        this.QF = new ActionMenuPresenter(getContext());
        this.QF.ec();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        fVar.a(this.QF, this.QD);
        this.QE = (ActionMenuView) this.QF.c(this);
        this.QE.setBackgroundDrawable(null);
        addView(this.QE, layoutParams);
    }

    public final void dS() {
        if (this.QX == null) {
            dT();
        }
    }

    public final void dT() {
        removeAllViews();
        this.kC = null;
        this.QE = null;
    }

    public final boolean showOverflowMenu() {
        if (this.QF != null) {
            return this.QF.showOverflowMenu();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int g;
            int size = MeasureSpec.getSize(i);
            int size2 = this.QG > 0 ? this.QG : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.QX != null) {
                g = a.g(this.QX, paddingLeft, makeMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.QX.getLayoutParams();
                paddingLeft = g - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.QE != null && this.QE.getParent() == this) {
                paddingLeft = a.g(this.QE, paddingLeft, makeMeasureSpec);
            }
            if (this.QY != null && this.kC == null) {
                if (this.Rc) {
                    this.QY.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    g = this.QY.getMeasuredWidth();
                    makeMeasureSpec = g <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= g;
                    }
                    this.QY.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a.g(this.QY, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.kC != null) {
                int min;
                LayoutParams layoutParams = this.kC.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.kC.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.QG <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean bu = as.bu(this);
        int paddingRight = bu ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.QX == null || this.QX.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.QX.getLayoutParams();
            int i6 = bu ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = bu ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = a.c(paddingRight, i6, bu);
            paddingRight = a.c(paddingRight + a.a(this.QX, paddingRight, paddingTop, paddingTop2, bu), i5, bu);
        }
        if (!(this.QY == null || this.kC != null || this.QY.getVisibility() == 8)) {
            paddingRight += a.a(this.QY, paddingRight, paddingTop, paddingTop2, bu);
        }
        if (this.kC != null) {
            a.a(this.kC, paddingRight, paddingTop, paddingTop2, bu);
        }
        i5 = bu ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.QE != null) {
            a.a(this.QE, i5, paddingTop, paddingTop2, !bu);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.up);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public final void K(boolean z) {
        if (z != this.Rc) {
            requestLayout();
        }
        this.Rc = z;
    }
}
