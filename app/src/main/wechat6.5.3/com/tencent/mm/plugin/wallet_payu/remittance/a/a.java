package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.d.a.a {
    public String bob;
    public String cpl;
    public String fTG;
    public String kGk;
    public double kOU;
    public int kYi;
    public int laj;
    public double lak;
    public String lal;
    public String pin;

    public a(String str, String str2, double d, String str3, int i, String str4, String str5, String str6) {
        this.fTG = str;
        this.pin = str2;
        this.kOU = d;
        this.cpl = str3;
        this.laj = i == 2 ? 0 : i;
        this.bob = str4;
        this.kGk = str5;
        Map hashMap = new HashMap();
        hashMap.put("pin", str2);
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str3);
        hashMap.put("transfer_type", String.valueOf(i));
        hashMap.put("target_username", str4);
        hashMap.put("bind_serial", str5);
        hashMap.put("transfer_qrcode_id", str6);
        u(hashMap);
    }

    public final int bfC() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kYi = jSONObject.optInt("response_result");
        this.lak = be.getDouble(jSONObject.optString("total_fee"), 0.0d);
        this.lal = jSONObject.optString("fee_type");
    }
}
