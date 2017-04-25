package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import android.graphics.Paint.Join;
import org.json.JSONArray;

public final class v implements d {
    public final String getMethod() {
        return "setLineJoin";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("miter".equalsIgnoreCase(optString)) {
            fVar.dCn.setStrokeJoin(Join.MITER);
            fVar.dCm.setStrokeJoin(Join.MITER);
        } else if ("round".equalsIgnoreCase(optString)) {
            fVar.dCn.setStrokeJoin(Join.ROUND);
            fVar.dCm.setStrokeJoin(Join.ROUND);
        } else if ("bevel".equalsIgnoreCase(optString)) {
            fVar.dCn.setStrokeJoin(Join.BEVEL);
            fVar.dCm.setStrokeJoin(Join.BEVEL);
        }
        return true;
    }
}
