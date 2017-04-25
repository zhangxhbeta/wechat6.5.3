package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.eh;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.g.a;
import com.tencent.mm.v.g.b;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartPlayVoice extends a {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";
    public static String dIX = null;
    public h dIW = null;
    private StartPlayVoice dIY;

    private static class StartPlayVoice extends MainProcessTask {
        public static final Creator<StartPlayVoice> CREATOR = new Creator<StartPlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartPlayVoice(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartPlayVoice[i];
            }
        };
        public String bde;
        private f dFd;
        private int dFe;
        private d dGU;
        public boolean dGX = false;
        public String filePath;

        public StartPlayVoice(d dVar, f fVar, int i) {
            this.dGU = dVar;
            this.dFd = fVar;
            this.dFe = i;
        }

        public StartPlayVoice(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            ad.o(new Runnable(this) {
                final /* synthetic */ StartPlayVoice dJa;

                {
                    this.dJa = r1;
                }

                public final void run() {
                    eh ehVar = new eh();
                    ehVar.bcF.op = 1;
                    ehVar.bcF.aST = this.dJa.filePath;
                    ehVar.bcF.bcH = true;
                    ehVar.bcF.aTe = true;
                    ehVar.bcF.bcI = new a(this) {
                        final /* synthetic */ AnonymousClass1 dJb;

                        {
                            this.dJb = r1;
                        }

                        public final void pa() {
                            this.dJb.dJa.dGX = false;
                            this.dJb.dJa.PP();
                        }
                    };
                    ehVar.bcF.bcJ = new b(this) {
                        final /* synthetic */ AnonymousClass1 dJb;

                        {
                            this.dJb = r1;
                        }

                        public final void onError() {
                            this.dJb.dJa.dGX = true;
                            this.dJb.dJa.PP();
                        }
                    };
                    com.tencent.mm.sdk.c.a.nhr.z(ehVar);
                }
            });
        }

        public final void OM() {
            Map hashMap = new HashMap();
            hashMap.put("localId", this.bde);
            this.dFd.y(this.dFe, this.dGU.c(this.dGX ? "fail" : "ok", hashMap));
            JsApiStartPlayVoice.dIX = null;
        }

        public final void f(Parcel parcel) {
            this.bde = parcel.readString();
            this.filePath = parcel.readString();
            this.dGX = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.bde);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.dGX ? (byte) 1 : (byte) 0);
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String ah = be.ah(jSONObject.optString(DownloadInfoColumns.FILEPATH, null), jSONObject.optString("localId"));
        v.i("MicroMsg.JsApiStartPlayVoice", "doPlayVoice, appId : %s, localId : %s", new Object[]{fVar.dzg, ah});
        if (be.kS(ah)) {
            fVar.y(i, c("fail_missing arguments", null));
            return;
        }
        AppBrandLocalMediaObject az = c.az(fVar.dzg, ah);
        if (az == null || be.kS(az.cvK) || d.a(fVar) == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        this.dIW = d.a(fVar);
        o.b n = o.yx().n("JsApi@" + this.dIW.hashCode(), true);
        h.a aVar = (h.a) n.a("onBackgroundListener", h.a.class);
        if (aVar == null) {
            aVar = new h.a(this) {
                final /* synthetic */ JsApiStartPlayVoice dIZ;

                {
                    this.dIZ = r1;
                }

                public final void Qi() {
                    JsApiStopPlayVoice.Qm();
                    this.dIZ.dIW.b((h.a) this);
                }
            };
            n.l("onBackgroundListener", aVar);
        }
        this.dIW.a(aVar);
        if (((h.b) n.a("onDestroyListener", h.b.class)) == null) {
            h.b anonymousClass2 = new h.b(this) {
                final /* synthetic */ JsApiStartPlayVoice dIZ;

                {
                    this.dIZ = r1;
                }

                public final void onDestroy() {
                    JsApiStopPlayVoice.Qm();
                    this.dIZ.dIW.b((h.b) this);
                }
            };
            n.l("onDestroyListener", anonymousClass2);
            this.dIW.a(anonymousClass2);
        }
        if (this.dIY == null) {
            this.dIY = new StartPlayVoice(this, fVar, i);
        }
        if (dIX != null) {
            Map hashMap = new HashMap();
            hashMap.put("localId", this.dIY.bde);
            fVar.y(this.dIY.dFe, c("ok", hashMap));
        }
        this.dIY.dGU = this;
        this.dIY.dFd = fVar;
        this.dIY.dFe = i;
        this.dIY.bde = ah;
        this.dIY.filePath = az.cvK;
        AppBrandMainProcessService.a(this.dIY);
        dIX = ah;
    }
}
