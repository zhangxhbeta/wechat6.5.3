package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.e;
import org.json.JSONObject;

public final class f extends b {
    String m;
    String n;
    Long pLe = null;

    public f(Context context, String str, String str2, int i, Long l, e eVar) {
        super(context, i, eVar);
        this.n = str;
        this.m = str2;
        this.pLe = l;
    }

    public final boolean L(JSONObject jSONObject) {
        r.a(jSONObject, "pi", this.m);
        r.a(jSONObject, "rf", this.n);
        if (this.pLe != null) {
            jSONObject.put("du", this.pLe);
        }
        return true;
    }

    public final c bQt() {
        return c.PAGE_VIEW;
    }
}
