package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class ai extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "initReady";
    private int dHj = 0;
    private long start;

    public final void a(h hVar, JSONObject jSONObject, int i) {
        if (jSONObject.keys().hasNext()) {
            this.dHj++;
        } else {
            this.start = System.currentTimeMillis();
            hVar.runOnUiThread(new Runnable(hVar) {
                final /* synthetic */ h dOj;

                {
                    this.dOj = r1;
                }

                public final void run() {
                    l lVar = this.dOj.dNn;
                    com.tencent.mm.plugin.appbrand.report.a.n(4, System.currentTimeMillis() - lVar.dOT);
                    lVar.evaluateJavascript("var raf_count = 0;\nfunction step(timestamp) {\n    ++raf_count;\n    typeof wx !== 'undefined' && wx.invoke('initReady', {'xx':'xx'});\n    if (raf_count < 1) {\n        window.requestAnimationFrame(step);\n    }\n};\nwindow.requestAnimationFrame(step);", null);
                }
            });
        }
        if (this.dHj > 0) {
            a.n(5, System.currentTimeMillis() - this.start);
            v.i("MicroMsg.JsApiInitReady", "onReady -> Real onReady: %d", new Object[]{Long.valueOf(r0)});
            hVar.onReady();
        }
    }
}
