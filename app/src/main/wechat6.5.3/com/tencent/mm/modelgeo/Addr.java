package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.be;

public class Addr implements Parcelable {
    public static final Creator<Addr> CREATOR = new Creator<Addr>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Addr addr = new Addr();
            addr.cJf = parcel.readString();
            addr.cJg = parcel.readString();
            addr.cJh = parcel.readString();
            addr.cJi = parcel.readString();
            addr.cJj = parcel.readString();
            addr.cJk = parcel.readString();
            addr.cJl = parcel.readString();
            addr.cJm = parcel.readString();
            addr.cJn = parcel.readString();
            addr.cJo = parcel.readString();
            addr.cJp = parcel.readString();
            addr.cJq = parcel.readFloat();
            addr.cJr = parcel.readFloat();
            return addr;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Addr[i];
        }
    };
    public String cJf;
    public String cJg;
    public String cJh;
    public String cJi;
    public String cJj;
    public String cJk;
    public String cJl;
    public String cJm;
    public String cJn;
    public String cJo;
    public String cJp;
    public float cJq;
    public float cJr;
    public Object tag = "";

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("address='" + this.cJf + '\'');
        stringBuilder.append(", country='" + this.cJg + '\'');
        stringBuilder.append(", administrative_area_level_1='" + this.cJh + '\'');
        stringBuilder.append(", locality='" + this.cJi + '\'');
        stringBuilder.append(", locality_shi='" + this.cJj + '\'');
        stringBuilder.append(", sublocality='" + this.cJk + '\'');
        stringBuilder.append(", neighborhood='" + this.cJl + '\'');
        stringBuilder.append(", route='" + this.cJm + '\'');
        stringBuilder.append(", streetNum='" + this.cJn + '\'');
        stringBuilder.append(", roughAddr='" + this.cJo + '\'');
        stringBuilder.append(", poi_name='" + this.cJp + '\'');
        stringBuilder.append(", lat=" + this.cJq);
        stringBuilder.append(", lng=" + this.cJr);
        stringBuilder.append(", tag=" + this.tag);
        return stringBuilder.toString();
    }

    public final String FV() {
        return be.ah(this.cJj, "") + be.ah(this.cJk, "") + be.ah(this.cJl, "") + be.ah(this.cJm, "") + be.ah(this.cJn, "");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(be.ah(this.cJf, ""));
        parcel.writeString(be.ah(this.cJg, ""));
        parcel.writeString(be.ah(this.cJh, ""));
        parcel.writeString(be.ah(this.cJi, ""));
        parcel.writeString(be.ah(this.cJj, ""));
        parcel.writeString(be.ah(this.cJk, ""));
        parcel.writeString(be.ah(this.cJl, ""));
        parcel.writeString(be.ah(this.cJm, ""));
        parcel.writeString(be.ah(this.cJn, ""));
        parcel.writeString(be.ah(this.cJo, ""));
        parcel.writeString(be.ah(this.cJp, ""));
        parcel.writeFloat(this.cJq);
        parcel.writeFloat(this.cJr);
    }
}
