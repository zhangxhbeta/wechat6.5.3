package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.support.v4.view.ai.AnonymousClass1;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ah {
    public static final g yH;
    public WeakReference<View> yD;
    private Runnable yE = null;
    private Runnable yF = null;
    private int yG = -1;

    interface g {
        void a(ah ahVar, View view);

        void a(ah ahVar, View view, float f);

        void a(ah ahVar, View view, al alVar);

        void a(View view, long j);

        void a(View view, an anVar);

        void a(View view, Interpolator interpolator);

        long aq(View view);

        void b(ah ahVar, View view);

        void b(ah ahVar, View view, float f);

        void b(View view, long j);

        void c(ah ahVar, View view, float f);
    }

    static class a implements g {
        WeakHashMap<View, Runnable> yI = null;

        class a implements Runnable {
            WeakReference<View> fg;
            ah yJ;
            final /* synthetic */ a yK;

            private a(a aVar, ah ahVar, View view) {
                this.yK = aVar;
                this.fg = new WeakReference(view);
                this.yJ = ahVar;
            }

            public final void run() {
                View view = (View) this.fg.get();
                if (view != null) {
                    this.yK.c(this.yJ, view);
                }
            }
        }

        a() {
        }

        public void a(View view, long j) {
        }

        public void a(ah ahVar, View view, float f) {
            d(ahVar, view);
        }

        public void b(ah ahVar, View view, float f) {
            d(ahVar, view);
        }

        public void c(ah ahVar, View view, float f) {
            d(ahVar, view);
        }

        public long aq(View view) {
            return 0;
        }

        public void a(View view, Interpolator interpolator) {
        }

        public void b(View view, long j) {
        }

        public void a(ah ahVar, View view) {
            d(ahVar, view);
        }

        public void b(ah ahVar, View view) {
            if (this.yI != null) {
                Runnable runnable = (Runnable) this.yI.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
            c(ahVar, view);
        }

        public void a(ah ahVar, View view, al alVar) {
            view.setTag(2113929216, alVar);
        }

        public void a(View view, an anVar) {
        }

        final void c(ah ahVar, View view) {
            al alVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof al) {
                alVar = (al) tag;
            } else {
                alVar = null;
            }
            Runnable c = ahVar.yE;
            Runnable d = ahVar.yF;
            ahVar.yE = null;
            ahVar.yF = null;
            if (c != null) {
                c.run();
            }
            if (alVar != null) {
                alVar.p(view);
                alVar.q(view);
            }
            if (d != null) {
                d.run();
            }
            if (this.yI != null) {
                this.yI.remove(view);
            }
        }

        private void d(ah ahVar, View view) {
            Runnable runnable = null;
            if (this.yI != null) {
                runnable = (Runnable) this.yI.get(view);
            }
            if (runnable == null) {
                runnable = new a(ahVar, view);
                if (this.yI == null) {
                    this.yI = new WeakHashMap();
                }
                this.yI.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    static class b extends a {
        WeakHashMap<View, Integer> yL = null;

        static class a implements al {
            ah yJ;
            boolean yM;

            a(ah ahVar) {
                this.yJ = ahVar;
            }

            public final void p(View view) {
                al alVar;
                this.yM = false;
                if (this.yJ.yG >= 0) {
                    y.a(view, 2, null);
                }
                if (this.yJ.yE != null) {
                    Runnable c = this.yJ.yE;
                    this.yJ.yE = null;
                    c.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof al) {
                    alVar = (al) tag;
                } else {
                    alVar = null;
                }
                if (alVar != null) {
                    alVar.p(view);
                }
            }

            public final void q(View view) {
                if (this.yJ.yG >= 0) {
                    y.a(view, this.yJ.yG, null);
                    this.yJ.yG = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.yM) {
                    al alVar;
                    if (this.yJ.yF != null) {
                        Runnable d = this.yJ.yF;
                        this.yJ.yF = null;
                        d.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof al) {
                        alVar = (al) tag;
                    } else {
                        alVar = null;
                    }
                    if (alVar != null) {
                        alVar.q(view);
                    }
                    this.yM = true;
                }
            }

            public final void ar(View view) {
                al alVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof al) {
                    alVar = (al) tag;
                } else {
                    alVar = null;
                }
                if (alVar != null) {
                    alVar.ar(view);
                }
            }
        }

        b() {
        }

        public final void a(View view, long j) {
            view.animate().setDuration(j);
        }

        public final void a(ah ahVar, View view, float f) {
            view.animate().alpha(f);
        }

        public final void b(ah ahVar, View view, float f) {
            view.animate().translationX(f);
        }

        public final void c(ah ahVar, View view, float f) {
            view.animate().translationY(f);
        }

        public final long aq(View view) {
            return view.animate().getDuration();
        }

        public final void a(View view, Interpolator interpolator) {
            view.animate().setInterpolator(interpolator);
        }

        public final void b(View view, long j) {
            view.animate().setStartDelay(j);
        }

        public final void a(ah ahVar, View view) {
            view.animate().cancel();
        }

        public final void b(ah ahVar, View view) {
            view.animate().start();
        }

        public void a(ah ahVar, View view, al alVar) {
            view.setTag(2113929216, alVar);
            view.animate().setListener(new AnonymousClass1(new a(ahVar), view));
        }
    }

    static class d extends b {
        d() {
        }

        public final void a(ah ahVar, View view, al alVar) {
            if (alVar != null) {
                view.animate().setListener(new aj.AnonymousClass1(alVar, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    static class c extends d {
        c() {
        }
    }

    static class e extends c {
        e() {
        }

        public final void a(View view, an anVar) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (anVar != null) {
                animatorUpdateListener = new ak.AnonymousClass1(anVar, view);
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
    }

    static class f extends e {
        f() {
        }
    }

    ah(View view) {
        this.yD = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            yH = new f();
        } else if (i >= 19) {
            yH = new e();
        } else if (i >= 18) {
            yH = new c();
        } else if (i >= 16) {
            yH = new d();
        } else if (i >= 14) {
            yH = new b();
        } else {
            yH = new a();
        }
    }

    public final ah c(long j) {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.a(view, j);
        }
        return this;
    }

    public final ah p(float f) {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.a(this, view, f);
        }
        return this;
    }

    public final ah q(float f) {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.b(this, view, f);
        }
        return this;
    }

    public final ah r(float f) {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.c(this, view, f);
        }
        return this;
    }

    public final ah b(Interpolator interpolator) {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.a(view, interpolator);
        }
        return this;
    }

    public final ah d(long j) {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.b(view, j);
        }
        return this;
    }

    public final void cancel() {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.a(this, view);
        }
    }

    public final void start() {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.b(this, view);
        }
    }

    public final ah a(al alVar) {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.a(this, view, alVar);
        }
        return this;
    }

    public final ah a(an anVar) {
        View view = (View) this.yD.get();
        if (view != null) {
            yH.a(view, anVar);
        }
        return this;
    }
}
