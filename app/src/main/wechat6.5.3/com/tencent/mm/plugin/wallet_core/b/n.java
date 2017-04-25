package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends g {
    public String kLw = "";
    public JSONObject kLx;

    public n(String str, String str2, String str3, String str4, String str5, String str6) {
        this.kLw = str;
        Map hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("req_key", str5);
        hashMap.put("transaction_id", str6);
        u(hashMap);
    }

    public final int aed() {
        return 1979;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/querypayaward";
    }

    public final int zg() {
        return 1979;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneTenpayQueryPayaward", "errcode %s errmsg %s json %s", new Object[]{Integer.valueOf(i), str, jSONObject});
        this.kLx = jSONObject;
    }

    public final boolean aEQ() {
        return false;
    }
}
