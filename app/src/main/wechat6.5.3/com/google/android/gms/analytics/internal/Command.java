package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR = new Creator<Command>() {
        @Deprecated
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Command(parcel);
        }

        @Deprecated
        public final /* synthetic */ Object[] newArray(int i) {
            return new Command[i];
        }
    };
    String afy;
    private String afz;
    String mValue;

    @Deprecated
    Command(Parcel parcel) {
        this.afy = parcel.readString();
        this.afz = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.afy);
        parcel.writeString(this.afz);
        parcel.writeString(this.mValue);
    }
}
