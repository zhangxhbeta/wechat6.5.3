package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class w extends g {
    public static int CTRL_INDEX = 71;
    public static String NAME = "getCurrentRoute";

    public final String a(h hVar) {
        Map hashMap = new HashMap();
        hashMap.put("route", hVar.dNn.dOM);
        v.d("MicroMsg.JsApiGetCurrentRoute", "getCurrentRoute : %s", new Object[]{c("ok", hashMap)});
        return c("ok", hashMap);
    }
}
