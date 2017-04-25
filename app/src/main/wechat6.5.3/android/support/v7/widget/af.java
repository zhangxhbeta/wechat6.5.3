package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import android.support.v7.b.a.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

final class af extends Drawable {
    static a aaJ;
    static final double iR = Math.cos(Math.toRadians(45.0d));
    final int aaI;
    final RectF aaK;
    Paint ft;
    Paint iS;
    Paint iT;
    float iV;
    Path iW;
    float iX;
    float iY;
    float iZ;
    float ja;
    private boolean jb = true;
    private final int jc;
    private final int je;
    boolean jf = true;
    private boolean jg = false;

    interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    af(Resources resources, int i, float f, float f2, float f3) {
        this.jc = resources.getColor(android.support.v7.b.a.a.Nn);
        this.je = resources.getColor(android.support.v7.b.a.a.Nm);
        this.aaI = resources.getDimensionPixelSize(b.No);
        this.ft = new Paint(5);
        this.ft.setColor(i);
        this.iS = new Paint(5);
        this.iS.setStyle(Style.FILL);
        this.iV = (float) ((int) (0.5f + f));
        this.aaK = new RectF();
        this.iT = new Paint(this.iS);
        this.iT.setAntiAlias(false);
        d(f2, f3);
    }

    private static int k(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public final void setAlpha(int i) {
        this.ft.setAlpha(i);
        this.iS.setAlpha(i);
        this.iT.setAlpha(i);
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.jb = true;
    }

    final void d(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
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
                this.iZ = (float) ((int) (((k * DownloadHelper.SAVE_FATOR) + ((float) this.aaI)) + 0.5f));
                this.iX = ((float) this.aaI) + k2;
                this.jb = true;
                invalidateSelf();
            }
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.iY, this.iV, this.jf));
        int ceil2 = (int) Math.ceil((double) b(this.iY, this.iV, this.jf));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (DownloadHelper.SAVE_FATOR * f)) + ((1.0d - iR) * ((double) f2)));
        }
        return DownloadHelper.SAVE_FATOR * f;
    }

    static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - iR) * ((double) f2)));
        }
        return f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.ft.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        int i;
        int i2 = 1;
        if (this.jb) {
            Rect bounds = getBounds();
            f = this.iY * DownloadHelper.SAVE_FATOR;
            this.aaK.set(((float) bounds.left) + this.iY, ((float) bounds.top) + f, ((float) bounds.right) - this.iY, ((float) bounds.bottom) - f);
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
            f = this.iV / (this.iV + this.iZ);
            float[] fArr = new float[]{0.0f, f, 1.0f};
            f = 0.0f;
            this.iS.setShader(new RadialGradient(0.0f, f, this.iV + this.iZ, new int[]{this.jc, this.jc, this.je}, fArr, TileMode.CLAMP));
            float f2 = 0.0f;
            this.iT.setShader(new LinearGradient(0.0f, (-this.iV) + this.iZ, f2, (-this.iV) - this.iZ, new int[]{this.jc, this.jc, this.je}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.iT.setAntiAlias(false);
            this.jb = false;
        }
        canvas.translate(0.0f, this.ja / 2.0f);
        f = (-this.iV) - this.iZ;
        float f3 = (this.iV + ((float) this.aaI)) + (this.ja / 2.0f);
        if (this.aaK.width() - (2.0f * f3) > 0.0f) {
            i = 1;
        } else {
            boolean z = false;
        }
        if (this.aaK.height() - (2.0f * f3) <= 0.0f) {
            i2 = 0;
        }
        int save = canvas.save();
        canvas.translate(this.aaK.left + f3, this.aaK.top + f3);
        canvas.drawPath(this.iW, this.iS);
        if (i != 0) {
            canvas.drawRect(0.0f, f, this.aaK.width() - (2.0f * f3), -this.iV, this.iT);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.aaK.right - f3, this.aaK.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.iW, this.iS);
        if (i != 0) {
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, f, this.aaK.width() - (2.0f * f3), this.iZ + (-this.iV), this.iT);
        }
        canvas.restoreToCount(save);
        i = canvas.save();
        canvas.translate(this.aaK.left + f3, this.aaK.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.iW, this.iS);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.aaK.height() - (2.0f * f3), -this.iV, this.iT);
        }
        canvas.restoreToCount(i);
        i = canvas.save();
        canvas.translate(this.aaK.right - f3, this.aaK.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.iW, this.iS);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.aaK.height() - (2.0f * f3), -this.iV, this.iT);
        }
        canvas.restoreToCount(i);
        canvas.translate(0.0f, (-this.ja) / 2.0f);
        aaJ.a(canvas, this.aaK, this.iV, this.ft);
    }
}
