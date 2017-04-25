package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends g {
    public String hck = "";
    public String irk = null;

    public c(String str, String str2, int i, String str3, String str4, int i2) {
        this.irk = str3;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str2);
        hashMap.put("transaction_id", str);
        hashMap.put("op", str3);
        hashMap.put("username", str4);
        hashMap.put("invalid_time", String.valueOf(i2));
        hashMap.put("total_fee", String.valueOf(i));
        v.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + str2 + ";transaction_id=" + str + ";total_fee=" + i);
        u(hashMap);
    }

    public final int aed() {
        return 0;
    }

    public final int zg() {
        return 1691;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferoperation";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                this.hck = optJSONObject.optString("guide_flag", "0");
            }
        }
    }
}
