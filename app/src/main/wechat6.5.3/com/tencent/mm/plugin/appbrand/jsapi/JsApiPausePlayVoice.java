package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.eh;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class JsApiPausePlayVoice extends a {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";
    private PausePlayVoice dHO;

    private static class PausePlayVoice extends MainProcessTask {
        public static final Creator<PausePlayVoice> CREATOR = new Creator<PausePlayVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                PausePlayVoice pausePlayVoice = new PausePlayVoice();
                pausePlayVoice.f(parcel);
                return pausePlayVoice;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PausePlayVoice[i];
            }
        };

        private PausePlayVoice() {
        }

        public final void OL() {
            ad.o(new Runnable(this) {
                final /* synthetic */ PausePlayVoice dHP;

                {
                    this.dHP = r1;
                }

                public final void run() {
                    eh ehVar = new eh();
                    ehVar.bcF.op = 4;
                    a.nhr.z(ehVar);
                }
            });
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        this.dHO = new PausePlayVoice();
        AppBrandMainProcessService.a(this.dHO);
        fVar.y(i, c("ok", null));
    }
}
