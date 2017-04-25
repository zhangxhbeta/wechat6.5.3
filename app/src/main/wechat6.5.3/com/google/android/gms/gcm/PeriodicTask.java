package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new Creator<PeriodicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PeriodicTask(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return new PeriodicTask[i];
        }
    };
    protected long arw;
    protected long arx;

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.arw = -1;
        this.arx = -1;
        this.arw = parcel.readLong();
        this.arx = parcel.readLong();
    }

    public String toString() {
        return super.toString() + " period=" + this.arw + " flex=" + this.arx;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.arw);
        parcel.writeLong(this.arx);
    }
}
