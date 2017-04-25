package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.lf;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;

public class SnsAdClick implements Parcelable {
    public static final Creator<SnsAdClick> CREATOR = new Creator<SnsAdClick>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            SnsAdClick snsAdClick = new SnsAdClick();
            snsAdClick.cZv = parcel.readString();
            snsAdClick.scene = parcel.readInt();
            snsAdClick.cZy = parcel.readInt();
            snsAdClick.cZw = parcel.readLong();
            snsAdClick.cZx = parcel.readString();
            snsAdClick.cZz = parcel.readLong();
            snsAdClick.cZB = parcel.readInt();
            return snsAdClick;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsAdClick[i];
        }
    };
    public int cZA = 0;
    public int cZB = 0;
    public String cZv = "";
    public long cZw = 0;
    public String cZx = "";
    public int cZy = 0;
    public long cZz = 0;
    public int scene = 0;

    public SnsAdClick(String str, int i, long j, String str2, int i2) {
        this.cZv = str;
        this.scene = i;
        this.cZw = j;
        this.cZx = str2;
        this.cZA = i2;
        this.cZB = 1;
        this.cZz = System.currentTimeMillis();
    }

    public SnsAdClick(String str, int i, long j, String str2, int i2, byte b) {
        this.cZv = str;
        this.scene = i;
        this.cZw = j;
        this.cZx = str2;
        this.cZA = i2;
        this.cZB = 0;
        this.cZz = System.currentTimeMillis();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cZv);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.cZy);
        parcel.writeLong(this.cZw);
        parcel.writeString(be.ah(this.cZx, ""));
        parcel.writeLong(this.cZz);
        parcel.writeInt(this.cZB);
    }

    public final void gg(int i) {
        lf lfVar = new lf();
        this.cZy = i;
        lfVar.bmA.bmB = this;
        a.nhr.z(lfVar);
    }
}
