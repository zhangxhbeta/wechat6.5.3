package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class r {
    WeakReference<View> fg;
    a jA = null;
    Animation jB = null;
    private AnimationListener jC = new AnimationListener(this) {
        final /* synthetic */ r jD;

        {
            this.jD = r1;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.jD.jB == animation) {
                this.jD.jB = null;
            }
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    };
    final ArrayList<a> jz = new ArrayList();

    static class a {
        final int[] jE;
        final Animation mAnimation;

        private a(int[] iArr, Animation animation) {
            this.jE = iArr;
            this.mAnimation = animation;
        }
    }

    r() {
    }

    public final void a(int[] iArr, Animation animation) {
        a aVar = new a(iArr, animation);
        animation.setAnimationListener(this.jC);
        this.jz.add(aVar);
    }

    final View ar() {
        return this.fg == null ? null : (View) this.fg.get();
    }
}
