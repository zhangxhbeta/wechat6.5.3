package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends g {
    public f(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        u(hashMap);
    }

    public final int aed() {
        return 62;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
