package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad extends g {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorageSync";

    public final String a(f fVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        if (be.kS(optString)) {
            return c("fail", null);
        }
        MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = fVar.dzg;
        jsApiGetStorageTask.apU = optString;
        AppBrandMainProcessService.b(jsApiGetStorageTask);
        optString = jsApiGetStorageTask.value == null ? "fail" : "ok";
        Map hashMap = new HashMap();
        hashMap.put("data", jsApiGetStorageTask.value == null ? "" : jsApiGetStorageTask.value);
        hashMap.put("dataType", jsApiGetStorageTask.type == null ? "" : jsApiGetStorageTask.type);
        return c(optString, hashMap);
    }
}
