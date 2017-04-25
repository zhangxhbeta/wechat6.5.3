package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tencentmap.mapsdk.map.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends c {
    public static final int CTRL_INDEX = 136;
    public static final String NAME = "includeMapPoints";

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiIncludeMapPoints", "get mapId error, exception : %s", new Object[]{e});
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
        if (a(hVar, i, true) == null) {
            v.i("MicroMsg.JsApiIncludeMapPoints", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(2131755380);
            try {
                if (jSONObject.has("points")) {
                    Iterable arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("points"));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        arrayList.add(new LatLng((double) be.getFloat(jSONObject2.optString("latitude"), 0.0f), (double) be.getFloat(jSONObject2.optString("longitude"), 0.0f)));
                    }
                    if (arrayList.size() > 0) {
                        Builder builder = new Builder();
                        builder.include(arrayList);
                        soSoMapView.getMap().a(b.b(builder.build()), 1000);
                    }
                }
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            v.e("MicroMsg.JsApiIncludeMapPoints", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }

    protected final boolean Qe() {
        return true;
    }
}
