package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends g {
    public String lvN;
    public boolean lvO = true;
    public String name;
    public String token;

    public b(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("bank_type", str2);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        u(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        aa(hashMap);
    }

    public final int aed() {
        return 63;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.token = jSONObject.optString("session_key");
            if ("1".equals(jSONObject.optString("all_info"))) {
                this.lvO = false;
                return;
            }
            this.lvO = true;
            this.name = jSONObject.optString("name");
            this.lvN = jSONObject.optString("cre_id");
        }
    }
}
