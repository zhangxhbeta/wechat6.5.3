package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONArray;

public final class r implements d {
    public final String getMethod() {
        return "setFillStyle";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        String optString = jSONArray.optString(0);
        JSONArray optJSONArray;
        int a;
        int a2;
        int a3;
        JSONArray optJSONArray2;
        int i;
        if ("linear".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                return false;
            }
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                return false;
            }
            a = d.a(optJSONArray, 0);
            a2 = d.a(optJSONArray, 1);
            a3 = d.a(optJSONArray, 2);
            int a4 = d.a(optJSONArray, 3);
            optJSONArray2 = jSONArray.optJSONArray(2);
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                return false;
            }
            int[] iArr = new int[optJSONArray2.length()];
            float[] fArr = new float[optJSONArray2.length()];
            for (i = 0; i < optJSONArray2.length(); i++) {
                JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i);
                if (optJSONArray3.length() >= 2) {
                    fArr[i] = (float) optJSONArray3.optDouble(0);
                    iArr[i] = d.h(optJSONArray3.optJSONArray(1));
                }
            }
            fVar.dCn.setShader(new LinearGradient((float) a, (float) a2, (float) a3, (float) a4, iArr, fArr, TileMode.CLAMP));
        } else if ("radial".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                return false;
            }
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 3) {
                return false;
            }
            a = d.a(optJSONArray, 0);
            a2 = d.a(optJSONArray, 1);
            a3 = d.a(optJSONArray, 2);
            if (a3 <= 0) {
                v.i("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle(radial) failed, sr(%s) <= 0.", new Object[]{Integer.valueOf(a3)});
                return false;
            }
            JSONArray optJSONArray4 = jSONArray.optJSONArray(2);
            int[] iArr2 = new int[optJSONArray4.length()];
            float[] fArr2 = new float[optJSONArray4.length()];
            for (i = 0; i < optJSONArray4.length(); i++) {
                optJSONArray2 = optJSONArray4.optJSONArray(i);
                if (optJSONArray2.length() >= 2) {
                    fArr2[i] = (float) optJSONArray2.optDouble(0);
                    iArr2[i] = d.h(optJSONArray2.optJSONArray(1));
                }
            }
            fVar.dCn.setShader(new RadialGradient((float) a, (float) a2, (float) a3, iArr2, fArr2, TileMode.CLAMP));
        } else if ("normal".equalsIgnoreCase(optString)) {
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                return false;
            }
            fVar.dCn.setColor(d.h(optJSONArray));
        }
        return true;
    }
}
