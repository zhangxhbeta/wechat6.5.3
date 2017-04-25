package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

public final class g {
    static final a wi;

    interface a {
        j a(LayoutInflater layoutInflater);

        void a(LayoutInflater layoutInflater, j jVar);
    }

    static class b implements a {
        b() {
        }

        public void a(LayoutInflater layoutInflater, j jVar) {
            layoutInflater.setFactory(jVar != null ? new a(jVar) : null);
        }

        public final j a(LayoutInflater layoutInflater) {
            Factory factory = layoutInflater.getFactory();
            return factory instanceof a ? ((a) factory).wj : null;
        }
    }

    static class c extends b {
        c() {
        }

        public void a(LayoutInflater layoutInflater, j jVar) {
            Factory2 aVar = jVar != null ? new a(jVar) : null;
            layoutInflater.setFactory2(aVar);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                i.a(layoutInflater, (Factory2) factory);
            } else {
                i.a(layoutInflater, aVar);
            }
        }
    }

    static class d extends c {
        d() {
        }

        public final void a(LayoutInflater layoutInflater, j jVar) {
            layoutInflater.setFactory2(jVar != null ? new a(jVar) : null);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            wi = new d();
        } else if (i >= 11) {
            wi = new c();
        } else {
            wi = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, j jVar) {
        wi.a(layoutInflater, jVar);
    }

    public static j a(LayoutInflater layoutInflater) {
        return wi.a(layoutInflater);
    }
}
