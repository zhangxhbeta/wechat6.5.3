package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class k {
    static final a wm;

    interface a {
        int a(MarginLayoutParams marginLayoutParams);

        int b(MarginLayoutParams marginLayoutParams);
    }

    static class b implements a {
        b() {
        }

        public final int a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public final int b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    static class c implements a {
        c() {
        }

        public final int a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        public final int b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            wm = new c();
        } else {
            wm = new b();
        }
    }

    public static int a(MarginLayoutParams marginLayoutParams) {
        return wm.a(marginLayoutParams);
    }

    public static int b(MarginLayoutParams marginLayoutParams) {
        return wm.b(marginLayoutParams);
    }
}
