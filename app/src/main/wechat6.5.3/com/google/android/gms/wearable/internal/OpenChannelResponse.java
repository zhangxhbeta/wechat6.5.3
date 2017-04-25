package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OpenChannelResponse implements SafeParcelable {
    public static final Creator<OpenChannelResponse> CREATOR = new ae();
    public final ChannelImpl aEV;
    public final int statusCode;
    public final int versionCode;

    OpenChannelResponse(int i, int i2, ChannelImpl channelImpl) {
        this.versionCode = i;
        this.statusCode = i2;
        this.aEV = channelImpl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ae.a(this, parcel, i);
    }
}
