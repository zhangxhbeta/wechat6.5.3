package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends g {
    public String desc;
    public double eWz;
    public String irA = "";
    public String irB = "";
    public String iry;
    public String irz;
    public int scene;
    public String username;

    public e(String str) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", URLEncoder.encode(str));
        u(hashMap);
    }

    public final int aed() {
        return 0;
    }

    public final int zg() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferscanqrcode";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            v.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[]{jSONObject.toString()});
            this.username = jSONObject.optString("user_name");
            this.iry = jSONObject.optString("true_name");
            this.eWz = jSONObject.optDouble("fee") / 100.0d;
            this.desc = jSONObject.optString("desc");
            this.scene = jSONObject.optInt("scene");
            this.irz = URLEncoder.encode(jSONObject.optString("transfer_qrcode_id"));
            this.irA = jSONObject.optString("f2f_pay_desc");
            this.irB = jSONObject.optString("rcvr_desc");
        }
    }
}
