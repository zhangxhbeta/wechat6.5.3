package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.tencentmap.mapsdk.map.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends c {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "addMapMarkers";

    private static class a extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 142;
        private static final String NAME = "onMapMarkerClick";

        private a() {
        }
    }

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiAddMapMarkers", "get mapId error, exception : %s", new Object[]{e});
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
            v.i("MicroMsg.JsApiAddMapMarkers", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(2131755380);
            try {
                if (jSONObject.has("markers")) {
                    List list;
                    int i2;
                    List list2 = (List) a.a("map_markers", List.class);
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        a.l("map_markers", arrayList);
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
                    final Map hashMap = new HashMap();
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("markers"));
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                        float f = be.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        float f2 = be.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        String optString = jSONObject2.optString("iconPath");
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(new LatLng((double) f, (double) f2));
                        int i4 = 0;
                        i2 = 0;
                        WebResourceResponse ar = com.tencent.mm.plugin.appbrand.appcache.b.ar(hVar.dzg, optString);
                        if (ar != null) {
                            Bitmap decodeStream = BitmapFactory.decodeStream(ar.getData());
                            markerOptions.icon(new BitmapDescriptor(decodeStream));
                            i2 = decodeStream.getHeight();
                            i4 = decodeStream.getWidth();
                        }
                        float optDouble = (float) jSONObject2.optDouble("alpha", 1.0d);
                        markerOptions.rotation((float) jSONObject2.optDouble("rotate", 0.0d));
                        markerOptions.alpha(optDouble);
                        optString = jSONObject2.optString("title");
                        if (!be.kS(optString)) {
                            markerOptions.title(optString);
                        }
                        if (jSONObject.has("anchor")) {
                            JSONObject jSONObject3 = new JSONObject(jSONObject.optString("anchor"));
                            markerOptions.anchor((float) jSONObject3.optDouble("anchoru"), (float) jSONObject3.optDouble("anchorv"));
                        }
                        Marker addMarker = soSoMapView.addMarker(markerOptions);
                        list.add(addMarker);
                        if (jSONObject2.has("width")) {
                            i4 = d.a(jSONObject2, "width");
                        }
                        if (jSONObject2.has("height")) {
                            i2 = d.a(jSONObject2, "height");
                        }
                        addMarker.getMarkerView().setMinimumHeight(i2);
                        addMarker.getMarkerView().setMinimumWidth(i4);
                        hashMap.put(addMarker.getId(), jSONObject2.optString("data"));
                    }
                    final int i5 = i;
                    final h hVar2 = hVar;
                    soSoMapView.getMap().b(new g.h(this) {
                        final /* synthetic */ e dKt;

                        public final boolean a(Marker marker) {
                            a aVar = new a();
                            String ma = be.ma((String) hashMap.get(marker.getId()));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("mapId", i5);
                                jSONObject.put("data", ma);
                            } catch (JSONException e) {
                                v.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", new Object[]{e});
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.e aa = aVar.aa(hVar2.dzg, hVar2.hashCode());
                            aa.mData = jSONObject.toString();
                            aa.PX();
                            if (be.kS(marker.getTitle()) && be.kS(marker.getSnippet())) {
                                return true;
                            }
                            if (marker.isInfoWindowShown()) {
                                marker.hideInfoWindow();
                            } else {
                                marker.showInfoWindow();
                            }
                            return false;
                        }
                    });
                }
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.JsApiAddMapMarkers", "parse markers error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            v.e("MicroMsg.JsApiAddMapMarkers", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }

    protected final boolean Qe() {
        return true;
    }
}
