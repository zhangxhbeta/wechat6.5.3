package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import org.json.JSONObject;

public final class bj extends g {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorageSync";

    public final String a(f fVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        if (be.kS(optString)) {
            return c("fail", null);
        }
        if ((optString2 == null ? 0 : optString2.length()) + optString.length() > a.mr(fVar.dzg).dDD.nPE) {
            return c("fail:entry size limit reached", null);
        }
        String str = "fail";
        MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = fVar.dzg;
        jsApiSetStorageTask.ad(optString, optString2, optString3);
        if (AppBrandMainProcessService.b(jsApiSetStorageTask)) {
            str = jsApiSetStorageTask.bfz;
        }
        return c(str, null);
    }
}
