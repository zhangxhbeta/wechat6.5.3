package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u extends a {
    public static final int CTRL_INDEX = 101;
    public static final String NAME = "getAppConfig";

    public static class a extends e {
        private static final int CTRL_INDEX = 109;
        private static final String NAME = "onAppConfig";
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            fVar.y(i, c("fail", null));
            v.e("MicroMsg.JsApiGetAppConfig", "data is null");
            return;
        }
        String str = fVar.dzg;
        final int optInt = jSONObject.optInt(Columns.TYPE, 0);
        v.i("MicroMsg.JsApiGetAppConfig", "getAppConfig app_id:%s,type:%d", new Object[]{str, Integer.valueOf(optInt)});
        if (optInt <= 0) {
            fVar.y(i, c("fail", null));
            v.e("MicroMsg.JsApiGetAppConfig", "type %d is invalid", new Object[]{Integer.valueOf(optInt)});
            return;
        }
        final MainProcessTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask();
        jsApiGetAppConfigTask.appId = str;
        jsApiGetAppConfigTask.type = optInt;
        final f fVar2 = fVar;
        final int i2 = i;
        jsApiGetAppConfigTask.dFu = new Runnable(this) {
            final /* synthetic */ u dGt;

            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put(Columns.TYPE, optInt);
                hashMap.put("data", jsApiGetAppConfigTask.value);
                v.i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", new Object[]{Integer.valueOf(optInt), jsApiGetAppConfigTask.value});
                if (be.kS(jsApiGetAppConfigTask.value)) {
                    fVar2.y(i2, this.dGt.c("fail", null));
                } else {
                    fVar2.y(i2, this.dGt.c("ok", hashMap));
                }
                jsApiGetAppConfigTask.PR();
            }
        };
        jsApiGetAppConfigTask.PQ();
        AppBrandMainProcessService.a(jsApiGetAppConfigTask);
    }
}
