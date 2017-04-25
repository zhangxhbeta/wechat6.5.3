package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONObject;

public final class bu extends c {
    public static final int CTRL_INDEX = 122;
    public static final String NAME = "updateShareButton";

    protected final int d(JSONObject jSONObject) {
        return jSONObject.getInt("shareButtonId");
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final boolean a(h hVar, int i, View view, JSONObject jSONObject) {
        a(hVar, i, true).G("data", jSONObject.optString("data", ""));
        return super.a(hVar, i, view, jSONObject);
    }

    protected final boolean Qe() {
        return true;
    }
}
