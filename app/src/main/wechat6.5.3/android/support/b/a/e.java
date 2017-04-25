package android.support.b.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.util.AttributeSet;

@TargetApi(21)
abstract class e extends Drawable {
    Drawable mi;

    e() {
    }

    static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.mi != null) {
            this.mi.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.mi != null) {
            return a.f(this.mi);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.mi != null) {
            return this.mi.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mi != null) {
            this.mi.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.mi != null) {
            a.a(this.mi, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.mi != null) {
            a.a(this.mi, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.mi != null) {
            this.mi.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.mi != null) {
            a.b(this.mi);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.mi != null) {
            a.a(this.mi, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.mi != null) {
            a.c(this.mi);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.mi != null) {
            a.a(this.mi, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.mi != null) {
            a.i(this.mi);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.mi != null) {
            this.mi.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.mi != null) {
            return this.mi.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.mi != null) {
            return this.mi.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.mi != null) {
            return this.mi.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.mi != null) {
            return this.mi.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.mi != null) {
            return this.mi.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.mi != null) {
            return this.mi.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.mi != null) {
            this.mi.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.mi != null) {
            return this.mi.setState(iArr);
        }
        return super.setState(iArr);
    }
}
