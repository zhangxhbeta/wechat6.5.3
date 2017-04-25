package com.tencent.mm.ui.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class Snack implements Parcelable {
    public static final Creator<Snack> CREATOR = new Creator<Snack>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Snack(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Snack[i];
        }
    };
    final String mMessage;
    final String oPS;
    final int oPT;
    final Parcelable oPU;
    final short oPV;
    final int oPW;

    Snack(String str, String str2, int i, Parcelable parcelable, short s, int i2) {
        this.mMessage = str;
        this.oPS = str2;
        this.oPT = i;
        this.oPU = parcelable;
        this.oPV = s;
        this.oPW = i2;
    }

    Snack(Parcel parcel) {
        this.mMessage = parcel.readString();
        this.oPS = parcel.readString();
        this.oPT = parcel.readInt();
        this.oPU = parcel.readParcelable(parcel.getClass().getClassLoader());
        this.oPV = (short) parcel.readInt();
        this.oPW = ((Integer) parcel.readParcelable(parcel.getClass().getClassLoader())).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMessage);
        parcel.writeString(this.oPS);
        parcel.writeInt(this.oPT);
        parcel.writeParcelable(this.oPU, 0);
        parcel.writeInt(this.oPV);
        parcel.writeInt(this.oPW);
    }

    public int describeContents() {
        return 0;
    }
}
