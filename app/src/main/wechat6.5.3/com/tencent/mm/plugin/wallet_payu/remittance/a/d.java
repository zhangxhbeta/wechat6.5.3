package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public String bcB;
    public String cpl;
    public String ecR;
    public double kOU;
    public int lam;

    public d(double d, String str, String str2, int i) {
        this.kOU = d;
        this.cpl = str;
        this.bcB = str2;
        this.lam = i;
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("to_customer_name", str2);
        hashMap.put("transfer_type", String.valueOf(i));
        u(hashMap);
    }

    public final int bfC() {
        return 13;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.ecR = jSONObject.optString("PrepayId");
    }
}
