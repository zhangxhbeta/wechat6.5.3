package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AmsEntityUpdateParcelable implements SafeParcelable {
    public static final Creator<AmsEntityUpdateParcelable> CREATOR = new at();
    byte aEJ;
    final byte aEK;
    final String mValue;
    final int mVersionCode;

    AmsEntityUpdateParcelable(int i, byte b, byte b2, String str) {
        this.aEJ = b;
        this.mVersionCode = i;
        this.aEK = b2;
        this.mValue = str;
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
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) obj;
        return this.aEJ != amsEntityUpdateParcelable.aEJ ? false : this.mVersionCode != amsEntityUpdateParcelable.mVersionCode ? false : this.aEK != amsEntityUpdateParcelable.aEK ? false : this.mValue.equals(amsEntityUpdateParcelable.mValue);
    }

    public int hashCode() {
        return (((((this.mVersionCode * 31) + this.aEJ) * 31) + this.aEK) * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + this.aEJ + ", mAttributeId=" + this.aEK + ", mValue='" + this.mValue + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        at.a(this, parcel);
    }
}
