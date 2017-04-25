package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.g;

public class DataItemAssetParcelable implements SafeParcelable, g {
    public static final Creator<DataItemAssetParcelable> CREATOR = new b();
    final String afy;
    final String ayh;
    final int mVersionCode;

    DataItemAssetParcelable(int i, String str, String str2) {
        this.mVersionCode = i;
        this.afy = str;
        this.ayh = str2;
    }

    public DataItemAssetParcelable(g gVar) {
        this.mVersionCode = 1;
        this.afy = (String) w.Z(gVar.getId());
        this.ayh = (String) w.Z(gVar.mz());
    }

    public int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.afy;
    }

    public final /* synthetic */ Object jH() {
        return this;
    }

    public final String mz() {
        return this.ayh;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.afy == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.afy);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.ayh);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
