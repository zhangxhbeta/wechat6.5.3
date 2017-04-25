package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends c {
    public static final int CTRL_INDEX = 4;
    public static final String NAME = "updateMap";

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", new Object[]{e});
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
            v.i("MicroMsg.JsApiUpdateMap", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(2131755380);
            if (jSONObject.has("scale")) {
                soSoMapView.getIController().setZoom(jSONObject.optInt("scale", 16));
            }
            try {
                float optDouble;
                if (jSONObject.has("covers")) {
                    List list;
                    int i2;
                    List list2 = (List) a.a("converters", List.class);
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        a.l("converters", arrayList);
                        list = arrayList;
                    } else {
                        list = list2;
                    }
                    if (list.size() > 0) {
                        for (i2 = 0; i2 < list.size(); i2++) {
                            ((Marker) list.get(i2)).remove();
                        }
                        list.clear();
                    }
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("covers"));
                    for (i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        float f = be.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        float f2 = be.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        String optString = jSONObject2.optString("iconPath");
                        optDouble = (float) jSONObject2.optDouble("rotate", 0.0d);
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(new LatLng((double) f, (double) f2));
                        WebResourceResponse ar = com.tencent.mm.plugin.appbrand.appcache.b.ar(hVar.dzg, optString);
                        if (ar != null) {
                            markerOptions.icon(new BitmapDescriptor(BitmapFactory.decodeStream(ar.getData())));
                        }
                        markerOptions.rotation(optDouble);
                        Marker addMarker = soSoMapView.addMarker(markerOptions);
                        addMarker.setTag("cover");
                        list.add(addMarker);
                    }
                }
                if (jSONObject.has("centerLatitude")) {
                    if (jSONObject.has("centerLongitude")) {
                        optDouble = be.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
                        float f3 = be.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
                        if (Math.abs(optDouble) <= 90.0f && Math.abs(f3) <= 180.0f) {
                            soSoMapView.getIController().setCenter((double) optDouble, (double) f3);
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            v.e("MicroMsg.JsApiUpdateMap", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }

    protected final boolean Qe() {
        return true;
    }
}
