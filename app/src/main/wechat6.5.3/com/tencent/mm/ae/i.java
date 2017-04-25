package com.tencent.mm.ae;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.a;

final class i implements a {
    private f<String, Bitmap> cMO = new f(5);

    i() {
    }

    public final void m(Object obj, Object obj2) {
        this.cMO.k((String) obj, (Bitmap) obj2);
    }

    public final Object get(Object obj) {
        return this.cMO.get((String) obj);
    }

    public final Object remove(Object obj) {
        this.cMO.remove((String) obj);
        return null;
    }
}
