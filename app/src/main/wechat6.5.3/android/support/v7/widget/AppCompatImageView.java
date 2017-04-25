package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements w {
    private f Tt;
    private i hS;

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(am.o(context), attributeSet, i);
        h eD = h.eD();
        this.Tt = new f(this, eD);
        this.Tt.a(attributeSet, i);
        this.hS = new i(this, eD);
        this.hS.a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.hS.setImageResource(i);
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
    }
}
