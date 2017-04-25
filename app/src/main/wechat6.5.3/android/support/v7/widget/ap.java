package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public final class ap {
    public final TypedArray adM;
    private final Context mContext;

    public static ap a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ap(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ap a(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new ap(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    private ap(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.adM = typedArray;
    }

    public final Drawable getDrawable(int i) {
        if (this.adM.hasValue(i)) {
            int resourceId = this.adM.getResourceId(i, 0);
            if (resourceId != 0) {
                return h.eD().a(this.mContext, resourceId, false);
            }
        }
        return this.adM.getDrawable(i);
    }

    public final Drawable by(int i) {
        if (this.adM.hasValue(i)) {
            int resourceId = this.adM.getResourceId(i, 0);
            if (resourceId != 0) {
                return h.eD().a(this.mContext, resourceId, true);
            }
        }
        return null;
    }

    public final CharSequence getText(int i) {
        return this.adM.getText(i);
    }

    public final boolean getBoolean(int i, boolean z) {
        return this.adM.getBoolean(i, z);
    }

    public final int getInt(int i, int i2) {
        return this.adM.getInt(i, i2);
    }

    public final int bz(int i) {
        return this.adM.getColor(i, -1);
    }

    public final int getDimensionPixelOffset(int i, int i2) {
        return this.adM.getDimensionPixelOffset(i, i2);
    }

    public final int getDimensionPixelSize(int i, int i2) {
        return this.adM.getDimensionPixelSize(i, i2);
    }

    public final int getLayoutDimension(int i, int i2) {
        return this.adM.getLayoutDimension(i, i2);
    }

    public final int getResourceId(int i, int i2) {
        return this.adM.getResourceId(i, i2);
    }

    public final boolean hasValue(int i) {
        return this.adM.hasValue(i);
    }
}
