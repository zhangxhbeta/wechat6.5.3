package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.e.d;
import java.util.List;

public class Polyline implements IOverlay {
    private final d polylineDelegate;

    public Polyline(d dVar) {
        this.polylineDelegate = dVar;
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof Polyline) ? false : this.polylineDelegate.equalsRemote(((Polyline) obj).polylineDelegate);
    }

    public int getColor() {
        return this.polylineDelegate.b();
    }

    public String getId() {
        return this.polylineDelegate.getId();
    }

    public List<LatLng> getPoints() {
        return this.polylineDelegate.c();
    }

    public float getWidth() {
        return this.polylineDelegate.a();
    }

    public float getZIndex() {
        return this.polylineDelegate.getZIndex();
    }

    public final int hashCode() {
        return this.polylineDelegate.hashCodeRemote();
    }

    public boolean isDottedLine() {
        return this.polylineDelegate.d();
    }

    public boolean isGeodesic() {
        return this.polylineDelegate.e();
    }

    public boolean isVisible() {
        return this.polylineDelegate.isVisible();
    }

    public void remove() {
        this.polylineDelegate.remove();
    }

    public void setColor(int i) {
        this.polylineDelegate.a(i);
    }

    public void setDottedLine(boolean z) {
        this.polylineDelegate.a(z);
    }

    public void setGeodesic(boolean z) {
        if (this.polylineDelegate.e() != z) {
            List points = getPoints();
            this.polylineDelegate.b(z);
            setPoints(points);
        }
    }

    public void setPoints(List<LatLng> list) {
        this.polylineDelegate.a((List) list);
    }

    public void setVisible(boolean z) {
        this.polylineDelegate.setVisible(z);
    }

    public void setWidth(float f) {
        this.polylineDelegate.a(f);
    }

    public void setZIndex(float f) {
        this.polylineDelegate.setZIndex(f);
    }
}
