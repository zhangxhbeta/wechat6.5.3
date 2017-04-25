package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.g.j;
import org.json.JSONObject;

public final class n extends a {
    public static final int CTRL_INDEX = 21;
    public static final String NAME = "closeSocket";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        j nR = a.dMK.nR(fVar.dzg);
        if (nR != null) {
            nR.QS();
            fVar.y(i, c("ok", null));
            return;
        }
        fVar.y(i, c("fail", null));
    }
}
