package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.storage.ab;

class JsApiGetContactMessageCountTask extends MainProcessTask {
    public static final Creator<JsApiGetContactMessageCountTask> CREATOR = new Creator<JsApiGetContactMessageCountTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiGetContactMessageCountTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetContactMessageCountTask[i];
        }
    };
    public int aWI;
    public Runnable dFu;
    public String username;

    public JsApiGetContactMessageCountTask(Parcel parcel) {
        f(parcel);
    }

    public final void OL() {
        ak.yW();
        ab Mh = c.wK().Mh(this.username);
        if (Mh == null) {
            this.aWI = -1;
            PP();
            return;
        }
        this.aWI = Mh.field_unReadCount;
        PP();
    }

    public final void OM() {
        if (this.dFu != null) {
            this.dFu.run();
        }
    }

    public final void f(Parcel parcel) {
        this.username = parcel.readString();
        this.aWI = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.aWI);
    }
}
