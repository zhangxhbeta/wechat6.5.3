package com.tencent.mm.ae.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ae.a.c;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public final class a {
    public static Bitmap a(c cVar, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            return d.b(str, i2, i, false);
        }
        if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            return d.JV(str);
        }
        return d.H(str, cVar.width, cVar.height);
    }

    public static Bitmap b(c cVar, String str, int i, int i2) {
        int i3 = 0;
        Options JS = d.JS(str);
        if (JS == null || (JS.outWidth < JS.outHeight * 2 && JS.outWidth * 2 > JS.outHeight)) {
            return d.b(str, i2, i, false);
        }
        if (i > 0 && i2 > 0) {
            return d.b(str, i2, i, true);
        }
        if (cVar != null && cVar.width > 0 && cVar.width > 0) {
            return d.b(str, cVar.height, cVar.width, true);
        }
        int i4;
        if (cVar == null || cVar.AR() == null) {
            v.w("MicroMsg.imageloader.ImageLoaderUtils", "crop bitmap cant not un set width or height");
            i4 = 0;
        } else {
            i4 = cVar.AR().getMeasuredWidth();
            i3 = cVar.AR().getMeasuredHeight();
        }
        return d.b(str, i3, i4, true);
    }

    public static Bitmap a(c cVar, byte[] bArr, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap decodeByteArray;
        if (i > 0 && i2 > 0) {
            decodeByteArray = d.decodeByteArray(bArr, i, i2);
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            decodeByteArray = d.bc(bArr);
        } else {
            decodeByteArray = d.decodeByteArray(bArr, cVar.width, cVar.height);
        }
        if (z) {
            decodeByteArray = d.a(d.decodeByteArray(bArr, i, i2), i, i2, false, true);
        }
        if (f > 0.0f) {
            decodeByteArray = d.c(decodeByteArray, f);
        }
        if (z2) {
            return d.G(decodeByteArray);
        }
        return decodeByteArray;
    }

    public static Bitmap c(c cVar, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            return d.I(str, i, i2);
        }
        if (cVar != null) {
            try {
                if (cVar.width > 0 && cVar.width > 0) {
                    return d.I(str, cVar.width, cVar.height);
                }
            } catch (IOException e) {
                v.e("MicroMsg.imageloader.ImageLoaderUtils", "get bitmap from assert failed. :%s", e.toString());
                return null;
            }
        }
        return d.I(str, 0, 0);
    }

    public static Bitmap a(c cVar, int i, int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            return d.R(i, i2, i3);
        }
        if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            return d.uU(i);
        }
        return d.R(i, cVar.width, cVar.height);
    }
}
