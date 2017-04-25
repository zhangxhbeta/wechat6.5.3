package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;

public class Authen implements Parcelable {
    public static final Creator<Authen> CREATOR = new Creator<Authen>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Authen(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Authen[i];
        }
    };
    public String bCc;
    public String bCk;
    public String bCl;
    public int bkU;
    public String cJf;
    public String cJg;
    public String dxo;
    public String hMt;
    public String hMu;
    public PayInfo imN = new PayInfo();
    public String kGo;
    public String kLp;
    public int kMQ = 0;
    public String kMR;
    public String kMS;
    public String kMT;
    public int kMU;
    public String kMV;
    public String kMW;
    public String kMX;
    public String kMY;
    public String kMZ;
    public String kNa;
    public String kNb;
    public String kNc;
    public String kNd;
    public String kNe;
    public String kNf;
    public String kNg;
    public String kNh;
    public String kNi;
    public String token;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bkU);
        parcel.writeString(be.ah(this.kMR, ""));
        parcel.writeString(be.ah(this.hMt, ""));
        parcel.writeString(be.ah(this.hMu, ""));
        parcel.writeString(be.ah(this.kMS, ""));
        parcel.writeString(be.ah(this.kMT, ""));
        parcel.writeInt(this.kMU);
        parcel.writeString(be.ah(this.kLp, ""));
        parcel.writeString(be.ah(this.kMV, ""));
        parcel.writeString(be.ah(this.kMW, ""));
        parcel.writeString(be.ah(this.kMX, ""));
        parcel.writeString(be.ah(this.token, ""));
        parcel.writeString(be.ah(this.kNa, ""));
        parcel.writeString(be.ah(this.kNb, ""));
        parcel.writeString(be.ah(this.cJg, ""));
        parcel.writeString(be.ah(this.bCk, ""));
        parcel.writeString(be.ah(this.bCl, ""));
        parcel.writeString(be.ah(this.cJf, ""));
        parcel.writeString(be.ah(this.kNc, ""));
        parcel.writeString(be.ah(this.dxo, ""));
        parcel.writeString(be.ah(this.bCc, ""));
        parcel.writeString(be.ah(this.kGo, ""));
        parcel.writeString(be.ah(this.kNd, ""));
        parcel.writeString(be.ah(this.kNe, ""));
        parcel.writeString(be.ah(this.kMZ, ""));
        parcel.writeString(be.ah(this.kNf, ""));
        parcel.writeString(be.ah(this.kNg, ""));
        parcel.writeString(be.ah(this.kNh, ""));
        parcel.writeString(be.ah(this.kNi, ""));
    }

    public Authen(Parcel parcel) {
        this.bkU = parcel.readInt();
        this.kMR = parcel.readString();
        this.hMt = parcel.readString();
        this.hMu = parcel.readString();
        this.kMS = parcel.readString();
        this.kMT = parcel.readString();
        this.kMU = parcel.readInt();
        this.kLp = parcel.readString();
        this.kMV = parcel.readString();
        this.kMW = parcel.readString();
        this.kMX = parcel.readString();
        this.token = parcel.readString();
        this.kNa = parcel.readString();
        this.kNb = parcel.readString();
        this.cJg = parcel.readString();
        this.bCk = parcel.readString();
        this.bCl = parcel.readString();
        this.cJf = parcel.readString();
        this.kNc = parcel.readString();
        this.dxo = parcel.readString();
        this.bCc = parcel.readString();
        this.kGo = parcel.readString();
        this.kNd = parcel.readString();
        this.kNe = parcel.readString();
        this.kMZ = parcel.readString();
        this.kNf = parcel.readString();
        this.kNg = parcel.readString();
        this.kNh = parcel.readString();
        this.kNi = parcel.readString();
    }
}
