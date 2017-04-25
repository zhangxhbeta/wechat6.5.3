package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public String ecR;
    public String laf;
    public String lag;

    public d(String str, String str2) {
        this.laf = str;
        this.lag = str2;
        Map hashMap = new HashMap();
        hashMap.put("payu_reference", str);
        hashMap.put("new_pin", str2);
        u(hashMap);
    }

    public final int bfC() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.ecR = jSONObject.optString("payu_reference");
    }
}
