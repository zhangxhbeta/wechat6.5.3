package com.tencent.mm.plugin.appbrand.c.b;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class i implements a {
    public final String getMethod() {
        return "rect";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float b = d.b(jSONArray, 0);
        float b2 = d.b(jSONArray, 1);
        Path path2 = path;
        path2.addRect(b, b2, b + d.b(jSONArray, 2), d.b(jSONArray, 3) + b2, Direction.CW);
        return true;
    }
}
