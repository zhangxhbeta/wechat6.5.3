package com.tencent.mm.wallet_core.d.a;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.b.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b() {
        u(new HashMap());
    }

    public final int bfC() {
        return 28;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetScenePayUTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (!be.kS(optString)) {
            m.setTimeStamp(optString);
        }
    }
}
