package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.sdk.platformtools.be;
import org.json.JSONObject;

final class JsApiStopRecordVoice extends a {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    private static class StopRecordVoice extends MainProcessTask {
        public static final Creator<StopRecordVoice> CREATOR = new Creator<StopRecordVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StopRecordVoice();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopRecordVoice[i];
            }
        };

        private StopRecordVoice() {
        }

        public final void OL() {
            a.vA().x(new Runnable(this) {
                final /* synthetic */ StopRecordVoice dJk;

                {
                    this.dJk = r1;
                }

                public final void run() {
                    com.tencent.mm.plugin.appbrand.e.a.oT();
                }
            });
        }
    }

    JsApiStopRecordVoice() {
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        if (d.a(fVar) != null) {
            d.a(fVar).og(null);
        }
        if (!be.kS(JsApiStartRecordVoice.dJc)) {
            AppBrandMainProcessService.a(new StopRecordVoice());
        }
        fVar.y(i, c("ok", null));
        JsApiStartRecordVoice.dJc = null;
    }
}
