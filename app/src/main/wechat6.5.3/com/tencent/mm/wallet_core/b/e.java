package com.tencent.mm.wallet_core.b;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends g {
    public String piv;

    public e(String str) {
        this.piv = str;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("crt_no", p.encode(str));
        hashMap.put("deviceid", com.tencent.mm.compatible.d.p.getDeviceID(aa.getContext()));
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 1568;
    }

    public final int zg() {
        return 1568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", new Object[]{Integer.valueOf(i), str});
    }
}
