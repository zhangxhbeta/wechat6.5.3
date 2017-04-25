package android.support.v4.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

final class c {
    private static Method vd;
    private static Method ve;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                ve = cls.getMethod("getScript", new Class[]{String.class});
                vd = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e) {
            ve = null;
            vd = null;
        }
    }

    public static String a(Locale locale) {
        String b = b(locale);
        if (b != null) {
            return m(b);
        }
        return null;
    }

    private static String m(String str) {
        try {
            if (ve != null) {
                return (String) ve.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (vd != null) {
                return (String) vd.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return locale2;
    }
}
