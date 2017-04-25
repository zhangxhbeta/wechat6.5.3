package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import com.tencent.mm.plugin.gif.MMGIFException;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable dG;
    private final Rect dH;
    private final Rect dI;
    private int dJ;
    protected boolean dK;
    boolean dL;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dH = new Rect();
        this.dI = new Rect();
        this.dJ = 119;
        this.dK = true;
        this.dL = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ce, i, 0);
        this.dJ = obtainStyledAttributes.getInt(i.cg, this.dJ);
        Drawable drawable = obtainStyledAttributes.getDrawable(i.cf);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.dK = obtainStyledAttributes.getBoolean(i.ch, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.dJ;
    }

    public void setForegroundGravity(int i) {
        if (this.dJ != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 0) {
                i2 |= 48;
            }
            this.dJ = i2;
            if (this.dJ == 119 && this.dG != null) {
                this.dG.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.dG;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.dG != null) {
            this.dG.jumpToCurrentState();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.dG != null && this.dG.isStateful()) {
            this.dG.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.dG != drawable) {
            if (this.dG != null) {
                this.dG.setCallback(null);
                unscheduleDrawable(this.dG);
            }
            this.dG = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.dJ == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.dG;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dL |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dL = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.dG != null) {
            Drawable drawable = this.dG;
            if (this.dL) {
                this.dL = false;
                Rect rect = this.dH;
                Rect rect2 = this.dI;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.dK) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.dJ, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.dG != null) {
            this.dG.setHotspot(f, f2);
        }
    }
}
