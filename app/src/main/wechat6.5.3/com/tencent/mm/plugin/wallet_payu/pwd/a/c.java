package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public String token = "";

    public c(String str) {
        Map hashMap = new HashMap();
        hashMap.put("pin", str);
        u(hashMap);
    }

    public final int bfC() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg.NetScenePayUCheckPwd", "errCode " + i + " errMsg: " + str);
        this.token = jSONObject.optString("payu_reference");
    }
}
