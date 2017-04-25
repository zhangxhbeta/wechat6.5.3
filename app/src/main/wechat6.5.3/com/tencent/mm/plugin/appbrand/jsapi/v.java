package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v extends a {
    public static final int CTRL_INDEX = 152;
    public static final String NAME = "getContactMessageCount";

    public static class a extends e {
        private static final int CTRL_INDEX = 152;
        private static final String NAME = "onContactMessageCountChange";
    }

    public final void a(final h hVar, JSONObject jSONObject, final int i) {
        String str = "";
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(hVar.dzg);
        if (mr != null) {
            str = mr.aWH;
        }
        if (be.kS(str)) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiGetAppConfig", "getContactMessageCount username is empty!!!");
        }
        final MainProcessTask jsApiGetContactMessageCountTask = new JsApiGetContactMessageCountTask();
        jsApiGetContactMessageCountTask.username = str;
        jsApiGetContactMessageCountTask.dFu = new Runnable(this) {
            final /* synthetic */ v dGw;

            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put("count", jsApiGetContactMessageCountTask.aWI);
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiGetAppConfig", "JsApiGetContactMessageCountTask unreadCount:%d", new Object[]{Integer.valueOf(jsApiGetContactMessageCountTask.aWI)});
                if (jsApiGetContactMessageCountTask.aWI == -1) {
                    hVar.y(i, this.dGw.c("fail", null));
                } else {
                    hVar.y(i, this.dGw.c("ok", hashMap));
                }
                jsApiGetContactMessageCountTask.PR();
            }
        };
        jsApiGetContactMessageCountTask.PQ();
        AppBrandMainProcessService.a(jsApiGetContactMessageCountTask);
    }
}
