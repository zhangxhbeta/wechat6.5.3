package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class f extends d {

    private static class a extends a {
        a(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new f(this, resources);
        }
    }

    f(Drawable drawable) {
        super(drawable);
    }

    f(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    a bt() {
        return new a(this.tA);
    }
}
