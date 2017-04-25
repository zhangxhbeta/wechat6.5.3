package com.tencent.mapsdk.raster.model;

import android.view.View;
import android.view.animation.Animation;

public final class MarkerOptions {
    private float alpha = 1.0f;
    private float anchorU = 0.5f;
    private float anchorV = 1.0f;
    private BitmapDescriptor bitmapDescriptor;
    private Animation hidingAnination;
    protected String id;
    private Animation infoWindowHideAnimation;
    private Animation infoWindowShowAnimation;
    private boolean isDraggable = false;
    private boolean isGps = false;
    private boolean isVisible = true;
    private LatLng latLng;
    private View markerView;
    private float rotation = 0.0f;
    private Animation showingAnination;
    private String snippet;
    private Object tag;
    private String title;

    public final MarkerOptions alpha(float f) {
        this.alpha = f;
        return this;
    }

    public final MarkerOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        return this;
    }

    public final MarkerOptions draggable(boolean z) {
        this.isDraggable = z;
        return this;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final Animation getHidingAnination() {
        return this.hidingAnination;
    }

    public final BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public final Animation getInfoWindowHideAnimation() {
        return this.infoWindowHideAnimation;
    }

    public final Animation getInfoWindowShowAnimation() {
        return this.infoWindowShowAnimation;
    }

    public final View getMarkerView() {
        return this.markerView;
    }

    public final LatLng getPosition() {
        return this.latLng;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final Animation getShowingAnination() {
        return this.showingAnination;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public final MarkerOptions infoWindowHideAnimation(Animation animation) {
        this.infoWindowHideAnimation = animation;
        return this;
    }

    public final MarkerOptions infoWindowShowAnimation(Animation animation) {
        this.infoWindowShowAnimation = animation;
        return this;
    }

    public final boolean isDraggable() {
        return this.isDraggable;
    }

    public final boolean isGps() {
        return this.isGps;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final MarkerOptions markerView(View view) {
        this.markerView = view;
        return this;
    }

    public final MarkerOptions position(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public final MarkerOptions rotation(float f) {
        this.rotation = f;
        return this;
    }

    public final MarkerOptions setHidingAnination(Animation animation) {
        this.hidingAnination = animation;
        return this;
    }

    public final MarkerOptions setShowingAnination(Animation animation) {
        this.showingAnination = animation;
        return this;
    }

    public final MarkerOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public final MarkerOptions tag(Object obj) {
        this.tag = obj;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.title = str;
        return this;
    }

    public final MarkerOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }
}
