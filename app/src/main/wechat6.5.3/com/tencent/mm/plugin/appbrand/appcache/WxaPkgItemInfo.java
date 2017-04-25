package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class WxaPkgItemInfo implements Parcelable {
    public static final Creator<WxaPkgItemInfo> CREATOR = new Creator<WxaPkgItemInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaPkgItemInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgItemInfo[i];
        }
    };
    public final String aST;
    public final String bsL;
    public final int dAT;
    public final int dAU;

    WxaPkgItemInfo(String str, int i, int i2) {
        this.aST = str;
        this.bsL = null;
        this.dAT = i;
        this.dAU = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aST);
        parcel.writeString(this.bsL);
        parcel.writeInt(this.dAT);
        parcel.writeInt(this.dAU);
    }

    private WxaPkgItemInfo(Parcel parcel) {
        this.aST = parcel.readString();
        this.bsL = parcel.readString();
        this.dAT = parcel.readInt();
        this.dAU = parcel.readInt();
    }
}
