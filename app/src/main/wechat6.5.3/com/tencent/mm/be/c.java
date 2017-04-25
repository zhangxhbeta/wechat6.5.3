package com.tencent.mm.be;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.svg.c.b;

public final class c {
    com.tencent.mm.svg.b.a neQ = new com.tencent.mm.svg.b.a();

    public static class a implements com.tencent.mm.compatible.f.a.a {
        com.tencent.mm.svg.b.a neQ = new com.tencent.mm.svg.b.a();

        public final Bitmap decodeResource(Resources resources, int i, Options options) {
            if (!this.neQ.d(resources, i)) {
                return null;
            }
            float f = 0.0f;
            if (options != null) {
                f = ((float) options.inDensity) / 160.0f;
            }
            return com.tencent.mm.svg.b.a.b(resources, i, f);
        }
    }

    static {
        com.tencent.mm.compatible.f.a.a(new a());
        b.iD(aa.getContext().getSharedPreferences("wechat_svg_debug", 4).getBoolean("open_tag", false));
    }

    public final Drawable c(Resources resources, int i) {
        if (this.neQ.d(resources, i)) {
            return com.tencent.mm.svg.b.a.c(resources, i);
        }
        return null;
    }

    public static void iq(boolean z) {
        aa.getContext().getSharedPreferences("wechat_svg_debug", 4).edit().putBoolean("open_tag", z).commit();
        b.iD(z);
    }
}
