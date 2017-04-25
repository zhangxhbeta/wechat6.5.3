package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppBrandLocalMediaObject implements Parcelable {
    public static final Creator<AppBrandLocalMediaObject> CREATOR = new Creator<AppBrandLocalMediaObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandLocalMediaObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLocalMediaObject[i];
        }
    };
    public String bde;
    public String cvK;
    public String dCf;
    public boolean dCg;
    public long dCh;
    public long dfM;
    public String mimeType;

    public String toString() {
        return "AppBrandLocalMediaObject{localId='" + this.bde + '\'' + ", fileFullPath='" + this.cvK + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.dCf + '\'' + '}';
    }

    protected AppBrandLocalMediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bde);
        parcel.writeString(this.cvK);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.dCf);
        parcel.writeByte(this.dCg ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.dfM);
        parcel.writeLong(this.dCh);
    }

    protected AppBrandLocalMediaObject(Parcel parcel) {
        this.bde = parcel.readString();
        this.cvK = parcel.readString();
        this.mimeType = parcel.readString();
        this.dCf = parcel.readString();
        this.dCg = parcel.readByte() != (byte) 0;
        this.dfM = parcel.readLong();
        this.dCh = parcel.readLong();
    }
}
