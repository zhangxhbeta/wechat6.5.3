package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DeleteDataItemsResponse implements SafeParcelable {
    public static final Creator<DeleteDataItemsResponse> CREATOR = new g();
    public final int aFb;
    public final int statusCode;
    public final int versionCode;

    DeleteDataItemsResponse(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.aFb = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel);
    }
}
