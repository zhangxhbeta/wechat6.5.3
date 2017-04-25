package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

class BroadCastData implements Parcelable {
    public static final Creator<BroadCastData> CREATOR = new Creator<BroadCastData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BroadCastData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BroadCastData[i];
        }
    };
    ArrayList<KVReportDataInfo> itB = new ArrayList();
    ArrayList<StIDKeyDataInfo> itC = new ArrayList();
    ArrayList<GroupIDKeyDataInfo> itD = new ArrayList();

    public BroadCastData(BroadCastData broadCastData) {
        if (broadCastData != null) {
            this.itB = new ArrayList(broadCastData.itB);
            this.itC = new ArrayList(broadCastData.itC);
            this.itD = new ArrayList(broadCastData.itD);
        }
    }

    protected BroadCastData(Parcel parcel) {
        parcel.readTypedList(this.itB, KVReportDataInfo.CREATOR);
        parcel.readTypedList(this.itC, StIDKeyDataInfo.CREATOR);
        parcel.readTypedList(this.itD, GroupIDKeyDataInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.itB);
        parcel.writeTypedList(this.itC);
        parcel.writeTypedList(this.itD);
    }
}
