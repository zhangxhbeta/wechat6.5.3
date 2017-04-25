package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String ecR;
    public String kYN;
    public String kYO;
    public boolean kZm;

    public b(String str, String str2) {
        this.kYN = str;
        this.kYO = str2;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        u(hashMap);
    }

    public final int bfC() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.kZm = jSONObject.optBoolean("has_mobile");
        this.ecR = jSONObject.optString("payu_reference");
    }
}
