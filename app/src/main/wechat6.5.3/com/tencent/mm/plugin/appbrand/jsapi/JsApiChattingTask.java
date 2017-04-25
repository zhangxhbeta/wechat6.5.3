package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;

public class JsApiChattingTask extends MainProcessTask {
    public static final Creator<JsApiChattingTask> CREATOR = new Creator<JsApiChattingTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiChattingTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiChattingTask[i];
        }
    };
    public String cID;
    public int dBr;
    public int dBs;
    public String dFs;
    public String dFt;
    public Runnable dFu;
    public String dJA;
    public String username;

    public JsApiChattingTask(Parcel parcel) {
        f(parcel);
    }

    public final void OL() {
        ak.yW();
        u LX = c.wH().LX(this.username);
        v.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s,avatar:%s", new Object[]{this.dFs, this.username, this.cID, this.dFt});
        if (LX == null || ((int) LX.chr) == 0) {
            LX = new u(this.username);
            LX.setType(0);
            LX.bS(this.cID);
            ak.yW();
            c.wH().N(LX);
            v.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[]{this.username});
        }
        PP();
    }

    public final void OM() {
        if (this.dFu != null) {
            this.dFu.run();
        }
    }

    public final void f(Parcel parcel) {
        this.dFs = parcel.readString();
        this.username = parcel.readString();
        this.cID = parcel.readString();
        this.dFt = parcel.readString();
        this.dJA = parcel.readString();
        this.dBs = parcel.readInt();
        this.dBr = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dFs);
        parcel.writeString(this.username);
        parcel.writeString(this.cID);
        parcel.writeString(this.dFt);
        parcel.writeString(this.dJA);
        parcel.writeInt(this.dBs);
        parcel.writeInt(this.dBr);
    }
}
