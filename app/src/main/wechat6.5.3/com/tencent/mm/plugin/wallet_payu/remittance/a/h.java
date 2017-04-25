package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends a {
    public h(String str, int i, String str2, String str3, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("total_fee", String.valueOf(i));
        hashMap.put("fee_type", str2);
        hashMap.put("receiver_name", str3);
        hashMap.put("invalid_time", String.valueOf(i2));
        u(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg.NetScenePayURemitttanceRetry", "errCode " + i + " errMsg: " + str);
    }

    public final int bfC() {
        return 26;
    }
}
