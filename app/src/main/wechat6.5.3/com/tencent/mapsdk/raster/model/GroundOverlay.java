package com.tencent.mapsdk.raster.model;

import android.os.RemoteException;
import com.tencent.mapsdk.rastercore.e.a;

public final class GroundOverlay implements IOverlay {
    private a iGroundOverlayDelegate;

    public GroundOverlay(a aVar) {
        this.iGroundOverlayDelegate = aVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GroundOverlay) {
            try {
                throw new RemoteException();
            } catch (RemoteException e) {
            }
        }
        return false;
    }

    public final float getBearing() {
        return this.iGroundOverlayDelegate.e();
    }

    protected final LatLngBounds getBounds() {
        return this.iGroundOverlayDelegate.d();
    }

    protected final float getHeight() {
        return this.iGroundOverlayDelegate.c();
    }

    public final String getId() {
        return this.iGroundOverlayDelegate.getId();
    }

    protected final LatLng getPosition() {
        return this.iGroundOverlayDelegate.a();
    }

    protected final float getTransparency() {
        return this.iGroundOverlayDelegate.f();
    }

    protected final float getWidth() {
        return this.iGroundOverlayDelegate.b();
    }

    public final float getZIndex() {
        return this.iGroundOverlayDelegate.getZIndex();
    }

    public final int hashCode() {
        return this.iGroundOverlayDelegate.hashCode();
    }

    public final boolean isVisible() {
        return this.iGroundOverlayDelegate.isVisible();
    }

    public final void remove() {
        this.iGroundOverlayDelegate.remove();
    }

    public final void setAnchor(float f, float f2) {
        this.iGroundOverlayDelegate.b(f, f2);
    }

    public final void setBearing(float f) {
        this.iGroundOverlayDelegate.b(f);
    }

    protected final void setDimensions(float f) {
        this.iGroundOverlayDelegate.a(f);
    }

    protected final void setDimensions(float f, float f2) {
        this.iGroundOverlayDelegate.a(f, f2);
    }

    protected final void setImage(BitmapDescriptor bitmapDescriptor) {
        this.iGroundOverlayDelegate.a(bitmapDescriptor);
    }

    protected final void setPosition(LatLng latLng) {
        this.iGroundOverlayDelegate.a(latLng);
    }

    protected final void setPositionFromBounds(LatLngBounds latLngBounds) {
        this.iGroundOverlayDelegate.a(latLngBounds);
    }

    protected final void setTransparency(float f) {
        this.iGroundOverlayDelegate.c(f);
    }

    public final void setVisible(boolean z) {
        this.iGroundOverlayDelegate.setVisible(z);
    }

    public final void setZIndex(float f) {
        this.iGroundOverlayDelegate.setZIndex(f);
    }
}
