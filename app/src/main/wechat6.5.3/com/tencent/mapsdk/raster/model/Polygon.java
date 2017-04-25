package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.e.c;
import java.util.List;

public final class Polygon implements IOverlay {
    private c polygonDelegate;

    public Polygon(c cVar) {
        this.polygonDelegate = cVar;
    }

    public final boolean contains(LatLng latLng) {
        return this.polygonDelegate.a(latLng);
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof Polygon) ? false : this.polygonDelegate.equalsRemote(((Polygon) obj).polygonDelegate);
    }

    public final int getFillColor() {
        return this.polygonDelegate.b();
    }

    public final String getId() {
        return this.polygonDelegate.getId();
    }

    public final List<LatLng> getPoints() {
        return this.polygonDelegate.c();
    }

    public final int getStrokeColor() {
        return this.polygonDelegate.d();
    }

    public final float getStrokeWidth() {
        return this.polygonDelegate.a();
    }

    public final float getZIndex() {
        return this.polygonDelegate.getZIndex();
    }

    public final int hashCode() {
        return this.polygonDelegate.hashCodeRemote();
    }

    public final boolean isVisible() {
        return this.polygonDelegate.isVisible();
    }

    public final void remove() {
        this.polygonDelegate.remove();
    }

    public final void setFillColor(int i) {
        this.polygonDelegate.a(i);
    }

    public final void setPoints(List<LatLng> list) {
        this.polygonDelegate.a((List) list);
    }

    public final void setStrokeColor(int i) {
        this.polygonDelegate.b(i);
    }

    public final void setStrokeWidth(float f) {
        this.polygonDelegate.a(f);
    }

    public final void setVisible(boolean z) {
        this.polygonDelegate.setVisible(z);
    }

    public final void setZIndex(float f) {
        this.polygonDelegate.setZIndex(f);
    }
}
