package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class Task implements Parcelable {
    private final boolean arA;
    private final int arB;
    private final boolean arC;
    private final String ary;
    private final boolean arz;
    private final Bundle mExtras;
    private final String oZ;

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        this.ary = parcel.readString();
        this.oZ = parcel.readString();
        this.arz = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.arA = z;
        this.arB = 2;
        this.arC = false;
        this.mExtras = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.ary);
        parcel.writeString(this.oZ);
        parcel.writeInt(this.arz ? 1 : 0);
        if (!this.arA) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
