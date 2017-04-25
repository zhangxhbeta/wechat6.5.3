package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class ae extends Drawable {
    float aaC;
    private final RectF aaD;
    private final Rect aaE;
    float aaF;
    boolean aaG = false;
    boolean aaH = true;
    final Paint ft;
    private PorterDuffColorFilter ml;
    private ColorStateList nj;
    private Mode nk;

    public ae(int i, float f) {
        this.aaC = f;
        this.ft = new Paint(5);
        this.ft.setColor(i);
        this.aaD = new RectF();
        this.aaE = new Rect();
    }

    public final void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.ft;
        if (this.ml == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.ml);
            obj = 1;
        }
        canvas.drawRoundRect(this.aaD, this.aaC, this.aaC, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    final void f(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.aaD.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.aaE.set(rect);
        if (this.aaG) {
            float a = af.a(this.aaF, this.aaC, this.aaH);
            this.aaE.inset((int) Math.ceil((double) af.b(this.aaF, this.aaC, this.aaH)), (int) Math.ceil((double) a));
            this.aaD.set(this.aaE);
        }
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        f(rect);
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.aaE, this.aaC);
    }

    public final void setAlpha(int i) {
        this.ft.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.ft.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.nj = colorStateList;
        this.ml = b(this.nj, this.nk);
        invalidateSelf();
    }

    public final void setTintMode(Mode mode) {
        this.nk = mode;
        this.ml = b(this.nj, this.nk);
        invalidateSelf();
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.nj == null || this.nk == null) {
            return false;
        }
        this.ml = b(this.nj, this.nk);
        return true;
    }

    public final boolean isStateful() {
        return (this.nj != null && this.nj.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter b(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
