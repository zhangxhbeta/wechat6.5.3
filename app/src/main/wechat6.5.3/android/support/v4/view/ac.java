package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ac {
    private static ThreadLocal<Rect> xr;

    static class AnonymousClass1 implements OnApplyWindowInsetsListener {
        final /* synthetic */ s xs;

        AnonymousClass1(s sVar) {
            this.xs = sVar;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return ((ap) this.xs.a(view, new ap(windowInsets))).yQ;
        }
    }

    static Rect bR() {
        if (xr == null) {
            xr = new ThreadLocal();
        }
        Rect rect = (Rect) xr.get();
        if (rect == null) {
            rect = new Rect();
            xr.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
