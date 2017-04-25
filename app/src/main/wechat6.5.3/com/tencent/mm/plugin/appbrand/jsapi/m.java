package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import org.json.JSONObject;

public final class m extends g {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorageSync";

    public final String a(f fVar, JSONObject jSONObject) {
        MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = fVar.dzg;
        AppBrandMainProcessService.b(jsApiClearStorageTask);
        return c("ok", null);
    }
}
