package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new Creator<OneoffTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OneoffTask(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return new OneoffTask[i];
        }
    };
    private final long aru;
    private final long arv;

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.aru = parcel.readLong();
        this.arv = parcel.readLong();
    }

    public String toString() {
        return super.toString() + " windowStart=" + this.aru + " windowEnd=" + this.arv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.aru);
        parcel.writeLong(this.arv);
    }
}
