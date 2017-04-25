package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public final class a extends Canvas {
    public Bitmap mBitmap;

    public a(Bitmap bitmap) {
        super(bitmap);
        this.mBitmap = bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        super.setBitmap(bitmap);
        this.mBitmap = bitmap;
    }
}
