package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends g {
    public String bhT;
    public boolean brN = true;
    private Map<String, String> hdk = new HashMap();
    public boolean lvM = false;
    public String token;

    public a(String str, String str2, String str3, String str4) {
        this.hdk.put("session_key", str3);
        this.hdk.put("bank_type", str4);
        this.hdk.put("name", str);
        this.hdk.put("cre_id", str2);
        u(this.hdk);
    }

    public final boolean axX() {
        super.axX();
        this.hdk.put("retry", "1");
        u(this.hdk);
        return true;
    }

    public final int aed() {
        return 64;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.token = jSONObject.optString("session_key");
                this.brN = "1".equals(jSONObject.getString("need_bind"));
                this.lvM = "1".equals(jSONObject.getString("bank_user"));
                this.bhT = jSONObject.optString("mobile_no");
            } catch (Throwable e) {
                v.a("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
