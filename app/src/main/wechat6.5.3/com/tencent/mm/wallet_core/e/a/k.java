package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.b.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class k extends g {
    public k() {
        u(new HashMap());
    }

    public final int aed() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (be.kS(optString)) {
            v.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
            m.setTimeStamp((System.currentTimeMillis() / 1000));
            return;
        }
        m.setTimeStamp(optString);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/timeseed";
    }

    public final int zg() {
        return 477;
    }
}
