package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mapsdk.rastercore.f.a;

public final class CameraPosition implements Parcelable {
    public static final Creator<CameraPosition> CREATOR = new Creator<CameraPosition>() {
        public final CameraPosition createFromParcel(Parcel parcel) {
            float readFloat = parcel.readFloat();
            float readFloat2 = parcel.readFloat();
            return new CameraPosition(new LatLng((double) readFloat, (double) readFloat2), parcel.readFloat());
        }

        public final CameraPosition[] newArray(int i) {
            return new CameraPosition[i];
        }
    };
    private static final int EMPTY_ZOOMLEVEL = -1;
    private final LatLng target;
    private float zoom = -1.0f;

    public static final class Builder {
        private LatLng target;
        private float zoom = -1.0f;

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.getTarget()).zoom(cameraPosition.getZoom());
        }

        public final CameraPosition build() {
            return new CameraPosition(this.target, this.zoom);
        }

        public final Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final Builder zoom(float f) {
            this.zoom = f;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f) {
        this.target = latLng;
        this.zoom = f;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return getTarget().equals(cameraPosition.getTarget()) && Float.floatToIntBits(getZoom()) == Float.floatToIntBits(cameraPosition.getZoom());
    }

    public final LatLng getTarget() {
        return this.target;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return a.a(a.a("target", getTarget()), a.a("zoom", Float.valueOf(getZoom())));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat((float) getTarget().getLatitude());
        parcel.writeFloat((float) getTarget().getLongitude());
        parcel.writeFloat(getZoom());
    }
}
