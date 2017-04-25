package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import org.json.JSONObject;

public final class bq extends a {
    public static final int CTRL_INDEX = 12;
    public static final String NAME = "stopPullDownRefresh";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        h a = d.a(fVar);
        a.runOnUiThread(new Runnable(a) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void run() {
                this.dOj.dOi.Ry();
            }
        });
    }
}
