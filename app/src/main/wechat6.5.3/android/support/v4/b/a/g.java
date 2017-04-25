package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class g extends f {

    private static class a extends a {
        a(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new g(this, resources);
        }
    }

    g(Drawable drawable) {
        super(drawable);
    }

    g(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.mDrawable.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    a bt() {
        return new a(this.tA);
    }
}
