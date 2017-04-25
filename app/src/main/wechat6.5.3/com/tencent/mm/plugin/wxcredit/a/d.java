package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends g {
    public k lvQ;

    public d(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        hashMap.put("bank_type", str2);
        hashMap.put("query_method", "1");
        u(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str2);
        aa(hashMap);
    }

    public final int aed() {
        return 57;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        v.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.lvQ = new k();
                this.lvQ.lvU = jSONObject.optInt("credit_state");
                this.lvQ.lvP = ((double) jSONObject.optInt("credit_amount")) / 100.0d;
                this.lvQ.lvV = ((double) jSONObject.optInt("credit_usable")) / 100.0d;
                this.lvQ.lvW = ((double) jSONObject.optInt("bill_amount")) / 100.0d;
                this.lvQ.lvX = jSONObject.optInt("bill_date");
                this.lvQ.lvY = ((double) jSONObject.optInt("repay_amount")) / 100.0d;
                this.lvQ.lvZ = ((double) jSONObject.optInt("repay_minimum")) / 100.0d;
                k kVar = this.lvQ;
                if (jSONObject.optInt("upgrade_amount") != 1) {
                    z = false;
                }
                kVar.lwa = z;
                this.lvQ.lwb = jSONObject.optInt("bill_month");
                this.lvQ.lwc = jSONObject.optString("repay_url");
                this.lvQ.lwd = jSONObject.optString("repay_lasttime");
                this.lvQ.lwh = jSONObject.optString("lasttime");
                JSONArray jSONArray = jSONObject.getJSONArray("jump_url_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String string = jSONObject2.getString("jump_name");
                        if ("account_rights_url".equals(string)) {
                            this.lvQ.lwf = jSONObject2.getString("jump_url");
                        } else if ("bill_url".equals(string)) {
                            this.lvQ.lwg = jSONObject2.getString("jump_url");
                        } else if ("card_detail_url".equals(string)) {
                            this.lvQ.lwe = jSONObject2.getString("jump_url");
                        } else if ("know_more_url".equals(string)) {
                            this.lvQ.lwi = jSONObject2.getString("jump_url");
                        }
                    }
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("appservice");
                if (jSONObject3 != null) {
                    this.lvQ.lwj = new j();
                    this.lvQ.lwj.lvT = jSONObject3.getString("app_telephone");
                    this.lvQ.lwj.cID = jSONObject3.getString("nickname");
                    this.lvQ.lwj.username = jSONObject3.getString("username");
                    this.lvQ.lwj.url = jSONObject3.getString("jump_url");
                }
            } catch (Throwable e) {
                v.a("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
