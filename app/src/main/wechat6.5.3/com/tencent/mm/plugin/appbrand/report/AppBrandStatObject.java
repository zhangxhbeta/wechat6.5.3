package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandStatObject implements Parcelable {
    public static final Creator<AppBrandStatObject> CREATOR = new Creator<AppBrandStatObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandStatObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandStatObject[i];
        }
    };
    public String aWP;
    public String aZj;
    public String appId;
    public int bpy;
    public int dJB;
    public String dJz;
    public long dOa;
    public String dPB;
    public int dPC;
    public boolean dPO = true;
    public long dPP;
    public int dPQ;
    public long dPR;
    public String dPS;
    public String dPT;
    public boolean isInit = false;
    public int scene;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        parcel.writeString(this.appId);
        parcel.writeInt(this.scene);
        parcel.writeString(this.aWP);
        parcel.writeString(this.aZj);
        parcel.writeInt(this.bpy);
        parcel.writeInt(this.dJB);
        parcel.writeInt(this.dPC);
        parcel.writeString(this.dPB);
        parcel.writeByte(this.dPO ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.dPP);
        parcel.writeInt(this.dPQ);
        parcel.writeLong(this.dPR);
        parcel.writeString(this.dPS);
        parcel.writeString(this.dPT);
        if (!this.isInit) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.dJz);
        parcel.writeLong(this.dOa);
    }

    protected AppBrandStatObject(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.scene = parcel.readInt();
        this.aWP = parcel.readString();
        this.aZj = parcel.readString();
        this.bpy = parcel.readInt();
        this.dJB = parcel.readInt();
        this.dPC = parcel.readInt();
        this.dPB = parcel.readString();
        this.dPO = parcel.readByte() != (byte) 0;
        this.dPP = parcel.readLong();
        this.dPQ = parcel.readInt();
        this.dPR = parcel.readLong();
        this.dPS = parcel.readString();
        this.dPT = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.isInit = z;
        this.dJz = parcel.readString();
        this.dOa = parcel.readLong();
    }
}
