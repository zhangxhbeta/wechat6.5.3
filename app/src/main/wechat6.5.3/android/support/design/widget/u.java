package android.support.design.widget;

import android.view.animation.Interpolator;

final class u {
    final e lk;

    interface a {
        void au();
    }

    interface c {
        void a(u uVar);
    }

    interface d {
        u az();
    }

    static abstract class e {

        interface a {
            void onAnimationEnd();
        }

        interface b {
            void ay();
        }

        abstract void a(a aVar);

        abstract void a(b bVar);

        abstract int aA();

        abstract float aB();

        abstract void cancel();

        abstract void e(float f, float f2);

        abstract void e(int i, int i2);

        abstract float getAnimatedFraction();

        abstract long getDuration();

        abstract boolean isRunning();

        abstract void setDuration(int i);

        abstract void setInterpolator(Interpolator interpolator);

        abstract void start();

        e() {
        }
    }

    class AnonymousClass2 implements a {
        final /* synthetic */ u lm;
        final /* synthetic */ a ln;

        AnonymousClass2(u uVar, a aVar) {
            this.lm = uVar;
            this.ln = aVar;
        }

        public final void onAnimationEnd() {
            this.ln.au();
        }
    }

    static class b implements a {
        b() {
        }

        public void au() {
        }
    }

    u(e eVar) {
        this.lk = eVar;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.lk.setInterpolator(interpolator);
    }

    public final void a(final c cVar) {
        this.lk.a(new b(this) {
            final /* synthetic */ u lm;

            public final void ay() {
                cVar.a(this.lm);
            }
        });
    }

    public final void e(int i, int i2) {
        this.lk.e(i, i2);
    }

    public final void e(float f, float f2) {
        this.lk.e(f, f2);
    }

    public final void setDuration(int i) {
        this.lk.setDuration(i);
    }
}
