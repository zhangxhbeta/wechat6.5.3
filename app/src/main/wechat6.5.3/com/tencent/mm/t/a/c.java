package com.tencent.mm.t.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.WeakReference;

public final class c implements com.tencent.mm.t.a.b.c {
    private static volatile WeakReference<Bitmap> cxG = null;
    public static final c cxH = new c();

    public final Bitmap g(Bitmap bitmap) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return bitmap;
        }
        return d.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
    }

    public final String AP() {
        return "WxaIcon";
    }
}
