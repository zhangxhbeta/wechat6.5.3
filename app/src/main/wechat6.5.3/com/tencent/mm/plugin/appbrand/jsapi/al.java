package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.be;
import org.json.JSONObject;

public final class al extends a {
    public static final int CTRL_INDEX = 102;
    public static final String NAME = "makePhoneCall";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("phoneNumber");
        if (be.kS(optString)) {
            fVar.y(i, c("fail", null));
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + optString));
        d.nt(fVar.dzg).startActivity(intent);
        fVar.y(i, c("ok", null));
    }
}
