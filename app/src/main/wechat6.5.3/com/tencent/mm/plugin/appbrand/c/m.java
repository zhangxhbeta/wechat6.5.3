package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class m implements d {
    public final String getMethod() {
        return "fillText";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 3) {
            return false;
        }
        canvas.drawText(jSONArray.optString(0), d.b(jSONArray, 1), d.b(jSONArray, 2), fVar.dCn);
        return true;
    }
}
