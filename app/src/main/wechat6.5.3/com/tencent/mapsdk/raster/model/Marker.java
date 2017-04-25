package com.tencent.mapsdk.raster.model;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.rastercore.e.a.c;

public final class Marker implements IOverlay {
    private c markerDelegate;

    public Marker(c cVar) {
        this.markerDelegate = cVar;
    }

    public final boolean equals(Object obj) {
        return (obj == null || !(obj instanceof Marker)) ? false : this.markerDelegate.equals(((Marker) obj).markerDelegate);
    }

    public final float getAlpha() {
        return this.markerDelegate.o();
    }

    public final String getId() {
        return this.markerDelegate.m();
    }

    public final View getMarkerView() {
        return this.markerDelegate.a();
    }

    public final LatLng getPosition() {
        return this.markerDelegate.l();
    }

    public final float getRotation() {
        return this.markerDelegate.j();
    }

    public final String getSnippet() {
        return this.markerDelegate.i();
    }

    public final Object getTag() {
        return this.markerDelegate.p();
    }

    public final String getTitle() {
        return this.markerDelegate.h();
    }

    public final int hashCode() {
        return this.markerDelegate.hashCode();
    }

    public final void hideInfoWindow() {
        this.markerDelegate.g();
    }

    public final boolean isDraggable() {
        return this.markerDelegate.d();
    }

    public final boolean isInfoWindowShown() {
        return this.markerDelegate.e();
    }

    public final boolean isVisible() {
        return this.markerDelegate.k();
    }

    public final void remove() {
        this.markerDelegate.b();
    }

    public final void set2Top() {
        this.markerDelegate.n();
    }

    public final void setAlpha(float f) {
        this.markerDelegate.b(f);
    }

    public final void setAnchor(float f, float f2) {
        this.markerDelegate.a(f, f2);
    }

    public final void setDraggable(boolean z) {
        this.markerDelegate.b(z);
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.markerDelegate.a(bitmapDescriptor);
    }

    public final void setInfoWindowHideAnimation(Animation animation) {
        this.markerDelegate.b(animation);
    }

    public final void setInfoWindowShowAnimation(Animation animation) {
        this.markerDelegate.a(animation);
    }

    public final void setMarkerView(View view) {
        this.markerDelegate.a(view);
    }

    public final void setPosition(LatLng latLng) {
        this.markerDelegate.a(latLng);
    }

    public final void setRotation(float f) {
        this.markerDelegate.a(f);
    }

    public final void setSnippet(String str) {
        this.markerDelegate.a(str);
    }

    public final void setTag(Object obj) {
        this.markerDelegate.a(obj);
    }

    public final void setTitle(String str) {
        this.markerDelegate.b(str);
    }

    public final void setVisible(boolean z) {
        this.markerDelegate.a(z);
    }

    public final void showInfoWindow() {
        this.markerDelegate.f();
    }
}
