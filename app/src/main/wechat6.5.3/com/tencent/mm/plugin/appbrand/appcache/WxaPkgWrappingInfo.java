package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appcache.f.a;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo implements Parcelable {
    public static final Creator<WxaPkgWrappingInfo> CREATOR = new Creator<WxaPkgWrappingInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaPkgWrappingInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgWrappingInfo[i];
        }
    };
    public String dBA;
    public int dBr;
    public int dBs;
    public long dBt;
    public boolean dBu;
    public String dBv;
    public transient String dBw;
    public volatile transient Map<String, WxaPkgItemInfo> dBx;
    public ArrayList<WxaPkgItemInfo> dBy;
    public boolean dBz;

    public static WxaPkgWrappingInfo mO(String str) {
        f fVar = new f(new File(str));
        if (!fVar.dAt) {
            v.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", new Object[]{str});
            return null;
        } else if (fVar.OS()) {
            Collection linkedList = new LinkedList();
            for (a aVar : fVar.dAx) {
                linkedList.add(new WxaPkgItemInfo(aVar.aST, aVar.dAz, aVar.dAy));
            }
            fVar.close();
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
            wxaPkgWrappingInfo.dBz = true;
            wxaPkgWrappingInfo.dBy = new ArrayList(linkedList);
            wxaPkgWrappingInfo.dBA = str;
            wxaPkgWrappingInfo.dBu = false;
            return wxaPkgWrappingInfo;
        } else {
            v.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", new Object[]{str});
            return null;
        }
    }

    public WxaPkgWrappingInfo() {
        this.dBx = null;
        this.dBy = null;
        this.dBz = false;
    }

    public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.dBr = wxaPkgWrappingInfo.dBr;
        this.dBs = wxaPkgWrappingInfo.dBs;
        this.dBt = wxaPkgWrappingInfo.dBt;
        if (wxaPkgWrappingInfo.dBz) {
            this.dBu = wxaPkgWrappingInfo.dBu;
            this.dBz = true;
            this.dBy = wxaPkgWrappingInfo.dBy;
            this.dBA = wxaPkgWrappingInfo.dBA;
        }
    }

    public final String toString() {
        return "WxaPkgWrappingInfo{pkgDebugType=" + this.dBr + ", pkgVersion=" + this.dBs + ", pkgCreateTime=" + this.dBt + ", localPkg=" + this.dBu + ", pkgMd5='" + this.dBv + '\'' + ", pkgFileInfoList.size=" + (this.dBy == null ? "null" : Integer.valueOf(this.dBy.size())) + ", hasPkgFileInfoList=" + this.dBz + ", pkgPath='" + this.dBA + '\'' + '}';
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        parcel.writeInt(this.dBr);
        parcel.writeInt(this.dBs);
        parcel.writeLong(this.dBt);
        parcel.writeByte(this.dBu ? (byte) 1 : (byte) 0);
        parcel.writeString(this.dBv);
        parcel.writeTypedList(this.dBy);
        if (!this.dBz) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.dBA);
    }

    private WxaPkgWrappingInfo(Parcel parcel) {
        boolean z = true;
        this.dBx = null;
        this.dBy = null;
        this.dBz = false;
        this.dBr = parcel.readInt();
        this.dBs = parcel.readInt();
        this.dBt = parcel.readLong();
        this.dBu = parcel.readByte() != (byte) 0;
        this.dBv = parcel.readString();
        this.dBy = parcel.createTypedArrayList(WxaPkgItemInfo.CREATOR);
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.dBz = z;
        this.dBA = parcel.readString();
    }
}
