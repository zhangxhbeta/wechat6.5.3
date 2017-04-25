package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.be;
import org.json.JSONObject;

final class ap extends a {
    public static final int CTRL_INDEX = 0;
    public static final String NAME = "openLink";

    ap() {
    }

    public final void a(h hVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("url");
        if (be.kS(optString)) {
            hVar.y(i, c("fail", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", optString);
        c.b(hVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        hVar.y(i, c("ok", null));
    }
}
