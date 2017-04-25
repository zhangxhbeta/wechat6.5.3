package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.k;

public class MessageEventParcelable implements SafeParcelable, k {
    public static final Creator<MessageEventParcelable> CREATOR = new aa();
    final byte[] aDR;
    final String aEZ;
    final int aFo;
    final String azi;
    final int mVersionCode;

    MessageEventParcelable(int i, int i2, String str, byte[] bArr, String str2) {
        this.mVersionCode = i;
        this.aFo = i2;
        this.aEZ = str;
        this.aDR = bArr;
        this.azi = str2;
    }

    public int describeContents() {
        return 0;
    }

    public final byte[] getData() {
        return this.aDR;
    }

    public final String getPath() {
        return this.aEZ;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.aFo + "," + this.aEZ + ", size=" + (this.aDR == null ? "null" : Integer.valueOf(this.aDR.length)) + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        aa.a(this, parcel);
    }
}
