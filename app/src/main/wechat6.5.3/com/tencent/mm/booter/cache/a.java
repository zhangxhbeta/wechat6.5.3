package com.tencent.mm.booter.cache;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends com.tencent.mm.cache.b.a {
    public static a bYR;
    private final f<String, Bitmap> bYS;

    private a() {
        Context context = aa.getContext();
        String str = "BACKGROUND_BITMAP_CACHE_LIMIT";
        if (com.tencent.mm.platformtools.a.a.values == null) {
            try {
                com.tencent.mm.platformtools.a.a.values = q.Kb(be.e(context.getAssets().open("profile.ini")));
            } catch (Throwable e) {
                v.e("MicroMsg.ProfileUtil", "exception:%s", be.e(e));
            }
        }
        this.bYS = new f(be.getInt(com.tencent.mm.platformtools.a.a.values == null ? null : (String) com.tencent.mm.platformtools.a.a.values.get(str), 2000));
    }

    public static void prepare() {
        if (bYR == null) {
            bYR = new a();
        }
    }

    public static void destroy() {
        if (bYR != null) {
            bYR.bYS.clear();
        }
    }

    public final Bitmap getBitmap(String str) {
        v.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", str);
        return (Bitmap) this.bYS.get(str);
    }

    public final MCacheItem cZ(String str) {
        v.v("MicroMsg.MMCacheImpl", "getting cache item: %s", str);
        return null;
    }

    public final void a(String str, Bitmap bitmap) {
        v.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", str);
        this.bYS.k(str, bitmap);
    }

    public final void da(String str) {
        v.v("MicroMsg.MMCacheImpl", "setting cache item: %s", str);
    }
}
