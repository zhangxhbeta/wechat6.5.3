package com.tencent.mm.plugin.sns.lucky.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static n cw(String str, String str2) {
        int argb = Color.argb(51, 255, 255, 255);
        n zQ = i.zQ(str);
        if (zQ != null) {
            return a(zQ.wm(), str2, argb, 55);
        }
        v.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
        return null;
    }

    public static n a(Bitmap bitmap, String str, int i, int i2) {
        n f = n.f(d.c(bitmap, i2));
        if (f == null) {
            v.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
        }
        if (f != null) {
            new Canvas(f.wm()).drawColor(i);
        }
        try {
            d.a(f.wm(), 70, CompressFormat.JPEG, str, false);
        } catch (Throwable e) {
            v.e("MicroMsg.BlurHelper", "error for exception " + e.getMessage());
            v.a("MicroMsg.BlurHelper", e, "", new Object[0]);
        }
        v.i("MicroMsg.BlurHelper", "blur done bitmap  " + f);
        return f;
    }
}
