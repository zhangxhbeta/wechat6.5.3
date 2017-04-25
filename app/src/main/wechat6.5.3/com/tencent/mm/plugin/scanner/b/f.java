package com.tencent.mm.plugin.scanner.b;

import android.graphics.Bitmap;
import c.a;

public final class f extends a {
    private static int iDr = 10;
    private final byte[] iDq;

    public f(Bitmap bitmap, int i, int i2) {
        super(bitmap.getWidth() - i, bitmap.getHeight() - i2);
        int width = bitmap.getWidth() - i;
        int height = bitmap.getHeight() - i2;
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, i / 2, i2 / 2, width, height);
        this.iDq = new byte[(width * height)];
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                int i6 = iArr[i4 + i5];
                int i7 = (i6 >> 16) & 255;
                int i8 = (i6 >> 8) & 255;
                i6 &= 255;
                if (i7 == i8 && i8 == i6) {
                    this.iDq[i4 + i5] = (byte) i7;
                } else {
                    this.iDq[i4 + i5] = (byte) ((i6 + ((i7 + i8) + i8)) >> 2);
                }
            }
        }
    }

    public final byte[] k(int i, byte[] bArr) {
        if (i < 0 || i >= this.height) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int i2 = this.width;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.iDq, i * i2, bArr, 0, i2);
        return bArr;
    }

    public final byte[] aLQ() {
        return this.iDq;
    }
}
