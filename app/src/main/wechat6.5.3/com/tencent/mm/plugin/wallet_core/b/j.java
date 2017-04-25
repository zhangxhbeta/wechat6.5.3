package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends g {
    public String kLn;
    public int kLo;
    public String kLp;
    public String kLq;

    public j(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        u(hashMap);
        aa(new HashMap());
    }

    public j(String str, String str2, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("resend", "1");
        u(hashMap);
        aa(new HashMap());
    }

    public final int aed() {
        return 100;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + i + " errMsg: " + str);
        this.kLn = jSONObject.optString("usertoken");
        this.kLo = jSONObject.optInt("is_free_sms");
        this.kLp = jSONObject.optString("mobile_no");
        this.kLq = jSONObject.optString("relation_key");
    }

    public final boolean bfB() {
        return this.kLo == 0;
    }

    public final int zg() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
    }
}
