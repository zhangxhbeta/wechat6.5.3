package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.e;
import org.json.JSONObject;

public final class d extends b {
    public static final e pKT;

    static {
        e eVar = new e();
        pKT = eVar;
        eVar.a = "A9VH9B8L4GX4";
    }

    public d(Context context) {
        super(context, 0, pKT);
    }

    public final boolean L(JSONObject jSONObject) {
        r.a(jSONObject, "actky", b.gD(this.pKS));
        return true;
    }

    public final c bQt() {
        return c.NETWORK_DETECTOR;
    }
}
