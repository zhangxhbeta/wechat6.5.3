package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiClearStorageTask extends MainProcessTask {
    public static final Creator<JsApiClearStorageTask> CREATOR = new Creator<JsApiClearStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiClearStorageTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiClearStorageTask[i];
        }
    };
    public String appId;

    public JsApiClearStorageTask(Parcel parcel) {
        f(parcel);
    }

    public final void OL() {
        b bVar = a.dzM;
        if (bVar != null) {
            bVar.clear(this.appId);
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
    }
}
