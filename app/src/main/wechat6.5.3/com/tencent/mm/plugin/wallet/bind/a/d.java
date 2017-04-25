package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends g {
    public d(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        u(hashMap);
    }

    public d(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("expired_flag", "1");
        u(hashMap);
    }

    public final int aed() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int zg() {
        return 473;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbind";
    }
}
