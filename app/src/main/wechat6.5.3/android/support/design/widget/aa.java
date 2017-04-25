package android.support.design.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;

final class aa {
    static final d lM = new d() {
        public final u az() {
            return new u(VERSION.SDK_INT >= 12 ? new w() : new v());
        }
    };
    private static final a lN;

    private interface a {
        void u(View view);
    }

    private static class b implements a {
        private b() {
        }

        public final void u(View view) {
        }
    }

    private static class c implements a {
        private c() {
        }

        public final void u(View view) {
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            lN = new c();
        } else {
            lN = new b();
        }
    }

    static void u(View view) {
        lN.u(view);
    }

    static u az() {
        return lM.az();
    }
}
