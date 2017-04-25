package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends g {
    public h(l lVar) {
        this(lVar, -1);
    }

    public h(l lVar, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(lVar.imN, hashMap, hashMap2);
        hashMap.put("flag", lVar.flag);
        if ("2".equals(lVar.flag)) {
            hashMap.put("passwd", lVar.kQj);
        }
        hashMap.put("verify_code", lVar.kQk);
        hashMap.put("token", lVar.token);
        if (!(lVar.imN == null || be.kS(lVar.imN.fTG))) {
            hashMap.put("req_key", lVar.imN.fTG);
        }
        if (i >= 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            v.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        }
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 13;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("test", "test");
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverify";
    }

    public final int zg() {
        return 472;
    }
}
