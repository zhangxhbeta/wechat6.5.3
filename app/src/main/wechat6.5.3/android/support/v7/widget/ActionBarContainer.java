package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.f;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable Pj;
    private boolean QO;
    View QP;
    private View QQ;
    private View QR;
    Drawable QS;
    Drawable QT;
    boolean QU;
    boolean QV;
    private int QW;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable cVar;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            cVar = new c(this);
        } else {
            cVar = new b(this);
        }
        setBackgroundDrawable(cVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.aV);
        this.Pj = obtainStyledAttributes.getDrawable(k.Kh);
        this.QS = obtainStyledAttributes.getDrawable(k.Kj);
        this.QW = obtainStyledAttributes.getDimensionPixelSize(k.Kp, -1);
        if (getId() == f.JC) {
            this.QU = true;
            this.QT = obtainStyledAttributes.getDrawable(k.Ki);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.QU ? this.QT == null : this.Pj == null && this.QS == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.QQ = findViewById(f.IU);
        this.QR = findViewById(f.IZ);
    }

    public final void l(Drawable drawable) {
        boolean z = true;
        if (this.Pj != null) {
            this.Pj.setCallback(null);
            unscheduleDrawable(this.Pj);
        }
        this.Pj = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.QQ != null) {
                this.Pj.setBounds(this.QQ.getLeft(), this.QQ.getTop(), this.QQ.getRight(), this.QQ.getBottom());
            }
        }
        if (this.QU) {
            if (this.QT != null) {
                z = false;
            }
        } else if (!(this.Pj == null && this.QS == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Pj != null) {
            this.Pj.setVisible(z, false);
        }
        if (this.QS != null) {
            this.QS.setVisible(z, false);
        }
        if (this.QT != null) {
            this.QT.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.Pj && !this.QU) || ((drawable == this.QS && this.QV) || ((drawable == this.QT && this.QU) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Pj != null && this.Pj.isStateful()) {
            this.Pj.setState(getDrawableState());
        }
        if (this.QS != null && this.QS.isStateful()) {
            this.QS.setState(getDrawableState());
        }
        if (this.QT != null && this.QT.isStateful()) {
            this.QT.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.Pj != null) {
                this.Pj.jumpToCurrentState();
            }
            if (this.QS != null) {
                this.QS.jumpToCurrentState();
            }
            if (this.QT != null) {
                this.QT.jumpToCurrentState();
            }
        }
    }

    public final void J(boolean z) {
        this.QO = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.QO || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public final void a(ai aiVar) {
        if (this.QP != null) {
            removeView(this.QP);
        }
        this.QP = aiVar;
        if (aiVar != null) {
            addView(aiVar);
            LayoutParams layoutParams = aiVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            aiVar.aaU = false;
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private static boolean aK(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int aL(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.QQ == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.QW >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.QW, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.QQ != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.QP != null && this.QP.getVisibility() != 8 && mode != 1073741824) {
                int aL;
                if (!aK(this.QQ)) {
                    aL = aL(this.QQ);
                } else if (aK(this.QR)) {
                    aL = 0;
                } else {
                    aL = aL(this.QR);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(aL + aL(this.QP), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.QP;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.QU) {
            int i6;
            if (this.Pj != null) {
                if (this.QQ.getVisibility() == 0) {
                    this.Pj.setBounds(this.QQ.getLeft(), this.QQ.getTop(), this.QQ.getRight(), this.QQ.getBottom());
                } else if (this.QR == null || this.QR.getVisibility() != 0) {
                    this.Pj.setBounds(0, 0, 0, 0);
                } else {
                    this.Pj.setBounds(this.QR.getLeft(), this.QR.getTop(), this.QR.getRight(), this.QR.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.QV = z2;
            if (!z2 || this.QS == null) {
                i5 = i6;
            } else {
                this.QS.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.QT != null) {
            this.QT.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
