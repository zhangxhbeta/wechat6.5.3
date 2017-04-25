package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetMusicPlayerState extends a {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";
    private GetMusicPlayerState dGT;

    private static class GetMusicPlayerState extends MainProcessTask {
        public static final Creator<GetMusicPlayerState> CREATOR = new Creator<GetMusicPlayerState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetMusicPlayerState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetMusicPlayerState[i];
            }
        };
        private f dFd;
        private int dFe;
        private d dGU;
        public String dGV;
        public String dGW;
        public boolean dGX = false;
        public int dGY;
        public String dGZ;
        public String dHa;
        public int kB;
        public int lr;
        public int mStatus;

        public GetMusicPlayerState(d dVar, f fVar, int i) {
            this.dGU = dVar;
            this.dFd = fVar;
            this.dFe = i;
        }

        public GetMusicPlayerState(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            JSONObject jSONObject;
            int i = -1;
            try {
                jSONObject = new JSONObject(this.dGV);
            } catch (Throwable e) {
                v.a("MicroMsg.JsApiGetMusicPlayerState", e, "", new Object[0]);
                jSONObject = null;
            }
            if (jSONObject == null) {
                this.dGX = true;
                this.dHa = "data is null.";
                PP();
            } else if (a.dze.ao(this.dGW, "")) {
                ajr HE = b.HE();
                if (HE != null) {
                    int i2;
                    d HF = b.HF();
                    if (HF != null) {
                        i2 = HF.lr;
                        i = HF.kB;
                    } else {
                        i2 = -1;
                    }
                    this.lr = i2 / BaseReportManager.MAX_READ_COUNT;
                    this.kB = i / BaseReportManager.MAX_READ_COUNT;
                    this.mStatus = HF.mStatus;
                    this.dGY = HF.cSU;
                    this.dGZ = HE.mKc;
                    this.dHa = "";
                    this.dGX = false;
                }
                v.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[]{Integer.valueOf(this.lr), Integer.valueOf(this.kB), Integer.valueOf(this.mStatus), Integer.valueOf(this.dGY), this.dGZ});
                PP();
            } else {
                v.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
                this.dGX = true;
                this.dHa = "appid not match cannot operate";
                PP();
            }
        }

        public final void OM() {
            String str;
            Map hashMap = new HashMap();
            hashMap.put("duration", Integer.valueOf(this.lr));
            hashMap.put("currentPosition", Integer.valueOf(this.kB));
            hashMap.put(DownloadInfo.STATUS, Integer.valueOf(this.mStatus));
            hashMap.put("downloadPercent", Integer.valueOf(this.dGY));
            hashMap.put("dataUrl", this.dGZ);
            f fVar = this.dFd;
            int i = this.dFe;
            d dVar = this.dGU;
            if (this.dGX) {
                str = "fail" + (TextUtils.isEmpty(this.dHa) ? "" : ":" + this.dHa);
            } else {
                str = "ok";
            }
            fVar.y(i, dVar.c(str, hashMap));
        }

        public final void f(Parcel parcel) {
            this.dGV = parcel.readString();
            this.dGW = parcel.readString();
            this.dGX = parcel.readByte() != (byte) 0;
            this.lr = parcel.readInt();
            this.kB = parcel.readInt();
            this.mStatus = parcel.readInt();
            this.dGY = parcel.readInt();
            this.dGZ = parcel.readString();
            this.dHa = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.dGV);
            parcel.writeString(this.dGW);
            parcel.writeByte(this.dGX ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.lr);
            parcel.writeInt(this.kB);
            parcel.writeInt(this.mStatus);
            parcel.writeInt(this.dGY);
            parcel.writeString(this.dGZ);
            parcel.writeString(this.dHa);
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        this.dGT = new GetMusicPlayerState(this, fVar, i);
        this.dGT.dGV = jSONObject.toString();
        this.dGT.dGW = fVar.dzg;
        AppBrandMainProcessService.a(this.dGT);
    }
}
