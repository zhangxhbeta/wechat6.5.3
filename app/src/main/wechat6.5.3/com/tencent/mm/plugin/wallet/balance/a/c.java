package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends g {
    public String bfr = null;
    public String brU;
    public String brV;
    public String brW;
    public String brX;
    public String brY;
    public boolean kFj = false;
    public String kFk = "";

    public c(double d, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("bank_type", str3);
        u(hashMap);
    }

    public final int aed() {
        return 74;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.bfr = jSONObject.optString("req_key");
            this.kFj = "1".equals(jSONObject.optString("should_alert"));
            this.kFk = jSONObject.optString("alert_msg");
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                v.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", new Object[]{optJSONObject.toString()});
                this.brU = optJSONObject.optString("guide_flag");
                this.brV = optJSONObject.optString("guide_wording");
                this.brW = optJSONObject.optString("left_button_wording");
                this.brX = optJSONObject.optString("right_button_wording");
                this.brY = optJSONObject.optString("upload_credit_url");
            }
        }
    }

    public final int zg() {
        return 1502;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genpresave";
    }
}
