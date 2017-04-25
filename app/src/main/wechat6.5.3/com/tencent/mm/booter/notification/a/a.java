package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.d;

public final class a {
    public Bitmap bZN;

    public static Bitmap b(Context context, Bitmap bitmap) {
        if (context == null || bitmap == null) {
            return null;
        }
        if (VERSION.SDK_INT < 11) {
            return bitmap;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(17104902) - context.getResources().getDimensionPixelSize(2131493530);
        return d.a(d.a(bitmap, dimensionPixelSize, dimensionPixelSize, false, false), false, (float) context.getResources().getDimensionPixelSize(2131493529));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap u(java.lang.String r12, java.lang.String r13) {
        /*
        r0 = com.tencent.mm.platformtools.t.kS(r12);
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
    L_0x0007:
        return r0;
    L_0x0008:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "user_";
        r2 = r12.getBytes();
        r2 = com.tencent.mm.a.g.m(r2);
        r3 = ".png";
        r4 = 1;
        r1 = com.tencent.mm.sdk.platformtools.h.b(r13, r1, r2, r3, r4);
        r0 = r0.append(r1);
        r1 = ".bm";
        r0 = r0.append(r1);
        r4 = r0.toString();
        r0 = 1;
        r2 = 0;
        r1 = 0;
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r5 = r3.exists();	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        if (r5 != 0) goto L_0x004e;
    L_0x003d:
        r0 = "MicroMsg.NotificationAvatar";
        r3 = "SmallBM get bm file not exsit:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r6 = 0;
        r5[r6] = r4;	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        com.tencent.mm.sdk.platformtools.v.w(r0, r3, r5);	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r0 = 0;
        goto L_0x0007;
    L_0x004e:
        r6 = r3.length();	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r5 = (int) r6;	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        if (r5 <= 0) goto L_0x005f;
    L_0x0055:
        r3 = 36864; // 0x9000 float:5.1657E-41 double:1.8213E-319;
        if (r5 == r3) goto L_0x0077;
    L_0x005a:
        r3 = 36880; // 0x9010 float:5.168E-41 double:1.8221E-319;
        if (r5 == r3) goto L_0x0077;
    L_0x005f:
        r0 = "MicroMsg.NotificationAvatar";
        r3 = "SmallBM get bm invalid size:%d file:%s";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r7 = 0;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r6[r7] = r5;	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r5 = 1;
        r6[r5] = r4;	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        com.tencent.mm.sdk.platformtools.v.e(r0, r3, r6);	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r0 = 0;
        goto L_0x0007;
    L_0x0077:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0170, OutOfMemoryError -> 0x014f }
        r1 = r3.getChannel();	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r2 = 36864; // 0x9000 float:5.1657E-41 double:1.8213E-319;
        r6 = java.nio.ByteBuffer.allocateDirect(r2);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r1.read(r6);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r2 = 0;
        r6.position(r2);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r2 = 36880; // 0x9010 float:5.168E-41 double:1.8221E-319;
        if (r5 != r2) goto L_0x00ce;
    L_0x0093:
        r0 = 16;
        r0 = java.nio.ByteBuffer.allocateDirect(r0);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r1.read(r0);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r2 = 0;
        r8 = r0.getLong(r2);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r10 = 1;
        r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r0 == 0) goto L_0x00cd;
    L_0x00a7:
        r0 = "MicroMsg.NotificationAvatar";
        r2 = "SmallBM get bm header invalid flag:%d size:%d file:%s";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r7 = 0;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r7 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r6[r7] = r5;	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r5 = 2;
        r6[r5] = r4;	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        com.tencent.mm.sdk.platformtools.v.e(r0, r2, r6);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r1.close();	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r3.close();	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r0 = 0;
        goto L_0x0007;
    L_0x00cd:
        r0 = 0;
    L_0x00ce:
        r2 = "MicroMsg.NotificationAvatar";
        r7 = "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s";
        r8 = 3;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r9 = 0;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r8[r9] = r5;	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r5 = 1;
        r9 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r8[r5] = r9;	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r5 = 2;
        r8[r5] = r4;	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        com.tencent.mm.sdk.platformtools.v.d(r2, r7, r8);	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r1.close();	 Catch:{ Exception -> 0x0172, OutOfMemoryError -> 0x016b }
        r2 = 0;
        r3.close();	 Catch:{ Exception -> 0x0175, OutOfMemoryError -> 0x016d }
        r3 = 0;
        r1 = 96;
        r5 = 96;
        r7 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        r1 = android.graphics.Bitmap.createBitmap(r1, r5, r7);	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        r1.copyPixelsFromBuffer(r6);	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        if (r0 == 0) goto L_0x014c;
    L_0x0102:
        r0 = 9;
        r5 = 9;
        r6 = 78;
        r7 = 78;
        r0 = android.graphics.Bitmap.createBitmap(r1, r0, r5, r6, r7);	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        r5 = "MicroMsg.NotificationAvatar";
        r6 = "recycle bitmap:%s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        r8 = 0;
        r9 = r1.toString();	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        r7[r8] = r9;	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        com.tencent.mm.sdk.platformtools.v.i(r5, r6, r7);	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        r1.recycle();	 Catch:{ Exception -> 0x0126, OutOfMemoryError -> 0x016d }
        goto L_0x0007;
    L_0x0126:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
    L_0x0129:
        r3 = "MicroMsg.NotificationAvatar";
        r5 = "SmallBM get exception e:%s file:%s";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r0 = r0.getMessage();
        r6[r7] = r0;
        r0 = 1;
        r6[r0] = r4;
        com.tencent.mm.sdk.platformtools.v.e(r3, r5, r6);
    L_0x013f:
        if (r1 == 0) goto L_0x0144;
    L_0x0141:
        r1.close();	 Catch:{ Exception -> 0x0169 }
    L_0x0144:
        if (r2 == 0) goto L_0x0149;
    L_0x0146:
        r2.close();	 Catch:{ Exception -> 0x0169 }
    L_0x0149:
        r0 = 0;
        goto L_0x0007;
    L_0x014c:
        r0 = r1;
        goto L_0x0007;
    L_0x014f:
        r0 = move-exception;
        r3 = r2;
    L_0x0151:
        r2 = "MicroMsg.NotificationAvatar";
        r5 = "SmallBM get OutOfMemoryError e:%s file:%s";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r0 = r0.getMessage();
        r6[r7] = r0;
        r0 = 1;
        r6[r0] = r4;
        com.tencent.mm.sdk.platformtools.v.e(r2, r5, r6);
        r2 = r3;
        goto L_0x013f;
    L_0x0169:
        r0 = move-exception;
        goto L_0x0149;
    L_0x016b:
        r0 = move-exception;
        goto L_0x0151;
    L_0x016d:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0151;
    L_0x0170:
        r0 = move-exception;
        goto L_0x0129;
    L_0x0172:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0129;
    L_0x0175:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0129;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.a.a.u(java.lang.String, java.lang.String):android.graphics.Bitmap");
    }
}
