package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new Creator<RatingCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    private final int uB;
    private final float uC;

    private RatingCompat(int i, float f) {
        this.uB = i;
        this.uC = f;
    }

    public final String toString() {
        return "Rating:style=" + this.uB + " rating=" + (this.uC < 0.0f ? "unrated" : String.valueOf(this.uC));
    }

    public final int describeContents() {
        return this.uB;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uB);
        parcel.writeFloat(this.uC);
    }
}
