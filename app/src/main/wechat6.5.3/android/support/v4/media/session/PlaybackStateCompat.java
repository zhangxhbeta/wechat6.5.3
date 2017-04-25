package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new Creator<PlaybackStateCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    private final Bundle mExtras;
    private final int mState;
    private final long uL;
    private final long uM;
    private final float uN;
    private final long uO;
    private final CharSequence uP;
    private final long uQ;
    private List<CustomAction> uR;
    private final long uS;

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new Creator<CustomAction>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CustomAction[i];
            }
        };
        private final Bundle mExtras;
        private final String uT;
        private final CharSequence uU;
        private final int uV;

        private CustomAction(Parcel parcel) {
            this.uT = parcel.readString();
            this.uU = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.uV = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.uT);
            TextUtils.writeToParcel(this.uU, parcel, i);
            parcel.writeInt(this.uV);
            parcel.writeBundle(this.mExtras);
        }

        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + this.uU + ", mIcon=" + this.uV + ", mExtras=" + this.mExtras;
        }
    }

    private PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.uL = parcel.readLong();
        this.uN = parcel.readFloat();
        this.uQ = parcel.readLong();
        this.uM = parcel.readLong();
        this.uO = parcel.readLong();
        this.uP = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.uR = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.uS = parcel.readLong();
        this.mExtras = parcel.readBundle();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.mState);
        stringBuilder.append(", position=").append(this.uL);
        stringBuilder.append(", buffered position=").append(this.uM);
        stringBuilder.append(", speed=").append(this.uN);
        stringBuilder.append(", updated=").append(this.uQ);
        stringBuilder.append(", actions=").append(this.uO);
        stringBuilder.append(", error=").append(this.uP);
        stringBuilder.append(", custom actions=").append(this.uR);
        stringBuilder.append(", active item id=").append(this.uS);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.uL);
        parcel.writeFloat(this.uN);
        parcel.writeLong(this.uQ);
        parcel.writeLong(this.uM);
        parcel.writeLong(this.uO);
        TextUtils.writeToParcel(this.uP, parcel, i);
        parcel.writeTypedList(this.uR);
        parcel.writeLong(this.uS);
        parcel.writeBundle(this.mExtras);
    }
}
