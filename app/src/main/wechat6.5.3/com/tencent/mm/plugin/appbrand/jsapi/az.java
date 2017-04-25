package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class az extends a {
    public static final int CTRL_INDEX = 63;
    public static final String NAME = "reportKeyValue";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        if (a.mr(fVar.dzg) == null) {
            v.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            fVar.y(i, c("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(Columns.VALUE);
                if (optInt > 0 && !be.kS(optString)) {
                    g.iuh.h(optInt, new Object[]{fVar.dzg, Integer.valueOf(r4.dDB.dBs), Integer.valueOf(r4.dDB.dBr + 1), optString});
                }
            } catch (Exception e) {
                v.e("MicroMsg.JsApiReportKeyValue", "AppBrandService parse report value failed : %s", new Object[]{e.getMessage()});
            }
        }
        fVar.y(i, c("ok", null));
    }

    public final void a(h hVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            hVar.y(i, c("fail", null));
            return;
        }
        if (a.mr(hVar.dzg) == null) {
            v.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            hVar.y(i, c("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(Columns.VALUE);
                if (optInt > 0 && !be.kS(optString)) {
                    g.iuh.h(optInt, new Object[]{hVar.dzg, Integer.valueOf(r4.dDB.dBs), Integer.valueOf(r4.dDB.dBr + 1), optString});
                }
            } catch (Exception e) {
                v.e("MicroMsg.JsApiReportKeyValue", "AppBrandPageView parse report value failed : %s", new Object[]{e.getMessage()});
            }
        }
        hVar.y(i, c("ok", null));
    }
}
