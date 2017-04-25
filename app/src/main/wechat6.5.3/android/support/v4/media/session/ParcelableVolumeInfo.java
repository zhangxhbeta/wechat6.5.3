package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new Creator<ParcelableVolumeInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    };
    public int uG;
    public int uH;
    public int uI;
    public int uJ;
    public int uK;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.uG = parcel.readInt();
        this.uI = parcel.readInt();
        this.uJ = parcel.readInt();
        this.uK = parcel.readInt();
        this.uH = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uG);
        parcel.writeInt(this.uI);
        parcel.writeInt(this.uJ);
        parcel.writeInt(this.uK);
        parcel.writeInt(this.uH);
    }
}
