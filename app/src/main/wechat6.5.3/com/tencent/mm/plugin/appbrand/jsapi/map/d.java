package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends c {
    public static final int CTRL_INDEX = 134;
    public static final String NAME = "addMapLines";

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiAddMapLines", "get mapId error, exception : %s", new Object[]{e});
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
        b a = a(hVar, i, true);
        if (a == null) {
            v.i("MicroMsg.JsApiAddMapLines", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(2131755380);
            try {
                if (jSONObject.has("lines")) {
                    List list;
                    int i2;
                    List list2 = (List) a.a("map_line", List.class);
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        a.l("map_line", arrayList);
                        list = arrayList;
                    } else {
                        list = list2;
                    }
                    if (list.size() > 0) {
                        for (i2 = 0; i2 < list.size(); i2++) {
                            ((Polyline) list.get(i2)).remove();
                        }
                        list.clear();
                    }
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                    for (i2 = 0; i2 < jSONArray.length(); i2++) {
                        int i3;
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        Iterable arrayList2 = new ArrayList();
                        JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                        for (i3 = 0; i3 < jSONArray2.length(); i3++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                            arrayList2.add(new LatLng((double) be.getFloat(jSONObject3.optString("latitude"), 0.0f), (double) be.getFloat(jSONObject3.optString("longitude"), 0.0f)));
                        }
                        i3 = com.tencent.mm.plugin.appbrand.k.d.ac(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                        int a2 = com.tencent.mm.plugin.appbrand.k.d.a(jSONObject2, "width");
                        boolean optBoolean = jSONObject2.optBoolean("dottedLine");
                        PolylineOptions polylineOptions = new PolylineOptions();
                        polylineOptions.addAll(arrayList2);
                        polylineOptions.color(i3);
                        polylineOptions.width((float) a2);
                        polylineOptions.setDottedLine(optBoolean);
                        list.add(soSoMapView.addPolyline(polylineOptions));
                    }
                }
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            v.e("MicroMsg.JsApiAddMapLines", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }

    protected final boolean Qe() {
        return true;
    }
}
