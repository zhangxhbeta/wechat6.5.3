package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends com.tencent.mm.wallet_core.e.a.g {
    public String bkp = null;

    public g(String str, String str2, String str3, String str4, String str5) {
        Map hashMap = new HashMap();
        hashMap.put("verify_code", str);
        hashMap.put("session_key", str2);
        hashMap.put("passwd", str3);
        hashMap.put("bind_serialno", str4);
        hashMap.put("bank_type", str5);
        u(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str5);
        aa(hashMap);
    }

    public final int aed() {
        return 65;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.bkp = jSONObject.optString("app_username");
        }
    }
}
