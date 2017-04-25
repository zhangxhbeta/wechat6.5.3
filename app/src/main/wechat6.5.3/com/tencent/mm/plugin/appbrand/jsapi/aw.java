package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import org.json.JSONObject;

public final class aw extends g {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorageSync";

    public final String a(f fVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        if (be.kS(optString)) {
            return c("fail", null);
        }
        MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = fVar.dzg;
        jsApiRemoveStorageTask.apU = optString;
        AppBrandMainProcessService.b(jsApiRemoveStorageTask);
        return c("ok", null);
    }
}
