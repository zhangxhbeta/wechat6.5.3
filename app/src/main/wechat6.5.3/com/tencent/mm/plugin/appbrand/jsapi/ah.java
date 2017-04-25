package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import com.tencent.mm.model.o;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class ah extends a {
    private static final int CTRL_INDEX = 106;
    private static final String NAME = "hideToast";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        b fy = o.yx().fy(fVar.hashCode() + "toast_name");
        if (fy == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        final View view = (View) fy.a("toast_view", View.class);
        if (view != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ ah dHi;

                public final void run() {
                    view.setVisibility(8);
                    fVar.y(i, this.dHi.c("ok", null));
                }
            });
        } else {
            fVar.y(i, c("fail", null));
        }
    }
}
