package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;

final class z {
    private static Field xm;
    private static boolean xn;
    private static Field xo;
    private static boolean xp;

    static int S(View view) {
        if (!xn) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                xm = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            xn = true;
        }
        if (xm != null) {
            try {
                return ((Integer) xm.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int T(View view) {
        if (!xp) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                xo = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            xp = true;
        }
        if (xo != null) {
            try {
                return ((Integer) xo.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
