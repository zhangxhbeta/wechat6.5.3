package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.w;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.EditText;

public class AppCompatEditText extends EditText implements w {
    private h Ts;
    private f Tt;
    private l Tu;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(am.o(context), attributeSet, i);
        this.Ts = h.eD();
        this.Tt = new f(this, this.Ts);
        this.Tt.a(attributeSet, i);
        this.Tu = l.d(this);
        this.Tu.a(attributeSet, i);
        this.Tu.eF();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Tt != null) {
            this.Tt.aI(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Tt != null) {
            this.Tt.g(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (this.Tt != null) {
            this.Tt.e(colorStateList);
        }
    }

    public final ColorStateList bO() {
        return this.Tt != null ? this.Tt.bO() : null;
    }

    public final void b(Mode mode) {
        if (this.Tt != null) {
            this.Tt.b(mode);
        }
    }

    public final Mode bP() {
        return this.Tt != null ? this.Tt.bP() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Tt != null) {
            this.Tt.eA();
        }
        if (this.Tu != null) {
            this.Tu.eF();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Tu != null) {
            this.Tu.g(context, i);
        }
    }
}
