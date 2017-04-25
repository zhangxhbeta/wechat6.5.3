package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class ab implements d {
    public final String getMethod() {
        return "translate";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        canvas.translate(d.b(jSONArray, 0), d.b(jSONArray, 1));
        return true;
    }
}
