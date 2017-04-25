package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import org.json.JSONObject;

public final class bi extends a {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorage";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        if (be.kS(optString)) {
            fVar.y(i, c("fail", null));
            return;
        }
        if ((optString2 == null ? 0 : optString2.length()) + optString.length() > a.mr(fVar.dzg).dDD.nPE) {
            fVar.y(i, c("fail:entry size limit reached", null));
            return;
        }
        final MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = fVar.dzg;
        jsApiSetStorageTask.ad(optString, optString2, optString3);
        jsApiSetStorageTask.dFu = new Runnable(this) {
            final /* synthetic */ bi dIk;

            public final void run() {
                fVar.y(i, this.dIk.c(jsApiSetStorageTask.bfz, null));
                jsApiSetStorageTask.PR();
            }
        };
        jsApiSetStorageTask.PQ();
        AppBrandMainProcessService.a(jsApiSetStorageTask);
    }
}
