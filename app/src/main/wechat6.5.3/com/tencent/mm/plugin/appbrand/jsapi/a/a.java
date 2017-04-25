package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.graphics.Color;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.c.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

abstract class a<P extends g> extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a() {
    }

    protected boolean a(P p, JSONObject jSONObject, h hVar, int i) {
        JSONObject jSONObject2;
        Throwable e;
        JSONObject jSONObject3;
        try {
            jSONObject2 = new JSONObject(jSONObject.getString("style"));
            try {
                p.dXf = Integer.valueOf(d.ht(jSONObject2.getInt("width")));
                p.dXg = Integer.valueOf(d.ht(jSONObject2.optInt("height", -1)));
                p.dXh = Integer.valueOf(d.ht(jSONObject2.getInt("top")));
                p.dXi = Integer.valueOf(d.ht(jSONObject2.getInt("left")));
            } catch (Exception e2) {
                e = e2;
                if (!Qr()) {
                    v.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", new Object[]{be.e(e)});
                    hVar.y(i, c("fail:invalid data", null));
                    return false;
                }
                if (jSONObject2 == null) {
                    p.dXo = jSONObject2.optString("fontWeight", "normal");
                    p.dXn = jSONObject2.optString("fontFamily", "");
                    p.dXj = jSONObject2.optString("textAlign", null);
                    try {
                        p.dXl = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                    } catch (Exception e3) {
                    }
                    try {
                        p.dXk = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                    } catch (Exception e4) {
                    }
                    try {
                        p.dXm = Integer.valueOf(d.ht(jSONObject2.getInt("fontSize")));
                    } catch (Exception e5) {
                    }
                    try {
                        p.dXA = Integer.valueOf(d.ht(jSONObject2.getInt("marginBottom")));
                    } catch (Exception e6) {
                        p.dXA = null;
                    }
                } else if (!Qr()) {
                    v.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                    hVar.y(i, c("fail:invalid data", null));
                    return false;
                }
                p.dXy = Boolean.valueOf(jSONObject.optBoolean("autoSize", false));
                p.dXe = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
                p.dXp = Integer.valueOf(jSONObject.optInt("maxLength", -1));
                p.dXq = jSONObject.optString("placeholder");
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
                p.dXt = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
                p.dXs = Integer.valueOf(d.ht(jSONObject3.getInt("fontSize")));
                p.dXr = jSONObject3.optString("fontWeight", "normal");
                p.dXv = Boolean.valueOf(jSONObject.optBoolean("hidden", false));
                p.dXu = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                p.dXz = Boolean.valueOf(jSONObject.getBoolean("fixed"));
                p.lqI = com.tencent.mm.plugin.appbrand.widget.input.e.a.Rj(jSONObject.optString("confirmType"));
                p.lqJ = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
                return true;
            }
        } catch (Exception e7) {
            e = e7;
            jSONObject2 = null;
            if (Qr()) {
                v.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", new Object[]{be.e(e)});
                hVar.y(i, c("fail:invalid data", null));
                return false;
            }
            if (jSONObject2 == null) {
                p.dXo = jSONObject2.optString("fontWeight", "normal");
                p.dXn = jSONObject2.optString("fontFamily", "");
                p.dXj = jSONObject2.optString("textAlign", null);
                p.dXl = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                p.dXk = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                p.dXm = Integer.valueOf(d.ht(jSONObject2.getInt("fontSize")));
                p.dXA = Integer.valueOf(d.ht(jSONObject2.getInt("marginBottom")));
            } else if (Qr()) {
                v.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                hVar.y(i, c("fail:invalid data", null));
                return false;
            }
            p.dXy = Boolean.valueOf(jSONObject.optBoolean("autoSize", false));
            p.dXe = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
            p.dXp = Integer.valueOf(jSONObject.optInt("maxLength", -1));
            p.dXq = jSONObject.optString("placeholder");
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.dXt = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.dXs = Integer.valueOf(d.ht(jSONObject3.getInt("fontSize")));
            p.dXr = jSONObject3.optString("fontWeight", "normal");
            p.dXv = Boolean.valueOf(jSONObject.optBoolean("hidden", false));
            p.dXu = Boolean.valueOf(jSONObject.getBoolean("disabled"));
            p.dXz = Boolean.valueOf(jSONObject.getBoolean("fixed"));
            p.lqI = com.tencent.mm.plugin.appbrand.widget.input.e.a.Rj(jSONObject.optString("confirmType"));
            p.lqJ = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
            return true;
        }
        if (jSONObject2 == null) {
            p.dXo = jSONObject2.optString("fontWeight", "normal");
            p.dXn = jSONObject2.optString("fontFamily", "");
            p.dXj = jSONObject2.optString("textAlign", null);
            p.dXl = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
            p.dXk = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
            p.dXm = Integer.valueOf(d.ht(jSONObject2.getInt("fontSize")));
            p.dXA = Integer.valueOf(d.ht(jSONObject2.getInt("marginBottom")));
        } else if (Qr()) {
            v.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
            hVar.y(i, c("fail:invalid data", null));
            return false;
        }
        p.dXy = Boolean.valueOf(jSONObject.optBoolean("autoSize", false));
        p.dXe = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
        p.dXp = Integer.valueOf(jSONObject.optInt("maxLength", -1));
        p.dXq = jSONObject.optString("placeholder");
        try {
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.dXt = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.dXs = Integer.valueOf(d.ht(jSONObject3.getInt("fontSize")));
            p.dXr = jSONObject3.optString("fontWeight", "normal");
        } catch (Exception e8) {
        }
        p.dXv = Boolean.valueOf(jSONObject.optBoolean("hidden", false));
        try {
            p.dXu = Boolean.valueOf(jSONObject.getBoolean("disabled"));
        } catch (Exception e9) {
            p.dXu = null;
        }
        try {
            p.dXz = Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (Exception e10) {
            p.dXz = null;
        }
        p.lqI = com.tencent.mm.plugin.appbrand.widget.input.e.a.Rj(jSONObject.optString("confirmType"));
        try {
            p.lqJ = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
        } catch (Exception e11) {
            p.lqJ = null;
        }
        return true;
    }

    protected boolean Qr() {
        return false;
    }

    protected static void aM(String str, String str2) {
        o.yx().n("AppBrandJsInput@" + str, true).G("passing_data", str2);
    }

    protected static h nG(String str) {
        WeakReference weakReference = (WeakReference) o.yx().fx("AppBrandJsInput@" + str).a("webview_reference", WeakReference.class);
        return weakReference == null ? null : (h) weakReference.get();
    }
}
