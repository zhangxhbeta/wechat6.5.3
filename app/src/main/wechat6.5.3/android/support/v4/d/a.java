package android.support.v4.d;

import android.os.Build.VERSION;
import java.util.Locale;

public final class a {
    private static final a vc;

    interface a {
        String a(Locale locale);
    }

    static class b implements a {
        b() {
        }

        public final String a(Locale locale) {
            return null;
        }
    }

    static class c implements a {
        c() {
        }

        public final String a(Locale locale) {
            return c.a(locale);
        }
    }

    static class d implements a {
        d() {
        }

        public final String a(Locale locale) {
            return b.a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            vc = new d();
        } else if (i >= 14) {
            vc = new c();
        } else {
            vc = new b();
        }
    }

    public static String a(Locale locale) {
        return vc.a(locale);
    }
}
