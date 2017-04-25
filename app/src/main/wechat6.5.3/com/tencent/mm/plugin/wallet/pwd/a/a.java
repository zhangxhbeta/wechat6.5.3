package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends g {
    public a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("new_passwd", str2);
        hashMap.put("new_rpasswd", str2);
        u(hashMap);
    }

    public final int aed() {
        return 9;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayChangePwd", "errCode " + i + " errMsg: " + str);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/changepwd";
    }

    public final int zg() {
        return 468;
    }
}
