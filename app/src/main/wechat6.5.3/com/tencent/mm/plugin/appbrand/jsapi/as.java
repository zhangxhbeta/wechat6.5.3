package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.f.AnonymousClass7;
import org.json.JSONObject;

public final class as extends a {
    public static final int CTRL_INDEX = 13;
    public static final String NAME = "redirectTo";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("url");
        if (a.mu(fVar.dzg).dCu.mZ(optString)) {
            fVar.y(i, c("fail:can not redirect to a tab bar page", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.page.f mp = a.mp(fVar.dzg);
        mp.dNG.dNX = 3;
        mp.runOnUiThread(new AnonymousClass7(mp, optString));
        fVar.y(i, c("ok", null));
    }
}
