package com.tencent.mm.plugin.appbrand.c.b;

import android.graphics.Path;
import org.json.JSONArray;

public final class e implements a {
    public final String getMethod() {
        return "closePath";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        path.close();
        return true;
    }
}
