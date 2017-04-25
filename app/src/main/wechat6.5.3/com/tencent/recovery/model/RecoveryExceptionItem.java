package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RecoveryExceptionItem implements Parcelable {
    public static final Creator<RecoveryExceptionItem> CREATOR = new Creator<RecoveryExceptionItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            RecoveryExceptionItem recoveryExceptionItem = new RecoveryExceptionItem();
            if (parcel.readInt() != 1) {
                z = false;
            }
            recoveryExceptionItem.pua = z;
            recoveryExceptionItem.type = parcel.readInt();
            recoveryExceptionItem.dyp = parcel.readInt();
            return recoveryExceptionItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryExceptionItem[i];
        }
    };
    public int dyp;
    public boolean pua;
    public int type;

    public String toString() {
        return this.pua + ";" + this.dyp + ";" + this.type;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pua ? 1 : 0);
        parcel.writeInt(this.type);
        parcel.writeInt(this.dyp);
    }
}
