package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public b(String str, int i, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", String.valueOf(i));
        hashMap.put("fee_type", str2);
        hashMap.put("to_customer_name", str3);
        u(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
        }
    }

    public final int bfC() {
        return 16;
    }
}
