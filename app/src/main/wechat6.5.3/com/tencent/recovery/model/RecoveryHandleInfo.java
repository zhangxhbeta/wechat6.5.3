package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RecoveryHandleInfo implements Parcelable {
    public static final Creator<RecoveryHandleInfo> CREATOR = new Creator<RecoveryHandleInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryHandleInfo recoveryHandleInfo = new RecoveryHandleInfo();
            recoveryHandleInfo.puk = parcel.readInt();
            recoveryHandleInfo.processName = parcel.readString();
            recoveryHandleInfo.versionCode = parcel.readInt();
            recoveryHandleInfo.versionName = parcel.readString();
            recoveryHandleInfo.pul = parcel.readArrayList(RecoveryExceptionItem.class.getClassLoader());
            recoveryHandleInfo.pud = parcel.readString();
            return recoveryHandleInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryHandleInfo[i];
        }
    };
    public String processName;
    public String pud;
    public int puk;
    public List<RecoveryExceptionItem> pul;
    public int versionCode;
    public String versionName;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.puk);
        parcel.writeString(this.processName);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeList(this.pul);
        parcel.writeString(this.pud);
    }
}
