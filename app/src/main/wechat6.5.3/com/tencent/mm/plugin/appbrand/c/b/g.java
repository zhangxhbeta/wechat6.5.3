package com.tencent.mm.plugin.appbrand.c.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class g implements a {
    public final String getMethod() {
        return "moveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        path.moveTo(d.b(jSONArray, 0), d.b(jSONArray, 1));
        return true;
    }
}
