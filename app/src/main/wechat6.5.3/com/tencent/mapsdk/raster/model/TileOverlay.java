package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.e.a.f;

public final class TileOverlay implements IOverlay {
    private f delegate;

    public TileOverlay(f fVar) {
        this.delegate = fVar;
    }

    public final void clearTileCache() {
        f.c();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TileOverlay)) {
            return false;
        }
        return this.delegate.equals(((TileOverlay) obj).delegate);
    }

    public final String getId() {
        return this.delegate.d();
    }

    public final int hashCode() {
        return this.delegate.hashCode();
    }

    public final boolean isVisible() {
        return this.delegate.e();
    }

    public final void remove() {
        this.delegate.b();
    }

    public final void setVisible(boolean z) {
        this.delegate.a(z);
    }
}
