package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SendMessageResponse implements SafeParcelable {
    public static final Creator<SendMessageResponse> CREATOR = new aj();
    public final int arX;
    public final int statusCode;
    public final int versionCode;

    SendMessageResponse(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.arX = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        aj.a(this, parcel);
    }
}
