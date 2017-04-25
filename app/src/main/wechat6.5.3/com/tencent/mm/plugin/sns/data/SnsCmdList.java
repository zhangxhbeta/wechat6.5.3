package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList implements Parcelable {
    public static final Creator<SnsCmdList> CREATOR = new Creator<SnsCmdList>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            int i = 0;
            SnsCmdList snsCmdList = new SnsCmdList();
            snsCmdList.jdI = parcel.readInt();
            snsCmdList.jdK.clear();
            for (int i2 = 0; i2 < snsCmdList.jdI; i2++) {
                snsCmdList.jdK.add(Integer.valueOf(parcel.readInt()));
            }
            snsCmdList.jdJ = parcel.readInt();
            snsCmdList.jdL.clear();
            while (i < snsCmdList.jdJ) {
                snsCmdList.jdL.add(Integer.valueOf(parcel.readInt()));
                i++;
            }
            return snsCmdList;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsCmdList[i];
        }
    };
    private int jdI = 0;
    private int jdJ = 0;
    public List<Integer> jdK = new LinkedList();
    public List<Integer> jdL = new LinkedList();

    public final void pQ(int i) {
        this.jdK.add(Integer.valueOf(i));
    }

    public final void pR(int i) {
        this.jdL.add(Integer.valueOf(i));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        this.jdI = this.jdK.size();
        parcel.writeInt(this.jdI);
        for (int i3 = 0; i3 < this.jdI; i3++) {
            parcel.writeInt(((Integer) this.jdK.get(i3)).intValue());
        }
        this.jdJ = this.jdL.size();
        parcel.writeInt(this.jdJ);
        while (i2 < this.jdJ) {
            parcel.writeInt(((Integer) this.jdL.get(i2)).intValue());
            i2++;
        }
    }
}
