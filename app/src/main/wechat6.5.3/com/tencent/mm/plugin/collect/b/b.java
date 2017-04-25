package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends g {
    public String cpl;
    public String desc;
    public String eWy = null;
    public double eWz;

    public b(double d, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("desc", str2);
        this.eWz = d;
        this.cpl = str;
        this.desc = str2;
        u(hashMap);
    }

    public final int aed() {
        return 0;
    }

    public final int zg() {
        return 1623;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersetf2ffee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.eWy = jSONObject.optString("pay_url");
        }
    }
}
