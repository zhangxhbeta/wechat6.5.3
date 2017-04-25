package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.c.a.a;
import org.json.JSONArray;

public final class n implements d {
    public final String getMethod() {
        return "restore";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.restore();
        if (!fVar.dCo.isEmpty()) {
            fVar.dCm = (a) fVar.dCo.pop();
            fVar.dCn = (a) fVar.dCp.pop();
        }
        return true;
    }
}
