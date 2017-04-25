package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiRefreshSession extends a {
    private static final int CTRL_INDEX = 118;
    private static final String NAME = "refreshSession";

    public static class RefreshSessionTask extends MainProcessTask {
        public static final Creator<RefreshSessionTask> CREATOR = new Creator<RefreshSessionTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new RefreshSessionTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RefreshSessionTask[i];
            }
        };
        String appId;
        private int bpD;
        d dFc;
        f dFd;
        int dFe;
        private int dHQ;
        private int dHR;
        private int dHS;

        public RefreshSessionTask(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            PQ();
            a aVar = new a();
            aVar.czn = new aem();
            aVar.czo = new aen();
            aVar.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
            aVar.czm = 1196;
            aVar.czp = 0;
            aVar.czq = 0;
            aem com_tencent_mm_protocal_c_aem = new aem();
            com_tencent_mm_protocal_c_aem.glj = this.appId;
            com_tencent_mm_protocal_c_aem.mEJ = this.bpD;
            aVar.czn = com_tencent_mm_protocal_c_aem;
            u.a(aVar.Bv(), new u.a(this) {
                final /* synthetic */ RefreshSessionTask dHT;

                {
                    this.dHT = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    v.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i == 0 && i2 == 0) {
                        aen com_tencent_mm_protocal_c_aen = (aen) bVar.czl.czs;
                        if (com_tencent_mm_protocal_c_aen == null) {
                            this.dHT.dHS = 0;
                            v.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
                            this.dHT.PP();
                        } else {
                            this.dHT.dHR = com_tencent_mm_protocal_c_aen.mmP.bcd;
                            String str2 = com_tencent_mm_protocal_c_aen.mmP.bce;
                            if (this.dHT.dHR == 0) {
                                this.dHT.dHQ = com_tencent_mm_protocal_c_aen.mER;
                                this.dHT.dHR = com_tencent_mm_protocal_c_aen.mmP.bcd;
                                this.dHT.dHS = 1;
                                this.dHT.PP();
                            } else {
                                this.dHT.dHR = com_tencent_mm_protocal_c_aen.mmP.bcd;
                                this.dHT.dHS = 2;
                                v.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[]{str2});
                                this.dHT.PP();
                            }
                        }
                    } else {
                        this.dHT.dHS = 0;
                        this.dHT.PP();
                    }
                    return 0;
                }
            }, true);
        }

        public final void OM() {
            Map hashMap = new HashMap();
            switch (this.dHS) {
                case 1:
                    hashMap.put("expireIn", this.dHQ);
                    hashMap.put("errCode", this.dHR);
                    this.dFd.y(this.dFe, this.dFc.c("ok", hashMap));
                    break;
                case 2:
                    hashMap.put("errCode", this.dHR);
                    this.dFd.y(this.dFe, this.dFc.c("fail", hashMap));
                    break;
                default:
                    hashMap.put("errCode", "-1");
                    this.dFd.y(this.dFe, this.dFc.c("fail", hashMap));
                    break;
            }
            PR();
        }

        public final void f(Parcel parcel) {
            this.dHQ = parcel.readInt();
            this.dHR = parcel.readInt();
            this.dHS = parcel.readInt();
            this.dFe = parcel.readInt();
            this.appId = parcel.readString();
            this.bpD = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dHQ);
            parcel.writeInt(this.dHR);
            parcel.writeInt(this.dHS);
            parcel.writeInt(this.dFe);
            parcel.writeString(this.appId);
            parcel.writeInt(this.bpD);
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        MainProcessTask refreshSessionTask = new RefreshSessionTask();
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(fVar.dzg);
        if (mr != null) {
            refreshSessionTask.bpD = mr.dDB.dBr;
        }
        String str = fVar.dzg;
        refreshSessionTask.dFc = this;
        refreshSessionTask.dFd = fVar;
        refreshSessionTask.dFe = i;
        refreshSessionTask.appId = str;
        refreshSessionTask.PQ();
        AppBrandMainProcessService.a(refreshSessionTask);
    }
}
