package com.tencent.mm.a;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class k {
    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return d(bArr, bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return d(bArr, bArr2);
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        int i3 = 0;
        byte[] bArr3 = new byte[FileUtils.S_IRUSR];
        for (i = 0; i < FileUtils.S_IRUSR; i++) {
            bArr3[i] = (byte) i;
        }
        if (bArr2 == null || bArr2.length == 0) {
            bArr3 = null;
        } else {
            i2 = 0;
            int i4 = 0;
            for (i = 0; i < FileUtils.S_IRUSR; i++) {
                i2 = (i2 + ((bArr2[i4] & WebView.NORMAL_MODE_ALPHA) + (bArr3[i] & WebView.NORMAL_MODE_ALPHA))) & WebView.NORMAL_MODE_ALPHA;
                byte b = bArr3[i];
                bArr3[i] = bArr3[i2];
                bArr3[i2] = b;
                i4 = (i4 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        i = 0;
        i2 = 0;
        while (i3 < bArr.length) {
            i2 = (i2 + 1) & WebView.NORMAL_MODE_ALPHA;
            i = (i + (bArr3[i2] & WebView.NORMAL_MODE_ALPHA)) & WebView.NORMAL_MODE_ALPHA;
            b = bArr3[i2];
            bArr3[i2] = bArr3[i];
            bArr3[i] = b;
            int i5 = ((bArr3[i2] & WebView.NORMAL_MODE_ALPHA) + (bArr3[i] & WebView.NORMAL_MODE_ALPHA)) & WebView.NORMAL_MODE_ALPHA;
            bArr4[i3] = (byte) (bArr3[i5] ^ bArr[i3]);
            i3++;
        }
        return bArr4;
    }
}
