package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FavorPayInfo implements Parcelable {
    public static final Creator<FavorPayInfo> CREATOR = new Creator<FavorPayInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FavorPayInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavorPayInfo[i];
        }
    };
    public String kOv;
    public int kOw;
    public String kOx;
    public String kOy;
    public String kOz;

    public FavorPayInfo(Parcel parcel) {
        this.kOv = parcel.readString();
        this.kOw = parcel.readInt();
        this.kOx = parcel.readString();
        this.kOy = parcel.readString();
        this.kOz = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.kOv);
        parcel.writeInt(this.kOw);
        parcel.writeString(this.kOx);
        parcel.writeString(this.kOy);
        parcel.writeString(this.kOz);
    }
}
