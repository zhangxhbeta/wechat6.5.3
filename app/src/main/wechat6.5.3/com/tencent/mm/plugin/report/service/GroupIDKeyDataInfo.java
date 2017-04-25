package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mars.smc.SmcLogic.IDKey;
import java.util.ArrayList;

class GroupIDKeyDataInfo implements Parcelable {
    public static final Creator<GroupIDKeyDataInfo> CREATOR = new Creator<GroupIDKeyDataInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GroupIDKeyDataInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GroupIDKeyDataInfo[i];
        }
    };
    ArrayList<IDKey> itE = new ArrayList();
    public boolean itF;

    GroupIDKeyDataInfo(ArrayList<IDKey> arrayList, boolean z) {
        this.itE = arrayList;
        this.itF = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.itE);
        parcel.writeInt(this.itF ? 1 : 0);
    }

    protected GroupIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        parcel.readTypedList(this.itE, IDKey.CREATOR);
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.itF = z;
    }
}
