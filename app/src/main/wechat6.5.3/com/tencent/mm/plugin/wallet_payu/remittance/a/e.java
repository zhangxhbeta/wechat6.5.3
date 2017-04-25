package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public String desc;
    public int eWB;
    public double eWz;
    public String iry;
    public String irz;
    public int scene;
    public String username;

    public e(String str) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", str);
        u(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.username = jSONObject.optString("user_name");
            this.iry = jSONObject.optString("true_name");
            this.eWz = jSONObject.optDouble("fee") / 100.0d;
            this.desc = jSONObject.optString("desc");
            this.scene = jSONObject.optInt("scene");
            this.irz = jSONObject.optString("transfer_qrcode_id");
            this.eWB = jSONObject.optInt("time_stamp");
        }
    }

    public final int bfC() {
        return 24;
    }
}
