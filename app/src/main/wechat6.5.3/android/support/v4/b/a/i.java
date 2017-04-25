package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.tencent.smtt.sdk.WebView;

public abstract class i extends Drawable {
    public final Paint ft = new Paint(3);
    public float iV;
    public final Bitmap mBitmap;
    private int tC = 160;
    private int tD = 119;
    public final BitmapShader tE;
    private final Matrix tF = new Matrix();
    final Rect tG = new Rect();
    private final RectF tH = new RectF();
    private boolean tI = true;
    public boolean tJ;
    private int tK;
    private int tL;

    public void setFilterBitmap(boolean z) {
        this.ft.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.ft.setDither(z);
        invalidateSelf();
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    final void bv() {
        if (this.tI) {
            if (this.tJ) {
                int min = Math.min(this.tK, this.tL);
                a(this.tD, min, min, getBounds(), this.tG);
                int min2 = Math.min(this.tG.width(), this.tG.height());
                this.tG.inset(Math.max(0, (this.tG.width() - min2) / 2), Math.max(0, (this.tG.height() - min2) / 2));
                this.iV = ((float) min2) * 0.5f;
            } else {
                a(this.tD, this.tK, this.tL, getBounds(), this.tG);
            }
            this.tH.set(this.tG);
            if (this.tE != null) {
                this.tF.setTranslate(this.tH.left, this.tH.top);
                this.tF.preScale(this.tH.width() / ((float) this.mBitmap.getWidth()), this.tH.height() / ((float) this.mBitmap.getHeight()));
                this.tE.setLocalMatrix(this.tF);
                this.ft.setShader(this.tE);
            }
            this.tI = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bv();
            if (this.ft.getShader() == null) {
                canvas.drawBitmap(bitmap, null, this.tG, this.ft);
            } else {
                canvas.drawRoundRect(this.tH, this.iV, this.iV, this.ft);
            }
        }
    }

    public void setAlpha(int i) {
        if (i != this.ft.getAlpha()) {
            this.ft.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.ft.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.ft.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.ft.getColorFilter();
    }

    public final void AM() {
        this.tJ = true;
        this.tI = true;
        bw();
        this.ft.setShader(this.tE);
        invalidateSelf();
    }

    private void bw() {
        this.iV = (float) (Math.min(this.tL, this.tK) / 2);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.tJ) {
            bw();
        }
        this.tI = true;
    }

    public int getIntrinsicWidth() {
        return this.tK;
    }

    public int getIntrinsicHeight() {
        return this.tL;
    }

    public int getOpacity() {
        if (this.tD != 119 || this.tJ) {
            return -3;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.hasAlpha() || this.ft.getAlpha() < WebView.NORMAL_MODE_ALPHA || n(this.iV)) {
            return -3;
        }
        return -1;
    }

    i(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.tC = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            this.tK = this.mBitmap.getScaledWidth(this.tC);
            this.tL = this.mBitmap.getScaledHeight(this.tC);
            this.tE = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            return;
        }
        this.tL = -1;
        this.tK = -1;
        this.tE = null;
    }

    public static boolean n(float f) {
        return f > 0.05f;
    }
}
