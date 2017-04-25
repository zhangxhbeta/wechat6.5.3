package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.Orders.b;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends g {
    public String eOP;
    public b kLj;
    public String kLk;
    public String kLl;

    public f(b bVar, String str, String str2) {
        this.kLj = bVar;
        Map hashMap = new HashMap();
        hashMap.put("activity_id", bVar.kPL);
        hashMap.put("award_id", bVar.kPN);
        hashMap.put("send_record_id", bVar.kPO);
        hashMap.put("user_record_id", bVar.kPP);
        hashMap.put("req_key", str);
        hashMap.put("transaction_id", str2);
        u(hashMap);
    }

    public final int aed() {
        return 1589;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null && i == 0) {
            this.kLk = jSONObject.optString("result_code");
            this.eOP = jSONObject.optString("result_msg");
            this.kLl = jSONObject.optString("alert_wording");
        }
    }

    public final int zg() {
        return 1589;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
    }
}
