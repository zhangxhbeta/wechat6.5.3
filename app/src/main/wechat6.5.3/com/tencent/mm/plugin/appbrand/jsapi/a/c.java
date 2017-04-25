package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 119;
    private static final String NAME = "removeTextArea";

    public final void a(h hVar, JSONObject jSONObject, final int i) {
        final String optString = jSONObject.optString("inputId", "");
        if (be.kS(optString)) {
            hVar.y(i, c("fail:invalid data", null));
            return;
        }
        final WeakReference weakReference = new WeakReference(hVar);
        com.tencent.mm.plugin.appbrand.k.a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ c dJZ;

            public final void run() {
                if (((h) weakReference.get()).getContext() instanceof MMActivity) {
                    ((MMActivity) ((h) weakReference.get()).getContext()).axg();
                }
                String str = e.oK(optString) ? "ok" : "fail";
                if (weakReference.get() != null) {
                    ((h) weakReference.get()).y(i, this.dJZ.c(str, null));
                }
            }
        });
    }
}
