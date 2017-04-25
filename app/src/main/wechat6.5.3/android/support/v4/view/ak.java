package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class ak {

    static class AnonymousClass1 implements AnimatorUpdateListener {
        final /* synthetic */ View yO;
        final /* synthetic */ an yP;

        AnonymousClass1(an anVar, View view) {
            this.yP = anVar;
            this.yO = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.yP.cc();
        }
    }
}
