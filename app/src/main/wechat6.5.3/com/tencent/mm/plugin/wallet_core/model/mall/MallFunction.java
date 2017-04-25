package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class MallFunction implements Parcelable {
    public static final Creator<MallFunction> CREATOR = new Creator<MallFunction>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallFunction(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallFunction[i];
        }
    };
    public String bpZ;
    public String cCj;
    public String gxI;
    public String hiB;
    public String hiC;
    public String imm;
    public String kRe;
    public ArrayList<String> kRf;
    public MallNews kRg;
    public String kRh;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallFunction(Parcel parcel) {
        this.imm = parcel.readString();
        this.bpZ = parcel.readString();
        this.kRe = parcel.readString();
        this.hiB = parcel.readString();
        this.hiC = parcel.readString();
        this.cCj = parcel.readString();
        this.gxI = parcel.readString();
        this.kRf = new ArrayList();
        parcel.readStringList(this.kRf);
        this.kRg = (MallNews) parcel.readParcelable(MallNews.class.getClassLoader());
        this.type = parcel.readInt();
        this.kRh = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.imm);
        parcel.writeString(this.bpZ);
        parcel.writeString(this.kRe);
        parcel.writeString(this.hiB);
        parcel.writeString(this.hiC);
        parcel.writeString(this.cCj);
        parcel.writeString(this.gxI);
        parcel.writeStringList(this.kRf);
        parcel.writeParcelable(this.kRg, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.kRh);
    }
}
