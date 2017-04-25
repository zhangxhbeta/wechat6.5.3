package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetConnectedNodesResponse implements SafeParcelable {
    public static final Creator<GetConnectedNodesResponse> CREATOR = new q();
    public final List<NodeParcelable> aFk;
    public final int statusCode;
    public final int versionCode;

    GetConnectedNodesResponse(int i, int i2, List<NodeParcelable> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.aFk = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        q.a(this, parcel);
    }
}
