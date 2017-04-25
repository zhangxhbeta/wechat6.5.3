package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class aj {

    static class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ al yN;
        final /* synthetic */ View yO;

        AnonymousClass1(al alVar, View view) {
            this.yN = alVar;
            this.yO = view;
        }

        public final void onAnimationCancel(Animator animator) {
            this.yN.ar(this.yO);
        }

        public final void onAnimationEnd(Animator animator) {
            this.yN.q(this.yO);
        }

        public final void onAnimationStart(Animator animator) {
            this.yN.p(this.yO);
        }
    }
}
