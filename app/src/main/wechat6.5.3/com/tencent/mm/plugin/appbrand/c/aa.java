package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import org.json.JSONArray;

public final class aa implements d {
    public final String getMethod() {
        return "setTextAlign";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("left".equalsIgnoreCase(optString)) {
            fVar.dCm.setTextAlign(Align.LEFT);
            fVar.dCn.setTextAlign(Align.LEFT);
        } else if ("right".equalsIgnoreCase(optString)) {
            fVar.dCm.setTextAlign(Align.RIGHT);
            fVar.dCn.setTextAlign(Align.RIGHT);
        } else if ("center".equalsIgnoreCase(optString)) {
            fVar.dCm.setTextAlign(Align.CENTER);
            fVar.dCn.setTextAlign(Align.CENTER);
        }
        return true;
    }
}
