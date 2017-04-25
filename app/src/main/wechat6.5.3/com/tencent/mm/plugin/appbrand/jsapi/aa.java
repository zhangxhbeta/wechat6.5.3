package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa extends a {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        String optString = jSONObject.optString("key");
        if (be.kS(optString)) {
            fVar.y(i, c("fail", null));
            return;
        }
        final MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = fVar.dzg;
        jsApiGetStorageTask.apU = optString;
        final f fVar2 = fVar;
        final int i2 = i;
        jsApiGetStorageTask.dFu = new Runnable(this) {
            final /* synthetic */ aa dHc;

            public final void run() {
                String str = jsApiGetStorageTask.value == null ? "fail" : "ok";
                Map hashMap = new HashMap();
                hashMap.put("data", jsApiGetStorageTask.value == null ? "" : jsApiGetStorageTask.value);
                hashMap.put("dataType", jsApiGetStorageTask.type == null ? "" : jsApiGetStorageTask.type);
                fVar2.y(i2, this.dHc.c(str, hashMap));
                jsApiGetStorageTask.PR();
                v.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", new Object[]{jsApiGetStorageTask.apU, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        };
        jsApiGetStorageTask.PQ();
        AppBrandMainProcessService.a(jsApiGetStorageTask);
    }
}
