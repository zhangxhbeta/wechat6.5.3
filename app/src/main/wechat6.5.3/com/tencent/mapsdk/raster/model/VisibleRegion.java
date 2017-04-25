package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.f.a;

public final class VisibleRegion {
    private final LatLng farLeft;
    private final LatLng farRight;
    private final LatLngBounds latLngBounds;
    private final int mVersionCode;
    private final LatLng nearLeft;
    private final LatLng nearRight;

    protected VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.mVersionCode = i;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return getNearLeft().equals(visibleRegion.getNearLeft()) && getNearRight().equals(visibleRegion.getNearRight()) && getFarLeft().equals(visibleRegion.getFarLeft()) && getFarRight().equals(visibleRegion.getFarRight()) && getLatLngBounds().equals(visibleRegion.getLatLngBounds());
    }

    public final LatLng getFarLeft() {
        return this.farLeft;
    }

    public final LatLng getFarRight() {
        return this.farRight;
    }

    public final LatLngBounds getLatLngBounds() {
        return this.latLngBounds;
    }

    public final LatLng getNearLeft() {
        return this.nearLeft;
    }

    public final LatLng getNearRight() {
        return this.nearRight;
    }

    protected final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return a.a(new Object[]{getNearLeft(), getNearRight(), getFarLeft(), getFarRight(), getLatLngBounds()});
    }

    public final String toString() {
        return a.a(a.a("nearLeft", getNearLeft()), a.a("nearRight", getNearRight()), a.a("farLeft", getFarLeft()), a.a("farRight", getFarRight()), a.a("latLngBounds", getLatLngBounds()));
    }
}
