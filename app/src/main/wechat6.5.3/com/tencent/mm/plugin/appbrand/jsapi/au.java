package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONObject;

public final class au extends b {
    public static final int CTRL_INDEX = 123;
    public static final String NAME = "removeShareButton";

    protected final int d(JSONObject jSONObject) {
        return jSONObject.getInt("shareButtonId");
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }
}
