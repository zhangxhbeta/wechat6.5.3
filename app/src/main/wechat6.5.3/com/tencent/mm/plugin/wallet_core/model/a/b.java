package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class b {
    public Bankcard kRA;
    public String kRB;
    public boolean kRC;
    public String kRD;
    public boolean kRE;
    public int kRF;

    public static String E(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cvv_length", jSONObject.optInt("cvv_length"));
            jSONObject2.put("information", jSONObject.optString("information"));
            jSONObject2.put("verified", jSONObject.optBoolean("verified"));
            jSONObject2.put("card_expiry", jSONObject.optString("card_expiry"));
            jSONObject2.put("is_credit", jSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
        } catch (Throwable e) {
            v.a("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
        }
        return jSONObject2.toString();
    }

    public b(Bankcard bankcard) {
        this.kRA = bankcard;
        try {
            JSONObject jSONObject = new JSONObject(this.kRA.field_ext_msg);
            this.kRB = jSONObject.optString("information");
            this.kRC = jSONObject.optBoolean("verified");
            this.kRD = jSONObject.optString("card_expiry");
            this.kRF = jSONObject.optInt("cvv_length");
            this.kRE = jSONObject.optBoolean("is_credit");
        } catch (Throwable e) {
            v.a("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
        }
    }
}
