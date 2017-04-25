package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends g {
    public e(l lVar) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("verify_code", lVar.kQk);
        hashMap.put("token", lVar.token);
        a(lVar.imN, hashMap, hashMap2);
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 11;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int zg() {
        return 470;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdverify";
    }
}
