package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i {
    private static final c Bz;
    private Object By;

    interface c {
        boolean H(Object obj);

        void I(Object obj);

        boolean J(Object obj);

        void a(Object obj, int i, int i2);

        boolean a(Object obj, float f);

        boolean a(Object obj, float f, float f2);

        boolean a(Object obj, Canvas canvas);

        Object l(Context context);

        boolean l(Object obj, int i);
    }

    static class a implements c {
        a() {
        }

        public final Object l(Context context) {
            return null;
        }

        public final void a(Object obj, int i, int i2) {
        }

        public final boolean H(Object obj) {
            return true;
        }

        public final void I(Object obj) {
        }

        public final boolean a(Object obj, float f) {
            return false;
        }

        public final boolean J(Object obj) {
            return false;
        }

        public final boolean l(Object obj, int i) {
            return false;
        }

        public final boolean a(Object obj, Canvas canvas) {
            return false;
        }

        public final boolean a(Object obj, float f, float f2) {
            return false;
        }
    }

    static class b implements c {
        b() {
        }

        public final Object l(Context context) {
            return new EdgeEffect(context);
        }

        public final void a(Object obj, int i, int i2) {
            ((EdgeEffect) obj).setSize(i, i2);
        }

        public final boolean H(Object obj) {
            return ((EdgeEffect) obj).isFinished();
        }

        public final void I(Object obj) {
            ((EdgeEffect) obj).finish();
        }

        public final boolean a(Object obj, float f) {
            return j.a(obj, f);
        }

        public final boolean J(Object obj) {
            EdgeEffect edgeEffect = (EdgeEffect) obj;
            edgeEffect.onRelease();
            return edgeEffect.isFinished();
        }

        public final boolean l(Object obj, int i) {
            ((EdgeEffect) obj).onAbsorb(i);
            return true;
        }

        public final boolean a(Object obj, Canvas canvas) {
            return ((EdgeEffect) obj).draw(canvas);
        }

        public boolean a(Object obj, float f, float f2) {
            return j.a(obj, f);
        }
    }

    static class d extends b {
        d() {
        }

        public final boolean a(Object obj, float f, float f2) {
            ((EdgeEffect) obj).onPull(f, f2);
            return true;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            Bz = new d();
        } else if (VERSION.SDK_INT >= 14) {
            Bz = new b();
        } else {
            Bz = new a();
        }
    }

    public i(Context context) {
        this.By = Bz.l(context);
    }

    public final void setSize(int i, int i2) {
        Bz.a(this.By, i, i2);
    }

    public final boolean isFinished() {
        return Bz.H(this.By);
    }

    public final void finish() {
        Bz.I(this.By);
    }

    public final boolean t(float f) {
        return Bz.a(this.By, f);
    }

    public final boolean h(float f, float f2) {
        return Bz.a(this.By, f, f2);
    }

    public final boolean cv() {
        return Bz.J(this.By);
    }

    public final boolean ah(int i) {
        return Bz.l(this.By, i);
    }

    public final boolean draw(Canvas canvas) {
        return Bz.a(this.By, canvas);
    }
}
