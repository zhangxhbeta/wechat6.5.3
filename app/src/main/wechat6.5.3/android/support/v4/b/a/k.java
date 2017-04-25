package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.e;

public final class k {

    private static class a extends i {
        a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        final void a(int i, int i2, int i3, Rect rect, Rect rect2) {
            e.apply(i, i2, i3, rect, rect2, 0);
        }
    }

    public static i a(Resources resources, Bitmap bitmap) {
        if (VERSION.SDK_INT >= 21) {
            return new j(resources, bitmap);
        }
        return new a(resources, bitmap);
    }
}
