package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class e extends d {

    private static class a extends a {
        a(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    e(Drawable drawable) {
        super(drawable);
    }

    e(a aVar, Resources resources) {
        super(aVar, resources);
    }

    final a bt() {
        return new a(this.tA);
    }

    protected final Drawable a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }
}
