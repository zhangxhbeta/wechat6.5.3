package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class s implements d {
    public final String getMethod() {
        return "setFontSize";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        int a = d.a(jSONArray, 0);
        fVar.dCn.setTextSize((float) a);
        fVar.dCm.setTextSize((float) a);
        return true;
    }
}
