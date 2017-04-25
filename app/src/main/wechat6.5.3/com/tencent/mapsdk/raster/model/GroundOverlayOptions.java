package com.tencent.mapsdk.raster.model;

import android.os.IBinder;

public final class GroundOverlayOptions {
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private float height;
    private boolean isVisible;
    private LatLng latLng;
    private LatLngBounds latlngBounds;
    private float transparency;
    private float width;
    private float zIndex;

    public GroundOverlayOptions() {
        this.transparency = 0.0f;
        this.isVisible = true;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
    }

    protected GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.transparency = 0.0f;
        this.isVisible = true;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = latLng;
        this.width = f;
        this.height = f2;
        this.latlngBounds = latLngBounds;
        this.bearing = f3;
        this.zIndex = f4;
        this.isVisible = z;
        this.transparency = f5;
        this.anchorU = f6;
        this.anchorV = f7;
    }

    public final GroundOverlayOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        return this;
    }

    public final GroundOverlayOptions bearing(float f) {
        this.bearing = f;
        return this;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getBearing() {
        return this.bearing;
    }

    public final LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public final float getHeight() {
        return this.height;
    }

    public final BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public final LatLng getLocation() {
        return this.latLng;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f) {
        return putGroundOverlayOptions(latLng, f, f);
    }

    public final GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        return putGroundOverlayOptions(latLng, f, f2);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        this.latlngBounds = latLngBounds;
        return this;
    }

    protected final GroundOverlayOptions putGroundOverlayOptions(LatLng latLng, float f, float f2) {
        this.latLng = latLng;
        this.width = f;
        this.height = f2;
        return this;
    }

    public final GroundOverlayOptions transparency(float f) {
        this.transparency = f;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final GroundOverlayOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
