package com.tencent.c.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class g {
    String aKA = null;
    String aOw = null;
    String aOx = "0";
    long aOy = 0;

    g() {
    }

    static g aL(String str) {
        g gVar = new g();
        if (s.aM(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    gVar.aKA = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    gVar.aOw = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    gVar.aOx = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    gVar.aOy = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
            }
        }
        return gVar;
    }

    final int a(g gVar) {
        if (gVar == null) {
            return 1;
        }
        if (s.aN(this.aOx) && s.aN(gVar.aOx)) {
            if (this.aOx.equals(gVar.aOx)) {
                return 0;
            }
            if (this.aOy < gVar.aOy) {
                return -1;
            }
            return 1;
        } else if (s.aN(this.aOx)) {
            return 1;
        } else {
            return -1;
        }
    }

    public final String toString() {
        return nP().toString();
    }

    private JSONObject nP() {
        JSONObject jSONObject = new JSONObject();
        try {
            s.b(jSONObject, "ui", this.aKA);
            s.b(jSONObject, "mc", this.aOw);
            s.b(jSONObject, "mid", this.aOx);
            jSONObject.put("ts", this.aOy);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
