package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONObject;

final class ca extends c {
    private static final int CTRL_INDEX = 87;
    public static final String NAME = "updateVideoPlayer";

    ca() {
    }

    protected final int d(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final boolean a(h hVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject.optBoolean("hide")) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        return true;
    }
}
