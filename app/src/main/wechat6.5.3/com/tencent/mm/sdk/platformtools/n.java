package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;

public final class n {
    public static int a(Bitmap bitmap, int i, String str) {
        if (bitmap == null || bitmap.isRecycled()) {
            return -1;
        }
        return MMJpegOptim.compressByQualityOptim(bitmap, i, false, str);
    }
}
