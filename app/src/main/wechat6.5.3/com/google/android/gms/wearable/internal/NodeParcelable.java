package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.l;

public class NodeParcelable implements SafeParcelable, l {
    public static final Creator<NodeParcelable> CREATOR = new ad();
    final String aBs;
    final int aFp;
    final boolean aFq;
    final String afy;
    final int mVersionCode;

    NodeParcelable(int i, String str, String str2, int i2, boolean z) {
        this.mVersionCode = i;
        this.afy = str;
        this.aBs = str2;
        this.aFp = i2;
        this.aFq = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof NodeParcelable) ? false : ((NodeParcelable) obj).afy.equals(this.afy);
    }

    public final String getId() {
        return this.afy;
    }

    public int hashCode() {
        return this.afy.hashCode();
    }

    public String toString() {
        return "Node{" + this.aBs + ", id=" + this.afy + ", hops=" + this.aFp + ", isNearby=" + this.aFq + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        ad.a(this, parcel);
    }
}
