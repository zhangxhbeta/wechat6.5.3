package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.widget.input.c.g;
import com.tencent.mm.plugin.appbrand.widget.input.c.h;
import com.tencent.mm.sdk.platformtools.be;
import org.json.JSONObject;

public class e extends a<h> {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    public void a(com.tencent.mm.plugin.appbrand.page.h hVar, JSONObject jSONObject, int i) {
        final g hVar2 = new h();
        if (a(hVar2, jSONObject, hVar, i)) {
            final String optString = jSONObject.optString("inputId", "");
            if (be.kS(optString)) {
                hVar.y(i, c("fail:invalid data", null));
                return;
            }
            String optString2 = jSONObject.optString("data", null);
            if (optString2 != null) {
                a.aM(optString, optString2);
            }
            final com.tencent.mm.plugin.appbrand.page.h hVar3 = hVar;
            final int i2 = i;
            a.runOnUiThread(new Runnable(this) {
                final /* synthetic */ e dKf;

                public final void run() {
                    if (com.tencent.mm.plugin.appbrand.widget.input.e.a(hVar2, optString)) {
                        hVar3.y(i2, this.dKf.c("ok", null));
                    } else {
                        hVar3.y(i2, this.dKf.c("fail", null));
                    }
                }
            });
        }
    }

    protected final boolean Qr() {
        return true;
    }
}
