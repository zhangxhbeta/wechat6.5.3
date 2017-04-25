package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.f.a;

public class LatLngBounds {
    private int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;

    public static final class Builder {
        private double mEast = Double.NaN;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mWest = Double.NaN;

        private boolean containsLongitude(double d) {
            return this.mWest <= this.mEast ? this.mWest <= d && d <= this.mEast : this.mWest <= d || d <= this.mEast;
        }

        public final LatLngBounds build() {
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
        }

        public final Builder include(LatLng latLng) {
            this.mSouth = Math.min(this.mSouth, latLng.getLatitude());
            this.mNorth = Math.max(this.mNorth, latLng.getLatitude());
            double longitude = latLng.getLongitude();
            if (Double.isNaN(this.mWest)) {
                this.mWest = longitude;
            } else {
                if (!containsLongitude(longitude)) {
                    if (LatLngBounds.longitudeDistanceHeadingWest(this.mWest, longitude) < LatLngBounds.longitudeDistanceHeadingEast(this.mEast, longitude)) {
                        this.mWest = longitude;
                    }
                }
                return this;
            }
            this.mEast = longitude;
            return this;
        }

        public final Builder include(Iterable<LatLng> iterable) {
            if (iterable != null) {
                for (LatLng include : iterable) {
                    include(include);
                }
            }
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        Builder include = new Builder().include(latLng).include(latLng2);
        this.southwest = new LatLng(include.mSouth, include.mWest);
        this.northeast = new LatLng(include.mNorth, include.mEast);
        this.mVersionCode = i;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean containsLatitude(double d) {
        return this.southwest.getLatitude() <= d && d <= this.northeast.getLatitude();
    }

    private boolean containsLongitude(double d) {
        return this.southwest.getLongitude() <= this.northeast.getLongitude() ? this.southwest.getLongitude() <= d && d <= this.northeast.getLongitude() : this.southwest.getLongitude() <= d || d <= this.northeast.getLongitude();
    }

    private boolean intersect(LatLngBounds latLngBounds) {
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        return Math.abs(((latLngBounds.northeast.getLongitude() + latLngBounds.southwest.getLongitude()) - this.northeast.getLongitude()) - this.southwest.getLongitude()) < ((this.northeast.getLongitude() - this.southwest.getLongitude()) + latLngBounds.northeast.getLongitude()) - latLngBounds.southwest.getLongitude() && Math.abs(((latLngBounds.northeast.getLatitude() + latLngBounds.southwest.getLatitude()) - this.northeast.getLatitude()) - this.southwest.getLatitude()) < ((this.northeast.getLatitude() - this.southwest.getLatitude()) + latLngBounds.northeast.getLatitude()) - latLngBounds.southwest.getLatitude();
    }

    private static double longitudeDistanceHeadingEast(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private static double longitudeDistanceHeadingWest(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public boolean contains(LatLng latLng) {
        return containsLatitude(latLng.getLatitude()) && containsLongitude(latLng.getLongitude());
    }

    public boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getNortheast() {
        return this.northeast;
    }

    public LatLng getSouthwest() {
        return this.southwest;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return a.a(new Object[]{this.southwest, this.northeast});
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.getLatitude(), latLng.getLatitude());
        double max = Math.max(this.northeast.getLatitude(), latLng.getLatitude());
        double longitude = this.northeast.getLongitude();
        double longitude2 = this.southwest.getLongitude();
        double longitude3 = latLng.getLongitude();
        if (containsLongitude(longitude3)) {
            longitude3 = longitude2;
            longitude2 = longitude;
        } else if (longitudeDistanceHeadingWest(longitude2, longitude3) < longitudeDistanceHeadingEast(longitude, longitude3)) {
            longitude2 = longitude;
        } else {
            double d = longitude2;
            longitude2 = longitude3;
            longitude3 = d;
        }
        return new LatLngBounds(new LatLng(min, longitude3), new LatLng(max, longitude2));
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        return latLngBounds == null ? false : intersect(latLngBounds) || latLngBounds.intersect(this);
    }

    public final String toString() {
        return a.a(a.a("southwest", this.southwest), a.a("northeast", this.northeast));
    }
}
