package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class i extends c {
    public static final int CTRL_INDEX = 141;
    public static final String NAME = "moveToMapLocation";

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiMoveToMapLocation", "get mapId error, exception : %s", new Object[]{e});
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
            v.i("MicroMsg.JsApiMoveToMapLocation", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(2131755380);
            AppbrandMapLocationPoint appbrandMapLocationPoint = (AppbrandMapLocationPoint) a.a(String.valueOf(i), AppbrandMapLocationPoint.class);
            if (appbrandMapLocationPoint != null) {
                soSoMapView.getIController().animateTo(appbrandMapLocationPoint.dKl, appbrandMapLocationPoint.dKm);
                return true;
            }
            v.e("MicroMsg.JsApiMoveToMapLocation", "appbrandMapLocationPoint is null");
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.JsApiMoveToMapLocation", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e});
            return false;
        }
    }

    protected final boolean Qe() {
        return true;
    }
}
