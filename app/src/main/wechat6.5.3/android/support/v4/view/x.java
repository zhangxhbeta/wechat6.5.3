package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class x {
    static final c xh;

    interface c {
        float a(VelocityTracker velocityTracker, int i);

        float b(VelocityTracker velocityTracker, int i);
    }

    static class a implements c {
        a() {
        }

        public final float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public final float b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class b implements c {
        b() {
        }

        public final float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity(i);
        }

        public final float b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            xh = new b();
        } else {
            xh = new a();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return xh.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return xh.b(velocityTracker, i);
    }
}
