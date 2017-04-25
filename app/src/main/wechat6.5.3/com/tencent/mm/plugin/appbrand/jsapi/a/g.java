package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 70;
    public static final String NAME = "hideKeyboard";

    static /* synthetic */ String b(h hVar) {
        return e.l(hVar) ? "ok" : "fail:input not exists";
    }

    public final void a(final h hVar, JSONObject jSONObject, final int i) {
        ad.o(new Runnable(this) {
            final /* synthetic */ g owf;

            public final void run() {
                if (hVar.ZO) {
                    hVar.y(i, this.owf.c(g.b(hVar), null));
                }
            }
        });
    }

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        ad.o(new Runnable(this) {
            final /* synthetic */ g owf;

            public final void run() {
                if (fVar.ZO) {
                    fVar.y(i, this.owf.c(g.b(d.a(fVar)), null));
                }
            }
        });
    }
}
