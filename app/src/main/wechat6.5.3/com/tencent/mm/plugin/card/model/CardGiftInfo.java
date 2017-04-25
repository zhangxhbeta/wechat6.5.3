package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardGiftInfo implements Parcelable {
    public static final Creator<CardGiftInfo> CREATOR = new Creator<CardGiftInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CardGiftInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardGiftInfo[i];
        }
    };
    public String bcB;
    public String bmE;
    public String coN;
    public String eCa;
    public String eCb;
    public String eCc;
    public String eCd;
    public String eCe;
    public String eCf;
    public String eCg;
    public String eCh;
    public String eCi;
    public String eCj;
    public String eCk;
    public String eCl;
    public String eCm;
    public boolean eCn;
    public int eCo;
    public int eCp;
    public int eCq;
    public String eCr;
    public String eCs;
    public int eCt;
    public String eCu;

    protected CardGiftInfo(Parcel parcel) {
        this.bcB = parcel.readString();
        this.bmE = parcel.readString();
        this.eCa = parcel.readString();
        this.eCb = parcel.readString();
        this.eCc = parcel.readString();
        this.eCd = parcel.readString();
        this.eCe = parcel.readString();
        this.eCf = parcel.readString();
        this.eCg = parcel.readString();
        this.eCh = parcel.readString();
        this.eCi = parcel.readString();
        this.eCj = parcel.readString();
        this.eCk = parcel.readString();
        this.eCl = parcel.readString();
        this.eCm = parcel.readString();
        this.coN = parcel.readString();
        this.eCn = parcel.readByte() != (byte) 0;
        this.eCo = parcel.readInt();
        this.eCp = parcel.readInt();
        this.eCq = parcel.readInt();
        this.eCr = parcel.readString();
        this.eCs = parcel.readString();
        this.eCt = parcel.readInt();
        this.eCu = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bcB);
        parcel.writeString(this.bmE);
        parcel.writeString(this.eCa);
        parcel.writeString(this.eCb);
        parcel.writeString(this.eCc);
        parcel.writeString(this.eCd);
        parcel.writeString(this.eCe);
        parcel.writeString(this.eCf);
        parcel.writeString(this.eCg);
        parcel.writeString(this.eCh);
        parcel.writeString(this.eCi);
        parcel.writeString(this.eCj);
        parcel.writeString(this.eCk);
        parcel.writeString(this.eCl);
        parcel.writeString(this.eCm);
        parcel.writeString(this.coN);
        parcel.writeByte(this.eCn ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.eCo);
        parcel.writeInt(this.eCp);
        parcel.writeInt(this.eCq);
        parcel.writeString(this.eCr);
        parcel.writeString(this.eCs);
        parcel.writeInt(this.eCt);
        parcel.writeString(this.eCu);
    }

    public String toString() {
        return "CardGiftInfo{toUserName='" + this.bcB + '\'' + ", fromUserName='" + this.bmE + '\'' + ", fromUserImgUrl='" + this.eCa + '\'' + ", fromUserContent='" + this.eCb + '\'' + ", fromUserContentPicUrl='" + this.eCc + '\'' + ", fromUserContentVideoUrl='" + this.eCd + '\'' + ", fromUserContentThumbPicUrl='" + this.eCe + '\'' + ", picAESKey='" + this.eCf + '\'' + ", videoAESKey='" + this.eCg + '\'' + ", thumbVideoAESKey='" + this.eCh + '\'' + ", cardBackgroundPicUrl='" + this.eCi + '\'' + ", cardLogoLUrl='" + this.eCj + '\'' + ", cardTitle='" + this.eCk + '\'' + ", cardPrice='" + this.eCl + '\'' + ", footerWording='" + this.eCm + '\'' + ", color='" + this.coN + '\'' + ", needJump=" + this.eCn + ", picDataLength=" + this.eCo + ", videoDataLength=" + this.eCp + ", thumbDataLength=" + this.eCq + ", descTitle='" + this.eCr + '\'' + ", descIconUrl='" + this.eCs + '\'' + ", descLayoutMode=" + this.eCt + '}';
    }
}
