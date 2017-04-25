package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends g {
    public int kGi;
    public String kGj;

    public a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bankcard_type", str);
        hashMap.put("bind_serial", str2);
        u(hashMap);
    }

    public final int aed() {
        return 1540;
    }

    public final int zg() {
        return 1540;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbindbanner";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i != 0) {
            return;
        }
        if (jSONObject != null) {
            this.kGi = jSONObject.optInt("unbindbannerlevel", 0);
            this.kGj = jSONObject.optString("unbindbannerwording");
            return;
        }
        v.e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
    }
}
