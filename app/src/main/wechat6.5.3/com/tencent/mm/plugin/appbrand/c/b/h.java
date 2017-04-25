package com.tencent.mm.plugin.appbrand.c.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class h implements a {
    public final String getMethod() {
        return "quadraticCurveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        path.quadTo(d.b(jSONArray, 0), d.b(jSONArray, 1), d.b(jSONArray, 2), d.b(jSONArray, 3));
        return true;
    }
}
