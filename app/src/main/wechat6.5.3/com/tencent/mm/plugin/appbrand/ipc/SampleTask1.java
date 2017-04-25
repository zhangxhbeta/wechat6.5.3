package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.v;

public class SampleTask1 extends MainProcessTask {
    public static final Creator<SampleTask1> CREATOR = new Creator<SampleTask1>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SampleTask1(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SampleTask1[i];
        }
    };
    public String dEI;
    public String dEJ;

    public SampleTask1(Parcel parcel) {
        f(parcel);
    }

    public final void OL() {
        v.e("SampleTask", this.dEI);
        this.dEJ = "String from Main Process";
        PP();
    }

    public final void OM() {
        v.e("SampleTask", this.dEJ);
    }

    public final void f(Parcel parcel) {
        this.dEI = parcel.readString();
        this.dEJ = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dEI);
        parcel.writeString(this.dEJ);
    }
}
