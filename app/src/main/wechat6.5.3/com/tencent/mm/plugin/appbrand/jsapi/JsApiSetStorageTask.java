package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.v;

class JsApiSetStorageTask extends MainProcessTask {
    public static final Creator<JsApiSetStorageTask> CREATOR = new Creator<JsApiSetStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.f(parcel);
            return jsApiSetStorageTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetStorageTask[i];
        }
    };
    private String apU;
    public String appId;
    public String bfz;
    public Runnable dFu;
    private boolean lpT;
    private int lpU;
    private int lpV;
    private int lpW;
    private String type;
    private String value;

    JsApiSetStorageTask() {
    }

    public final void ad(String str, String str2, String str3) {
        if (cb.K(str, str2, str3) > 102400) {
            this.lpU = cb.K(str);
            this.lpV = cb.K(str2);
            this.lpW = cb.K(str3);
            try {
                cb.l(this.lpS, str, str2, str3);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
            }
            this.lpT = true;
            return;
        }
        this.lpT = false;
        this.apU = str;
        this.value = str2;
        this.type = str3;
    }

    private void buV() {
        this.apU = null;
        this.value = null;
        this.type = null;
    }

    public final void OM() {
        if (this.dFu != null) {
            this.dFu.run();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void OL() {
        /*
        r5 = this;
        r0 = r5.lpT;
        if (r0 == 0) goto L_0x0046;
    L_0x0004:
        r0 = r5.lpS;	 Catch:{ Exception -> 0x0056 }
        r0 = com.tencent.mm.plugin.appbrand.jsapi.cb.Rg(r0);	 Catch:{ Exception -> 0x0056 }
        r1 = r0.length();	 Catch:{ Exception -> 0x0056 }
        r2 = r5.lpU;	 Catch:{ Exception -> 0x0056 }
        r3 = r5.lpV;	 Catch:{ Exception -> 0x0056 }
        r2 = r2 + r3;
        r3 = r5.lpW;	 Catch:{ Exception -> 0x0056 }
        r2 = r2 + r3;
        if (r1 != r2) goto L_0x0041;
    L_0x0018:
        r1 = 0;
        r2 = r5.lpU;	 Catch:{ Exception -> 0x0056 }
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0056 }
        r5.apU = r1;	 Catch:{ Exception -> 0x0056 }
        r1 = r5.lpU;	 Catch:{ Exception -> 0x0056 }
        r2 = r5.lpU;	 Catch:{ Exception -> 0x0056 }
        r3 = r5.lpV;	 Catch:{ Exception -> 0x0056 }
        r2 = r2 + r3;
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0056 }
        r5.value = r1;	 Catch:{ Exception -> 0x0056 }
        r1 = r5.lpU;	 Catch:{ Exception -> 0x0056 }
        r2 = r5.lpV;	 Catch:{ Exception -> 0x0056 }
        r1 = r1 + r2;
        r2 = r5.lpU;	 Catch:{ Exception -> 0x0056 }
        r3 = r5.lpV;	 Catch:{ Exception -> 0x0056 }
        r2 = r2 + r3;
        r3 = r5.lpW;	 Catch:{ Exception -> 0x0056 }
        r2 = r2 + r3;
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0056 }
        r5.type = r0;	 Catch:{ Exception -> 0x0056 }
    L_0x0041:
        r0 = r5.lpS;
        com.tencent.mm.plugin.appbrand.jsapi.cb.Rh(r0);
    L_0x0046:
        r0 = com.tencent.mm.plugin.appbrand.a.a.dzM;
        if (r0 != 0) goto L_0x006e;
    L_0x004a:
        r0 = "fail";
        r5.bfz = r0;
        r5.buV();
        r5.PP();
    L_0x0055:
        return;
    L_0x0056:
        r0 = move-exception;
        r1 = "MicroMsg.JsApiSetStorageTask";
        r0 = r0.getMessage();	 Catch:{ all -> 0x0067 }
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);	 Catch:{ all -> 0x0067 }
        r0 = r5.lpS;
        com.tencent.mm.plugin.appbrand.jsapi.cb.Rh(r0);
        goto L_0x0046;
    L_0x0067:
        r0 = move-exception;
        r1 = r5.lpS;
        com.tencent.mm.plugin.appbrand.jsapi.cb.Rh(r1);
        throw r0;
    L_0x006e:
        r1 = r5.appId;
        r2 = r5.apU;
        r3 = r5.value;
        r4 = r5.type;
        r0 = r0.d(r1, r2, r3, r4);
        r1 = com.tencent.mm.plugin.appbrand.appstorage.b.a.NONE;
        if (r0 != r1) goto L_0x008a;
    L_0x007e:
        r0 = "ok";
        r5.bfz = r0;
    L_0x0083:
        r5.buV();
        r5.PP();
        goto L_0x0055;
    L_0x008a:
        r1 = com.tencent.mm.plugin.appbrand.appstorage.b.a.QUOTA_REACHED;
        if (r0 != r1) goto L_0x0094;
    L_0x008e:
        r0 = "fail:quota reached";
        r5.bfz = r0;
        goto L_0x0083;
    L_0x0094:
        r0 = "fail";
        r5.bfz = r0;
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.JsApiSetStorageTask.OL():void");
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
        this.bfz = parcel.readString();
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
        parcel.writeString(this.bfz);
    }
}
