package com.tencent.mm.plugin.appbrand.k;

import android.graphics.Color;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.aa;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static DisplayMetrics dSM = aa.getContext().getResources().getDisplayMetrics();

    public static int h(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 3) {
            return 0;
        }
        if (jSONArray.length() == 3) {
            return Color.rgb(jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
        }
        return Color.argb(jSONArray.optInt(3) & 255, jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
    }

    public static int ac(String str, int i) {
        try {
            if (str.charAt(0) != '#') {
                return Color.parseColor(str);
            }
            long parseLong;
            if (str.length() == 7) {
                parseLong = Long.parseLong(str.substring(1), 16) | -16777216;
            } else if (str.length() != 9) {
                throw new IllegalArgumentException("Unknown color");
            } else {
                parseLong = Long.parseLong(str.substring(1, 7), 16) | (Long.parseLong(str.substring(7, 9), 16) << 24);
            }
            return (int) parseLong;
        } catch (Exception e) {
            return i;
        }
    }

    public static int hs(int i) {
        return dSM == null ? i : (int) (((float) i) / dSM.density);
    }

    public static float J(float f) {
        return dSM == null ? f : f / dSM.density;
    }

    public static int ht(int i) {
        return dSM == null ? i : (int) (dSM.density * ((float) i));
    }

    public static int a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0;
        }
        return ht(jSONObject.optInt(str, 0));
    }

    public static int a(JSONArray jSONArray, int i) {
        return jSONArray == null ? 0 : ht(jSONArray.optInt(i, 0));
    }

    public static float b(JSONArray jSONArray, int i) {
        return a(jSONArray, i, 0.0f);
    }

    public static float a(JSONArray jSONArray, int i, float f) {
        if (jSONArray == null) {
            return f;
        }
        f = (float) jSONArray.optDouble(i, (double) f);
        return dSM != null ? f * dSM.density : f;
    }
}
