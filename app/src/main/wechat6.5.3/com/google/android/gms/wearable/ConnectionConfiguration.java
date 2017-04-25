package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class ConnectionConfiguration implements SafeParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR = new t();
    final String aDU;
    final int aDV;
    final boolean aDW;
    String aDX;
    boolean aDY;
    String aDZ;
    boolean aga;
    final int amO;
    final String mName;
    final int mVersionCode;

    ConnectionConfiguration(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3, boolean z3, String str4) {
        this.mVersionCode = i;
        this.mName = str;
        this.aDU = str2;
        this.amO = i2;
        this.aDV = i3;
        this.aDW = z;
        this.aga = z2;
        this.aDX = str3;
        this.aDY = z3;
        this.aDZ = str4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return v.d(Integer.valueOf(this.mVersionCode), Integer.valueOf(connectionConfiguration.mVersionCode)) && v.d(this.mName, connectionConfiguration.mName) && v.d(this.aDU, connectionConfiguration.aDU) && v.d(Integer.valueOf(this.amO), Integer.valueOf(connectionConfiguration.amO)) && v.d(Integer.valueOf(this.aDV), Integer.valueOf(connectionConfiguration.aDV)) && v.d(Boolean.valueOf(this.aDW), Boolean.valueOf(connectionConfiguration.aDW)) && v.d(Boolean.valueOf(this.aDY), Boolean.valueOf(connectionConfiguration.aDY));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersionCode), this.mName, this.aDU, Integer.valueOf(this.amO), Integer.valueOf(this.aDV), Boolean.valueOf(this.aDW), Boolean.valueOf(this.aDY)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.aDU);
        stringBuilder.append(", mType=" + this.amO);
        stringBuilder.append(", mRole=" + this.aDV);
        stringBuilder.append(", mEnabled=" + this.aDW);
        stringBuilder.append(", mIsConnected=" + this.aga);
        stringBuilder.append(", mPeerNodeId=" + this.aDX);
        stringBuilder.append(", mBtlePriority=" + this.aDY);
        stringBuilder.append(", mNodeId=" + this.aDZ);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        t.a(this, parcel);
    }
}
