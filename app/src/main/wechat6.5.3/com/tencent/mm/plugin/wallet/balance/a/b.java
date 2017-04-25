package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends g {
    public int aYt = 0;
    public String bfr = null;
    public String brU;
    public String brV;
    public String brW;
    public String brX;
    public String brY;
    public double iro = 0.0d;
    public double irx = 0.0d;
    public boolean kFj = false;
    public String kFk = "";
    public com.tencent.mm.plugin.wallet_core.model.b kFl;
    public com.tencent.mm.plugin.wallet_core.model.b kFm;

    public b(double d, String str, String str2, int i) {
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("bank_type", str2);
        hashMap.put("operation", String.valueOf(i));
        u(hashMap);
    }

    public final int aed() {
        return 75;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.bfr = jSONObject.optString("req_key");
            this.kFj = "1".equals(jSONObject.optString("should_alert"));
            this.kFk = jSONObject.optString("alert_msg");
            this.iro = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
            this.irx = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
            JSONObject optJSONObject = jSONObject.optJSONObject("first_fetch_info");
            if (optJSONObject != null) {
                v.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
                this.kFl = w.a(optJSONObject, false);
            } else {
                v.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
            }
            optJSONObject = jSONObject.optJSONObject("need_charge_fee_info");
            if (optJSONObject != null) {
                v.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
                this.kFm = w.a(optJSONObject, false);
            } else {
                v.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
            }
            this.aYt = jSONObject.optInt("operation", 0);
            v.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.iro + " total_fee:" + this.irx + " operation:" + this.aYt);
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                v.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[]{optJSONObject.toString()});
                this.brU = optJSONObject.optString("guide_flag");
                this.brV = optJSONObject.optString("guide_wording");
                this.brW = optJSONObject.optString("left_button_wording");
                this.brX = optJSONObject.optString("right_button_wording");
                this.brY = optJSONObject.optString("upload_credit_url");
            }
        }
    }

    public final int zg() {
        return 1503;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
    }
}
