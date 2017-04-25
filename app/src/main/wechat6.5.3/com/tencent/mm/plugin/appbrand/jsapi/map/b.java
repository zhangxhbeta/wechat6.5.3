package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends c {
    public static final int CTRL_INDEX = 135;
    public static final String NAME = "addMapCircles";

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiAddMapCircles", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final boolean a(h hVar, int i, View view, JSONObject jSONObject) {
        com.tencent.mm.model.o.b a = a(hVar, i, true);
        if (a == null) {
            v.i("MicroMsg.JsApiAddMapCircles", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(2131755380);
            try {
                if (jSONObject.has("circles")) {
                    List list;
                    int i2;
                    List list2 = (List) a.a("map_circle", List.class);
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        a.l("map_circle", arrayList);
                        list = arrayList;
                    } else {
                        list = list2;
                    }
                    if (list.size() > 0) {
                        for (i2 = 0; i2 < list.size(); i2++) {
                            ((Circle) list.get(i2)).remove();
                        }
                        list.clear();
                    }
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("circles"));
                    for (i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        float f = be.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        float f2 = be.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        int ac = d.ac(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                        int ac2 = d.ac(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                        int a2 = d.a(jSONObject2, "radius");
                        int a3 = d.a(jSONObject2, "strokeWidth");
                        CircleOptions circleOptions = new CircleOptions();
                        circleOptions.center(new LatLng((double) f, (double) f2));
                        circleOptions.radius((double) a2);
                        circleOptions.strokeColor(ac);
                        circleOptions.strokeWidth((float) a3);
                        circleOptions.fillColor(ac2);
                        list.add(soSoMapView.addCircle(circleOptions));
                    }
                }
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            v.e("MicroMsg.JsApiAddMapCircles", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }

    protected final boolean Qe() {
        return true;
    }
}
