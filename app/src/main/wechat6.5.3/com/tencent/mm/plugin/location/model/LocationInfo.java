package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.be;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new Creator<LocationInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            LocationInfo locationInfo = new LocationInfo();
            locationInfo.gRJ = parcel.readString();
            locationInfo.gRK = parcel.readDouble();
            locationInfo.gRL = parcel.readDouble();
            locationInfo.zoom = parcel.readInt();
            locationInfo.gRM = parcel.readString();
            locationInfo.gRN = parcel.readString();
            locationInfo.bkV = parcel.readString();
            locationInfo.gRO = parcel.readString();
            locationInfo.gRP = parcel.readInt();
            return locationInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationInfo[i];
        }
    };
    public String bkV;
    public String gRJ;
    public double gRK;
    public double gRL;
    public String gRM;
    public String gRN;
    String gRO;
    public int gRP;
    public int zoom;

    public LocationInfo() {
        this.gRJ = "";
        this.gRK = -1000.0d;
        this.gRL = -1000.0d;
        this.gRM = "";
        this.gRN = "zh-cn";
        this.gRO = "";
        this.gRP = 0;
    }

    public LocationInfo(byte b) {
        this.gRJ = "";
        this.gRK = -1000.0d;
        this.gRL = -1000.0d;
        this.gRM = "";
        this.gRN = "zh-cn";
        this.gRO = "";
        this.gRP = 0;
        this.gRJ = toString() + " " + System.nanoTime();
        this.zoom = d.dV(false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.gRJ);
        parcel.writeDouble(this.gRK);
        parcel.writeDouble(this.gRL);
        parcel.writeInt(this.zoom);
        parcel.writeString(this.gRM);
        parcel.writeString(this.gRN);
        parcel.writeString(this.bkV);
        parcel.writeString(this.gRO);
        parcel.writeInt(this.gRP);
    }

    public final boolean avY() {
        if (this.gRK == -1000.0d || this.gRL == -1000.0d) {
            return false;
        }
        return true;
    }

    public final boolean avZ() {
        if (be.kS(this.gRM) && be.kS(this.bkV)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.gRK + " " + this.gRL + " " + this.gRM + " " + this.bkV + "  " + this.gRJ;
    }

    public int describeContents() {
        return 0;
    }
}
