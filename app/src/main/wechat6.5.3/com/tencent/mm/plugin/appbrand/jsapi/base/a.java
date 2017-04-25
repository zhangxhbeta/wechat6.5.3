package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.util.DisplayMetrics;
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

public abstract class a extends d {
    public abstract View a(h hVar, JSONObject jSONObject);

    static /* synthetic */ void a(a aVar, final h hVar, final int i) {
        final b a = aVar.a(hVar, i, true);
        if (((h.b) a.a("baseViewDestroyListener", h.b.class)) == null) {
            h.b anonymousClass3 = new h.b(aVar) {
                final /* synthetic */ a dJu;

                public final void onDestroy() {
                    hVar.b((h.b) this);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 dJv;

                        {
                            this.dJv = r1;
                        }

                        public final void run() {
                            View nE = e.Qp().nE(e.a(hVar, this.dJv.dJu.Qd(), i));
                            if (nE != null) {
                                hVar.dNn.dOO.by(nE);
                            }
                        }
                    });
                    this.dJu.a(hVar, i);
                    a.recycle();
                    System.gc();
                }
            };
            a.l("baseViewDestroyListener", anonymousClass3);
            hVar.a(anonymousClass3);
        }
    }

    static /* synthetic */ void a(a aVar, h hVar, int i, View view, JSONObject jSONObject) {
        if (aVar.Qj()) {
            b a = aVar.a(hVar, i, true);
            a.o("disableScroll", jSONObject.optBoolean("disableScroll", false));
            a.o("enableLongClick", aVar.Qk());
            a.G("data", jSONObject.optString("data"));
            if (!jSONObject.optBoolean("gesture", false)) {
                return;
            }
            if (hVar == null || view == null || a == null) {
                v.i("MicroMsg.ViewMotionHelper", "setOnTouchListener failed, page or view or keyValueSet is null.");
            } else {
                view.setOnTouchListener(new d(hVar, a));
            }
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        super.a(fVar, jSONObject, i);
        h a = d.a(fVar);
        if (a == null) {
            v.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi insertView failed, current page view is null.");
            fVar.y(i, a(a, false, 0, "page is null"));
            return;
        }
        final WeakReference weakReference = new WeakReference(a);
        final f fVar2 = fVar;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        ad.o(new Runnable(this) {
            final /* synthetic */ a dJu;

            public final void run() {
                h hVar = (h) weakReference.get();
                if (hVar == null) {
                    v.w("MicroMsg.BaseInsertViewJsApi", "page view has been release.");
                    fVar2.y(i2, this.dJu.a(hVar, false, 0, "page is null"));
                    return;
                }
                View a = this.dJu.a(hVar, jSONObject2);
                if (a == null) {
                    v.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
                    fVar2.y(i2, this.dJu.a(hVar, false, 0, "inflate view failed"));
                    return;
                }
                int d;
                try {
                    d = this.dJu.d(jSONObject2);
                } catch (JSONException e) {
                    d = e.a(hVar, a);
                }
                String a2 = e.a(hVar, this.dJu.Qd(), d);
                if (e.Qp().contains(a2)) {
                    v.w("MicroMsg.BaseInsertViewJsApi", "insert view(%s) failed, it has been inserted before.", new Object[]{a2});
                    fVar2.y(i2, this.dJu.a(hVar, false, d, "the view has already exist"));
                    return;
                }
                boolean a3 = a.a(hVar, jSONObject2, a);
                if (a3) {
                    e.Qp().a(a2, a);
                    a.a(this.dJu, hVar, d, a, jSONObject2);
                    this.dJu.b(hVar, d, a, jSONObject2);
                }
                a.a(this.dJu, hVar, d);
                v.i("MicroMsg.BaseInsertViewJsApi", "insert view(viewId : %s, view : %s, r : %s)", new Object[]{Integer.valueOf(d), Integer.valueOf(a.hashCode()), Boolean.valueOf(a3)});
                fVar2.y(i2, this.dJu.a(hVar, a3, d, a3 ? null : "insert view fail"));
            }
        });
    }

    public final void a(final h hVar, final JSONObject jSONObject, final int i) {
        super.a(hVar, jSONObject, i);
        ad.o(new Runnable(this) {
            final /* synthetic */ a dJu;

            public final void run() {
                View a = this.dJu.a(hVar, jSONObject);
                if (a == null) {
                    v.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
                    hVar.y(i, this.dJu.a(hVar, false, 0, "page is null"));
                    return;
                }
                int d;
                try {
                    d = this.dJu.d(jSONObject);
                } catch (JSONException e) {
                    d = e.a(hVar, a);
                }
                String a2 = e.a(hVar, this.dJu.Qd(), d);
                if (e.Qp().contains(a2)) {
                    v.w("MicroMsg.BaseInsertViewJsApi", "insert view(%s) failed, it has been inserted before.", new Object[]{a2});
                    hVar.y(i, this.dJu.a(hVar, false, d, "the view has already exist"));
                    return;
                }
                boolean a3 = a.a(hVar, jSONObject, a);
                if (a3) {
                    e.Qp().a(a2, a);
                    a.a(this.dJu, hVar, d, a, jSONObject);
                    this.dJu.b(hVar, d, a, jSONObject);
                }
                a.a(this.dJu, hVar, d);
                v.i("MicroMsg.BaseInsertViewJsApi", "insert view(viewId : %s, view : %s, r : %s)", new Object[]{Integer.valueOf(d), Integer.valueOf(a.hashCode()), Boolean.valueOf(a3)});
                hVar.y(i, this.dJu.a(hVar, a3, d, a3 ? null : "insert view fail"));
            }
        });
    }

    public void b(h hVar, int i, View view, JSONObject jSONObject) {
    }

    public boolean Qj() {
        return false;
    }

    public boolean Qk() {
        return false;
    }

    protected static boolean a(h hVar, JSONObject jSONObject, View view) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("position"));
            if (jSONObject2.length() < 4) {
                return false;
            }
            int a = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject2, "top");
            int a2 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject2, "left");
            int a3 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject2, "width");
            int a4 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject2, "height");
            int optInt = jSONObject.optInt("zIndex", 0);
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            v.d("MicroMsg.BaseInsertViewJsApi", "insertView(z:%s, t:%s, l:%s, w:%s, h:%s), window(w:%s, h:%s, d:%s)", new Object[]{Integer.valueOf(optInt), Integer.valueOf(a), Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Float.valueOf(displayMetrics.density)});
            return hVar.dNn.dOO.a(view, optInt, a3, a4, a2, a);
        } catch (Exception e) {
            v.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[]{e});
            return false;
        }
    }
}
