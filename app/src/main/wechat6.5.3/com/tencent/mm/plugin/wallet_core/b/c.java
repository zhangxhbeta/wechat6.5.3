package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends g {
    public c() {
        k.bge().cie.dF("WalletBulletin", "delete from WalletBulletin");
        u(new HashMap());
    }

    public final int aed() {
        return 1679;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }

    public final int zg() {
        return 1679;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + i + " " + jSONObject);
        if (i == 0) {
            n.B(jSONObject);
            long optLong = jSONObject.optLong("banner_update_interval", 0);
            v.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=" + optLong);
            ak.yW();
            com.tencent.mm.model.c.vf().a(a.nrQ, Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("config_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    f bfO = f.bfO();
                    if (optJSONArray != null) {
                        v.d("MicroMsg.GpsReportHelper", optJSONArray.toString());
                        bfO.kOD = optJSONArray;
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(a.nsH, optJSONArray.toString());
                    }
                }
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.nsI, optJSONObject.optString("title"));
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.nsJ, optJSONObject.optString("content"));
            }
            optJSONObject = jSONObject.optJSONObject("realname_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("balance_title");
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.nsK, optString);
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.nsL, optString2);
            }
        }
    }
}
