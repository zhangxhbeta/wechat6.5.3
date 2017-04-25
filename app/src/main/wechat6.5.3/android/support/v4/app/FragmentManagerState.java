package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new Creator<FragmentManagerState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };
    FragmentState[] qD;
    int[] qE;
    BackStackState[] qF;

    public FragmentManagerState(Parcel parcel) {
        this.qD = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.qE = parcel.createIntArray();
        this.qF = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.qD, i);
        parcel.writeIntArray(this.qE);
        parcel.writeTypedArray(this.qF, i);
    }
}
