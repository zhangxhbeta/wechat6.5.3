package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.a;
import android.support.v4.widget.c;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class g {
    private ColorStateList TA = null;
    private Mode TB = null;
    private boolean TC = false;
    private boolean TD = false;
    private boolean TE;
    private final h Ts;
    private final CompoundButton Tz;

    g(CompoundButton compoundButton, h hVar) {
        this.Tz = compoundButton;
        this.Ts = hVar;
    }

    final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.Tz.getContext().obtainStyledAttributes(attributeSet, k.bJ, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.Ld)) {
                int resourceId = obtainStyledAttributes.getResourceId(k.Ld, 0);
                if (resourceId != 0) {
                    this.Tz.setButtonDrawable(this.Ts.a(this.Tz.getContext(), resourceId, false));
                }
            }
            if (obtainStyledAttributes.hasValue(k.Le)) {
                c.a(this.Tz, obtainStyledAttributes.getColorStateList(k.Le));
            }
            if (obtainStyledAttributes.hasValue(k.Lf)) {
                c.a(this.Tz, w.aO(obtainStyledAttributes.getInt(k.Lf, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void f(ColorStateList colorStateList) {
        this.TA = colorStateList;
        this.TC = true;
        eC();
    }

    final void c(Mode mode) {
        this.TB = mode;
        this.TD = true;
        eC();
    }

    final void eB() {
        if (this.TE) {
            this.TE = false;
            return;
        }
        this.TE = true;
        eC();
    }

    private void eC() {
        Drawable a = c.a(this.Tz);
        if (a == null) {
            return;
        }
        if (this.TC || this.TD) {
            a = a.g(a).mutate();
            if (this.TC) {
                a.a(a, this.TA);
            }
            if (this.TD) {
                a.a(a, this.TB);
            }
            if (a.isStateful()) {
                a.setState(this.Tz.getDrawableState());
            }
            this.Tz.setButtonDrawable(a);
        }
    }

    final int aJ(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = c.a(this.Tz);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
