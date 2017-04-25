package com.tencent.c.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class a {
    public static String aOc = "ts";
    public static String aOd = "times";
    public static String aOe = "mfreq";
    public static String aOf = "mdays";
    long aNY = 0;
    int aNZ = 0;
    int aOa = 100;
    int aOb = 3;

    a() {
    }

    a(String str) {
        if (s.aM(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(aOc)) {
                    this.aNY = jSONObject.getLong(aOc);
                }
                if (!jSONObject.isNull(aOe)) {
                    this.aOa = jSONObject.getInt(aOe);
                }
                if (!jSONObject.isNull(aOd)) {
                    this.aNZ = jSONObject.getInt(aOd);
                }
                if (!jSONObject.isNull(aOf)) {
                    this.aOb = jSONObject.getInt(aOf);
                }
            } catch (JSONException e) {
            }
        }
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(aOc, this.aNY);
            jSONObject.put(aOd, this.aNZ);
            jSONObject.put(aOe, this.aOa);
            jSONObject.put(aOf, this.aOb);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
