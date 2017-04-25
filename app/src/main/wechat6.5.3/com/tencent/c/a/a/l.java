package com.tencent.c.a.a;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

final class l {
    static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArr = new int[FileUtils.S_IRUSR];
        int[] iArr2 = new int[FileUtils.S_IRUSR];
        int length = bArr2.length;
        if (length <= 0 || length > FileUtils.S_IRUSR) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        for (i2 = 0; i2 < FileUtils.S_IRUSR; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        i2 = 0;
        for (length = 0; length < FileUtils.S_IRUSR; length++) {
            i2 = ((i2 + iArr[length]) + iArr2[length]) & WebView.NORMAL_MODE_ALPHA;
            int i3 = iArr[length];
            iArr[length] = iArr[i2];
            iArr[i2] = i3;
        }
        byte[] bArr3 = new byte[bArr.length];
        i2 = 0;
        length = 0;
        while (i < bArr.length) {
            i2 = (i2 + 1) & WebView.NORMAL_MODE_ALPHA;
            length = (length + iArr[i2]) & WebView.NORMAL_MODE_ALPHA;
            i3 = iArr[i2];
            iArr[i2] = iArr[length];
            iArr[length] = i3;
            bArr3[i] = (byte) (iArr[(iArr[i2] + iArr[length]) & WebView.NORMAL_MODE_ALPHA] ^ bArr[i]);
            i++;
        }
        return bArr3;
    }
}
