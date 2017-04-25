package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.d.a.a {
    public String ecR;
    public String kZj;
    public boolean kZk;
    public String kZl;

    public a(String str, String str2) {
        this.kZj = str;
        this.ecR = str2;
        Map hashMap = new HashMap();
        hashMap.put("otp", str);
        hashMap.put("payu_reference", str2);
        u(hashMap);
    }

    public final int bfC() {
        return 4;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.kZk = jSONObject.optBoolean("verified");
        this.kZl = jSONObject.optString("payu_reference");
    }
}
