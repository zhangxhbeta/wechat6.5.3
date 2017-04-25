package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import org.json.JSONArray;

public final class u implements d {
    public final String getMethod() {
        return "setLineCap";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("butt".equalsIgnoreCase(optString)) {
            fVar.dCn.setStrokeCap(Cap.BUTT);
            fVar.dCm.setStrokeCap(Cap.BUTT);
        } else if ("round".equalsIgnoreCase(optString)) {
            fVar.dCn.setStrokeCap(Cap.ROUND);
            fVar.dCm.setStrokeCap(Cap.ROUND);
        } else if ("square".equalsIgnoreCase(optString)) {
            fVar.dCn.setStrokeCap(Cap.SQUARE);
            fVar.dCm.setStrokeCap(Cap.SQUARE);
        }
        return true;
    }
}
