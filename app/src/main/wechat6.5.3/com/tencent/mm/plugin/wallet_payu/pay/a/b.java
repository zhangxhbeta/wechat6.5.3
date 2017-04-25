package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public int eWB;
    public String fTG;
    public String hOJ;
    public String kGk;
    public String kRM;
    public String kYe;
    public String kYk;
    public String kYl;
    public String kYn;
    public double kZE;
    public String kZF;
    public double kZG;
    public String kZH;
    public boolean kZI;
    public boolean kZJ;
    public String kZK;
    public String kZL;
    public String kZM;
    public String pin;

    public b(String str, double d, String str2, String str3, String str4, String str5, String str6) {
        this.fTG = str;
        this.kZE = d;
        this.kZF = str2;
        this.kRM = str3;
        this.kGk = str4;
        this.kYe = str5;
        this.pin = str6;
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str2);
        hashMap.put("bank_type", str3);
        hashMap.put("bind_serial", str4);
        if (!str3.equals("SVA_PAYU")) {
            hashMap.put("cvv", str5);
        }
        hashMap.put("pin", str6);
        u(hashMap);
    }

    public final int bfC() {
        return 9;
    }

    public final boolean iY() {
        return this.kZK.equals("1");
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hOJ = jSONObject.optString("trans_id");
            this.kZG = jSONObject.optDouble("total_fee") / 100.0d;
            this.kZH = jSONObject.optString("fee_type");
            this.kZI = jSONObject.optBoolean("redirect");
            this.kYk = jSONObject.optString("gateway_reference");
            this.kYl = jSONObject.optString("gateway_code");
            this.kZK = jSONObject.optString("pay_status");
            this.eWB = jSONObject.optInt("timestamp");
            this.kZL = jSONObject.optString("pay_status_name");
            this.kZM = jSONObject.optString("bank_type");
            this.kZJ = jSONObject.optBoolean("is_force_adjust");
            this.kYn = jSONObject.optString("force_adjust_code");
        }
    }
}
