package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;
import org.json.JSONObject;

public final class j extends b {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiRemoveMap", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean a(h hVar, int i, View view) {
        o.b a = a(hVar, i);
        if (a == null) {
            v.i("MicroMsg.JsApiRemoveMap", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            final SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(2131755380);
            List list = (List) a.a("markers", List.class);
            List list2 = (List) a.a("converters", List.class);
            if (list != null && list.size() > 0) {
                list.clear();
            }
            if (list2 != null && list2.size() > 0) {
                list2.clear();
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ j dKE;

                public final void run() {
                    if (soSoMapView != null) {
                        soSoMapView.setVisibility(8);
                        soSoMapView.clean();
                    }
                }
            });
            a.recycle();
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.JsApiRemoveMap", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e});
            return false;
        }
    }
}
