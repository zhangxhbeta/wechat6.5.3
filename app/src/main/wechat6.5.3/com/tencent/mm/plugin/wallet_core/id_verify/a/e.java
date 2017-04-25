package com.tencent.mm.plugin.wallet_core.id_verify.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends g {
    public String kMs = null;
    public String kMt = null;
    public String kMu = null;
    public String kMv = null;
    public int kMw = 0;
    public long kMx = 0;
    public String title = null;

    public e(int i, int i2) {
        this.kMw = i2;
        Map hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        u(hashMap);
    }

    public final int aed() {
        return 1614;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + i + ";errMsg=" + str);
        if (i == 0 && jSONObject != null) {
            this.kMs = jSONObject.optString("agreed_flag", "0");
            this.title = jSONObject.optString("title", "");
            this.kMt = jSONObject.optString("service_protocol_wording", "");
            this.kMu = jSONObject.optString("service_protocol_url", "");
            this.kMv = jSONObject.optString("button_wording", "");
            this.kMx = jSONObject.optLong("delay_expired_time", 0);
            if (this.kMx > 0) {
                ak.yW();
                c.vf().a(a.nsD, Long.valueOf(System.currentTimeMillis() + (this.kMx * 1000)));
            }
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
    }

    public final int zg() {
        return 1614;
    }
}
