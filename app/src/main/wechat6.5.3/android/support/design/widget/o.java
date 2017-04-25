package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.a.c;
import android.support.v7.c.a.a;

final class o extends a {
    static final double iR = Math.cos(Math.toRadians(45.0d));
    float fE;
    final Paint iS;
    final Paint iT;
    final RectF iU;
    float iV;
    Path iW;
    float iX;
    float iY;
    float iZ;
    float ja;
    private boolean jb = true;
    private final int jc;
    private final int jd;
    private final int je;
    boolean jf = true;
    private boolean jg = false;

    public o(Resources resources, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.jc = resources.getColor(c.aa);
        this.jd = resources.getColor(c.Z);
        this.je = resources.getColor(c.Y);
        this.iS = new Paint(5);
        this.iS.setStyle(Style.FILL);
        this.iV = (float) Math.round(f);
        this.iU = new RectF();
        this.iT = new Paint(this.iS);
        this.iT.setAntiAlias(false);
        d(f2, f3);
    }

    private static int k(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public final void setAlpha(int i) {
        super.setAlpha(i);
        this.iS.setAlpha(i);
        this.iT.setAlpha(i);
    }

    protected final void onBoundsChange(Rect rect) {
        this.jb = true;
    }

    final void d(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float k = (float) k(f);
        float k2 = (float) k(f2);
        if (k > k2) {
            if (!this.jg) {
                this.jg = true;
            }
            k = k2;
        }
        if (this.ja != k || this.iY != k2) {
            this.ja = k;
            this.iY = k2;
            this.iZ = (float) Math.round(k * 1.5f);
            this.iX = k2;
            this.jb = true;
            invalidateSelf();
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.iY, this.iV, this.jf));
        int ceil2 = (int) Math.ceil((double) b(this.iY, this.iV, this.jf));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - iR) * ((double) f2)));
        }
        return 1.5f * f;
    }

    public static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - iR) * ((double) f2)));
        }
        return f;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        if (this.jb) {
            Rect bounds = getBounds();
            float f2 = this.iY * 1.5f;
            this.iU.set(((float) bounds.left) + this.iY, ((float) bounds.top) + f2, ((float) bounds.right) - this.iY, ((float) bounds.bottom) - f2);
            this.mDrawable.setBounds((int) this.iU.left, (int) this.iU.top, (int) this.iU.right, (int) this.iU.bottom);
            RectF rectF = new RectF(-this.iV, -this.iV, this.iV, this.iV);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.iZ, -this.iZ);
            if (this.iW == null) {
                this.iW = new Path();
            } else {
                this.iW.reset();
            }
            this.iW.setFillType(FillType.EVEN_ODD);
            this.iW.moveTo(-this.iV, 0.0f);
            this.iW.rLineTo(-this.iZ, 0.0f);
            this.iW.arcTo(rectF2, 180.0f, 90.0f, false);
            this.iW.arcTo(rectF, 270.0f, -90.0f, false);
            this.iW.close();
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.iV / f3;
                f = f4 + ((1.0f - f4) / 2.0f);
                this.iS.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.jc, this.jd, this.je}, new float[]{0.0f, f4, f, 1.0f}, TileMode.CLAMP));
            }
            this.iT.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.jc, this.jd, this.je}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.iT.setAntiAlias(false);
            this.jb = false;
        }
        int save = canvas.save();
        canvas.rotate(this.fE, this.iU.centerX(), this.iU.centerY());
        float f5 = (-this.iV) - this.iZ;
        f = this.iV;
        Object obj = this.iU.width() - (2.0f * f) > 0.0f ? 1 : null;
        Object obj2 = this.iU.height() - (2.0f * f) > 0.0f ? 1 : null;
        float f6 = f / ((this.ja - (this.ja * 0.5f)) + f);
        float f7 = f / ((this.ja - (this.ja * 0.25f)) + f);
        float f8 = f / (f + (this.ja - (this.ja * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.iU.left + f, this.iU.top + f);
        canvas.scale(f6, f7);
        canvas.drawPath(this.iW, this.iS);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.iU.width() - (2.0f * f), -this.iV, this.iT);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.iU.right - f, this.iU.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(180.0f);
        canvas.drawPath(this.iW, this.iS);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.iU.width() - (2.0f * f), this.iZ + (-this.iV), this.iT);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.iU.left + f, this.iU.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(270.0f);
        canvas.drawPath(this.iW, this.iS);
        if (obj2 != null) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.iU.height() - (2.0f * f), -this.iV, this.iT);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.iU.right - f, this.iU.top + f);
        canvas.scale(f6, f7);
        canvas.rotate(90.0f);
        canvas.drawPath(this.iW, this.iS);
        if (obj2 != null) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f5, this.iU.height() - (2.0f * f), -this.iV, this.iT);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
        super.draw(canvas);
    }
}
