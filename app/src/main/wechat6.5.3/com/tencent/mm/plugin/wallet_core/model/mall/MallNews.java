package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallNews implements Parcelable {
    public static final Creator<MallNews> CREATOR = new Creator<MallNews>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallNews(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallNews[i];
        }
    };
    public int aXx;
    public String bax;
    public int kPK;
    public String kRl = "0";
    public String kRm = "0";
    public String kRn;
    public String kRo;
    public String kRp;
    public String kRq;
    public int kRr;
    public String kRs;
    public int kRt;
    public String kRu;
    public String kRv;
    public String keV;
    public String type;

    public MallNews(String str) {
        this.kRn = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MallNews)) {
            return false;
        }
        MallNews mallNews = (MallNews) obj;
        if (this.kRn == null || !this.kRn.equals(mallNews.kRn) || this.keV == null || !this.keV.equals(mallNews.keV)) {
            return false;
        }
        return true;
    }

    public MallNews(Parcel parcel) {
        this.kRn = parcel.readString();
        this.keV = parcel.readString();
        this.bax = parcel.readString();
        this.kRo = parcel.readString();
        this.kRp = parcel.readString();
        this.kRq = parcel.readString();
        this.kRr = parcel.readInt();
        this.kRs = parcel.readString();
        this.kRl = parcel.readString();
        this.kRm = parcel.readString();
        this.aXx = parcel.readInt();
        this.kRu = parcel.readString();
        this.kPK = parcel.readInt();
        this.kRv = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.kRn);
        parcel.writeString(this.keV);
        parcel.writeString(this.bax);
        parcel.writeString(this.kRo);
        parcel.writeString(this.kRp);
        parcel.writeString(this.kRq);
        parcel.writeInt(this.kRr);
        parcel.writeString(this.kRs);
        parcel.writeString(this.kRl);
        parcel.writeString(this.kRm);
        parcel.writeInt(this.aXx);
        parcel.writeString(this.kRu);
        parcel.writeInt(this.kPK);
        parcel.writeString(this.kRv);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[]{this.kRn, this.keV, this.bax, this.kRo, this.kRp, this.kRq, this.kRl, this.kRu, this.kRs, Integer.valueOf(this.kPK), this.kRv});
    }
}
