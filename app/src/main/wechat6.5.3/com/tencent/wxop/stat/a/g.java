package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.e;
import org.json.JSONObject;

public final class g extends b {
    private d pLf;
    private JSONObject pLg = null;

    public g(Context context, int i, JSONObject jSONObject, e eVar) {
        super(context, i, eVar);
        this.pLf = new d(context);
        this.pLg = jSONObject;
    }

    public final boolean L(JSONObject jSONObject) {
        if (this.pKQ != null) {
            jSONObject.put("ut", this.pKQ.e);
        }
        if (this.pLg != null) {
            jSONObject.put("cfg", this.pLg);
        }
        if (l.hm(this.pKS)) {
            jSONObject.put("ncts", 1);
        }
        this.pLf.a(jSONObject, null);
        return true;
    }

    public final c bQt() {
        return c.SESSION_ENV;
    }
}
