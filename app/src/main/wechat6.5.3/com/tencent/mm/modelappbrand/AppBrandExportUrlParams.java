package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mmdb.database.SQLiteDatabase;

public class AppBrandExportUrlParams implements Parcelable {
    public static final Creator<AppBrandExportUrlParams> CREATOR = new Creator<AppBrandExportUrlParams>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandExportUrlParams(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandExportUrlParams[i];
        }
    };
    public String appId;
    public int cPY;
    public int dBr;
    public int dBs;
    public String dJA;

    public AppBrandExportUrlParams(String str, int i) {
        this(str, i, SQLiteDatabase.KeyEmpty, -1, -1);
    }

    public AppBrandExportUrlParams(String str, int i, String str2, int i2, int i3) {
        this.appId = str;
        this.cPY = i;
        this.dJA = str2;
        this.dBr = i2;
        this.dBs = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.cPY);
        parcel.writeString(this.dJA);
        parcel.writeInt(this.dBr);
        parcel.writeInt(this.dBs);
    }

    protected AppBrandExportUrlParams(Parcel parcel) {
        this.appId = parcel.readString();
        this.cPY = parcel.readInt();
        this.dJA = parcel.readString();
        this.dBr = parcel.readInt();
        this.dBs = parcel.readInt();
    }

    public String toString() {
        return "AppBrandExportUrlParams{appId='" + this.appId + '\'' + ", from=" + this.cPY + ", pageId='" + this.dJA + '\'' + ", pkgDebugType=" + this.dBr + ", pkgVersion=" + this.dBs + '}';
    }
}
