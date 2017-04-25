package com.tencent.mm.a;

import com.tencent.smtt.sdk.WebView;

public final class h {
    public static int aq(int i, int i2) {
        int i3 = 0;
        if (i2 < 0 || i2 >= Integer.MAX_VALUE) {
            return 0;
        }
        byte[] bArr = new byte[4];
        while (i3 < 4) {
            bArr[i3] = (byte) ((i >> (i3 * 8)) & WebView.NORMAL_MODE_ALPHA);
            i3++;
        }
        return (int) ((((long) b(bArr, 4)) & 4294967295L) % ((long) i2));
    }

    public static int b(byte[] bArr, int i) {
        int i2 = i >> 2;
        int i3 = i ^ 0;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i4 << 2) + 0;
            i5 = ((bArr[i5 + 0] & WebView.NORMAL_MODE_ALPHA) | (((((bArr[i5 + 3] << 8) | (bArr[i5 + 2] & WebView.NORMAL_MODE_ALPHA)) << 8) | (bArr[i5 + 1] & WebView.NORMAL_MODE_ALPHA)) << 8)) * 1540483477;
            i4++;
            i3 = ((i5 ^ (i5 >>> 24)) * 1540483477) ^ (i3 * 1540483477);
        }
        i4 = i - (i2 << 2);
        if (i4 != 0) {
            if (i4 >= 3) {
                i3 ^= bArr[(i + 0) - 3] << 16;
            }
            if (i4 >= 2) {
                i3 ^= bArr[(i + 0) - 2] << 8;
            }
            if (i4 > 0) {
                i3 ^= bArr[(i + 0) - 1];
            }
            i3 *= 1540483477;
        }
        i3 = (i3 ^ (i3 >>> 13)) * 1540483477;
        return i3 ^ (i3 >>> 15);
    }
}
