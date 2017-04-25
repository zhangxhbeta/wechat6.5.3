package com.tencent.mm.plugin.wallet_core.b;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends com.tencent.mm.wallet_core.e.a.g {
    public g(String str) {
        Map hashMap = new HashMap();
        hashMap.put("wallet_tpa_country", str);
        u(hashMap);
    }

    public final int aed() {
        return 1663;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int zg() {
        return 1663;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
    }

    public final int getType() {
        return super.getType();
    }
}
