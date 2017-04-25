package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.b.a;
import android.util.TypedValue;

final class al {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = new int[]{16842908};
    static final int[] PRESSED_STATE_SET = new int[]{16842919};
    static final int[] SELECTED_STATE_SET = new int[]{16842913};
    private static final ThreadLocal<TypedValue> adD = new ThreadLocal();
    static final int[] adE = new int[]{16843518};
    static final int[] adF = new int[]{-16842919, -16842908};
    private static final int[] adG = new int[1];
    static final int[] dM = new int[]{16842912};
    static final int[] iJ = new int[]{-16842910};

    public static int h(Context context, int i) {
        adG[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, adG);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList i(Context context, int i) {
        adG[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, adG);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int j(Context context, int i) {
        ColorStateList i2 = i(context, i);
        if (i2 != null && i2.isStateful()) {
            return i2.getColorForState(iJ, i2.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) adD.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            adD.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return a(context, i, typedValue.getFloat());
    }

    static int a(Context context, int i, float f) {
        int h = h(context, i);
        return a.i(h, Math.round(((float) Color.alpha(h)) * f));
    }
}
