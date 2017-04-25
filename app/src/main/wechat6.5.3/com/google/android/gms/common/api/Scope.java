package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR = new s();
    final String akZ;
    final int mVersionCode;

    Scope(int i, String str) {
        w.i(str, "scopeUri must not be null or empty");
        this.mVersionCode = i;
        this.akZ = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.akZ.equals(((Scope) obj).akZ);
    }

    public final int hashCode() {
        return this.akZ.hashCode();
    }

    public final String toString() {
        return this.akZ;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        s.a(this, parcel);
    }
}
