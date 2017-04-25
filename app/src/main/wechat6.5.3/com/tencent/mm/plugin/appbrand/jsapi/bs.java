package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class bs extends a {
    public static final int CTRL_INDEX = 65;
    public static final String NAME = "systemLog";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        v.i("AppBrandLog." + fVar.dzg, jSONObject.optString("message"));
    }

    public final void a(h hVar, JSONObject jSONObject, int i) {
        v.i("AppBrandLog." + hVar.dzg, jSONObject.optString("message"));
    }
}
