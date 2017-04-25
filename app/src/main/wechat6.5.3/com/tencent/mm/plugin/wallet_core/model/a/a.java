package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.c;
import org.json.JSONObject;

public final class a extends c {
    private static a kRz = null;

    public static a bgP() {
        if (kRz == null) {
            kRz = new a();
        }
        return kRz;
    }

    public final Bankcard y(JSONObject jSONObject) {
        Bankcard y = super.y(jSONObject);
        y.field_ext_msg = b.E(jSONObject);
        y.field_bankcardClientType = 1;
        y.field_desc = jSONObject.optString("description");
        y.field_trueName = jSONObject.optString("name_on_card");
        if ("CREDITCARD_PAYU".equals(jSONObject.optString("bank_type"))) {
            y.field_cardType |= Bankcard.kNm;
        } else {
            y.field_cardType |= Bankcard.kNo;
        }
        return y;
    }
}
