package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o extends g {
    public String kLm;
    public String kLy;

    public o(l lVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("verify_code", lVar.kQk);
        hashMap.put("token", lVar.token);
        hashMap.put("passwd", lVar.kQj);
        hashMap.put("relation_key", str);
        u(hashMap);
    }

    public final int aed() {
        return 124;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null && i == 0) {
            this.kLm = jSONObject.optString("token_type");
            this.kLy = jSONObject.optString("usertoken");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
    }

    public final int zg() {
        return 1604;
    }
}
