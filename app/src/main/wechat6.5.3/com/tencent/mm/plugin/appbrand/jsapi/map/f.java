package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends c {
    public static final int CTRL_INDEX = 144;
    public static final String NAME = "getMapCenterLocation";

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiGetMapCenterLocation", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        SoSoMapView soSoMapView;
        try {
            soSoMapView = (SoSoMapView) e.Qp().nF(e.a(hVar, Qd(), i)).findViewById(2131755380);
        } catch (Exception e) {
            v.e("MicroMsg.JsApiGetMapCenterLocation", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e});
            soSoMapView = null;
            z = false;
        }
        LatLng mapCenter = soSoMapView.getMap().getMapCenter();
        Map hashMap = new HashMap();
        hashMap.put("latitude", Double.valueOf(mapCenter.getLatitude()));
        hashMap.put("longitude", Double.valueOf(mapCenter.getLongitude()));
        if (z) {
            return c("ok", hashMap);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final boolean a(h hVar, int i, View view, JSONObject jSONObject) {
        return true;
    }

    protected final boolean Qe() {
        return true;
    }
}
