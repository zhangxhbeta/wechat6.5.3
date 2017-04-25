package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInStatusResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncOptInStatusResponse> CREATOR = new m();
    public final boolean aFg;
    public final boolean aFh;
    public final int statusCode;
    public final int versionCode;

    GetCloudSyncOptInStatusResponse(int i, int i2, boolean z, boolean z2) {
        this.versionCode = i;
        this.statusCode = i2;
        this.aFg = z;
        this.aFh = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        m.a(this, parcel);
    }
}
