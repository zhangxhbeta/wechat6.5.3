package com.tencent.mapsdk.raster.model;

import android.graphics.Bitmap;

public final class BitmapDescriptor implements Cloneable {
    int h = 0;
    Bitmap mBitmap;
    int w = 0;

    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.w = bitmap.getWidth();
            this.h = bitmap.getHeight();
            this.mBitmap = bitmap;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.w = i;
        this.h = i2;
        this.mBitmap = bitmap;
    }

    public final BitmapDescriptor clone() {
        return new BitmapDescriptor(Bitmap.createBitmap(this.mBitmap), this.w, this.h);
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public final int getHeight() {
        return this.h;
    }

    public final int getWidth() {
        return this.w;
    }
}
