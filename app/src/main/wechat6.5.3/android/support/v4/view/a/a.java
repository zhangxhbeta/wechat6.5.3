package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class a {
    private static final d yR;

    interface d {
        void a(AccessibilityEvent accessibilityEvent, int i);

        int b(AccessibilityEvent accessibilityEvent);
    }

    static class c implements d {
        c() {
        }

        public void a(AccessibilityEvent accessibilityEvent, int i) {
        }

        public int b(AccessibilityEvent accessibilityEvent) {
            return 0;
        }
    }

    static class a extends c {
        a() {
        }
    }

    static class b extends a {
        b() {
        }

        public final void a(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }

        public final int b(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            yR = new b();
        } else if (VERSION.SDK_INT >= 14) {
            yR = new a();
        } else {
            yR = new c();
        }
    }

    public static f a(AccessibilityEvent accessibilityEvent) {
        return new f(accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        yR.a(accessibilityEvent, i);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return yR.b(accessibilityEvent);
    }
}
