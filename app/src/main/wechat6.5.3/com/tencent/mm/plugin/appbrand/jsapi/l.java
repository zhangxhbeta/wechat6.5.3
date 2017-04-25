package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import org.json.JSONObject;

public final class l extends a {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorage";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = fVar.dzg;
        AppBrandMainProcessService.a(jsApiClearStorageTask);
        fVar.y(i, c("ok", null));
    }
}
