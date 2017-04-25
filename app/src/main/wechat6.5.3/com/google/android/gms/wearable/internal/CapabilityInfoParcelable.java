package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.l;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable {
    public static final Creator<CapabilityInfoParcelable> CREATOR = new ay();
    final List<NodeParcelable> aET;
    private Set<l> aEU;
    private final Object aoG = new Object();
    final String mName;
    final int mVersionCode;

    CapabilityInfoParcelable(int i, String str, List<NodeParcelable> list) {
        this.mVersionCode = i;
        this.mName = str;
        this.aET = list;
        this.aEU = null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) obj;
        if (this.mVersionCode != capabilityInfoParcelable.mVersionCode) {
            return false;
        }
        if (this.mName == null ? capabilityInfoParcelable.mName != null : !this.mName.equals(capabilityInfoParcelable.mName)) {
            return false;
        }
        if (this.aET != null) {
            if (this.aET.equals(capabilityInfoParcelable.aET)) {
                return true;
            }
        } else if (capabilityInfoParcelable.aET == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.mName != null ? this.mName.hashCode() : 0) + (this.mVersionCode * 31)) * 31;
        if (this.aET != null) {
            i = this.aET.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.aET + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        ay.a(this, parcel);
    }
}
