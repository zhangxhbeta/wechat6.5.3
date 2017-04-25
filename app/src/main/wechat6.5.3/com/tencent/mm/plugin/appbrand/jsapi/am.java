package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import org.json.JSONObject;

public final class am extends a {
    public static final int CTRL_INDEX = 15;
    public static final String NAME = "navigateBack";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        a.mp(fVar.dzg).hi(jSONObject.optInt("delta", 1));
        fVar.y(i, c("ok", null));
    }
}
