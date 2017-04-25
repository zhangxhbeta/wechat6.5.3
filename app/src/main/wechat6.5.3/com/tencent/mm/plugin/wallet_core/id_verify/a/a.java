package com.tencent.mm.plugin.wallet_core.id_verify.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends g {
    public a(int i) {
        Map hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        u(hashMap);
    }

    public final int aed() {
        return 1584;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneAgreeDisclaimer", "errCode = " + i + ";errMsg = " + str);
    }

    public final int zg() {
        return 1584;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamesetduty";
    }
}
