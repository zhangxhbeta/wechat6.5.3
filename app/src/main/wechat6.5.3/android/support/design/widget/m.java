package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.b.a.a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
final class m extends k {
    private InsetDrawable iy;
    private final Interpolator mInterpolator;

    m(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.mInterpolator = visibilityAwareImageButton.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.iu.getContext(), 17563661);
    }

    final void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.im = a.g(l.ag());
        a.a(this.im, colorStateList);
        if (mode != null) {
            a.a(this.im, mode);
        }
        if (i2 > 0) {
            this.io = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.io, this.im});
        } else {
            this.io = null;
            layerDrawable = this.im;
        }
        this.in = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.iq = this.in;
        this.iv.setBackgroundDrawable(this.in);
    }

    public final void i(float f) {
        this.iu.setElevation(f);
        if (this.iv.Z()) {
            ae();
        }
    }

    final void j(float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, a(ObjectAnimator.ofFloat(this.iu, "translationZ", new float[]{f})));
        stateListAnimator.addState(it, a(ObjectAnimator.ofFloat(this.iu, "translationZ", new float[]{f})));
        stateListAnimator.addState(EMPTY_STATE_SET, a(ObjectAnimator.ofFloat(this.iu, "translationZ", new float[]{0.0f})));
        this.iu.setStateListAnimator(stateListAnimator);
        if (this.iv.Z()) {
            ae();
        }
    }

    final void c(Rect rect) {
        if (this.iv.Z()) {
            this.iy = new InsetDrawable(this.in, rect.left, rect.top, rect.right, rect.bottom);
            this.iv.setBackgroundDrawable(this.iy);
            return;
        }
        this.iv.setBackgroundDrawable(this.in);
    }

    final void b(int[] iArr) {
    }

    final void aa() {
    }

    final boolean ac() {
        return false;
    }

    private Animator a(Animator animator) {
        animator.setInterpolator(this.mInterpolator);
        return animator;
    }

    final d af() {
        return new e();
    }

    final void b(Rect rect) {
        if (this.iv.Z()) {
            float Y = this.iv.Y();
            float elevation = this.iu.getElevation() + this.is;
            int ceil = (int) Math.ceil((double) o.b(elevation, Y, false));
            int ceil2 = (int) Math.ceil((double) o.a(elevation, Y, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
