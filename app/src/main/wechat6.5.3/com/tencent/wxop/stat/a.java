package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    long a = 0;
    int b = 0;
    String c = "";
    int d = 0;
    String e = "";

    public final JSONObject nT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.a);
            jSONObject.put("st", this.b);
            if (this.c != null) {
                jSONObject.put("dm", this.c);
            }
            jSONObject.put("pt", this.d);
            if (this.e != null) {
                jSONObject.put("rip", this.e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
