package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInOutDoneResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncOptInOutDoneResponse> CREATOR = new l();
    public final boolean aFf;
    public final int statusCode;
    public final int versionCode;

    GetCloudSyncOptInOutDoneResponse(int i, int i2, boolean z) {
        this.versionCode = i;
        this.statusCode = i2;
        this.aFf = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        l.a(this, parcel);
    }
}
