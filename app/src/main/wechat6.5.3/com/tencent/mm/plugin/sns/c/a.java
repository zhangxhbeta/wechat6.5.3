package com.tencent.mm.plugin.sns.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static n b(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = l.wk().a(str, options, decodeResultLogger);
            if (a != null) {
                a = i.q(str, a);
            }
            v.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a});
            return n.f(a);
        } catch (OutOfMemoryError e) {
            com.tencent.mm.bh.a.byo();
            v.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }

    public static Bitmap c(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a = l.wk().a(str, options, decodeResultLogger);
            if (a != null) {
                a = i.q(str, a);
            }
            v.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a});
            return a;
        } catch (OutOfMemoryError e) {
            com.tencent.mm.bh.a.byo();
            v.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }
}
