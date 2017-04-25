package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AddLocalCapabilityResponse implements SafeParcelable {
    public static final Creator<AddLocalCapabilityResponse> CREATOR = new ar();
    public final int statusCode;
    public final int versionCode;

    AddLocalCapabilityResponse(int i, int i2) {
        this.versionCode = i;
        this.statusCode = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ar.a(this, parcel);
    }
}
