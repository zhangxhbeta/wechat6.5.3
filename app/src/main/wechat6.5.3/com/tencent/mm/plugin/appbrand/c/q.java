package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import org.json.JSONArray;

public final class q implements d {
    public final String getMethod() {
        return "scale";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        canvas.scale((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1));
        return true;
    }
}
