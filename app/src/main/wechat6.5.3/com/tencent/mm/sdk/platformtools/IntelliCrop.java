package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;

class IntelliCrop {
    public static native int crop(Bitmap bitmap, int[] iArr);

    public static native void release();

    IntelliCrop() {
    }
}
