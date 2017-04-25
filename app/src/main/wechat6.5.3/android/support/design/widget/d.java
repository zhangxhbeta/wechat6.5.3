package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a;

class d extends Drawable {
    int fA;
    private ColorStateList fB;
    private int fC;
    boolean fD = true;
    float fE;
    final Paint ft = new Paint(1);
    final Rect fu = new Rect();
    final RectF fv = new RectF();
    float fw;
    int fx;
    int fy;
    int fz;

    public d() {
        this.ft.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas) {
        float height;
        if (this.fD) {
            Paint paint = this.ft;
            Rect rect = this.fu;
            copyBounds(rect);
            height = this.fw / ((float) rect.height());
            float f = 0.0f;
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, f, (float) rect.bottom, new int[]{a.h(this.fx, this.fC), a.h(this.fy, this.fC), a.h(a.i(this.fy, 0), this.fC), a.h(a.i(this.fA, 0), this.fC), a.h(this.fA, this.fC), a.h(this.fz, this.fC)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP));
            this.fD = false;
        }
        height = this.ft.getStrokeWidth() / 2.0f;
        RectF rectF = this.fv;
        copyBounds(this.fu);
        rectF.set(this.fu);
        rectF.left += height;
        rectF.top += height;
        rectF.right -= height;
        rectF.bottom -= height;
        canvas.save();
        canvas.rotate(this.fE, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.ft);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.fw);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.ft.setAlpha(i);
        invalidateSelf();
    }

    final void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.fC = colorStateList.getColorForState(getState(), this.fC);
        }
        this.fB = colorStateList;
        this.fD = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.ft.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.fw > 0.0f ? -3 : -2;
    }

    protected void onBoundsChange(Rect rect) {
        this.fD = true;
    }

    public boolean isStateful() {
        return (this.fB != null && this.fB.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.fB != null) {
            int colorForState = this.fB.getColorForState(iArr, this.fC);
            if (colorForState != this.fC) {
                this.fD = true;
                this.fC = colorForState;
            }
        }
        if (this.fD) {
            invalidateSelf();
        }
        return this.fD;
    }
}
