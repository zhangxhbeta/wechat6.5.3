package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.config.i.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask extends MainProcessTask {
    public static final Creator<JsApiGetAppConfigTask> CREATOR = new Creator<JsApiGetAppConfigTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiGetAppConfigTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetAppConfigTask[i];
        }
    };
    public String apU;
    public String appId;
    public Runnable dFu;
    public int type;
    public String value;

    public JsApiGetAppConfigTask(Parcel parcel) {
        f(parcel);
    }

    public final void OL() {
        i.a(this.appId, this.type, 0, new c(this) {
            final /* synthetic */ JsApiGetAppConfigTask dGu;

            {
                this.dGu = r1;
            }

            public final void mM(String str) {
                this.dGu.value = str;
                this.dGu.PP();
            }
        }, true);
    }

    public final void OM() {
        if (this.dFu != null) {
            this.dFu.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.apU = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.apU);
        parcel.writeString(this.value);
        parcel.writeInt(this.type);
    }
}
