package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class w implements d {
    public final String getMethod() {
        return "setLineWidth";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        float b = d.b(jSONArray, 0);
        fVar.dCn.setStrokeWidth(b);
        fVar.dCm.setStrokeWidth(b);
        return true;
    }
}
