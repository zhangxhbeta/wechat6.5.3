package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;

final class w extends e {
    final ValueAnimator lx = new ValueAnimator();

    w() {
    }

    public final void start() {
        this.lx.start();
    }

    public final boolean isRunning() {
        return this.lx.isRunning();
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.lx.setInterpolator(interpolator);
    }

    public final void a(final b bVar) {
        this.lx.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ w lz;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                bVar.ay();
            }
        });
    }

    public final void a(final a aVar) {
        this.lx.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ w lz;

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                aVar.onAnimationEnd();
            }

            public final void onAnimationCancel(Animator animator) {
            }
        });
    }

    public final void e(int i, int i2) {
        this.lx.setIntValues(new int[]{i, i2});
    }

    public final int aA() {
        return ((Integer) this.lx.getAnimatedValue()).intValue();
    }

    public final void e(float f, float f2) {
        this.lx.setFloatValues(new float[]{f, f2});
    }

    public final float aB() {
        return ((Float) this.lx.getAnimatedValue()).floatValue();
    }

    public final void setDuration(int i) {
        this.lx.setDuration((long) i);
    }

    public final void cancel() {
        this.lx.cancel();
    }

    public final float getAnimatedFraction() {
        return this.lx.getAnimatedFraction();
    }

    public final long getDuration() {
        return this.lx.getDuration();
    }
}
