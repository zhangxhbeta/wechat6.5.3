package com.tencent.wxop.stat.b;

import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public String a = null;
    public String b = null;
    private String c = null;
    private String d = "0";
    public int e;
    private int f = 0;
    private long g = 0;

    public c(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.e = i;
    }

    private JSONObject bQz() {
        JSONObject jSONObject = new JSONObject();
        try {
            r.a(jSONObject, "ui", this.a);
            r.a(jSONObject, "mc", this.b);
            r.a(jSONObject, "mid", this.d);
            r.a(jSONObject, "aid", this.c);
            jSONObject.put("ts", this.g);
            jSONObject.put("ver", this.f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String toString() {
        return bQz().toString();
    }
}
