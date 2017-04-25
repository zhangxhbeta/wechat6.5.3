package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.be;

public class VertifyInfo implements Parcelable {
    public static final Creator<VertifyInfo> CREATOR = new Creator<VertifyInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            VertifyInfo vertifyInfo = new VertifyInfo();
            vertifyInfo.koG = parcel.readInt();
            vertifyInfo.koH = parcel.readInt();
            vertifyInfo.koI = parcel.readInt();
            vertifyInfo.kox = parcel.readInt();
            vertifyInfo.dVK = parcel.readString();
            vertifyInfo.koq = parcel.readString();
            vertifyInfo.mFileName = parcel.readString();
            vertifyInfo.koJ = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            vertifyInfo.koK = z;
            vertifyInfo.kox = vertifyInfo.koG;
            return vertifyInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VertifyInfo[i];
        }
    };
    public String dVK = "";
    public String koC = "";
    public int koG;
    public int koH;
    public int koI = 0;
    public boolean koJ = false;
    public boolean koK = false;
    public String koq = "";
    public int kox = 0;
    public String mFileName = "";

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.koG);
        parcel.writeInt(this.koH);
        parcel.writeInt(this.koI);
        parcel.writeInt(this.kox);
        parcel.writeString(be.ah(this.dVK, ""));
        parcel.writeString(be.ah(this.koq, ""));
        parcel.writeString(be.ah(this.mFileName, ""));
        if (this.koJ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.koK) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
