package com.tencent.mm.bb.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;

public final class a {
    public static Bitmap b(Context context, String str, int i, int i2) {
        byte[] bArr = new byte[40000];
        int[] iArr = new int[2];
        int a = QbarNative.a(bArr, iArr, str, i, i2, "UTF-8");
        QbarNative.nativeRelease();
        if (a > 0) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            int i4 = displayMetrics.heightPixels;
            if (i3 >= i4) {
                i3 = i4;
            }
            int i5 = (int) (((double) i3) * 0.8d);
            int i6 = (int) (((double) iArr[0]) * 0.1d);
            i3 = 0;
            if (i == 0) {
                i3 = i5 / (iArr[0] + (i6 * 2));
                if (i3 == 0) {
                    i3 = 1;
                }
                i5 = i3;
            } else if (i == 5) {
                i3 = i5 / (iArr[0] + (i6 * 2));
                if (i3 == 0) {
                    i3 = 1;
                }
                i5 = i3;
                i3 = (iArr[0] * i3) / iArr[1];
            } else {
                i5 = 0;
            }
            int i7 = i6 * i5;
            i4 = (iArr[0] + (i6 * 2)) * i5;
            int i8 = (iArr[1] * i3) + (i6 * (i5 * 2));
            Bitmap createBitmap = Bitmap.createBitmap(i4, i8, Config.RGB_565);
            int[] iArr2 = new int[(i4 * i8)];
            Arrays.fill(iArr2, -1);
            for (i6 = 0; i6 < iArr[1]; i6++) {
                for (int i9 = 0; i9 < iArr[0]; i9++) {
                    int i10;
                    int i11;
                    if (bArr[(iArr[0] * i6) + i9] == (byte) 1) {
                        for (i10 = 0; i10 < i3; i10++) {
                            for (i11 = 0; i11 < i5; i11++) {
                                iArr2[((((((i6 * i3) + i7) + i10) * i4) + (i9 * i5)) + i7) + i11] = -16777216;
                            }
                        }
                    } else {
                        for (i10 = 0; i10 < i3; i10++) {
                            for (i11 = 0; i11 < i5; i11++) {
                                iArr2[((((((i6 * i3) + i7) + i10) * i4) + (i9 * i5)) + i7) + i11] = -1;
                            }
                        }
                    }
                }
            }
            createBitmap.setPixels(iArr2, 0, i4, 0, 0, i4, i8);
            if (createBitmap == null) {
                v.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[]{Integer.valueOf(a), be.bur().toString()});
            } else {
                v.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[]{createBitmap});
            }
            return createBitmap;
        }
        v.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[]{Integer.valueOf(a), be.bur().toString()});
        return null;
    }
}
