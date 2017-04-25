package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;

public interface TileProvider {
    public static final Tile NO_TILE = new Tile(-1, -1, -1, null);

    Tile getTile(int i, int i2, int i3, MapSource mapSource, Object... objArr);

    int getTileHeight();

    int getTileWidth();
}
