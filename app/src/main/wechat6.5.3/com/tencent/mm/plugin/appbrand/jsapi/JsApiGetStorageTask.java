package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.v;

class JsApiGetStorageTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageTask> CREATOR = new Creator<JsApiGetStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
            jsApiGetStorageTask.f(parcel);
            return jsApiGetStorageTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageTask[i];
        }
    };
    public String apU;
    public String appId;
    public Runnable dFu;
    private boolean lpT;
    private int lpU;
    private int lpV;
    private int lpW;
    public String type;
    public String value;

    public final void OL() {
        b bVar = a.dzM;
        if (bVar == null) {
            PP();
            return;
        }
        Object[] at = bVar.at(this.appId, this.apU);
        if (((b.a) at[0]) == b.a.NONE) {
            if (cb.K((String) at[1], (String) at[2]) > 102400) {
                this.lpV = cb.K((String) at[1]);
                this.lpW = cb.K(r1);
                try {
                    cb.l(this.lpS, r0, r1);
                } catch (Exception e) {
                    v.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                }
                this.lpT = true;
            } else {
                this.lpT = false;
                this.value = r0;
                this.type = r1;
            }
        }
        PP();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void OM() {
        /*
        r4 = this;
        r0 = r4.lpT;
        if (r0 == 0) goto L_0x0030;
    L_0x0004:
        r0 = r4.lpS;	 Catch:{ Exception -> 0x003a }
        r0 = com.tencent.mm.plugin.appbrand.jsapi.cb.Rg(r0);	 Catch:{ Exception -> 0x003a }
        r1 = r0.length();	 Catch:{ Exception -> 0x003a }
        r2 = r4.lpV;	 Catch:{ Exception -> 0x003a }
        r3 = r4.lpW;	 Catch:{ Exception -> 0x003a }
        r2 = r2 + r3;
        if (r1 != r2) goto L_0x002b;
    L_0x0015:
        r1 = 0;
        r2 = r4.lpV;	 Catch:{ Exception -> 0x003a }
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x003a }
        r4.value = r1;	 Catch:{ Exception -> 0x003a }
        r1 = r4.lpV;	 Catch:{ Exception -> 0x003a }
        r2 = r4.lpV;	 Catch:{ Exception -> 0x003a }
        r3 = r4.lpW;	 Catch:{ Exception -> 0x003a }
        r2 = r2 + r3;
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x003a }
        r4.type = r0;	 Catch:{ Exception -> 0x003a }
    L_0x002b:
        r0 = r4.lpS;
        com.tencent.mm.plugin.appbrand.jsapi.cb.Rh(r0);
    L_0x0030:
        r0 = r4.dFu;
        if (r0 == 0) goto L_0x0039;
    L_0x0034:
        r0 = r4.dFu;
        r0.run();
    L_0x0039:
        return;
    L_0x003a:
        r0 = move-exception;
        r1 = "MicroMsg.JsApiGetStorageTask";
        r0 = r0.getMessage();	 Catch:{ all -> 0x004b }
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);	 Catch:{ all -> 0x004b }
        r0 = r4.lpS;
        com.tencent.mm.plugin.appbrand.jsapi.cb.Rh(r0);
        goto L_0x0030;
    L_0x004b:
        r0 = move-exception;
        r1 = r4.lpS;
        com.tencent.mm.plugin.appbrand.jsapi.cb.Rh(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.JsApiGetStorageTask.OM():void");
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.lpT = parcel.readByte() != (byte) 0;
        this.lpU = parcel.readInt();
        this.lpV = parcel.readInt();
        this.lpW = parcel.readInt();
        this.apU = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByte(this.lpT ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.lpU);
        parcel.writeInt(this.lpV);
        parcel.writeInt(this.lpW);
        parcel.writeString(this.apU);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
    }
}
