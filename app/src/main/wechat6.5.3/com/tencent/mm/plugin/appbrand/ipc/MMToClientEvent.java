package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;

public class MMToClientEvent extends MainProcessTask {
    public static final Creator<MMToClientEvent> CREATOR = new Creator<MMToClientEvent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MMToClientEvent(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MMToClientEvent[i];
        }
    };
    private static MMToClientEvent dEE;
    int aWI;
    public String appId;
    String bcZ;
    public int dED;
    public int type;

    public MMToClientEvent(Parcel parcel) {
        f(parcel);
    }

    private static MMToClientEvent PO() {
        if (dEE == null) {
            synchronized (MMToClientEvent.class) {
                if (dEE == null) {
                    dEE = new MMToClientEvent();
                }
            }
        }
        return dEE;
    }

    public final void OL() {
        switch (this.dED) {
            case 1:
                d.a(this);
                return;
            case 2:
                d.b(this);
                return;
            default:
                return;
        }
    }

    public static void nn(String str) {
        PO().dED = 1;
        PO().appId = str;
        AppBrandMainProcessService.a(PO());
    }

    public static void no(String str) {
        PO().dED = 2;
        PO().appId = str;
        AppBrandMainProcessService.a(PO());
    }

    public final void OM() {
        Map hashMap;
        switch (this.dED) {
            case 3:
                a aVar = new a();
                hashMap = new HashMap();
                hashMap.put(Columns.TYPE, Integer.valueOf(this.type));
                hashMap.put("data", this.bcZ);
                aVar.aa(this.appId, 0).o(hashMap).PX();
                return;
            case 4:
                v.a aVar2 = new v.a();
                hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(this.aWI));
                hashMap.put("data", this.bcZ);
                aVar2.aa(this.appId, 0).o(hashMap).PX();
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.dED = parcel.readInt();
        this.appId = parcel.readString();
        this.type = parcel.readInt();
        this.bcZ = parcel.readString();
        this.aWI = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dED);
        parcel.writeString(this.appId);
        parcel.writeInt(this.type);
        parcel.writeString(this.bcZ);
        parcel.writeInt(this.aWI);
    }
}
