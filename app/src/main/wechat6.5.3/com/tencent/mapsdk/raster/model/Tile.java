package com.tencent.mapsdk.raster.model;

public final class Tile {
    private final byte[] data;
    private final int x;
    private final int y;
    private final int zoom;

    public Tile(int i, int i2, int i3, byte[] bArr) {
        this.x = i;
        this.y = i2;
        this.zoom = i3;
        this.data = bArr;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final int getZoom() {
        return this.zoom;
    }
}
