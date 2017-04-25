package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.y;

class k extends j {
    private boolean ic;

    k(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
    }

    boolean ac() {
        return true;
    }

    final void ad() {
        float rotation = this.iu.getRotation();
        if (this.ie != null) {
            o oVar = this.ie;
            float f = -rotation;
            if (oVar.fE != f) {
                oVar.fE = f;
                oVar.invalidateSelf();
            }
        }
        if (this.io != null) {
            d dVar = this.io;
            rotation = -rotation;
            if (rotation != dVar.fE) {
                dVar.fE = rotation;
                dVar.invalidateSelf();
            }
        }
    }

    final void a(final a aVar, boolean z) {
        if (!this.ic && this.iu.getVisibility() == 0) {
            if (!y.ai(this.iu) || this.iu.isInEditMode()) {
                this.iu.i(8, false);
                if (aVar == null) {
                    return;
                }
                return;
            }
            this.iu.animate().cancel();
            this.iu.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(a.et).setListener(new AnimatorListenerAdapter(this, false) {
                private boolean ik;
                final /* synthetic */ k il;

                public final void onAnimationStart(Animator animator) {
                    this.il.ic = true;
                    this.ik = false;
                    this.il.iu.i(0, false);
                }

                public final void onAnimationCancel(Animator animator) {
                    this.il.ic = false;
                    this.ik = true;
                }

                public final void onAnimationEnd(Animator animator) {
                    this.il.ic = false;
                    if (!this.ik) {
                        this.il.iu.i(8, false);
                    }
                }
            });
        }
    }

    final void b(final a aVar, boolean z) {
        if (!this.ic && this.iu.getVisibility() == 0) {
            return;
        }
        if (!y.ai(this.iu) || this.iu.isInEditMode()) {
            this.iu.i(0, false);
            this.iu.setAlpha(1.0f);
            this.iu.setScaleY(1.0f);
            this.iu.setScaleX(1.0f);
            return;
        }
        this.iu.animate().cancel();
        if (this.iu.getVisibility() != 0) {
            this.iu.setAlpha(0.0f);
            this.iu.setScaleY(0.0f);
            this.iu.setScaleX(0.0f);
        }
        this.iu.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(a.eu).setListener(new AnimatorListenerAdapter(this, false) {
            final /* synthetic */ k il;

            public final void onAnimationStart(Animator animator) {
                this.il.iu.i(0, false);
            }

            public final void onAnimationEnd(Animator animator) {
            }
        });
    }
}
