package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class d extends Drawable implements Callback, c {
    static final Mode mj = Mode.SRC_IN;
    Drawable mDrawable;
    private boolean mn;
    a tA;
    private int tx;
    private Mode ty;
    private boolean tz;

    protected static abstract class a extends ConstantState {
        int lZ;
        ColorStateList nj = null;
        Mode nk = d.mj;
        ConstantState tB;

        public abstract Drawable newDrawable(Resources resources);

        a(a aVar) {
            if (aVar != null) {
                this.lZ = aVar.lZ;
                this.tB = aVar.tB;
                this.nj = aVar.nj;
                this.nk = aVar.nk;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.tB != null ? this.tB.getChangingConfigurations() : 0) | this.lZ;
        }
    }

    private static class b extends a {
        b(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d(a aVar, Resources resources) {
        this.tA = aVar;
        if (this.tA != null && this.tA.tB != null) {
            j(a(this.tA.tB, resources));
        }
    }

    d(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            this.tA = bt();
        }
        j(drawable);
    }

    protected Drawable a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.mDrawable.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.tA != null ? this.tA.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = bu() ? this.tA.nj : null;
        return (colorStateList != null && colorStateList.isStateful()) || this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return c(iArr) || this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.tA != null) {
            if ((this.tA.tB != null ? 1 : null) != null) {
                this.tA.lZ = getChangingConfigurations();
                return this.tA;
            }
        }
        return null;
    }

    public Drawable mutate() {
        if (!this.mn && super.mutate() == this) {
            this.tA = bt();
            if (this.mDrawable != null) {
                this.mDrawable.mutate();
            }
            if (this.tA != null) {
                this.tA.tB = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
            }
            this.mn = true;
        }
        return this;
    }

    a bt() {
        return new b(this.tA);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.mDrawable.setLevel(i);
    }

    public final void M(int i) {
        d(ColorStateList.valueOf(i));
    }

    public final void d(ColorStateList colorStateList) {
        this.tA.nj = colorStateList;
        c(getState());
    }

    public final void a(Mode mode) {
        this.tA.nk = mode;
        c(getState());
    }

    private boolean c(int[] iArr) {
        if (!bu()) {
            return false;
        }
        ColorStateList colorStateList = this.tA.nj;
        Mode mode = this.tA.nk;
        if (colorStateList == null || mode == null) {
            this.tz = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.tz && colorForState == this.tx && mode == this.ty) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.tx = colorForState;
        this.ty = mode;
        this.tz = true;
        return true;
    }

    public final Drawable bs() {
        return this.mDrawable;
    }

    public final void j(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.tA != null) {
                this.tA.tB = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean bu() {
        return true;
    }
}
