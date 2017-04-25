package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageInfoTask> CREATOR = new Creator<JsApiGetStorageInfoTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
            jsApiGetStorageInfoTask.f(parcel);
            return jsApiGetStorageInfoTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageInfoTask[i];
        }
    };
    public int aGx;
    public String appId;
    public Runnable dFu;
    public ArrayList<String> dHf;
    public int size;

    public final void OL() {
        b bVar = a.dzM;
        if (bVar == null) {
            PP();
            return;
        }
        Object[] mP = bVar.mP(this.appId);
        this.dHf = (ArrayList) mP[0];
        this.size = ((Integer) mP[1]).intValue();
        this.aGx = ((Integer) mP[2]).intValue();
        PP();
    }

    public final void OM() {
        if (this.dFu != null) {
            this.dFu.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.dHf = parcel.createStringArrayList();
        this.size = parcel.readInt();
        this.aGx = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeStringList(this.dHf);
        parcel.writeInt(this.size);
        parcel.writeInt(this.aGx);
    }
}
