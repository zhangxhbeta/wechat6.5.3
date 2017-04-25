package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab extends a {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        final MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = fVar.dzg;
        jsApiGetStorageInfoTask.dFu = new Runnable(this) {
            final /* synthetic */ ab dHe;

            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put("keys", jsApiGetStorageInfoTask.dHf);
                hashMap.put("currentSize", Integer.valueOf(jsApiGetStorageInfoTask.size));
                hashMap.put("limitSize", Integer.valueOf(jsApiGetStorageInfoTask.aGx));
                fVar.y(i, this.dHe.c("ok", hashMap));
            }
        };
        jsApiGetStorageInfoTask.PQ();
        AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
    }
}
