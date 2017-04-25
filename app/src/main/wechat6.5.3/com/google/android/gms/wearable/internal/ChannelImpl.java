package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Channel;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new bb();
    final String aDZ;
    final String aEY;
    final String aEZ;
    final int mVersionCode;

    ChannelImpl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.aEY = (String) w.Z(str);
        this.aDZ = (String) w.Z(str2);
        this.aEZ = (String) w.Z(str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.aEY.equals(channelImpl.aEY) && v.d(channelImpl.aDZ, this.aDZ) && v.d(channelImpl.aEZ, this.aEZ) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public int hashCode() {
        return this.aEY.hashCode();
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.aEY + '\'' + ", nodeId='" + this.aDZ + '\'' + ", path='" + this.aEZ + '\'' + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        bb.a(this, parcel);
    }
}
