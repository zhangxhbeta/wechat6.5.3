package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.v;

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Location location = new Location();
            location.cJq = parcel.readFloat();
            location.cJr = parcel.readFloat();
            location.accuracy = parcel.readInt();
            location.biJ = parcel.readInt();
            location.mac = parcel.readString();
            location.biL = parcel.readString();
            return location;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Location[i];
        }
    };
    public int accuracy;
    public int biJ;
    public String biL;
    public float cJq;
    public float cJr;
    public String mac;

    public Location(float f, float f2, int i, int i2, String str, String str2) {
        this.cJq = f;
        this.cJr = f2;
        this.accuracy = i;
        this.biJ = i2;
        this.mac = str;
        this.biL = str2;
    }

    public final boolean bnO() {
        if (this.cJq != -1000.0f && this.cJr != -1000.0f) {
            return false;
        }
        v.d("MicroMsg.Radar.Location", "mac and cellId is null");
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.cJq);
        parcel.writeFloat(this.cJr);
        parcel.writeInt(this.accuracy);
        parcel.writeInt(this.biJ);
        parcel.writeString(this.mac);
        parcel.writeString(this.biL);
    }
}
