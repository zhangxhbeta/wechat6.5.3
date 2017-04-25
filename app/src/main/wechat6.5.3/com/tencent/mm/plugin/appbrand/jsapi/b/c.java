package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 84;
    public static final String NAME = "showDatePickerView";

    public final void a(h hVar, JSONObject jSONObject, int i) {
        super.a(hVar, jSONObject, i);
        String optString = jSONObject.optString("mode");
        if ("date".equals(optString)) {
            new a().a(this, hVar, jSONObject, i);
        } else if ("time".equals(optString)) {
            new f().a(this, hVar, jSONObject, i);
        } else {
            hVar.y(i, c("fail:invalid data", null));
        }
    }
}
