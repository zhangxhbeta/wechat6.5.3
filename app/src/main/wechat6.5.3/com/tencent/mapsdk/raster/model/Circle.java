package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.rastercore.tile.a.b;

public final class Circle implements IOverlay {
    private final b iCircleDel$6689bbe;

    public Circle(b bVar) {
        this.iCircleDel$6689bbe = bVar;
    }

    public final boolean contains(LatLng latLng) {
        return this.iCircleDel$6689bbe.b(latLng);
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof Circle) ? false : this.iCircleDel$6689bbe.equalsRemote(((Circle) obj).iCircleDel$6689bbe);
    }

    public final LatLng getCenter() {
        return this.iCircleDel$6689bbe.a();
    }

    public final int getFillColor() {
        return this.iCircleDel$6689bbe.e();
    }

    public final String getId() {
        return this.iCircleDel$6689bbe.getId();
    }

    public final double getRadius() {
        return this.iCircleDel$6689bbe.b();
    }

    public final int getStrokeColor() {
        return this.iCircleDel$6689bbe.d();
    }

    public final boolean getStrokeDash() {
        return this.iCircleDel$6689bbe.f();
    }

    public final DashPathEffect getStrokeDashPathEffect() {
        return this.iCircleDel$6689bbe.g();
    }

    public final float getStrokeWidth() {
        return this.iCircleDel$6689bbe.c();
    }

    public final float getZIndex() {
        return this.iCircleDel$6689bbe.getZIndex();
    }

    public final int hashCode() {
        return this.iCircleDel$6689bbe.hashCodeRemote();
    }

    public final boolean isVisible() {
        return this.iCircleDel$6689bbe.isVisible();
    }

    public final void remove() {
        this.iCircleDel$6689bbe.remove();
    }

    public final void setCenter(LatLng latLng) {
        this.iCircleDel$6689bbe.a(latLng);
    }

    public final void setFillColor(int i) {
        this.iCircleDel$6689bbe.b(i);
    }

    public final void setRadius(double d) {
        this.iCircleDel$6689bbe.a(d);
    }

    public final void setStrokeColor(int i) {
        this.iCircleDel$6689bbe.a(i);
    }

    public final void setStrokeDash(boolean z) {
        this.iCircleDel$6689bbe.a(z);
    }

    public final void setStrokeWidth(float f) {
        this.iCircleDel$6689bbe.a(f);
    }

    public final void setVisible(boolean z) {
        this.iCircleDel$6689bbe.setVisible(z);
    }

    public final void setZIndex(float f) {
        this.iCircleDel$6689bbe.setZIndex(f);
    }

    public final void strokeDashPathEffect(DashPathEffect dashPathEffect) {
        this.iCircleDel$6689bbe.a(dashPathEffect);
    }
}
