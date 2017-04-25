package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagList implements Parcelable {
    public static final Creator<SnsTagList> CREATOR = new Creator<SnsTagList>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            SnsTagList snsTagList = new SnsTagList();
            snsTagList.jdQ = parcel.readInt();
            for (int i = 0; i < snsTagList.jdQ; i++) {
                snsTagList.jdR.add(Long.valueOf(parcel.readLong()));
            }
            return snsTagList;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsTagList[i];
        }
    };
    private int jdQ = 0;
    private List<Long> jdR = new LinkedList();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        this.jdQ = this.jdR.size();
        parcel.writeInt(this.jdQ);
        for (Long longValue : this.jdR) {
            parcel.writeLong(longValue.longValue());
        }
    }
}
