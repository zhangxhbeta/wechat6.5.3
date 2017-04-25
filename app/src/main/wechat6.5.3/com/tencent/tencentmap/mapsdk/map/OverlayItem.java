package com.tencent.tencentmap.mapsdk.map;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mapsdk.raster.model.GeoPoint;

public class OverlayItem implements Parcelable {
    public static final Creator<OverlayItem> CREATOR = new Creator<OverlayItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OverlayItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OverlayItem[i];
        }
    };
    protected final String mSnippet;
    protected final String mTitle;
    protected GeoPoint pAb;
    protected boolean pAc = true;

    protected OverlayItem(Parcel parcel) {
        this.pAb = (GeoPoint) parcel.readValue(GeoPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.pAb);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
    }
}
