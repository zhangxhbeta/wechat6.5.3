package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends g {
    public m(String str) {
        Map hashMap = new HashMap();
        hashMap.put("device_id", p.rK());
        hashMap.put("passwd", str);
        u(hashMap);
    }

    public final int aed() {
        return 51;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
