package com.tencent.mm.plugin.address.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RcptItem implements Parcelable {
    public static final Creator<RcptItem> CREATOR = new Creator<RcptItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RcptItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RcptItem[i];
        }
    };
    public String code = "";
    public String dxo = "";
    public boolean dxp = false;
    public String name = "";

    public RcptItem(String str, String str2, String str3) {
        this.name = str;
        this.code = str2;
        this.dxo = str3;
    }

    public int describeContents() {
        return 0;
    }

    public RcptItem(Parcel parcel) {
        this.name = parcel.readString();
        this.code = parcel.readString();
        this.dxo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.code);
        parcel.writeString(this.dxo);
    }
}
