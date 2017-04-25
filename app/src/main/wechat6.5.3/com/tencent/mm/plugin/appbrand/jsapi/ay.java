package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ay extends a {
    private static final int CTRL_INDEX = 64;
    private static final String NAME = "reportIDKey";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                g.iuh.a((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt(Columns.VALUE), false);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[]{e.getMessage()});
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
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                g.iuh.a((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt(Columns.VALUE), false);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[]{e.getMessage()});
            }
        }
        hVar.y(i, c("ok", null));
    }
}
