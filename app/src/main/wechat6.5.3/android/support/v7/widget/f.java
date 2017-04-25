package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.y;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;

final class f {
    private final h Ts;
    private an Tv;
    private an Tw;
    private an Tx;
    private final View mView;

    f(View view, h hVar) {
        this.mView = view;
        this.Ts = hVar;
    }

    final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, k.dE, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.Nc)) {
                ColorStateList e = this.Ts.e(this.mView.getContext(), obtainStyledAttributes.getResourceId(k.Nc, -1));
                if (e != null) {
                    g(e);
                }
            }
            if (obtainStyledAttributes.hasValue(k.Nd)) {
                y.a(this.mView, obtainStyledAttributes.getColorStateList(k.Nd));
            }
            if (obtainStyledAttributes.hasValue(k.Ne)) {
                y.a(this.mView, w.aO(obtainStyledAttributes.getInt(k.Ne, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void aI(int i) {
        g(this.Ts != null ? this.Ts.e(this.mView.getContext(), i) : null);
    }

    final void e(ColorStateList colorStateList) {
        if (this.Tw == null) {
            this.Tw = new an();
        }
        this.Tw.adI = colorStateList;
        this.Tw.adK = true;
        eA();
    }

    final ColorStateList bO() {
        return this.Tw != null ? this.Tw.adI : null;
    }

    final void b(Mode mode) {
        if (this.Tw == null) {
            this.Tw = new an();
        }
        this.Tw.nk = mode;
        this.Tw.adJ = true;
        eA();
    }

    final Mode bP() {
        return this.Tw != null ? this.Tw.nk : null;
    }

    final void eA() {
        Drawable background = this.mView.getBackground();
        if (background == null) {
            return;
        }
        if (this.Tw != null) {
            h.a(background, this.Tw, this.mView.getDrawableState());
        } else if (this.Tv != null) {
            h.a(background, this.Tv, this.mView.getDrawableState());
        } else {
            boolean z;
            if (VERSION.SDK_INT == 21 && (background instanceof GradientDrawable)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.Tx == null) {
                    this.Tx = new an();
                }
                an anVar = this.Tx;
                anVar.adI = null;
                anVar.adK = false;
                anVar.nk = null;
                anVar.adJ = false;
                ColorStateList ae = y.ae(this.mView);
                if (ae != null) {
                    anVar.adK = true;
                    anVar.adI = ae;
                }
                Mode af = y.af(this.mView);
                if (af != null) {
                    anVar.adJ = true;
                    anVar.nk = af;
                }
                if (anVar.adK || anVar.adJ) {
                    h.a(background, anVar, this.mView.getDrawableState());
                }
            }
        }
    }

    final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.Tv == null) {
                this.Tv = new an();
            }
            this.Tv.adI = colorStateList;
            this.Tv.adK = true;
        } else {
            this.Tv = null;
        }
        eA();
    }
}
