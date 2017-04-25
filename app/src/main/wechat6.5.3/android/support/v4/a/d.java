package android.support.v4.a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

final class d implements b {
    private TimeInterpolator nu;

    d() {
    }

    public final void v(View view) {
        if (this.nu == null) {
            this.nu = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.nu);
    }
}
