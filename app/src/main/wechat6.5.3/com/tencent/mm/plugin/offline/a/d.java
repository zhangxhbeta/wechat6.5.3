package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends e {
    public d(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("buss_type", str);
        hashMap.put("method", str2);
        String str4 = "network";
        Object obj = ak.isWifi(aa.getContext()) ? "wifi" : ak.is3G(aa.getContext()) ? "3g" : ak.is2G(aa.getContext()) ? "2g" : ak.isWap(aa.getContext()) ? "wap" : ak.is4G(aa.getContext()) ? "4g" : "unknown";
        hashMap.put(str4, obj);
        hashMap.put("transactionid", str3);
        u(hashMap);
    }

    public final int aed() {
        return 122;
    }

    public final void a(int i, JSONObject jSONObject) {
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/datareport";
    }

    public final int zg() {
        return 1602;
    }
}
