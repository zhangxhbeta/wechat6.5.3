package android.support.v4.view;

import android.view.WindowInsets;

final class ap extends ao {
    final WindowInsets yQ;

    ap(WindowInsets windowInsets) {
        this.yQ = windowInsets;
    }

    public final int getSystemWindowInsetLeft() {
        return this.yQ.getSystemWindowInsetLeft();
    }

    public final int getSystemWindowInsetTop() {
        return this.yQ.getSystemWindowInsetTop();
    }

    public final int getSystemWindowInsetRight() {
        return this.yQ.getSystemWindowInsetRight();
    }

    public final int getSystemWindowInsetBottom() {
        return this.yQ.getSystemWindowInsetBottom();
    }

    public final boolean isConsumed() {
        return this.yQ.isConsumed();
    }

    public final ao cd() {
        return new ap(this.yQ.consumeSystemWindowInsets());
    }

    public final ao d(int i, int i2, int i3, int i4) {
        return new ap(this.yQ.replaceSystemWindowInsets(i, i2, i3, i4));
    }
}
