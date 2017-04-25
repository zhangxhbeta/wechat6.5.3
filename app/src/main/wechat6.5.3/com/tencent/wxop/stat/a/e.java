package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class e extends b {
    private static String a = null;
    private String m = null;
    public String n = null;

    public e(Context context, int i, com.tencent.wxop.stat.e eVar) {
        super(context, i, eVar);
        this.m = f.gQ(context).c;
        if (a == null) {
            a = l.gZ(context);
        }
    }

    public final boolean L(JSONObject jSONObject) {
        r.a(jSONObject, "op", a);
        r.a(jSONObject, "cn", this.m);
        jSONObject.put("sp", this.n);
        return true;
    }

    public final c bQt() {
        return c.NETWORK_MONITOR;
    }
}
