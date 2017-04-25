package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class i {
    private final ImageView TU;
    private final h Ts;

    public i(ImageView imageView, h hVar) {
        this.TU = imageView;
        this.Ts = hVar;
    }

    public final void a(AttributeSet attributeSet, int i) {
        ap a = ap.a(this.TU.getContext(), attributeSet, k.bj, i);
        try {
            Drawable by = a.by(k.KN);
            if (by != null) {
                this.TU.setImageDrawable(by);
            }
            int resourceId = a.getResourceId(k.KO, -1);
            if (resourceId != -1) {
                by = this.Ts.a(this.TU.getContext(), resourceId, false);
                if (by != null) {
                    this.TU.setImageDrawable(by);
                }
            }
            by = this.TU.getDrawable();
            if (by != null) {
                w.n(by);
            }
            a.adM.recycle();
        } catch (Throwable th) {
            a.adM.recycle();
        }
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            Drawable a = this.Ts != null ? this.Ts.a(this.TU.getContext(), i, false) : a.a(this.TU.getContext(), i);
            if (a != null) {
                w.n(a);
            }
            this.TU.setImageDrawable(a);
            return;
        }
        this.TU.setImageDrawable(null);
    }
}
