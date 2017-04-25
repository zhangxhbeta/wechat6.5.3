package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends g {
    public String bhT = "";
    public String hKB = "0";
    private String hKC = "0";
    private boolean hKD = false;

    public f(Bankcard bankcard, String str, String str2, int i, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("oper", str2);
        if (str2.equals("changeto")) {
            if (TextUtils.isEmpty(str3)) {
                hashMap.put("verify_code", "");
            } else {
                hashMap.put("verify_code", str3);
            }
            hashMap.put("chg_fee", String.valueOf(i));
            hashMap.put("bind_serialno", bankcard.field_bindSerial);
            hashMap.put("bank_type", bankcard.field_bankcardType);
            hashMap.put("card_tail", bankcard.field_bankcardTail);
        }
        this.bhT = bankcard.field_mobile;
        u(hashMap);
    }

    public final int aed() {
        return 50;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hKB = jSONObject.optString("verify_flag");
            this.hKC = jSONObject.optString("limit_fee");
        }
    }
}
