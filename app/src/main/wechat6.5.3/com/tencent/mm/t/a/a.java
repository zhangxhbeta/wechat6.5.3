package com.tencent.mm.t.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.k;
import com.tencent.mm.sdk.platformtools.aa;
import java.lang.ref.WeakReference;

public enum a {
    ;
    
    private static volatile WeakReference<Bitmap> cxj;

    public static Drawable AK() {
        if (cxj == null || cxj.get() == null || ((Bitmap) cxj.get()).isRecycled()) {
            cxj = new WeakReference(com.tencent.mm.compatible.f.a.decodeResource(aa.getResources(), 2131165440));
        }
        Drawable a = k.a(aa.getResources(), (Bitmap) cxj.get());
        a.AM();
        return a;
    }
}
