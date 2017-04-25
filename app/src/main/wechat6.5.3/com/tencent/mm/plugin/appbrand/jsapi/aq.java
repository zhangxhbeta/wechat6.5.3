package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class aq extends a {
    public static final int CTRL_INDEX = 38;
    public static final String NAME = "openLocation";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        try {
            float f = be.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f2 = be.getFloat(jSONObject.optString("longitude"), 0.0f);
            String ou = a.ou(jSONObject.optString("name"));
            String ou2 = a.ou(jSONObject.optString("address"));
            try {
                i2 = be.getInt(jSONObject.optString("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 7);
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i2 > 0) {
                intent.putExtra("kwebmap_scale", i2);
            }
            intent.putExtra("kPoiName", ou);
            intent.putExtra("Kwebmap_locaion", ou2);
            MMActivity nt = d.nt(fVar.dzg);
            if (nt == null) {
                fVar.y(i, c("fail", null));
                return;
            }
            c.b(nt, "location", ".ui.RedirectUI", intent);
            fVar.y(i, c("ok", null));
        } catch (Exception e2) {
            fVar.y(i, c("invalid_coordinate", null));
        }
    }
}
