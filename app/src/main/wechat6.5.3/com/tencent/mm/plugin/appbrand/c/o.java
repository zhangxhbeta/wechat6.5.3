package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import org.json.JSONArray;

public final class o implements d {
    public final String getMethod() {
        return "rotate";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        canvas.rotate((float) ((((double) ((float) jSONArray.optDouble(0))) / 3.141592653589793d) * 180.0d));
        return true;
    }
}
