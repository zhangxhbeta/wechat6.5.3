package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class ao extends ad {
    private final WeakReference<Context> adL;

    public ao(Context context, Resources resources) {
        super(resources);
        this.adL = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.adL.get();
        if (!(drawable == null || context == null)) {
            h.eD();
            h.a(context, i, drawable);
        }
        return drawable;
    }
}
