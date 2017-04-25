package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import org.json.JSONObject;

public final class av extends a {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorage";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("key");
        if (be.kS(optString)) {
            fVar.y(i, c("fail", null));
            return;
        }
        MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = fVar.dzg;
        jsApiRemoveStorageTask.apU = optString;
        AppBrandMainProcessService.a(jsApiRemoveStorageTask);
        fVar.y(i, c("ok", null));
    }
}
