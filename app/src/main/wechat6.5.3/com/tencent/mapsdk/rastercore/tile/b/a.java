package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.raster.model.UrlTileProvider;

public abstract class a extends UrlTileProvider {
    public a(int i) {
    }

    protected static int a(int i, int i2) {
        int i3 = i % i2;
        return i3 * i2 < 0 ? i3 + i2 : i3;
    }

    public int getTileHeight() {
        return 256;
    }

    public int getTileWidth() {
        return 256;
    }
}
