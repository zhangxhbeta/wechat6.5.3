package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback implements Parcelable {
    public static final Creator<PendingCallback> CREATOR = new Creator<PendingCallback>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return new PendingCallback[i];
        }
    };
    final IBinder anH;

    public PendingCallback(Parcel parcel) {
        this.anH = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.anH);
    }
}
