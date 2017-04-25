package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.c.b.d;
import org.json.JSONArray;

public final class h implements d {
    public final String getMethod() {
        return "strokePath";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.drawPath(d.Pu().d(jSONArray), fVar.dCm);
        return true;
    }
}
