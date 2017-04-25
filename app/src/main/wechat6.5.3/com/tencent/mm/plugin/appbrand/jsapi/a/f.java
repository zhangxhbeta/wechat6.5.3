package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.g;
import org.json.JSONObject;

public final class f extends e {
    private static final int CTRL_INDEX = 111;
    private static final String NAME = "updateTextArea";

    protected final /* synthetic */ boolean a(g gVar, JSONObject jSONObject, h hVar, int i) {
        c.h hVar2 = (c.h) gVar;
        boolean a = super.a(hVar2, jSONObject, hVar, i);
        hVar2.dXw = Boolean.valueOf(true);
        hVar2.lqJ = Boolean.valueOf(false);
        hVar2.dXx = Boolean.valueOf(true);
        return a;
    }

    public final void a(h hVar, JSONObject jSONObject, int i) {
        super.a(hVar, jSONObject, i);
    }
}
