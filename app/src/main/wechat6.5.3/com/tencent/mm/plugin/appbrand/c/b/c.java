package com.tencent.mm.plugin.appbrand.c.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class c implements a {
    public final String getMethod() {
        return "bezierCurveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 6) {
            return false;
        }
        path.cubicTo(d.b(jSONArray, 0), d.b(jSONArray, 1), d.b(jSONArray, 2), d.b(jSONArray, 3), d.b(jSONArray, 4), d.b(jSONArray, 5));
        return true;
    }
}
