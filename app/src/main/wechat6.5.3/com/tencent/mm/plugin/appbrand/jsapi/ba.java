package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

final class ba extends a {
    public static final int CTRL_INDEX = 108;
    public static final String NAME = "reportRealtimeAction";

    ba() {
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("actionData");
        String str = "";
        h a = d.a(fVar);
        if (a != null) {
            String str2 = a.dNn.dOM;
            if (!be.kS(str2) && str2.contains(".html")) {
                str = str2.substring(0, str2.lastIndexOf(".html") + 5);
            }
        }
        AppBrandIDKeyBatchReport.a(2, fVar.dzg, str, 0, optString, nC(fVar.dzg));
        fVar.y(i, c("ok", null));
    }

    public final void a(h hVar, JSONObject jSONObject, int i) {
        String str = "";
        String optString = jSONObject.optString("actionData");
        String str2 = hVar.dNn.dOM;
        if (!be.kS(str2) && str2.contains(".html")) {
            str = str2.substring(0, str2.lastIndexOf(".html") + 5);
        }
        AppBrandIDKeyBatchReport.a(2, hVar.dzg, str, 0, optString, nC(hVar.dzg));
        hVar.y(i, c("ok", null));
    }

    private static String nC(String str) {
        AppBrandStatObject ms = a.ms(str);
        if (ms != null) {
            return be.ma(ms.aWP);
        }
        v.e("MicroMsg.JsApiReportRealtimeAction", "statObject is Null!");
        return "";
    }
}
