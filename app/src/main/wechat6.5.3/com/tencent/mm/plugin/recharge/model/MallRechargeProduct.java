package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallRechargeProduct implements Parcelable {
    public static final Creator<MallRechargeProduct> CREATOR = new Creator<MallRechargeProduct>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallRechargeProduct(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallRechargeProduct[i];
        }
    };
    public String aZD;
    public String appId;
    public String fkg;
    public String imm;
    public String imn;
    public float imo = 0.0f;
    public float imp = 0.0f;
    public boolean imq;
    public int imr;
    public int ims;
    public int imt;
    public final boolean imu;
    public boolean imv = true;
    public boolean isDefault;

    public MallRechargeProduct(boolean z) {
        this.imu = z;
    }

    public final boolean isValid() {
        if (!this.imq || this.imr > 0) {
            return true;
        }
        return false;
    }

    public static void a(MallRechargeProduct mallRechargeProduct, MallRechargeProduct mallRechargeProduct2) {
        mallRechargeProduct2.appId = mallRechargeProduct.appId;
        mallRechargeProduct2.imm = mallRechargeProduct.imm;
        mallRechargeProduct2.aZD = mallRechargeProduct.aZD;
        mallRechargeProduct2.fkg = mallRechargeProduct.fkg;
        mallRechargeProduct2.imn = mallRechargeProduct.imn;
        mallRechargeProduct2.imo = mallRechargeProduct.imo;
        mallRechargeProduct2.imp = mallRechargeProduct.imp;
        mallRechargeProduct2.imq = mallRechargeProduct.imq;
        mallRechargeProduct2.imr = mallRechargeProduct.imr;
        mallRechargeProduct2.ims = mallRechargeProduct.ims;
        mallRechargeProduct2.isDefault = mallRechargeProduct.isDefault;
        mallRechargeProduct2.imv = mallRechargeProduct.imv;
        mallRechargeProduct2.imt = mallRechargeProduct.imt;
    }

    public int describeContents() {
        return 0;
    }

    public MallRechargeProduct(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.imm = parcel.readString();
        this.appId = parcel.readString();
        this.aZD = parcel.readString();
        this.fkg = parcel.readString();
        this.imn = parcel.readString();
        this.imo = parcel.readFloat();
        this.imp = parcel.readFloat();
        this.imq = parcel.readInt() == 1;
        this.imr = parcel.readInt();
        this.ims = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDefault = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.imu = z2;
        this.imt = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.imm);
        parcel.writeString(this.appId);
        parcel.writeString(this.aZD);
        parcel.writeString(this.fkg);
        parcel.writeString(this.imn);
        parcel.writeFloat(this.imo);
        parcel.writeFloat(this.imp);
        parcel.writeInt(this.imq ? 1 : 0);
        parcel.writeInt(this.imr);
        parcel.writeInt(this.ims);
        if (this.isDefault) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.imu) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.imt);
    }
}
