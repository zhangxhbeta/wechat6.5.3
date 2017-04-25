package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class e implements d {
    public final String getMethod() {
        return "arc";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 5) {
            return false;
        }
        float b = d.b(jSONArray, 0);
        float b2 = d.b(jSONArray, 1);
        float b3 = d.b(jSONArray, 2);
        Canvas canvas2 = canvas;
        canvas2.drawArc(new RectF(b - b3, b2 - b3, b + b3, b3 + b2), (float) ((((double) ((float) jSONArray.optDouble(3))) / 3.141592653589793d) * 180.0d), (float) ((((double) ((float) jSONArray.optDouble(4))) / 3.141592653589793d) * 180.0d), true, fVar.dCm);
        return true;
    }
}
