package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;

class j extends l {
    private int ia;
    private r ib = new r();
    private boolean ic;
    o ie;

    private abstract class a extends Animation {
        final /* synthetic */ j ih;
        private float ii;
        private float ij;

        protected abstract float ab();

        private a(j jVar) {
            this.ih = jVar;
        }

        public void reset() {
            super.reset();
            this.ii = this.ih.ie.ja;
            this.ij = ab() - this.ii;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            o oVar = this.ih.ie;
            oVar.d(this.ii + (this.ij * f), oVar.iY);
        }
    }

    private class b extends a {
        final /* synthetic */ j ih;

        private b(j jVar) {
            this.ih = jVar;
            super();
        }

        protected final float ab() {
            return this.ih.ir + this.ih.is;
        }
    }

    private class c extends a {
        final /* synthetic */ j ih;

        private c(j jVar) {
            this.ih = jVar;
            super();
        }

        protected final float ab() {
            return this.ih.ir;
        }
    }

    j(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.ia = visibilityAwareImageButton.getResources().getInteger(17694720);
        r rVar = this.ib;
        View ar = rVar.ar();
        if (ar != visibilityAwareImageButton) {
            if (ar != null) {
                View ar2 = rVar.ar();
                int size = rVar.jz.size();
                for (int i = 0; i < size; i++) {
                    if (ar2.getAnimation() == ((a) rVar.jz.get(i)).mAnimation) {
                        ar2.clearAnimation();
                    }
                }
                rVar.fg = null;
                rVar.jA = null;
                rVar.jB = null;
            }
            if (visibilityAwareImageButton != null) {
                rVar.fg = new WeakReference(visibilityAwareImageButton);
            }
        }
        this.ib.a(PRESSED_ENABLED_STATE_SET, c(new b()));
        this.ib.a(it, c(new b()));
        this.ib.a(EMPTY_STATE_SET, c(new c()));
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.im = android.support.v4.b.a.a.g(l.ag());
        android.support.v4.b.a.a.a(this.im, colorStateList);
        if (mode != null) {
            android.support.v4.b.a.a.a(this.im, mode);
        }
        this.in = android.support.v4.b.a.a.g(l.ag());
        Drawable drawable = this.in;
        r1 = new int[3][];
        int[] iArr = new int[]{it, i, PRESSED_ENABLED_STATE_SET};
        iArr[1] = i;
        r1[2] = new int[0];
        iArr[2] = 0;
        android.support.v4.b.a.a.a(drawable, new ColorStateList(r1, iArr));
        if (i2 > 0) {
            this.io = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.io, this.im, this.in};
        } else {
            this.io = null;
            drawableArr = new Drawable[]{this.im, this.in};
        }
        this.iq = new LayerDrawable(drawableArr);
        this.ie = new o(this.iu.getResources(), this.iq, this.iv.Y(), this.ir, this.ir + this.is);
        o oVar = this.ie;
        oVar.jf = false;
        oVar.invalidateSelf();
        this.iv.setBackgroundDrawable(this.ie);
    }

    final void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.im != null) {
            android.support.v4.b.a.a.a(this.im, colorStateList);
        }
        if (this.io != null) {
            this.io.c(colorStateList);
        }
    }

    final void setBackgroundTintMode(Mode mode) {
        if (this.im != null) {
            android.support.v4.b.a.a.a(this.im, mode);
        }
    }

    void i(float f) {
        if (this.ie != null) {
            this.ie.d(f, this.is + f);
            ae();
        }
    }

    void j(float f) {
        if (this.ie != null) {
            o oVar = this.ie;
            oVar.d(oVar.ja, this.ir + f);
            ae();
        }
    }

    void b(int[] iArr) {
        a aVar;
        r rVar = this.ib;
        int size = rVar.jz.size();
        for (int i = 0; i < size; i++) {
            a aVar2 = (a) rVar.jz.get(i);
            if (StateSet.stateSetMatches(aVar2.jE, iArr)) {
                aVar = aVar2;
                break;
            }
        }
        aVar = null;
        if (aVar != rVar.jA) {
            View ar;
            if (!(rVar.jA == null || rVar.jB == null)) {
                ar = rVar.ar();
                if (ar != null && ar.getAnimation() == rVar.jB) {
                    ar.clearAnimation();
                }
                rVar.jB = null;
            }
            rVar.jA = aVar;
            ar = (View) rVar.fg.get();
            if (aVar != null && ar != null && ar.getVisibility() == 0) {
                rVar.jB = aVar.mAnimation;
                ar = rVar.ar();
                if (ar != null) {
                    ar.startAnimation(rVar.jB);
                }
            }
        }
    }

    void aa() {
        r rVar = this.ib;
        if (rVar.jB != null) {
            View ar = rVar.ar();
            if (ar != null && ar.getAnimation() == rVar.jB) {
                ar.clearAnimation();
            }
        }
    }

    void a(final a aVar, boolean z) {
        if (!this.ic && this.iu.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.iu.getContext(), android.support.design.a.a.U);
            loadAnimation.setInterpolator(a.et);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new b(this, false) {
                final /* synthetic */ j ih;
            });
            this.iu.startAnimation(loadAnimation);
        }
    }

    void b(final a aVar, boolean z) {
        if (this.iu.getVisibility() != 0 || this.ic) {
            this.iu.clearAnimation();
            this.iu.i(0, false);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.iu.getContext(), android.support.design.a.a.T);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(a.eu);
            loadAnimation.setAnimationListener(new b(this) {
                final /* synthetic */ j ih;
            });
            this.iu.startAnimation(loadAnimation);
        }
    }

    void b(Rect rect) {
        this.ie.getPadding(rect);
    }

    private Animation c(Animation animation) {
        animation.setInterpolator(a.es);
        animation.setDuration((long) this.ia);
        return animation;
    }
}
