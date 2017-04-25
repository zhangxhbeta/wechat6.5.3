package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.AppBrandPageActionSheet.c;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONObject;

public final class bo extends a {
    public static final int CTRL_INDEX = 146;
    public static final String NAME = "showShareMenu";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        h a = d.a(fVar);
        if (a != null) {
            c cVar = c.ShareAppMsg;
            if (cVar != null) {
                a.lqh.remove(cVar);
            }
        }
        fVar.y(i, c("ok", null));
    }
}
