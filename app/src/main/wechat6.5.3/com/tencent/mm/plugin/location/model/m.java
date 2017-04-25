package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.mm.bd.a;
import com.tencent.mm.pluginsdk.j.z;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements z {
    private Bitmap eAm = null;
    x<String, Bitmap> gSS = new x(20);

    public m() {
        try {
            this.eAm = b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null), 0, 0);
            this.eAm = d.a(this.eAm, false, (float) (this.eAm.getWidth() >> 1));
        } catch (Throwable e) {
            v.a("MicroMsg.TrackAvatarCacheService", e, "", new Object[0]);
        }
    }

    public final Bitmap vF(String str) {
        if (be.kS(str)) {
            return null;
        }
        v.d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", new Object[]{str, Integer.valueOf(this.gSS.size())});
        Bitmap bitmap = (Bitmap) this.gSS.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public final void n(String str, Bitmap bitmap) {
        if (this.gSS.get(str) != null) {
            Bitmap bitmap2 = (Bitmap) this.gSS.get(str);
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.gSS.remove(str);
        }
        this.gSS.put(str, bitmap);
        v.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[]{str, Integer.valueOf(this.gSS.size())});
    }
}
