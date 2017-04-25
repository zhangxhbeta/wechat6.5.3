package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class an extends a {
    public static final int CTRL_INDEX = 14;
    public static final String NAME = "navigateTo";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        if (a.mp(fVar.dzg).dNC.size() >= 5) {
            fVar.y(i, c("fail:page limit exceeded", null));
            v.e("MicroMsg.JsApiNavigateTo", "page limit exceeded");
            return;
        }
        String optString = jSONObject.optString("url");
        if (a.mu(fVar.dzg).dCu.mZ(optString)) {
            fVar.y(i, c("fail:can not navigate to a tab bar page", null));
            return;
        }
        a.mp(fVar.dzg).nY(optString);
        fVar.y(i, c("ok", null));
    }
}
