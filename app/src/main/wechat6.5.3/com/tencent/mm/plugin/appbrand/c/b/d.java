package com.tencent.mm.plugin.appbrand.c.b;

import android.graphics.Path;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    private static d dCq;
    private Map<String, a> dCr = new HashMap();

    public static d Pu() {
        if (dCq == null) {
            synchronized (d.class) {
                if (dCq == null) {
                    dCq = new d();
                }
            }
        }
        return dCq;
    }

    public d() {
        a(new g());
        a(new e());
        a(new f());
        a(new h());
        a(new c());
        a(new b());
        a(new i());
    }

    public final Path d(JSONArray jSONArray) {
        Path path = new Path();
        if (jSONArray == null || jSONArray.length() == 0) {
            return path;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                a aVar = (a) this.dCr.get(optString);
                if (aVar != null) {
                    aVar.a(path, optJSONArray);
                }
            }
        }
        return path;
    }

    private void a(a aVar) {
        this.dCr.put(aVar.getMethod(), aVar);
    }
}
