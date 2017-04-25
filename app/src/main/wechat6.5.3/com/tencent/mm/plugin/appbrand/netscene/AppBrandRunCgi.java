package com.tencent.mm.plugin.appbrand.netscene;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;

public final class AppBrandRunCgi {

    public interface a {
        void a(int i, int i2, String str, b bVar);
    }

    private static final class RemoteCgiTask extends MainProcessTask implements com.tencent.mm.v.u.a {
        public static final Creator<RemoteCgiTask> CREATOR = new Creator<RemoteCgiTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new RemoteCgiTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RemoteCgiTask[i];
            }
        };
        int dLS = 0;
        private int dLT;
        private int dLU;
        private String dLV;
        private b dLW;
        b dLX;
        a dLY;

        public final void OL() {
            u.a(this.dLX, this, true);
        }

        public final int a(int i, int i2, String str, b bVar, k kVar) {
            this.dLT = i;
            this.dLU = i2;
            this.dLV = str;
            this.dLW = bVar;
            this.dLS = 2;
            PP();
            return 0;
        }

        public final void OM() {
            com.tencent.mm.plugin.appbrand.k.a.aD(this);
            if (this.dLY != null) {
                this.dLY.a(this.dLT, this.dLU, this.dLV, this.dLW);
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.dLS);
            switch (this.dLS) {
                case 1:
                    AppBrandRunCgi.a(this.dLX, parcel);
                    return;
                case 2:
                    parcel.writeInt(this.dLT);
                    parcel.writeInt(this.dLU);
                    parcel.writeString(this.dLV);
                    AppBrandRunCgi.a(this.dLW, parcel);
                    return;
                default:
                    return;
            }
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.dLS = parcel.readInt();
            switch (this.dLS) {
                case 1:
                    this.dLX = AppBrandRunCgi.g(parcel);
                    return;
                case 2:
                    this.dLT = parcel.readInt();
                    this.dLU = parcel.readInt();
                    this.dLV = parcel.readString();
                    this.dLW = AppBrandRunCgi.g(parcel);
                    return;
                default:
                    return;
            }
        }

        RemoteCgiTask() {
        }

        RemoteCgiTask(Parcel parcel) {
            f(parcel);
        }
    }

    static /* synthetic */ void a(b bVar, Parcel parcel) {
        parcel.writeString(bVar.czk.czs.getClass().getName());
        byte[] bArr = new byte[0];
        try {
            bArr = bVar.czk.czs.toByteArray();
        } catch (Throwable e) {
            v.e("MicroMsg.AppBrandRunCgi", "writeCommReqRespToParcel, requestProto toByteArray, exp = %s", new Object[]{be.e(e)});
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.czl.czs.getClass().getName());
        bArr = new byte[0];
        try {
            bArr = bVar.czl.czs.toByteArray();
        } catch (Throwable e2) {
            v.e("MicroMsg.AppBrandRunCgi", "writeCommReqRespToParcel, responseProto toByteArray, exp = %s", new Object[]{be.e(e2)});
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.czm);
        parcel.writeInt(bVar.czk.cmdId);
        parcel.writeInt(bVar.czl.cmdId);
    }

    public static void a(b bVar, final a aVar) {
        if (aa.bto()) {
            u.a(bVar, new com.tencent.mm.v.u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (aVar != null) {
                        aVar.a(i, i2, str, bVar);
                    }
                    return 0;
                }
            });
            return;
        }
        MainProcessTask remoteCgiTask = new RemoteCgiTask();
        com.tencent.mm.plugin.appbrand.k.a.aC(remoteCgiTask);
        remoteCgiTask.dLX = bVar;
        remoteCgiTask.dLY = aVar;
        remoteCgiTask.dLS = 1;
        AppBrandMainProcessService.a(remoteCgiTask);
    }

    static b g(Parcel parcel) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        String readString = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar.czn = ((com.tencent.mm.ba.a) Class.forName(readString).newInstance()).az(bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.AppBrandRunCgi", "readCommReqRespFromParcel, parse requestProto, exp = %s", new Object[]{be.e(e)});
        }
        String readString2 = parcel.readString();
        bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar.czo = ((com.tencent.mm.ba.a) Class.forName(readString2).newInstance()).az(bArr);
        } catch (Throwable e2) {
            if (e2 instanceof a.a.a.b) {
                try {
                    aVar.czo = (com.tencent.mm.ba.a) Class.forName(readString2).newInstance();
                } catch (Throwable e22) {
                    v.e("MicroMsg.AppBrandRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[]{be.e(e22)});
                }
            }
            v.e("MicroMsg.AppBrandRunCgi", "readCommReqRespFromParcel, parse responseProto, exp = %s", new Object[]{be.e(r1)});
        }
        aVar.uri = parcel.readString();
        aVar.czm = parcel.readInt();
        aVar.czp = parcel.readInt();
        aVar.czq = parcel.readInt();
        return aVar.Bv();
    }
}
