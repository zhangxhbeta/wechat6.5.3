package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.protocal.c.cp;
import java.util.ArrayList;
import java.util.LinkedList;

public class AppBrandSysConfig implements Parcelable {
    public static final Creator<AppBrandSysConfig> CREATOR = new Creator<AppBrandSysConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandSysConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandSysConfig[i];
        }
    };
    public String aWH;
    public String aZU;
    public String appId;
    public ArrayList<String> dDA;
    public final WxaPkgWrappingInfo dDB;
    public final WxaPkgWrappingInfo dDC;
    public AppBrandGlobalSystemConfig dDD;
    public cp dDE;
    public transient LinkedList<bjg> dDF;
    public transient int dDG;
    public String dDo;
    public boolean dDp;
    public byte[] dDq;
    public int dDr;
    public int dDs;
    public int dDt;
    public int dDu;
    public int dDv;
    public long dDw;
    public ArrayList<String> dDx;
    public ArrayList<String> dDy;
    public ArrayList<String> dDz;
    public int uin;

    public final long PA() {
        return this.dDE == null ? 0 : this.dDE.mcU;
    }

    public AppBrandSysConfig() {
        this.dDp = false;
        this.dDB = new WxaPkgWrappingInfo();
        this.dDC = new WxaPkgWrappingInfo();
    }

    public String toString() {
        return "AppBrandSysConfig{uin=" + this.uin + ", brandId='" + this.aWH + '\'' + ", brandName='" + this.aZU + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.dDo + '\'' + ", debugEnabled=" + this.dDp + ", maxWebViewDepth=" + this.dDr + ", maxBackgroundLifeSpan=" + this.dDs + ", maxRequestConcurrent=" + this.dDt + ", maxUploadConcurrent=" + this.dDu + ", maxDownloadConcurrent=" + this.dDv + ", requestDomains=" + this.dDx + ", socketDomains=" + this.dDy + ", uploadDomains=" + this.dDz + ", downloadDomains=" + this.dDA + ", appPkgInfo=" + this.dDB + ", libPkgInfo=" + this.dDC + ", systemSettings=" + this.dDD + ", runningFlag=" + l.a(this.dDE) + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uin);
        parcel.writeString(this.aWH);
        parcel.writeString(this.aZU);
        parcel.writeString(this.appId);
        parcel.writeString(this.dDo);
        parcel.writeByte(this.dDp ? (byte) 1 : (byte) 0);
        parcel.writeByteArray(this.dDq);
        parcel.writeInt(this.dDr);
        parcel.writeInt(this.dDs);
        parcel.writeInt(this.dDt);
        parcel.writeInt(this.dDu);
        parcel.writeInt(this.dDv);
        parcel.writeLong(this.dDw);
        parcel.writeStringList(this.dDx);
        parcel.writeStringList(this.dDy);
        parcel.writeStringList(this.dDz);
        parcel.writeStringList(this.dDA);
        parcel.writeParcelable(this.dDB, i);
        parcel.writeParcelable(this.dDC, i);
        parcel.writeParcelable(this.dDD, i);
        l.a(this.dDE, parcel);
    }

    protected AppBrandSysConfig(Parcel parcel) {
        boolean z = false;
        this.dDp = false;
        this.uin = parcel.readInt();
        this.aWH = parcel.readString();
        this.aZU = parcel.readString();
        this.appId = parcel.readString();
        this.dDo = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.dDp = z;
        this.dDq = parcel.createByteArray();
        this.dDr = parcel.readInt();
        this.dDs = parcel.readInt();
        this.dDt = parcel.readInt();
        this.dDu = parcel.readInt();
        this.dDv = parcel.readInt();
        this.dDw = parcel.readLong();
        this.dDx = parcel.createStringArrayList();
        this.dDy = parcel.createStringArrayList();
        this.dDz = parcel.createStringArrayList();
        this.dDA = parcel.createStringArrayList();
        this.dDB = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.dDC = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.dDD = (AppBrandGlobalSystemConfig) parcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader());
        this.dDE = l.d(parcel);
    }
}
