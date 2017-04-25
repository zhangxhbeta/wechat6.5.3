package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.sdk.platformtools.v;

public class GeneralControlWrapper implements Parcelable {
    public static final Creator<GeneralControlWrapper> CREATOR = new Creator<GeneralControlWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeneralControlWrapper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeneralControlWrapper[i];
        }
    };
    public static final GeneralControlWrapper lWq = new GeneralControlWrapper(10);
    public static final GeneralControlWrapper lWr = new GeneralControlWrapper(1);
    public int lWs;

    public GeneralControlWrapper(rr rrVar) {
        this.lWs = rrVar.mvv;
        v.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public GeneralControlWrapper(int i) {
        this.lWs = i;
        v.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public final boolean bry() {
        boolean z = (this.lWs & 2) > 0;
        v.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = " + z);
        return z;
    }

    public final boolean brz() {
        boolean z = (this.lWs & 64) > 0;
        v.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = " + z);
        return z;
    }

    public final boolean brA() {
        boolean z = (this.lWs & 2048) > 0;
        v.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[bitset=0x");
        stringBuilder.append(Integer.toHexString(this.lWs));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.lWs);
    }

    private GeneralControlWrapper(Parcel parcel) {
        this.lWs = parcel.readInt();
    }
}
