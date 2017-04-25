package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.t;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton implements t {
    private h Ts;
    private g Ty;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(am.o(context), attributeSet, i);
        this.Ts = h.eD();
        this.Ty = new g(this, this.Ts);
        this.Ty.a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.Ty != null) {
            this.Ty.eB();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.Ts != null ? this.Ts.a(getContext(), i, false) : android.support.v4.content.a.a(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.Ty != null ? this.Ty.aJ(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public final void f(ColorStateList colorStateList) {
        if (this.Ty != null) {
            this.Ty.f(colorStateList);
        }
    }

    public final void c(Mode mode) {
        if (this.Ty != null) {
            this.Ty.c(mode);
        }
    }
}
