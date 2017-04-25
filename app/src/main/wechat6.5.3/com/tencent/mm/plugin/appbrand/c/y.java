package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class y implements d {
    public final String getMethod() {
        return "setShadow";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        int a = d.a(jSONArray, 0);
        int a2 = d.a(jSONArray, 1);
        int a3 = d.a(jSONArray, 2);
        JSONArray optJSONArray = jSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            return false;
        }
        int h = d.h(optJSONArray);
        fVar.dCn.setShadowLayer((float) a3, (float) a, (float) a2, h);
        fVar.dCm.setShadowLayer((float) a3, (float) a, (float) a2, h);
        return true;
    }
}
