package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends g {
    private boolean boF = true;

    public c(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("code_ver", str);
        hashMap.put("cn", str2);
        v.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", new Object[]{str, str2});
        u(hashMap);
    }

    public final int aed() {
        return 1686;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
    }

    public final int zg() {
        return 1686;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            v.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
            com.tencent.mm.plugin.report.service.g.iuh.a(135, 22, 1, true);
            return;
        }
        v.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", new Object[]{Integer.valueOf(i), str});
        com.tencent.mm.plugin.report.service.g.iuh.a(135, 23, 1, true);
    }

    public final void a(com.tencent.mm.wallet_core.b.c cVar) {
        if (cVar.piu != 0 || cVar.errType == 0) {
            this.boF = true;
        } else {
            this.boF = false;
        }
        v.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", new Object[]{Boolean.valueOf(this.boF)});
    }

    public final boolean aEQ() {
        return this.boF;
    }
}
