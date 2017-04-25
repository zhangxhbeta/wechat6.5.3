package android.support.v4.b.a;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

final class b {
    static Method tt;
    static boolean tu;
    private static Method tv;
    private static boolean tw;

    public static int i(Drawable drawable) {
        if (!tw) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                tv = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            tw = true;
        }
        if (tv != null) {
            try {
                return ((Integer) tv.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                tv = null;
            }
        }
        return -1;
    }
}
