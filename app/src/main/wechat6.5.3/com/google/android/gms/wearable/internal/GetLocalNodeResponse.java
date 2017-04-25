package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetLocalNodeResponse implements SafeParcelable {
    public static final Creator<GetLocalNodeResponse> CREATOR = new t();
    public final NodeParcelable aFn;
    public final int statusCode;
    public final int versionCode;

    GetLocalNodeResponse(int i, int i2, NodeParcelable nodeParcelable) {
        this.versionCode = i;
        this.statusCode = i2;
        this.aFn = nodeParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        t.a(this, parcel, i);
    }
}
