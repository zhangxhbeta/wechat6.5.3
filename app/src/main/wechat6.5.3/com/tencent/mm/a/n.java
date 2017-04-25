package com.tencent.mm.a;

import com.tencent.smtt.sdk.WebView;

public final class n {
    public static byte[] cE(int i) {
        int i2 = 0;
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) ((i >> (i3 * 8)) & WebView.NORMAL_MODE_ALPHA);
        }
        byte[] bArr2 = new byte[4];
        while (i2 < 4) {
            bArr2[i2] = bArr[3 - i2];
            i2++;
        }
        return bArr2;
    }

    public static int o(byte[] bArr) {
        return ((((bArr[3] & WebView.NORMAL_MODE_ALPHA) << 24) | ((bArr[2] & WebView.NORMAL_MODE_ALPHA) << 16)) | ((bArr[1] & WebView.NORMAL_MODE_ALPHA) << 8)) | ((bArr[0] & WebView.NORMAL_MODE_ALPHA) << 0);
    }

    public static int c(byte[] bArr, int i) {
        return ((((bArr[i] & WebView.NORMAL_MODE_ALPHA) << 24) | ((bArr[i + 1] & WebView.NORMAL_MODE_ALPHA) << 16)) | ((bArr[i + 2] & WebView.NORMAL_MODE_ALPHA) << 8)) | ((bArr[i + 3] & WebView.NORMAL_MODE_ALPHA) << 0);
    }
}
