package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppBrandInitConfig implements Parcelable {
    public static final Creator<AppBrandInitConfig> CREATOR = new Creator<AppBrandInitConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandInitConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandInitConfig[i];
        }
    };
    public String aWH;
    public String aZU;
    public String appId;
    public String dDn;
    public int dzx;
    public String iconUrl;
    public long startTime;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aWH);
        parcel.writeString(this.aZU);
        parcel.writeString(this.appId);
        parcel.writeInt(this.dzx);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.dDn);
        parcel.writeLong(this.startTime);
    }

    private AppBrandInitConfig(Parcel parcel) {
        this.aWH = parcel.readString();
        this.aZU = parcel.readString();
        this.appId = parcel.readString();
        this.dzx = parcel.readInt();
        this.iconUrl = parcel.readString();
        this.dDn = parcel.readString();
        this.startTime = parcel.readLong();
    }
}
