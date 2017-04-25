package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mmdb.database.SQLiteDatabase;

public class PayInfo implements Parcelable {
    public static final Creator<PayInfo> CREATOR = new Creator<PayInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PayInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PayInfo[i];
        }
    };
    public String aZD;
    public String appId;
    public int bfq;
    public String bfs;
    public String bft;
    public String biS;
    public String bjV = SQLiteDatabase.KeyEmpty;
    public int bkh;
    public String bkj;
    public int bkq = 0;
    public int bkr = -1;
    public String fTG;
    public String gjT;
    public String kXn;
    public boolean lVA = true;
    public String lVB;
    public String lVC;
    public Bundle lVD;
    public int lVE = 0;
    public int lVF = 0;
    public int lVG;
    public long lVH = 0;
    public int lVI = -1;
    public String lVJ;
    public String lVK;
    public int lVy = 0;
    public boolean lVz = false;

    public PayInfo(Parcel parcel) {
        boolean z = true;
        this.bkq = parcel.readInt();
        this.lVy = parcel.readInt();
        this.fTG = parcel.readString();
        this.gjT = parcel.readString();
        this.appId = parcel.readString();
        this.kXn = parcel.readString();
        this.bkj = parcel.readString();
        this.lVB = parcel.readString();
        this.aZD = parcel.readString();
        this.biS = parcel.readString();
        this.bkh = parcel.readInt();
        this.bkr = parcel.readInt();
        this.lVz = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.lVA = z;
        this.lVD = parcel.readBundle();
        this.lVE = parcel.readInt();
        this.bfs = parcel.readString();
        this.bft = parcel.readString();
        this.bfq = parcel.readInt();
        this.lVH = parcel.readLong();
        this.bjV = parcel.readString();
        this.lVJ = parcel.readString();
        this.lVK = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.bkq);
        parcel.writeInt(this.lVy);
        parcel.writeString(this.fTG);
        parcel.writeString(this.gjT);
        parcel.writeString(this.appId);
        parcel.writeString(this.kXn);
        parcel.writeString(this.bkj);
        parcel.writeString(this.lVB);
        parcel.writeString(this.aZD);
        parcel.writeString(this.biS);
        parcel.writeInt(this.bkh);
        parcel.writeInt(this.bkr);
        parcel.writeInt(this.lVz ? 1 : 0);
        if (!this.lVA) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.lVD);
        parcel.writeInt(this.lVE);
        parcel.writeString(this.bfs);
        parcel.writeString(this.bft);
        parcel.writeInt(this.bfq);
        parcel.writeLong(this.lVH);
        parcel.writeString(this.bjV);
        parcel.writeString(this.lVJ);
        parcel.writeString(this.lVK);
    }

    public String toString() {
        return String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[]{Integer.valueOf(this.bkq), this.fTG, this.gjT, this.appId, this.kXn, this.bkj, this.lVB, this.aZD, this.bjV});
    }
}
