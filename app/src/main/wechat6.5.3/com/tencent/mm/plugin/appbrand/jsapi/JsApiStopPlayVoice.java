package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.eh;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class JsApiStopPlayVoice extends a {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    private static class StopPlayVoice extends MainProcessTask {
        public static final Creator<StopPlayVoice> CREATOR = new Creator<StopPlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StopPlayVoice();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopPlayVoice[i];
            }
        };

        private StopPlayVoice() {
        }

        public final void OL() {
            ad.o(new Runnable(this) {
                final /* synthetic */ StopPlayVoice dJj;

                {
                    this.dJj = r1;
                }

                public final void run() {
                    eh ehVar = new eh();
                    ehVar.bcF.op = 2;
                    a.nhr.z(ehVar);
                }
            });
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("localId");
        v.i("MicroMsg.JsApiStopPlayVoice", "doStopVoice, appId : %s, localId : %s", new Object[]{fVar.dzg, optString});
        AppBrandMainProcessService.a(new StopPlayVoice());
        fVar.y(i, c("ok", null));
        JsApiStartPlayVoice.dIX = null;
    }

    public static void Qm() {
        if (!be.kS(JsApiStartPlayVoice.dIX)) {
            AppBrandMainProcessService.a(new StopPlayVoice());
            JsApiStartPlayVoice.dIX = null;
        }
    }
}
