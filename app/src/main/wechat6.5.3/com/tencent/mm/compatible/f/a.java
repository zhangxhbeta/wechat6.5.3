package com.tencent.mm.compatible.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public final class a extends BitmapFactory {
    private static a cfR = null;

    public interface a {
        Bitmap decodeResource(Resources resources, int i, Options options);
    }

    public static void a(a aVar) {
        cfR = aVar;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        return decodeResource(resources, i, null);
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        if (cfR != null) {
            Bitmap decodeResource = cfR.decodeResource(resources, i, options);
            if (decodeResource != null) {
                return decodeResource;
            }
        }
        return a(resources, i, options);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(android.content.res.Resources r5, int r6, android.graphics.BitmapFactory.Options r7) {
        /*
        r1 = 0;
        com.tencent.mm.sdk.platformtools.d.a(r7);
        r2 = new android.util.TypedValue;	 Catch:{ Exception -> 0x002a, all -> 0x0034 }
        r2.<init>();	 Catch:{ Exception -> 0x002a, all -> 0x0034 }
        r0 = r5.openRawResource(r6, r2);	 Catch:{ Exception -> 0x002a, all -> 0x0034 }
        r3 = 0;
        r1 = decodeResourceStream(r5, r2, r0, r3, r7);	 Catch:{ Exception -> 0x003b, all -> 0x0042 }
    L_0x0012:
        if (r1 != 0) goto L_0x0018;
    L_0x0014:
        r1 = decodeStream(r0);	 Catch:{ Exception -> 0x0047, all -> 0x0042 }
    L_0x0018:
        if (r0 == 0) goto L_0x001d;
    L_0x001a:
        r0.close();	 Catch:{ IOException -> 0x003d }
    L_0x001d:
        if (r1 != 0) goto L_0x0041;
    L_0x001f:
        if (r7 == 0) goto L_0x0041;
    L_0x0021:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Problem decoding into existing bitmap";
        r0.<init>(r1);
        throw r0;
    L_0x002a:
        r0 = move-exception;
        r0 = r1;
    L_0x002c:
        if (r0 == 0) goto L_0x001d;
    L_0x002e:
        r0.close();	 Catch:{ IOException -> 0x0032 }
        goto L_0x001d;
    L_0x0032:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0034:
        r0 = move-exception;
    L_0x0035:
        if (r1 == 0) goto L_0x003a;
    L_0x0037:
        r1.close();	 Catch:{ IOException -> 0x003f }
    L_0x003a:
        throw r0;
    L_0x003b:
        r2 = move-exception;
        goto L_0x0012;
    L_0x003d:
        r0 = move-exception;
        goto L_0x001d;
    L_0x003f:
        r1 = move-exception;
        goto L_0x003a;
    L_0x0041:
        return r1;
    L_0x0042:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0035;
    L_0x0047:
        r2 = move-exception;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.f.a.a(android.content.res.Resources, int, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }
}
