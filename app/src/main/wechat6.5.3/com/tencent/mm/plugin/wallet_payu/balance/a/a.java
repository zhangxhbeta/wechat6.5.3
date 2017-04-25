package com.tencent.mm.plugin.wallet_payu.balance.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.d.a.a {
    public String cpl;
    public String fTG;
    public double kOU;

    public a(double d, String str) {
        this.kOU = d;
        this.cpl = str;
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        u(hashMap);
    }

    public final int bfC() {
        return 20;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.fTG = jSONObject.optString("prepayid");
    }
}
