package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.v;

public class SampleTask2 extends MainProcessTask {
    public static final Creator<SampleTask2> CREATOR = new Creator<SampleTask2>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SampleTask2();
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SampleTask2[i];
        }
    };

    public final void OL() {
        v.e("SampleTask2", "Run in Main Process");
    }
}
