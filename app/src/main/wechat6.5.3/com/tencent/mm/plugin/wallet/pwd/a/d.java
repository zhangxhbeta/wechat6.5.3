package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends g {
    private Map<String, String> hdk = new HashMap();
    public String token = null;

    public d(Authen authen, boolean z) {
        this.hdk.put("flag", authen.bkU);
        if (!be.kS(authen.kNa)) {
            this.hdk.put("first_name", authen.kNa);
            this.hdk.put("last_name", authen.kNb);
            this.hdk.put("country", authen.cJg);
            this.hdk.put("area", authen.bCk);
            this.hdk.put("city", authen.bCl);
            this.hdk.put("address", authen.cJf);
            this.hdk.put("phone_number", authen.kNc);
            this.hdk.put("zip_code", authen.dxo);
            this.hdk.put("email", authen.bCc);
        }
        this.hdk.put("bank_type", authen.hMt);
        if (authen.kMU > 0) {
            this.hdk.put("cre_type", authen.kMU);
        }
        if (!be.kS(authen.kMS)) {
            this.hdk.put("true_name", authen.kMS);
        }
        if (!be.kS(authen.kMT)) {
            this.hdk.put("identify_card", authen.kMT);
        }
        this.hdk.put("mobile_no", authen.kLp);
        this.hdk.put("bank_card_id", authen.kMV);
        if (!be.kS(authen.kMW)) {
            this.hdk.put("cvv2", authen.kMW);
        }
        if (!be.kS(authen.kMX)) {
            this.hdk.put("valid_thru", authen.kMX);
        }
        this.hdk.put("new_card_reset_pwd", z ? "1" : "0");
        u(this.hdk);
    }

    public final boolean axX() {
        super.axX();
        this.hdk.put("is_repeat_send", "1");
        u(this.hdk);
        return true;
    }

    public final int aed() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.token = jSONObject.optString("token");
        }
    }

    public final String axY() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
    }

    public final int zg() {
        return 469;
    }
}
