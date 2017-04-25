package com.tencent.mm.plugin.appbrand.c.b;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mm.plugin.appbrand.k.d;
import org.json.JSONArray;

public final class b implements a {
    public final String getMethod() {
        return "arc";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 5) {
            return false;
        }
        float b = d.b(jSONArray, 0);
        float b2 = d.b(jSONArray, 1);
        float b3 = d.b(jSONArray, 2);
        float f = b - b3;
        float f2 = b2 - b3;
        float f3 = b + b3;
        b2 += b3;
        float toDegrees = (float) Math.toDegrees((double) ((float) jSONArray.optDouble(3)));
        b = (float) Math.toDegrees((double) ((float) jSONArray.optDouble(4)));
        b3 = (float) (360.0d / (6.283185307179586d * ((double) b3)));
        float f4 = (b - toDegrees) % 360.0f;
        b = jSONArray.optBoolean(5) ? toDegrees - b : b - toDegrees;
        if (f4 > b3 || f4 < (-b3)) {
            path.arcTo(new RectF(f, f2, f3, b2), toDegrees, b, false);
        } else {
            path.addArc(new RectF(f, f2, f3, b2), toDegrees, b);
        }
        return true;
    }
}
