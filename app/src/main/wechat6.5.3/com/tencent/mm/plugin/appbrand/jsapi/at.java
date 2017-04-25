package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONObject;

public final class at extends b {
    public static final int CTRL_INDEX = 68;
    public static final String NAME = "removeCanvas";

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final String Qd() {
        return "canvas";
    }

    protected final int d(JSONObject jSONObject) {
        return jSONObject.optInt("canvasId");
    }
}
