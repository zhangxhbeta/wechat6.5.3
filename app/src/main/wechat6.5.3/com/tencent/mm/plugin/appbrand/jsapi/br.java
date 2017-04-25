package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import org.json.JSONObject;

public final class br extends a {
    public static final int CTRL_INDEX = 150;
    public static final String NAME = "switchTab";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("url");
        if (a.mu(fVar.dzg).dCu.mZ(optString)) {
            a.mp(fVar.dzg).nZ(optString);
            fVar.y(i, c("ok", null));
            return;
        }
        fVar.y(i, c("fail:can not switch to non-TabBar page", null));
    }
}
