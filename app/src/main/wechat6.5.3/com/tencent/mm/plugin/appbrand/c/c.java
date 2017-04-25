package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.c.b.d;
import org.json.JSONArray;

public final class c implements d {
    public final String getMethod() {
        return "clipPath";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.clipPath(d.Pu().d(jSONArray));
        return true;
    }
}
