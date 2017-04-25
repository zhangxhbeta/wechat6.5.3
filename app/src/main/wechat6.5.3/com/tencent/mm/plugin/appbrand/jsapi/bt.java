package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONObject;

final class bt extends c {
    public static final int CTRL_INDEX = 83;
    public static final String NAME = "updateCanvas";

    bt() {
    }

    protected final String Qd() {
        return "canvas";
    }

    protected final int d(JSONObject jSONObject) {
        return jSONObject.optInt("canvasId");
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final boolean Qe() {
        return true;
    }

    protected final boolean Qj() {
        return true;
    }
}
