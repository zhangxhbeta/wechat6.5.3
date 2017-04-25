package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import org.json.JSONArray;

public final class x implements d {
    public final String getMethod() {
        return "setMiterLimit";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        float optDouble = (float) jSONArray.optDouble(0);
        fVar.dCn.setStrokeMiter(optDouble);
        fVar.dCm.setStrokeMiter(optDouble);
        return true;
    }
}
