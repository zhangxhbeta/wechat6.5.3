package com.tencent.mm.plugin.wallet_core.a.a;

import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends g {
    public b(l lVar) {
        this(lVar, -1);
    }

    public b(l lVar, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", lVar.flag);
        hashMap.put("passwd", lVar.kQj);
        hashMap.put("verify_code", lVar.kQk);
        hashMap.put("token", lVar.token);
        hashMap.put("bind_flag", lVar.kQl ? "1" : "0");
        if (i > 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            v.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        }
        a(lVar.imN, hashMap, hashMap2);
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 17;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverifyreg";
    }

    public final int zg() {
        return 475;
    }
}
