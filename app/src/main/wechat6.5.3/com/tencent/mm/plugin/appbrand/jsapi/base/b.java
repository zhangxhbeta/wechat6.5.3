package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b extends d {
    public final void a(h hVar, JSONObject jSONObject, int i) {
        super.a(hVar, jSONObject, i);
        try {
            boolean a;
            int d = d(jSONObject);
            View nE = e.Qp().nE(e.a(hVar, Qd(), d));
            if (nE != null) {
                hVar.dNn.dOO.by(nE);
                a = a(hVar, d, nE);
            } else {
                a = false;
            }
            if (a) {
                a(hVar, d);
            }
            v.i("MicroMsg.BaseRemoveViewJsApi", "remove view(viewId : %s, view : %s, r : %s)", new Object[]{Integer.valueOf(d), nE, Boolean.valueOf(a)});
            hVar.y(i, a(hVar, a, d, a ? null : "remove view from ViewManager failed"));
        } catch (JSONException e) {
            v.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[]{e});
            hVar.y(i, a(hVar, false, 0, "view id do not exist"));
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        super.a(fVar, jSONObject, i);
        h a = d.a(fVar);
        if (a == null) {
            v.w("MicroMsg.BaseRemoveViewJsApi", "Remove view failed, AppBrandPageView is null.");
            fVar.y(i, a(a, false, 0, "page is null"));
            return;
        }
        try {
            boolean a2;
            String str;
            int d = d(jSONObject);
            View nE = e.Qp().nE(e.a(a, Qd(), d));
            if (nE != null) {
                a.dNn.dOO.by(nE);
                a2 = a(a, d, nE);
            } else {
                a2 = false;
            }
            if (a2) {
                a(a, d);
            }
            v.i("MicroMsg.BaseRemoveViewJsApi", "remove view(viewId : %s, view : %s, r : %s)", new Object[]{Integer.valueOf(d), nE, Boolean.valueOf(a2)});
            if (a2) {
                str = null;
            } else {
                str = "remove view from ViewManager failed";
            }
            fVar.y(i, a(a, a2, d, str));
        } catch (JSONException e) {
            v.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. Exception : %s", new Object[]{e});
            fVar.y(i, a(a, false, 0, "view id do not exist"));
        }
    }

    public boolean a(h hVar, int i, View view) {
        return true;
    }
}
