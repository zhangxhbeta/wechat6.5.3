package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ElementQuery implements Parcelable {
    public static final Creator<ElementQuery> CREATOR = new Creator<ElementQuery>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ElementQuery(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ElementQuery[i];
        }
    };
    public static String kNR = "bind_serial";
    public JSONObject cBx;
    public String hMt;
    public String hMu;
    public int kLu;
    public String kMZ;
    public String kNS;
    public String kNT;
    public boolean kNU;
    public boolean kNV;
    public boolean kNW;
    public boolean kNX;
    public String kNY;
    public boolean kNZ;
    public int kOa;
    public int kOb;
    public String kOc;
    public String kOd;
    public String kOe;
    public String kOf;
    public String kOg;
    public String kOh;
    public boolean kOi;
    public boolean kOj;
    public boolean kOk;
    public boolean kOl;
    public boolean kOm;
    public boolean kOn;
    public boolean kOo;
    public boolean kOp;
    public boolean kOq;
    public String kOr;
    private List<Integer> kOs = null;
    public boolean kOt;
    public boolean kOu = false;

    public final boolean isError() {
        return "0".equals(be.ah(this.kOd, "").trim());
    }

    public final boolean bfM() {
        return 1 == this.kOb;
    }

    public final List<Integer> bfN() {
        this.kOr = "1|2|5|9";
        if (this.kOs != null) {
            return this.kOs;
        }
        if (be.kS(this.kOr)) {
            return null;
        }
        this.kOs = new ArrayList();
        for (String str : this.kOr.split("\\|")) {
            int i = be.getInt(str, 0);
            if (i > 0) {
                this.kOs.add(Integer.valueOf(i));
            }
        }
        return this.kOs;
    }

    public ElementQuery(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.hMu = parcel.readString();
        this.kNS = parcel.readString();
        this.kNT = parcel.readString();
        this.kNU = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kNV = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kNW = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kNX = z;
        this.kNY = parcel.readString();
        this.hMu = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kNZ = z;
        this.kOa = parcel.readInt();
        this.kOb = parcel.readInt();
        this.hMt = parcel.readString();
        this.kOc = parcel.readString();
        this.kOd = parcel.readString();
        this.kOe = parcel.readString();
        this.kOh = parcel.readString();
        this.kOg = parcel.readString();
        this.kOf = parcel.readString();
        this.kOi = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOj = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOk = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOl = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOm = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOn = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOp = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOo = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOq = z;
        this.kLu = parcel.readInt();
        this.kOr = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.kOu = z;
        this.kMZ = parcel.readString();
        if (1 != parcel.readInt()) {
            z2 = false;
        }
        this.kOt = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(be.ah(this.hMu, ""));
        parcel.writeString(be.ah(this.kNS, ""));
        parcel.writeString(be.ah(this.kNT, ""));
        parcel.writeInt(this.kNU ? 1 : 0);
        if (this.kNV) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kNW) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kNX) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(be.ah(this.kNY, ""));
        parcel.writeString(be.ah(this.hMu, ""));
        if (this.kNZ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.kOa);
        parcel.writeInt(this.kOb);
        parcel.writeString(be.ah(this.hMt, ""));
        parcel.writeString(be.ah(this.kOc, ""));
        parcel.writeString(be.ah(this.kOd, ""));
        parcel.writeString(be.ah(this.kOe, ""));
        parcel.writeString(be.ah(this.kOh, ""));
        parcel.writeString(be.ah(this.kOg, ""));
        parcel.writeString(be.ah(this.kOf, ""));
        parcel.writeInt(this.kOi ? 1 : 0);
        if (this.kOj) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kOk) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kOl) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kOm) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kOn) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kOp) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kOo) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.kOq) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.kLu);
        parcel.writeString(this.kOr);
        if (this.kOu) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.kMZ);
        if (!this.kOt) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
