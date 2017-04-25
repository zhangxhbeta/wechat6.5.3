package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class l implements d {
    public final String getMethod() {
        return "fillRect";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float b = d.b(jSONArray, 0);
        float b2 = d.b(jSONArray, 1);
        Canvas canvas2 = canvas;
        canvas2.drawRect(b, b2, b + d.b(jSONArray, 2), d.b(jSONArray, 3) + b2, fVar.dCn);
        return true;
    }
}
