package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.model.o;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d extends a {
    public abstract String a(h hVar, boolean z, int i, String str);

    public String Qd() {
        return "";
    }

    public int d(JSONObject jSONObject) {
        throw new JSONException("viewId do not exist, override the method getViewId(data).");
    }

    public final b a(h hVar, int i) {
        return o.yx().fy(e.a(hVar, Qd(), i));
    }

    public final b a(h hVar, int i, boolean z) {
        return o.yx().n(e.a(hVar, Qd(), i), z);
    }
}
