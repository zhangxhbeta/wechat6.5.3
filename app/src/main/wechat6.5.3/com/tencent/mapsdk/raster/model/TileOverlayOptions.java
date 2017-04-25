package com.tencent.mapsdk.raster.model;

public final class TileOverlayOptions {
    private boolean diskCacheEnabled = true;
    private TileProvider tileProvider;
    private boolean visible = true;
    private float zIndex = 1.0f;

    public final TileOverlayOptions diskCacheEnabled(boolean z) {
        this.diskCacheEnabled = z;
        return this;
    }

    public final boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public final TileProvider getTileProvider() {
        return this.tileProvider;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.visible;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.visible = z;
        return this;
    }

    public final TileOverlayOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
