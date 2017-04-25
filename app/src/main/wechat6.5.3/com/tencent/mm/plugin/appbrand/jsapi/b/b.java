package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.page.h;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class b extends com.tencent.mm.plugin.appbrand.widget.b.b {
    private int dFQ;
    private WeakReference<h> dGH;
    private d dKR;

    abstract void e(JSONObject jSONObject);

    b() {
    }

    final void a(d dVar, h hVar, JSONObject jSONObject, int i) {
        a.aC(this);
        this.dKR = dVar;
        this.dGH = new WeakReference(hVar);
        this.dFQ = i;
        e(jSONObject);
    }

    protected final View Qz() {
        return this.dGH == null ? null : (h) this.dGH.get();
    }

    final void d(String str, Map<String, Object> map) {
        a.aD(this);
        if (this.dGH != null && this.dGH.get() != null && this.dKR != null) {
            ((h) this.dGH.get()).y(this.dFQ, this.dKR.c(str, map));
        }
    }
}
