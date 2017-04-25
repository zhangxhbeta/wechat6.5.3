package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import org.json.JSONObject;

public final class bh extends a {
    public static final int CTRL_INDEX = 8;
    public static final String NAME = "setNavigationBarTitle";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("title");
        com.tencent.mm.plugin.appbrand.page.f mp = a.mp(fVar.dzg);
        if (mp == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        mp.Rm().QZ().of(optString);
        fVar.y(i, c("ok", null));
    }
}
