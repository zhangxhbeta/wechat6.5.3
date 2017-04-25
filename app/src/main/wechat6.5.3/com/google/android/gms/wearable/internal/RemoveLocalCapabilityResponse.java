package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RemoveLocalCapabilityResponse implements SafeParcelable {
    public static final Creator<RemoveLocalCapabilityResponse> CREATOR = new ai();
    public final int statusCode;
    public final int versionCode;

    RemoveLocalCapabilityResponse(int i, int i2) {
        this.versionCode = i;
        this.statusCode = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ai.a(this, parcel);
    }
}
