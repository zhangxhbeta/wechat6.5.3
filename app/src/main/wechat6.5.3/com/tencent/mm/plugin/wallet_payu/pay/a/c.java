package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public Orders ith;
    private String kIr;

    public c(String str) {
        this(str, 0);
    }

    public c(String str, int i) {
        this.ith = null;
        this.kIr = null;
        this.kIr = str;
        Map hashMap = new HashMap();
        hashMap.put("req_key", this.kIr);
        hashMap.put("query_scene", String.valueOf(i));
        u(hashMap);
    }

    public final int bfC() {
        return 8;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.ith = Orders.z(jSONObject);
        if (this.ith != null) {
            this.ith.fTG = this.kIr;
        }
    }
}
