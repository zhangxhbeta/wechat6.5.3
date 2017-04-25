package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class WloginLoginInfo implements Parcelable, Serializable {
    public static final Creator<WloginLoginInfo> CREATOR = new Creator<WloginLoginInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WloginLoginInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WloginLoginInfo[i];
        }
    };
    public static int TYPE_LOACL = 1;
    public static int TYPE_REMOTE = 2;
    private static final long serialVersionUID = 5551948389726789420L;
    public String mAccount;
    public long mAppid;
    public long mCreateTime;
    public int mType;
    public long mUin;

    public WloginLoginInfo(String str, long j, long j2, long j3, int i) {
        this.mAccount = str;
        this.mUin = j;
        this.mAppid = j2;
        this.mCreateTime = j3;
        this.mType = i;
    }

    private WloginLoginInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAccount);
        parcel.writeLong(this.mUin);
        parcel.writeLong(this.mAppid);
        parcel.writeLong(this.mCreateTime);
        parcel.writeInt(this.mType);
    }

    public void readFromParcel(Parcel parcel) {
        this.mAccount = parcel.readString();
        this.mUin = parcel.readLong();
        this.mAppid = parcel.readLong();
        this.mCreateTime = parcel.readLong();
        this.mType = parcel.readInt();
    }
}
