package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String cpl;
    public String fTG;
    public String hOJ;
    public double kOU;
    public String kYe;
    public String kYf;
    public String kYg;
    public String kYh;
    public int kYi;
    public boolean kYj;
    public String kYk;
    public String kYl;
    public boolean kYm;
    public String kYn;
    public String pin;

    public b(String str, String str2, String str3, double d, String str4, String str5, String str6, String str7) {
        this.pin = str;
        this.kYe = str2;
        this.fTG = str3;
        this.kOU = d;
        this.cpl = str4;
        this.kYf = str5;
        this.kYg = str6;
        this.kYh = str7;
        Map hashMap = new HashMap();
        hashMap.put("pin", str);
        hashMap.put("bind_serial", str5);
        hashMap.put("req_key", str3);
        hashMap.put("fee_type", str4);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("bank_type", str6);
        hashMap.put("cvv", str2);
        hashMap.put("dest_bind_serial", str7);
        u(hashMap);
    }

    public final int bfC() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hOJ = jSONObject.optString("trans_id");
        this.kYi = jSONObject.optInt("response_result");
        this.kYj = jSONObject.optBoolean("redirect");
        this.kYk = jSONObject.optString("gateway_reference");
        this.kYl = jSONObject.optString("gateway_code");
        this.kYm = jSONObject.optBoolean("is_force_adjust");
        this.kYn = jSONObject.optString("force_adjust_code");
    }
}
