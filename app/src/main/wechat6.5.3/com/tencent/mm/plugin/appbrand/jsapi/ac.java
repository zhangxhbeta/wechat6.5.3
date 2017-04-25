package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends g {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfoSync";

    public final String a(f fVar, JSONObject jSONObject) {
        MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = fVar.dzg;
        AppBrandMainProcessService.b(jsApiGetStorageInfoTask);
        Map hashMap = new HashMap();
        hashMap.put("keys", jsApiGetStorageInfoTask.dHf);
        hashMap.put("currentSize", Integer.valueOf(jsApiGetStorageInfoTask.size));
        hashMap.put("limitSize", Integer.valueOf(jsApiGetStorageInfoTask.aGx));
        return c("ok", hashMap);
    }
}
