package com.tencent.a.a.a.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    String a = null;
    String b = null;
    public String c = "0";
    long d = 0;

    static c aH(String str) {
        c cVar = new c();
        if (h.b(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    cVar.a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    cVar.b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    cVar.c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    cVar.d = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
            }
        }
        return cVar;
    }

    private JSONObject nJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            h.a(jSONObject, "ui", this.a);
            h.a(jSONObject, "mc", this.b);
            h.a(jSONObject, "mid", this.c);
            jSONObject.put("ts", this.d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String toString() {
        return nJ().toString();
    }
}
