package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c extends d {
    static /* synthetic */ void a(c cVar, h hVar, int i, JSONObject jSONObject) {
        boolean z = false;
        if (cVar.Qj()) {
            try {
                b a = cVar.a(hVar, i, false);
                if (a != null) {
                    boolean z2 = jSONObject.getBoolean("disableScroll");
                    if (a.fA("isTouching")) {
                        String str = "disableScroll";
                        if (!z2) {
                            z = true;
                        }
                        if (a.getBoolean(str, z) != z2) {
                            a.o("disableScroll-nextState", z2);
                            return;
                        }
                        return;
                    }
                    a.o("disableScroll", z2);
                }
            } catch (JSONException e) {
            }
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        super.a(fVar, jSONObject, i);
        h a = d.a(fVar);
        if (a == null) {
            v.w("MicroMsg.BaseUpdateViewJsApi", "invoke JsApi updateView failed, current page view is null.");
            fVar.y(i, a(a, false, 0, "page is null"));
            return;
        }
        final WeakReference weakReference = new WeakReference(a);
        final f fVar2 = fVar;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        ad.o(new Runnable(this) {
            final /* synthetic */ c dJw;

            public final void run() {
                h hVar = (h) weakReference.get();
                if (hVar == null) {
                    v.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
                    fVar2.y(i2, this.dJw.a(hVar, false, 0, "page is null"));
                    return;
                }
                try {
                    int d = this.dJw.d(jSONObject2);
                    View nF = e.Qp().nF(e.a(hVar, this.dJw.Qd(), d));
                    if (nF == null) {
                        v.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[]{Integer.valueOf(d)});
                        fVar2.y(i2, this.dJw.a(hVar, false, d, "got 'null' when get view by the given viewId"));
                        return;
                    }
                    boolean z;
                    boolean a;
                    try {
                        nF.setVisibility(jSONObject2.getBoolean("hide") ? 8 : 0);
                        z = true;
                    } catch (JSONException e) {
                        z = false;
                    }
                    Object obj = null;
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = jSONObject2.getJSONObject("position");
                        obj = 1;
                    } catch (Exception e2) {
                        if (!this.dJw.Qe()) {
                            v.e("MicroMsg.BaseUpdateViewJsApi", "parse position error. Exception :%s", new Object[]{e2});
                            fVar2.y(i2, this.dJw.a(hVar, z, d, "missing the parameter 'position'"));
                            return;
                        }
                    }
                    c.a(this.dJw, hVar, d, jSONObject2);
                    if (obj == null) {
                        v.i("MicroMsg.BaseUpdateViewJsApi", "just update data.");
                        a = this.dJw.a(hVar, d, nF, jSONObject2);
                    } else if (jSONObject == null || jSONObject.length() < 4) {
                        fVar2.y(i2, this.dJw.a(hVar, z, d, "illegal parameter 'position'"));
                        return;
                    } else {
                        int a2 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject, "top");
                        int a3 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject, "left");
                        int a4 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject, "width");
                        int a5 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject, "height");
                        int optInt = jSONObject2.optInt("zIndex", 0);
                        hVar.dNn.dOO.by(nF);
                        a = hVar.dNn.dOO.a(nF, optInt, a4, a5, a3, a2) || z;
                        if (a) {
                            a = this.dJw.a(hVar, d, nF, jSONObject2);
                        }
                        v.i("MicroMsg.BaseUpdateViewJsApi", "update view(viewId : %s, view : %s, zIndex : %s, width : %s, height : %s, left : %s, top : %s), r : %s.", new Object[]{Integer.valueOf(d), Integer.valueOf(nF.hashCode()), Integer.valueOf(optInt), Integer.valueOf(a4), Integer.valueOf(a5), Integer.valueOf(a3), Integer.valueOf(a2), Boolean.valueOf(a)});
                    }
                    Object a6 = this.dJw.a(hVar, a, d, a ? null : "update view fail");
                    if (!TextUtils.isEmpty(a6)) {
                        fVar2.y(i2, a6);
                    }
                } catch (JSONException e3) {
                    v.e("MicroMsg.BaseUpdateViewJsApi", "get viewId error. Exception : %s", new Object[]{e3});
                    fVar2.y(i2, this.dJw.a(hVar, false, 0, "view id do not exist"));
                }
            }
        });
    }

    public final void a(final h hVar, final JSONObject jSONObject, final int i) {
        super.a(hVar, jSONObject, i);
        ad.o(new Runnable(this) {
            final /* synthetic */ c dJw;

            public final void run() {
                boolean z;
                try {
                    int d = this.dJw.d(jSONObject);
                    View nF = e.Qp().nF(e.a(hVar, this.dJw.Qd(), d));
                    if (nF == null) {
                        v.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[]{Integer.valueOf(d)});
                        hVar.y(i, this.dJw.a(hVar, false, d, "got 'null' when get view by the given viewId"));
                        return;
                    }
                    boolean a;
                    try {
                        nF.setVisibility(jSONObject.getBoolean("hide") ? 8 : 0);
                        z = true;
                    } catch (JSONException e) {
                        z = false;
                    }
                    Object obj = null;
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = jSONObject.getJSONObject("position");
                        obj = 1;
                    } catch (Exception e2) {
                        if (!this.dJw.Qe()) {
                            v.e("MicroMsg.BaseUpdateViewJsApi", "parse position error. Exception :%s", new Object[]{e2});
                            hVar.y(i, this.dJw.a(hVar, z, d, "missing the parameter 'position'"));
                            return;
                        }
                    }
                    c.a(this.dJw, hVar, d, jSONObject);
                    if (obj == null) {
                        v.i("MicroMsg.BaseUpdateViewJsApi", "just update data.");
                        a = this.dJw.a(hVar, d, nF, jSONObject);
                    } else if (jSONObject == null || jSONObject.length() < 4) {
                        hVar.y(i, this.dJw.a(hVar, z, d, "illegal parameter 'position'"));
                        return;
                    } else {
                        int a2 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject, "top");
                        int a3 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject, "left");
                        int a4 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject, "width");
                        int a5 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject, "height");
                        int optInt = jSONObject.optInt("zIndex", 0);
                        hVar.dNn.dOO.by(nF);
                        a = hVar.dNn.dOO.a(nF, optInt, a4, a5, a3, a2) || z;
                        if (a) {
                            a = this.dJw.a(hVar, d, nF, jSONObject);
                        }
                        v.i("MicroMsg.BaseUpdateViewJsApi", "update view(viewId : %s, view : %s, zIndex : %s, width : %s, height : %s, left : %s, top : %s), r : %s.", new Object[]{Integer.valueOf(d), Integer.valueOf(nF.hashCode()), Integer.valueOf(optInt), Integer.valueOf(a4), Integer.valueOf(a5), Integer.valueOf(a3), Integer.valueOf(a2), Boolean.valueOf(a)});
                    }
                    Object a6 = this.dJw.a(hVar, a, d, a ? null : "update view fail");
                    if (!TextUtils.isEmpty(a6)) {
                        hVar.y(i, a6);
                    }
                } catch (Exception e3) {
                    v.e("MicroMsg.BaseUpdateViewJsApi", "get viewId error. Exception : %s", new Object[]{e3});
                    hVar.y(i, this.dJw.a(hVar, false, 0, "view id do not exist"));
                }
            }
        });
    }

    public boolean a(h hVar, int i, View view, JSONObject jSONObject) {
        return true;
    }

    public boolean Qe() {
        return false;
    }

    public boolean Qj() {
        return false;
    }
}
