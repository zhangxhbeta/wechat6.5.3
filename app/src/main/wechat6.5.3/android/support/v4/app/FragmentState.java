package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new Creator<FragmentState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentState[i];
        }
    };
    final int mIndex;
    Bundle oG;
    final Bundle oJ;
    final boolean oP;
    final int oX;
    final int oY;
    final String oZ;
    final boolean pb;
    final boolean pc;
    final String qG;
    Fragment qH;

    public FragmentState(Fragment fragment) {
        this.qG = fragment.getClass().getName();
        this.mIndex = fragment.mIndex;
        this.oP = fragment.oP;
        this.oX = fragment.oX;
        this.oY = fragment.oY;
        this.oZ = fragment.oZ;
        this.pc = fragment.pc;
        this.pb = fragment.pb;
        this.oJ = fragment.oJ;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.qG = parcel.readString();
        this.mIndex = parcel.readInt();
        this.oP = parcel.readInt() != 0;
        this.oX = parcel.readInt();
        this.oY = parcel.readInt();
        this.oZ = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.pc = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.pb = z2;
        this.oJ = parcel.readBundle();
        this.oG = parcel.readBundle();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.qG);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.oP ? 1 : 0);
        parcel.writeInt(this.oX);
        parcel.writeInt(this.oY);
        parcel.writeString(this.oZ);
        if (this.pc) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.pb) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.oJ);
        parcel.writeBundle(this.oG);
    }
}
